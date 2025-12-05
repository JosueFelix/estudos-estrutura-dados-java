package Lista06;

public class No {
    int info;
    char caractere;
    No esquerda;
    No direita;

    public No(int info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    // Construtor
    public No(char caractere) {
        this.caractere = caractere;
        this.esquerda = null;
        this.direita = null;
    }
}