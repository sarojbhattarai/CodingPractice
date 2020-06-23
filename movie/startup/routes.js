const error = require("../middleware/error");
const express = require("express");
const genres = require("../routes/genres");
const customers = require("../routes/customers");
const rentals = require("../routes/rentals");
const movies = require("../routes/movies");
const users = require("../routes/users");
const auth = require("../routes/auth");

module.exports = function (app) {
  app.use(express.json());
  app.use("/routes/genres", genres);
  app.use("/routes/customers", customers);
  app.use("/routes/movies", movies);
  app.use("/routes/rentals", rentals);
  app.use("/routes/users", users);
  app.use("/routes/auth", auth);
  app.use(error);
};
