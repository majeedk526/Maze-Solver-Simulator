package dsa;

import processing.core.PApplet;

public class Edge {
	
	int wd, ht;
	Node src, dest; // source and destination node
	PApplet p;
	boolean visited = false;
	int R=10;
	
	private final static int SIZE = 2; 
	  
	  public Edge(PApplet p, Node src, Node dest){
	  
		  this.src = src; 
		  this.dest = dest;
		  this.p = p;

	  }
	  
	  
	  void draw(){
		 
		p.strokeWeight(5); 
		  
		if(visited){
			p.stroke(p.color(R,150,200));
			//p.fill(p.color(R,150,200));
		} else {
			p.stroke(p.color(100,0,0));
			//p.fill(p.color(100,0,0));	
		}
		
		p.line(src.width, src.height, dest.width, dest.height);
	    
	  }
	  
	  void markVisited(){
		  visited = true;
		  R*=5;
		  draw();
	  }
	  
	  void reset(){
		visited = false;
		R = 10;
		draw();
	  }
}
