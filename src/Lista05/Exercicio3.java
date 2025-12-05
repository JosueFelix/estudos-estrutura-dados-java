package Lista05;

import java.util.Random;

public class Exercicio3 {
    public static void main(String[] args) {
        int tamanho = 11;
        Integer[] tabela = new Integer[tamanho];
        Random random = new Random();
        int colisoes = 0;

        System.out.println("=== Visitantes em Central City ===");
        for (int i = 0; i < 20; i++) {
            int visitante = random.nextInt(100);
            int hash = visitante % tamanho;

            if (tabela[hash] != null) {
                colisoes++;
            } else {
                tabela[hash] = visitante;
            }
        }
        System.out.println("Total de colisões registradas: " + colisoes);
    }
}