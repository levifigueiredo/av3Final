public interface Agendamento {
    public abstract void agendarHorario(String cliente, String servico, String dataHora, String senha);
    public abstract boolean cancelarHorario(String senha);
}