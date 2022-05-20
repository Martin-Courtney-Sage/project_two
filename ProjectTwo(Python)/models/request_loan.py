
class RequestLoan:

    def __init__(self, req_id=0, user_id=0, acct_id=0, loan_amount=0, loan_term="", loan_type="", loan_status=""):
        self.req_id = req_id
        self.user_id = user_id
        self.acct_id = acct_id
        self.loan_amount = loan_amount
        self.loan_term = loan_term
        self.loan_type = loan_type
        self.loan_status = loan_status

    def __repr__(self):
        return str({
            'req_id': self.req_id,
            'user_id': self.user_id,
            'acct_id': self.acct_id,
            'loan_amount': self.loan_amount,
            'loan_term': self.loan_term,
            'loan_type': self.loan_type,
            'loan_status': self.loan_status
        })

    def json(self):
        return str({
            'reqId': self.req_id,
            'userId': self.user_id,
            'acctId': self.acct_id,
            'loanAmount': self.loan_amount,
            'loanTerm': self.loan_term,
            'loanType': self.loan_type,
            'loanStatus': self.loan_status
        })
