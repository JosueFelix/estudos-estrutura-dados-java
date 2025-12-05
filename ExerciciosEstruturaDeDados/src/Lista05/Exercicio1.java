package Lista05;

public class Exercicio1 {
    static class Peca {
        int id;
        double peso;

        public Peca(int id, double peso) {
            this.id = id;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        int tamanho = 10; // Tamanho arbitrário para o exemplo
        Peca[] tabela = new Peca[tamanho];

        // 5 Peças para inserir
        Peca[] pecas = {
                new Peca(115, 25.5),
                new Peca(12, 10.0),
                new Peca(39, 15.2),
                new Peca(40, 50.0),
                new Peca(55, 12.8)
        };

        System.out.println("=== Traje de Lex Luthor ===");
        for (Peca p : pecas) {
            int hash = p.id % tamanho;
            tabela[hash] = p; // Inserção simples
            System.out.println("Peça ID " + p.id + " armazenada no índice " + hash);
        }
    }
}