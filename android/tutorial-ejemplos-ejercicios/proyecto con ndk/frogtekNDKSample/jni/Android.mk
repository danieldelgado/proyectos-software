LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= ndksample
LOCAL_SRC_FILES:= ndksample.c

include $(BUILD_SHARED_LIBRARY)