(function () {
    "use strict"
    // Enum Declarations for State Management
    let BASE = `https://api.flightapi.io`;
    let KEY = `64138433f75e113b18804e8c`;
    let display = "d-none";
    let layover = "Nonstop";
    let submit = document.getElementById("submit");
    let loader = document.getElementById("loading-screen");
    let alertBar = document.getElementById("alert");
    let spadesImg = document.getElementById("vectorImg");
    let CABIN = "Economy";
    let TRIP = "onewaytrip"
    let LIMIT = 10;
    let renderContainer = document.getElementById("render-container");
    let searched = false;

    const DISPLAY = Object.freeze({
        NONE: "d-none",
        FLEX: "d-flex"
    });
    const alert = Object.freeze({
        NOT_EXIST: "Sorry there are no flights for this search",
        UNDEFINED: "Cannot read properties of undefined"
    });
    const TRIP_CABIN = Object.freeze({
        ECONOMY: "Economy",
    });



// ++++++++++++++++++++++ Functions +++++++++++++++++++++++++++++++++
    function mergeSort(arr) {
        if (arr.length <= 1) {
            return arr;
        }
        const mid = Math.floor(arr.length / 2);
        const left = arr.slice(0, mid);
        const right = arr.slice(mid);
        return merge(mergeSort(left), mergeSort(right));
    }

    function merge(left, right) {
        let result = [];
        while (left.length && right.length) {
            if (left[0].price >= right[0].price) {
                result.push(left.shift());
            } else {
                result.push(right.shift());
            }
        }
        while (left.length) {
            result.push(left.shift());
        }
        while (right.length) {
            result.push(right.shift());
        }
        return result;
    }
    function shuffleArray(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
        return array;
    }

    function Hour12Time(militaryTime) {

        const [hours, minutes] = militaryTime.split(':').map(Number);
        const isPM = hours >= 12;
        const hours12 = hours % 12 || 12;
        const time12 = `${hours12}:${minutes.toString().padStart(2, '0')} ${isPM ? 'PM' : 'AM'}`;
        return time12;
    }
     // ++++++++++++++++++++++ Functions End +++++++++++++++++++++++++++++++++||

    let form = document.getElementById("form");
    // Form Event
    form.addEventListener("submit", (evt) => {
        alertBar.classList.remove("slide-down");
        // Loader flex
        loader.style.display = "flex";
        spadesImg.style.display = "none";
        if (searched === true) {
            let tickets = document.querySelectorAll(".ticket");
            tickets.forEach(ticket => {
                ticket.remove()
            })
        }

        evt.preventDefault();
        let event = [];
        try {

            for (let i = 0; i < evt.target.length - 1; i++) {
                if (evt.target[i].value === ""){
                    throw Error("Please Enter Valid input")
                }
                event[i] = evt.target[i].value;
                console.log(`typeof event: ${i}: `, evt.target[i].value);
            }
        } catch (error){
            alertBar.innerText = error.message;
            alertBar.classList.add("slide-down");
        }

        let requestOptions = {
            method: 'GET',
            redirect: 'manual'
        };
        // \ ========== Trim and format for API ============== /
        if (event[3].includes(" ")) {
            event[3] = event[3].trim().replaceAll(" ", '-').toLowerCase()
            event[4] = event[4].trim().replaceAll(" ", '-').toLowerCase()
        }
        // \ ========== Trim and format for API ============== /

        // City 1
        fetch(`https://api.flightapi.io/iata/${KEY}?name=${event[3]}&type=airport`, requestOptions)
            .then(response => response.json())
            .then(airport1 => {
                console.log("fetch1 status:", airport1.status)

                // City 2
                fetch(`https://api.flightapi.io/iata/${KEY}?name=${event[4]}&type=airport`, requestOptions)
                    .then(response => response.json())
                    .then(airport2 => {
                        console.log("fetch2")
                        console.log("Status: ",airport2.message)
                        const dateObject = Object.freeze({
                            ONE_DATE: event[5]
                        });

                        // /======= Default PARAMS ======\
                        let DATE = dateObject.ONE_DATE;
                        // \======= Default PARAMS ======/

                        // Query
                        fetch(`${BASE}/${TRIP}/${KEY}/${airport1.data[0].iata}/${airport2.data[0].iata}/${DATE}/1/0/0/${CABIN}/USD`, requestOptions)
                            .then(response => response.json())
                            .then(result => {
                                renderContainer.innerHTML = "";
                                console.log("Status", result.status);
                                if (result.status !== 200) {
                                    if(result.status === 404){
                                        alertBar.innerText = alert.NOT_EXIST;
                                        alertBar.classList.add("slide-down");
                                    }
                                    if (result.status === 504) {
                                        alertBar.innerText = alert.NOT_EXIST;
                                        alertBar.classList.add("slide-down");
                                        loader.style.display = "none"
                                    }
                                }
                                let tranferArr = [];
                                let search = [];
                                for (let n = 0; n < result.airlines.length; n++) {
                                    search.push({
                                        code: result.airlines[n].code,
                                        name: result.airlines[n].name
                                    });
                                }
                                let flightObj = {};
                                // FOR LOOP FOR ONEWAY TRIP
                                for (let i = 0; i < LIMIT; i++) {
                                    if (result.legs[i].stopoversCount !== undefined) {
                                        if (result.legs[i].stopoversCount === 0) {
                                            layover = "Nonstop"
                                        } else {
                                            layover = "layover: " + result.legs[i].stopoversCount;
                                        }
                                    }
                                    flightObj = {
                                        departureTime: result.legs[i].departureTime,
                                        arrivalTime: result.legs[i].arrivalTime,
                                        departureAirport: result.legs[i].departureAirportCode,
                                        arrivalAirport: result.legs[i].arrivalAirportCode,
                                        duration: result.legs[i].duration,
                                        layover: layover,
                                        price: result.fares[i].price.totalAmountUsd,
                                        cabin: CABIN,
                                        trip: TRIP,
                                        airline: []
                                    }
                                    tranferArr.push(flightObj);
                                    result.legs[i].airlineCodes.forEach(airlineCode => {
                                        for (let z = 0; z < search.length; z++) {
                                            if (airlineCode === search[z].code) {
                                                flightObj.airline.push(search[z].name);
                                            }
                                        }
                                    }) // end of forEach
                                } // end of for loop
                                tranferArr = shuffleArray(tranferArr);
                                let sh = [1, 2, 3, 4]
                                console.log("sh : ", shuffleArray(sh));

                                let HTML = "";
                                for (let i = 0; i < 10; i++) {

                                    HTML +=
                                        // Template literal starts
                                        `                                                                              
                                          <div class="tickets-cont d-flex ">
                <div class="ticket card-paper1">
                    <div class="info-cont">
                        <div class="info-row mb-4 border-bottom justify-content-between m-0">
                            <p>${CABIN}</p>
                        </div>
                        <!-- +++++++++++++++++++ ONETRIP ++++++++++++++++++++++++++ -->
                        <div class="info-row">
                            <div class="info-column">
                                <ion-icon class="fs-12" name="airplane-sharp"></ion-icon>
                            </div>
                            <div class="info-column ms-3 flex-column justify-content-center">
                                <p class="responsive-font fw-bold">
             
                                    <span id="flight-start-time-oneway">${Hour12Time(tranferArr[i].departureTime)}</span>
                                    -
                                    <span id="flight-end-time-oneway">${Hour12Time(tranferArr[i].arrivalTime)}</span>
                                </p>
                                <p id="airline-name-oneway">
                                   ${tranferArr[i].airline[0]}
                                </p>
                            </div>
                            <div class="info-column">
                                <p id="stopOver-type-oneway">${layover}</p>
                            </div>
                            <div class="info-column ms-3 flex-column justify-content-center">
                                <p id="flight-duration-oneway" class="fs-15 fw-bold">
                                    ${tranferArr[i].duration}
                                </p>
                                <p id="airport-names-cont-oneway">
                                    <span class="airport" id="airport1-oneway">${tranferArr[i].departureAirport}</span>
                                    -
                                    <span class="airport" id="airport2-oneway">${tranferArr[i].arrivalAirport}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <!-- need to be in form  -->
                    <div class="buy-deal-cont d-flex justify-content-center">

                         <div class="buy-deal-row mb-3">
                            <span class="fs-13" id="price">$${tranferArr[i].price.toPrecision(5)}</span>
                        </div>
                        <div class="buy-deal-row">
                            <a href="booking.html"></a>
                            <form action="/checkout" method="GET">
                            <input type="hidden"  class="d-none" name="departureTime" value='${Hour12Time(tranferArr[i].departureTime)}'>
                             <input type="hidden"  class="d-none" name="arrivalTime" value='${Hour12Time(tranferArr[i].arrivalTime)}'>
                              <input type="hidden"  class="d-none" name="duration" value='${tranferArr[i].duration}'>
                               <input type="hidden"  class="d-none" name="cabin" value='${tranferArr[i].departureAirport}'>
                                <input type="hidden" class="d-none"  name="arrivalAirport" value='${tranferArr[i].arrivalAirport}'>
                                 <input type="hidden"  class="d-none" name="price" value='$${tranferArr[i].price}'>
                                  <input type="hidden"  class="d-none" name="airline" value='${tranferArr[i].airline[0]}'>
                                 <input type="hidden"  class="d-none" name="cabin" value='${tranferArr[i].cabin}'>        
                                   <button class="btn-buy fw-bold">Get Ticket
                                <ion-icon name="paper-plane-outline"></ion-icon>
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>                                                                                                                                                         
                                        `// html end
                                } // end of loop

                                renderContainer.innerHTML = HTML;
                                submit.setAttribute("disabled", false)
                                submit.removeAttribute("disabled");
                                searched = true;


                                console.log(tranferArr)
                                console.log("search: ", search);

                                loader.style.display = "none";

                            // fetch 3 Query
                            }).catch(error => {
                            if(error.message !== FETCH_STATUS){
                                alertBar.innerText = alert.NOT_EXIST;
                                alertBar.classList.add("slide-down");
                            }
                                console.log(error)

                            })
                        // fetch 2
                    }).catch(error => {

                    if (error.message.includes(alert.UNDEFINED)) {
                        alertBar.innerHTML = alert.NOT_EXIST;
                        alertBar.classList.add("slide-down");
                    }
                    });
                // fetch 1
                console.log("fetch1")
            }).catch(error => {
            if (error.message.includes(alert.UNDEFINED)) {
                alertBar.innerHTML = alert.NOT_EXIST;
                alertBar.classList.add("slide-down");
                submit.setAttribute("disabled", false);

            }
            loader.style.display = "none";
        })
    })//form event
})();