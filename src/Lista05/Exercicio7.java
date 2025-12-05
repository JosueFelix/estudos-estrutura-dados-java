package Lista05;

public class Exercicio7 {
    public static void main(String[] args) {
        int tamanho = 5;
        Integer[] cidades = new Integer[tamanho];
        int[] ids = {10, 22, 35, 40, 55, 60, 72}; // 7 itens para 5 vagas

        System.out.println("=== Cidades Salvas ===");
        for (int id : ids) {
            int hash = id % tamanho;
            int original = hash;
            boolean inseriu = false;

            // Sondagem Linear para tentar achar vaga
            for (int i = 0; i < tamanho; i++) {
                int pos = (original + i) % tamanho;
                if (cidades[pos] == null) {
                    cidades[pos] = id;
                    System.out.println("Cidade " + id + " inserida no índice " + pos);
                    inseriu = true;
                    break;
                }
            }
            if (!inseriu) System.out.println("ERRO: Tabela cheia para a cidade " + id);
        }
    }
}