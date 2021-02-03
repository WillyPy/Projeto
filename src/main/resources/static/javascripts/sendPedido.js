window.onload = async function() {
    try {
        let tipos = await $.ajax({
            url: "/api/tipopedido",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let tipo of tipos) {
            html+= "<option value="+tipo.id+">"+tipo.nome+
                "</option>";
        }
        document.getElementById("tipos").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }

    try {
        let ongs = await $.ajax({
            url: "/api/Ong",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let ong of ongs) {
            html+= "<option value="+ong.id+">"+ong.nome+
                "</option>";
        }
        document.getElementById("ongs").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }
}

async function sendPedido() {
    try {
        let pedido = {
            carta: document.getElementById("carta").value,
            ong: { id: parseInt(document.getElementById("ongs").value) },
            tipoPedido: { id: parseInt(document.getElementById("tipos").value) }
        }
        console.log(JSON.stringify(pedido));
        let result = await $.ajax({
            url: "/api/Pedido",
            method: "post",
            dataType: "json",
            data:JSON.stringify(pedido),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        sessionStorage.setItem("pedidoId",result.id);
        window.location = "pedido.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
