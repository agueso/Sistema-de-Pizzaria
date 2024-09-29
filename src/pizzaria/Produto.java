package pizzaria;

public class Produto {
	private String nome;
	private double valor;
	private int codigo;
	private String tamanho;
	private String descricao;
	
	public Produto(String nome, double valor,
			int codigo, String tamanho, String descricao) {
		this.nome = nome;
		this.valor =valor;
		this.tamanho = tamanho;
		this.descricao = descricao;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void cadastraProduto() {
		System.out.println("Produto " + this.nome + " cadastrado com sucesso. ");
	}
	
	public void removerProduto() {
		System.out.println("Produto " + this.nome + " removido com sucesso. ");
	}
	
}
