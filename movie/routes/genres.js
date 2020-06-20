const auth = require("../middleware/auth");
const admin = require("../middleware/admin");
const express = require("express");
const router = express.Router();
const { Genre, validate } = require("../models/genres");
const mongoose = require("mongoose");
const asyncMiddleware = require("../middleware/async");



router.get(
  "/",
  asyncMiddleware(async (req, res) => {
    const genre = await Genre.find().sort("name");
    res.send(genre);
  })
);

router.post("/", auth,asyncMiddleware( async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let genre = new Genre({
    name: req.body.name,
  });
  genre = await genre.save().catch((err) => {
    console.log("Error while posting", err);
  });

  res.send(genre);
}));

router.get("/:id", asyncMiddleware(async (req, res) => {
  const genre = await Genre.findById(req.params.id);
  if (!genre) {
    res.status(404).send("Error 404 on get");
  }
  res.send(genre);
}));

router.put("/:id",asyncMiddleware( async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(404).send(error.details[0].message);
  }

  const genre = await Genre.findByIdAndUpdate(
    req.params.id,
    {
      name: req.body.name,
    },
    {
      new: true,
    }
  );

  if (!genre) {
    return res.status(404).send("Error 404 on PUT");
  }
  res.send(genre);
}));

router.delete("/:id", [auth, admin], async (req, res) => {
  const genre = await Genre.findByIdAndRemove(req.params.id);
  if (!genre) {
    return res.status(404).send("Error 404 on delete");
  }
  res.send(genre);
});

module.exports = router;
