package laboratórios;

import java.util.Scanner;
import stack.ArrayStack;
import stack.Stack;

public class DiamanteAreia {
    static Stack<String> p = new ArrayStack<>();

    public int minerar(String d[]) {
        int result = 0;

        for(int i=0; i <d.length; i++) {
            if(d[i].equals("<")) {
                p.push(d[i]);
            }
            if (d[i].equals(">") && !p.isEmpty()) {
                 result++;
                 p.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        for(int i = 0; i < N; i++) {
            String linha = s.nextLine();
            String[] d = linha.split("");

            DiamanteAreia diamante = new DiamanteAreia();

            System.out.println(diamante.minerar(d));
        }

    }
}
