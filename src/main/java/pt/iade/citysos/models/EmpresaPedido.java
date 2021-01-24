package pt.iade.citysos.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_pedido")
public class EmpresaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ep_id")
    private int id;
    @Column(name = "ep_data")
    private Date data;

    public EmpresaPedido(int id, Date data){
        id = this.id;
        data = this.data;
    }
    
}
