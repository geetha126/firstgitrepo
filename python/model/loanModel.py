from socket import if_indextoname
from sys import dont_write_bytecode
import flask_sqlalchemy
from datetime import date
import json

db=flask_sqlalchemy.SQLAlchemy()

class loanModel(db.Model):
    __tablename__= 'loan'
    __table_args__={'schema':'bms_schema'}
    
    loan_id = db.Column(db.Integer, primary_key = True)
    loan_type = db.Column(db.String(50), nullable = False)
    loan_amount = db.Column(db.Integer, nullable = False)
    user_id = db.Column(db.String(50), nullable = False)
    rate_of_interest = db.Column(db.Integer, nullable = False)
    duration = db.Column(db.String(50), nullable = False)
    date = db.Column(db.String(100), nullable = False)
    

    def __repr__(self):
        return json.dumps({"loan_id":self.loan_id,"loan_type":self.loan_type,"loan_amount":self.loan_amount,\
            "user_id":self.user_id,"rate_of_interest":self.rate_of_interest,\
            "duration":self.duration,"date":self.date}, indent=8)