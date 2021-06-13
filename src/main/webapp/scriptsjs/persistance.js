function upload() {
    const logged = getCookie("logged");
    console.log(String(logged) + " sess");
    if (logged === "") {
        window.alert("please login for this action to succeed");
        return;
    }
    const uploadData = {
        language: document.getElementById('lang').value,
        code: document.getElementById('code').value
    };
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            window.alert("program uploaded successfully");
        }
    }
    xhr.open("POST", "upload", true);
    xhr.send(JSON.stringify(uploadData));
}