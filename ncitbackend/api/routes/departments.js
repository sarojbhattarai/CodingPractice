const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const { Department, validate } = require("../models/departments");

router.get("/", async (req, res) => {
  const department = await Department.find().sort("name");
  res.send(department);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) return res.status(400).send(error.details[0].message);
  let department = new Department({
    name: req.body.name,
  });
  department = await department.save().catch((err) => {
    console.log("Error while posting", err);
  });
  res.send(department);
});

router.get("/:id", (req, res) => {
  const id = req.params.id;
  res.status(200).send("The id is" + id);
});

module.exports = router;
