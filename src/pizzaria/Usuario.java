package pizzaria;


public class Usuario {
	private String nome;
	private String telefone;
	
	public Usuario(String nome, String telefone) {
		this.nome= nome;
		this.telefone= telefone;
	}
	 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void atualizarTelefone(String novoTelefone) {
		this.telefone=novoTelefone;
		System.out.println("Telefone Atualizado para: "+ this.telefone);
	}
	
	
}
