from flask import Flask,request
from model.loanModel import db,loanModel
from flask_smorest import Blueprint
from flask.views import MethodView

userBp = Blueprint("loanDetails", __name__, description = "Apply Loan Blueprint")

@userBp.route("/applyLoan")
class loanDetails(MethodView):
    def post(self):
        request_data = request.get_json()
        print(request_data)
        new_loan = loanModel(**request_data)
        print(new_loan)
        db.session.add(new_loan)
        db.session.commit()
        return {"Loan":new_loan.loan_id+" created"},201

    def get(self):
        all_users = loanModel.query.all()
        return {"Loan details": str(all_users)}, 200    
