
class RequestCredit:

    def __init__(self, req_id=0, user_id=0, card_type="", credit_limit=0, req_status=""):
        self.req_id = req_id
        self.user_id = user_id
        self.card_type = card_type
        self.credit_limit = credit_limit
        self.req_status = req_status

    def __repr__(self):
        return str({
            'req_id': self.req_id,
            'user_id': self.user_id,
            'card_type': self.card_type,
            'credit_limit': self.credit_limit,
            'req_status': self.req_status
        })

    def json(self):
        return str({
            'reqId': self.req_id,
            'userId': self.user_id,
            'cardType': self.card_type,
            'creditLimit': self.credit_limit,
            'reqStatus': self.req_status
        })
