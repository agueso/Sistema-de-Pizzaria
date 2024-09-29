package pizzaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
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
                    Cliente cliente = criarCliente(scanner);
                    clientes.add(cliente);
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    Produto produto = criarProduto(scanner);
                    produtos.add(produto);
                    produto.cadastraProduto();
                    break;

                case 3:
                    if (!clientes.isEmpty()) {
                        exibirDetalhesClientes(clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado.");
                    }
                    break;

                case 4:
                    if (!produtos.isEmpty()) {
                        exibirDetalhesProdutos(produtos);
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    break;

                case 5:
                    if (!clientes.isEmpty()) {
                        atualizarTelefoneCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para atualizar telefone.");
                    }
                    break;

                case 6:
                    if (!clientes.isEmpty()) {
                        autenticarCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para autenticação.");
                    }
                    break;

                case 7:
                    if (!produtos.isEmpty()) {
                        removerProduto(scanner, produtos);
                    } else {
                        System.out.println("Nenhum produto cadastrado para remover.");
                    }
                    break;
                    
                case 8: 
                    if (!clientes.isEmpty()) {
                        removerCliente(scanner, clientes);
                    } else {
                        System.out.println("Nenhum cliente cadastrado para remover.");
                    }
                    break;
                case 9: // Realizar Pedido
                    if (!produtos.isEmpty()) {
                        Pedido pedido = realizarPedido(scanner, produtos);
                        pedidos.add(pedido);
                        pedido.realizarPedido();
                    } else {
                        System.out.println("Nenhum produto disponível para realizar o pedido.");
                    }
                    break;

                case 10: // Listar Pedidos
                    listarPedidos(pedidos);
                    break;

                case 11: // Verificar Status de Entrega
                    verificarStatusEntrega(scanner, pedidos);
                    break;

                case 12: // Mudar Status de Entrega
                    mudarStatusEntrega(scanner, pedidos);
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

    private static Cliente criarCliente(Scanner scanner) {
        System.out.println("Cadastrar novo cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Cliente(nome, telefone, email, endereco, senha);
    }

    private static Produto criarProduto(Scanner scanner) {
        System.out.println("Cadastrar novo produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        return new Produto(nome, valor, codigo, tamanho, descricao);
    }

    private static void exibirDetalhesClientes(ArrayList<Cliente> clientes) {
        System.out.println("\nDetalhes dos clientes cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("-------------------------------");
        }
    }

    private static void exibirDetalhesProdutos(ArrayList<Produto> produtos) {
        System.out.println("\nDetalhes dos produtos cadastrados:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Valor: R$" + produto.getValor());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Tamanho: " + produto.getTamanho());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("-------------------------------");
        }
    }

    private static void atualizarTelefoneCliente(Scanner scanner, ArrayList<Cliente> clientes) {
        System.out.println("\nDigite o nome do cliente cujo telefone deseja atualizar:");
        String nomeCliente = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.print("Digite um novo telefone para atualizar: ");
            String novoTelefone = scanner.nextLine();
            clienteEncontrado.atualizarTelefone(novoTelefone);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void autenticarCliente(Scanner scanner, ArrayList<Cliente> clientes) {
        System.out.println("\nDigite o nome do cliente para autenticação:");
        String nomeCliente = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.print("Digite a senha para autenticação: ");
            String senhaInformada = scanner.nextLine();
            boolean autenticacaoSucesso = clienteEncontrado.autenticarCliente(senhaInformada);
            
            if (autenticacaoSucesso) {
                System.out.println("Cliente autenticado e pronto para realizar pedidos!");
            } else {
                System.out.println("Falha na autenticação. Verifique suas credenciais.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removerProduto(Scanner scanner, ArrayList<Produto> produtos) {
        System.out.println("\nDigite o nome do produto que deseja remover:");
        String nomeProduto = scanner.nextLine();
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoRemover = produto;
                break;
            }
        }

        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            produtoRemover.removerProduto();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    private static void removerCliente(Scanner scanner, ArrayList<Cliente> clientes) {
        System.out.println("\nDigite o nome do cliente que deseja remover:");
        String nomeCliente = scanner.nextLine();
        Cliente clienteRemover = null;

        // Procurar cliente pelo nome
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteRemover = cliente;
                break;
            }
        }

        // Verificar se o cliente foi encontrado e removê-lo
        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente " + clienteRemover.getNome() + " removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    private static Pedido realizarPedido(Scanner scanner, ArrayList<Produto> produtos) {
        System.out.println("\nRealizar novo pedido:");
        System.out.print("ID do Pedido: ");
        int idPedido = scanner.nextInt();
        Pedido pedido = new Pedido(idPedido);

        boolean adicionarMaisItens = true;
        while (adicionarMaisItens) {
            System.out.println("\nEscolha um produto para adicionar ao pedido:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " (R$" + produtos.get(i).getValor() + ")");
            }
            int opcaoProduto = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir a nova linha

            if (opcaoProduto >= 0 && opcaoProduto < produtos.size()) {
                Produto produtoEscolhido = produtos.get(opcaoProduto);
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Personalização (opcional): ");
                String personalizacao = scanner.nextLine();

                Item item = new Item(produtoEscolhido, quantidade, personalizacao);
                pedido.adicionarItem(item);
            } else {
                System.out.println("Produto inválido.");
            }

            System.out.print("Deseja adicionar mais itens? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                adicionarMaisItens = false;
            }
        }

        pedido.confirmarPedido();
        return pedido;
    }

    private static void listarPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("\nPedidos realizados:");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    private static void verificarStatusEntrega(Scanner scanner, ArrayList<Pedido> pedidos) {
        System.out.print("\nDigite o ID do pedido para verificar status de entrega: ");
        int idPedido = scanner.nextInt();
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado != null) {
            String status = pedidoEncontrado.isConfirmado() ? "Entregue" : "Não entregue";
            System.out.println("O pedido #" + idPedido + " está " + status + ".");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private static void mudarStatusEntrega(Scanner scanner, ArrayList<Pedido> pedidos) {
        System.out.print("\nDigite o ID do pedido para mudar o status de entrega: ");
        int idPedido = scanner.nextInt();
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado != null) {
            System.out.print("Deseja marcar como entregue? (s/n): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("s")) {
                pedidoEncontrado.confirmarPedido();
                System.out.println("Status do pedido #" + idPedido + " atualizado para entregue.");
            } else {
                System.out.println("Nenhuma alteração realizada.");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }
    
}

