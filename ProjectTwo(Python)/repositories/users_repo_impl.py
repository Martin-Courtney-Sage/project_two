from models.users import Users
from repositories.user_repo import UserRepo
from exceptions.resource_not_found import ResourceNotFound
from util.db_connection import connection


def _build_user(record):
    return Users(user_id=record[0], first_name=record[1], last_name=record[2], email=record[3], phone=record[4],
                 username=record[5], passcode=record[6])


class UserRepoImpl(UserRepo):

    def create_user(self, user):
        sql = "INSERT INTO Users VALUES (DEFAULT, %s, %s, %s, %s, %s, %s) RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [user.user_id, user.first_name, user.last_name, user.email, user.phone, user.username,
                             user.passcode])
        connection.commit()
        record = cursor.fetchone()
        return _build_user(record)

    def get_user(self, user_id):
        sql = "SELECT * FROM Users WHERE userID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        record = cursor.fetchone()

        if record:
            return _build_user(record)
        else:
            raise ResourceNotFound(f"User with ID: {user_id} - Not Found")

    def get_all_users(self):
        sql = "SELECT * FROM Users"
        cursor = connection.cursor()
        cursor.execute(sql)
        records = cursor.fetchall()
        user_list = [_build_user(record) for record in records]
        return user_list

    def update_user(self, change):
        sql = "UPDATE Users SET firstname = %s, lastname = %s, email = %s, phone = %s, username = %s," \
              "passcode = %s RETURNING *"
        cursor = connection.cursor()
        cursor.execute(sql, [change.first_name, change.last_name, change.email, change.phone,
                             change.username, change.passcode])
        connection.commit()
        record = cursor.fetchone()
        return _build_user(record)

    def del_user(self, user_id):
        sql = "DELETE FROM Users WHERE userID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        connection.commit()
        return f"User ID: {user_id} - Deleted"
