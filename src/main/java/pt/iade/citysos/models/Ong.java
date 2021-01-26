package pt.iade.citysos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ong")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ong_id")
    private int id;
    
    @Column(name="ong_nome")
    private String nome;
    
    @Column(name="ong_regiao")
    private String regiao;

    @OneToOne
    @JoinColumn(name="ong_e_id")
    private Empresa empresas;
    
    @OneToMany
    @JoinColumn(name="p_ong_id")
    private List<Pedido> pedidos;

    public Ong(){}
    
    public Ong(int id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
    }

    public int getId(){ return id; }
    public void setId(int id){
        id = this.id;
    }
    public String getNome(){ return nome; }
    public void setNome( String nome){
        nome = this.nome;
    }
    public String getRegiao(){ return regiao; }
    public void setRegiao(String regiao){
    	this.regiao = regiao;
    }
    public List<Pedido> getPedido(){ return pedidos; }
}
