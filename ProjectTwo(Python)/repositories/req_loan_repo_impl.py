from exceptions.resource_not_found import ResourceNotFound
from models.request_loan import RequestLoan
from repositories.request_loan_repo import RequestLoanRepo
from util.db_connection import connection


def _build_loan(record):
    return RequestLoan(req_id=record[0], user_id=record[1], acct_id=record[2], loan_amount=record[3],
                       loan_term=record[4], loan_type=record[5], loan_status=record[6])


class ReqLoanRepoImpl(RequestLoanRepo):

    def create_request_loan(self, loan):
        pass

    def get_request_loan(self, req_id):
        pass

    def get_all_request_loan(self, user_id):
        pass

    def update_request_loan(self, change):
        pass

    def del_request_loan(self, req_id):
        pass
