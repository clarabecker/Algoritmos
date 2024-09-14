import java.util.Random;

public class GeradorInstacia {
    private static final String caracteresbase = "abcd";
    private static final Random RANDOM = new Random();

    static String[] geradorInstancias(int tamanho) {
        int tamanhoBase = 5 + RANDOM.nextInt(6);
        StringBuilder sb = new StringBuilder(tamanhoBase);
        for (int i = 0; i < tamanhoBase; i++) {
            sb.append(caracteresbase.charAt(RANDOM.nextInt(caracteresbase.length())));
        }

        String stringBase = sb.toString();

        String[] colecaoAtualizada = new String[0];

        while (colecaoAtualizada.length < tamanho) {
            String modificada = modificarString(stringBase, tamanhoBase);

            String[] novoVetor = new String[colecaoAtualizada.length + 1];

            System.arraycopy(colecaoAtualizada, 0, novoVetor, 0, colecaoAtualizada.length);

            novoVetor[colecaoAtualizada.length] = modificada;

            colecaoAtualizada = novoVetor;
        }

        return colecaoAtualizada;
    }

    private static String modificarString(String Stringbase, int tamanhoBase) {
        char[] caracteres = Stringbase.toCharArray();

        for (int i = 0; i < tamanhoBase; i++) {
            double probabilidadeModificacao = (i + 1.0) / tamanhoBase;
            if (RANDOM.nextDouble() < probabilidadeModificacao) {
                caracteres[i] = caracteresbase.charAt(RANDOM.nextInt(caracteresbase.length()));
            }
        }
        return new String(caracteres);
    }

    public static String[][] gerarListaInstancia(String[][] instancias) {

        for (int i = 2; i <= instancias.length + 1; i++) {
            int tamanho = (int) Math.pow(2, i);
            instancias[i - 2] = geradorInstancias(tamanho);
        }

        for (int i = 0; i < instancias.length; i++) {
            System.out.println("Instância " + (i + 1) + " (tamanho " + (int) Math.pow(2, i + 2) + "):");
            for (String s : instancias[i]) {
                System.out.println(s);
            }
            System.out.println();
        }

        return instancias;
    }
}
