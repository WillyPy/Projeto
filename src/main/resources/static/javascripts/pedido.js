window.onload = async function() {
    let pedidoId = sessionStorage.getItem("pedidoId");
    try {
    
        let pedido = await $.ajax({
            url: "/api/pedidos/"+pedidoId,
            method: "get",
            dataType: "json"
        });
        console.log(pedido);
     
        document.getElementById("Detalhes").innerHTML = pedido.carta;
        document.getElementById("ong").innerHTML = pedido.ong.nome;
        document.getElementById("regiao").innerHTML = pedido.ong.regiao;
        document.getElementById("tipoped").innerHTML = pedido.tipoPedido.nome;
    } catch(err) {
        console.log(err);
    }
}
async function aceitar() {
    try {
        let estado = {
            empresa: { id: sessionStorage.getItem("empresaId")},
            pedido: { id: sessionStorage.getItem("pedidoId")},
            estadoPedido: {id: 1},
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
        window.location = "empresaPage.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
async function rejeitar() {
    try {
        let estado = {
            empresa: { id: sessionStorage.getItem("empresaId")},
            pedido: { id: sessionStorage.getItem("pedidoId")},
            estadoPedido: {id : 2},
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
        window.location = "empresaPage.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}

