package trabalhografo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Metodos {

    Grafo grafo;
    int n, m;

    public Metodos(Grafo grafo) {
        this.grafo = grafo;
        n = grafo.getN();
        m = grafo.getM();

    }

    public Boolean TemLaco(int matrizAdjacencia[][]) {
        for (int i = 1; i < n; i++) {
            if (matrizAdjacencia[i][i] == 1) {
                return true;//Verificando se existe laço
            }
        }
        return false;
    }

    //É multigrafo se existe arestas paralelas
    public Boolean Multigrafo(int matrizAdjacencia[][], int matrizIncidencia[][]) {
        int contArestaParalela = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrizAdjacencia[i][j] == 1) {//Verificando se onde tem ligaçao também existe arestas Paralelas
                    contArestaParalela = 0;
                    for (int aresta = 1; aresta <= m; aresta++)//vai percorrer todas as arestas
                    {
                        if (matrizIncidencia[aresta][i] == 1 && matrizIncidencia[aresta][j] == 1)//Verifica se a aresta liga os dois vertices
                        {
                            contArestaParalela++;
                        }
                    }
                }
            }
        }
        if (contArestaParalela >= 2) {
            return true;
        }
        return false;
    }

    //É simples se não tem laço e não tem arestas paralelas
    public Boolean Simples(int matrizAdjacencia[][], int matrizIncidencia[][]) {
        if (TemLaco(matrizAdjacencia) == false
                && Multigrafo(matrizAdjacencia, matrizIncidencia) == false) {
            return true;
        } else {
            return false;
        }
    }

    //É Pseudográgico se existe no minimo um laço
    public Boolean Pseudografico(int matrizAdjacencia[][]) {
        if (TemLaco(matrizAdjacencia) == true) {
            return true;
        } else {
            return false;
        }
    }

    //Grau do vertice é o numero de arestas que indicem nele
    public int grauDoVertice(int matrizIncidencia[][], int vertice) {
        int cont = 0;
        for (int i = 1; i <= m; i++) //linhas = arestas
        {
            if (matrizIncidencia[i][vertice] == 1) {
                cont++;
            }
        }
        return cont;
    }

    public void imprimeGrauDosVertices(int matrizIncidencia[][]) {
        for (int j = 1; j <= n; j++) {
            System.out.println("Qual o grau do vertice " + j + "? " + grauDoVertice(matrizIncidencia, j));
        }
    }

    public int[] vetorGrauDosVertices(int matrizIncidencia[][]) {
        int vet[] = new int[n];
        for (int j = 1; j < n; j++) {
            vet[j] = grauDoVertice(matrizIncidencia, j);
        }
        return vet;
    }

    public Boolean verificaGrauDosVertices(int grauEsperado, int matrizIncidencia[][]) {
        int vetGraus[] = vetorGrauDosVertices(matrizIncidencia);
        for (int i = 0; i < vetGraus.length; i++) {
            if (vetGraus[i] != grauEsperado) {
                return false;
            }
        }
        return true;
    }

    // É completo se a quantidade de Arestas=(n*(n-1))/2 e se todos os vértices possuem grau=n-1 <=> numero de arestas q indicem nele
    public Boolean Completo(int matrizIncidencia[][]) {
        int qntdEsperadaArestas = (n * (n - 1)) / 2;
        int grauVerticeEsperado = n - 1;
        Boolean grausEsperado = verificaGrauDosVertices(grauVerticeEsperado, matrizIncidencia);
        if (qntdEsperadaArestas == m && grausEsperado == true) {
            return true;
        }
        return false;
    }

    public boolean floyd_warshall(int matrizAdjacencia[][]) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (matrizAdjacencia[i][k] == 1) {
                    for (int j = 0; j < n; j++) {
                        matrizAdjacencia[i][j] |= (matrizAdjacencia[i][k] & matrizAdjacencia[k][j]);
                    }
                }
            }
        }
        boolean v = transitivo(matrizAdjacencia,n);
        System.out.println("E transitivo" +v);
        boolean y = testeConexo(matrizAdjacencia, n);
        System.out.println("É conexo? " + y);
        return y;
    }

    public static boolean testeConexo(int graf[][], int maiorV) {
        for (int i = 0; i < maiorV; i++) {
            for (int j = 0; j < maiorV; j++) {
                if (graf[i][j] != 1) {
                   // System.out.println("Nao e conexo");
                    return false;
                }
            }
        }
        return true;

    }
    
    public static boolean transitivo(int graf[][], int maiorV) {
        for (int i = 0; i < maiorV; i++) {
            for (int j = 0; j < maiorV; j++) {
                if (graf[i][j] == 1) {
                   //System.out.println("Nao e conexo");
                    return false;
                }
            }
        }
        return true;

    }

}
