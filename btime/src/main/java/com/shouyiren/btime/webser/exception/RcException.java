package com.shouyiren.btime.webser.exception;


import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:49
 * email:727933147@qq.com
 */

public class RcException
        extends RuntimeException {
    protected static List<ResourceBundle> resourceBundleList = new LinkedList();
    private static final long serialVersionUID = 5862719337181086056L;
    protected int rc;

    static {
        addResourceBundle("com.shouyiren.btime.webser.exception.RcException");
    }

    public RcException(int paramInt) {
        super(getValue(new StringBuilder().append("rc_").append(paramInt).toString()) + "(" + paramInt + ")");
        setRc(paramInt);
    }

    public RcException(int paramInt, String paramString) {
        super(paramString);
        setRc(paramInt);
    }

    public RcException(int paramInt, Throwable paramThrowable) {
        super(getValue(new StringBuilder().append("rc_").append(paramInt).toString()) + "(" + paramInt + ")", paramThrowable);
        setRc(paramInt);
    }

    public static void addResourceBundle(String paramString) {
        ResourceBundle param = ResourceBundle.getBundle(paramString);
        resourceBundleList.add(0, param);
    }

    public static String getValue(String paramString) {
        String str = null;
        try {
            Iterator localIterator = resourceBundleList.iterator();
            do {
                if (!localIterator.hasNext()) {
                    break;
                }
                str = ((ResourceBundle) localIterator.next()).getString(paramString);
            } while (str == null);
        } catch (Exception e) {
            for (; ; ) {
                str = "";
            }
        }
        return str;
    }

    public static CommonRes retErr(Exception paramException, CommonRes paramCommonRes) {
        paramCommonRes.setErrorInfo(paramException.getMessage());
        if (paramException.getClass() == RcException.class) {
            paramCommonRes.setRc(((RcException) paramException).getRc());
        }
        for (; ; ) {
            paramCommonRes.setRc(CommonRes.RES_RUNTIME_EXCEPTION);
            return paramCommonRes;
        }
    }

    public int getRc() {
        return this.rc;
    }

    public StackTraceElement[] getStackTrace() {
        int i = 5;
        StackTraceElement[] arrayOfStackTraceElement1 = super.getStackTrace();
        if (arrayOfStackTraceElement1.length < 5) {
            i = arrayOfStackTraceElement1.length;
        }
        StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[i];
        System.arraycopy(arrayOfStackTraceElement1, 0, arrayOfStackTraceElement2, 0, i);
        return arrayOfStackTraceElement2;
    }

    public void printStackTrace(PrintStream paramPrintStream) {
        try {
            paramPrintStream.println(this);
            StackTraceElement[] arrayOfStackTraceElement = super.getStackTrace();
            for (int i = 0; (i < arrayOfStackTraceElement.length) && (i < 5); i++) {
                StringBuilder localStringBuilder = new StringBuilder();
                paramPrintStream.println("\tat " + arrayOfStackTraceElement[i]);
            }
            return;
        } finally {
        }
    }

    public void setRc(int paramInt) {
        this.rc = paramInt;
    }
}

