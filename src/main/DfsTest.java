//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// Classe criada para executar e consumir os recursos da biblioteca
// a idéia é criar um menu que recebe entradas do teclado para realizar
// operações

package main;

import algorithms.DFS;
import algorithms.VerticeDFS;
import graph_types.GrafoLista;
import interfaces.Grafo;

public class DfsTest {

	public static void main(String[] args) {
		GrafoLista g = new GrafoLista("Grafo 1");
		Grafo g1 = new GrafoLista("Grafo Teste");
		String nome = g1.getNome();
		
		System.out.println(nome);
		VerticeDFS[] listaDeResultados;

		g.addVertices(3);
		g.addAresta(1, 3);
		g.addAresta(2, 3);
		g.addAresta(2, 1);

		listaDeResultados = DFS.runDFS(g);

		// Vertice
		// cor
		// td - Tempo de descoberta
		// tf - Tempo de finalizacao
		// Vertice predecessor
		System.out.println("Vertice\tcor\ttd\ttf\tPredecessor");

		for (VerticeDFS v : listaDeResultados) {

			System.out.printf("%d\t%s\t%d\t%d\t%d%n", v.getVerticeContexto().getId(), v.getCor(),
					v.getTempoDeDescoberta(), v.getTempoDeFinalizacao(),
					v.getPredecesso() == null ? null : v.getPredecesso().getId());
		}
	}

}
