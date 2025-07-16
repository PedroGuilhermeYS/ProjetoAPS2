package servico;

import model.Pedido;

public class FreteCalculadoraPeso implements FreteStrategy {
    public double calcular(Pedido pedido) {
        return pedido.getPesoTotal() * 5.0;
    }
}
