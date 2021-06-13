function isSessionThere() {
    console.log("session there called");
    const logged = getCookie("logged");
    console.log(String(logged) + " sess");
    if(logged===""){
    }else {
        replaceLoginWithProfile();
    }
}
function replaceLoginWithProfile() {
    document.getElementById('nav-login').innerHTML=
        "<div class=\"profile_logo\">\n" +
        "        <img src=\"Styles/PngItem_877270.png\" alt=\"Try Again\" class=\"pimg_logo\" onclick='profileCLick()'>\n" +
        "<div class=\"dropdown-options\">\n" +
        "    <a href=\"\" onclick='profileCLick()'>Profile</a>\n" +
        "    <a href=\"/Codeline_war_exploded/logout\">Logout</a>\n" +
        "    <a href=\"\" onclick='submissionCLick()'>My Submissions</a>\n" +
        "  </div>" +
        "</div>";
}
function profileCLick(){
    window.open("/Codeline_war_exploded/profile");
}
function submissionCLick(){
    window.open("/Codeline_war_exploded/submissions");
}
function getCookie(cname) {
    const name = cname + "=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const ca = decodedCookie.split(';');
    console.log(decodedCookie);
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        console.log(String(ca[i]));
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}