from flask import Flask,request,jsonify

print('hello')
app = Flask(__name__)
model = []    
print(model)
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
