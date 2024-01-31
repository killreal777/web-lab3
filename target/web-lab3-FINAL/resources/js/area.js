//import table from "./table.js";
//because of jsf


const area = {
    clean : function () {
        removeElementsByClass("dot");
    },

    update : function () {
        area.clean();
        area.printAllDots();
    },

    printDot : function (x, y, r, isHit) {
        const centerCoordinate = 150;
        const dotOffsetX = getDotOffset(x, r);
        const dotOffsetY = getDotOffset(y, r);
        const dotCoordinateX = centerCoordinate + dotOffsetX;
        const dotCoordinateY = centerCoordinate - dotOffsetY;

        createDotHtml(dotCoordinateX, dotCoordinateY, isHit);
    },

    printAllDots : function () {
        const dotResults = table.getAllDotResults();
        const currentRadius = document.getElementById("check-form:r").value;

        for (const dot of dotResults) {
            area.printDot(dot.x.toString(), dot.y.toString(), currentRadius, dot.isHit);
        }
    }
}

//export default area;
//because of jsf


function removeElementsByClass(className){
    const elements = document.getElementsByClassName(className);
    while(elements.length > 0) {
        elements[0].parentNode.removeChild(elements[0]);
    }
}


function getDotOffset(coordinateValue, radiusValue) {
    const radiusOffset = 100;
    let dotOffset = coordinateValue / radiusValue * radiusOffset;
    return correctDotOffset(dotOffset);
}

function correctDotOffset(dotOffset) {
    const maxOffset = 149.5;
    const minOffset = -149.5;

    if (dotOffset > maxOffset) return maxOffset;
    if (dotOffset < minOffset) return minOffset;
    return dotOffset;
}


function createDotHtml(cx, cy, isHit) {
    const svg = document.getElementById("area-svg");
    const svgNS = "http://www.w3.org/2000/svg";
    const dot = document.createElementNS(svgNS, "circle");

    setCreatedDotAttributes(dot, cx, cy, isHit);
    svg.appendChild(dot);
}

function setCreatedDotAttributes(dot, cx, cy, isHit) {
    const r = "2.5";
    const styleClass = (isHit) ? "hit dot" : "fail dot";

    dot.setAttributeNS(null,"cx", cx);
    dot.setAttributeNS(null,"cy", cy);
    dot.setAttributeNS(null,"r", r);
    dot.setAttributeNS(null,"class", styleClass);
}
