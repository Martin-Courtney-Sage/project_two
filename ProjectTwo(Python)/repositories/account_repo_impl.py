from exceptions.resource_not_found import ResourceNotFound
from models.accounts import Accounts
from repositories.account_repo import AccountRepo
from util.db_connection import connection


def _build_account(record):
    return Accounts(acct_id=record[0], user_id=record[1], account_type=record[2], account_balance=record[3])

class AcctRepoImpl(AccountRepo):
    def create_account(self, account):
        sql = 'INSERT INTO Accounts VALUES (DEFAULT, %s, %s, %s) RETURN *'
        cursor = connection.cursor()
        cursor.execute(sql, [account.acct_id, account.user_id, account.account_type, account.account_balance])
        connection.commit()
        record = cursor.fetchone()
        return _build_account(record)

    def get_account(self, acct_id):
        sql = "SELECT * FROM Accounts WHERE acctID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [acct_id])
        record = cursor.fetchone()
        if record:
            return _build_account(record)
        else:
            raise ResourceNotFound(f"Account with ID {acct_id} - Not Found")

    def get_all_accounts(self, user_id):
        sql = "SELECT * from Accounts WHERE userID = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [user_id])
        records = cursor.fetchall()
        if records:
            acct_list = [_build_account(record) for record in records]
            return acct_list
        else:
            raise ResourceNotFound(f"Account for ID {user_id} - Not Found")

    def update_account(self, change):
        sql = "UPDATE Accounts SET userID=%s, acctID=%s, accountType=%s, accountBalance=%s RETURN *"
        cursor = connection.cursor()
        cursor.execute(sql, [change.acct_id, change.user_id, change.account_type, change.account_balance])
        connection.commit()
        record = cursor.fetchone()
        return _build_account(record)

    def del_account(self, acct_id):
        sql = "DELETE FROM Accounts WHERE acctID=%s RETURN *"
        cursor = connection.cursor()
        cursor.execute(sql, [acct_id])
        connection.commit()
        return f"{acct_id} successfully deleted"

    def withdraw_funds(self, acct_id):
        sql = "UPDATE Accounts WHERE acctID = %s SET accountBalance = account.account_balance"
        cursor = connection.cursor()
        cursor.execute(sql, [acct_id])
        connection.commit()
        return f"{acct_id} -- withdrew funds successfully"

    def deposit_funds(self, acct_id):
        sql = "UPDATE Accounts WHERE acctID = %s SET accountBalance = account.account_balance"
        cursor = connection.cursor()
        cursor.execute(sql, [acct_id])
        connection.commit()
        return f"Funds deposited successfully into -- {acct_id}"


    def transfer_funds(self, acct_id_from, acct_id_too):
        sql = "UPDATE Accounts WHERE acctID = acct_id_from SET accountBalance = account1 " \
              "UPDATE Accounts WHERE acctID = acct_id_too SET accountBalance = account2"
        cursor = connection.cursor()
        cursor.execute(sql, [acct_id_from, acct_id_too])
        connection.commit()
        return f"Funds successfully transferred between - {acct_id_too} and {acct_id_from}"
