function loadXMLDoc() {
    let xmlhttp;
    xmlhttp = new XMLHttpRequest();
    const code = document.getElementById("code").value.toString();
    console.log(code);
    const url=`exe`;
    console.log(url);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById("output").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST",url,true);
    xmlhttp.send(code);
}
function fillBox(){
    const code = document.getElementById("code");
    code.innerHTML="class Abc{\n" +
        "\tpublic static void main(String[] args){\n" +
        "\t\tSystem.out.println(\"hello\");\n" +
        "\t}\n" +
        "}\n";
}