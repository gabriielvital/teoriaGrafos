
package trabalhografo;

/**
 *
 * @author Daniel
 */
public class Grafo {
    private int n, m;
    private Boolean direcionado;
    private ListaDeAdjacencia lista;
    
    
    
    
    public Grafo(int n, int m) {
        this.n = n;
        this.m = m;
    }
    
    
    public Grafo(int n, int m, Boolean direcionado, ListaDeAdjacencia lista) {
        this.n = n;
        this.m = m;
        this.direcionado = direcionado;
        this.lista = lista;
    }



    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Boolean getDirecionado() {
        return direcionado;
    }

    public void setDirecionado(Boolean direcionado) {
        this.direcionado = direcionado;
    }

    public ListaDeAdjacencia getLista() {
        return lista;
    }

    public void setLista(ListaDeAdjacencia lista) {
        this.lista = lista;
    }
   
    public int ordemDoGrafo() {
        return n;
    }

    public int tamanhoDoGrafo() {
        return n + m;
    }
    
}
