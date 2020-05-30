const mongoose = require('mongoose');

const productSchema = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId, //specical type of id which mongoose offers!! 
    name:String,
    price:Number
});

module.exports = mongoose.model("Product",productSchema);


