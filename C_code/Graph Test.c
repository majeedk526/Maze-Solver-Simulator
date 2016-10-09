#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"

Graph *graph;

int main(void){
	
	graph = createGraph(10);
	addEdge(graph,0,1);
	addEdge(graph,0,3);
	//addEdge(graph,0,5);
	addEdge(graph,1,3);
	//addEdge(graph,1,7);
	//addEdge(graph,2,9);
	//addEdge(graph,9,1);
	printGraph(graph);
	
	int *ids = dfsSearch(graph, 0,2);
	int i=0;
	
	for(i=0; i< numVisited; i++){
		printf("%d -> ", ids[i]);
	}
	
	//system("PAUSE");
	//return EXIT_SUCCESS;	
}
