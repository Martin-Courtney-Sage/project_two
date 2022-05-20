from abc import ABC, abstractmethod


class RequestLoanRepo(ABC):

    @abstractmethod
    def create_request_loan(self, loan):
        pass

    @abstractmethod
    def get_request_loan(self, req_id):
        pass

    @abstractmethod
    def get_all_request_loan(self, user_id):
        pass

    @abstractmethod
    def update_request_loan(self, change):
        pass

    @abstractmethod
    def del_request_loan(self, req_id):
        pass
