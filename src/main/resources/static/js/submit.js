

(function(){
    "use strict"
    // Enum Declarations for State Management
    let display = "d-none";
    let layover = "Nonstop";
    let loader = document.getElementById("loading-screen");
    const DISPLAY = Object.freeze({
        NONE: "d-none",
        FLEX: "d-flex"
    });
    const TRIP_TYPE = Object.freeze({
        ROUNDTRIP: "roundtrip",
        ONEWAY: "onewaytrip"
    });
    const TRIP_PASSENGER = Object.freeze({
        ADULT: "adult",
        CHILD: "child"
    });
    const TRIP_CABIN = Object.freeze({
        ECONOMY: "economy",
        BUSINESS: "business"
    });
    let BASE = `https://api.flightapi.io`;
    // let KEY = `640f1b3ff75e113b18803e12`;
    let KEY = `6411ef78e055523b129e12bd`;

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
    function Hour12Time(militaryTime){
        const [hours, minutes] = militaryTime.split(':').map(Number);
        const isPM = hours >= 12;
        const hours12 = hours % 12 || 12;
        const time12 = `${hours12}:${minutes.toString().padStart(2, '0')} ${isPM ? 'PM' : 'AM'}`;
        return time12;
    }


    // ++++++++++++++++++++++ Functions End +++++++++++++++++++++++++++++++++












    document.addEventListener("DOMContentLoaded", ()=>{
        let form = document.getElementById("form");
        // console.log("form: ",form)
        form.addEventListener("submit", (evt)=>{
            evt.preventDefault();
            loader.style.display = "block"
            let event = [];
            for (let i = 0;i< evt.target.length-1;i++){

                event[i] = evt.target[i].value;
                console.log(`event: ${i}: `,evt.target[i].value);
            }
            let requestOptions = {
                method: 'GET',
                redirect: 'manual'
            };
            // \ ========== Trim and format for API ============== /
            if(event[3].includes(" ") || event[4].includes(" ")){
                event[3] = event[3].trim().replaceAll(" ", '-')
                event[4] = event[4].trim().replaceAll(" ", '-')
            }
            // \ ========== Trim and format for API ============== /


            // City 1
            fetch(`https://api.flightapi.io/iata/${KEY}?name=${event[3]}&type=airport`, requestOptions)
                .then(response => response.json())
                .then(airport1 => {

                    // City 2
                    fetch(`https://api.flightapi.io/iata/${KEY}?name=${event[4]}&type=airport`, requestOptions)
                        .then(response => response.json())
                        .then(airport2 => {
                            console.log("fetch2")
                            const dateObject = Object.freeze({
                                ONE_DATE: event[5],
                                TWO_DATE: `${event[5]}/${event[6]}`
                            });

                            // /======= Default PARAMS ======\
                            let DATE = dateObject.ONE_DATE;
                            let TRIP = TRIP_TYPE.ONEWAY;
                            let CABIN = TRIP_CABIN.ECONOMY;
                            // \======= Default PARAMS ======/

                            if (event[0] === TRIP_TYPE.ROUNDTRIP){
                                DATE = dateObject.TWO_DATE;
                                TRIP = TRIP_TYPE.ROUNDTRIP;
                                display = DISPLAY.FLEX
                            }
                            if(event[2] === TRIP_CABIN.BUSINESS){
                                CABIN = TRIP_CABIN.BUSINESS;
                            }

                            // Query
                            fetch(`${BASE}/${TRIP}/${KEY}/${airport1.data[0].iata}/${airport2.data[0].iata}/${DATE}/1/0/0/${CABIN}/USD`, requestOptions)
                                .then(response => response.json())
                                .then(result => {
                                    console.log("Status",result.status);
                                    if (result.status == 504) {
                                        alert("Sorry there are no flights.");
                                        loader.style.display = "none"
                                        // throw new Error('Sorry there are no flights');
                                    }
                                    // console.log("Airport1: ",airport1.data[0].iata)
                                    // console.log( "Airport2: ",airport2.data[0].iata)
                                    console.log(result)
                                    // let renderContainer = document.getElementById("render-container");
                                    // let stopOverCount = 0;
                                    let tranferArr = [];
                                    let roundtripArr = [];
                                    let search = [];
                                    for (let n = 0;n<result.airlines.length;n++){
                                        search.push({
                                            code:result.airlines[n].code,
                                            name:result.airlines[n].name
                                        });
                                    }
                                    let flightObj = {};
                                    let flightBackObj = {};


                                    if (TRIP === TRIP_TYPE.ONEWAY) {

                                        // FOR LOOP FOR ONEWAY TRIP
                                        for (let i = 0; i < result.legs.length; i++) {
                                            console.log("stopovers",result.legs[i].stopoversCount)
                                            if(result.legs[i].stopoversCount == 0 ){
                                                layover = "Nonstop"
                                            }else {
                                                layover = "layover: "+ result.legs[i].stopoversCount;
                                            }
                                            // need to add round trip
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
                                    } // end of if (TRIP === TRIP_TYPE.ONEWAY)

                                    let renderContainer = document.getElementById("render-container");

                                        let HTML = "";
                                    for (let i = 0; i<10;i++) {

                                        HTML +=
                                        `                                                                              
                                          <div class="tickets-cont d-flex ">
                <div class="ticket card-paper1">
                    <div class="info-cont">
                        <div class="info-row mb-4 border-bottom justify-content-between m-0">
                            <p>${tranferArr[i].cabin}</p>
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
                        <!-- +++++++++++++++++++ ONETRIP ++++++++++++++++++++++++++ -->
            
                        <!-- +++++++++++++++++++ ROUNDTRIP ++++++++++++++++++++++++++ -->
                        
                       <!-- +++++++++++++++++++ ROUNDTRIP ++++++++++++++++++++++++++ -->

                       


                    </div>
                    <!-- need to be in form  -->
                    <div class="buy-deal-cont">
                      
                        <div class="buy-deal-row">
                            <span class="fs-13" id="price">$${tranferArr[i].price}</span>
                        </div>
                        <div class="buy-deal-row">
                            <a href="booking.html"></a>
                            <form action="/create/checkout/session" method="POST">
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





                                    console.log(tranferArr)
                                    console.log(search);




                                }).catch(error => console.log(error))
        // fetch 2
        }).catch(error => {





            console.log('error', error)});

         // fetch 1
        console.log("fetch1")
    }).catch(error => console.log(error))











        })//form event










    }) // dom loaded
})();

//
// <div className="info-row">
//     <div className="info-column">
//         <img src="assets/img/UA.png" alt="">
//     </div>
//     <div className="info-column ms-3 flex-column justify-content-center">
//         <p className="responsive-font fw-bold">
//             <span id="flight-start-time-roundtrip">n</span>
//             -
//             <span id="flight-end-time-roundtrip">n</span>
//         </p>
//
//         <p id="airline-name-roundtrip">
//             n
//         </p>
//     </div>
//     <div className="info-column">
//         <p id="stopOver-type-roundtrip">Nonstop</p>
//     </div>
//     <div className="info-column ms-3 flex-column justify-content-center">
//
//         <p className="fs-13 fw-bold">
//             <span id="flight-duration-roundtrip">3h</span>
//         </p>
//
//         <p id="airport-names-cont-roundtrip">
//             <span id="airport1-roundtrip">airp</span>
//             -
//             <span id="airport2-roundtrip">airp</span>
//         </p>
//     </div>
// </div>