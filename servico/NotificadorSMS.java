package servico;

import model.Cliente;

public class NotificadorSMS implements Notificacao {
    public void notificar(Cliente cliente) {
        System.out.println("Enviando SMS para o número: " + cliente.getTelefone() + ". Do cliente: " + cliente.getNome());
    }
}