


function refreshArea() {
    cleanArea();
    printAllDots();
}


function printAllDots() {
    const xValues = document.getElementsByClassName("x-column");
    const yValues = document.getElementsByClassName("y-column");
    const resultValues = document.getElementsByClassName("result-column");
    const r = document.getElementById("check-form:r").value;

    for (let i = 0; i < resultValues.length; i++) {
        let x = parseFloat(xValues[i].innerHTML);
        let y = parseFloat(yValues[i].innerHTML);
        let isHit = resultValues[i].innerHTML === "true";
        printDot(x, y, r, isHit);
    }
}

function printDot(x, y, r, isHit) {
    const centerCoordinate = 150;
    const dotOffsetX = getDotOffset(x, r);
    const dotOffsetY = getDotOffset(y, r);
    const dotCoordinateX = centerCoordinate + dotOffsetX;
    const dotCoordinateY = centerCoordinate - dotOffsetY;
    createDotHtml(dotCoordinateX, dotCoordinateY);
}

function createDotHtml(cx, cy, isHit) {
    const svg = document.getElementById("area-svg");
    const svgNS = "http://www.w3.org/2000/svg";
    const newCircle = document.createElementNS(svgNS, "circle");

    newCircle.setAttributeNS(null,"cx",cx);
    newCircle.setAttributeNS(null,"cy",cy);
    newCircle.setAttributeNS(null,"r","2.5");
    if (isHit)
        newCircle.setAttributeNS(null,"class","hit-dot");
    else
        newCircle.setAttributeNS(null,"class","fail-dot");
    svg.appendChild(newCircle);
}

function cleanArea() {
    document.getElementById("hit-dot").remove();
    document.getElementById("fail-dot").remove();
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
