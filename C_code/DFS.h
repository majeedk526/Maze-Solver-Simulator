#include <stdio.h>
#include "Types.h"
#include "Stack.h"
#include <stdbool.h>
#include "Graph.c"

int visited[100] = {-1};
int numVisited = 0;
bool pathFound = false;

bool isVisited(int _id);
AdjListNode* getListNode(Graph *graph, int _id);
void printPath();

int* dfsSearch(Graph *graph, int src, int dest){
	
	
	bool searchOver = false;
	
	Stack *stack = getStackPointer();
	int curId;
	int *nbrIds;
	
	AdjListNode *tmpListNode = getListNode(graph, src);
	Node *tmpNode = tmpListNode->head;
	
	push(stack, tmpNode);
	
	while(!pathFound && !searchOver){
		
		tmpNode = pop(stack);
		if(tmpNode==NULL){
			searchOver = true;
			continue;
		}
		
		visited[numVisited] = tmpNode->_id;
		numVisited++;
		if(tmpNode->_id == dest){
			pathFound = true;
			continue;
		}
		
		nbrIds = getNeighbours(graph,tmpNode->_id);
		while(nbrsCount!=0){
			AdjListNode *adjNode = getListNode(graph, *nbrIds);
			Node* nNode = adjNode->head;
			if(nNode->_id == dest){
				visited[numVisited] = nNode->_id;
				numVisited++;
				pathFound = true;
				break; // break while loop
			}
			
			if(!isVisited(nNode->_id)){
				push(stack, nNode);
			} 
			
			nbrIds++;
			nbrsCount--;	
		}
		
		if(pathFound){continue;	} // get out of main loop
	}
	
	return visited;	
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



