const mongoose = require("mongoose");
const Joi = require("joi");

const courseSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    trim: true,
    maxlength: 150,
    minlength: 2,
  },
});

const Course = mongoose.model("Course", courseSchema);

function validateCourse(course) {
  const schema = {
    name: Joi.string().required(),
  };
  return Joi.validate(course, schema);
}

module.exports.Course = Course;
module.exports.validate = validateCourse;
