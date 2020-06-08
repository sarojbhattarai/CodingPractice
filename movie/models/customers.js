const Joi = require("joi");
const mongoose = require("mongoose");

const customerSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 3,
  },
  email: {
    type: String,
    required: true,
  },
  isGold: {
    type: Boolean,
    default: false,
  },
});

const Customers = mongoose.model("Customers", customerSchema);

function validateCustomer(customer) {
    const schema = {
      name: Joi.string().min(3).required(),
      email:Joi.string().min(5).max(50).required(),
      isGold:Joi.boolean()
    };
    return Joi.validate(customer, schema);
  }

  module.exports.Customers = Customers;
  module.exports.validate = validateCustomer;
  