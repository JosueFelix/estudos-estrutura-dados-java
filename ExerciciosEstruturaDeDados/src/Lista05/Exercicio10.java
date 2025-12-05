package Lista05;

public class Exercicio10 {
    public static void main(String[] args) {
        int tamanho = 13;
        Integer[] banco = new Integer[tamanho];

        int[] validas = {13, 26, 35, 48, 51, 64, 77, 80};

        // Inserir válidas
        for (int chave : validas) {
            int hash = chave % tamanho;
            while(banco[hash] != null) hash = (hash + 1) % tamanho; // Sondagem linear
            banco[hash] = chave;
        }

        // Testar chaves (Coringa)
        int[] testes = {26, 99, 51};

        System.out.println("=== Sistema Ciborgue ===");
        for (int t : testes) {
            int hash = t % tamanho;
            boolean achou = false;

            // Busca Linear a partir do hash
            for(int i=0; i<tamanho; i++) {
                int pos = (hash + i) % tamanho;
                if (banco[pos] == null) break;
                if (banco[pos] == t) {
                    achou = true;
                    break;
                }
            }

            if (achou) System.out.println("Chave " + t + ": VÁLIDA.");
            else System.out.println("Chave " + t + ": INVÁLIDA (Alerta!).");
        }
    }
}