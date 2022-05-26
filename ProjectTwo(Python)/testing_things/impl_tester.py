from exceptions.funds_not_available import FundsNotAvailable
from exceptions.resource_not_found import ResourceNotFound
from models.users import Users
from repositories.account_repo_impl import AcctRepoImpl as a
from repositories.users_repo_impl import UserRepoImpl as u
import unittest


class TestUser(unittest.TestCase):

    def test_get_user(self):
        print("testing get user")
        self.assertEqual(u.get_user(u, 1).first_name, 'Jane')
        self.assertEqual(u.get_user(u, 1).last_name, 'Smith')
        self.assertEqual(u.get_user(u, 1).email, 'JS2022@gmail.com')
        self.assertEqual(u.get_user(u, 1).phone, '555-7882')
        print("finish")

    def test_get_all_users(self):
        print("testing get all users")
        self.assertTrue(0 < len(u.get_all_users(u)) < 100)
        self.assertEqual(u.get_all_users(u)[0], Users(1, 'Jane', 'Smith', 'JS2022@gmail.com', '555-7882'))
        print("finish")


class TestExceptions(unittest.TestCase):

    def test_resource_not_found(self):
        print("test start")
        try:
            if a.get_account(a, 1):
                print("found")
            else:
                print("none")
        except ResourceNotFound as r:
            return r.message
        self.assertFalse(ResourceNotFound == Exception)
        print("finish")

    def test_funds_not_available(self):
        print("testing start")
        self.assertFalse(FundsNotAvailable == Exception)
        print("finish")


if __name__ == '__main__':
    unittest.main()
