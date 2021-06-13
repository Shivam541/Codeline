function loadXMLDoc() {
    let xmlhttp;
    xmlhttp = new XMLHttpRequest();
    const code = document.getElementById("code").value.toString();
    console.log(code);
    const url = `exe`;
    console.log(url);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById("output").value = xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST", url, true);
    xmlhttp.send(code);
}

function fillBox() {
    const code = document.getElementById("code");
    code.value = "class Abc{\n" +
        "\tpublic static void main(String[] args){\n" +
        "\t\tSystem.out.println(\"hello\");\n" +
        "\t}\n" +
        "}\n";
}

function resetEditor() {
    fillBox();
    document.getElementById('input').value = "Input goes here";
    document.getElementById('output').value = "Output";
}


function download(file, text) {
    var element = document.createElement('a');
    element.setAttribute('href',
        'data:text/plain;charset=utf-8, '
        + encodeURIComponent(text));
    element.setAttribute('download', file);
    document.body.appendChild(element);
    element.click();
    document.body.removeChild(element);
}

function downloadSame() {
    var text = document.getElementById("code").value;
    var filename = "Abc.txt";
    download(filename, text);
}