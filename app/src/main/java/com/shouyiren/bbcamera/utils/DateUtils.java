package com.shouyiren.bbcamera.utils;


import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:25
 * email:727933147@qq.com
 */

public class DateUtils {
    private static final String[] Animals = {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
    private static final String[] Gan = {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
    private static final String[] Zhi = {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
    private static Calendar sCalendar;

    public static final String AnimalsYear(int paramInt) {
        return Animals[((paramInt - 4) % 12)];
    }

    public static Calendar calendarInstance() {
        if (sCalendar == null) {
            sCalendar = new GregorianCalendar();
        }
        return sCalendar;
    }

    public static final String cyclical(int paramInt) {
        return cyclicalm(paramInt - 1900 + 36);
    }

    private static final String cyclicalm(int paramInt) {
        return Gan[(paramInt % 10)] + Zhi[(paramInt % 12)];
    }
}

