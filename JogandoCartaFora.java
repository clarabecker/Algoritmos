package laboratorio;
import list.ArrayList;
import stack.ArrayStack;

import java.util.Scanner;

public class JogandoCartaFora {
    static ArrayList<Integer> cartas = new ArrayList<>();
    static ArrayList<Integer> descartadas = new ArrayList<>();

    public void descarteCartas() {

        while (cartas.size() > 1) {
            int descartada = cartas.get(0);
            descartadas.add(descartada);
            cartas.remove(0);

            int moverParaFinal = cartas.get(0);
            cartas.remove(0);
            cartas.add(moverParaFinal);
        }

        int ultimaCarta = cartas.get(0);

        System.out.print("Discarded: ");
        for (int i = 0; i < descartadas.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(descartadas.get(i));
        }

        System.out.println(" ");
        System.out.print("Remaining: ");
        System.out.print(ultimaCarta);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        for (int i = 1; i <= N ; i++) {
            cartas.add(i);
        }

        JogandoCartaFora cartaFora = new JogandoCartaFora();

        cartaFora.descarteCartas();
    }
}
