package pt.iade.citysos.models.repositories;
import org.springframework.data.repository.CrudRepository;
import pt.iade.citysos.models.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
    
}
