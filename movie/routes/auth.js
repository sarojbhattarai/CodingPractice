const bcrypt = require("bcrypt");
const _ = require("lodash");
const express = require("express");
const router = express.Router();
const { User } = require("../models/users");
const mongoose = require("mongoose");
const Joi = require("Joi");

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let user = await User.findOne({ email: req.body.email });
  if (!user) {
    return res.status(400).send("Invalid email or password");
  }

  const validPassword = await bcrypt.compare(req.body.password,user.password)
  if(!validPassword){
      return res.status(400).send("Invalid Email or Password")
  }

  res.send("You have logged in successfully");
});

function validate(req) {
    const schema = {
      email: Joi.string().min(3).max(100).required(),
      password: Joi.string().min(6).max(2048).required(),
    };
    return Joi.validate(req, schema);
  }
  

module.exports = router;
