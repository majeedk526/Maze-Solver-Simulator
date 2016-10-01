#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"

Graph *graph;

int main(void){
	
	
	/**addEdge(graph,0,2);
	addEdge(graph,0,1);
	addEdge(graph,1,2);
	addEdge(graph,0,2);
	addEdge(graph,2,0);	**/
	//printGraph(graph);
	
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
	
}

int* jDfsSearch(int src, int dest){
	return dfsSearch(graph, 0,2);	
}
