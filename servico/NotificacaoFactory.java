package servico;

public class NotificacaoFactory {
    public static Notificacao criar(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "email" -> new NotificadorEmail();
            case "sms" -> new NotificadorSMS();
            case "whatsapp" -> new NotificadorWhatsApp();
            default -> null;
        };
    }
}