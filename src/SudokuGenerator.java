import java.util.Random;

public class SudokuGenerator {
    
    private int[][] tabuleiro;
    private final int N = 9;
    private final Random random = new Random();
    
    public SudokuGenerator(int N) {
        this.tabuleiro = new int[this.N][this.N];
    }
    
    public void gerarJogo() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        resolverTabuleiro();
    }

    private boolean resolverTabuleiro() {
        for (int linha = 0; linha < N; linha++) {
            for (int coluna = 0; coluna < N; coluna++) {

                if (tabuleiro[linha][coluna] == 0) {
                    int[] numerosMisturados = gerarNumerosAleatorios();
                    
                    for (int numero : numerosMisturados) {
                        if (nValido(linha, coluna, numero)) {
                            tabuleiro[linha][coluna] = numero;
                            if (resolverTabuleiro()) {
                                return true;
                            } else {
                                tabuleiro[linha][coluna] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void removerDigitos(int quantidade) {
        while (quantidade > 0) {
            int linha = random.nextInt(N);
            int col = random.nextInt(N);

            if (tabuleiro[linha][col] != 0) {
                tabuleiro[linha][col] = 0;
                quantidade--;
            }
        }
    }

    private boolean nValido(int linha, int col, int numero) {
        for (int i = 0; i < N; i++) {
            if (tabuleiro[linha][i] == numero) return false;
        }

        for (int i = 0; i < N; i++) {
            if (tabuleiro[i][col] == numero) return false;
        }

        int inicioLinha = linha - (linha % 3);
        int inicioCol = col - (col % 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[inicioLinha + i][inicioCol + j] == numero) return false;
            }
        }
        return true;
    }

    private int[] gerarNumerosAleatorios() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public int[][] getCopiaTabuleiro() {
        int[][] copia = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(tabuleiro[i], 0, copia[i], 0, N);
        }
        return copia;
    }
}