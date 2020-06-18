const auth = require("../middleware/auth");//auth is authorisation
const bcrypt = require('bcrypt');
const jwt = require("jsonwebtoken");
const config = require("config");
const _ = require("lodash");
const express = require("express");
const router = express.Router();
const { User, validate } = require("../models/user");
const mongoose = require("mongoose");


router.get("/me",auth, async(req,res)=>{
    const user = await User.findById(req.user._id).select('-password');
    res.send(user);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let user = await User.findOne({ email: req.body.email });
  if (user) {
    return res.status(400).send("User is already registered");
  }

  user = new User(_.pick(req.body,['name', 'email','password']));
  const salt = await bcrypt.genSalt(15);
  user.password = await bcrypt.hash(user.password,salt); 
  await user.save();
  const token = user.generateAuthToken();
  res.header('x-auth-token', token).send(_.pick(user,['name','email','_id']));
});

module.exports = router;
