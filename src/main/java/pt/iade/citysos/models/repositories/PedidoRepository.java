package pt.iade.citysos.models.repositories;

//import javax.transaction.Transactional;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.citysos.models.Pedido;
import pt.iade.citysos.models.views.PedidoView;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
	
	String activePedidoQuery = 
	"SELECT p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido " +
	"FROM tipo_pedido b, pedido a, ong  " + 
	"WHERE b.tip_ped_id = a.p_tip_ped_id AND a.p_ong_id = ong_id ";
	@Query(value = activePedidoQuery, nativeQuery = true)
	Iterable<PedidoView> findAllPedidos();

	String pedidoByTipoQuery = activePedidoQuery + "AND tip_ped_nome = :tipopedKey ";
    @Query(value = pedidoByTipoQuery, nativeQuery = true)
	Iterable<PedidoView> findPedidoByTipo(@Param("tipopedKey") String tipopedKey);
	
    
}
