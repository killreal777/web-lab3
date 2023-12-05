// listener

const areaElement = document.getElementById("area-svg");

const xValue = document.getElementById("check-form:x");
const yValue = document.getElementById("check-form:y");
const checkButton = document.getElementById("check-form:check-button");

areaElement.onclick = function(event) {
    let data = getAreaDotClickData(event);
    if (data.r != null) {
        xValue.value = data.x;
        yValue.value = data.y;
    }
    checkButton.click();
};



// click

const rValue = document.getElementById("check-form:r");
const center = document.getElementById("dot-center").getBoundingClientRect();
const area = areaElement.getBoundingClientRect();
const scale = area.width / 3;


function getAreaDotClickData(clickEvent) {
    let r = rValue.value;
    let x = (clickEvent.pageX - center.x) / scale * r;
    let y = (center.y - clickEvent.pageY) / scale * r;

    x = math.roundTwoSigns(x);
    y = math.roundTwoSigns(y);

    return createAreaDotClickDataObject(r, x, y);
}

function createAreaDotClickDataObject(r, x, y) {
    return {
        "r" : r,
        "x" : x,
        "y" : y
    };
}



// math

const math = {
    roundTwoSigns : function (number) {
        return Math.round(number * 100) / 100;
    }
};
