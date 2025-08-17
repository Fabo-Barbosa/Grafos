package algorithms;

import graph_types.Aresta;
import graph_types.Grafo;
import representation.PseudoVertice;
import representation.Result;

public abstract class BellmanFord {
	
	private static void relax(Aresta a, Result r) {
		PseudoVertice origem = r.getPseudoVerticeByContext(a.getPonta1().getId());
		PseudoVertice destino = r.getPseudoVerticeByContext(a.getPonta2().getId());
		int pesoDaAresta = a.getValue();
		
		destino.setDist(origem.getDist() + pesoDaAresta);
	}
	
	public static Result run(Grafo g) {
		// initialize Result
		Result result = Result.generateResult(g);
		
		// initialize values with largest integer and
		// the first vertex with 0
		for (PseudoVertice v : result.getVerticesResult()) {
			v.setDist(3000); // usei 3000 para representar o infinito
		}
		result.getVerticesResult().get(0).setDist(0);
		
		
		// laço principal, percorre todas arestas V vezzes
		for (int i = 0; i < g.getQuantidadeVertice(); i++) {
			for (Aresta a : g.getConjuntoDeArestas()) {
				if (result.getPseudoVerticeByContext(a.getPonta2().getId()).getDist() > 
				a.getValue() + result.getPseudoVerticeByContext(a.getPonta1().getId()).getDist()) {
					relax(a, result);
					result.getPseudoVerticeByContext(a.getPonta2().getId()).setPredecessor(a.getPonta1().getId());
				}
			}
		}
		
		// laço de verificação, se houver ainda houver vértices tensos, há um ciclo negativo
		// logo o sucesso do algoritmo é false
		for (Aresta a : g.getConjuntoDeArestas()) {
			if (result.getPseudoVerticeByContext(a.getPonta2().getId()).getDist() > 
			a.getValue() + result.getPseudoVerticeByContext(a.getPonta1().getId()).getDist()) {
				result.setSuccess(false);
				return result;
			}
		}
		
		result.setSuccess(true);
		return result;
		
	}
}
