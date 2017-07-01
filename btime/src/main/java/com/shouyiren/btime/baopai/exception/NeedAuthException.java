package com.shouyiren.btime.baopai.exception;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:28
 * email:727933147@qq.com
 */

public class NeedAuthException
        extends RuntimeException {
    private static final long serialVersionUID = 913693228141184668L;

    public NeedAuthException() {
    }

    public NeedAuthException(String paramString) {
        super(paramString);
    }
}

