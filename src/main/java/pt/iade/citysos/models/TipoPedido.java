package pt.iade.citysos.models;

public enum TipoPedido {
        CRECHE(false),
        ESCOLA_PRIMARIA(false),
        ESCOLA_SECUNDARIA(false),
        FACULDADE(false);
    
        private boolean tipo;
        
        private TipoPedido(boolean tipo){
            tipo = this.tipo;
        }
        public boolean getTipo(){ return tipo; }
}