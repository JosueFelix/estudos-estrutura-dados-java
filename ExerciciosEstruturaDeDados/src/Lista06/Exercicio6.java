package Lista06;

import java.util.Stack;

public class Exercicio6 {
    public static void main(String[] args) {
        String expressao = "((5+2)*(8-3))"; // Usando números para poder calcular
        System.out.println("=== EXERCÍCIO 6: Expressão ===");
        System.out.println("Expressão Original: " + expressao);

        No raiz = montarArvoreExpressao(expressao);

        System.out.print("Notação Central (Infixa): ");
        exibirInfixa(raiz);

        System.out.println("\nResultado do Cálculo: " + calcular(raiz));
    }

    // Monta a árvore usando Pilha
    public static No montarArvoreExpressao(String exp) {
        Stack<No> pilha = new Stack<>();
        Stack<Character> ops = new Stack<>(); // Temporário para lógica simples

        // Obs: Para expressão totalmente parentizada, a lógica é simplificada:
        // Ignora '(', empilha operando, empilha operador.
        // Ao achar ')', desempilha: op, dir, esq -> cria No -> empilha No.

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                // Se for número, cria nó e empilha (lê dígitos seguidos se precisar)
                // Aqui assume 1 dígito para simplificar o exemplo da lista
                pilha.push(new No(Character.getNumericValue(c)));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Guarda operador como Caractere no No (adaptado)
                No op = new No(0); // Valor dummy
                op.caractere = c;
                pilha.push(op);
            } else if (c == ')') {
                // Fecha parênteses: monta a subárvore
                No direita = pilha.pop();
                No operador = pilha.pop();
                No esquerda = pilha.pop();

                operador.esquerda = esquerda;
                operador.direita = direita;
                pilha.push(operador);
            }
        }
        return pilha.peek();
    }

    public static void exibirInfixa(No no) {
        if (no != null) {
            // Se for operador, abre parenteses
            if (no.esquerda != null) System.out.print("(");

            exibirInfixa(no.esquerda);

            if (no.caractere != 0) System.out.print(no.caractere); // Operador
            else System.out.print(no.info); // Número

            exibirInfixa(no.direita);

            if (no.direita != null) System.out.print(")");
        }
    }

    public static int calcular(No no) {
        if (no == null) return 0;
        // Se é folha (número)
        if (no.esquerda == null && no.direita == null) return no.info;

        // Se é operador
        int esq = calcular(no.esquerda);
        int dir = calcular(no.direita);

        switch (no.caractere) {
            case '+': return esq + dir;
            case '-': return esq - dir;
            case '*': return esq * dir;
            case '/': return esq / dir;
        }
        return 0;
    }
}