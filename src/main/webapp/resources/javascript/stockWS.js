var wsocket;

function connect() {
    wsocket = new WebSocket("ws://localhost:8080/FeesBoek/stockWSEndPoint");
    wsocket.onmessage = onMessage;
}

function onMessage(evt) {
    var arraypv = evt.data.split("/");
    document.getElementById("price").innerHTML = arraypv[0];
    document.getElementById("volume").innerHTML = arraypv[1];
    document.getElementById("color").innerHTML = arraypv[2];

    document.getElementById("potato").style.background = arraypv[2];
}

function sendColor() {
    var color = document.getElementById("color").value;
    wsocket.send(color);
}

window.addEventListener("load", connect, false);