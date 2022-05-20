from exceptions.resource_not_found import ResourceNotFound
from models.request_job import RequestJob
from repositories.request_job_repo import RequestJobRepo
from util.db_connection import connection


def _build_job(record):
    return RequestJob(req_id=record[0], user_id=record[1], position_app=record[2], job_status=record[3])


class ReqJobRepoImpl(RequestJobRepo):

    def create_request_job(self, job):
        pass

    def get_request_job(self, req_id):
        pass

    def get_all_request_job(self, user_id):
        pass

    def update_request_job(self, change):
        pass

    def del_request_job(self, req_id):
        pass
