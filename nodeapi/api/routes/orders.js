const express = require("express");

const router = express.Router();

router.get("/", (req, res, next) => {
  res.status(200).json({
    message: "WAIT.... ORDER IS BEING FETCHED",
  });
});

router.post("/", (req, res, next) => {
  const order  = {
    orderID: req.body.orderID,
    quantity: req.body.quantity
  };
  res.status(201).json({
    message: "ORDERS WERE FETCHED",
    orders:order
  });
});

router.get("/:orderID", (req, res, next) => {
  res.status(201).json({
    message: "ORDERS DETAILS",
    id: req.params.orderID,
  });
});

router.delete("/:orderID", (req, res, next) => {
  res.status(201).json({
    message: "ORDER IS DELETED",
    id: req.params.orderID,
  });
});

module.exports = router;
