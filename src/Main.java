import java.util.*;

public class Main implements Agendamento, Notificacao, Avaliacao {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> agendamentos = new HashMap<>();
    private static List<String> notificacoes = new ArrayList<>();

    public static void main(String[] args) {
        Main sistema = new Main();
        int opcao;
        do {
            sistema.exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> sistema.fazerAgendamento();
                case 2 -> sistema.cancelarAgendamento();
                case 3 -> sistema.comprarProduto();
                case 4 -> sistema.pagarServico();
                case 5 -> sistema.enviarFeedback();
                case 6 -> sistema.sair();
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }

    private void exibirMenu() {
        System.out.println("Bem vindo a Barbearia Legal!");
        System.out.println("1) Realizar Agendamento");
        System.out.println("2) Cancelar Agendamento");
        System.out.println("3) Produtos");
        System.out.println("4) Pagar Serviço");
        System.out.println("5) Feedback");
        System.out.println("6) Sair Do Menu");
        System.out.print("Escolha uma opção: ");
    }

    private void fazerAgendamento() {
        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Escolha seu serviço (1- Barba R$30, 2- Cabelo R$40): ");
        int servico = scanner.nextInt();
        scanner.nextLine();
        String tipoServico = servico == 1 ? "Barba" : "Cabelo";
        double preco = servico == 1 ? 30.0 : 40.0;

        System.out.print("Informe a data e a hora do seu agendamento: ");
        String dataHora = scanner.nextLine();
        System.out.print("Escolha uma senha para o seu agendamento: ");
        String senha = scanner.nextLine();

        agendarHorario(nome, tipoServico + " - R$" + preco, dataHora, senha);
    }

    private void cancelarAgendamento() {
        System.out.print("Informe a senha de agendamento: ");
        String senha = scanner.nextLine();
        cancelarHorario(senha);
    }

    private void comprarProduto() {
        System.out.println("Produtos Disponíveis:");
        System.out.println("1. Gel de Pentear (R$25)");
        System.out.println("2. Minoxidil (R$20)");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        String produto = escolha == 1 ? "Gel de Pentear - R$25" : "Minoxidil - R$20";

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão");
        System.out.println("2. Pix");
        int pagamentoEscolha = scanner.nextInt();
        scanner.nextLine();

        if (pagamentoEscolha == 1) {
            System.out.println("Escolha o tipo de cartão:");
            System.out.println("1. Crédito");
            System.out.println("2. Débito");
            int tipoCartao = scanner.nextInt();
            scanner.nextLine();
            String tipo = tipoCartao == 1 ? "Crédito" : "Débito";
            enviarNotificacao("Pagamento via " + tipo + " realizado para " + produto);
        } else if (pagamentoEscolha == 2) {
            enviarNotificacao("Pagamento via Pix realizado para " + produto);
        } else {
            System.out.println("Opção de pagamento inválida.");
            return;
        }

        System.out.println("Compra realizada com sucesso: " + produto);
    }

    private void pagarServico() {
        System.out.print("Digite a senha do agendamento: ");
        String senha = scanner.nextLine();

        if (agendamentos.containsKey(senha)) {
            System.out.println("Detalhes do serviço: " + agendamentos.get(senha));

            System.out.println("Escolha a forma de pagamento:");
            System.out.println("1. Cartão");
            System.out.println("2. Pix");
            int pagamentoEscolha = scanner.nextInt();
            scanner.nextLine();

            if (pagamentoEscolha == 1) {
                System.out.println("Escolha o tipo de cartão:");
                System.out.println("1. Crédito");
                System.out.println("2. Débito");
                int tipoCartao = scanner.nextInt();
                scanner.nextLine();
                String tipo = tipoCartao == 1 ? "Crédito" : "Débito";
                enviarNotificacao("Pagamento via " + tipo + " realizado para o serviço.");
            } else if (pagamentoEscolha == 2) {
                enviarNotificacao("Pagamento via Pix realizado para o serviço.");
            } else {
                System.out.println("Opção de pagamento inválida.");
                return;
            }

            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Nenhum agendamento encontrado com essa senha.");
        }
    }

    private void enviarFeedback() {
        System.out.print("Avalie nosso serviço (1 a 5 estrelas): ");
        int estrelas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite seu comentário: ");
        String comentario = scanner.nextLine();
        avaliarServico(estrelas, comentario);
    }

    private void sair() {
        System.out.println("Obrigado por escolher a Barbearia Legal!");
        System.out.println("Notificações:");
        for (String notificacao : notificacoes) {
            System.out.println("- " + notificacao);
        }
    }

    @Override
    public void agendarHorario(String cliente, String servico, String dataHora, String senha) {
        agendamentos.put(senha, servico + " - " + dataHora);
        enviarNotificacao("Agendamento marcado: " + cliente + ": " + servico + " em " + dataHora);
        System.out.println("Agendamento realizado com sucesso!");
    }

    @Override
    public boolean cancelarHorario(String senha) {
        if (agendamentos.containsKey(senha)) {
            agendamentos.remove(senha);
            enviarNotificacao("Agendamento cancelado com sucesso.");
            System.out.println("Agendamento cancelado com sucesso!");
        } else {
            System.out.println("Agendamento não encontrado.");
        }
        return false;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        notificacoes.add(mensagem);
    }

    @Override
    public void avaliarServico(int estrelas, String comentario) {
        enviarNotificacao("Feedback recebido: " + estrelas + " estrelas. Comentário: " + comentario);
        System.out.println("Obrigado pelo feedback!");
    }
}
