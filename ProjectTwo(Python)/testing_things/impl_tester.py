from repositories.account_repo_impl import AcctRepoImpl as a
from repositories.users_repo_impl import UserRepoImpl as u
import unittest


# Testing User Functions
class TestUser(unittest.TestCase):

    def test_get_user(self):
        print("testing get user")
        self.assertEquals(u.get_user(u, 1).first_name, 'Jane')
        self.assertEquals(u.get_user(u, 1).last_name, 'Smith')
        self.assertEquals(u.get_user(u, 1).email, 'JS2022@gmail.com')
        self.assertEquals(u.get_user(u, 1).phone, '555-7882')
        print("finish")

    def test_get_all_users(self):
        print("testing get all users")
        print("finish")


# Testing Account Functions
class TestAccount(unittest.TestCase):

    def test_get_account(self):
        print("testing get account")
        print("finish")

    def test_get_all_accounts(self):
        print("testing get all accounts for a user")
        print("finish")

    def test_deposit_success(self):
        print("testing deposit funds")
        print("finish")

    def test_withdraw_success(self):
        print("testing withdraw funds")
        print("finish")

    def test_transfer_success(self):
        print("testing transfer funds")
        print("finish")


# Testing Requests Functions
class TestRequests(unittest.TestCase):
    pass


if __name__ == '__main__':
    unittest.main()
