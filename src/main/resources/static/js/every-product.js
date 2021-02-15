function fetchData(){
    console.log("1. fetchData")
    // this will eventually be an endpoint from Spring Boot
    fetch('/products/all')
        .then((resp) => resp.json())
        .then(function(data) {
            console.log("2. receive data")
            console.log(data);
        })
        .catch(function(error) {
            console.log(error);
        });
}

window.onload = () => {
    fetchData()
}