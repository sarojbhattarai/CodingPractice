const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const { Customers, validate } = require("../models/customers");

router.get("/", async (req, res) => {
  const customer = await Customers.find().sort("name");
  res.send(customer);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let customer = new Customers({
    name: req.body.name,
    email: req.body.email,
    isGold: req.body.isGold,
  });
  customer = await customer.save().catch((err) => {
    console.log("Error while posting", err);
  });

  res.send(customer);
});

router.get("/:id", async (req, res) => {
  const customer = await Customers.findById(req.params.id);
  if (!customer) {
    res.status(404).send("Error 404 on get");
  }
  res.send(customer);
});

router.put("/:id", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(404).send(error.details[0].message);
  }

  const customer = await Customers.findByIdAndUpdate(
    req.params.id,
    {
      name: req.body.name,
      email: req.body.email,
      isGold: req.body.isGold,
    },
    {
      new: true,
    }
  );

  if (!customer) {
    return res.status(404).send("Error 404 on PUT");
  }
  res.send(customer);
});

router.delete("/:id", async (req, res) => {
  const customer = await Customers.findByIdAndRemove(req.params.id);
  if (!customer) {
    return res.status(404).send("Error 404 on delete");
  }
  res.send(customer);
});

module.exports = router;
