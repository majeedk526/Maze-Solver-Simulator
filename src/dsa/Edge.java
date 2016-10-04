package dsa;

import processing.core.PApplet;

public class Edge {
	
	int wd, ht;
	Node src, dest; // source and destination node
	PApplet p;
	
	private final static int SIZE = 2; 
	  
	  public Edge(PApplet p, Node src, Node dest){
	  
		  this.src = src; 
		  this.dest = dest;
		  this.p = p;
		  uvColor();

	  }
	  
	  
	  void draw(){
	   if(src.x == dest.x){
		   ht=src.dist;
		   wd = 5;
		   
	   } else if(src.y == dest.y){
		   wd =  src.dist;
		   ht = 5;
	   }
	   	
	   vColor();
	    p.rect(src.width, src.height, ht, wd);
	  }
	  
	  
	  void vColor(){ // visited color
		  
		  p.fill(p.color(0,150,200));
		  
		  
	  }
	  
	  void uvColor(){ //unvisited color
		  p.fill(p.color(100,0,0));
		  draw();
		  
	  }
	  
	/**  private int getHeight(){
		  
		//  if(sn.lOffset == dn.lOffset){return dn.hOffset - sn.hOffset;}
		 // else {return SIZE;}
	  }
	  
	  private int getWidth(){
		  
		  //if(sn.hOffset == dn.hOffset){return dn.lOffset - sn.lOffset;}
		  //else {return SIZE;}
	  }
	
**/
}
