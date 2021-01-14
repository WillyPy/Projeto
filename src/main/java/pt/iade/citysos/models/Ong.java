package pt.iade.citysos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ong_id")
    private int id;
    @Column(name="ong_nome")
    private String nome;
    @Column(name="pedidos_aprovados")
    private int pedidos_aprovados;
    
    @OneToMany
    @JoinColumn(name="pedido_ong_id")
    private List<PedidoSos> pedidos;

    public Ong(int id, String nome, int pedidos_aprovados){
        id = this.id;
        nome = this.nome;
        pedidos_aprovados = this.pedidos_aprovados;
    }

    public String getNome(){
        return nome;
    }

    public int getPedidosAprovados(){
        return pedidos_aprovados;
    }
}
