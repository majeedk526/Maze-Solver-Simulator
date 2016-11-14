package dsa;

import processing.core.PApplet;

public class JGraph extends PApplet{
	
	private int sConst = 100;
	private int refWidth = 150;
	private int refHeight = 20;
	
	JGraph jgraph; // Use to call non-static method of JGraph class
	Gui gui; // holds object of GUI class to generate maze
	
	
	public static void main(String[] args) {
		// apply the processing API 
		PApplet.main(JGraph.class.getName());
	}
	
	// setup window
	public void settings(){
		
		size(1200, 800);
	}
	
	public void setup(){
	
		background(255);
		surface.setResizable(true);
		
		gui = new Gui(this);
		gui.setup();
		
	}
	
	//  Update graphics continuously
	public void draw(){
		
		gui.draw();
		
		// Animate search button
		if(mouseX < 70 && mouseX > 10 && mouseY < 70 && mouseY > 10){
			stroke(4);
			fill(0,200,0);
			ellipse(40,40,60,60);
			fill(0);
			text("Search", 20,45);
		} else {
			stroke(4);
			fill(0,200,0);
			ellipse(40,40,50,50);
			fill(0);
			text("Search", 20,45);
		}
		
		
		// Animate reset button
		if(mouseX < 70 && mouseX > 10 && mouseY < 120 && mouseY > 75 ) {
			stroke(4);
			fill(200,200,100);
			ellipse(40,95,60,60);
			fill(0);
			text("Reset", 25,100);
		}else {
			stroke(4);
			fill(200,200,100);
			ellipse(40,95,50,50);
			fill(0);
			text("Reset", 25,100);
		}
		
		// Print text information
		fill(color(10,150,200));	
		rect(40,160,50,5);
		text("Edge visited once.",95,165);
		
		fill(color(250,150,200));
		rect(40,180,50,5);
		text("Edge revisited",95,185);
	}
	
	public void mouseClicked(){
		
		// Search button clicked
		if(mouseX < 70 && mouseX > 10 && mouseY < 70 && mouseY > 10){
			gui.search();
			
			// Reset button clicked
		} else if(mouseX < 70 && mouseX > 10 && mouseY < 120 && mouseY > 75 ){
			gui.reset();
			
			// Check if any maze node is clicked
		}else {
			gui.mouseClicked(mouseX, mouseY);
		}
	}		
}
