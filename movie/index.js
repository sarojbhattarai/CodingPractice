const express = require("express");
const Joi = require('joi');
const app = express();
const genres = require("./routes/genres");
app.use(express.json());

app.use("/routes/genres", genres);

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`Listening to ${PORT}...`);
});
