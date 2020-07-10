const mongoose = require("mongoose");
const Joi = require("joi");
const { departmentSchema } = require("./departments");

const studentSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 3,
    maxlength: 30,
    trim: true,
  },
  department: {
    type: departmentSchema,
    required: true,
  },

  email: {
    type: String,
    required: true,
    trim: true,
  },
  rollNo: {
    type: String,
    required: true,
    minlength: 5,
    trim: true,
  },
});

const Student = mongoose.model("Student", studentSchema);

function validateStudent(student) {
  const schema = {
    name: Joi.string().min(3).required(),
    departmentId: Joi.string().required(),
    email: Joi.string().required(),
    rollNo: Joi.string().length(6).required(),
  };
  return Joi.validate(student, schema); 
}

module.exports.Student = Student;
module.exports.validate = validateStudent;

//5f0875a8f095520574850689
