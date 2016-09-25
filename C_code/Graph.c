#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // for bool
#include <stddef.h> // for NULL

int i;

typedef struct List{
	struct Nodes * head;
} AdjList;

typedef struct Nodes{
	int _id;
	struct Nodes * next; //left, right, forward node
} Node;

typedef struct Graphs{
	int size;
	AdjList * adjList;
} Graph;

Graph* createGraph(int size){
	
	Graph * graph = (Graph*) malloc(sizeof(Graph));
	
	graph->size = size;
	graph->adjList = (AdjList*) malloc(sizeof(size * AdjList));
	
	for(i=0; i<size; i++){
		graph->adjList[i].head = NULL;
	}	
	
	return true;
}

bool addNode(Graph* graph){
	
	AdjList *nAdjList = (AdjList) malloc(sizeof(AdjList));
	nAdjList->head = NULL;
	graph[graph->size] = nAdjList;
	graph->size++;

	return true;
		
	
}

bool addEdge(Graph *graph, int src, int dest){
	
	Node *node = (Node*) malloc(sizeof(Node));
	node->_id = dest;
	node->next = NULL;
	
	if(graph[src].head == NULL){
		graph[src].head = node;
		return true;
	}
	
	Node *tmp = graph[src].head;
	
	while(tmp->next != NULL){
		tmp = tmp->next;
	}
	
	tmp->next = node;
	return true;
}

void printGraph(Graph *graph){
	
	int s = graph->size;
	printf("Size of graph = %d\n", s);
	
	
	
	AdjList *tmpList = graph[0];
	for(i=0; i<s; i++){
		
	}
	
}



