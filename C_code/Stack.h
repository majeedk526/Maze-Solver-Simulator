#pragma once

#include <stdio.h>
#include "Types.h"
#include <stdlib.h>

typedef struct StackNodes{
	struct StackNodes *bottom;
	Node *data; 
} StackNode;

typedef struct Stacks{
	int size;
	StackNode * stackHead;
} Stack;

void push(Stack *stack, Node *n);
Node* pop(Stack *stack);
Stack* getStackPointer();

Stack* getStackPointer(){
	Stack *stack = (Stack*) malloc(sizeof(Stack));
	stack->stackHead = NULL;
	stack->size = 0;
	return stack;
}

void push(Stack *stack, Node *n){
	
	StackNode *newStackNode = (StackNode*) malloc(sizeof(StackNode));
	newStackNode->data = n;
	newStackNode->bottom = stack->stackHead; // first node has bottom = NULL
	stack->size++;
	stack->stackHead = newStackNode;
}

Node* pop(Stack *stack){
	
	if(stack->stackHead == NULL){
		printf("No element in stack.\n");
		return NULL;
	}
	
	StackNode *stackNode = stack->stackHead;
	Node *data = stackNode->data;
	stack->stackHead = stackNode->bottom;
	free(stackNode);
	stack->size--;
	return data;
}

void printStack(Stack *stack){
	StackNode *snode = stack->stackHead;
	int s = 0;
	int snodes[100];
	while(snode != NULL){
		snodes[s] = snode->data->_id;
		snode = snode->bottom;
		s++;
	}
	while(s>0){
		printf("%d, ",snodes[--s]);	
	}
	
	printf("\n");
}
