async function addEmpresa() {
    try {
        let empresa = {
            nome: document.getElementById("nome").value,
        }
        console.log(JSON.stringify(empresa));
        let result = await $.ajax({
            url: "/api/empresas",
            method: "post",
            dataType: "json",
            data:JSON.stringify(empresa),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        window.location = "index.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}