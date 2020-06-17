const mongoose = require("mongoose");
const express = require("express");
const Joi = require("joi");
Joi.objectId = require("joi-objectid")(Joi);
const app = express();
const genres = require("./routes/genres");
const customers = require("./routes/customers");
const rentals = require("./routes/rentals");
const movies = require("./routes/movies");
const users = require("./routes/users");
const auth = require("./routes/auth");
const config = require('config');

// if (!config.get('jwtPrivateKey')){
//   console.error('ERROR!! JWT KEY IS NOT DEFINED');
//   process.exit(1);
// }
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

app.use(express.json());

app.use("/routes/genres", genres);
app.use("/routes/customers", customers);
app.use("/routes/movies", movies);
app.use("/routes/rentals", rentals);
app.use("/routes/users", users);
app.use("/routes/auth", auth);

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`Listening to ${PORT}...`);
});
