package laboratórios;
import queue.ArrayQueue;
import utils.Point;

import java.util.HashMap;
import java.util.Scanner;

public class ListaNomes {

    public void ordenarLista(String[] nomes) {
        ArrayQueue<String> queue = new ArrayQueue<>();
        HashMap<Integer, String> ListaNomes = new HashMap<Integer, String>();

        for(String nome : nomes) {
            int tamanho = nome.length();
            if (!ListaNomes.containsKey(tamanho)) {
                ListaNomes.put(tamanho, nome);
            } else {
                queue.enqueue(nome);
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
