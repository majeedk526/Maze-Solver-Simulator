package dsa;

import processing.core.PApplet;

public class Edge {
	
	int lOffset, hOffset, wd, ht;
	Node sn, dn; // source and destination node
	PApplet p;
	
	private final static int SIZE = 2; 
	  
	  public Edge(Object o, Node sn, Node dn){
	  
		  this.sn = sn; 
		  this.dn = dn;
		  this.p = (PApplet) o;
		  uvColor();

	  }
	  
	  
	  void draw(){
	    
	    p.rect(lOffset, hOffset, wd, ht);
	  }
	  
	  
	  void vColor(int r, int g, int b){
		  
		  p.fill(p.color(100,150,200));
		  draw();
		  
	  }
	  
	  void uvColor(){
		  p.fill(0);
		  draw();
		  
	  }
	  
	  private int getHeight(){
		  
		  if(sn.lOffset == dn.lOffset){return dn.hOffset - sn.hOffset;}
		  else {return SIZE;}
	  }
	  
	  private int getWidth(){
		  
		  if(sn.hOffset == dn.hOffset){return dn.lOffset - sn.lOffset;}
		  else {return SIZE;}
	  }
	

}
