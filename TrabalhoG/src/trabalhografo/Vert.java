/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografo;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */

// Classe auxiliar para criação da lista de adjacencia 
public class Vert {
    int principal;
    private ArrayList<Integer> listaAdjacente; // criando lista 

    public Vert(int principal) { // construtor da lista, pegando primeiro o vertice principal e depois criando a lista
        this.principal = principal;
        
        this.listaAdjacente = new ArrayList();
    }

    // gets e sets 
    public ArrayList<Integer> getListaAdjacente() {
        return listaAdjacente;
    }

    public void setAdjacente(ArrayList<Integer> listaAdjacente) {
        this.listaAdjacente = listaAdjacente;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }
    
}
