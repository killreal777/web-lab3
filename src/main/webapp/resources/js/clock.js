const clock = document.getElementById("clock");
const updateTimeSec = 1;

function showCurrentDateTime() {
    const timeout = updateTimeSec * 1000;
    clock.innerText = currentDateTimeToString();
    setTimeout(function(){ showCurrentDateTime() }, timeout);
}

showCurrentDateTime();


function currentDateTimeToString() {
    let currentDateTime = new Date();
    return dateTimeToString(currentDateTime)
}

function dateTimeToString(date) {
    return timeToString(date) + "\n" + dateToString(date);
}

function timeToString(date) {
    let hour = insertLeadingZeros(date.getHours());
    let min = insertLeadingZeros(date.getMinutes());
    let sec = insertLeadingZeros(date.getSeconds());
    return hour + ":" + min + ":" + sec;
}

function dateToString(date) {
    let day = insertLeadingZeros(date.getDate());
    let month = insertLeadingZeros(date.getMonth() + 1);
    let year = insertLeadingZeros(date.getFullYear());
    return day + "." + month + "." + year;
}

function insertLeadingZeros(number) {
    return (number < 10) ? ("0" + number) : (number);
}
