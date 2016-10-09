#include <stdio.h>
#include "Types.h"
#include "Stack.h"
#include <stdbool.h>
#include "Graph.c"

int visited[200] = {-1};
int numVisited = 0;
bool pathFound = false;

bool isVisited(int _id);
AdjListNode* getListNode(Graph *graph, int _id);
void printPath();

int* dfsSearch(Graph *graph, int src, int dest){
	
	
	bool searchOver = false;
	
	int trackBack[50];
	int tbVisited = 0;
	bool isBackTracking = false;
	
	Stack *stack = getStackPointer();
	Stack *tbstack = getStackPointer();
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
		} else {
			//put on back track stack
			if(!isVisited(tmpNode->_id)){
				push(tbstack,tmpNode);	
			}
		}
		
		if(isVisited(tmpNode->_id)){
			// throw first element of back track stack
			// pop and add to visited (from tbstack) until unvisited neighbour node is found
			isBackTracking = true;
			pop(tbstack); // throw top node
			while(isBackTracking){
				Node *node = pop(tbstack);
				if(node == NULL) {searchOver = true; break;}
				visited[numVisited] = node->_id;
				numVisited++;
				nbrIds = getNeighbours(graph,node->_id);
				while(nbrsCount!=0){
					if(!isVisited(*nbrIds)){
						push(tbstack,node);
						isBackTracking = false;
						break;
					}
					nbrIds++;
					nbrsCount--;	
				}
				
				if(!isBackTracking){break;}		
			}
			continue;
		}
		
		visited[numVisited] = tmpNode->_id;
		numVisited++;
		if(tmpNode->_id == dest){
			pathFound = true;
			continue;
		}
		
		nbrIds = getNeighbours(graph,tmpNode->_id);
		if(nbrsCount==1) {push(stack, tmpNode);}
		while(nbrsCount!=0){
			if(*nbrIds == dest){
				visited[numVisited] = *nbrIds;
				numVisited++;
				pathFound = true;
				break; // break while loop
			}
			if(!isVisited(*nbrIds)){
				AdjListNode *adjNode = getListNode(graph, *nbrIds);
				push(stack, adjNode->head);
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



