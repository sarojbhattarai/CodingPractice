const express = require("express");
const router = express.Router();
const { Course, validate } = require("../models/courses");
const Joi = require("joi");

router.get("/", async (req, res) => {
  const allCourse = await Course.find().sort("name");
  res.status(200).send(allCourse);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) return res.status(400).send(error.details[0].message);

  const course = new Course({
    name: req.body.name,
  });
  const result = await course.save();
  res.send(result);
});

router.get("/:id", async (req, res) => {
  const course = await Course.findById(req.params.id);
  if (!course) res.status(404).send("not found");
  res.send(course);
});

router.delete("/:id", async (req, res) => {
  const id = req.params.id;
  const course = await Course.findByIdAndDelete(id);
  if (!course) res.status(404).send("Course not Found");
  res.send(course);
});

module.exports = router;
