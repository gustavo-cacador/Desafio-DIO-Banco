public interface InterfaceConta {
     
    void depositar(double valor);
    
     void sacar(double valor);

     void transferir(double valor, Conta contaDestino);

     void imprimirExtrato();
}
