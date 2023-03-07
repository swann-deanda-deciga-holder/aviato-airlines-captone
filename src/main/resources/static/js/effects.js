(function(){
    "use strict"
    let like = document.getElementById("like");
    like.style.color = "#000000"

    like.addEventListener("click", ()=>{
        if(like.style.color == "red"){
            like.style.color = "#000000"
        }else{
            like.style.color = "red"

        }

    })
    // let form = document.getElementById("form");
    // form.addEventListener("submit", (e)=>{
    //     e.preventDefault();
    // })
    const observer = new IntersectionObserver((entries)=>{
        entries.forEach(entry => {
            if (entry.isIntersecting){
                entry.target.classList.add("show");
            }
            // else{
            //     entry.target.classList.remove("show");
            // }
        });
    });

    const hiddenElements = document.querySelectorAll(".hidden");
    hiddenElements.forEach(el => {
        observer.observe(el);
    })







})();

