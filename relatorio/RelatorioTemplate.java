package relatorio;

import model.Pedido;

public abstract class RelatorioTemplate {
    public final void gerar(Pedido pedido) {
        cabecalho(pedido);
        corpo(pedido);
        rodape(pedido);
    }

    protected abstract void cabecalho(Pedido pedido);
    protected abstract void corpo(Pedido pedido);
    protected abstract void rodape(Pedido pedido);
}