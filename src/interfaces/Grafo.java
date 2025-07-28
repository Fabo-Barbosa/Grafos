package interfaces;


public interface Grafo {
	
	// funções principais de um grafo
	public void addVertice();
	public void addVertices(int quant);
	public void addAresta(int idVertice1, int idVertice2);
	public boolean isConect(int idVertice1, int idVertice2);
	
	// funções simples de GrafoInicial
	public String getNome();
	public void setNome(String nome);
	public int getQuantidadeVertice();
	public int getQuantidadeAresta();
	
}
