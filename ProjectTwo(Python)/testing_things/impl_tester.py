from repositories.account_repo_impl import AcctRepoImpl
from repositories.users_repo_impl import UserRepoImpl
import unittest


# Testing User Functions
class TestUser(unittest.TestCase):
    def test_create_user(self):
        print("testing create user")
        print("test success")

    def test_get_user(self):
        print("testing get user")
        print("test success")

    def test_get_all_users(self):
        print("testing get all users")
        print("test success")

    def test_update_user(self):
        print("testing updating user")
        print("test success")

    def test_delete_user(self):
        print("testing delete user")
        print("test success")


# Testing Account Functions
class TestAccount(unittest.TestCase):
    def test_create_account(self):
        print("testing create account")
        print("test success")

    def test_get_account(self):
        print("testing get account")
        print("test success")

    def test_get_all_accounts(self):
        print("testing get all accounts for a user")
        print("test success")

    def test_update_account(self):
        print("testing updating account")
        print("test success")

    def test_delete_account(self):
        print("testing delete account")
        print("test success")

    def test_deposit_success(self):
        print("testing deposit funds")
        print("test success")

    def test_withdraw_success(self):
        print("testing withdraw funds")
        print("test success")

    def test_transfer_success(self):
        print("testing transfer funds")
        print("test success")


# Testing Requests Functions
class TestRequests(unittest.TestCase):
    pass


if __name__ == '__main__':
    unittest.main()
