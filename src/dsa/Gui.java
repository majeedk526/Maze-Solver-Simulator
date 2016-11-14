package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;

public class Gui {
	
	PApplet p;
	JGraph jgraph; // used to get PApplet object
	
	Node src = null, dest = null;
	boolean lastSrcSelected = false;
	
	// Holds references to nodes and edges
	List<Node> nodeList;
	Map<String, Edge> edgeList;
	Iterator<Map.Entry<String, Edge>> iterator;
	
	int[] path; // stores node visited during DFS search
	
	// Selecting source and goal node
	boolean isClicked = false;
	float mousex, mousey;
	
	
	public Gui(JGraph jgraph){
	// Initialise member variables
		this.p = (PApplet) jgraph;
		this.jgraph = jgraph;
		
		nodeList = new ArrayList<Node>();
		edgeList = new HashMap<>();
		
	}
	
	public void setup(){
		
		// Draw graph with 100 nodes
		//jgraph.jCreateGraph(100);
		
		for(int i=0;i<10;i++){
			for(int j=0; j<10; j++){
				addNode(j,i);
			}
		}
	
		// Add edges between nodes
		addEdge(0,8,0,9); addEdge(0,8,0,7); addEdge(0,8,1,8);
		addEdge(1,8,2,8); addEdge(1,8,1,9); addEdge(1,9,2,9);
		addEdge(2,9,3,9); addEdge(3,9,3,8); addEdge(3,8,3,7);
		addEdge(3,7,3,6); addEdge(3,6,3,5); addEdge(3,5,2,5);
		addEdge(2,5,2,6); addEdge(2,6,1,6); addEdge(1,6,0,5);
		addEdge(0,5,0,4); addEdge(0,4,0,3); addEdge(0,3,0,2);
		addEdge(0,2,0,1); addEdge(0,1,1,1); addEdge(1,1,2,1); 
		addEdge(2,1,3,1); addEdge(3,1,4,1); addEdge(4,1,5,1);
		addEdge(5,1,6,1); addEdge(6,1,6,2); 
		
		addEdge(2,5,1,4); addEdge(1,4,0,4);
		addEdge(1,3,2,2); addEdge(2,2,3,2); addEdge(3, 2, 3, 1);
		addEdge(3,2,4,3); addEdge(3,4,4,3); addEdge(4,3,5,3);
		addEdge(5,3,6,3); addEdge(5,3,5,4); addEdge(4,1,4,2);
		addEdge(4,2,5,2);
		
		addEdge(6,2,6,3);
		addEdge(6,3,6,4); addEdge(6,4,6,5); addEdge(3,8,4,8);
		addEdge(4,8,5,8); addEdge(5,8,5,9); addEdge(5,9,6,9);
		addEdge(6,9,6,8); addEdge(6,8,5,7); addEdge(5,7,4,7);
		addEdge(4,7,3,7); addEdge(5,7,6,6); addEdge(6,6,6,5);
		
		
	}
	
	public void draw(){
		// update background
		p.background(255);
		
		// iterate through edge list and draw them
		iterator = edgeList.entrySet().iterator();
		while(iterator.hasNext()){
			iterator.next().getValue().draw();
		}
		
		// iterate through node list and draw them
		for(Node n : nodeList){
			if(isClicked){
				// if node got clicked then select as source or destination node
				if(n.isGotClicked(mousex, mousey)){
					if(lastSrcSelected){
						if(dest!=null){ dest.isSelected = false;}
						dest = n;
						isClicked = false;
						dest.setDest();
						lastSrcSelected = false;
					} else {
						if(src != null){src.isSelected = false;}
						src = n;
						src.setSrc();
						isClicked = false;
						lastSrcSelected = true;
					}
				}
			}
			n.draw();
		}		
	}
	
	// update mouse positions whne it got clicked
	public void mouseClicked(float x, float y){
		isClicked = true;
		this.mousex = x;
		this.mousey = y;
		
	}
	
	// Reset each node
	public void reset(){
		for(Node n : nodeList){
			n.reset();
		}
		
		iterator = edgeList.entrySet().iterator();
		while(iterator.hasNext()){
			iterator.next().getValue().reset();
		}
		src = null;
		dest = null;
	}
	
	/**
	@param x1, y1 coordinates of first node
	@param x2, y2 Coordinates of second node
	*/
	void addEdge(int x1, int y1, int x2, int y2){
		// add Egde to maze
		int pos1 = x1 + y1*10;
		int pos2 = x2 + y2*10;
		Node n1 = nodeList.get(pos1);
		Node n2 = nodeList.get(pos2);
		
		edgeList.put(String.format("%d%d", pos1,pos2),new Edge(p, n1, n2));
		//jgraph.jAddEdge(pos1, pos2);
	}
	
	// add node to maze
	void addNode(int x, int y){
		Node n = new Node(p,x,y);
		nodeList.add(n);
		n.draw();
	}
	
	void search(){
		// validate inputs
		if(src == null || dest ==null){
			System.out.println("null error either src or destination missing");
			return;
		}
		
		// get node numbers in range 0 to 100
		int s = src.x + src.y*10;
		int d = dest.x + dest.y*10; 
		
		System.out.println("src : " + s + " dest : " + d);
		
		// call native method and get result
		//int[] path = jgraph.jDfsSearch(s,d);
		// print graph from Native implementation
		//jgraph.jDisplayGraph();
		// Show animation to user of each node visited during search
		//new AnimThread(path, edgeList).start();
	}
	
	// Thread class for animating visited edges
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
				if(e==null){
					e = edgeList.get(String.format("%d%d", path[i+1], path[i]));}
				if(e != null){
					e.markVisited();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else if(path[i+1] == -1) {
					System.out.println("Success : path found");
					break;
				} else if(path[i+1] == -2){
					System.out.println("Path not found.");
				}
				System.out.print(path[i] + "-> ");
		}
	}
  }
}
