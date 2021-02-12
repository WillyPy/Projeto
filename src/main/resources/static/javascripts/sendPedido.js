window.onload = async function() {
    try {
        let tipos = await $.ajax({
            url: "/api/tippedidos",
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
            url: "/api/ongs",
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
            url: "/api/pedidos",
            method: "post",
            dataType: "json",
            data:JSON.stringify(pedido),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        sessionStorage.setItem("pedidoId",result.id);
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }

    try {
        let estado = {
            pedido: { id: sessionStorage.getItem("pedidoId")},
            estadoPedido: {id : 1},
            data: new Date()
        }
        console.log(JSON.stringify(estado));
        let result = await $.ajax({
            url: "/api/empresaPedidos",
            method: "post",
            dataType: "json",
            data:JSON.stringify(estado),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        window.location = "pedidoOng.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
