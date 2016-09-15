package dsa;

import processing.core.PApplet;

public class Edge {
	
	int lOffset, hOffset, wd, ht;
	PApplet p;
	  
	  public Edge(Object o, int lo, int ho, int w, int h){
	  
		this.p = (PApplet) o;
	    this.lOffset = lo;
	    this.hOffset = ho;
	    this.wd = w;
	    this.ht = h;
	    draw();

	  }
	  
	  
	  void draw(){
	    
	    p.rect(lOffset, hOffset, wd, ht);
	  }
	

}
