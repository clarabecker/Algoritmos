package laboratorio;
import stack.ArrayStack;
import stack.Stack;

public class JogoBeisebol {
    static Stack<Integer> p = new ArrayStack<>();

    public void placar(String[] pontuacao) {
        for(int i = 0; i< pontuacao.length; i++) {
            if(pontuacao[i].matches("-?\\d+")) {
                String ponto = pontuacao[i];
                p.push(Integer.parseInt(ponto));
            }
            else if(pontuacao[i].equals("+")) {
                int valor = pontuacaoSoma(p);
                p.push(valor);
            }
            else if (pontuacao[i].equalsIgnoreCase("D")) {
                p.push(p.top() * 2);
            }
            else if (pontuacao[i].equalsIgnoreCase("C")) {
                p.pop();
            }
        }
        int soma = 0;

        while (!p.isEmpty()) {
            soma += p.pop();
        }

        System.out.println(soma);
    }

    public int pontuacaoSoma(Stack<Integer> p) {

        if(p.size() > 1) {
            return (p.top() + penultimoElemento(p));
        }
        else
            return 0;
    }

    public int penultimoElemento(Stack<Integer> p) {

        int ultimoElmento = p.pop();
        int penultimoElemento = p.top();

        p.push(ultimoElmento);
        return penultimoElemento;
    }

    public static void main(String[] args) {
        String[] teste = {"5", "2", "C", "D", "+"};
        String[] teste2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        String[] teste3 = {"1", "C"};

        JogoBeisebol jogo = new JogoBeisebol();
        jogo.placar(teste2);
    }
}
