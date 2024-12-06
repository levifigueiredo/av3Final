public class Cartao extends Pagamento {
    private String tipoCartao;

    public Cartao(double valor, String tipoCartao) {
        super(valor);
        this.tipoCartao = tipoCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    @Override
    public String toString() {
        return "Cartao [valor=" + valor + ", tipoCartao=" + tipoCartao + "]";
    }

    public void definirValor(double valor) {
        this.valor = valor;
    }

    public void definirValor(double valor, double taxa) {
        this.valor = valor + taxa;
    }
}