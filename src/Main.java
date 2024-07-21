public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Gustavo");
        
        Endereco endereco1 = new Endereco();
        endereco1.setRua("Rua C");
        endereco1.setCidade("Vila Velha");
        endereco1.setEstado("ES");
        endereco1.setCep("12345-678");
        
        cliente1.setEndereco(endereco1);

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupança(cliente1);

        cc.depositar(400);
        cc.sacar(150);
        cc.transferir(50, poupanca);

        poupanca.depositar(970);
        poupanca.sacar(325);
        poupanca.transferir(40, cc);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println("=== Endereço do Cliente ===");
        cliente1.imprimirEndereco();

        System.out.println("=== Histórico da Conta Corrente ===");
        cc.imprimirHistorico();
        
        System.out.println("=== Histórico da Conta Poupança ===");
        poupanca.imprimirHistorico();
    }
}


