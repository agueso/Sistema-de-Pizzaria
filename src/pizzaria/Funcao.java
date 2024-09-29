package pizzaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcao {
	 Scanner scanner = new Scanner(System.in);
	 
	    private ArrayList<Cliente> clientes;
	    
	    public Cliente criarCliente(Scanner scanner) {  	
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

	    public  Produto criarProduto(Scanner scanner) {
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

	    public  void  exibirDetalhesClientes (ArrayList<Cliente> clientes) {
	        System.out.println("\nDetalhes dos clientes cadastrados:");
	        for (Cliente cliente : clientes) {
	            System.out.println("Nome: " + cliente.getNome());
	            System.out.println("Telefone: " + cliente.getTelefone());
	            System.out.println("Email: " + cliente.getEmail());
	            System.out.println("Endereço: " + cliente.getEndereco());
	            System.out.println("-------------------------------");
	        }
	    }

	    public void exibirDetalhesProdutos(ArrayList<Produto> produtos) {
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

	    public  void atualizarTelefoneCliente(Scanner scanner, ArrayList<Cliente> clientes) {
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

	    public  void autenticarCliente(Scanner scanner, ArrayList<Cliente> clientes) {
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

	    public  void removerProduto(Scanner scanner, ArrayList<Produto> produtos) {
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
	    public  void removerCliente(Scanner scanner, ArrayList<Cliente> clientes) {
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
	    public  Pedido realizarPedido(Scanner scanner, ArrayList<Produto> produtos) {
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

	    public  void listarPedidos(ArrayList<Pedido> pedidos) {
	        System.out.println("\nPedidos realizados:");
	        if (pedidos.isEmpty()) {
	            System.out.println("Nenhum pedido realizado.");
	        } else {
	            for (Pedido pedido : pedidos) {
	                System.out.println(pedido);
	            }
	        }
	    }

	    public  void verificarStatusEntrega(Scanner scanner, ArrayList<Pedido> pedidos) {
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

	    public  void mudarStatusEntrega(Scanner scanner, ArrayList<Pedido> pedidos) {
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
