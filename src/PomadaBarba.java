public class PomadaBarba extends Produto {
    public PomadaBarba() {
        super(20.0, "Pomada para Barba"); // Preço fixo de R$ 20,00
    }

    @Override
    public String toString() {
        return "PomadaBarba [nomeProduto=" + nomeProduto + ", preco=" + preco + "]";
    }
}