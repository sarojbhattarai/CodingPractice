const winston = require("winston");
const mongoose = require("mongoose");


const logger = winston.createLogger({
  transports: [
      new winston.transports.Console()
  ]
});

module.exports = function () {
  mongoose
    .connect("mongodb://localhost/movies", {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      useCreateIndex:true
    })
    .then(() => logger.info("Connected to MongoDB"));
};
