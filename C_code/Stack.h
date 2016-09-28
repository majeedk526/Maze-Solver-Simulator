#pragma once

#include <stdio.h>
#include "Types.h"
#include <stdlib.h>

typedef struct StackNodes{
	struct StackNodes *bottom;
	Node *data; 
} StackNode;

typedef struct Stacks{
	StackNode * stackHead;
} Stack;

void push(Stack *stack, Node *n);
Node* pop(Stack *stack);
StackNode* getStackPointer();

StackNode* getStackPointer(){
	StackNode *stack = (StackNode*) malloc(sizeof(StackNode));
	stack->bottom = NULL;
	return stack;
}

void push(Stack *stack, Node *n){
	
	StackNode *newStackNode = (StackNode*) malloc(sizeof(StackNode));
	newStackNode->data = n;
	newStackNode->bottom = stack->stackHead;
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
	return data;
}
