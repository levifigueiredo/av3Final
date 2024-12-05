public class CorteBarba extends Servico {
    public CorteBarba() {
        super("Corte de Barba", 30.0); // Preço fixo de R$ 30,00
    }

    @Override
    public String toString() {
        return "CorteBarba [tipoServico=" + tipoServico + ", preco=" + preco + "]";
    }

    public double calcularPreco(double desconto) {
        return preco - desconto;
    }

    public double calcularPreco(double desconto, double taxa) {
        return preco - desconto + taxa;
    }
}