from controllers import user_controller, account_controller, request_controller


def route(app):
    user_controller.route(app)
    account_controller.route(app)
    request_controller.route(app)
