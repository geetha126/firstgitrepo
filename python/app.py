from flask import Flask,request
from model.userModel import db,userModel
from flask_smorest import Api
from resource.userDetails import userBp
import json


app = Flask(__name__)

app.config["PROPAGATE_EXCEPTIONS"] = True
app.config["API_TITLE"] = "BMS API"
app.config["API_VERSION"] = "v1" 
app.config["OPENAPI_VERSION"] = "3.0.3"
app.config["OPENAPI_URL_PREFIX"] = "/" 
app.config["OPENAPI_SWAGGER_UI_PATH"] =  "/swagger-ui"
app.config["OPENAPI_SWAGGER_UI_URL"] = "https://cdn.jsdelivr.net/npm/swagger-ui-dist/"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
app.config["SQLALCHEMY_DATABASE_URI"] = "postgresql://postgres:root@localhost:5432/bms"

db.init_app(app)
api = Api(app)
api.register_blueprint(userBp)
