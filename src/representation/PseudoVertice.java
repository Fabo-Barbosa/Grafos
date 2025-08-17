package representation;

public class PseudoVertice {
	
	private int context;
	private int predecessor;
	private int dist;
	
	public PseudoVertice(int context) {
		this.context = context;
	}
	
	public int getPredecessor() {
		return predecessor;
	}
	public int getDist() {
		return dist;
	}
	
	public void setPredecessor(int predecessor) {
		this.predecessor = predecessor;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
	
	public int getContext() {
		return context;
	}

}
