public abstract class Servico {
    protected String tipoServico;
    protected double preco;

    public Servico(String tipoServico, double preco) {
        this.tipoServico = tipoServico;
        this.preco = preco;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Servico [tipoServico=" + tipoServico + ", preco=" + preco + "]";
    }
}