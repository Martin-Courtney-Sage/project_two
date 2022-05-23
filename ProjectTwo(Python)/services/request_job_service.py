from repositories.request_job_repo import RequestJobRepo


class ReqJobService:

    def __init__(self, job_repo: RequestJobRepo):
        self.job_repo = job_repo

    # CRUD OPERATIONS

    def create_request_job(self, job):
        return self.job_repo.create_request_job(job)

    def get_request_job(self, req_id):
        return self.job_repo.get_request_job(req_id)

    def get_all_request_job(self, user_id):
        return self.job_repo.get_all_request_job(user_id)

    def update_request_job(self, change):
        return self.job_repo.update_request_job(change)

    def del_request_job(self, req_id):
        return self.job_repo.del_request_job(req_id)

    # EXTRA OPERATIONS