const mongoose = require("mongoose");
const Joi = require("joi");

const departmentSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 3,
    maxlength: 30,
    trim: true,
  },
});

const Department = mongoose.model("Department", departmentSchema);

function validateDepartment(department) {
  const schema = {
    name: Joi.string().min(3).required(),
  };
  return Joi.validate(department, schema);
}

module.exports.departmentSchema = departmentSchema;
module.exports.Department = Department;
module.exports.validate = validateDepartment;

//5f0875a8f095520574850689
