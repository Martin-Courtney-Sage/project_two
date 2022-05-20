
class RequestJob:

    def __init__(self, req_id=0, user_id=0, position_app="", job_status=""):
        self.req_id = req_id
        self.user_id = user_id
        self.position_app = position_app
        self.job_status = job_status

    def __repr__(self):
        return str({
            'req_id': self.req_id,
            'user_id': self.user_id,
            'position_app': self.position_app,
            'job_status': self.job_status
        })

    def json(self):
        return str({
            'reqId': self.req_id,
            'userId': self.user_id,
            'positionApp': self.position_app,
            'jobStatus': self.job_status
        })
