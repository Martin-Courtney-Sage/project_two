from repositories.request_loan_repo import RequestLoanRepo


class ReqLoanService:

    def __init__(self, loan_repo: RequestLoanRepo):
        self.loan_repo = loan_repo

    # CRUD OPERATIONS

    def create_request_loan(self, loan):
        return self.loan_repo.create_request_loan(loan)

    def get_request_loan(self, req_id):
        return self.loan_repo.get_request_loan(req_id)

    def get_all_request_loan(self, user_id):
        return self.loan_repo.get_all_request_loan(user_id)

    def update_request_loan(self, change):
        return self.loan_repo.update_request_loan(change)

    def del_request_loan(self, req_id):
        return self.loan_repo.del_request_loan(req_id)

    # EXTRA OPERATIONS