const Joi = require("joi");
const mongoose = require("mongoose");
const jwt = require("jsonwebtoken")
 
const userSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 3,
    maxlength: 50,
  },
  email: {
    type: String,
    required: true,
    maxlength: 100,
    unique: true,
  },
  password: {
    type: String,
    required: true,
    minlength: 6,
    maxlength: 2048,
  },
  isAdmin:{
    type:Boolean,
  }
});
userSchema.methods.generateAuthToken=function(){
  const token = jwt.sign({ _id: this._id, isAdmin:this.isAdmin },"jwtPrivateKey");
  return token;
}

const User = mongoose.model("User", userSchema);

function validateUser(user) { 
  const schema = {
    name: Joi.string().min(3).max(50).required(),
    email: Joi.string().min(3).max(100).required(),
    password: Joi.string().min(6).max(2048).required(),
  };
  return Joi.validate(user, schema);
}

module.exports.User = User;
module.exports.validate = validateUser;
