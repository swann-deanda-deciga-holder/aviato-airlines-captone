window.addEventListener('load',()=>{
    let plane = document.getElementById('plane');
    plane.classList.add('d-none');
    window.addEventListener('scroll',  () =>{
        let currentPosition = window.pageYOffset;
        let targetPosition = 864.5;
        // todo remove phone when over the footer
        let endPosition = 10000;
        console.log("Window pos: ",currentPosition);
        if(currentPosition == 0){
            plane.classList.add("d-none");
        }

        if (currentPosition >= targetPosition) {
            // code to run when the page has been scrolled to the target position
            plane.classList.remove("d-none");
            plane.classList.add("d-flex");

            // phone.classList.add("show");
        }else{
            plane.classList.remove("d-flex");

            // phone.classList.remove("show");
        }
        if (currentPosition >= endPosition){
            plane.classList.remove("d-flex");
            plane.classList.add("d-none");



        }
        // if (currentPosition >= endPosition) {
        //     plane.classList.remove("show");
        //     plane.classList.add("d-none");
        // }

    });

})



