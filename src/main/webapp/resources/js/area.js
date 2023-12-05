import validators from "./validators.js";

const area = {
    addDot : function (dataJson) {

        let rValue = dataJson["r"];
        let xValue = dataJson["x"];
        let yValue = dataJson["y"];
        //printDot(xValue, yValue, rValue);



        let hitDot = $("#hit-dot");

        let centerCoordinate = 150;

        let dotOffsetX = getDotOffset(xValue, rValue);
        let dotOffsetY = getDotOffset(yValue, rValue);

        let dotCoordinateX = centerCoordinate + dotOffsetX;
        let dotCoordinateY = centerCoordinate - dotOffsetY;

        hitDot.attr("cx", dotCoordinateX);
        hitDot.attr("cy", dotCoordinateY);


    },

    refresh : function () {
        cleanArea();
        printAllDots();
    }
}

export default area;


function getCurrentRadius() {
    return $("#r").val();
}



const dots = [];

function addDot(xValue, yValue) {
    const dot = {x: xValue, y: yValue}
    dots.add(dot)
}

function printAllDots() {
    const radius = getCurrentRadius();

    for (let dot in dots)
        printDot(dot.x, dot.y, radius);
}

function printDot(x, y, r) {
    const centerCoordinate = 150;
    const dotOffsetX = getDotOffset(x, r);
    const dotOffsetY = getDotOffset(y, r);
    const dotCoordinateX = centerCoordinate + dotOffsetX;
    const dotCoordinateY = centerCoordinate - dotOffsetY;
    createDotHtml(dotCoordinateX, dotCoordinateY);
}

function createDotHtml(cx, cy) {
    const svg = document.getElementById("area-svg");
    const svgNS = "http://www.w3.org/2000/svg";
    const newCircle = document.createElementNS(svgNS, "circle");

    newCircle.setAttributeNS(null,"cx",cx);
    newCircle.setAttributeNS(null,"cy",cy);
    newCircle.setAttributeNS(null,"r","2.5");
    newCircle.setAttributeNS(null,"class","hit-dot");
    svg.appendChild(newCircle);
}

function cleanArea() {
    $(".hit-dot").remove();
}


function getDotOffset(coordinateValue, radiusValue) {
    const radiusOffset = 100;
    const maxOffset = 149.5;
    const minOffset = -149.5;
    let dotOffset = coordinateValue / radiusValue * radiusOffset;

    if (dotOffset > maxOffset)
        dotOffset = maxOffset;
    if (dotOffset < minOffset)
        dotOffset = minOffset;

    return dotOffset;
}
