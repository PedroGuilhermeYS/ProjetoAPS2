package servico;

import model.Pedido;
import java.util.Scanner;

public class FreteCalculadoraDistancia implements FreteStrategy {
    public double calcular(Pedido pedido) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe a distância (km): ");
        double distancia = sc.nextDouble();
        return distancia * 0.5;
    }
}