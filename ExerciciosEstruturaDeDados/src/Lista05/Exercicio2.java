package Lista05;

import java.util.Arrays;

public class Exercicio2 {
    public static void main(String[] args) {
        int tamanho = 10;
        Integer[] tabela = new Integer[tamanho];

        int[] codigos = {7, 12, 22, 32};

        System.out.println("=== Acesso Batcaverna ===");
        for (int codigo : codigos) {
            int hash = codigo % tamanho;

            System.out.print("Tentando inserir código " + codigo + " no índice " + hash + ": ");

            if (tabela[hash] == null) {
                tabela[hash] = codigo;
                System.out.println("Sucesso.");
            } else {
                System.out.println("COLISÃO! (Já ocupado por " + tabela[hash] + ")");
            }
        }
        System.out.println("Tabela Final: " + Arrays.toString(tabela));
    }
}