(function(){
    "use strict"

    let tripType = document.getElementById("trip-type")
    let round = document.getElementById("round")
    let oneway = document.getElementById("oneway")
    let submit = document.getElementById("form-submit")

    let dates = document.getElementById("dates")

    let div = document.createElement("div");
    div.classList.add("input-group")
    div.classList.add("mb-3")
    div.classList.add("w-25")
    div.classList.add("searchbar-w")
    let span = document.createElement("span")
    span.innerText = "Date"
    span.classList.add("input-group-text");
    let input = document.createElement("input")
    input.classList.add("form-control")
    input.setAttribute("type","date");
    input.setAttribute("required", "true");

    div.appendChild(span);
    div.appendChild(input);

    tripType.addEventListener("change", ()=>{
        if (tripType.value == "roundtrip"){
            dates.insertBefore(div,submit)
        }else{
            if (tripType.value == "oneway")
                dates.removeChild(div)
        }
    })


    tripType.addEventListener("click",(e)=>{
    })






})();