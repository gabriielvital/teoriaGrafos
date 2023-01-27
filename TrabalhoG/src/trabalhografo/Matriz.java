
package trabalhografo;

public class Matriz {
     public static int[][] criaMatriz(int lin, int col) {//criando a matriz
        int matriz[][] = new int[lin + 1][col + 1];
        for (int i = 0; i <= lin; i++) {
            for (int j = 0; j <= col; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }

    public static void imprimeMatriz(int matriz[][], int lin, int col) {
        for (int i = 1; i <= lin; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print("" + matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
