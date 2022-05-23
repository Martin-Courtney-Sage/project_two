from repositories.account_repo import AccountRepo
from exceptions.resource_not_found import ResourceNotFound
from exceptions.funds_not_available import FundsNotAvailable


class AccountService:

    def __init__(self, account_repo: AccountRepo):
        self.account_repo = account_repo

    # CRUD OPERATIONS

    def create_account(self, user_id):
        return self.account_repo.create_account(user_id)

    def get_account(self, acct_id):
        return self.account_repo.get_account(acct_id)

    def get_all_accounts(self, user_id):
        return self.account_repo.get_all_accounts(user_id)

    def update_account(self, change):
        return self.account_repo.update_account(change)

    def del_account(self, acct_id):
        return self.account_repo.del_account(acct_id)

    # EXTRA OPERATIONS

    def withdraw_funds(self, acct_id, funds=0):  # withdraw funds
        account = self.get_account(acct_id)
        if account.account_balance < int(funds):
            try:
                return
            except ValueError:
                raise FundsNotAvailable(f"Account with ID: {acct_id} - Not Enough Funds")
        account.account_balance = str(int(account.account_balance) - int(funds))
        return account.account_balance

    def deposit_funds(self, acct_id, funds=0):  # deposit funds
        account = self.get_account(acct_id)
        account.account_balance = str(int(account.account_balance) + int(funds))
        return account.account_balance

    def transfer_funds(self, acct_id_from, acct_id_too, funds=0):  # transfer funds
        account1 = self.get_account(acct_id_from)
        account2 = self.get_account(acct_id_too)
        if account1.account_balance < int(funds):
            try:
                return
            except ValueError:
                raise FundsNotAvailable(f"Account with ID: {acct_id_from} - Not Enough Funds")
        self.withdraw_funds(account1, funds)
        self.deposit_funds(account2, funds)
        return str(f"Funds have transferred. {account1}={account1.account_balance} & {account2}={account2.account_balance}")
