package dsa;

import processing.core.PApplet;

public class Node {
	
	public int x, y;
	PApplet p;
	private final int XOFFSET = 200;
	private final int YOFFSET = -40;
	public int dist = 80;
	int width, height;
	boolean isSelected = false;
	
	private int R, G, B;
	  
	  public Node(PApplet p, int x, int y){
	    
		this.p = p;
	    this.x = x;
	    this.y = y;
	    
	  }
	  
	  
	  public void draw(){
		  
		 width = XOFFSET + dist*((y*10+x)/10+1);
		 height = YOFFSET + dist* (x+1);
		 
		 
		 	if(p.mouseX>=width-10 && p.mouseX<=width+10 && p.mouseY>=height-10 && p.mouseY<=height+10){
		 		  p.text("x: " + x + " y : " + y, 20,100);
				  p.fill(p.color(0,100,0));
				  p.ellipse(width, height, 50, 50);
			  }
		  
		 	if(isSelected){
		 		p.fill(p.color(R,G,B));
				p.ellipse(width, height, 50, 50);
		 	}
		  
		  p.stroke(0);
		  p.fill(p.color(0,0,100));
		  p.ellipse(width, height, 20, 20);
		  
	  }
	  
	  public void setSrc(){
		  isSelected = true;
		 R=223; G= 220; B=20;
	  }
	  
	  public void setDest(){
		  isSelected = true;
		  R=20; G= 169; B=243; 
	  }
	  
	  boolean isGotClicked(float x, float y){
		
		  if(x>=width-10 && x<=width+10 && y>=height-10 && y<=height+10){
			  return true;
		  }
		  return false;
		  
	  }
}
