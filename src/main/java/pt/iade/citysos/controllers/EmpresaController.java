package pt.iade.citysos.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.citysos.models.Empresa;
import pt.iade.citysos.models.repositories.EmpresaRepository;

@RestController
@RequestMapping(path="/api/Empresa")
public class EmpresaController {
    private Logger logger = LoggerFactory.getLogger(EmpresaController.class); 
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Empresa> getEmpresas(){
        logger.info("sending all");
        return empresaRepository.findAll();
    }
}
