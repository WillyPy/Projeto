
window.onload = async function() {

    try {
        let empresas = await $.ajax({
            url: "/api/Empresa",
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
}
async function setSessionUser() {
    let empresaId = parseInt(document.getElementById("empresa").value) ;
    sessionStorage.setItem("empresaId", empresaId);
}
async function addEmpresa() {
    try {  
        window.location = "registroEmpresa.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
async function loginOng() {
    try {  
        window.location = "ongPage.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
async function loginEmpresa() {
        setSessionUser();
        window.location = "empresaPage.html";
    

}