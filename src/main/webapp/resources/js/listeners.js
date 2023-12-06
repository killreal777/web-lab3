//import click from "./click.js";
//because of jsf

const area = document.getElementById("area-svg");
const xInput = document.getElementById("check-form:x");
const yInput = document.getElementById("check-form:y");
const checkButton = document.getElementById("check-form:check-button");

area.onclick = function(event) {
    let areaDot = click.getAreaDot(event);
    if (areaDot.r != null) {
        xInput.value = areaDot.x;
        yInput.value = areaDot.y;
    }
    checkButton.click();
};



//import dots from "./dots.js";
//import table from "./table.js";
//because of jsf

document.getElementById("check-form:r").onchange = function(event) {
    dots.deleteAllDots();
    printAllDots()
}

document.getElementById("results-table").onclick = function(event) {
    dots.deleteAllDots();
    printAllDots();
}

window.onload = function() {
    printAllDots();
};



function printAllDots() {
    const dotResults = table.getAllDotResults();
    const currentRadius = document.getElementById("check-form:r").value;

    for (const dot of dotResults) {
        dots.printDot(dot.x.toString(), dot.y.toString(), currentRadius, dot.isHit);
    }
}

