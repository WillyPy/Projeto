package pt.iade.citysos.models.repositories;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pt.iade.citysos.models.EmpresaPedido;

public interface EmpresaPedidoRepository extends CrudRepository<EmpresaPedido, Integer>{
    Optional<EmpresaPedido> findByPedidoIdAndEmpresaId( int pedidoId, int empresaId);
}
