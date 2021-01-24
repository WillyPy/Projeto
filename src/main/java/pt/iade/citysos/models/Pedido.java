package pt.iade.citysos.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private int id;
    @Column(name="p_tipo")
    private String tipo;
    @Column(name="p_cart_sol")
    private String carta;
    @OneToMany
    @JoinColumn(name = "ep_p_id")
    private List<EmpresaPedido> publicacao;

    //para ligar o Estado a base de dados... garantir que na base de dados o id começa em 0 e não em 1.
    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estado;

    public Pedido(int id, String tipo, String carta) {
        id = this.id;
        tipo = this.tipo;
        carta = this.carta;
    }

    public String getTipo(){
        return tipo;
    }
    
    public String getPub(){
        return carta;
    }
}