package pt.iade.citysos.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.citysos.models.TipoPedido;
import pt.iade.citysos.models.exceptions.NotFoundException;
import pt.iade.citysos.models.repositories.TipoPedidoRepository;

@RestController
@RequestMapping(path="/api/TipoPedido")
public class TipoPedidoController {
    private Logger logger = LoggerFactory.getLogger(TipoPedido.class);
   
    @Autowired
    private TipoPedidoRepository tipoPedidoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TipoPedido> getTipoPedido(){
        logger.info("sending all");
        return tipoPedidoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoPedido getTipo(@PathVariable int id){
        logger.info("find by id"+id);
        Optional<TipoPedido> _tipo = tipoPedidoRepository.findById(id);
        if(!_tipo.isPresent())
            throw new NotFoundException("" + id, "Tipo de Pedido", "id");
        else
            return _tipo.get();
    }
}
