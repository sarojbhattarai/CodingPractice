const mongoose = require("mongoose");

const productSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //specical type of id which mongoose offers!!
  name: { type: String, required: true },
  price: { type: Number, required: true },
});

module.exports = mongoose.model("Product", productSchema);
