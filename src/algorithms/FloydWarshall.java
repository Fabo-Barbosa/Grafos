package algorithms;

import graph_types.Aresta;
import graph_types.Grafo;
import graph_types.GrafoLista;
import graph_types.Vertice;

public class FloydWarshall {
	static final int INFINITO = 10000; // só para representar um número muito grande

	public static void main(String[] args) {
		
		// inicialização do grafo
		Grafo g = new GrafoLista("Grafo Teste");
		
		// vertices 1, 2, 3 e 4
		g.addVertices(4);
		
		//1 -4-> 2
		g.addAresta(1, 2, 4);
		
		//3 -2-> 1
		g.addAresta(3, 1, 2);
		
		//1 -7-> 4
		g.addAresta(1, 4, 7);
		
		//2 -1-> 4
		g.addAresta(2, 4, 1);
		
		//4 -9-> 3
		g.addAresta(4, 3, 9);
		
		
		// inicializando as matrizes do algoritmo
		int dimensao = g.getQuantidadeVertice();
		int[][] matrizPeso = new int[dimensao][dimensao]; // Matriz de pesos
		int[][] matrizPred = new int[dimensao][dimensao]; // Matriz de predecessores
		
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				if (j != i) { // se os vértices forem diferentes
					// se a vizinhança do vértice na posição i conter o vértice da posição j, encontra-se a aresta
					// que conecta os dois, e atribuí o peso da aresta na matrizPeso[i][j]
					if (g.getConjuntoDeVertices().get(i).getVizinhanca().contains(g.getConjuntoDeVertices().get(j))) {
						for (Aresta a : g.getConjuntoDeVertices().get(i).getArestasAdjacentes()) {
							if (a.getPonta2() == g.getConjuntoDeVertices().get(j)) {
								matrizPeso[i][j]= a.getValue();
								break;
							}
						}
						
						matrizPred[i][j] = i; // posição [i][j] possui o predecessor o próprio i
					} else { // caso o vértice da posição i não for adjacente ao vértice da posição j
						matrizPeso[i][j] = INFINITO;
						matrizPred[i][j] = -1;
					}
				} else { // caso os dois vértices forem iguais
					matrizPeso[i][j] = 0;
					matrizPred[i][j] = i;
				}
			}		
		}
	}

}
