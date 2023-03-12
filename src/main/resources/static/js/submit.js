(function(){
    "use strict"

    document.addEventListener("DOMContentLoaded", ()=>{
        let form = document.getElementById("form");
        console.log("form: ",form)




        form.addEventListener("submit", (evt)=>{
            evt.preventDefault();
            for (let i = 0;i< evt.target.length;i++){
                console.log(evt.target[i].value);
            }
        })//form event










    }) // dom loaded
})();// IIFE