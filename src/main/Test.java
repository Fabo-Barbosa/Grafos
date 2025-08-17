//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// Classe criada para executar e consumir os recursos da biblioteca
// a idéia é criar um menu que recebe entradas do teclado para realizar
// operações

package main;

import algorithms.BellmanFord;
import algorithms.DFS;
import algorithms.VerticeDFS;
import graph_types.GrafoLista;
import representation.PseudoVertice;
import representation.Result;

public class Test {

	public static void main(String[] args) {
		GrafoLista g = new GrafoLista("Grafo 1");

		g.addVertices(4);
		g.addAresta(1, 3);
		g.addAresta(1, 2);
		g.addAresta(2, 3);
		g.addAresta(2, 4);
		g.addAresta(4, 1);
		
		// adicionando valores nas arestas
		g.getArestaById(1).setValue(7);
		g.getArestaById(2).setValue(-3);
		g.getArestaById(3).setValue(4);
		g.getArestaById(4).setValue(-1);
		g.getArestaById(5).setValue(3);

		Result listaDeResultados = BellmanFord.run(g);

		// Vertice
		// cor
		// td - Tempo de descoberta
		// tf - Tempo de finalizacao
		// Vertice predecessor
		
		if (listaDeResultados.isSuccess()) {
			System.out.println("Não há ciclo negativo...");
		}else {
			System.out.println("O grafo possui um ciclo negativo!");
		}
		
		System.out.println("Vertice\tDistancia\tPredecessor");

		for (PseudoVertice v : listaDeResultados.getVerticesResult()) {

			System.out.printf("%d\t%d\t\t%d%n", v.getContext(), v.getDist(), v.getPredecessor());
		}
		
	}

}
