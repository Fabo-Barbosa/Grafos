package graph_types;

//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// classe grafo sem nenhum tipo de estrutura inicial
// será heradada por classes que irão implementar grafos
// com duas estruturas diferentes, matriz e lista de adjacências

public abstract class Grafo {
	
	private String nome;
	private int quantVertice;
	private int quantAresta;
	
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

	public int getQuantVertice() {
		return quantVertice;
	}

	public void setQuantVertice() {
		this.quantVertice++;
	}

	public int getQuantAresta() {
		return quantAresta;
	}

	public void setQuantAresta() {
		this.quantAresta++;
	}

}
