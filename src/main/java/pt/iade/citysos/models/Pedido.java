package pt.iade.citysos.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private int id;
    
    @Column(name="p_cart_sol")
    private String carta;
    
    @ManyToOne
    @JoinColumn(name="p_ong_id")
    private Ong ong; 
    
    @ManyToOne
    @JoinColumn(name="p_tip_ped_id")
    private TipoPedido tipoPedido;
    
    public Pedido(){}
    
    public int getId(){
        return id;
    }
    public String getCarta(){
        return carta;
    }
    
    public TipoPedido getTipoPedido(){
        return tipoPedido;
    }

    public Ong getOng(){
        return ong;
    }

}
