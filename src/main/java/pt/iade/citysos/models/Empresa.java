package pt.iade.citysos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
//@Table(name="Empresa")
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="e_id")
    private int id;
    @Column(name="e_nome")
    private String nome;
    @Column(name="e_password")
    private String password;
    /*@Column(name="e_email")
    private String email;*/
    
    @OneToMany
    @JoinColumn(name="pedido_e_id")
    private List<PedidoSos> pedidos;

    public Empresa(int id, String nome, String password){
        id = this.id;
        nome = this.nome;
        password =  this.password;
       // email = this.email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword(){
        return password;
    }

    /*public String getEmail(){
        return email;
    }*/
}