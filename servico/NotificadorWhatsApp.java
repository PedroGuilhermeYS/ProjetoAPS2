package servico;

import model.Cliente;

public class NotificadorWhatsApp implements Notificacao {
    public void notificar(Cliente cliente) {
        System.out.println("Enviando mensagem no zap para o número: " + cliente.getTelefone() + ". Do cliente: " + cliente.getNome());
    }
}