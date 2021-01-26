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

import pt.iade.citysos.models.EmpresaPedido;
import pt.iade.citysos.models.exceptions.NotFoundException;
import pt.iade.citysos.models.repositories.EmpresaPedidoRepository;

@RestController
@RequestMapping(path = "/api/Publicacao")
public class EmpresaPedidoController {
    private Logger logger = LoggerFactory.getLogger(EmpresaPedidoController.class);
    
    @Autowired
    private EmpresaPedidoRepository empresaPedidoRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EmpresaPedido> getPublicacao(){
        logger.info("Sending all");
        return empresaPedidoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpresaPedido getPub(@PathVariable int id){
        logger.info("find by id"+id);
        Optional<EmpresaPedido> _pub = empresaPedidoRepository.findById(id);
        if(!_pub.isPresent())
            throw new NotFoundException("" + id, "Publicação", "id");
        else
            return _pub.get();
    }
}
