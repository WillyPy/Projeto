window.onload = function() {
    loadPedidos();
}

async function loadPedidos() {
    try {
        let pedidos = await $.ajax({
            url: "/api/Pedido/all",
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
        html += "<section onclick='showPedido("+pedido.id+")'>"+
        "<h3>"+pedido.tipoPedido+"</h3>"+
        "<h3> ong: "+pedido.ong+"</h3></section>";
        
    }
    elemMain.innerHTML = html;
}

function showPedido(pedidoId) {
    sessionStorage.setItem("pedidoId",pedidoId);
    window.location = "pedido.html";
}

async function filterTipo() {
        try {
            let tipo = document.getElementById("tipoPedido").value;
            let pedidos = await $.ajax({
                url: "/api/Pedido/filtrar_tipo?tipo=" + tipo,
                method: "get",
                dataType: "json"
            });
            showPedidos(pedidos);
        } catch (err) {
            let elemMain = document.getElementById("main");
            console.log(err);
            elemMain.innerHTML = "<h1> Página não está disponível</h1>" +
                "<h2> Por favor tente mais tarde</h2>";
        }
    }