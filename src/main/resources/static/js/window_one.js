"use strict"

import User from "./User.js";

window.addEventListener("load", main);

function main (event) {
    console.log("Hello from js")
    let userOne = new User("01","First", "Second");
}