package pt.iade.citysos.models.repositories;

//import javax.transaction.Transactional;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.citysos.models.EmpresaPedido;
import pt.iade.citysos.models.Pedido;
import pt.iade.citysos.models.views.PedidoView;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
	
	String activePedidoQuery = 
	"SELECT p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido " +
	"FROM tipo_pedido b, pedido a, ong  " + 
	"WHERE b.tip_ped_id = a.p_tip_ped_id AND a.p_ong_id = ong_id ";
	@Query(value = activePedidoQuery, nativeQuery = true)
	Iterable<PedidoView> findAllPedidos();

	String currentPedidoEstadoQuery = "Select p_id AS id, est_estado AS estado"+
	"from estado_pedido a Join empresa_pedido b on b.ep_est_id=a.est_id Join pedido c on b.ep_p_id=c.p_id"+
	"where ep_data =(select Max(ep_data) from empresa_pedido where ep_p_id=b.ep_p_id)";
	String estadoPedidosQuery = currentPedidoEstadoQuery + " And ep_p_id= = :id ";
    @Query(value = pedidosOngQuery, nativeQuery = true)
	EmpresaPedido estadoPedido(@Param("id") int id);


	String pedidoByTipoQuery = activePedidoQuery + "AND tip_ped_nome = :tipopedKey ";
    @Query(value = pedidoByTipoQuery, nativeQuery = true)
	Iterable<PedidoView> findPedidoByTipo(@Param("tipopedKey") String tipopedKey);
	
	String pedidoByOngQuery = activePedidoQuery + "AND ong_nome = :ongpedKey ";
    @Query(value = pedidoByOngQuery, nativeQuery = true)
	Iterable<PedidoView> findPedidoByOng(@Param("ongpedKey") String tipopedKey);

	String pedidosOngQuery = activePedidoQuery + " AND ong_id = :id ";
    @Query(value = pedidosOngQuery, nativeQuery = true)
	Iterable<PedidoView> searchOngPedidos(@Param("id") int id);

	
}
