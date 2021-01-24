package pt.iade.citysos.models;

public enum EstadoPedido {
    APROVADO(true),
    NAO_APROVADO(false),
    SUBMETIDO(false);
 
    private boolean aceite;

    private EstadoPedido(boolean aceite){
        aceite = this.aceite;
    }
    public boolean isAceite(){ return aceite; }
}