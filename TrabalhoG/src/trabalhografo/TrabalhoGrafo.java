/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author Daniel
 */
public class TrabalhoGrafo {

    
     
    public static int[][] MatrizAdjacencia() {
        Scanner ler = new Scanner(System.in);
        int i, j, tamanho = 0, lin = 0, col = 0;

        try {
            FileReader arq = new FileReader("entradaAdjacencia.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            tamanho = Integer.parseInt(linha);//numero de vertices
            int matriz[][] = Matriz.criaMatriz(tamanho, tamanho);
            linha = lerArq.readLine();
            while (linha != null) { //while roda enquanto tiver linhas
                String[] split = linha.split("_");
                lin = Integer.parseInt(split[0]);//linha
                col = Integer.parseInt(split[1]);//coluna
                matriz[lin][col] = 1;
                linha = lerArq.readLine();
            }
            System.out.println("Matriz Adjacencia");
            Matriz.imprimeMatriz(matriz, tamanho, tamanho);//Imprimir Matriz
            arq.close();
            return matriz;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }
    }

    public static int[][] MatrizIncidencia() {
        Scanner ler = new Scanner(System.in);
        int i, j, qntdVertice = 0, qntdAresta = 0, lin = 0, col = 0;

        try {
            FileReader arq = new FileReader("entradaIncidencia.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            qntdVertice = Integer.parseInt(lerArq.readLine());//numero de vertices
            qntdAresta = Integer.parseInt(lerArq.readLine());//numero de arestas
            int matriz[][] = Matriz.criaMatriz(qntdAresta, qntdVertice);

            String linha = lerArq.readLine();
            while (linha != null) { //while roda enquanto tiver linhas
                String[] split = linha.split("_");
                lin = Integer.parseInt(split[0]);
                col = Integer.parseInt(split[1]);
                matriz[lin][col] = 1;
                linha = lerArq.readLine();
            }
            
            
            //Imprimir Matriz
            System.out.println("Matriz Incidencia");
            Matriz.imprimeMatriz(matriz, qntdAresta, qntdVertice);
            arq.close();
            return matriz;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        
        
        int matrizAdjacencia[][] = MatrizAdjacencia();
        int matrizIncidencia[][] = MatrizIncidencia();
        int n = matrizAdjacencia.length - 1;
        int m = matrizIncidencia.length - 1;
        ListaDeAdjacencia lista = new ListaDeAdjacencia(matrizAdjacencia, n);
        Grafo grafo = new Grafo(n, m, Boolean.FALSE, lista);
        Metodos a = new Metodos(grafo);
       
        System.out.println("Simples?  "+a.Simples(matrizAdjacencia, matrizIncidencia)+"\n");
        System.out.println("Laço? "+a.TemLaco(matrizAdjacencia)+"\n");   
        System.out.println("Multigrafo? "+a.Multigrafo(matrizAdjacencia, matrizIncidencia)+"\n");
        System.out.println("Pseudografo? "+a.Pseudografico(matrizAdjacencia)+"\n");
        System.out.println("Completo? "+a.Completo(matrizIncidencia));
        System.out.println("\n");
        a.imprimeGrauDosVertices(matrizIncidencia);
        System.out.println("\nQual a ordem do grafo ? "+grafo.ordemDoGrafo());
        System.out.println("\nQual o tamanho do grafo ? "+grafo.tamanhoDoGrafo());
        System.out.println("\n");
        
         System.out.println("Lista de Adjacencia:");
         lista.imprimeListaDeAdjacencia();
         System.out.println("\nO grafo e conexo?" +a.floyd_warshall(matrizAdjacencia)+"\n");
        
       
        
       
    }
 }
    

