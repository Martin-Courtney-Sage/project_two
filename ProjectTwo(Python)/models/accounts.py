
class Accounts:

    def __init__(self, acct_id=0, user_id=0, account_type="", account_balance=0):
        self.acct_id = acct_id
        self.user_id = user_id
        self.account_type = account_type
        self.account_balance = account_balance

    def __repr__(self):
        return str({
            'acct_id': self.acct_id,
            'user_id': self.user_id,
            'account_type': self.account_type,
            'account_balance': self.account_balance
        })

    def json(self):
        return str({
            'acctId': self.acct_id,
            'userId': self.user_id,
            'accountType': self.account_type,
            'accountBalance': self.account_balance
        })
