package graph_types;

import interfaces.Grafo;

//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// classe grafo sem nenhum tipo de estrutura inicial
// será heradada por classes que irão implementar grafos
// com duas estruturas diferentes, matriz e lista de adjacências

public abstract class GrafoInicial {

	private String nome;
	private int quantVertice;
	private int quantAresta;
	protected final int MAX_VERTICES = 50;
	protected final int MAX_ARESTAS = (50 * this.MAX_VERTICES) / 2;

	public GrafoInicial(String nome) {
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

}
