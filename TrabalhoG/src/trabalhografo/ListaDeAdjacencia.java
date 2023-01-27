
package trabalhografo;

import java.util.ArrayList;

    public final class ListaDeAdjacencia {
    ArrayList<Vert> VertComListas;

    
  
    public ListaDeAdjacencia(int matrizAdjacencia[][], int n) {
        completandoLista(matrizAdjacencia, n);
        recebeVertices(matrizAdjacencia, n);
    }

    public void completandoLista(int matrizAdjacencia[][], int n) {
        VertComListas = new ArrayList();
        
        for (int i = 1; i <= n; i++) {
            
            VertComListas.add(new Vert(i));
        }
    }
    // acessa o vertice e add os vertices adjacentes
    public ArrayList<Vert> recebeVertices(int matrizAdjacencia[][], int n) {
        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= n; j++) {
                
                if (matrizAdjacencia[i][j] == 1) {
                    
                    int indice = i - 1;
                    
                    VertComListas.get(indice).getListaAdjacente().add(j); 
                }
            }
        }
        return VertComListas;
    }

    public void imprimeListaDeAdjacencia() {
        for (int i = 0; i < VertComListas.size(); i++) {
            
            System.out.print(VertComListas.get(i).getPrincipal() + " = ");// vertice principal
            
            for (int j = 0; j < VertComListas.get(i).getListaAdjacente().size(); j++) {
                
                if (j == VertComListas.get(i).getListaAdjacente().size() - 1) {
                    
                    System.out.print("" + VertComListas.get(i).getListaAdjacente().get(j) + "");
                    
                } else {
                    
                    System.out.print("" + VertComListas.get(i).getListaAdjacente().get(j) + "->");
                    
                }
            }
            System.out.println("");
        }
    }

    // get e set 
    public ArrayList<Vert> getVertComListas() {
        return VertComListas;
    }

    public void setVertComListas(ArrayList<Vert> VertComListas) {
        this.VertComListas = VertComListas;
    }
    
}
