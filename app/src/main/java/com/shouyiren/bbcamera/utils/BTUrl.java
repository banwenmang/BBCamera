package com.shouyiren.bbcamera.utils;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;

import com.dw.bcamera.setting.FeedbackActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:25
 * email:727933147@qq.com
 */
public final class BTUrl {
    public static final String MODULE_FEEDBACK = "feedback";
    public static final String MODULE_MALL_AREA = "area";
    public static final String MODULE_MALL_DETAIL = "detail";
    public static final String MODULE_MALL_ORDER = "order";
    public static final String MODULE_PHOTO_SELECT = "photoselect";
    public static final String MODULE_RECIPE = "recipe";
    public static final String MODULE_VIDEO_SELECT = "videoselect";
    public static final String SHARE_QQ = "qq";
    public static final String SHARE_QQ_SCENE_QQ = "0";
    public static final String SHARE_QQ_SCENE_QZONE = "1";
    public static final String SHARE_SINA = "sina";
    public static final String SHARE_TYPE_APP = "2";
    public static final String SHARE_TYPE_TEXT = "1";
    public static final String SHARE_TYPE_WEBURL = "0";
    public static final String SHARE_WEIXIN_SCENE_FRIENDS = "0";
    public static final String SHARE_WEIXIN_SCENE_P2P = "1";
    public static final String SHARE_WENXIN = "weixin";
    public static final String URL_MODE_APPSTORE = "appstore";
    public static final String URL_MODE_BROWSE = "browse";
    public static final String URL_MODE_CLOSEWEB = "closeweb";
    public static final String URL_MODE_INIT_FONT_SIZE = "initFontResize";
    public static final String URL_MODE_INIT_SHARE = "initShare";
    public static final String URL_MODE_MODULE = "module";
    public static final String URL_MODE_SHARE = "share";
    public static final String URL_MODE_WEBVIEW = "webview";
    public static final String URL_PARAM_ALBUM_ID = "albumid";
    public static final String URL_PARAM_ARTICLEID = "articleid";
    public static final String URL_PARAM_BRAND_ID = "brandid";
    public static final String URL_PARAM_COUNT = "count";
    public static final String URL_PARAM_CUSTOM = "custom";
    public static final String URL_PARAM_DID = "did";
    public static final String URL_PARAM_FONTSIZE_ENABLE = "enable";
    public static final String URL_PARAM_INVITE_PARENT_BID = "bid";
    public static final String URL_PARAM_MOUDLE = "module";
    public static final String URL_PARAM_NUMIID = "numIId";
    public static final String URL_PARAM_ORDER_ID = "orderid";
    public static final String URL_PARAM_RECIPEID = "recipeid";
    public static final String URL_PARAM_SECID = "secid";
    public static final String URL_PARAM_SECRET = "secret";
    public static final String URL_PARAM_SETID = "setid";
    public static final String URL_PARAM_SHARE_CBFUN = "cbfun";
    public static final String URL_PARAM_SHARE_EXTINFO = "extInfo";
    public static final String URL_PARAM_SHARE_IMGURL = "imgurl";
    public static final String URL_PARAM_SHARE_MODUEL = "module";
    public static final String URL_PARAM_SHARE_SCENE = "scene";
    public static final String URL_PARAM_SHARE_SUMMARY = "summary";
    public static final String URL_PARAM_SHARE_TEXTCONTENT = "textcontent";
    public static final String URL_PARAM_SHARE_TITLE = "title";
    public static final String URL_PARAM_SHARE_TYPE = "type";
    public static final String URL_PARAM_SHARE_WEBURL = "weburl";
    public static final String URL_PARAM_SUB_MOUDLE = "sub_module";
    public static final String URL_PARAM_TID = "tid";
    public static final String URL_PARAM_TRACKID = "trackid";
    public static final String URL_PARAM_URL = "url";
    public static final String URL_PROTOCOL = "qbb6url";
    public final String mMode;
    public final Map<String, String> mParams;
    public final String mProtocol;

    private BTUrl(String paramString1, String paramString2, Map<String, String> paramMap) {
        this.mProtocol = paramString1;
        this.mMode = paramString2;
        this.mParams = paramMap;
    }

    private void downloadApp(Context paramContext, String paramString1, String paramString2) {
        String str = Utils.getRedirectUrl(paramString1);
        if (TextUtils.isEmpty(str)) {
        }
        for (; ; ) {
            return;
            if (Build.VERSION.SDK_INT <= 8) {
                paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                paramString1 = paramString2;
                if (TextUtils.isEmpty(paramString2)) {
                    paramString1 = paramContext.getResources().getString(2131427328);
                }
                if (Utils.downloadFile(paramContext, str, paramString1) < 0L) {
                    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            }
        }
    }

    private void openBrowse(Context paramContext, String paramString) {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        Utils.sendGestureBroadcast(paramContext, false);
        Utils.sendAdScreenBroadcast(paramContext, true);
    }

    private void openFeedback(Context paramContext) {
        paramContext.startActivity(new Intent(paramContext, FeedbackActivity.class));
    }

    public static BTUrl parser(String paramString) {
        BTUrl localBTUrl = null;
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return localBTUrl;
            if (paramString.startsWith("qbb6url")) {
                String str2 = paramString.substring("qbb6url".length() + 3);
                String str1 = parserMode(str2);
                localBTUrl = null;
                paramString = localBTUrl;
                if (str2.contains("?")) {
                    str2 = str2.substring(str1.length() + 1);
                    paramString = localBTUrl;
                    if (!TextUtils.isEmpty(str2)) {
                        paramString = parserParams(str2);
                    }
                }
                localBTUrl = new BTUrl("qbb6url", str1, paramString);
            }
        }
    }

    private static String parserMode(String paramString) {
        int i = paramString.length();
        int j = paramString.indexOf('?');
        if (-1 != j) {
            i = j;
        }
        return paramString.substring(0, i);
    }

    private static Map<String, String> parserParams(String paramString) {
        String[] arrayOfString = paramString.split("&");
        if (arrayOfString == null) {
            paramString = null;
            return paramString;
        }
        HashMap localHashMap = new HashMap(arrayOfString.length);
        int j = arrayOfString.length;
        int i = 0;
        for (; ; ) {
            paramString = localHashMap;
            if (i >= j) {
                break;
            }
            paramString = arrayOfString[i];
            int k = paramString.indexOf("=");
            String str2 = paramString.substring(0, k);
            String str1 = paramString.substring(k + 1);
            if ((!str2.equals("url")) && (!str2.equals("imgurl")) && (!str2.equals("weburl")) && (!str2.equals("title")) && (!str2.equals("summary")) && (!str2.equals("extInfo")) && (!str2.equals("textcontent")) && (!str2.equals("enable"))) {
                paramString = str1;
                if (!str2.equals("bid")) {
                    break label176;
                }
            }
            try {
                paramString = URLDecoder.decode(str1, "utf-8");
                label176:
                localHashMap.put(str2.trim(), paramString.trim());
                i++;
            } catch (UnsupportedEncodingException paramString) {
                for (; ; ) {
                    paramString.printStackTrace();
                    paramString = str1;
                }
            }
        }
    }

    public boolean isAppStore() {
        return "appstore".equals(this.mMode);
    }

    public boolean isCloseWeb() {
        return "closeweb".equals(this.mMode);
    }

    public boolean isInitFontSize() {
        return "initFontResize".equals(this.mMode);
    }

    public boolean isInitShare() {
        return "initShare".equals(this.mMode);
    }

    public boolean isIntentWithNoResult() {
        boolean bool = true;
        if ("browse".equals(this.mMode)) {
        }
        for (; ; ) {
            return bool;
            if (!"appstore".equals(this.mMode)) {
                if ("module".equals(this.mMode)) {
                    bool = TextUtils.isEmpty((String) this.mParams.get("cbfun"));
                } else {
                    bool = false;
                }
            }
        }
    }

    public boolean isShare() {
        return "share".equals(this.mMode);
    }

    public boolean isWebView() {
        return "webview".equals(this.mMode);
    }

    public void startIntent(Context paramContext, String paramString) {
        if ((!isIntentWithNoResult()) || (paramContext == null)) {
        }
        for (; ; ) {
            return;
            paramString = this.mMode;
            if ("browse".equals(paramString)) {
                openBrowse(paramContext, (String) this.mParams.get("url"));
            } else if ("appstore".equals(paramString)) {
                downloadApp(paramContext, (String) this.mParams.get("url"), (String) this.mParams.get("title"));
            } else if (("module".equals(paramString)) && ("feedback".equals((String) this.mParams.get("module")))) {
                openFeedback(paramContext);
            }
        }
    }
}

