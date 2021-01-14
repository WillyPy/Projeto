package pt.iade.citysos.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.citysos.models.PedidoSos;
import pt.iade.citysos.models.repositories.PedidoSosRepository;

@RestController
@RequestMapping(path="/api/PedidoSos")
public class PedidoSosController {
    private Logger logger = LoggerFactory.getLogger(PedidoSosController.class);
    @Autowired
    private PedidoSosRepository pedidoSosRepository;
    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PedidoSos> getPedidoSos(){
        logger.info("sending all");
        return pedidoSosRepository.findAll();
    }
}
