
let passenger = document.createElement("div");
passenger.classList.add("d-flex");
passenger.classList.add("gap-2");
passenger.classList.add("flex-wrap");
// passenger.classList.add("dol");
// passenger.classList.add("blu");
passenger.classList.add("justify-content-center");
passenger.classList.add("justify-content-sm-start");
passenger.classList.add("justify-content-md-start");
passenger.classList.add("justify-content-lg-start");

let title = document.createElement("div");
title.classList.add("w-100");
title.classList.add("d-flex");
title.classList.add("justify-content-between");
title.classList.add("align-items-center");

let p = document.createElement("p");
p.innerText = "Passenger 2";
let trash = document.createElement("ion-icon");

trash.style.fontSize = "24px";
trash.style.cursor = "pointer";
trash.setAttribute("name", "trash-outline");
title.appendChild(p);
title.appendChild(trash);

let firstNameInput = document.createElement("div");
firstNameInput.classList.add("mb-3");
let label1 = document.createElement("label");
label1.setAttribute("for", "firstname");
label1.setAttribute("class", "form-label");
label1.innerText = "First Name";
let inputFirstName = document.createElement("input");
inputFirstName.setAttribute("type", "text");
inputFirstName.required = true;
inputFirstName.setAttribute("class", "form-control");
firstNameInput.appendChild(label1);
firstNameInput.appendChild(inputFirstName);

let lastNameInput = document.createElement("div");
lastNameInput.classList.add("mb-3");
let label2 = document.createElement("label");
label2.setAttribute("for", "lastname");
label2.classList.add("form-label");
label2.innerText = "Last Name";
let inputLastName = document.createElement("input");
inputLastName.setAttribute("type", "text");
inputLastName.required = true;
inputLastName.classList.add("form-control");
lastNameInput.appendChild(label2);
lastNameInput.appendChild(inputLastName);

let passengerType = document.createElement("div");
passengerType.classList.add("mb-3");
let label3 = document.createElement("label");
label3.setAttribute("for", "passengerType");
label3.classList.add("form-label");
label3.innerText = "Passenger Type";
let inputPassengerType = document.createElement("input");
inputPassengerType.setAttribute("type", "text");
inputPassengerType.classList.add("form-control");
passengerType.appendChild(label3);
passengerType.appendChild(inputPassengerType);

passenger.appendChild(title);
passenger.appendChild(firstNameInput);
passenger.appendChild(lastNameInput);
passenger.appendChild(passengerType);

function isNull(value) {
    return value == null;
}
function isNumeric(value) {
    return !isNaN(parseInt(value));
}
function isString(value) {
    return typeof value == "String";
}

function AddPassenger(checkoutForm, paymentSection) {
    try {
        if (isNull(checkoutForm)) {
            throw new Error("checkoutForm is Null");
        }
        if (isNull(paymentSection)) {
            throw new Error("paymentSection is null");
        }
    } catch (err) {
        console.error(err);
    }
    passenger.setAttribute("id", `passenger2`);
    checkoutForm.insertBefore(passenger, paymentSection);
}

function removeElement(elem){
    elem.remove();
    // let elem = document.getElementById(`${id}`);
}


document.addEventListener("DOMContentLoaded", () => {

    let checkoutForm = document.getElementById("checkout-form");
    let addPassenger = document.getElementById("addPassenger");
    let paymentSection = document.getElementById("payment-section");

    addPassenger.addEventListener("click", () => {
        let webElement = document.getElementById("passenger2");
        if (webElement != null ) {
            alert("STOP You can only purchase for 2 passengers at a time ");
        }

        AddPassenger(checkoutForm, paymentSection);
        trash.addEventListener("click", ()=>{
            passenger.remove();

        });

    });

}); // end of DOMContentLoaded

