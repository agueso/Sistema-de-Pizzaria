package pizzaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Classe que representa um Pedido na pizzaria
public class Pedido {
    // Atributos da classe Pedido
    private int idPedido;
    private LocalDateTime dataHora;
    private int quantidade;
    private String personalizacoes;
    private List<Item> itens;
    private boolean confirmado;

    // Construtor da classe Pedido
    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.itens = new ArrayList<>();
        this.quantidade = 0;
        this.personalizacoes = "";
        this.confirmado = false;
    }

    // Método para realizar o pedido (inicializar data e hora)
    public void realizarPedido() {
        this.dataHora = LocalDateTime.now();
        System.out.println("Pedido #" + idPedido + " realizado em: " + this.dataHora);
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(Item item) {
        if (confirmado) {
            System.out.println("Não é possível adicionar itens a um pedido já confirmado.");
            return;
        }
        itens.add(item);
        quantidade += item.getQuantidade();
        if (item.getPersonalizar() != null && !item.getPersonalizar().isEmpty()) {
            personalizacoes += item.getPersonalizar() + "; ";
        }
        System.out.println("Item adicionado: " + item.getProduto().getNome() + " (Quantidade: " + item.getQuantidade() + ")");
    }

    // Método para confirmar o pedido
    public void confirmarPedido() {
        if (itens.isEmpty()) {
            System.out.println("Não há itens no pedido para confirmar.");
            return;
        }
        this.confirmado = true;
        double total = calcularTotal();
        System.out.println("Pedido #" + idPedido + " confirmado com " + quantidade + " itens. Total: " + String.format("R$ %.2f", total));
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.calcularPrecoTotal();
        }
        return total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getPersonalizacoes() {
        return personalizacoes;
    }

    public List<Item> getItens() {
        return itens;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{")
          .append("idPedido=").append(idPedido)
          .append(", dataHora=").append(dataHora != null ? dataHora : "N/A") // Verifica se dataHora é nulo
          .append(", quantidade=").append(quantidade)
          .append(", personalizacoes='").append(personalizacoes != null && !personalizacoes.isEmpty() ? personalizacoes : "Nenhuma").append('\'') // Verifica personalizacoes
          .append(", confirmado=").append(confirmado)
          .append(", itens=[");

        if (itens != null && !itens.isEmpty()) {
            for (int i = 0; i < itens.size(); i++) {
                sb.append("\n  ").append(itens.get(i).toString());
                if (i < itens.size() - 1) {
                    sb.append(",");
                }
            }
        } else {
            sb.append("Nenhum item");
        }

        sb.append("\n]}");
        return sb.toString();
    }
}
