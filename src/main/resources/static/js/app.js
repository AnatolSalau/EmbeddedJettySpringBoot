console.log("Hello from app.js")

ws = new WebSocket("ws://127.0.0.1:8080/pong");

ws.onopen = function (ev) {
    action("open connection")
    console.log("open connection")
}

ws.onmessage = function (ev) {
    action(ev.data);
}

ws.onclose = function (ev) {
    action("close connection")
    console.log("close connection")
}

ws.onerror = function (ev) {
    action("error connection")
    console.log("error connection")
}

function action(message) {
    let output = document.getElementById("stack");
    let newParagraph = document.createElement("p");
    newParagraph.appendChild(document.createTextNode(message));
    output.appendChild(newParagraph);
}

function ping() {
    let message = document.getElementById('message').value;
    action("sent " + message);
    ws.send(message);
}