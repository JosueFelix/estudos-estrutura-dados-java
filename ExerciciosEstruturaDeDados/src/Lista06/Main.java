package Lista06;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arv = new ArvoreBinaria();
        // Montando árvore para testes
        arv.inserir(10);
        arv.inserir(5);
        arv.inserir(15);
        arv.inserir(3);
        arv.inserir(7);
        arv.inserir(18);

        System.out.println("--- EXERCÍCIO 1 ---");
        System.out.print("Folhas: "); arv.exibirFolhas(arv.raiz);
        System.out.println("\nNós com 1 filho: " + arv.contarUmFilho(arv.raiz));
        System.out.print("Nível 1: "); arv.imprimirNivel(arv.raiz, 0, 1);

        System.out.println("\n\n--- EXERCÍCIO 2 ---");
        System.out.println("Altura: " + arv.altura(arv.raiz));
        System.out.println("Estritamente Binária? " + arv.isEstritamenteBinaria(arv.raiz));
        System.out.println("Completa? " + arv.isCompleta(arv.raiz, 0, arv.contarNos(arv.raiz)));

        System.out.println("\n--- EXERCÍCIO 4 ---");
        System.out.println("Soma Total: " + arv.somaTotal(arv.raiz));
        System.out.println("Soma Folhas: " + arv.somaFolhas(arv.raiz));
        System.out.println("Diferença Esq/Dir da Raiz: " + arv.diferencaEsqDir());

        System.out.println("\n--- EXERCÍCIO 3 (Espelho) ---");
        System.out.print("Antes: "); arv.caminharCentral(arv.raiz);
        arv.espelhar(arv.raiz);
        System.out.print("\nDepois: "); arv.caminharCentral(arv.raiz);
        System.out.println();

        System.out.println("\n--- EXERCÍCIO 7 (Identicas) ---");
        ArvoreBinaria a2 = new ArvoreBinaria();
        a2.inserir(10); a2.inserir(5);
        System.out.println("Identicas (retorna 1 ou 0): " + arv.saoIdenticas(arv.raiz, a2.raiz));
    }
}