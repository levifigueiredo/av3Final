public class Cartao extends Pagamento {
    private String tipoCartao; // Débito ou Crédito

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

    // Sobrescrevendo toString (Polimorfismo de Sobreposição)
    @Override
    public String toString() {
        return "Cartao [valor=" + valor + ", tipoCartao=" + tipoCartao + "]";
    }

    // Sobrecarga: Definir valor do pagamento
    public void definirValor(double valor) {
        this.valor = valor;
    }

    public void definirValor(double valor, double taxa) {
        this.valor = valor + taxa;
    }
}