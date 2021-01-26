package pt.iade.citysos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private int id;
    
    @Column(name="p_cart_sol")
    private String carta;

    @OneToMany
    @JoinColumn(name = "ep_p_id")
    private List<EmpresaPedido> publicacao;
    
    @ManyToOne
    @JoinColumn(name="p_ong_id")
    private Ong ong; 
    
    @ManyToOne
    @JoinColumn(name="p_tip_ped_id")
    private TipoPedido tipoPedido;

    public Pedido(){}
    public Pedido(int id,  String carta) {
		id = this.id;
		carta = this.carta;
	}    
    public int getid(){ return id; }
    public void setId(int id){
        id = this.id;
    }
    public String getCarta(){ return carta; }
    public void setCarta(String carta){
        carta = this.carta;
    }
    public TipoPedido getTipoPedido(){ return tipoPedido; }
    public Ong getOng(){ return ong; }
}
