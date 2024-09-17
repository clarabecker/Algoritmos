package laboratórios;
import java.util.*;

import java.util.HashMap;
import java.util.Scanner;

public class ListaNomes {

    public void ordenarLista(String[] nomes) {
        List<String>[] gruposPorTamanho = new ArrayList[11];

        for (int i = 2; i <= 10; i++) {
            gruposPorTamanho[i] = new ArrayList<>();
        }

        for (String nome : nomes) {
            int tamanho = nome.length();
            gruposPorTamanho[tamanho].add(nome);
        }

        boolean haNomesRestantes = true;

        while (haNomesRestantes) {
            haNomesRestantes = false;
            List<String> linhaAtual = new ArrayList<>();

            for (int tamanho = 2; tamanho <= 10; tamanho++) {
                if (!gruposPorTamanho[tamanho].isEmpty()) {
                    linhaAtual.add(gruposPorTamanho[tamanho].remove(0));
                    haNomesRestantes = true;
                }
            }

            if (!linhaAtual.isEmpty()) {
                System.out.println(String.join(", ", linhaAtual));
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();

        String nomes[] = new String[N];
        for (int i = 0; i < N; i++) {
            nomes[i] = s.next();
            s.nextLine();
        }

        ListaNomes lista = new ListaNomes();
        lista.ordenarLista(nomes);
    }
}
