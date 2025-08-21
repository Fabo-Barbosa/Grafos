//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

// A classe aresta possui duas variáveis de instância principais
// ponta1 e ponta2, cada uma é do tipo Vertice e representam as
// duas extremmidades da aresta, os outros atributos podem ajudar
// a acessar a aresta, buscando por nome ou id e um elemento tag
// caso seja necessário marcar a aresta com algum tipo de tag

package graph_types;

public class Aresta {

	private final int id;
	private String nome;
	private int value;
	private Vertice ponta1;
	private Vertice ponta2;

	// os conturtores foram criados como protected para que
	// não seja possível a criação de uma aresta fora de um grafo

	// um construtor sem informar o nome da aresta
	protected Aresta(Vertice p1, Vertice p2, int id, int value) {

		this(p1, p2, id, value, "");
	}

	// construtor que aceita também uma tag
	protected Aresta(Vertice p1, Vertice p2, int id, int value, String nome) {

		// assim que o contrutor for chamado incrementa 1
		// na quantidade de arestas e atribui ao id da aresta

		this.ponta1 = p1;
		this.ponta2 = p2;
		this.id = id;
		this.value = value;
		this.nome = nome;

		p1.addAdjacencia(this);

	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vertice getPonta1() {
		return ponta1;
	}

	public Vertice getPonta2() {
		return ponta2;
	}

	public int getId() {
		return id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
