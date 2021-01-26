package pt.iade.citysos.models.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pt.iade.citysos.models.Empresa;
import pt.iade.citysos.models.EmpresaPedido;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into empresa_pedido " + "(ep_e_id, ep_p_id) " + 
        "values(:#{#empresa.id}, :#{#empresa.pedido.id})", nativeQuery = true)
    void addEmpresaToEmpresaPedido(@Param("empresa") EmpresaPedido empresa);
}