package pt.iade.citysos.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.citysos.models.Pedido;
import pt.iade.citysos.models.exceptions.NotFoundException;
import pt.iade.citysos.models.repositories.PedidoRepository;
import pt.iade.citysos.models.views.PedidoView;

@RestController
@RequestMapping(path="/api/Pedido")
public class PedidoController {

    private Logger logger = LoggerFactory.getLogger(PedidoController.class);
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pedido> getPedido(){
        logger.info("sending all");
        return pedidoRepository.findAll();
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pedido getPed(@PathVariable int id){
        logger.info("find by id" +id);
        Optional<Pedido> _ped = pedidoRepository.findById(id);
        if (!_ped.isPresent())
            throw new NotFoundException("" + id, "Pedido", "id");
        else
            return _ped.get();
    }

    

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PedidoView> getAllPedidos() {
        logger.info("Todos os Pedidos");
        return pedidoRepository.findAllPedidos();
    }

    @GetMapping(path = "/filtrar_tipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PedidoView> searchPedidoTipo(@RequestParam(value = "tipo", defaultValue = "") String tipoPedKey) {
        logger.info("Pedido com o seu tipo: " + tipoPedKey);
        return pedidoRepository.findPedidoByTipo(tipoPedKey);
    }
    @GetMapping(path = "/filtrar_ong", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PedidoView> SerchPedidoOng(@RequestParam(value = "ong", defaultValue = "") String ongPedKey) {
        logger.info("Pedido com o seu tipo: " + ongPedKey);
        return pedidoRepository.findPedidoByOng(ongPedKey);
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Pedido savePedido(@RequestBody Pedido newPedido) {
        logger.info("Saving album with title: "+newPedido);
        Pedido pedido = pedidoRepository.save(newPedido);
        return pedido;
    }

}