package dsa;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class JGraph extends PApplet{
	
	private int sConst = 100;
	private int refWidth = 150;
	private int refHeight = 20;

	List<Node> nodeList;
	List<Edge> edgeList;
	JGraph jgraph;
	
	int[] path;
	
	public native void jCreateGraph(int size);
	public native void jAddEdge(int src, int dest);
	public native void jDisplayGraph();
	public native int[] jDfsSearch(int src, int dest);
	
	static {System.loadLibrary("GraphImpl");}
	
	public JGraph(){
		nodeList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}
	
	public static void main(String[] args) {
		
		PApplet.main(JGraph.class.getName());
		
		/**jgraph.jCreateGraph(10);
		jgraph.jAddEdge(0, 1);
		jgraph.jAddEdge(0, 3);
		jgraph.jAddEdge(0, 5);
		jgraph.jAddEdge(1, 3);
		jgraph.jAddEdge(1, 7);
		jgraph.jAddEdge(2, 9);
		jgraph.jAddEdge(9, 1);
		
		jgraph.jDisplayGraph();
		int[] path = jgraph.jDfsSearch(0,7);
		
		System.out.println("printing path found :\n");
		for(int i=0; i<path.length; i++){
			System.out.print(path[i] + "-> ");
		}
		System.out.println("\n"); **/
		
		
	}
	
	void addNode(int x, int y){
		Node n = new Node(this,x,y);
		nodeList.add(n);
		n.draw();
	}
	
	public void settings(){
		
		size(1200, 800);
	}
	
	public void setup(){
		
		background(255);
		surface.setResizable(true);
		fill(color(50,100,150));
		for(int i=0;i<10;i++){
			for(int j=0; j<10; j++){
				addNode(i,j);
			}
		}
		
		addEdge(0, 0, 0, 2);
		//addEdge(0, 0, 1, 0);
		
	}
	
	
	public void draw(){
		for(int i=0; i<nodeList.size(); i++){
			(nodeList.get(i)).draw();
		}
		
		for(int i=0; i<edgeList.size(); i++){
			edgeList.get(i).draw();
		}
	}

	
	/**
	@param s source node
	@param d destination node
	*/
	void addEdge(int x1, int y1, int x2, int y2){
		
		int pos1 = x1 + y1*10;
		int pos2 = x2 + y2*10;
		Node n1 = nodeList.get(pos1);
		Node n2 = nodeList.get(pos2);
		edgeList.add(new Edge(this, n1, n2));
		
	}
	
}
