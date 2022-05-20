from abc import ABC, abstractmethod


class RequestJobRepo(ABC):

    @abstractmethod
    def create_request_job(self, job):
        pass

    @abstractmethod
    def get_request_job(self, req_id):
        pass

    @abstractmethod
    def get_all_request_job(self, user_id):
        pass

    @abstractmethod
    def update_request_job(self, change):
        pass

    @abstractmethod
    def del_request_job(self, req_id):
        pass
