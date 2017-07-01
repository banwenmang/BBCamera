package com.shouyiren.bbcamera.utils;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Log;

import com.dw.bcamera.engine.BTEngine;
import com.dw.bcamera.engine.CommonMgr;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:25
 * email:727933147@qq.com
 */

public class CrashHandler
        implements Thread.UncaughtExceptionHandler {
    private static CrashHandler INSTANCE = new CrashHandler();
    public static final String TAG = "CrashHandler";
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private Map<String, String> infos = new HashMap();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    private boolean handleException(Throwable paramThrowable) {
        if (paramThrowable == null) {
        }
        for (boolean bool = false; ; bool = true) {
            return bool;
            collectDeviceInfo(this.mContext);
            saveCrashInfo2File(paramThrowable);
        }
    }

    private void saveCrashInfo2File(Throwable paramThrowable) {
        if (paramThrowable == null) {
            return;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        Object localObject1;
        label35:
        Object localObject2;
        if (this.infos != null) {
            localObject1 = this.infos.entrySet().iterator();
            if (((Iterator) localObject1).hasNext()) {
            }
        } else {
            localObject1 = new StringWriter();
            localObject2 = new PrintWriter((Writer) localObject1);
            paramThrowable.printStackTrace((PrintWriter) localObject2);
        }
        for (paramThrowable = paramThrowable.getCause(); ; paramThrowable = paramThrowable.getCause()) {
            if (paramThrowable == null) {
                ((PrintWriter) localObject2).close();
                localStringBuffer.append(localObject1.toString());
                BTEngine.singleton().getCommonMgr().sendErrorLog2Server(localStringBuffer.toString());
                break;
                Object localObject3 = (Map.Entry) ((Iterator) localObject1).next();
                localObject2 = (String) ((Map.Entry) localObject3).getKey();
                localObject3 = (String) ((Map.Entry) localObject3).getValue();
                localStringBuffer.append(localObject2 + "=" + (String) localObject3 + "\n");
                break label35;
            }
            paramThrowable.printStackTrace((PrintWriter) localObject2);
        }
    }

    public void collectDeviceInfo(Context paramContext) {
        Object localObject;
        StringBuilder localStringBuilder;
        try {
            localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1);
            if (localObject != null) {
                if (((PackageInfo) localObject).versionName != null) {
                    break label99;
                }
                paramContext = "null";
                localStringBuilder = new java / lang / StringBuilder;
                localStringBuilder.<init> (String.valueOf(((PackageInfo) localObject).versionCode));
                localObject = localStringBuilder.toString();
                this.infos.put("versionName", paramContext);
                this.infos.put("versionCode", localObject);
            }
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                int j;
                Log.e("CrashHandler", "an error occured when collect package info", paramContext);
            }
            localStringBuilder = paramContext[i];
        }
        paramContext = Build.class.getDeclaredFields();
        j = paramContext.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return;
                label99:
                paramContext = ((PackageInfo) localObject).versionName;
                break;
            }
            try {
                localStringBuilder.setAccessible(true);
                this.infos.put(localStringBuilder.getName(), localStringBuilder.get(null).toString());
                localObject = new java / lang / StringBuilder;
                ((StringBuilder) localObject).<init> (String.valueOf(localStringBuilder.getName()));
                Log.d("CrashHandler", " : " + localStringBuilder.get(null));
                i++;
            } catch (Exception localException) {
                for (; ; ) {
                    Log.e("CrashHandler", "an error occured when collect crash info", localException);
                }
            }
        }
    }

    public void init(Context paramContext) {
        this.mContext = paramContext;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        handleException(paramThrowable);
        try {
            Thread.sleep(3000L);
            if (this.mDefaultHandler != null) {
                this.mDefaultHandler.uncaughtException(paramThread, paramThrowable);
            }
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
                Log.e("CrashHandler", "error : ", localInterruptedException);
            }
        }
    }
}

