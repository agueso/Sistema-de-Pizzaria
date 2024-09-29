package pizzaria;
import java.util.ArrayList;
import java.util.Scanner;



public class Cliente extends Usuario {
    private String email;
    private String endereco;
    private String senha;
    Scanner scanner = new Scanner(System.in);
    
    public Cliente(String nome, String telefone, String email,
    		String endereco, String senha) {
        super(nome,telefone); //vem da herança
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
	public void cadastrarCliente() {
		System.out.println("Cliente "+ getNome() + " cadastrado com sucesso.");
	}
    
	public boolean autenticarCliente(String SenhaInformada) {
		if(this.senha.equals(SenhaInformada)) {
			System.out.print("Autentificação bem-sucedida!");
			return true;
		} else {
			System.out.print("Falha na autenticação");
			return false;
		}
	}
	
	 private  void  exibirDetalhesClientes (ArrayList<Cliente> clientes) {
	        System.out.println("\nDetalhes dos clientes cadastrados:");
	        for (Cliente cliente : clientes) {
	            System.out.println("Nome: " + cliente.getNome());
	            System.out.println("Telefone: " + cliente.getTelefone());
	            System.out.println("Email: " + cliente.getEmail());
	            System.out.println("Endereço: " + cliente.getEndereco());
	            System.out.println("-------------------------------");
	        }
	    }
	
}