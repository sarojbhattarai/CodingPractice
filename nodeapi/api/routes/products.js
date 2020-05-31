const express = require("express");
const router = express.Router();

const mongoose = require("mongoose");
const Product = require("../models/products");

router.get("/", (req, res, next) => {
  res.status(200).json({
    message: "Inside GET REQUEST",
  });
});

router.post("/", (req, res, next) => {
  /**
   * Here I can store my data by calling a constructor because we can use models as constructor
   */
  const product = new Product({
    _id: mongoose.Types.ObjectId(),
    name: req.body.name,
    price: req.body.price,
  });
  product
    .save()
    .then((result) => {
      console.log(result);
      res.status(201).json({
          message:"Handling Post request to /products",
          createdProduct:result
      });
    })
    .catch(err=>{
      console.log(err);
      res.status(500).json({
        error:err
      })
    }); 
});

router.get("/:productID", (req, res, next) => {
  const id = req.params.productID;
  Product.findById(id)
    .exec()
    .then((doc) => {
      console.log(doc);
      res.status(200).json(doc);
    })
    .catch((err) => {
      console.log(err);
      res.status(500).json({
        error: err,
      });
    });
});

router.post("/:productID", (req, res, next) => {
  res.status(201).json({
    message: "Inside POST",
    id: req.params.productID,
  });
});

router.delete("/", (req, res, next) => {
  res.status(200).json({
    message: "DELETED. BYE BYE",
  });
});

router.patch("/", (req, res, next) => {
  res.status(201).json({
    message: "UPDATED SUCCESSFULLY",
  });
});

module.exports = router;
