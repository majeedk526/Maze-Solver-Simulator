#pragma once

typedef struct AdjListNodes{
	struct AdjListNodes * next;
	struct AdjListNodes * prev;
	struct Nodes * head;
} AdjListNode;

typedef struct Nodes{
	int _id;
	struct Nodes *src, *dest;
} Node;

typedef struct Graphs{
	int size;
	AdjListNode * adjListHead;
} Graph;
