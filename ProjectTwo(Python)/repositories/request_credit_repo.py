from abc import ABC, abstractmethod


class RequestCreditRepo(ABC):

    @abstractmethod
    def create_request_credit(self, credit):
        pass

    @abstractmethod
    def get_request_credit(self, req_id):
        pass

    @abstractmethod
    def get_all_request_credit(self, user_id):
        pass

    @abstractmethod
    def update_request_credit(self, change):
        pass

    @abstractmethod
    def del_request_credit(self, req_id):
        pass
