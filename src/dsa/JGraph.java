package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;

public class JGraph extends PApplet{
	
	private int sConst = 100;
	private int refWidth = 150;
	private int refHeight = 20;

	List<Node> nodeList;
	//List<Edge> edgeList;
	Map<String, Edge> edgeList;
	
	int[] path;
	
	public native void jCreateGraph(int size);
	public native void jAddEdge(int src, int dest);
	public native void jDisplayGraph();
	public native int[] jDfsSearch(int src, int dest);
	
	static {System.loadLibrary("GraphImpl");}
	
	public JGraph(){
		nodeList = new ArrayList<Node>();
		//edgeList = new ArrayList<Edge>();
		edgeList = new HashMap<>();
	}
	
	public static void main(String[] args) {
		
		PApplet.main(JGraph.class.getName());
		
		JGraph jgraph = new JGraph();
		
		Gui gui = new Gui(jgraph);
		gui.settings();
		gui.setup();
		gui.draw();
		
	}
	
	public void settings2(){
		
		size(1200, 800);
	}
	
	public void setup2(){
		
		background(255);
		surface.setResizable(true);
		//fill(color(50,100,150));
		
		// create node points
		for(int i=0;i<10;i++){
			for(int j=0; j<10; j++){
				addNode(i,j);
			}
		}
		
		addEdge(0,0,0,1);		
		addEdge(0,0,1,0);
		addEdge(1,0,1,1);
		addEdge(1,1,1,2);
		addEdge(1,2,1,3);
		addEdge(1,3,2,3);
		addEdge(2,3,3,3);
		addEdge(3,3,3,2);
		addEdge(2,2,3,2);
		
		this.jDisplayGraph();
		int[] path = jDfsSearch(0,21);
		AnimThread animThread = new AnimThread(path, edgeList);
		animThread.start();
		
	}
	
	
	public void draw2(){
		
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
		
		edgeList.put(String.format("%d%d", pos1,pos2),new Edge(this, n1, n2));
		this.jAddEdge(pos1, pos2);
	}
	
	void addNode(int x, int y){
		Node n = new Node(this,x,y);
		nodeList.add(n);
		n.draw();
	}
	
	void search(JGraph jgraph){
		
		int[] path = jgraph.jDfsSearch(0,21);
		
		System.out.println("printing path found :\n");
		for(int i=0; i<path.length-1; i++){
			Edge e = jgraph.edgeList.get(String.format("%d%d", path[i], path[i+1]));
			if(e != null){
				e.markVisited();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.print(path[i] + "-> ");
		}
		/**if(path[i] == -2){
			System.out.println("Unsuccessful search");
			break;
		}**/
		System.out.println("\n"); 
		
	}
	
	class AnimThread extends Thread {
		int path[];
		Map<String, Edge> edgeList;
		
		public AnimThread(int path[], Map<String, Edge> edgeList){
			this.path = path;
			this.edgeList = edgeList;
		}
		
		@Override
		public void run(){
			System.out.println("printing path found :\n");
			for(int i=0; i<path.length-1; i++){
				Edge e = edgeList.get(String.format("%d%d", path[i], path[i+1]));
				if(e != null){
					e.markVisited();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.print(path[i] + "-> ");
		}
	}
  }	
}
