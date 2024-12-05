public class PomadaCabelo extends Produto {
    public PomadaCabelo() {
        super(25.0, "Pomada para Cabelo"); // Preço fixo de R$ 25,00
    }

    @Override
    public String toString() {
        return "PomadaCabelo [nomeProduto=" + nomeProduto + ", preco=" + preco + "]";
    }

    public void aplicarDesconto(double desconto) {
        this.preco -= desconto;
    }

    public void aplicarDesconto(double desconto, double taxa) {
        this.preco -= desconto + taxa;
    }
}
