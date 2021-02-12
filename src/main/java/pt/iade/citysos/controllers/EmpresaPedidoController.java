package pt.iade.citysos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.citysos.models.EmpresaPedido;
import pt.iade.citysos.models.repositories.EmpresaPedidoRepository;

@RestController
@RequestMapping(path="/api/empresaPedidos")
public class EmpresaPedidoController {
    
    private Logger logger = LoggerFactory.getLogger(EmpresaPedidoController.class);
    @Autowired
    private EmpresaPedidoRepository empresaPedidoRepository;

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EmpresaPedido> getEmpresaPedido(){
        logger.info("sending all");
        return empresaPedidoRepository.findAll();
    }
    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public EmpresaPedido saveEstado(@RequestBody EmpresaPedido novoEstado) {
        logger.info("Saving album with title: "+novoEstado);
        EmpresaPedido estado = empresaPedidoRepository.save(novoEstado);
        return estado;
    }

}
