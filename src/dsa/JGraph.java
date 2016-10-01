package dsa;

import processing.core.PApplet;

public class JGraph extends PApplet{
	
	private int sConst = 100;
	private int refWidth = 150;
	private int refHeight = 20;

	int[] path;
	
	public native void jCreateGraph(int size);
	public native void jAddEdge(int src, int dest);
	public native void jDisplayGraph();
	public native int[] jDfsSearch(int src, int dest);
	
	static {System.loadLibrary("GraphImpl");}
	
	public static void main(String[] args) {
		PApplet.main(JGraph.class.getName());
		
		JGraph jgraph = new JGraph();
		jgraph.jCreateGraph(10);
		jgraph.addEdge(0, 1);
		jgraph.addEdge(0, 3);
		jgraph.addEdge(0, 5);
		jgraph.addEdge(1, 3);
		jgraph.addEdge(1, 7);
		jgraph.addEdge(2, 9);
		jgraph.addEdge(9, 1);
		
		//jgraph.jDisplayGraph();
		int[] path = jgraph.jDfsSearch(0,1);
		
		for(int i=0; i<path.length; i++){
			System.out.print(path[i] + "-> ");
		}
		System.out.println("\n");
	}
	
	public void settings(){
		
		size(1200, 800);
	}
	
	public void setup(){
		
		background(255);
		fill(color(50,100,150));
		
		for(int i=0; i<50; i++){
			
			//if(i<50){ // change to 90 to increase size
			if(i<50 && i%10 <=5){	
				addEdge(i, i+10);
			}
		    
		    
		    //if(i%10 !=5){
			if(i%10 !=5 && i%10 <=5){
		    	addEdge(i,i+1);
		    }
		    
		
		}
		
		
		
	}
	
	
	public void draw(){
		
		//ellipse(width/2, height/2,second(), second());
		
	}

	
	/**
	@param s source node
	@param d destination node
	*/
	void addEdge(int s, int d){
	  
	 // adjList.get(s).add(d);
	  int column = s/10 + 1;
	  int row = 0;
	  
	  if(s<10){
	    row = s+1;
	  } else {
	    row = s%10 + 1;
	  }
	  
	  if(s-d==-10){
	  // right edge
	  //Edge e = new Edge(this, refWidth + (column-1)*sConst, refHeight + (row-1)*sConst, sConst,2);
	  
	  }
	 
	  if(s-d >= 10){
	  //left edge
	  
	  //Edge e = new Edge()
	  
	  }
	  
	  if(s-d ==-1){
	    // straight edge
	    //Edge e = new Edge(this, refWidth + (column-1)*sConst, refHeight + (row-1)*sConst, 2,sConst);
	    
	  }

	}
	
}
