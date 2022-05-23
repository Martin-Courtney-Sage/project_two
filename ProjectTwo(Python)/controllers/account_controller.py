from flask import request, jsonify
from exceptions.resource_not_found import ResourceNotFound
from models.accounts import Accounts
from repositories.account_repo_impl import AcctRepoImpl
from services.account_services import AccountService

ar = AcctRepoImpl()
acc = AccountService(ar)


def route(app):

    @app.route("/account", methods=['POST'])
    def post_account():
        body = request.json
        account = Accounts(user_id=body["userID"], account_type=body["accountType"], account_balance=body["accountBalance"])
        account = acc.create_account(account)
        return account.json(), 201

    @app.route("/account/<acct_id>", methods=['GET'])
    def get_account(acct_id):
        try:
            return acc.get_account(acct_id).json(), 200
        except ValueError as e:
            return "Not an existing account", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/accounts/<user_id>", methods=['GET'])
    def get_all_accounts(user_id):
        try:
            return jsonify([account.json() for account in acc.get_all_accounts(user_id)]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/account/<acct_id>", methods=['PUT'])
    def put_account(acct_id):
        body = request.json
        account = Accounts(acct_id=acct_id, account_type=body["accountType"], account_balance=body["accountBalance"])
        account = acc.update_account(account)
        try:
            return account.json(), 201
        except ValueError as e:
            return "Not an existing Account to update", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/user/<acct_id>", methods=['DELETE'])
    def del_account(acct_id):
        acc.del_account(acct_id)
        return f"{acct_id} has been deleted", 204

    @app.route("/account/<acct_id>/withdraw/<funds>", methods=['PATCH'])  # withdraw funds
    def withdraw_funds(acct_id, funds):
        body = request.json
        try:
            if "withdraw" in body:  # type "withdraw" in the body section of the JSON
                remaining_balance = acc.withdraw_funds(acct_id, funds)
                account = Accounts(acct_id=acct_id, account_type=body["accountType"], account_balance=remaining_balance)
                acc.update_account(account)
                return f"The new balance of Account ID: {acct_id} is {remaining_balance}", 200
            else:
                return "Insufficient Funds", 422
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/account/<acct_id>/deposit/<funds>", methods=['PATCH'])  # deposit funds
    def deposit_funds(acct_id, funds):
        body = request.json
        try:
            if "deposit" in body:  # type "deposit" in the body section of the JSON
                remaining_balance = acc.deposit_funds(acct_id, funds)
                account = Accounts(acct_id=acct_id, account_type=body["accountType"], account_balance=remaining_balance)
                acc.update_account(account)
                return f"The new balance of Account ID: {acct_id} is {remaining_balance}", 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/account/<acct_id_from>/transfer/<acct_id_too>/<funds>", methods=['PATCH'])
    def transfer_funds(acct_id_from, acct_id_too, funds):
        body = request.json
        try:
            if "transfer" in body:  # type "transfer" in the body section of the JSON
                remaining_balance1 = acc.withdraw_funds(acct_id_from, funds)
                account = Accounts(acct_id=acct_id_from, account_type=body["accountTypeFrom"],
                                   account_balance=remaining_balance1)
                acc.update_account(account)
                remaining_balance2 = acc.deposit_funds(acct_id_too, funds)
                account = Accounts(acct_id=acct_id_too, account_type=body["accountTypeToo"],
                                   account_balance=remaining_balance2)
                acc.update_account(account)
                return f"Funds have been transferred. Account ID: {acct_id_from}={remaining_balance1}." \
                       f"Account ID: {acct_id_too}={remaining_balance2}."
            else:
                return "Insufficient Funds", 422
        except ResourceNotFound as r:
            return r.message, 404
