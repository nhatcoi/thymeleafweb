const wrapper = document.querySelector('.wrapper')
const registerLink = document.querySelector('.register-link')
const loginLink = document.querySelector('.login-link')

registerLink.onclick = () => {
    wrapper.classList.add('active')
}

loginLink.onclick = () => {
    wrapper.classList.remove('active')
}

function validatePasswords() {
    const password = document.getElementById("password").value;
    const authPassword = document.getElementById("authPassword").value;

    if (password !== authPassword) {
        alert("Passwords do not match. Please re-enter the passwords.");
        return false;
    }
    return true;
}

document.addEventListener("click", function() {
    const messageElement = document.getElementById("message");
    if (messageElement) {
        messageElement.textContent = "";
    }
});