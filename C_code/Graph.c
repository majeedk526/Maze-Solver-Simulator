#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // for bool
#include <stddef.h> // for NULL
#include "Types.h"

int i;

Graph* createGraph(int size);
AdjListNode* newListNode(AdjListNode *prev, int _id);
Node* newNode(Node * src, int _id);
bool addEdge(Graph *graph, int src, int dest);

Graph* createGraph(int size){
	
	if(size<=0) {
		printf("size must be greater than 0.\n");
		return NULL;
	}
	
	Graph * graph = (Graph*) malloc(sizeof(Graph));
	graph->size = size;
	
	graph->adjListHead = newListNode(NULL,0); //list start reference
	
	AdjListNode * tmpListNode = graph->adjListHead; // for traversing
	Node *tmpNode = tmpListNode->head;
	
	for(i=1;i<size;i++){
		tmpListNode->next = newListNode(tmpListNode,i);
		tmpListNode = tmpListNode->next;
	}
	
	return graph;
}

Node* newNode(Node * src, int _id){
	Node * node = (Node*) malloc(sizeof(Node));
	node->_id = _id;
	node->src = src;
	node->dest = NULL;
	return node;
}

AdjListNode* newListNode(AdjListNode *prev, int _id){
	
	AdjListNode * newLNode = (AdjListNode*) malloc(sizeof(AdjListNode));
	
	newLNode->prev = prev;
	newLNode->next = NULL;
	newLNode->head= newNode(NULL, _id);
	return newLNode;
}

bool addEdge(Graph *graph, int src, int dest){
	
	AdjListNode *tmpListNode = graph->adjListHead;
	Node *tmpNode;
	
	int s = graph->size;
	
	for(i=0; i<src; i++){
		tmpListNode = tmpListNode->next;
	}
	
	tmpNode = tmpListNode->head;
	
	while(tmpNode->dest != NULL){
		tmpNode = tmpNode->dest;
		if(tmpNode->_id == dest){
			printf("path between %d and %d already exists.\n");
			return false;
		}
	}
	
	tmpNode->dest = newNode(tmpNode,dest);
	return true;
}

void printGraph(Graph *graph){
	
	int s = graph->size;
	printf("Size of graph = %d\n", s);
	
	if(s==0){ return;}
	
	AdjListNode *tmpListNode = graph->adjListHead;
	Node *tmpNode;
	for(i=0; i<s; i++){
		tmpNode = tmpListNode->head;
		printf("%d -> ", tmpNode->_id);
		while (tmpNode->dest != NULL){
			tmpNode = tmpNode->dest;
			printf("%d , ", tmpNode->_id);
		}
		printf("\n");
		tmpListNode = tmpListNode->next;
	}
	
}



