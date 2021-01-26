try {
        let artistas = await $.ajax({
            url: "/api/artists",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let artista of artistas) {
            html+= "<option value="+artista.id+">"+artista.name+
                "</option>";
        }
        document.getElementById("artist").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }