let currentUser;//под кем логин
let personalKey = ["id", "name", "lastName", "age", "password", "email", "roles"];

let testString;

startUser();

async function startUser() {
    await getCurrent();
    await fillCurrentHeader();
}

async function getCurrent() {
    try {
        let response = await fetch('http://localhost:8080/rest/current');
        let user = await response.json();
        currentUser = user;
    } catch (error) {
        alert(error);
    }
}


async function fillCurrentHeader() {
    let m = document.getElementById("headerMail");
    m.innerText = currentUser["email"];
    m = document.getElementById("headerRole");
    let roles = "";
    for (let k = 0; k < currentUser.roles.length; k++) {
        roles += currentUser.roles[k].role + " ";
    }
    m.innerText = roles;
}

async function getTest(){
    try {
        let response = await fetch('http://localhost:8080/drest/delivery/test_get');
        let tString = await response.text();
        testString = tString;
    } catch (error) {
        alert(error);
    }

    let m = document.getElementById('1result');
    m.innerText = 'result = '+testString;
}

async function postTest(){
    transfer = document.getElementById('new-test').value;
    try {

        let response = await fetch('http://localhost:8080/drest/delivery/test_post', {
            method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},
            body: JSON.stringify(transfer)
        });

        let tString = await response.text();
        testString = tString;
    } catch (error) {
        alert(error);
    }

    let m = document.getElementById('2result');
    m.innerText = 'result = '+testString;
}

async function getTestDost(){
    try {
        let response = await fetch('http://localhost:8080/drest/delivery/test_get_dost');
        let tString = await response.text();
        testString = tString;
    } catch (error) {
        alert(error);
    }

    let m = document.getElementById('3result');
    m.innerText = 'result = '+testString;
}

async function postDost(){
    transfer = document.getElementById('new-test2').value;
    try {

        let response = await fetch('http://localhost:8080/drest/delivery/test_post_dost', {
            method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},
            body: JSON.stringify(transfer)
        });

        let tString = await response.text();
        testString = tString;
    } catch (error) {
        alert(error);
    }

    let m = document.getElementById('4result');
    m.innerText = 'result = '+testString;
}