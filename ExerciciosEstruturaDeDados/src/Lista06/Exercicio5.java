package Lista06;

public class Exercicio5 {
    // Variável estática para acompanhar o índice atual no array prefixado
    static int indicePre = 0;

    public static void main(String[] args) {
        // Exemplo de sequências (Árvore do exemplo anterior)
        int[] prefixado = {10, 5, 3, 7, 15, 18};
        int[] central   = {3, 5, 7, 10, 15, 18};

        System.out.println("=== EXERCÍCIO 5: Reconstrução de Árvore ===");

        // Reconstrói a árvore
        No raiz = construirArvore(prefixado, central, 0, central.length - 1);

        System.out.print("Caminhamento Pós-fixado da árvore reconstruída: ");
        posFixado(raiz);
        System.out.println();
    }

    // Função auxiliar recursiva para montar a árvore
    public static No construirArvore(int[] pre, int[] in, int inInicio, int inFim) {
        if (inInicio > inFim) return null;

        // O nó atual é o próximo da lista prefixada
        No no = new No(pre[indicePre++]);

        // Se não tiver mais filhos (folha), retorna o nó
        if (inInicio == inFim) return no;

        // Achar onde esse nó está na lista Central (inorder) para dividir esq/dir
        int inIndice = buscarIndice(in, inInicio, inFim, no.info);

        // Constrói as subárvores recursivamente
        no.esquerda = construirArvore(pre, in, inInicio, inIndice - 1);
        no.direita = construirArvore(pre, in, inIndice + 1, inFim);

        return no;
    }

    // CORREÇÃO AQUI: Retorna -1 se não encontrar, em vez de tentar acessar 'i' fora do loop
    public static int buscarIndice(int[] in, int inicio, int fim, int valor) {
        for (int i = inicio; i <= fim; i++) {
            if (in[i] == valor) return i;
        }
        return -1; // Retorno de segurança caso não encontre
    }

    // Exibe em pós-ordem (Esq, Dir, Raiz)
    public static void posFixado(No no) {
        if (no != null) {
            posFixado(no.esquerda);
            posFixado(no.direita);
            System.out.print(no.info + " ");
        }
    }
}