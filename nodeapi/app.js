const express = require("express");
const bodyParser = require("body-parser");
const app = express();
const morgan = require("morgan");
const mongoose = require("mongoose");

const productRoutes = require("./api/routes/products");
const orderRoutes = require("./api/routes/orders");

//It handles login
app.use(morgan("dev"));

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

//routes
app.use("/products", productRoutes);
app.use("/orders", orderRoutes);

mongoose
  .connect(
    "mongodb+srv://sarojshop:" +
      process.env.Password +
      "@cluster0-r5zq7.mongodb.net/test?retryWrites=true&w=majority",
    { useNewUrlParser: true, useUnifiedTopology: true }
  )
  .then(() => console.log("Connect to MongoDB.."))
  .catch((err) => console.error("Could not connect to MongoDB..", err));

//error handling

app.use((req, res, next) => {
  const error = new Error(" NOT FOUND ERROR 404");
  error.status = 404;
  //transfers error to next middleware. Where database error can also be handled (if present)
  next(error);
});

app.use((error, req, res, next) => {
  res.status(error.status || 500).json({
    message: error.message,
  });
});

module.exports = app;
