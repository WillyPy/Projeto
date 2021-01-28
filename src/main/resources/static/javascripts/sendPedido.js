async function sendPedido() {
    try {
        let pedido = { 
            ong:{ nome: document.getElementById("ong").value,
                regiao: document.getElementById("regiao").value},
            tipoPedido: document.getElementById("tipop").value,
            ped: document.getElementById("carta").value,
        }
        alert(JSON.stringify(pedido));
        let result = await $.ajax({
            url: "/api/Pedido",
            method: "post",
            dataType: "json",
            data: JSON.stringify(pedido),
            contentType: "application/json"
        });
        alert(JSON.stringify(result));
    } catch (err) {
        console.log(err);
        // mensagem para o utilizador
    }
}
