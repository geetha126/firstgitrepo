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
"""
@app.get("/loan/<int:id>")
def get_model(id):
    return model[id], 200
@app.post("/loan")
def create_loan():
    req_data = request.get_json()
    new_loan = {"loanType":req_data["loanType"], "id":len(model)}
    #, "modelAmount":req_data["modelAmount"]}
  #             "Date":req_data["Date"],"RateOfInterest":req_data["RateOfInterest"], 
   #             "Duration":req_data["Duration"],"id":len(model)}
    model.append(new_loan)
    return new_loan, 201

@app.post("/friend")
def create_friend():
    req_data = request.get_json()
    new_friend = {"modelType":req_data["modelType"], "id":len(model)}

    model.append(new_friend)
    return new_friend, 201    
"""