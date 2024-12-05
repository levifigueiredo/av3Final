public interface Agendamento {
    void agendarHorario(String cliente, String servico, String dataHora, String senha);
    boolean cancelarHorario(String senha);
}