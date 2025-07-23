//@Fábio Henrique dos Reis Barbosa - Computer Science Student
//classe que compõe a biblioteca de Grafos

//implementação de uma classe DFS que armazenará os resultados
//de cada vértice ao realizar o algoritmo para um determinado grafo
//para realizar o armazenamento utilizo um ArrayList de Maps, no qual
//cada Map guarda o resultado de um vértice e algumas outras informações
//importantes para realizar o algoritmo.
//O ArrayList caminho registra o percurso completo que o algoritmo realizou

package algorithms;

import graph_types.GrafoLista;
import graph_types.Vertice;

public abstract class DFS {
	
	private static int tempoAux;
	private static VerticeDFS[] resultados; //cada vertice é vinculado a um map da lista
	
	// função criará uma lista de VerticeDFS com os seus contextos
	private static void initilize(GrafoLista g) {
			
		resultados = new VerticeDFS[g.getConjuntoDeVertices().size()];
		int count = 0;
			
		for (Vertice v: g.getConjuntoDeVertices()) {
			VerticeDFS aux = new VerticeDFS(v);
			resultados[count] = aux;
			count++;
		}
	}
	
	// função será publica para ser utilizada em outras classes
	// além de processar o algoritmo ela retornará resultados
	public static VerticeDFS[] runDFS(GrafoLista g) {
		
		initilize(g);
		
		tempoAux = 0;
		
		for (VerticeDFS u : resultados) {
			
			if(u.getCor() == VerticeDFS.BRANCO) {
				dfsVisita(u);
			}
		}
		return resultados;
	}
	
	// função recursiva do algoritmo
	private static void dfsVisita(VerticeDFS u) {
		tempoAux++;
		
		u.setTempoDeDescoberta(tempoAux);
		u.setCor(VerticeDFS.CINZA);
		
		for (Vertice v : u.getVerticeContexto().getVizinhanca()) {
			if (getContexto(v.getId()).getCor().equals(VerticeDFS.BRANCO)) {
				getContexto(v.getId()).setPredecesso(u.getVerticeContexto());
				dfsVisita(getContexto(v.getId()));
			}
		}
		
		u.setCor(VerticeDFS.PRETO);
		tempoAux++;
		u.setTempoDeFinalizacao(tempoAux);
	}
	
	
	// função que retorna o contexto em relação aos Maps da variável resultados
	// recebe o id do vértice e percorre a lista procurando o Map de contexto
	// retorna um Map incluído na lista resultados
	private static VerticeDFS getContexto(int id) {
		
		for (VerticeDFS m: resultados) {
			if (m.getVerticeContexto().getId() == id)
				return m;
		}
		return null;
	}

}
