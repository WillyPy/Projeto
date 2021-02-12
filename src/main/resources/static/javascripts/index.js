
window.onload = async function() {
    try {
        let empresas = await $.ajax({
            url: "/api/empresas",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let empresa of empresas) {
            html+= "<option value="+empresa.id+">"+empresa.nome+
                "</option>";
        }
        document.getElementById("empresa").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }

    try {
        let ongs = await $.ajax({
            url: "/api/ongs",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let ong of ongs) {
            html+= "<option value="+ong.id+">"+ong.nome+
                "</option>";
        }
        document.getElementById("ong").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}

//Ong funções
async function setSessionOng() {
    let ongId = parseInt(document.getElementById("ong").value) ;
    sessionStorage.setItem("ongId", ongId);
}

async function addOng() {
    window.location = "registroOng.html";
}

async function loginOng() {
    setSessionOng();
    window.location = "ongPage.html";
}

//Empresa Funções
async function setSessionEmpresa() {
    let empresaId = parseInt(document.getElementById("empresa").value) ;
    sessionStorage.setItem("empresaId", empresaId);
}

async function addEmpresa() {
        window.location = "registroEmpresa.html";
}

async function loginEmpresa() {
        setSessionEmpresa();
        window.location = "empresaPage.html";
}
