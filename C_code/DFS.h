#include <stdio.h>
#include "Types.h"
#include "Stack.h"
#include <stdbool.h>
#include "Graph.c"

int visited[100] = {-1};
int numVisited = 0;

bool isVisited(int _id);
AdjListNode* getListNode(Graph *graph, int _id);
void printPath();

int* dfsSearch(Graph *graph, int src, int dest){
	
	bool pathFound = false;
	bool searchOver = false;
	int path[100];
	
	Stack *stack = getStackPointer();
	int curId;
	int j = 0;
	int *cnbrs;
	
	AdjListNode *tmpListNode = getListNode(graph, src);
	Node *tmpNode = tmpListNode->head;
	
	while(!pathFound || !searchOver){
		curId = tmpNode->_id;
		numVisited++;
		if(isVisited(curId)){
			tmpNode = pop(stack);
			continue;
		}
		
		visited[j] = curId;
		j++;
		
		if(curId == dest){
			pathFound = true;
			printPath();
			break;
		}
		
		cnbrs = getNeighbours(graph,curId);
		while(nbrsCount!=0){
			AdjListNode *adjNode = getListNode(graph, *cnbrs);
			Node* nNode = adjNode->head;
			if(nNode->_id == dest){
				push(stack,nNode);
				break;
			} 
			push(stack, adjNode->head);
			cnbrs++;
			nbrsCount--;	
		}
		
		//tmpNode = getListNode(graph, tmpNode->_id);
		tmpNode = pop(stack);
		if(tmpNode == NULL){
			searchOver = true;
		}
	}	
}

void printPath(){
	int i=0;
	for(i=0; i<numVisited; i++){
		printf("%d -> ", visited[i]);
	}
	printf("\n");
}

bool isVisited(int _id){
	int i =0;
	for(i=0; i<numVisited; i++){
		if(_id == visited[i]){
			return true;
		}
	}
	
	return false;
}



