package dsa;

import processing.core.PApplet;

public class Node {
	
	public int x, y;
	PApplet p;
	private final int XOFFSET = 200;
	private final int YOFFSET = -40;
	public int dist = 100;
	//private int width, height;
	int width, height;
	
	  
	  public Node(PApplet p, int x, int y){
	    
		this.p = p;
	    this.x = x;
	    this.y = y*10+x;
	    
	  }
	  
	  
	  public void draw(){
		  
		 width = XOFFSET + dist*(y/10+1);
		 height = YOFFSET + dist* (x+1);
		 
		  if(p.mouseX>=width-10 && p.mouseX<=width+10 && p.mouseY>=height-10 && p.mouseY<=height+10){
			  p.fill(p.color(0,100,0));
			  p.ellipse(width, height, 50, 50);
			  
		  }else {
			  
			  p.fill(255);
			  p.stroke(255);
			  p.ellipse(width, height, 50, 50);
			  p.ellipse(width, height, 50, 50);
		  }
		  
		  p.stroke(0);
		  p.fill(p.color(0,0,100));
		  p.ellipse(width, height, 20, 20);
		  
	  }

}
