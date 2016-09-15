package dsa;

import processing.core.PApplet;

public class JGraph extends PApplet{
	
	private int sConst = 100;
	private int refWidth = 150;
	private int refHeight = 20;

	public static void main(String[] args) {
		PApplet.main(JGraph.class.getName());

	}
	
	public void settings(){
		
		size(1200, 800);
	}
	
	public void setup(){
		
		background(255);
		fill(color(50,100,150));
		
		for(int i=0; i<50; i++){
			
			if(i<50){ // change to 90 to increase size
				addEdge(i, i+10);
			}
		    
		    
		    if(i%10 !=5){
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
	  Edge e = new Edge(this, refWidth + (column-1)*sConst, refHeight + (row-1)*sConst, sConst,2);
	  
	  }
	 
	  if(s-d >= 10){
	  //left edge
	  
	  //Edge e = new Edge()
	  
	  }
	  
	  if(s-d ==-1){
	    // straight edge
	    Edge e = new Edge(this, refWidth + (column-1)*sConst, refHeight + (row-1)*sConst, 2,sConst);
	    
	  }

	}
	
}
