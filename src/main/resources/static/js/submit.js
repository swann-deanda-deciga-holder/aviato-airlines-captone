(function(){
    "use strict"
    // Enum Declarations for State Management
    const TRIP_TYPE = Object.freeze({
        ROUNDTRIP: "roundtrip",
        ONEWAY: "oneway"
    });
    const TRIP_PASSENGER = Object.freeze({
        ADULT: "adult",
        CHILD: "child"
    });
    const TRIP_CLASS = Object.freeze({
        ECONOMY: "economy",
        BUSINESS: "business"
    });

    document.addEventListener("DOMContentLoaded", ()=>{
        let form = document.getElementById("form");
        console.log("form: ",form)
        form.addEventListener("submit", (evt)=>{
            evt.preventDefault();
            for (let i = 0;i< evt.target.length-1;i++){
                console.log(evt.target[i].value);
            }
        })//form event










    }) // dom loaded
})();// IIFE