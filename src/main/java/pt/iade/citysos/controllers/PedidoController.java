package pt.iade.citysos.controllers;

import java.util.ArrayList;
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

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pedido sendPed(@RequestBody String newPedido) {
        Pedido pedido = pedidoRepository.save(newPedido);
        return pedido;
    }

    @GetMapping(path = "/filter_tipo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pedido> searchPedTipo(@RequestParam(value = "tipoPedido", defaultValue = "") String tipoPedido) {
    logger.info("Sending pedidos with tipo: " + tipoPedido);
    ArrayList<Pedido> ped = (ArrayList<Pedido>) getPedido();
    ped.removeIf((p) -> !(p.getTipoPedido().getNome().contains(tipoPedido)));
    return ped;
}
}