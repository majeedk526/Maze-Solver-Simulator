#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"


int main(void){
	
	Graph *graph = createGraph(3);
	addEdge(graph,0,2);
	addEdge(graph,0,1);
	addEdge(graph,1,2);
	addEdge(graph,0,2);
	addEdge(graph,2,0);	
	printGraph(graph);
	
	dfsSearch(graph, 0,2);
	
	system("PAUSE");
	return EXIT_SUCCESS;	
}
