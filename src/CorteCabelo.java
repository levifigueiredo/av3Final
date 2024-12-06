public class CorteCabelo extends Servico {
    public CorteCabelo() {
        super("Corte de Cabelo", 40.0);
    }

    @Override
    public String toString() {
        return "CorteCabelo [tipoServico=" + tipoServico + ", preco=" + preco + "]";
    }
}