import psycopg2 as psycopg2
from psycopg2 import OperationalError


def create_connection():
    try:
        conn = psycopg2.connect(
            database='BankApp',  # place the database name here that you wish to connect too
            user='postgres',  # place your main server username here
            password='Passcode1234',  # place your main server password here
            host='bankapi.cm3eifypc0db.us-east-1.rds.amazonaws.com',  # put the server endpoint line here
            port='5432'  # put the port number here
        )

        return conn
    except OperationalError as e:
        print(f"{e}")
        return None


connection = create_connection()

def _test():
    print(connection)


if __name__ == '__main__':
    _test()