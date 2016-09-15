package dsa;

import processing.core.PApplet;

public class Node {
	
	private int cSize = 10;
	public int lOffset, hOffset;
	PApplet p;
	  
	  
	  public Node(Object o, int lOffset, int hOffset){
	    
		this.p = (PApplet) o;
	    this.lOffset = lOffset;
	    this.hOffset = hOffset;
	  
	  }


	  void draw(){
	    
	    p.fill(p.color(0,0,150));
	    p.ellipse(lOffset, hOffset, cSize, cSize);
	    
	  }
	

}
