package Lista05;

import java.util.LinkedList;

public class Exercicio6 {
    public static void main(String[] args) {
        int tamanho = 10;
        LinkedList<Integer>[] tabela = new LinkedList[tamanho];

        for(int i=0; i<tamanho; i++) tabela[i] = new LinkedList<>();

        int[] flechas = {15, 25, 35, 12, 22};

        System.out.println("=== Estoque Arqueiro Verde ===");
        for (int f : flechas) {
            int hash = f % tamanho;
            tabela[hash].add(f);
            System.out.println("Flecha " + f + " adicionada na lista do índice " + hash);
        }

        System.out.println("\nConteúdo das Listas:");
        for(int i=0; i<tamanho; i++) {
            if(!tabela[i].isEmpty()) System.out.println("Índice " + i + ": " + tabela[i]);
        }
    }
}