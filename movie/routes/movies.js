const express = require("express");
const router = express.Router();
const { Movie, validate } = require("../models/movies");
const { Genre } = require("../models/genres");
const mongoose = require("mongoose");

router.get("/", async (req, res) => {
  const movie = await Movie.find().sort("title");
  res.send(movie);
});

router.post("/", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(400).send(error.details[0].message);
  }
  let movie = new Movie({
    title: req.body.title,
    genre: {
      _id: genre._id,
      name: genre.name,
    },
    numberInStocks: req.body.numberInStocks,
  });
  movie = await movie.save().catch((err) => {
    console.log("Error while posting", err);
  });

  res.send(movie);
});

router.get("/:id", async (req, res) => {
  const movie = await Movie.findById(req.params.id);
  if (!movie) {
    res.status(404).send("Error 404 on get");
  }
  res.send(movie);
});

router.put("/:id", async (req, res) => {
  const { error } = validate(req.body);
  if (error) {
    return res.status(404).send(error.details[0].message);
  }

  const movie = await Movie.findByIdAndUpdate(
    req.params.id,
    {
      title: req.body.title,
      genre: {
        _id: genre._id,
        name: genre.name,
      },
      numberInStocks: req.body.numberInStocks,
    },
    {
      new: true,
    }
  );

  if (!movie) {
    return res.status(404).send("Error 404 on PUT");
  }
  res.send(movie);
});

router.delete("/:id", async (req, res) => {
  const movie = await Movie.findByIdAndRemove(req.params.id);
  if (!movie) {
    return res.status(404).send("Error 404 on delete");
  }
  res.send(movie);
});

module.exports = router;
