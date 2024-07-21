import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements InterfaceConta{
    

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1; // Gerar um número sequencial, para que toda vez que um cliente for criar uma conta o número ser o próximo e não repetir.

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private List<Transacao> transacoes;
    
    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }


    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
        //saldo += valor;
        transacoes.add(new Transacao("Depósito", valor, getCurrentDate()));

    }


    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
        //saldo -= valor;
        transacoes.add(new Transacao("Saque", valor, getCurrentDate()));

    }


    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new Transacao("Transferência Enviada", valor, getCurrentDate()));
        contaDestino.adicionarTransacaoRecebida(new Transacao("Transferência Recebida", valor, getCurrentDate()));
    }

    private void adicionarTransacaoRecebida(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    private String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (Transacao transacao : transacoes) {
            System.out.println(String.format("%s - %s: %.2f", transacao.getData(), transacao.getTipo(), transacao.getValor()));
        }
    }
}
