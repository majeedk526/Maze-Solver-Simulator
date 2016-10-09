package dsa;

import processing.core.PApplet;

public class Edge {
	
	int wd, ht;
	Node src, dest; // source and destination node
	PApplet p;
	boolean visited = false;
	
	private final static int SIZE = 2; 
	  
	  public Edge(PApplet p, Node src, Node dest){
	  
		  this.src = src; 
		  this.dest = dest;
		  this.p = p;

	  }
	  
	  
	  void draw(){
		 
		if(visited){
			p.fill(p.color(0,150,200));
		} else {
			p.fill(p.color(100,0,0));	
		}
		  
	   if(src.x == dest.x){
		   ht=src.dist;
		   wd = 5;
		   
	   } else if(src.y == dest.y){
		   wd =  src.dist;
		   ht = 5;
	   }
	   	
	   if(src.height > dest.height){
		   p.rect(src.width, dest.height, ht, wd);
	   }else if(src.width > dest.width) {
		   p.rect(dest.width, src.height, ht, wd);
	   } else{
		   p.rect(src.width, src.height, ht, wd);
	   }
	    
	  }
	  
	  void markVisited(){
		  visited = true;
		  draw();
	  }
}
