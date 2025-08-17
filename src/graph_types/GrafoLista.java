//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// implementação de grafo utillizando as listas
// de adjacências dos próprios vértices
// é desejado que os vértices sejam criados a partir do Grafo

package graph_types;

import java.util.ArrayList;
import java.util.List;

public class GrafoLista extends Grafo {

	// conjuntos de vertices e arestas
	private final List<Vertice> conjuntoDeVertices;
	private final List<Aresta> conjuntoDeArestas;

	// construtor
	public GrafoLista(String nome) {
		super(nome);
		this.conjuntoDeArestas = new ArrayList<>();
		this.conjuntoDeVertices = new ArrayList<>();
	}

	// adiciona um vértice apenas com seu ID
	// inicia de 1
	public void addVertice() {
		if (super.getQuantidadeVertice() < super.MAX_VERTICES) {
			super.setQuantVertice();
			this.conjuntoDeVertices.add(new Vertice(super.getQuantidadeVertice()));

		} else {
			System.out.println("Grafo possui o máximo de vertices!!!");
		}
	}

	public void addVertices(int quant) {
		if ((super.getQuantidadeVertice() + quant < super.MAX_VERTICES) && (quant > 0)) {

			for (int i = 0; i < quant; i++) {
				super.setQuantVertice();
				this.conjuntoDeVertices.add(new Vertice(super.getQuantidadeVertice()));
			}
		} else {
			System.out.println("Não é possível adicionar essa quantidade!!!");
		}
	}

	// adiciona uma aresta entre dois vértices que ainda não estão
	// conectados, caso o grafo tenha 1 ou nenhum vértice ele mata a função
	// ideia: Adaptar para retornar um booleano
	public void addAresta(int idVertice1, int idVertice2) {

		if (super.getQuantidadeVertice() < 2) {

			System.out.println("Número de vertices nao permite criar aresta!");
			return;

		}

		Vertice v1 = this.getVerticeById(idVertice1);
		Vertice v2 = this.getVerticeById(idVertice2);
		
		if (v1.isAdjacent(v2) && v2.isAdjacent(v1)) {

			System.out.println("Já existe uma aresta conectando esses vertices...");
			return;
		}

		if (v1 == null || v2 == null) {

			System.out.println("Id não está atrelado a nenhum vertice...");

		} else {

			super.setQuantAresta();
			this.conjuntoDeArestas.add(new Aresta(v1, v2, super.getQuantidadeAresta()));
		}
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
	
	// retorna uma aresta utilizando um ID válido
		public Aresta getArestaById(int id) {

			if (id < 1) {
				return null;
			}

			for (Aresta aux : this.conjuntoDeArestas) {

				if (aux.getId() == id) {
					return aux;
				}
			}

			return null;
		}

	public List<Vertice> getConjuntoDeVertices() {
		return conjuntoDeVertices;
	}

	public List<Aresta> getConjuntoDeArestas() {
		return conjuntoDeArestas;
	}

}
