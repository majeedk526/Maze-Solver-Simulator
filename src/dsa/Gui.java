package dsa;

import processing.core.PApplet;

public class Gui {
	
	PApplet p;
	JGraph jgraph;
	
	public Gui(JGraph jgraph){
		this.p = (PApplet) jgraph;
		this.jgraph = jgraph;
	}
	
	public void settings(){
		p.size(1200, 800);
	}
	
	public void setup(){
		p.background(255);
		p.getSurface().setResizable(true);
	}
	
	public void draw(){
		// create node points
				for(int i=0;i<10;i++){
					for(int j=0; j<10; j++){
						jgraph.addNode(i,j);
					}
				}
				
				jgraph.addEdge(0,0,0,1);		
				jgraph.addEdge(0,0,1,0);
				jgraph.addEdge(1,0,1,1);
				jgraph.addEdge(1,1,1,2);
				jgraph.addEdge(1,2,1,3);
				jgraph.addEdge(1,3,2,3);
				jgraph.addEdge(2,3,3,3);
				jgraph.addEdge(3,3,3,2);
				jgraph.addEdge(2,2,3,2);
				
	}
	
	public void createGraph(int size){
		jgraph.jCreateGraph(100);
	}

}
