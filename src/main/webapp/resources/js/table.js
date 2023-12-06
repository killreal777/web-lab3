const table = {
    getAllDotResults : function () {
        let results = [];
        let linesAmount = getLinesAmount();

        for (let i = 0; i < linesAmount; i++) {
            results.push(getDotResultByLineIndex(i));
        }

        return results;
    },

    getLastDotResult : function () {
        return getDotResultByLineIndex(0);
    }
}

//export default table;
//because of jsf


const xColumn = document.getElementsByClassName("x-column");
const yColumn = document.getElementsByClassName("y-column");
const resultColumn = document.getElementsByClassName("result-column");

function getLinesAmount() {
    return resultColumn.length;
}

function getDotResultByLineIndex(i) {
    let x = parseFloat(xColumn[i].innerHTML);
    let y = parseFloat(yColumn[i].innerHTML);
    let isHit = resultColumn[i].innerHTML === "true";

    return createDotResultDataObject(x, y, isHit)
}

function createDotResultDataObject(x, y, isHit) {
    return {
        "x" : x,
        "y" : y,
        "isHit" : isHit
    };
}
