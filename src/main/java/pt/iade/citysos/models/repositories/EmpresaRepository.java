package pt.iade.citysos.models.repositories;
import org.springframework.data.repository.CrudRepository;
import pt.iade.citysos.models.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    
}