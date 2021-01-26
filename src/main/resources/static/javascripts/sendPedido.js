async function sendPedido() {
    try {
        let pedido = {
            carta: document.getElementById("carta").value,
            ong:{ nome: parseInt(document.getElementById("ong").value),
                regiao: parseInt(document.getElementById("regiao").value)},
            tipoPedido: document.getElementById("tipop").value,
        }
        alert(JSON.stringify(ad));
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