#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"

Graph *graph;

int main(void){
	
	graph = createGraph(10);
	addEdge(graph,0,1);
	addEdge(graph,0,3);
	addEdge(graph,0,5);
	addEdge(graph,1,3);
	addEdge(graph,1,7);
	addEdge(graph,2,9);
	addEdge(graph,9,1);
	printGraph(graph);
	
	//dfsSearch(graph, 0,2);
	
	//system("PAUSE");
	//return EXIT_SUCCESS;	
}


void jCretaeGraph(){
	graph = createGraph(3);
}

void jAddEdge(int src, int dest){
	addEdge(graph,src, dest);
}

void jDisplayGraph(){
	printGraph(graph);
}

int* jDfsSearch(int src, int dest){
	return dfsSearch(graph, 0,2);	
}
