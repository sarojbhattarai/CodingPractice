const express = require("express");
const app = express();
const winston = require("winston");

require("./startup/logging");
require("./startup/validation");
require("./startup/routes")(app);
require("./startup/db")();

const PORT = process.env.PORT || 3000;
const logger = winston.createLogger({
    transports: [
        new winston.transports.Console()
    ]
});

app.listen(PORT, () => logger.info(`Listening to ${PORT}...`));
