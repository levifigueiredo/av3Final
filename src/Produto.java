public abstract class Produto {
    protected double preco;
    protected String nomeProduto;

    public Produto(double preco, String nomeProduto) {
        this.preco = preco;
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public String toString() {
        return "Produto [nomeProduto=" + nomeProduto + ", preco=" + preco + "]";
    }
}