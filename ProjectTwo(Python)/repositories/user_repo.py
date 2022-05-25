from abc import ABC, abstractmethod


class UserRepo(ABC):
    @abstractmethod
    def create_user(self, user):
        pass

    @abstractmethod
    def get_user(self, user_id):
        pass

    @abstractmethod
    def get_all_users(self):
        pass

    @abstractmethod
    def update_user(self, change):
        pass

    @abstractmethod
    def del_user(self, user_id):
        pass
