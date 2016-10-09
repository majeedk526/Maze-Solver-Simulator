#include <stdio.h>
#include "Graph.c"
#include <stdlib.h>
#include "DFS.h"
#include "dsa_JGraph.h"

Graph *graph;

JNIEXPORT void JNICALL Java_dsa_JGraph_jCreateGraph
  (JNIEnv *env, jobject o, jint size){
  	
  	graph = createGraph(size);
  	return;
  }

JNIEXPORT void JNICALL Java_dsa_JGraph_jAddEdge
  (JNIEnv *env, jobject o, jint src, jint dest){
  	addEdge(graph,src, dest);
  	return;
  }

JNIEXPORT void JNICALL Java_dsa_JGraph_jDisplayGraph
  (JNIEnv *env, jobject o){
	printGraph(graph);
	return;  	
  }
  
  
JNIEXPORT jintArray JNICALL Java_dsa_JGraph_jDfsSearch
  (JNIEnv *env, jobject o, jint src, jint dest){
  	int *path =  dfsSearch(graph, src,dest);
  	int i=0;
  	jint arr[200] = {-1};
	for(i=0;i<numVisited;i++){
		arr[i] = path[i]; 	
	} 
  	
  	if(!pathFound){
  		arr[i] = -2; // unsuccessful search
	  }
  	
  	jintArray p = (*env)->NewIntArray(env, 200);
  	(*env)->SetIntArrayRegion(env, p,0,200,arr);

	  return p;
  }
