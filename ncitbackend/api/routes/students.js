const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const { Student, validate } = require("../models/students");
const { Department } = require("../models/departments");

router.get("/", async (req, res) => {
  const student = await Student.find().sort("name");
  if (!student) res.status(404).send("not found");
  res.send(student);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) return res.status(400).send(error.details[0].message);
  const department = await Department.findById(req.body.departmentId);
  if (!department) return res.status(400).send("Error id");

  let student = new Student({
    name: req.body.name,
    department: {
      _id: department._id,
      name: department.name,
    },
    email: req.body.email,
    rollNo: req.body.rollNo,
  });
  student = await student.save().catch((err) => {
    console.log("Error while posting", err);
  });
  res.send(student);
});
module.exports = router;
