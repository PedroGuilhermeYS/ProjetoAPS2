package sistemaPedidos;

import model.*;
import servico.*;
import relatorio.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = Sistema.getInstancia();

        while (true) {
            System.out.println("\n&&&& Menu &&&&");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Criar Pedido");
            System.out.println("4 - Relatórios");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("CPF: "); String cpf = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Telefone: "); String tel = sc.nextLine();
                    sistema.adicionarCliente(new Cliente(nome, cpf, email, tel));
                }
                case 2 -> {
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Preço: "); double preco = sc.nextDouble();
                    System.out.print("Peso: "); double peso = sc.nextDouble(); sc.nextLine();
                    sistema.adicionarProduto(new Produto(nome, preco, peso));
                }
                case 3 -> {
                    System.out.println("Clientes:");
                    for (int i = 0; i < sistema.getClientes().size(); i++)
                        System.out.println(i + " - " + sistema.getClientes().get(i).getNome());
                    System.out.print("Escolha cliente: ");
                    Cliente cliente = sistema.getClientes().get(sc.nextInt());

                    List<ItemPedido> itens = new ArrayList<>();
            
                    System.out.println("Produtos:");
                    for (int i = 0; i < sistema.getProdutos().size(); i++)
                        System.out.println(i + " - " + sistema.getProdutos().get(i).getNome());
                    System.out.print("Escolha produto: ");
                    int escolha = sc.nextInt();
                    if (escolha == -1) break;
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    itens.add(new ItemPedido(sistema.getProdutos().get(escolha), qtd));
                    

                    System.out.println("1 - Frete por peso | 2 - Frete por distância");
                    FreteStrategy frete = sc.nextInt() == 1 ? new FreteCalculadoraPeso() : new FreteCalculadoraDistancia();

                    Pedido pedido = new Pedido(cliente, itens, frete);

                    System.out.print("Notificar por (email/sms/whatsapp): ");
                    pedido.setNotificador(NotificacaoFactory.criar(sc.next()));

                    pedido.confirmar();
                    sistema.adicionarPedido(pedido);
                }
                case 4 -> {
                    for (int i = 0; i < sistema.getPedidos().size(); i++)
                        System.out.println(i + " - Pedido de " + sistema.getPedidos().get(i).getCliente().getNome());
                    System.out.print("Escolha pedido: ");
                    Pedido pedido = sistema.getPedidos().get(sc.nextInt());
                    System.out.print("Formato (texto/json): ");
                    String formato = sc.next();
                    RelatorioTemplate relatorio = formato.equalsIgnoreCase("json") ? new RelatorioJSON() : new RelatorioTexto();
                    relatorio.gerar(pedido);
                }
                case 5 -> {
                    System.out.println("Saindo...");
                    return;
                }
            }
        }
    }
}