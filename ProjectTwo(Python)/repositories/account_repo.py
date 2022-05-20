from abc import ABC, abstractmethod


class AccountRepo(ABC):

    @abstractmethod
    def create_account(self, account):
        pass

    @abstractmethod
    def get_account(self, acct_id):
        pass

    @abstractmethod
    def get_all_accounts(self, user_id):
        pass

    @abstractmethod
    def update_account(self, change):
        pass

    @abstractmethod
    def del_account(self, acct_id):
        pass
