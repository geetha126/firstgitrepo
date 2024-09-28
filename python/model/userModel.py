from socket import if_indextoname
from sys import dont_write_bytecode
import flask_sqlalchemy
from datetime import date
import json

db=flask_sqlalchemy.SQLAlchemy()

class userModel(db.Model):
    __tablename__= 'user_table'
    __table_args__={'schema':'bms_schema'}
    
    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.String(50), nullable = False)
    username = db.Column(db.String(50), nullable = False)
    password = db.Column(db.String(50), nullable = False)
    contact_no = db.Column(db.Integer, nullable = False)
    email_id = db.Column(db.String(50), nullable = False)
    address = db.Column(db.String(100), nullable = False)
    state = db.Column(db.String(50), nullable = False)
    country = db.Column(db.String(50), nullable = False)
    pan = db.Column(db.String(50), nullable = False)
    dob = db.Column(db.String(50), nullable = False)

    def __repr__(self):
        return json.dumps({"id":self.id,"username":self.username,"password":self.password,\
            "name":self.name,"contact_no":self.contact_no,"email_id":self.email_id,\
            "address":self.address,"state":self.state,"country":self.country,"pan":self.pan,"dob":self.dob}, indent=4)