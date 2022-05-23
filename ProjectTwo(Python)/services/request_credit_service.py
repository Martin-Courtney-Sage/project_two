from repositories.request_credit_repo import RequestCreditRepo


class ReqCreditService:

    def __init__(self, credit_repo: RequestCreditRepo):
        self.credit_repo = credit_repo

    # CRUD OPERATIONS

    def create_request_credit(self, credit):
        return self.credit_repo.create_request_credit(credit)

    def get_request_credit(self, req_id):
        return self.credit_repo.get_request_credit(req_id)

    def get_all_request_credit(self, user_id):
        return self.credit_repo.get_all_request_credit(user_id)

    def update_request_credit(self, change):
        return self.credit_repo.update_request_credit(change)

    def del_request_credit(self, req_id):
        return self.credit_repo.del_request_credit(req_id)

    # EXTRA OPERATIONS