package pizzaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	//ClienteService clienteService = new ClienteService();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Funcao c = new Funcao();
        ArrayList<Produto> produtos = new ArrayList<>();
        Funcao p = new Funcao();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--------------Menu------------------");
            System.out.println("|1. Cadastrar Cliente                |");
            System.out.println("|2. Cadastrar Produto                |");
            System.out.println("|3. Exibir Detalhes dos Clientes     |");
            System.out.println("|4. Exibir Detalhes dos Produtos     |");
            System.out.println("|5. Atualizar Telefone de um Cliente |");
            System.out.println("|6. Autenticar Cliente               |");
            System.out.println("|7. Remover Produto                  |");
            System.out.println("|8. Remover Cliente                  |");
            System.out.println("|9. Realizar Pedido                  |");
            System.out.println("|10. Listar Pedidos                  |");
            System.out.println("|11. Verificar Status de Entrega     |");
            System.out.println("|12. Mudar Status de Entrega         |");
            System.out.println("|13. Sair                             |");
            System.out.print("|- Escolha uma opção:                |");
            System.out.println("\n-----------------------------------");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                	Cliente cliente =c.criarCliente(scanner) ;
                	clientes.add(cliente); 
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    Produto produto = p.criarProduto(scanner);
                    produtos.add(produto);
                    produto.cadastraProduto();
                    break;

                case 3:
                    if (!clientes.isEmpty()) {
                    	c.exibirDetalhesClientes(clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado.");
                    }
                    break;

                case 4:
                    if (!produtos.isEmpty()) {
                        p.exibirDetalhesProdutos(produtos);
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    break;

                case 5:
                    if (!clientes.isEmpty()) {
                        c.atualizarTelefoneCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para atualizar telefone.");
                    }
                    break;

                case 6:
                    if (!clientes.isEmpty()) {
                        c.autenticarCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para autenticação.");
                    }
                    break;

                case 7:
                    if (!produtos.isEmpty()) {
                        p.removerProduto(scanner, produtos);
                    } else {
                        System.out.println("Nenhum produto cadastrado para remover.");
                    }
                    break;
                    
                case 8: 
                    if (!clientes.isEmpty()) {
                        c.removerCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para remover.");
                    }
                    break;
                case 9: // Realizar Pedido
                    if (!produtos.isEmpty()) {
                        Pedido pedido = p.realizarPedido(scanner, produtos);
                        pedidos.add(pedido);
                        pedido.realizarPedido();
                    } else {
                        System.out.println("Nenhum produto disponível para realizar o pedido.");
                    }
                    break;

                case 10: // Listar Pedidos
                    p.listarPedidos(pedidos);
                    break;

                case 11: // Verificar Status de Entrega
                    p.verificarStatusEntrega(scanner, pedidos);
                    break;

                case 12: // Mudar Status de Entrega
                    p.mudarStatusEntrega(scanner, pedidos);
                    break;

                case 13:
                    continuar = false;
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        }

        scanner.close();
    }

    
}

