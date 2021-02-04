package pt.iade.citysos.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.citysos.models.Ong;
import pt.iade.citysos.models.exceptions.NotFoundException;
import pt.iade.citysos.models.repositories.OngRepository;

@RestController
@RequestMapping(path="/api/Ong")
public class OngController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(OngController.class);
    @Autowired
    
    private OngRepository ongRepository;
    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ong> getOng(){
        logger.info("sending all");
        return ongRepository.findAll();
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ong getOng(@PathVariable int id){
        logger.info("find by id" +id);
        Optional<Ong> _ong = ongRepository.findById(id);
        if (!_ong.isPresent())
            throw new NotFoundException("" + id, "Ong", "id");
        else
            return _ong.get();
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Ong addOng(@RequestBody Ong newOng) {
        logger.info("Add Ong with title: "+newOng);
        Ong ong = ongRepository.save(newOng);
        return ong;
    }
}