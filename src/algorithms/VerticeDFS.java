package algorithms;

import graph_types.Vertice;

public class VerticeDFS {
	
	private final Vertice contexto;
	private String cor;
	private int tempoDeDescoberta;
	private int tempoDeFinalizacao;
	private Vertice predecesso;
	protected static final String BRANCO = "Branco";
	protected static final String CINZA = "Cinza";
	protected static final String PRETO = "Preto";
	
	public VerticeDFS(Vertice contexto) {
		this.contexto = contexto;
		this.cor = VerticeDFS.BRANCO;
	}

	public Vertice getVerticeContexto() {
		return contexto;
	}

	public String getCor() {
		return cor;
	}

	public int getTempoDeDescoberta() {
		return tempoDeDescoberta;
	}

	public int getTempoDeFinalizacao() {
		return tempoDeFinalizacao;
	}

	public Vertice getPredecesso() {
		return predecesso;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setTempoDeDescoberta(int tempoDeDescoberta) {
		this.tempoDeDescoberta = tempoDeDescoberta;
	}

	public void setTempoDeFinalizacao(int tempoDeFinalizacao) {
		this.tempoDeFinalizacao = tempoDeFinalizacao;
	}

	public void setPredecesso(Vertice predecesso) {
		this.predecesso = predecesso;
	}
}
