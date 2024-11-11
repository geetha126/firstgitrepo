#update profile- to update the details of account holder into the system

from flask import Flask, request, jsonify
from model.userModel import db,userModel
from flask_smorest import Blueprint
from flask.views import MethodView

userBp = Blueprint("loanDetails", __name__, description = "Apply Loan Blueprint")

@userBp.route("/updateUser/<int:user_id>")
class updateUser(MethodView):
    def put(self):
        request_data = request.get_json()
        if not request_data or 'username' not in request_data:
            return jsonify({"error": "Missing required fields"}), 400
    
        edit_user = userModel(**request_data)
        db.session.update(edit_user)
        db.session.commit()
        return jsonify({"message": "Profile updated successfully","User":edit_user.username}),201

    def get(self):
        all_users = userModel.query.all()
        return {"Users": str(all_users)}, 200    




