#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"

Graph *graph;

int main(void){
	
	graph = createGraph(10);
	addEdge(graph,1,2);
	addEdge(graph,1,3);
	addEdge(graph,1,7);
	addEdge(graph,7,9);
	addEdge(graph,3,4);
	addEdge(graph,4,5);
	addEdge(graph,5,3);
	addEdge(graph,2,6);
	printGraph(graph);
	
	int *ids = dfsSearch(graph, 1,10);
	int i=0;
	
	for(i=0; i< numVisited; i++){
		printf("%d -> ", ids[i]);
	}
	
	//system("PAUSE");
	//return EXIT_SUCCESS;	
}
