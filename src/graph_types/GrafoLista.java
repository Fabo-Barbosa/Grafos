package graph_types;

import java.util.ArrayList;

//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//ckasse que compõe a biblioteca de Grafos

// implementação de grafo utillizando as listas
// de adjacências dos próprios vértices

public class GrafoLista extends Grafo {
	
	// conjuntos de vertices e arestas
	private ArrayList<Vertice> conjuntoDeVertices;
	private ArrayList<Aresta> conjuntoDeArestas;
	
	public GrafoLista(String nome) {
		super(nome);
		this.conjuntoDeArestas = new ArrayList<>();
		this.conjuntoDeVertices = new ArrayList<>();
	}
	
	

}
