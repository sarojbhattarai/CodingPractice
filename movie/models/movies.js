const Joi = require("joi");
const mongoose = require("mongoose");
const { genreSchema } = require("./genres");

const movieSchema = new mongoose.Schema({
  title: {
    type: String,
    minlength: 1,
    maxlength: 255,
    trim: true,
    required:true
  },
  genre: {
    type: genreSchema,
    required: true,
  },
  numberInStocks: {
    type: Number,
    required: true,
    min: 0,
    max: 140,
  },
});

const Movie = mongoose.model("Movie", movieSchema);

function validateMovie(movie) {
  const schema = {
    title: Joi.string().min(1).max(255).required(),
    genreId: Joi.string().required(),
    numberInStocks: Joi.number().min(0).max(140).required(),
  };
  return Joi.validate(movie, schema);
}

module.exports.Movie = Movie;
module.exports.validate = validateMovie;
