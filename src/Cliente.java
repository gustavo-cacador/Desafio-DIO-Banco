public class Cliente {
    
    private String nome;
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimirEndereco() {
        System.out.println(String.format("Rua: %s", this.endereco.getRua()));
        System.out.println(String.format("Cidade: %s", this.endereco.getCidade()));
        System.out.println(String.format("Estado: %s", this.endereco.getEstado()));
        System.out.println(String.format("CEP: %s", this.endereco.getCep()));
    }
    
}

