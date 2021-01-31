window.onload = async function() {
    let pedidoId = sessionStorage.getItem("pedidoId");
    try {
        
        let pedido = await $.ajax({
            url: "/api/pedido/"+pedidoId,
            method: "get",
            dataType: "json"
        });
        console.log(pedido);
    
        document.getElementById("tipoped").innerHTML = pedido.tipoPedido.nome;
        document.getElementById("ong").innerHTML = pedido.ong.nome;


        let pedidos = await $.ajax({
            url: "/api/pedidos/"+pedidoId,
            method: "get",
            dataType: "json"
        });

        
        let html = "";
        for(let pedido of pedidos) {
            html+= "<p onclick='showTrack("+pedido.id+")'>"+pedido.tipoPedido.nome+"</p>";
        }
        document.getElementById("pedidos").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}


function showTrack(id) {
    // TODO: open page with track info
} 