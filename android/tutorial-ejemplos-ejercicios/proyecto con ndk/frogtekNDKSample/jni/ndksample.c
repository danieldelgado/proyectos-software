#include <string.h>
#include <jni.h>

jstring Java_org_frogtek_ndksample_Main_getStringFromNDK(JNIEnv* env, jobject this)
{
	return (*env)->NewStringUTF(env, "Croak 2!!");
}
