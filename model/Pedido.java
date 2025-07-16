package model;

import servico.*;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens;
    private double frete;
    private Notificacao notificador;

    public Pedido(Cliente cliente, List<ItemPedido> itens, FreteStrategy freteStrategy) {
        this.cliente = cliente;
        this.itens = itens;
        this.frete = freteStrategy.calcular(this);
    }

    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public double getTotalProdutos() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }
    public double getPesoTotal() {
        return itens.stream().mapToDouble(ItemPedido::getPesoTotal).sum();
    }
    public double getFrete() { return frete; }
    public double getTotalComFrete() { return getTotalProdutos() + frete; }

    public void setNotificador(Notificacao notificador) {
        this.notificador = notificador;
    }

    public void confirmar() {
        if (notificador != null) {
            notificador.notificar(cliente);
        }
    }
}