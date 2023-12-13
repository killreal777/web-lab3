const table = {
    getAllDotResults : function () {
        let results = [];
        let rowsAmount = getRowsAmount();

        for (let rowIndex = 0; rowIndex < rowsAmount; rowIndex++) {
            results.push(getDotResultByRowIndex(rowIndex));
        }

        return results;
    },

    getLastDotResult : function () {
        return getDotResultByRowIndex(0);
    }
}

//export default table;
//because of jsf

const startTimeColumn = document.getElementsByClassName("start-time-column");
const xColumn = document.getElementsByClassName("x-column");
const yColumn = document.getElementsByClassName("y-column");
const resultColumn = document.getElementsByClassName("result-column");

function getRowsAmount() {
    return resultColumn.length;
}

function getDotResultByRowIndex(i) {
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
