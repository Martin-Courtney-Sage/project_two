from controllers import user_controller, account_controller


def route(app):
    user_controller.route(app)
    account_controller.route(app)