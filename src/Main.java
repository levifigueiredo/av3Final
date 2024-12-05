import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> agendamentos = new HashMap<>(); // Senha -> Detalhes do agendamento
    private static List<String> notificacoes = new ArrayList<>(); // Lista de notificações

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            switch (opcao) {
                case 1 -> fazerAgendamento();
                case 2 -> cancelarAgendamento();
                case 3 -> comprarProduto();
                case 4 -> pagarServico();
                case 5 -> enviarFeedback();
                case 6 -> sair();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu - Sistema Barbearia =====");
        System.out.println("1. Fazer Agendamento");
        System.out.println("2. Cancelar Agendamento");
        System.out.println("3. Comprar Produto");
        System.out.println("4. Pagar Serviço");
        System.out.println("5. Enviar Feedback");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void fazerAgendamento() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Escolha o serviço (1- Corte de Barba R$30, 2- Corte de Cabelo R$40): ");
        int servico = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        String tipoServico = servico == 1 ? "Corte de Barba" : "Corte de Cabelo";
        double preco = servico == 1 ? 30.0 : 40.0;

        System.out.print("Digite a data e hora do agendamento (ex: 15/12/2024 14:00): ");
        String dataHora = scanner.nextLine();
        System.out.print("Crie uma senha para o agendamento: ");
        String senha = scanner.nextLine();

        agendamentos.put(senha, tipoServico + " - R$" + preco + " - " + dataHora);
        notificacoes.add("Agendamento criado com sucesso para " + tipoServico + " em " + dataHora);
        System.out.println("Agendamento realizado com sucesso!");
    }

    private static void cancelarAgendamento() {
        System.out.print("Digite a senha do agendamento: ");
        String senha = scanner.nextLine();

        if (agendamentos.containsKey(senha)) {
            agendamentos.remove(senha);
            notificacoes.add("Agendamento cancelado com sucesso.");
            System.out.println("Agendamento cancelado com sucesso!");
        } else {
            System.out.println("Agendamento não encontrado.");
        }
    }

    private static void comprarProduto() {
        System.out.println("Escolha o produto:");
        System.out.println("1. Pomada para Cabelo (R$25)");
        System.out.println("2. Pomada para Barba (R$20)");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        String produto = escolha == 1 ? "Pomada para Cabelo - R$25" : "Pomada para Barba - R$20";

        // Escolha da forma de pagamento
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão");
        System.out.println("2. Pix");
        int pagamentoEscolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (pagamentoEscolha == 1) {
            System.out.println("Escolha o tipo de cartão:");
            System.out.println("1. Crédito");
            System.out.println("2. Débito");
            int tipoCartao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            String tipo = tipoCartao == 1 ? "Crédito" : "Débito";
            System.out.println("Pagamento via " + tipo + " realizado com sucesso.");
        } else if (pagamentoEscolha == 2) {
            System.out.println("Pagamento via Pix realizado com sucesso.");
        } else {
            System.out.println("Opção de pagamento inválida.");
            return;
        }

        notificacoes.add("Produto comprado: " + produto);
        System.out.println("Compra realizada com sucesso: " + produto);
    }

    private static void pagarServico() {
        System.out.print("Digite a senha do agendamento: ");
        String senha = scanner.nextLine();

        if (agendamentos.containsKey(senha)) {
            System.out.println("Detalhes do serviço: " + agendamentos.get(senha));

            // Escolha da forma de pagamento
            System.out.println("Escolha a forma de pagamento:");
            System.out.println("1. Cartão");
            System.out.println("2. Pix");
            int pagamentoEscolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            if (pagamentoEscolha == 1) {
                System.out.println("Escolha o tipo de cartão:");
                System.out.println("1. Crédito");
                System.out.println("2. Débito");
                int tipoCartao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                String tipo = tipoCartao == 1 ? "Crédito" : "Débito";
                System.out.println("Pagamento via " + tipo + " realizado com sucesso.");
            } else if (pagamentoEscolha == 2) {
                System.out.println("Pagamento via Pix realizado com sucesso.");
            } else {
                System.out.println("Opção de pagamento inválida.");
                return;
            }

            notificacoes.add("Pagamento realizado para o serviço: " + agendamentos.get(senha));
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Nenhum agendamento encontrado com essa senha.");
        }
    }

    private static void enviarFeedback() {
        System.out.print("Avalie nosso serviço (1 a 5 estrelas): ");
        int estrelas = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Digite seu comentário: ");
        String comentario = scanner.nextLine();

        notificacoes.add("Feedback recebido: " + estrelas + " estrelas. Comentário: " + comentario);
        System.out.println("Obrigado pelo feedback!");
    }

    private static void sair() {
        System.out.println("Saindo do sistema... Obrigado!");
        System.out.println("Notificações realizadas:");
        for (String notificacao : notificacoes) {
            System.out.println("- " + notificacao);
        }
    }
}