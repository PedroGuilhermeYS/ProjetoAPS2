package servico;

import model.Pedido;

public interface FreteStrategy {
    double calcular(Pedido pedido);
}