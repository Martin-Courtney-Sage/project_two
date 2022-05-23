from exceptions.resource_not_found import ResourceNotFound
from models.request_loan import RequestLoan
from repositories.request_loan_repo import RequestLoanRepo
from util.db_connection import connection


def _build_loan(record):
    return RequestLoan(req_id=record[0], user_id=record[1], acct_id=record[2], loan_amount=record[3],
                       loan_term=record[4], loan_type=record[5], loan_status=record[6])


class ReqLoanRepoImpl(RequestLoanRepo):

    def create_request_loan(self, loan):
        sql = "INSERT INTO RequestLoan Values (DEFAULT, %s, %s, %s, %s, %s, %s) RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [loan.user_id, loan.acct_id, loan.loan_amount, loan.loan_term, loan.loan_type,
                             loan.loan_status])
        connection.commit()
        record = cursor.fetchone()
        return _build_loan(record)

    def get_request_loan(self, req_id):
        sql = "SELECT * FROM RequestLoan WHERE reqID = %s"  # return specific request
        cursor = connection.cursor()
        cursor.execute(sql, [req_id])
        record = cursor.fetchone()
        if record:
            return _build_loan(record)
        else:
            raise ResourceNotFound(f"Request with ID: {req_id} - Not Found")

    def get_all_request_loan(self, user_id):
        sql = "SELECT * FROM RequestLoan WHERE userID = %s"  # return all requests for that user
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        records = cursor.fetchall()
        loan_list = [_build_loan(record) for record in records]
        return _build_loan

    def update_request_loan(self, change):
        sql = "UPDATE RequestLoan SET userID=%s, acctID=%s, loanAmount=%s, loanTerm=%s, loanType=%s, loanStatus=%s" \
              "WHERE reqID=%s RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [change.user_id, change.acct_id, change.loan_amount, change.loan_term, change.loan_type,
                             change.loan_status, change.req_id])
        connection.commit()
        record = cursor.fetchone()
        return _build_loan(record)

    def del_request_loan(self, req_id):
        sql = "DELETE FROM RequestLoan WHERE reqID = %s"
        cursor = connection.commit()
        cursor.execute(sql, [req_id])
        connection.commit()
