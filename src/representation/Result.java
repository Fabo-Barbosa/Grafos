package representation;

import java.util.ArrayList;
import java.util.List;

import graph_types.Grafo;
import graph_types.Vertice;

public class Result {
	
	private boolean success;
	private List<PseudoVertice> verticesResult;
	
	public Result() {
		verticesResult = new ArrayList<PseudoVertice>();
	}
	
	public static Result generateResult(Grafo g) {
		Result r = new Result();
		for (Vertice v: g.getConjuntoDeVertices()) {
			r.addVerticeResult(new PseudoVertice(v.getId()));
		}
		
		return r;
	}
	
	public PseudoVertice getPseudoVerticeByContext(int context) {
		for (PseudoVertice v : verticesResult) {
			if (v.getContext() == context)
				return v;
		}
		
		return null;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<PseudoVertice> getVerticesResult() {
		return verticesResult;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void addVerticeResult(PseudoVertice vertice) {
		this.verticesResult.add(vertice);
	}

}
