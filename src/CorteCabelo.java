public class CorteCabelo extends Servico {
    public CorteCabelo() {
        super("Corte de Cabelo", 40.0); // Preço fixo de R$ 40,00
    }

    @Override
    public String toString() {
        return "CorteCabelo [tipoServico=" + tipoServico + ", preco=" + preco + "]";
    }
}