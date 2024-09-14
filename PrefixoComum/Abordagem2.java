import java.util.Arrays;

public class Abordagem2 {
    public static void main(String[] args) {
        GeradorInstacia gerador = new GeradorInstacia();

        String[][] instancias = new String[18][];

        instancias = gerador.gerarListaInstancia(instancias);

        for (int i = 0; i < instancias.length; i++) {
            String[] arrayAtual = instancias[i];

            long comecoexecucao = System.nanoTime();

            String ans = prefixoComum(arrayAtual);

            long fimexecucao = System.nanoTime();

            long duracao = fimexecucao-comecoexecucao;

            double duracaoSegundos = duracao/  1_000_000_000.0;

            if (ans.length() > 0) {
                System.out.println("Instância " + (i + 1) + " - Prefixo comum: " + ans);
            } else {
                System.out.println("Instância " + (i + 1) + " - Não possui prefixo comum");
            }

            System.out.printf("Tempo de execução: %.9f segundos%n", duracaoSegundos);
        }
    }
        static String prefixoComum (String arr[]){
            int n = arr.length;
            Arrays.sort(arr);

            String comparacao = arr[0];

            int minLength = Math.min(comparacao.length(), arr[n - 1].length());
            int index = 0;

            while (index < minLength && comparacao.charAt(index) == arr[n - 1].charAt(index)) {
                index++;
            }

            comparacao = comparacao.substring(0, index);

            return comparacao;
        }

}
