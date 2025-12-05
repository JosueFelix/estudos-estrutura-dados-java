package Lista05;

public class Exercicio5 {
    public static void main(String[] args) {
        int tamanho = 10;
        Integer[] tabela = new Integer[tamanho];
        int[] armaduras = {105, 205, 302, 412, 500, 608, 708, 909};

        System.out.println("=== Protocolo JARVIS ===");
        for (int serie : armaduras) {
            int hash = serie % tamanho;
            if (tabela[hash] == null) {
                tabela[hash] = serie;
                System.out.println("Armadura " + serie + " salva no índice " + hash);
            } else {
                System.out.println("FALHA: Armadura " + serie + " colidiu no índice " + hash);
            }
        }
    }
}