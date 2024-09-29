package pizzaria;
public class Item {
    private Produto produto;
    private int quantidade;
    private String personalizar;

    
    public Item(Produto produto, int quantidade, String personalizar) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.personalizar = personalizar;
    }

    
    public double calcularPrecoTotal() {
        return produto.getValor() * quantidade;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPersonalizar() {
        return personalizar;
    }

    public void setPersonalizar(String personalizar) {
        this.personalizar = personalizar;
    }

    @Override
    public String toString() {
        return "Item{" +
               "produto=" + (produto != null ? produto : "Produto indefinido") +
               ", quantidade=" + quantidade +
               ", personalizar='" + (personalizar != null ? personalizar : "Nenhuma personalização") + '\'' +
               ", precoTotal=" + String.format("R$ %.2f", calcularPrecoTotal()) +
               '}';
    }
}