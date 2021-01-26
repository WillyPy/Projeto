window.onload = function() {
    loadPedidos();
}

async function loadPedidos() {
    try {
        let pedidos = await $.ajax({
            url: "/api/Pedido",
            method: "get",
            dataType: "json"
        });
        showPedidos(pedidos);
        
    } catch(err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
    }
} 

function showPedidos(pedidos) {
    let elemMain = document.getElementById("main");
    let html ="";
    for (let pedido of pedidos) {
        html += "<section onclick='showpedido("+pedido.id+")'>"+
        "<h3>"+pedido.tipoPedido.nome+"</h3>"+
        "<p> Artista: "+pedido.ong.name+"</p></section>";
    }
    elemMain.innerHTML = html;
}


function showPedido(pedidoId) {
    sessionStorage.setItem("pedidoId",pedidoId);
    window.location = "album.html";
}