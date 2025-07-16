package relatorio;

import model.ItemPedido;
import model.Pedido;

public class RelatorioJSON extends RelatorioTemplate {
    protected void cabecalho(Pedido pedido) {
        System.out.println("{");
        System.out.println("  \"cliente\": \"" + pedido.getCliente().getNome() + "\",");
    }
    protected void corpo(Pedido pedido) {
        System.out.println("  \"produtos\": [");
        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemPedido item = pedido.getItens().get(i);
            System.out.print("    {\"nome\": \"" + item.getProduto().getNome() + "\", \"quantidade\": " + item.getQuantidade() + ", \"preco\": " + item.getSubtotal() + "}");
            if (i < pedido.getItens().size() - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("  ],");
    }
    protected void rodape(Pedido pedido) {
        System.out.println("  \"total\": " + pedido.getTotalProdutos() + ",");
        System.out.println("  \"frete\": " + pedido.getFrete() + ",");
        System.out.println("  \"total_com_frete\": " + pedido.getTotalComFrete());
        System.out.println("}");
    }
}
