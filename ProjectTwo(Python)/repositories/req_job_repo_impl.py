from exceptions.resource_not_found import ResourceNotFound
from models.request_job import RequestJob
from repositories.request_job_repo import RequestJobRepo
from util.db_connection import connection


def _build_job(record):
    return RequestJob(req_id=record[0], user_id=record[1], position_app=record[2], job_status=record[3])


class ReqJobRepoImpl(RequestJobRepo):

    def create_request_job(self, job):
        sql = "INSERT INTO RequestJob Values (DEFAULT, %s, %s, %s) RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [job.user_id, job.position_app, job.job_status])
        connection.commit()
        record = cursor.fetchone()
        return _build_job(record)

    def get_request_job(self, req_id):
        sql = "SELECT * FROM RequestJob WHERE reqID = %s"  # return specific request
        cursor = connection.curser()
        cursor.execute(sql, [req_id])
        record = cursor.fetchone()
        if record:
            return _build_job(record)
        else:
            raise ResourceNotFound(f"Request with ID: {req_id} - Not Found")

    def get_all_request_job(self, user_id):
        sql = "SELECT * FROM RequestJob WHERE userID = %s"  # return all requests for that user
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        records = cursor.fetchall()
        job_list = [_build_job(record) for record in records]
        return job_list

    def update_request_job(self, change):
        sql = "UPDATE RequestJob SET userID=%s, positionApp=%s, jobStatus=%s WHERE reqID=%s RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [change.user_id, change.position_app, change.job_status, change.req_id])
        connection.commit()
        record = cursor.fetchone()
        return _build_job(record)

    def del_request_job(self, req_id):
        sql = "DELETE FROM RequestJob WHERE reqID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [req_id])
        connection.commit()
