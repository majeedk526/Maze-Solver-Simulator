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
		 
		if(visited){
			p.fill(p.color(R,150,200));
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
		   p.rect(src.width-5, dest.height, ht, wd);
	   }else if(src.width > dest.width) {
		   p.rect(dest.width, src.height-5, ht, wd);
	   } else{
		   
		   //if(ht==5){
			   p.rect(src.width, src.height-5, ht, wd);
		   //} else{
			 //  if(ht==5){
			//	   p.rect(src.width-5, src.height-5, ht, wd);
			  // }
		   //}
		   
	   }
	    
	  }
	  
	  void markVisited(){
		  visited = true;
		  R*=5;
		  draw();
	  }
}
