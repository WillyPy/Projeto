package pt.iade.citysos.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.citysos.models.Pedido;
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
}
