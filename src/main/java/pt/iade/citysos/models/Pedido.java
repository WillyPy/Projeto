package pt.iade.citysos.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private int id;
    @Column(name="ped_tipo")
    private String tipo;
    /*@Column(name="ped_texto")
    private String mensagem;*/
    @Column(name="ped_cart_sol")
    private String carta;

    //para ligar o Estado a base de dados... garantir que na base de dados o id começa em 0 e não em 1.
    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estado;

    public Pedido(int id, String tipo, /*String mensagem,*/ String carta) {
        id = this.id;
        tipo = this.tipo;
        //mensagem = this.mensagem;
        carta = this.carta;
    }

    public String getTipo(){
        return tipo;
    }
    /*public String getPubs(){
        return mensagem;
    }*/
    
    public String getCarta(){
        return carta;
    }
}