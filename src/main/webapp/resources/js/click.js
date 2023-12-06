//import math from "./math.js";
//because of jsf

const radius = document.getElementById("check-form:r");
const centerRect = document.getElementById("dot-center").getBoundingClientRect();
const areaRect = document.getElementById("area-svg").getBoundingClientRect();
const scale = areaRect.width / 3;

const click = {
    getAreaDot : function (clickEvent) {
        let r = radius.value;
        let x = (clickEvent.pageX - centerRect.x) / scale * r;
        let y = (centerRect.y - clickEvent.pageY) / scale * r;

        x = math.roundTwoSigns(x);
        y = math.roundTwoSigns(y);

        return createAreaDotDataObject(r, x, y);
    }
}

//export default click;
//because of jsf

function createAreaDotDataObject(r, x, y) {
    return {
        "r" : r,
        "x" : x,
        "y" : y
    };
}
