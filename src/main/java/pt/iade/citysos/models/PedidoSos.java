package pt.iade.citysos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PedidoSos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sos_id")
    private int id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="numero_de_publicacoes")
    private int numero_de_publicacoes;

    public PedidoSos(int id, String titulo, int numero_de_publicacoes) {
        id = this.id;
        titulo = this.titulo;
        numero_de_publicacoes = this.numero_de_publicacoes;
    }

    public String getTitulo(){
        return titulo;
    }
    public int getPubs(){
        return numero_de_publicacoes;
    }
}