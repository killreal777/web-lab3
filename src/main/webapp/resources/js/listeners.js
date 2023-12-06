//import click from "./click.js";
//because of jsf

const xInput = document.getElementById("check-form:x");
const yInput = document.getElementById("check-form:y");
const checkButton = document.getElementById("check-form:check-button");

document.getElementById("area-svg").onclick = function(event) {
    let areaDot = click.getAreaDot(event);
    if (areaDot.r != null) {
        xInput.value = areaDot.x;
        yInput.value = areaDot.y;
    }
    checkButton.click();
};


//import dots from "./area.js";
//because of jsf

document.getElementById("check-form:r").onchange = function(event) {
    area.update();
}

document.getElementById("results-table").onclick = function(event) {
    area.update();
}

window.onload = function() {
    area.update();
};
