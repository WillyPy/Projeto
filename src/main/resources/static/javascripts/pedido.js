window.onload = async function() {
    let pedidoId = sessionStorage.getItem("pedidoId");
    try {
    
        let pedido = await $.ajax({
            url: "/api/Pedido/"+pedidoId,
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

as

