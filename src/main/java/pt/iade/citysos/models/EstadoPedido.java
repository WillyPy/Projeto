package pt.iade.citysos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="est_id")
    private int id;

    @OneToMany
    @JoinColumn(name="p_ong_id")
    private List<EstadoPedido> estadoPedido; 
    
    @Column(name="est_estado")
    private String nome ;

    public int getId(){ return id; }
    public String geNome(){ return nome; }
    
    
}