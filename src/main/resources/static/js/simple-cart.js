class Cart {
    constructor(){
        // this is the constructor
    }

    addItem(item_json){
        // set the item by sku
        localStorage.setItem(localStorage.length, item_json);
        // localStorage.setItem(JSON.stringify(item_json), JSON.stringify(item_json));
    }

    removeItem(id){
        // using parseInt because id is "string".
        // Need to change to "int"
        // localStorage stores the length as an integer
        console.log("about to remove item");
        console.log(id);
        localStorage.removeItem(parseInt(id));
    }

    function hint(){
        console.log("1. Localstorage is not designed to be a database");
        console.log("2. Retrieval of data results in a non-ordered data");
        console.log("3. Storing of data requires stringifying and exact datatype. Meaning \"something\" and something are not the same.");
        console.log("4. ")
    }
}

function getEveryItems() {
    var values = [],
        keys = Object.keys(localStorage),
        i = keys.length;
    while ( i-- ) {
        values.push( localStorage.getItem(keys[i]));
    }
    return values;
}

function fetchData(){
    console.log("1. fetchData")
    // this will eventually be an endpoint from Spring Boot
    var answer = [];
    fetch('js/products.json')
        .then((resp) => resp.json())
        .then(function(data) {
            console.log("2. receive data");
            var c = new Cart()
            for (let index = 0; index < data.products.length; index++) {
                const element = data.products[index];
                c.addItem(element);
            }

            // Take note of the syntax of the json. products follow by 1 follow by "sku"
            console.log(data.products[1]["sku"])
        })
        .catch(function(error) {
            console.log(error);
        });
}

function remove(){
    var this_cart = new Cart();
    this_cart.removeItem(localStorage.length-1)
    updateCount();
}

function removeSpecific(){
    removeFirstOccurance(document.getElementById("text").value);
}



function removeFirstOccurance(id){
    for (var i = 0; i < localStorage.length; i++){
        key = localStorage.key(i);
        value = localStorage.getItem(localStorage.key(i));
        // console.log(key)
        // console.log(value.toString());
        // console.log(item);
        // console.log("----------");

        //TODO change value to value["sku"]
        if(id == value.toString()){
            localStorage.removeItem(key);
            break;
        }
    }

    updateCount();
}

function add(){
    var this_cart = new Cart();
    this_cart.addItem(document.getElementById("text").value);
    updateCount();
}

function updateCount(){
    document.getElementById("display").innerText =  "" + JSON.stringify(count(getEveryItems()));
    document.getElementById("count").innerText = "Cart's count: " + localStorage.length
}

function count(array_elements) {
    var counts = {};
    array_elements.forEach(function(x,i) {
        counts[x] = (counts[x] || 0) + 1;
    });
    return counts;
}

window.onload = () => {
    var all = getEveryItems();
    console.log(all)
    count(all)
}