const mongoose = require("mongoose");
const express = require("express");
const app = express();
const students = require("./api/routes/students");
const departments = require("./api/routes/departments");

app.use(express.json());
mongoose
  .connect("mongodb://localhost/ncit", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useCreateIndex: true,
  })
  .then(console.log("Connected to MongoDB"));

app.use("/students", students);
app.use("/departments", departments);

const PORT = process.env.port || 3000;
app.listen(PORT, () => `Listening to port ${PORT}...`);
