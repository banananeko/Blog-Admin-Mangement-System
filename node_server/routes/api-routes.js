const { v4: uuid } = require("uuid");
const express = require("express");
const router = express.Router();

const usersDao = require("../modules/users-dao.js");

let bodyParser = require('body-parser');
const { route } = require("./application-routes.js");

let newFileName;

router.use(bodyParser.json());

// Send login details
router.post("/api/login", async function (req, res) {
    const username = req.body.username;
    const password = req.body.password;

    // Find a matching user in the database
    const user = await usersDao.retrieveUserWithCredentials(username, password);
    // if there is a matching user...
    if (user) {
        // Auth success - give that user an authToken, save the token in a cookie, and redirect to the homepage.
        const authToken = uuid();
        user.authToken = authToken;
        await usersDao.updateUser(user);
        res.cookie("authToken", authToken);
        res.locals.user = user;
        res.cookie("user", user);

        res.status(204).json();
    }
    // Otherwise, if there's no matching user...
    else {
        // Auth fail
        res.locals.user = null;
        res.status(401).json();
    }
});

router.get("/api/logout", function (req, res) {
    res.clearCookie("authToken");
    res.clearCookie("user");

    res.locals.user = null;
    res.status(204).json();
});

router.get("/api/users", async function (req, res) {
    if (req.cookies["user"] && req.cookies["user"].isAdmin === 1) {
        const users = await usersDao.retrieveAllUsers();
        res.json(users);
    } else {
        res.status(401).json();
    }
});

router.get("/api/user", async function (req, res) {
    if (req.cookies["user"]) {
        const user = req.cookies["user"];
        res.json(user);
    } else {
        res.status(401).json();
    }
});

router.delete("/api/users/:userId", async function (req, res) {
    const userId = req.params.userId;
    if (res.locals.user && res.locals.user.isAdmin === 1) {
         await usersDao.deleteUser(userId);
        res.status(204).json();
    } else {
        res.status(401).json();
    }
});


module.exports = router;
``