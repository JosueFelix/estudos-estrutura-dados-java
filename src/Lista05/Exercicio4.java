package Lista05;

public class Exercicio4 {
    public static void main(String[] args) {
        int tamanho = 7;
        String[] inimigos = {"Ares", "Cheetah", "Circe"};

        System.out.println("=== Inimigos da Mulher-Maravilha ===");
        for (String nome : inimigos) {
            int somaAscii = 0;
            for (int i = 0; i < nome.length(); i++) {
                somaAscii += nome.charAt(i);
            }

            int hash = somaAscii % tamanho;
            System.out.println("Inimigo: " + nome + " -> Índice: " + hash);
        }
    }
}