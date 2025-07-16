package sistemaPedidos;

import model.*;
import java.util.*;

public class Sistema {
    private static Sistema instancia;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private Sistema() {}

    public static Sistema getInstancia() {
        if (instancia == null) instancia = new Sistema();
        return instancia;
    }

    public List<Cliente> getClientes() { return clientes; }
    public List<Produto> getProdutos() { return produtos; }
    public List<Pedido> getPedidos() { return pedidos; }

    public void adicionarCliente(Cliente c) { clientes.add(c); }
    public void adicionarProduto(Produto p) { produtos.add(p); }
    public void adicionarPedido(Pedido p) { pedidos.add(p); }
}