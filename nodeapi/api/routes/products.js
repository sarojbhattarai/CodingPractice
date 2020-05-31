const express = require("express");
const router = express.Router();

const mongoose = require("mongoose");
const Product = require("../models/products");

router.get("/", (req, res, next) => {
  Product.find()
    .exec()
    .then((docs) => {
      console.log(docs);
      res.status(200).json(docs);
    })
    .catch((err) => {
      console.log(err);
      res.status(500).json({
        error: err,
      });
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
        message: "Handling Post request to /products",
        createdProduct: result,
      });
    })
    .catch((err) => {
      console.log(err);
      res.status(500).json({
        error: err,
      });
    });
});

router.get("/:productID", (req, res, next) => {
  const id = req.params.productID;
  Product.findById(id)
    .exec()
    .then((doc) => {
      console.log("From Database", doc);
      if (doc) {
        res.status(200).json(doc);
      } else {
        res.status(404).json({
          message: "ID is not valid",
        });
      }
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

router.delete("/:productID", (req, res, next) => {
  const id = req.params.productID;
  Product.remove({ _id: id })
    .exec()
    .then((res) => {
      res.status(200).json(result);
    })
    .catch((err) => {
      console.log(err);
      res.status(500).json({
        error: err,
      });
    });
});

router.patch("/:productID", (req, res, next) => {
  id = req.params.productID;
  const updateOps = {};
  for (const ops of req.body) {
    updateOps[ops.propName] = ops.value;
  }
  Product.updateOne(
    {
      _id: id,
    },
    { $set: updateOps }
  )
    .exec()
    .then((result) => {
      console.log(result);
      res.status(200).json(result);
    })
    .catch((err) => {
      console.log(err);
      res.status(500).json({
        error: err,
      });
    });
});

module.exports = router;
