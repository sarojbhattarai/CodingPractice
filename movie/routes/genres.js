const express = require("express");
const router = express.Router();
const Joi = require("joi");
const mongoose = require("mongoose");

const genreSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 3,
  },
});

const Genre = mongoose.model("Genre", genreSchema);

router.get("/", async (req, res) => {
  const genre = await Genre.find().sort("name");
  res.send(genre);
});

router.post("/", async (req, res) => {
  const { error } = validateGenre(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let genre = new Genre({
    name: req.body.name,
  });
  genre = await genre.save().catch(err =>{
    console.log("Error while posting", err)
  }); 

  res.send(genre);
});

router.get("/:id", async (req, res) => {
  const genre = await Genre.findById(req.params.id);
  if (!genre) {
    res.status(404).send("Error 404 on get");
  } 
  res.send(genre);
});

router.put("/:id", async (req, res) => {
  const { error } = validateGenre(req.body);
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
});

router.delete("/:id", async (req, res) => {
  const genre = await Genre.findByIdAndRemove(req.params.id);
  if (!genre) {
    return res.status(404).send("Error 404 on delete");
  }
  res.send(genre);
});

function validateGenre(genre) {
  const schema = {
    name: Joi.string().min(3).required(),
  };
  return Joi.validate(genre, schema);
}

module.exports = router;
