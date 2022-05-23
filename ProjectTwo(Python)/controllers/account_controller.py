from flask import request, jsonify
from exceptions.resource_not_found import ResourceNotFound
from models.accounts import Accounts
from repositories.account_repo_impl import  import AcctRepoImpl
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

    @app.route("/account/<user_id>", methods=['GET'])
    def get_account(user_id):
        try:
            return acc.get_account(user_id).json(), 200
        except ValueError as e:
            return "Not an existing account", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/accounts/<user_id>", methods=['GET'])
    def get_all_accounts():
        try:
            return jsonify([account.json() for account in acc.get_all_accounts()]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/account/<user_id>", methods=['PUT'])
    def put_account(user_id):
        body = request.json
        account = Accounts(user_id=user_id, account_type=body["accountType"], account_balance=body["accountBalance"])
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