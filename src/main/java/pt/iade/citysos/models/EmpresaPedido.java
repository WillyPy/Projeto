package pt.iade.citysos.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name ="ep_p_id")
    private Pedido pedidoId;

    @ManyToOne
    @JoinColumn(name = "ep_e_id")
    private Empresa empresaId;

    //para ligar o Estado a base de dados... garantir que na base de dados o id começa em 0 e não em 1.
    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estado;

    public EmpresaPedido(int id, Date data){
        id = this.id;
        data = this.data;
        estado = EstadoPedido.SUBMETIDO;
    }
    
    public int getId(){ return id; }
    public void setId(int id){ 
        id = this.id;
    }
    public Date getData(){ return data; }

    public EstadoPedido getEstado(){ return estado; }
    
}
