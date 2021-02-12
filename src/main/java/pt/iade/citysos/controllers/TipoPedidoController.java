package pt.iade.citysos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.citysos.models.TipoPedido;
import pt.iade.citysos.models.repositories.TipoPedidoRepository;

@RestController
@RequestMapping(path="/api/tippedidos")
public class TipoPedidoController {
    private Logger logger = LoggerFactory.getLogger(TipoPedidoController.class);
    @Autowired
    private TipoPedidoRepository tipopedidoRepository;
    
    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TipoPedido> geTipoPedido(){
        logger.info("sending all");
        return tipopedidoRepository.findAll();
    }

}
