from flask import request, jsonify
from exceptions.resource_not_found import ResourceNotFound
from models.request_credit import RequestCredit
from models.request_job import RequestJob
from models.request_loan import RequestLoan
from repositories.req_credit_repo_impl import ReqCreditRepoImpl
from repositories.req_job_repo_impl import ReqJobRepoImpl
from repositories.req_loan_repo_impl import ReqLoanRepoImpl
from services.request_credit_service import ReqCreditService
from services.request_job_service import ReqJobService
from services.request_loan_service import ReqLoanService

rc = ReqCreditRepoImpl()
rl = ReqLoanRepoImpl()
rj = ReqJobRepoImpl()
rs = ReqCreditService(rc)
ls = ReqLoanService(rl)
js = ReqJobService(rj)


def route(app):

    @app.route("/request/credit", methods=['POST'])
    def put_request_credit():
        body = request.json
        credit = RequestCredit(user_id=body["userId"], card_type=body["cardType"], credit_limit=body["creditLimit"],
                               req_status=body["reqStatus"])
        credit = rs.create_request_credit(credit)
        return credit.json(), 201

    @app.route("/request/job", methods=['POST'])
    def put_request_job():
        body = request.json
        job = RequestJob(user_id=body["userId"], position_app=body["positionApp"], job_status=body["jobStatus"])
        job = js.create_request_job(job)
        return job.json(), 201

    @app.route("/request/loan", methods=['POST'])
    def put_request_loan():
        body = request.json
        loan = RequestLoan(user_id=body["userId"], acct_id=body["acctId"], loan_amount=body["loanAmount"],
                           loan_term=body["loanTerm"], loan_type=body["loanType"], loan_status=body["loanStatus"])
        loan = ls.create_request_loan(loan)
        return loan.json(), 201

    @app.route("/request/credit/<req_id>", methods=['GET'])
    def get_credit(req_id):
        try:
            return rs.get_request_credit(req_id).json(), 200
        except ValueError as e:
            return "Not an existing Request ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/job/<req_id>", methods=['GET'])
    def get_job(req_id):
        try:
            return js.get_request_job(req_id).json(), 200
        except ValueError as e:
            return "Not an existing Request ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/loan/<req_id>", methods=['GET'])
    def get_loan(req_id):
        try:
            return ls.get_request_loan(req_id).json(), 200
        except ValueError as e:
            return "Not an existing Request ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/requests/credit/<user_id>", methods=['GET'])
    def get_all_credits(user_id):
        try:
            return jsonify([credit.json() for credit in rs.get_all_request_credit(user_id)]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/requests/job/<user_id>", methods=['GET'])
    def get_all_jobs(user_id):
        try:
            return jsonify([job.json() for job in js.get_all_request_job(user_id)]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/requests/loan/<user_id>", methods=['GET'])
    def get_all_loans(user_id):
        try:
            return jsonify([loan.json() for loan in ls.get_all_request_loan(user_id)]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/credit/<user_id>", methods=['PUT'])
    def update_credit(user_id):
        body = request.json
        credit = RequestCredit(user_id=user_id, card_type=body["cardType"], credit_limit=body["creditLimit"],
                               req_status=body["reqStatus"])
        credit = rs.update_request_credit(credit)
        try:
            return credit.json(), 201
        except ValueError as e:
            return "Not an existing Credit Request", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/job/<user_id>", methods=['PUT'])
    def update_job(user_id):
        body = request.json
        job = RequestJob(user_id=user_id, position_app=body["positionApp"], job_status=body["jobStatus"])
        job = js.update_request_job(job)
        try:
            return job.json(), 201
        except ValueError as e:
            return "Not an existing Job Request", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/loan/<user_id>", methods=['PUT'])
    def update_loan(user_id):
        body = request.json
        loan = RequestLoan(user_id=user_id, acct_id=body["acctId"], loan_amount=body["loanAmount"],
                           loan_term=body["loanTerm"], loan_type=body["loanType"], loan_status=body["loanStatus"])
        loan = ls.update_request_loan(loan)
        try:
            return loan.json(), 201
        except ValueError as e:
            return "Not an existing Loan Request", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/request/credit/<req_id>", methods=['DELETE'])
    def delete_credit(req_id):
        rs.del_request_credit(req_id)
        return f"{req_id} has been deleted", 204

    @app.route("/request/job/<req_id>", methods=['DELETE'])
    def delete_job(req_id):
        js.del_request_job(req_id)
        return f"{req_id} has been deleted", 204

    @app.route("/request/loan/<req_id>", methods=['DELETE'])
    def delete_loan(req_id):
        ls.del_request_loan(req_id)
        return f"{req_id} has been deleted", 204
