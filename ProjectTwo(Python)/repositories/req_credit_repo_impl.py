from exceptions.resource_not_found import ResourceNotFound
from models.request_credit import RequestCredit
from repositories.request_credit_repo import RequestCreditRepo
from util.db_connection import connection


def _build_credit(record):
    return RequestCredit(req_id=record[0], user_id=record[1], card_type=record[2], credit_limit=record[3],
                         req_status=record[4])


class ReqCreditRepoImpl(RequestCreditRepo):

    def create_request_credit(self, credit):
        sql = "INSERT INTO RequestCredit Values (DEFAULT, %s, %s, %s, %s) RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [credit.user_id, credit.card_type, credit.credit_limit])
        connection.commit()
        record = cursor.fetchone()
        return _build_credit(record)

    def get_request_credit(self, req_id):
        sql = "SELECT * FROM RequestCredit WHERE reqID = %s"  # return specific request
        cursor = connection.cursor()
        cursor.execute(sql, [req_id])
        record = cursor.fetchone()
        if record:
            return _build_credit(record)
        else:
            raise ResourceNotFound(f"Request with ID: {req_id} - Not Found")

    def get_all_request_credit(self, user_id):
        sql = "SELECT * FROM RequestCredit WHERE userID = %s"  # return all requests for that user
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        records = cursor.fetchall()
        credit_list = [_build_credit(record) for record in records]
        return credit_list

    def update_request_credit(self, change):
        sql = "UPDATE RequestCredit SET userID=%s, cardType=%s, creditLimit=%s, reqStatus=%s WHERE reqID=%s RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [change.user_id, change.card_type, change.credit_limit, change.req_status, change.req_id])
        connection.commit()
        record = cursor.fetchone()
        return _build_credit(record)

    def del_request_credit(self, req_id):
        sql = "DELETE FROM RequestCredit WHERE reqID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [req_id])
        connection.commit()
