public class Pix extends Pagamento {
    public Pix(double valor) {
        super(valor);
    }

    // Sobrescrevendo toString (Polimorfismo de Sobreposição)
    @Override
    public String toString() {
        return "Pix [valor=" + valor + "]";
    }
}


