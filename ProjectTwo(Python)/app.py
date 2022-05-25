from flask import Flask

import controllers.front_controller as fc

app = Flask(__name__)

fc.route(app)

if __name__ == '__main__':
    app.run()
