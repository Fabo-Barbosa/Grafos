package graph_types;

import java.util.List;

//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// classe grafo sem nenhum tipo de estrutura inicial
// será heradada por classes que irão implementar grafos
// com duas estruturas diferentes, matriz e lista de adjacências

public abstract class Grafo {

	private String nome;
	private int quantVertice;
	private int quantAresta;
	protected final int MAX_VERTICES = 50;
	protected final int MAX_ARESTAS = (50 * this.MAX_VERTICES) / 2;

	public Grafo(String nome) {
		this.nome = nome;
		this.quantAresta = 0;
		this.quantVertice = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeVertice() {
		return quantVertice;
	}

	protected void setQuantVertice() {
		this.quantVertice++;
	}

	public int getQuantidadeAresta() {
		return quantAresta;
	}

	protected void setQuantAresta() {
		this.quantAresta++;
	}
	
	// funções principais de um grafo
	public abstract void addVertice();
	public abstract void addVertices(int quant);
	public abstract void addAresta(int idVertice1, int idVertice2, int value);
	public abstract List<Vertice> getConjuntoDeVertices();
	public abstract List<Aresta> getConjuntoDeArestas();

}
