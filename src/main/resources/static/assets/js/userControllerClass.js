/* let userList = [];

function login() {
    for (i = 0; i < localStorage.length; i++) {
        let keyName = window.localStorage.key(i);
        let localStorageUser = JSON.parse(window.localStorage.getItem(keyName));
        userList.push(localStorageUser);
    }
    
    userEmail = document.getElementById("userEmail").value
    userPassword = document.getElementById("userPassword").value

    let valid = false;

    for (i = 0; i < userList.length; i++) {
        if (userEmail === userList[i].userEmail && userPassword === userList[i].userPassword) {
            window.location = "stories.html"
            valid = true
            break
        }
    }
    if (!valid) {
        alert("Email or password is invalid")
    }
}


function signUp() {
    signUpName = document.getElementById("signUpName").value
    signUpPhone = document.getElementById("signUpPhone").value
    signUpEmail = document.getElementById("signUpEmail").value
    signUpPassword = document.getElementById("signUpPassword").value

    if (signUpName.length == 0 || signUpPhone.length == 0 || signUpEmail.length == 0 || signUpPassword.length == 0) {
        alert("Please fill in required fields");
        return
    }

    let newUser = {
        userName: signUpName,
        userPhone: signUpPhone,
        userEmail: signUpEmail,
        userPassword: signUpPassword
    }

    window.localStorage.setItem(newUser.userEmail, JSON.stringify(newUser));

    if (newUser.length != 0) {
        $('#signUpForm').modal('hide');
        document.getElementById("signUpName").value = "";
        document.getElementById("signUpPhone").value = "";
        document.getElementById("signUpEmail").value = "";
        document.getElementById("signUpPassword").value = "";
        alert("Signup successful!");
    }
} 


