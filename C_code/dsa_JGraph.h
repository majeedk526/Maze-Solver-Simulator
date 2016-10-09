/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class dsa_JGraph */

#ifndef _Included_dsa_JGraph
#define _Included_dsa_JGraph
#ifdef __cplusplus
extern "C" {
#endif
#undef dsa_JGraph_DEBUG
#define dsa_JGraph_DEBUG 0L
#undef dsa_JGraph_DEFAULT_WIDTH
#define dsa_JGraph_DEFAULT_WIDTH 100L
#undef dsa_JGraph_DEFAULT_HEIGHT
#define dsa_JGraph_DEFAULT_HEIGHT 100L
#undef dsa_JGraph_PERLIN_YWRAPB
#define dsa_JGraph_PERLIN_YWRAPB 4L
#undef dsa_JGraph_PERLIN_YWRAP
#define dsa_JGraph_PERLIN_YWRAP 16L
#undef dsa_JGraph_PERLIN_ZWRAPB
#define dsa_JGraph_PERLIN_ZWRAPB 8L
#undef dsa_JGraph_PERLIN_ZWRAP
#define dsa_JGraph_PERLIN_ZWRAP 256L
#undef dsa_JGraph_PERLIN_SIZE
#define dsa_JGraph_PERLIN_SIZE 4095L
/*
 * Class:     dsa_JGraph
 * Method:    jCreateGraph
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_dsa_JGraph_jCreateGraph
  (JNIEnv *, jobject, jint);

/*
 * Class:     dsa_JGraph
 * Method:    jAddEdge
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_dsa_JGraph_jAddEdge
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     dsa_JGraph
 * Method:    jDisplayGraph
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_dsa_JGraph_jDisplayGraph
  (JNIEnv *, jobject);

/*
 * Class:     dsa_JGraph
 * Method:    jDfsSearch
 * Signature: (II)[I
 */
JNIEXPORT jintArray JNICALL Java_dsa_JGraph_jDfsSearch
  (JNIEnv *, jobject, jint, jint);

#ifdef __cplusplus
}
#endif
#endif