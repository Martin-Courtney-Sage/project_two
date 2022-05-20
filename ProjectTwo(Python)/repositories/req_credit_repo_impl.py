from exceptions.resource_not_found import ResourceNotFound
from models.request_credit import RequestCredit
from repositories.request_credit_repo import RequestCreditRepo
from util.db_connection import connection


def _build_credit(record):
    return RequestCredit(req_id=record[0], user_id=record[1], card_type=record[2], credit_limit=record[3],
                         req_status=record[4])


class ReqCreditRepoImpl(RequestCreditRepo):

    def create_request_credit(self, credit):
        pass

    def get_request_credit(self, req_id):
        pass

    def get_all_request_credit(self, user_id):
        pass

    def update_request_credit(self, change):
        pass

    def del_request_credit(self, req_id):
        pass
