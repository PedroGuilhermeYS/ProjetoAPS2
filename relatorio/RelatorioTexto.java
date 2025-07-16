package relatorio;

import model.ItemPedido;
import model.Pedido;

public class RelatorioTexto extends RelatorioTemplate {
    protected void cabecalho(Pedido pedido) {
        System.out.println("Cliente: " + pedido.getCliente().getNome());
    }
    protected void corpo(Pedido pedido) {
        System.out.println("Produtos:");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println("- " + item.getProduto().getNome() + " (" + item.getQuantidade() + "x) - R$ " + item.getSubtotal());
        }
    }
    protected void rodape(Pedido pedido) {
        System.out.println("Total: R$ " + pedido.getTotalProdutos());
        System.out.println("Frete: R$ " + pedido.getFrete());
        System.out.println("Total com frete: R$ " + pedido.getTotalComFrete());
    }
}