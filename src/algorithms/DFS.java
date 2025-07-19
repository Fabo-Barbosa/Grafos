//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

//implementação de uma classe DFS que armazenará os resultados
//de cada vértice ao realizar o algoritmo para um determinado grafo
//para realizar o armazenamento utilizo um ArrayList de Maps, no qual
//cada Map guarda o resultado de um vértice e algumas outras informações
//importantes para realizar o algoritmo.
//O ArrayList caminho registra o percurso completo que o algoritmo realizou

package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import graph_types.Grafo;
import graph_types.GrafoLista;
import graph_types.Vertice;


public class DFS {
	
	private static final String[] CORES = {"BRANCO", "CINZA", "PRETO"};
	private int tempoAux;
	private Map<String, Integer> modelo;
	private ArrayList<Map<String, Integer>> resultados; //cada vertice é vinculado a um map da lista
	private GrafoLista grafoAtual;
	
	public DFS() {
		// construtor padrão
		this.resultados = new ArrayList<Map<String,Integer>>();
		this.modelo = new HashMap<String, Integer>();
		
		this.modelo.put("id_contexto", null);
		this.modelo.put("cor", 0);
		this.modelo.put("descoberta", 0);
		this.modelo.put("finalizacao", 0);
		this.modelo.put("predecessor", null);
	}
	
	// função será publica para ser utilizada em outras classes
	// além de processar o algoritmo ela retornará resultados
	public List<Map<String, Integer>> runDFS(GrafoLista g) {
		
		this.setGrafo(g);
		
		tempoAux = 0;
		
		for (Map<String, Integer> u : this.resultados) {
			
			if(u.get("cor") == 0) {
				dfsVisita(g.getVerticeById(u.get("id_contexto")));
			}
		}
		return this.resultados;
	}
	
	public Grafo getGrafoAtual() {
		return this.grafoAtual;
	}
	
	private void dfsVisita(Vertice u) {
		tempoAux++;
		Map<String, Integer> contexto = this.getContexto(u.getId());
		
		contexto.replace("descoberta", tempoAux);
		contexto.replace("cor", 1);
		
		for (Vertice v : u.getVizinhanca()) {
			if (this.getContexto(v.getId()).get("cor").equals(0)) {
				this.getContexto(v.getId()).replace("predecessor", u.getId());
				dfsVisita(v);
			}
		}
		
		contexto.replace("cor", 2);
		tempoAux++;
		contexto.replace("finalizacao", tempoAux);
	}
	
	
	// função que retorna o contexto em relação aos Maps da variável resultados
	// recebe o id do vértice e percorre a lista procurando o Map de contexto
	// retorna um Map incluído na lista resultados
	private Map<String, Integer> getContexto(int id) {
		
		for (Map<String, Integer> m: this.resultados) {
			if (m.get("id_contexto") == id)
				return m;
		}
		return null;
	}
	
	
	//  função usada na própria classe para popular a variável resultados
	// com valores iniciais e seus respectivos campos sendo:
	// id do vértice contexto
	// indice da cor do vértice
	// tempo de descoberta
	// tempo de finalização
	// e id do vértice predecessor
	private void setGrafo(GrafoLista g) {
		
		if (!(this.resultados.isEmpty()))
			this.resultados.removeAll(this.resultados);
		
		for (Vertice v: g.getConjuntoDeVertices()) {
			Map<String, Integer> mapDfs = new HashMap<String, Integer>();
			mapDfs.putAll(modelo);
			mapDfs.replace("id_contexto", v.getId());
			this.resultados.add(mapDfs);
		}
		
		this.grafoAtual = g;
	}
	
	// função com a finalidade unicamente de teste
	public void showResults() {
		
		System.out.println("id\tcor\tdescoberta\tfinalização\tpredecessor");
		
		for (Map<String, Integer> m: this.resultados) {
			System.out.printf("%d\t%s\t\t%d\t%d\t\t%d%n", m.get("id_contexto"), DFS.CORES[m.get("cor")],
					m.get("descoberta"), m.get("finalizacao"), m.get("predecessor"));
		}
	}

}
