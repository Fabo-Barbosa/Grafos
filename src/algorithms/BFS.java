//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

/* A função runBFS() implementa o algoritmo de busca em largura.
 Ela visita todos os vértices do grafo G que estão ao alcance do
 vértice s e registra num vetor num[] a ordem em que os vértices são
 descobertos. Esta versão da função supõe que o grafo G é representado
 tado por listas de adjacência.  (Código inspirado no programa 18.9 de Sedgewick.)*/
package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph_types.GrafoLista;
import graph_types.Vertice;

public class BFS {
	
	// fila auxiliar para executar o algoritmo, cada elemento da lista representa um vértice
	private static Queue<Vertice> queue;
	
	// funções auxiliares da função principal
	private static void QUEUEinit() {
		queue = new LinkedList<>();
	}
	
	private static void QUEUEput(Vertice vertice) {
		queue.add(vertice);
	}
	
	private static Vertice QUEUEget() {
		return queue.poll();
	}
	
	private static boolean QUEUEempty() {
		return queue.isEmpty();
	}
	
	private static void QUEUEfree() {
		queue.clear();
	}
	
	//public static List<Vertice> runBFS(GrafoLista g, Vertice inicio){
		
	//}
}
