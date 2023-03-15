// let myHeaders = new Headers();
// myHeaders.append("Content-Type", "application/x-www-form-urlencoded"");
// myHeaders.append("Authorization", "Bearer AoFHSlg9KtEyxPUFmWwraHejbg6O");
// let urlencoded = new URLSearchParams();
// urlencoded.append("grant_type”, “client_credentials");
// urlencoded.append("client_id", "APME4obuvBeTqAqYbbIylpBqx0F9Vof6");
// urlencoded.append("client_secret", "BVLRoqFc88NfQBf1");

let thread = new Worker("../js/worker.js")


let requestOptions = {
    method: "POST",
    headers: {
        "Content-Type": "application/x-www-form-urlencoded",
        "Authorization": "Bearer AoFHSlg9KtEyxPUFmWwraHejbg6O"
    },
    body: {
        grant_type: "client_credentials",
        client_id: "APME4obuvBeTqAqYbbIylpBqx0F9Vof6",
        client_secret: "BVLRoqFc88NfQBf1"
    },
    redirect: "follow"
};
fetch("https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=PAR&maxPrice=200", requestOptions)
    .then(response => response.json() )
    .then(result => console.log(result) )
    .catch(error => console.log( "error", error) );