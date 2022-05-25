from flask import request, jsonify
from exceptions.resource_not_found import ResourceNotFound
from models.users import Users
from repositories.users_repo_impl import UserRepoImpl
from services.user_service import UserService

ur = UserRepoImpl()
us = UserService(ur)


def route(app):

    @app.route("/user", methods=['POST'])  # creates user
    def post_user():
        body = request.json
        user = Users(first_name=body["fistName"], last_name=body["lastName"], email=body["email"],
                     phone=body["phone"])
        user = us.create_user(user)
        return user.json(), 201

    @app.route("/user/<user_id>", methods=['GET'])  # gets user
    def get_user(user_id):
        try:
            return us.get_user(user_id).json(), 200
        except ValueError as e:
            return "Not an existing User ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/user", methods=['GET'])  # gets all users
    def get_all_users():
        try:
            return jsonify([user.json() for user in us.get_all_users()]), 200
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/user/<user_id>", methods=['PUT'])  # updates user
    def put_user(user_id):
        body = request.json
        user = Users(user_id=user_id, first_name=body["fistName"], last_name=body["lastName"], email=body["email"],
                     phone=body["phone"])
        user = us.update_user(user)
        try:
            return user.json(), 201
        except ValueError as e:
            return "Not an existing User ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/user/<user_id>", methods=['DELETE'])  # deletes user
    def delete_user(user_id):
        us.del_user(user_id)
        return f"{user_id} has been deleted", 204
