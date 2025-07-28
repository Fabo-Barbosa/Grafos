//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// A classe Vertice será herdada por outros tipos de vertices
// possui como variável de instância principal um id tipo int
// e uma lista que guarda arestas adjacentes, os outros atributos
// são auxiliares

package graph_types;

import java.util.ArrayList;

public class Vertice {

	private int id;
	private String tag;
	private String nome;
	private int grau;
	private ArrayList<Aresta> arestasAdjacentes = new ArrayList<>();
	private ArrayList<Vertice> vizinhanca = new ArrayList<>();

	// contrutores com modificador de acesso protcted
	// só é possível instanciar a classe por meio de classes do pacote
	// construtor que recebe apenas um id
	protected Vertice(int id) {
		this(id, "", "");
	}

	// construtor que recebe nome e id
	protected Vertice(int id, String nome) {
		this(id, nome, "");
	}

	// construtor que recebe nome, id e uma tag
	protected Vertice(int id, String nome, String tag) {
		this.id = id;
		this.tag = tag;
		this.nome = nome;
		this.grau = 0;
	}

	// função usada pela classe Aresta
	// adiciona uma aresta adjacente ao vertice
	// e adiciona o vértice adjacente ao conjunto de vértices
	protected void addAdjacencia(Aresta aresta) {

		Vertice aux = aresta.getPonta1();
		if (aux == this) {
			aux = aresta.getPonta2();
		}

		if (!(this.vizinhanca.contains(aux))) {

			this.vizinhanca.add(aux);
			this.arestasAdjacentes.add(aresta);
			this.incGrau();

		}
	}

	// função usada pela classe Aresta
	// remove uma aresta adjacente ao vertice
	// e remove o vértice adjacente ao conjunto de vértices
	protected void removeAdjacencia(Aresta aresta) {

		Vertice aux = aresta.getPonta1();
		if (aux == this) {
			aux = aresta.getPonta2();
		}

		if (this.vizinhanca.contains(aux)) {
			this.vizinhanca.remove(aux);
		}

		if (this.arestasAdjacentes.contains(aresta)) {
			this.arestasAdjacentes.remove(aresta);
			this.decGrau();
		}
	}

	public boolean isAdjacent(Vertice v) {

		if (this.vizinhanca.isEmpty())
			return false;

		for (Vertice vaux : this.vizinhanca) {

			if (vaux == v)
				return true;
		}

		return false;
	}

	protected void addVertice(Vertice v) {
		this.vizinhanca.add(v);
	}

	public ArrayList<Vertice> getVizinhanca() {
		return this.vizinhanca;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGrau() {
		return grau;
	}

	private void incGrau() {
		this.grau++;
	}

	private void decGrau() {
		this.grau--;
	}

}
