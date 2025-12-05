package Lista05;

public class Exercicio9 {
    public static void main(String[] args) {
        int tamanho = 11;
        String[] tabela = new String[tamanho];
        String[] palavras = {"oraculo", "sombra", "codigo", "iluminatti", "agenda"};

        System.out.println("=== Teoria da Conspiração ===");
        for (String p : palavras) {
            int soma = 0;
            for (char c : p.toCharArray()) soma += c;

            int hash = soma % tamanho;
            // Tratamento simples de colisão linear caso precise
            while (tabela[hash] != null) hash = (hash + 1) % tamanho;

            tabela[hash] = p;
            System.out.println("Palavra '" + p + "' no índice " + hash);
        }
    }
}