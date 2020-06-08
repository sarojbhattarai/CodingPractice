const mongoose = require("mongoose");
const express = require("express");
const Joi = require("joi");
const app = express();
const genres = require("./routes/genres");
app.use(express.json());

app.use("/routes/genres", genres);

mongoose
  .connect("mongodb://localhost/movies", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("Connected to MongoDB");
  })
  .catch((err) => {
    console.log("Error", err);
  });

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`Listening to ${PORT}...`);
});
