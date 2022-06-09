public class Produto {
    String nome;
    String quantidade;

    public Produto(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Produto [nome= " + nome + ", quantidade= " + quantidade + "]";
    }

}
