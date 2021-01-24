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
@Table(name = "tipo_pedido")
public class TipoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_ped_id")
    private int id;
    @Column(name = "tip_nome")
    private String nome;

    @OneToMany
    @JoinColumn(name="p_tip_ped_id")
    private List<Pedido> pedidos;
    
    public TipoPedido(int id, String nome){
        id = this.id;
        nome = this.nome;
    }

    public String getNome(){ return nome; }

    
}
