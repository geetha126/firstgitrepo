from flask import Flask,request
from model.userModel import db,userModel
from flask_smorest import Blueprint
from flask.views import MethodView

userBp = Blueprint("userDetails", __name__, description = "User Registration Blueprint")

@userBp.route("/userRegistration")
class userDetails(MethodView):
    def post(self):
        request_data = request.get_json()
        new_user = userModel(**request_data)
        db.session.add(new_user)
        db.session.commit()
        return {"User":new_user.username},201

    def get(self):
        all_users = userModel.query.all()
        return {"Users": str(all_users)}, 200    
