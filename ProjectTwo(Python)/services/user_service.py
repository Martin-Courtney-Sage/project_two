from repositories.user_repo import UserRepo


class UserService:

    def __init__(self, user_repo: UserRepo):
        self.user_repo = user_repo

    # CRUD OPERATIONS

    def create_user(self, user):
        return self.user_repo.create_user(user)

    def get_user(self, user_id):
        return self.user_repo.get_user(user_id)

    def get_all_users(self):
        return self.user_repo.get_all_users()

    def update_user(self, change):
        return self.user_repo.update_user(change)

    def del_user(self, user_id):
        return self.user_repo.del_user(user_id)

    # EXTRA OPERATIONS
