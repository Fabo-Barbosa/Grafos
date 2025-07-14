//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// Classe criada para executar e consumir os recursos da biblioteca
// a idéia é criar um menu que recebe entradas do teclado para realizar
// operações

package main;

import graph_types.GrafoLista;

public class DfsTest {

	public static void main(String[] args) {
		GrafoLista g = new GrafoLista("Grafo 1");
		System.out.println(g.getNome());
	}

}
