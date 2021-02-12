package pt.iade.citysos.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

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
    @JoinColumn(name ="ep_est_id")
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name ="ep_p_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "ep_e_id")
    private Empresa empresa;    

    public EmpresaPedido(){}
    
    public int getId(){ return id; }

    public Date getData(){ return data; }

    public Pedido getPedido(){return pedido;}
    
    public Empresa getEmpresa(){return empresa;}

    public EstadoPedido getEstadoPedido(){
        return estadoPedido;}
    
}
