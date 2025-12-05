package Lista06;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) return new No(valor);
        if (valor < atual.info) atual.esquerda = inserirRec(atual.esquerda, valor);
        else if (valor > atual.info) atual.direita = inserirRec(atual.direita, valor);
        return atual;
    }


    //  Exibir folhas crescente
    public void exibirFolhas(No no) {
        if (no != null) {
            exibirFolhas(no.esquerda);
            if (no.esquerda == null && no.direita == null) {
                System.out.print(no.info + " ");
            }
            exibirFolhas(no.direita);
        }
    }

    //  Contar nós com exatamente 1 filho
    public int contarUmFilho(No no) {
        if (no == null) return 0;
        int conta = 0;
        if ((no.esquerda == null && no.direita != null) || (no.esquerda != null && no.direita == null)) {
            conta = 1;
        }
        return conta + contarUmFilho(no.esquerda) + contarUmFilho(no.direita);
    }

    //  Imprimir nível K
    public void imprimirNivel(No no, int nivelAtual, int k) {
        if (no == null) return;
        if (nivelAtual == k) {
            System.out.print(no.info + " ");
        } else {
            imprimirNivel(no.esquerda, nivelAtual + 1, k);
            imprimirNivel(no.direita, nivelAtual + 1, k);
        }
    }

    //  Altura
    public int altura(No no) {
        if (no == null) return -1; // -1 para altura de arestas, 0 para nós. Usando -1 padrão.
        int hEsq = altura(no.esquerda);
        int hDir = altura(no.direita);
        return Math.max(hEsq, hDir) + 1;
    }

    //  Estritamente Binária (0 ou 2 filhos)
    public boolean isEstritamenteBinaria(No no) {
        if (no == null) return true;
        if (no.esquerda == null && no.direita == null) return true;
        if (no.esquerda != null && no.direita != null) {
            return isEstritamenteBinaria(no.esquerda) && isEstritamenteBinaria(no.direita);
        }
        return false; // Tem só 1 filho
    }

    //  Completa (Usando contagem de nós e índices)
    public boolean isCompleta(No no, int index, int numeroNos) {
        if (no == null) return true;
        if (index >= numeroNos) return false;
        return isCompleta(no.esquerda, 2 * index + 1, numeroNos) &&
                isCompleta(no.direita, 2 * index + 2, numeroNos);
    }

    public int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    // Espelho
    public void espelhar(No no) {
        if (no == null) return;
        // Troca
        No temp = no.esquerda;
        no.esquerda = no.direita;
        no.direita = temp;
        // Recurse
        espelhar(no.esquerda);
        espelhar(no.direita);
    }

    public void caminharCentral(No no) {
        if (no != null) {
            caminharCentral(no.esquerda);
            System.out.print(no.info + " ");
            caminharCentral(no.direita);
        }
    }

    // Soma total
    public int somaTotal(No no) {
        if (no == null) return 0;
        return no.info + somaTotal(no.esquerda) + somaTotal(no.direita);
    }

    // Soma folhas
    public int somaFolhas(No no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return no.info;
        return somaFolhas(no.esquerda) + somaFolhas(no.direita);
    }

    //Diferença
    public int diferencaEsqDir() {
        if (raiz == null) return 0;
        int somaEsq = somaTotal(raiz.esquerda);
        int somaDir = somaTotal(raiz.direita);
        return somaEsq - somaDir;
    }


    // Idênticas
    public int saoIdenticas(No a, No b) {
        if (a == null && b == null) return 1; // Ambas vazias = iguais
        if (a != null && b != null) {
            if (a.info == b.info &&
                    saoIdenticas(a.esquerda, b.esquerda) == 1 &&
                    saoIdenticas(a.direita, b.direita) == 1) {
                return 1;
            }
        }
        return 0; // Diferentes
    }
}