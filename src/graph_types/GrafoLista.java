//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// implementação de grafo utillizando as listas
// de adjacências dos próprios vértices
// é desejado que os vértices sejam criados a partir do Grafo

package graph_types;

import java.util.ArrayList;

public class GrafoLista extends Grafo {
	
	// conjuntos de vertices e arestas
	private ArrayList<Vertice> conjuntoDeVertices;
	private ArrayList<Aresta> conjuntoDeArestas;
	
	// construtor
	public GrafoLista(String nome) {
		super(nome);
		this.conjuntoDeArestas = new ArrayList<>();
		this.conjuntoDeVertices = new ArrayList<>();
	}
	
	// adiciona um vértice apenas com seu ID
	// inicia de 1
	public void addVertice() {
		if (super.getQuantVertice() < super.MAX_VERTICES) {
			super.setQuantVertice();
			this.conjuntoDeVertices.add(new Vertice(super.getQuantVertice()));
		
		} else {
			System.out.println("Grafo possui o máximo de vertices!!!");
		}
	}
	
	public void addVertices(int quant) {
		if (
			(super.getQuantVertice() + quant < super.MAX_VERTICES) &&
			(quant > 0)) {
			
			for (int i = 0; i < quant; i++) {
				super.setQuantVertice();
				this.conjuntoDeVertices.add(new Vertice(super.getQuantVertice()));
			}
		} else {
			System.out.println("Não é possível adicionar essa quantidade!!!");
		}
	}
	
	// adiciona uma aresta entre dois vértices que ainda não estão
	// conectados, caso o grafo tenha 1 ou nenhum vértice ele mata a função
	// ideia: Adaptar para retornar um booleano
	public void addAresta(int idVertice1, int idVertice2) {
		
		if (super.getQuantVertice() < 2) {
			
			System.out.println("Número de vertices nao permite criar aresta!");
			return;
			
		}
		
		if (this.isConect(idVertice1, idVertice2)) {
			
			System.out.println("Já existe uma aresta conectando esses vertices...");
			return;
		}
		
		Vertice v1 = this.getVerticeById(idVertice1);
		Vertice v2 = this.getVerticeById(idVertice2);
		
		if (v1 == null || v2 == null) {
			
			System.out.println("Id não está atrelado a nenhum vertice...");
			
		} else {
			
			super.setQuantAresta();
			this.conjuntoDeArestas.add(new Aresta(v1, v2, super.getQuantAresta()));
		}
	}
	
	// verifica se dois vértices estão conectados por uma aresta
	public boolean isConect(int idVertice1, int idVertice2) {
		
		if (super.getQuantVertice() < 2) 
			return false;
		
		Vertice v1 = this.getVerticeById(idVertice1);
		Vertice v2 = this.getVerticeById(idVertice2);
		
		if (v1.isAdjacent(v2) && v2.isAdjacent(v1))
			return true;
		else
			return false;
		
	}
	
	// retorna um vértice utilizando um ID válido
	public Vertice getVerticeById(int id) {
		
		if (id < 1) {
			return null;
		}
		
		for (Vertice aux : this.conjuntoDeVertices) {
			
			if (aux.getId() == id) {
				return aux;
			}
		}
		
		return null;
	}

	public ArrayList<Vertice> getConjuntoDeVertices() {
		return conjuntoDeVertices;
	}

	public ArrayList<Aresta> getConjuntoDeArestas() {
		return conjuntoDeArestas;
	}

}
