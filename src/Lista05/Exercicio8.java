package Lista05;

public class Exercicio8 {
    public static void main(String[] args) {
        int tamanho = 10;
        Integer[] tabela = new Integer[tamanho];
        int[] concluidas = {101, 204, 303, 404, 505};

        // Inserção
        for (int m : concluidas) {
            tabela[m % tamanho] = m;
        }

        // Busca
        int busca = 303; // Número para testar
        int hash = busca % tamanho;

        System.out.println("=== Bat-Computador ===");
        if (tabela[hash] != null && tabela[hash] == busca) {
            System.out.println("Missão " + busca + ": CONCLUÍDA.");
        } else {
            System.out.println("Missão " + busca + ": NÃO ENCONTRADA.");
        }
    }
}