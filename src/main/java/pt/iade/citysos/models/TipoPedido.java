package pt.iade.citysos.models;

public enum TipoPedido {
        ESCOLA_PRIMARIA(false),
        ESCOLA_SECUNDARIA(false),
        FACULDADE(false);
        CRECHE(false),
    
        private boolean tipo;
        
        private TipoPedido(boolean tipo){
            tipo = this.tipo;
        }
        public boolean getTipo(){ return tipo; }
}
