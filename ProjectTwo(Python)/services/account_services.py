from repositories.account_repo import AccountRepo
from exceptions.resource_not_found import ResourceNotFound


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