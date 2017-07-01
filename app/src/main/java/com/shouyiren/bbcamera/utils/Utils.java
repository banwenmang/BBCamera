package com.shouyiren.bbcamera.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;

import com.btime.webser.device.api.DeviceInfo;
import com.dw.bcamera.CommonUI;
import com.dw.bcamera.engine.BTEngine;
import com.dw.bcamera.engine.Config;
import com.dw.bcamera.engine.OutOfMemoryException;
import com.dw.bcamera.engine.UpdateVersionItem;
import com.dw.bcamera.template.StickerData;
import com.dw.bcamera.template.ThemeDataNew;
import com.dw.common.GsonUtil;
import com.google.myjson.Gson;
import com.google.myjson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:25
 * email:727933147@qq.com
 */

public class Utils {
    public static final int ACTIVYTY_JPG_QUALITY = 85;
    public static final int AVATAR_JPG_QUALITY = 85;
    public static final String BABYINFO_GENDER_FEMALE = "f";
    public static final String BABYINFO_GENDER_MALE = "m";
    public static final String BABYINFO_GENDER_WEIZHI = "n";
    public static final String BCAMERA_PACKAGE_NAME = "com.dw.videoclipper";
    public static final int CHANNEL_BAOPAI_360 = 11012;
    public static final int CHANNEL_BAOPAI_HUAWEI = 11017;
    public static final int CHANNEL_BAOPAI_OFFICIAL = 11000;
    public static final int CHANNEL_BAOPAI_PP = 11002;
    public static final int CHANNEL_BAOPAI_XIAOMI = 11001;
    public static final String CMD_INVALID_TOKEN = "cmd_invalid_token";
    public static final int COVER_JPG_QUALITY = 85;
    public static final boolean DEBUG = false;
    public static final String DOWNLOADS_PATH = "content://downloads/download";
    public static final String[] DO_NOY_PLAY_VIDEO_DEVICES;
    public static final int DUE_DATE_DAY = 280;
    public static final int DUE_DATE_WEEK = 40;
    public static final String FEEDBACK_SEPARATOR = "%";
    public static final int GUIDE_PAGE_VERSION = 2;
    public static final long INVALID_ID = 0L;
    public static final int INVALID_REQUEST_ID = 0;
    public static final String KEY_REQUEST_ID = "requestId";
    public static final float LARGE_FONT_SCALE = 1.15F;
    public static int LOG_LEVEL = 4351;
    public static final long MAX_IMAGE_SIZE = 3000000L;
    public static final int MAX_IMAGE_WIDTH = 4000;
    public static final int MAX_VIDEO_BITRATE = 1280000;
    public static final int MAX_VIDEO_BITRATE_SOFT = 3000000;
    public static final int MAX_VIDEO_DURATION = 60000;
    public static final int MAX_VIDEO_HEIGHT = 480;
    public static final int MAX_VIDEO_WIDTH = 640;
    public static final long ONE_MONTH = 2592000000L;
    public static final boolean OPEN_LOG_UTILS = false;
    public static final long READ_SMS_TIME = 30000L;
    public static final String TAG = "btime";
    public static final String TEST_VIDEO_PATH;
    public static final long UPDATE_VERSION = 86400000L;
    public static final long UPDATE_VISITE_NUM_TIME = 43200000L;
    public static final String VIDEO_CLIPPER_DOWNLOAD_URL = "http://www.qbb6.com/apk/qbb6-video-editor.apk";
    public static final String VIDEO_CLIPPER_PACKAGENAME = "com.dw.videoclipper";
    public static final long VISITE_NUM_TIME = 1800000L;
    private static float hRadius;
    private static int iterations = 3;
    private static Date mDate;
    private static Object sLock;
    private static float vRadius;

    static {
        DO_NOY_PLAY_VIDEO_DEVICES = new String[]{"L50t", "C6902", "LT29i", "C6603", "GT-I8552", "vivo Y13L", "GT-S7572", "SCH-I739", "L36h", "SM-G3502C", "GT-S7508", "SCH-I699I", "L35h", "GT-I8262D", "SM-G3509I", "SCH-I829", "SM-G3139D", "M35h", "HUAWEI G750-T01", "SCH-I869", "XM50t", "SCH-I679", "C6802", "SM-G3502I", "1107", "S7562"};
        TEST_VIDEO_PATH = Config.CAMERA_DIR + File.separator + "test.mp4";
        sLock = new Object();
        mDate = null;
        hRadius = 2.0F;
        vRadius = 2.0F;
    }

    public static Bitmap BoxBlurFilter(Bitmap paramBitmap)
            throws OutOfMemoryException {
        int j = paramBitmap.getWidth();
        int k = paramBitmap.getHeight();
        int[] arrayOfInt2 = new int[j * k];
        int[] arrayOfInt1 = new int[j * k];
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        paramBitmap.getPixels(arrayOfInt2, 0, j, 0, 0, j, k);
        for (int i = 0; ; i++) {
            if (i >= iterations) {
                blurFractional(arrayOfInt2, arrayOfInt1, j, k, hRadius);
                blurFractional(arrayOfInt1, arrayOfInt2, k, j, vRadius);
                localBitmap.setPixels(arrayOfInt2, 0, j, 0, 0, j, k);
                return localBitmap;
            }
            blur(arrayOfInt2, arrayOfInt1, j, k, hRadius);
            blur(arrayOfInt1, arrayOfInt2, k, j, vRadius);
        }
    }

    /* Error */
    public static String GetNetIp() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 13
        //   3: aconst_null
        //   4: astore 5
        //   6: aconst_null
        //   7: astore 8
        //   9: aconst_null
        //   10: astore 7
        //   12: aconst_null
        //   13: astore 18
        //   15: aconst_null
        //   16: astore 14
        //   18: aconst_null
        //   19: astore 15
        //   21: aconst_null
        //   22: astore 16
        //   24: aconst_null
        //   25: astore 12
        //   27: ldc_w 293
        //   30: astore 11
        //   32: aconst_null
        //   33: astore_2
        //   34: aconst_null
        //   35: astore_3
        //   36: aconst_null
        //   37: astore 4
        //   39: aconst_null
        //   40: astore 19
        //   42: aconst_null
        //   43: astore 10
        //   45: aconst_null
        //   46: astore 6
        //   48: aconst_null
        //   49: astore 9
        //   51: aconst_null
        //   52: astore 17
        //   54: aload 19
        //   56: astore_0
        //   57: aload 18
        //   59: astore_1
        //   60: new 295	java/net/URL
        //   63: astore 20
        //   65: aload 19
        //   67: astore_0
        //   68: aload 18
        //   70: astore_1
        //   71: aload 20
        //   73: ldc_w 297
        //   76: invokespecial 298	java/net/URL:<init>	(Ljava/lang/String;)V
        //   79: aload 17
        //   81: astore_2
        //   82: aload 13
        //   84: astore 5
        //   86: aload 10
        //   88: astore 7
        //   90: aload 14
        //   92: astore 4
        //   94: aload 15
        //   96: astore_3
        //   97: aload 16
        //   99: astore 8
        //   101: aload 20
        //   103: invokevirtual 302	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   106: checkcast 304	java/net/HttpURLConnection
        //   109: astore_1
        //   110: aload 11
        //   112: astore 10
        //   114: aload_1
        //   115: astore_2
        //   116: aload 13
        //   118: astore 5
        //   120: aload_1
        //   121: astore 7
        //   123: aload 14
        //   125: astore 4
        //   127: aload_1
        //   128: astore 6
        //   130: aload 15
        //   132: astore_3
        //   133: aload_1
        //   134: astore 9
        //   136: aload 16
        //   138: astore 8
        //   140: aload_1
        //   141: invokevirtual 307	java/net/HttpURLConnection:getResponseCode	()I
        //   144: sipush 200
        //   147: if_icmpne +343 -> 490
        //   150: aload_1
        //   151: astore_2
        //   152: aload 13
        //   154: astore 5
        //   156: aload_1
        //   157: astore 7
        //   159: aload 14
        //   161: astore 4
        //   163: aload_1
        //   164: astore 6
        //   166: aload 15
        //   168: astore_3
        //   169: aload_1
        //   170: astore 9
        //   172: aload 16
        //   174: astore 8
        //   176: aload_1
        //   177: invokevirtual 311	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   180: astore_0
        //   181: aload_1
        //   182: astore_2
        //   183: aload_0
        //   184: astore 5
        //   186: aload_1
        //   187: astore 7
        //   189: aload_0
        //   190: astore 4
        //   192: aload_1
        //   193: astore 6
        //   195: aload_0
        //   196: astore_3
        //   197: aload_1
        //   198: astore 9
        //   200: aload_0
        //   201: astore 8
        //   203: new 313	java/io/BufferedReader
        //   206: astore 10
        //   208: aload_1
        //   209: astore_2
        //   210: aload_0
        //   211: astore 5
        //   213: aload_1
        //   214: astore 7
        //   216: aload_0
        //   217: astore 4
        //   219: aload_1
        //   220: astore 6
        //   222: aload_0
        //   223: astore_3
        //   224: aload_1
        //   225: astore 9
        //   227: aload_0
        //   228: astore 8
        //   230: new 315	java/io/InputStreamReader
        //   233: astore 12
        //   235: aload_1
        //   236: astore_2
        //   237: aload_0
        //   238: astore 5
        //   240: aload_1
        //   241: astore 7
        //   243: aload_0
        //   244: astore 4
        //   246: aload_1
        //   247: astore 6
        //   249: aload_0
        //   250: astore_3
        //   251: aload_1
        //   252: astore 9
        //   254: aload_0
        //   255: astore 8
        //   257: aload 12
        //   259: aload_0
        //   260: ldc_w 317
        //   263: invokespecial 320	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   266: aload_1
        //   267: astore_2
        //   268: aload_0
        //   269: astore 5
        //   271: aload_1
        //   272: astore 7
        //   274: aload_0
        //   275: astore 4
        //   277: aload_1
        //   278: astore 6
        //   280: aload_0
        //   281: astore_3
        //   282: aload_1
        //   283: astore 9
        //   285: aload_0
        //   286: astore 8
        //   288: aload 10
        //   290: aload 12
        //   292: invokespecial 323	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   295: aload_1
        //   296: astore_2
        //   297: aload_0
        //   298: astore 5
        //   300: aload_1
        //   301: astore 7
        //   303: aload_0
        //   304: astore 4
        //   306: aload_1
        //   307: astore 6
        //   309: aload_0
        //   310: astore_3
        //   311: aload_1
        //   312: astore 9
        //   314: aload_0
        //   315: astore 8
        //   317: new 203	java/lang/StringBuilder
        //   320: astore 14
        //   322: aload_1
        //   323: astore_2
        //   324: aload_0
        //   325: astore 5
        //   327: aload_1
        //   328: astore 7
        //   330: aload_0
        //   331: astore 4
        //   333: aload_1
        //   334: astore 6
        //   336: aload_0
        //   337: astore_3
        //   338: aload_1
        //   339: astore 9
        //   341: aload_0
        //   342: astore 8
        //   344: aload 14
        //   346: invokespecial 324	java/lang/StringBuilder:<init>	()V
        //   349: aload_1
        //   350: astore_2
        //   351: aload_0
        //   352: astore 5
        //   354: aload_1
        //   355: astore 7
        //   357: aload_0
        //   358: astore 4
        //   360: aload_1
        //   361: astore 6
        //   363: aload_0
        //   364: astore_3
        //   365: aload_1
        //   366: astore 9
        //   368: aload_0
        //   369: astore 8
        //   371: aload 10
        //   373: invokevirtual 327	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   376: astore 13
        //   378: aload 13
        //   380: ifnonnull +122 -> 502
        //   383: aload_1
        //   384: astore_2
        //   385: aload_0
        //   386: astore 5
        //   388: aload_1
        //   389: astore 7
        //   391: aload_0
        //   392: astore 4
        //   394: aload_1
        //   395: astore 6
        //   397: aload_0
        //   398: astore_3
        //   399: aload_1
        //   400: astore 9
        //   402: aload_0
        //   403: astore 8
        //   405: ldc_w 329
        //   408: invokestatic 335	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
        //   411: aload 14
        //   413: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   416: invokevirtual 339	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   419: astore 13
        //   421: aload_0
        //   422: astore 12
        //   424: aload 11
        //   426: astore 10
        //   428: aload_1
        //   429: astore_2
        //   430: aload_0
        //   431: astore 5
        //   433: aload_1
        //   434: astore 7
        //   436: aload_0
        //   437: astore 4
        //   439: aload_1
        //   440: astore 6
        //   442: aload_0
        //   443: astore_3
        //   444: aload_1
        //   445: astore 9
        //   447: aload_0
        //   448: astore 8
        //   450: aload 13
        //   452: invokevirtual 345	java/util/regex/Matcher:find	()Z
        //   455: ifeq +35 -> 490
        //   458: aload_1
        //   459: astore_2
        //   460: aload_0
        //   461: astore 5
        //   463: aload_1
        //   464: astore 7
        //   466: aload_0
        //   467: astore 4
        //   469: aload_1
        //   470: astore 6
        //   472: aload_0
        //   473: astore_3
        //   474: aload_1
        //   475: astore 9
        //   477: aload_0
        //   478: astore 8
        //   480: aload 13
        //   482: invokevirtual 348	java/util/regex/Matcher:group	()Ljava/lang/String;
        //   485: astore 10
        //   487: aload_0
        //   488: astore 12
        //   490: aload 12
        //   492: invokevirtual 353	java/io/InputStream:close	()V
        //   495: aload_1
        //   496: invokevirtual 356	java/net/HttpURLConnection:disconnect	()V
        //   499: aload 10
        //   501: areturn
        //   502: aload_1
        //   503: astore_2
        //   504: aload_0
        //   505: astore 5
        //   507: aload_1
        //   508: astore 7
        //   510: aload_0
        //   511: astore 4
        //   513: aload_1
        //   514: astore 6
        //   516: aload_0
        //   517: astore_3
        //   518: aload_1
        //   519: astore 9
        //   521: aload_0
        //   522: astore 8
        //   524: new 203	java/lang/StringBuilder
        //   527: astore 12
        //   529: aload_1
        //   530: astore_2
        //   531: aload_0
        //   532: astore 5
        //   534: aload_1
        //   535: astore 7
        //   537: aload_0
        //   538: astore 4
        //   540: aload_1
        //   541: astore 6
        //   543: aload_0
        //   544: astore_3
        //   545: aload_1
        //   546: astore 9
        //   548: aload_0
        //   549: astore 8
        //   551: aload 12
        //   553: aload 13
        //   555: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   558: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   561: aload_1
        //   562: astore_2
        //   563: aload_0
        //   564: astore 5
        //   566: aload_1
        //   567: astore 7
        //   569: aload_0
        //   570: astore 4
        //   572: aload_1
        //   573: astore 6
        //   575: aload_0
        //   576: astore_3
        //   577: aload_1
        //   578: astore 9
        //   580: aload_0
        //   581: astore 8
        //   583: aload 14
        //   585: aload 12
        //   587: ldc_w 358
        //   590: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   593: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   596: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   599: pop
        //   600: goto -251 -> 349
        //   603: astore_3
        //   604: aload_2
        //   605: astore_0
        //   606: aload 5
        //   608: astore_1
        //   609: aload_3
        //   610: invokevirtual 361	java/net/MalformedURLException:printStackTrace	()V
        //   613: aload 5
        //   615: invokevirtual 353	java/io/InputStream:close	()V
        //   618: aload_2
        //   619: invokevirtual 356	java/net/HttpURLConnection:disconnect	()V
        //   622: aload 11
        //   624: astore 10
        //   626: goto -127 -> 499
        //   629: astore_0
        //   630: aload_0
        //   631: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   634: aload 11
        //   636: astore 10
        //   638: goto -139 -> 499
        //   641: astore_2
        //   642: aload_3
        //   643: astore 9
        //   645: aload 9
        //   647: astore_0
        //   648: aload 8
        //   650: astore_1
        //   651: aload_2
        //   652: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   655: aload 8
        //   657: invokevirtual 353	java/io/InputStream:close	()V
        //   660: aload 9
        //   662: invokevirtual 356	java/net/HttpURLConnection:disconnect	()V
        //   665: aload 11
        //   667: astore 10
        //   669: goto -170 -> 499
        //   672: astore_0
        //   673: aload_0
        //   674: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   677: aload 11
        //   679: astore 10
        //   681: goto -182 -> 499
        //   684: astore_2
        //   685: aload 7
        //   687: astore_3
        //   688: aload 4
        //   690: astore 6
        //   692: aload 6
        //   694: astore_0
        //   695: aload_3
        //   696: astore_1
        //   697: aload_2
        //   698: invokevirtual 363	java/lang/Exception:printStackTrace	()V
        //   701: aload_3
        //   702: invokevirtual 353	java/io/InputStream:close	()V
        //   705: aload 6
        //   707: invokevirtual 356	java/net/HttpURLConnection:disconnect	()V
        //   710: aload 11
        //   712: astore 10
        //   714: goto -215 -> 499
        //   717: astore_0
        //   718: aload_0
        //   719: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   722: aload 11
        //   724: astore 10
        //   726: goto -227 -> 499
        //   729: astore_2
        //   730: aload_1
        //   731: invokevirtual 353	java/io/InputStream:close	()V
        //   734: aload_0
        //   735: invokevirtual 356	java/net/HttpURLConnection:disconnect	()V
        //   738: aload_2
        //   739: athrow
        //   740: astore_0
        //   741: aload_0
        //   742: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   745: goto -7 -> 738
        //   748: astore_0
        //   749: aload_0
        //   750: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   753: goto -254 -> 499
        //   756: astore_2
        //   757: aload 7
        //   759: astore_0
        //   760: aload 4
        //   762: astore_1
        //   763: goto -33 -> 730
        //   766: astore_2
        //   767: goto -75 -> 692
        //   770: astore_2
        //   771: goto -126 -> 645
        //   774: astore_3
        //   775: goto -171 -> 604
        // Local variable table:
        //   start	length	slot	name	signature
        //   56	550	0	localObject1	Object
        //   629	2	0	localIOException1	IOException
        //   647	1	0	localObject2	Object
        //   672	2	0	localIOException2	IOException
        //   694	1	0	localObject3	Object
        //   717	18	0	localIOException3	IOException
        //   740	2	0	localIOException4	IOException
        //   748	2	0	localIOException5	IOException
        //   759	1	0	localObject4	Object
        //   59	704	1	localObject5	Object
        //   33	586	2	localObject6	Object
        //   641	11	2	localIOException6	IOException
        //   684	14	2	localException1	Exception
        //   729	10	2	localObject7	Object
        //   756	1	2	localObject8	Object
        //   766	1	2	localException2	Exception
        //   770	1	2	localIOException7	IOException
        //   35	542	3	localObject9	Object
        //   603	40	3	localMalformedURLException1	MalformedURLException
        //   687	15	3	localObject10	Object
        //   774	1	3	localMalformedURLException2	MalformedURLException
        //   37	724	4	localObject11	Object
        //   4	610	5	localObject12	Object
        //   46	660	6	localObject13	Object
        //   10	748	7	localObject14	Object
        //   7	649	8	localObject15	Object
        //   49	612	9	localObject16	Object
        //   43	682	10	localObject17	Object
        //   30	693	11	str	String
        //   25	561	12	localObject18	Object
        //   1	553	13	localObject19	Object
        //   16	568	14	localStringBuilder	StringBuilder
        //   19	148	15	localObject20	Object
        //   22	151	16	localObject21	Object
        //   52	28	17	localObject22	Object
        //   13	56	18	localObject23	Object
        //   40	26	19	localObject24	Object
        //   63	39	20	localURL	URL
        // Exception table:
        //   from	to	target	type
        //   101	110	603	java/net/MalformedURLException
        //   140	150	603	java/net/MalformedURLException
        //   176	181	603	java/net/MalformedURLException
        //   203	208	603	java/net/MalformedURLException
        //   230	235	603	java/net/MalformedURLException
        //   257	266	603	java/net/MalformedURLException
        //   288	295	603	java/net/MalformedURLException
        //   317	322	603	java/net/MalformedURLException
        //   344	349	603	java/net/MalformedURLException
        //   371	378	603	java/net/MalformedURLException
        //   405	421	603	java/net/MalformedURLException
        //   450	458	603	java/net/MalformedURLException
        //   480	487	603	java/net/MalformedURLException
        //   524	529	603	java/net/MalformedURLException
        //   551	561	603	java/net/MalformedURLException
        //   583	600	603	java/net/MalformedURLException
        //   613	622	629	java/io/IOException
        //   60	65	641	java/io/IOException
        //   71	79	641	java/io/IOException
        //   655	665	672	java/io/IOException
        //   60	65	684	java/lang/Exception
        //   71	79	684	java/lang/Exception
        //   701	710	717	java/io/IOException
        //   60	65	729	finally
        //   71	79	729	finally
        //   609	613	729	finally
        //   651	655	729	finally
        //   697	701	729	finally
        //   730	738	740	java/io/IOException
        //   490	499	748	java/io/IOException
        //   101	110	756	finally
        //   140	150	756	finally
        //   176	181	756	finally
        //   203	208	756	finally
        //   230	235	756	finally
        //   257	266	756	finally
        //   288	295	756	finally
        //   317	322	756	finally
        //   344	349	756	finally
        //   371	378	756	finally
        //   405	421	756	finally
        //   450	458	756	finally
        //   480	487	756	finally
        //   524	529	756	finally
        //   551	561	756	finally
        //   583	600	756	finally
        //   101	110	766	java/lang/Exception
        //   140	150	766	java/lang/Exception
        //   176	181	766	java/lang/Exception
        //   203	208	766	java/lang/Exception
        //   230	235	766	java/lang/Exception
        //   257	266	766	java/lang/Exception
        //   288	295	766	java/lang/Exception
        //   317	322	766	java/lang/Exception
        //   344	349	766	java/lang/Exception
        //   371	378	766	java/lang/Exception
        //   405	421	766	java/lang/Exception
        //   450	458	766	java/lang/Exception
        //   480	487	766	java/lang/Exception
        //   524	529	766	java/lang/Exception
        //   551	561	766	java/lang/Exception
        //   583	600	766	java/lang/Exception
        //   101	110	770	java/io/IOException
        //   140	150	770	java/io/IOException
        //   176	181	770	java/io/IOException
        //   203	208	770	java/io/IOException
        //   230	235	770	java/io/IOException
        //   257	266	770	java/io/IOException
        //   288	295	770	java/io/IOException
        //   317	322	770	java/io/IOException
        //   344	349	770	java/io/IOException
        //   371	378	770	java/io/IOException
        //   405	421	770	java/io/IOException
        //   450	458	770	java/io/IOException
        //   480	487	770	java/io/IOException
        //   524	529	770	java/io/IOException
        //   551	561	770	java/io/IOException
        //   583	600	770	java/io/IOException
        //   60	65	774	java/net/MalformedURLException
        //   71	79	774	java/net/MalformedURLException
    }

    private static boolean URLContainParameter(String paramString) {
        boolean bool = false;
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return bool;
            if (paramString.contains("?")) {
                bool = true;
            }
        }
    }

    public static void blur(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat) {
        int i6 = paramInt1 - 1;
        int i8 = (int) paramFloat;
        int j = i8 * 2 + 1;
        int[] arrayOfInt = new int[j * 256];
        int i1;
        for (int i = 0; ; i++) {
            if (i >= j * 256) {
                i1 = 0;
                i = 0;
                if (i < paramInt2) {
                    break;
                }
                return;
            }
            arrayOfInt[i] = (i / j);
        }
        int i3 = i;
        int k = 0;
        int n = 0;
        int m = 0;
        j = 0;
        int i2 = -i8;
        label92:
        if (i2 > i8) {
        }
        for (i2 = 0; ; i2++) {
            if (i2 >= paramInt1) {
                i1 += paramInt1;
                i++;
                break;
                i4 = paramArrayOfInt1[(clamp(i2, 0, paramInt1 - 1) + i1)];
                k += (i4 >> 24 & 0xFF);
                n += (i4 >> 16 & 0xFF);
                m += (i4 >> 8 & 0xFF);
                j += (i4 & 0xFF);
                i2++;
                break label92;
            }
            paramArrayOfInt2[i3] = (arrayOfInt[k] << 24 | arrayOfInt[n] << 16 | arrayOfInt[m] << 8 | arrayOfInt[j]);
            int i5 = i2 + i8 + 1;
            int i4 = i5;
            if (i5 > i6) {
                i4 = i6;
            }
            int i7 = i2 - i8;
            i5 = i7;
            if (i7 < 0) {
                i5 = 0;
            }
            i4 = paramArrayOfInt1[(i1 + i4)];
            i5 = paramArrayOfInt1[(i1 + i5)];
            k += (i4 >> 24 & 0xFF) - (i5 >> 24 & 0xFF);
            n += ((0xFF0000 & i4) - (0xFF0000 & i5) >> 16);
            m += ((0xFF00 & i4) - (0xFF00 & i5) >> 8);
            j += (i4 & 0xFF) - (i5 & 0xFF);
            i3 += paramInt2;
        }
    }

    public static void blurFractional(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat) {
        float f = paramFloat - (int) paramFloat;
        paramFloat = 1.0F / (1.0F + 2.0F * f);
        int j = 0;
        int i = 0;
        if (i >= paramInt2) {
            return;
        }
        paramArrayOfInt2[i] = paramArrayOfInt1[0];
        int m = i + paramInt2;
        for (int k = 1; ; k++) {
            if (k >= paramInt1 - 1) {
                paramArrayOfInt2[m] = paramArrayOfInt1[(paramInt1 - 1)];
                j += paramInt1;
                i++;
                break;
            }
            int i2 = j + k;
            int i1 = paramArrayOfInt1[(i2 - 1)];
            int n = paramArrayOfInt1[i2];
            int i5 = paramArrayOfInt1[(i2 + 1)];
            int i4 = (int) (((i1 >> 24 & 0xFF) + (i5 >> 24 & 0xFF)) * f);
            i2 = (int) (((i1 >> 16 & 0xFF) + (i5 >> 16 & 0xFF)) * f);
            int i3 = (int) (((i1 >> 8 & 0xFF) + (i5 >> 8 & 0xFF)) * f);
            i1 = (int) (((i1 & 0xFF) + (i5 & 0xFF)) * f);
            paramArrayOfInt2[m] = ((int) (((n >> 24 & 0xFF) + i4) * paramFloat) << 24 | (int) (((n >> 16 & 0xFF) + i2) * paramFloat) << 16 | (int) (((n >> 8 & 0xFF) + i3) * paramFloat) << 8 | (int) (((n & 0xFF) + i1) * paramFloat));
            m += paramInt2;
        }
    }

    public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        Object localObject;
        if (paramBitmap == null) {
            localObject = null;
            return (byte[]) localObject;
        }
        int i = 85;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        if (paramBoolean2) {
            label34:
            localObject = arrayOfByte;
            if (arrayOfByte != null) {
                if ((arrayOfByte.length <= 0) || (arrayOfByte.length > 32768)) {
                    break label86;
                }
                localObject = arrayOfByte;
            }
        }
        for (; ; ) {
            if (paramBoolean1) {
            }
            try {
                paramBitmap.recycle();
                localByteArrayOutputStream.close();
            } catch (Exception paramBitmap) {
                paramBitmap.printStackTrace();
            }
            break;
            label86:
            localByteArrayOutputStream.reset();
            paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
            arrayOfByte = localByteArrayOutputStream.toByteArray();
            i = (int) (i * 0.8F);
            break label34;
            if (paramBoolean3) {
                for (; ; ) {
                    localObject = arrayOfByte;
                    if (arrayOfByte == null) {
                        break;
                    }
                    if (arrayOfByte.length > 0) {
                        localObject = arrayOfByte;
                        if (arrayOfByte.length <= 5242780) {
                            break;
                        }
                    }
                    localByteArrayOutputStream.reset();
                    paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
                    arrayOfByte = localByteArrayOutputStream.toByteArray();
                    i = (int) (i * 0.8F);
                }
            }
            paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
            localObject = localByteArrayOutputStream.toByteArray();
        }
    }

    public static int calculateDay(Date paramDate1, Date paramDate2) {
        int j = 0;
        int i = j;
        if (paramDate1 != null) {
            if (paramDate2 != null) {
                break label16;
            }
            i = j;
        }
        for (; ; ) {
            return i;
            label16:
            Calendar localCalendar2 = Calendar.getInstance();
            Calendar localCalendar1 = Calendar.getInstance();
            localCalendar2.setTime(paramDate1);
            localCalendar1.setTime(paramDate2);
            localCalendar2.set(11, 0);
            localCalendar2.set(12, 0);
            localCalendar2.set(13, 0);
            localCalendar2.set(14, 0);
            localCalendar1.set(11, 0);
            localCalendar1.set(12, 0);
            localCalendar1.set(13, 0);
            localCalendar1.set(14, 0);
            j = (int) ((localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L);
            i = j;
            if (j >= 0) {
                i = j + 1;
            }
        }
    }

    private static ArrayList<Integer> calendarInterval(Calendar paramCalendar1, Calendar paramCalendar2) {
        if ((paramCalendar1 == null) || (paramCalendar2 == null)) {
            paramCalendar1 = null;
            return paramCalendar1;
        }
        long l1 = paramCalendar1.getTimeInMillis();
        long l2 = paramCalendar2.getTimeInMillis();
        int n = paramCalendar1.get(5) - paramCalendar2.get(5);
        int m = paramCalendar1.get(2) - paramCalendar2.get(2);
        int i = paramCalendar1.get(1) - paramCalendar2.get(1);
        if (Long.valueOf(l1).longValue() <= Long.valueOf(l2).longValue()) {
            n = 0;
            m = 0;
            i = 0;
        }
        int j = n;
        int k = m;
        if (n < 0) {
            k = m - 1;
            paramCalendar1.add(2, -1);
            if (paramCalendar1.getActualMaximum(5) <= paramCalendar2.get(5)) {
                break label212;
            }
        }
        label212:
        for (j = paramCalendar1.getActualMaximum(5) - paramCalendar2.get(5) + paramCalendar1.get(5); ; j = paramCalendar1.get(5)) {
            n = k;
            m = i;
            if (k < 0) {
                n = (k + 12) % 12;
                m = i - 1;
            }
            paramCalendar1 = new ArrayList();
            paramCalendar1.add(Integer.valueOf(m));
            paramCalendar1.add(Integer.valueOf(n));
            paramCalendar1.add(Integer.valueOf(j));
            break;
        }
    }

    public static void callPhone(Context paramContext, String paramString) {
        try {
            Intent localIntent = new android / content / Intent;
            localIntent.<init> ("android.intent.action.CALL");
            StringBuilder localStringBuilder = new java / lang / StringBuilder;
            localStringBuilder.<init> ("tel:+");
            localIntent.setData(Uri.parse(paramString));
            paramContext.startActivity(localIntent);
            return;
        } catch (Exception paramContext) {
            for (; ; ) {
            }
        }
    }

    public static boolean checkApkExist(Context paramContext, String paramString) {
        boolean bool;
        if (TextUtils.isEmpty(paramString)) {
            bool = false;
        }
        for (; ; ) {
            return bool;
            try {
                paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
                if (paramContext == null) {
                    bool = false;
                }
            } catch (PackageManager.NameNotFoundException paramContext) {
                for (; ; ) {
                    paramContext = null;
                    continue;
                    bool = true;
                }
            }
        }
    }

    private static boolean checkFsWritable() {
        boolean bool = false;
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File localFile = new File(str);
        if (!localFile.isDirectory()) {
        }
        for (; ; ) {
            synchronized (sLock) {
                if (!localFile.mkdirs()) {
                    return bool;
                }
                localFile = new File(str, ".probe");
                try {
                    synchronized (sLock) {
                        if (localFile.exists()) {
                            localFile.delete();
                        }
                        if (localFile.createNewFile()) {
                        }
                    }
                } catch (IOException localIOException) {
                }
            }
            ((File) localObject3).delete();
            bool = true;
        }
    }

    public static int clamp(int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt1 < paramInt2) {
        }
        for (; ; ) {
            return paramInt2;
            if (paramInt1 > paramInt3) {
                paramInt2 = paramInt3;
            } else {
                paramInt2 = paramInt1;
            }
        }
    }

    public static void closeSilently(Closeable paramCloseable) {
        if (paramCloseable == null) {
        }
        for (; ; ) {
            return;
            try {
                paramCloseable.close();
            } catch (Throwable paramCloseable) {
            }
        }
    }

    private static int compare(String paramString1, String paramString2) {
        int[][] arrayOfInt2 = null;
        int i1 = 0;
        i = 0;
        int n = 0;
        j = 0;
        int[][] arrayOfInt1 = arrayOfInt2;
        m = n;
        k = i1;
        for (; ; ) {
            try {
                if (!TextUtils.isEmpty(paramString1)) {
                    arrayOfInt1 = arrayOfInt2;
                    m = n;
                    k = i1;
                    i = paramString1.length();
                }
                arrayOfInt1 = arrayOfInt2;
                m = n;
                k = i;
                if (!TextUtils.isEmpty(paramString2)) {
                    arrayOfInt1 = arrayOfInt2;
                    m = n;
                    k = i;
                    j = paramString2.length();
                }
                if (i == 0) {
                    i = j;
                    return i;
                }
                if (j == 0) {
                    continue;
                }
                arrayOfInt1 = arrayOfInt2;
                m = j;
                k = i;
                arrayOfInt2 = new int[i + 1][j + 1];
                k = 0;
                if (k <= i) {
                    continue;
                }
                k = 0;
                if (k <= j) {
                    continue;
                }
                n = 1;
                if (n <= i) {
                    continue;
                }
                arrayOfInt1 = arrayOfInt2;
            } catch (Exception paramString1) {
                int i3;
                int i2;
                j = m;
                i = k;
                continue;
            }
            i = arrayOfInt1[i][j];
            continue;
            arrayOfInt2[k][0] = k;
            k++;
            continue;
            arrayOfInt2[0][k] = k;
            k++;
            continue;
            arrayOfInt1 = arrayOfInt2;
            m = j;
            k = i;
            i3 = paramString1.charAt(n - 1);
            i1 = 1;
            if (i1 <= j) {
                continue;
            }
            n++;
        }
        arrayOfInt1 = arrayOfInt2;
        m = j;
        k = i;
        if (i3 == paramString2.charAt(i1 - 1)) {
        }
        for (i2 = 0; ; i2 = 1) {
            arrayOfInt1 = arrayOfInt2;
            m = j;
            k = i;
            arrayOfInt2[n][i1] = min(arrayOfInt2[(n - 1)][i1] + 1, arrayOfInt2[n][(i1 - 1)] + 1, arrayOfInt2[(n - 1)][(i1 - 1)] + i2);
            i1++;
            break;
        }
    }

    public static boolean containChinese(String paramString) {
        if (paramString.getBytes().length != paramString.length()) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    /* Error */
    public static float convertRationalLatLonToFloat(String paramString1, String paramString2) {
        // Byte code:
        //   0: aload_0
        //   1: ldc_w 567
        //   4: invokevirtual 571	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   7: astore_0
        //   8: aload_0
        //   9: iconst_0
        //   10: aaload
        //   11: ldc_w 573
        //   14: invokevirtual 571	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   17: astore 10
        //   19: aload 10
        //   21: iconst_0
        //   22: aaload
        //   23: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   26: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   29: aload 10
        //   31: iconst_1
        //   32: aaload
        //   33: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   36: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   39: ddiv
        //   40: dstore_2
        //   41: aload_0
        //   42: iconst_1
        //   43: aaload
        //   44: ldc_w 573
        //   47: invokevirtual 571	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   50: astore 10
        //   52: aload 10
        //   54: iconst_0
        //   55: aaload
        //   56: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   59: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   62: aload 10
        //   64: iconst_1
        //   65: aaload
        //   66: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   69: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   72: ddiv
        //   73: dstore 4
        //   75: aload_0
        //   76: iconst_2
        //   77: aaload
        //   78: ldc_w 573
        //   81: invokevirtual 571	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   84: astore_0
        //   85: aload_0
        //   86: iconst_0
        //   87: aaload
        //   88: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   91: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   94: aload_0
        //   95: iconst_1
        //   96: aaload
        //   97: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
        //   100: invokestatic 582	java/lang/Double:parseDouble	(Ljava/lang/String;)D
        //   103: ddiv
        //   104: dstore 6
        //   106: dload 4
        //   108: ldc2_w 583
        //   111: ddiv
        //   112: dload_2
        //   113: dadd
        //   114: dload 6
        //   116: ldc2_w 585
        //   119: ddiv
        //   120: dadd
        //   121: dstore_2
        //   122: aload_1
        //   123: ldc_w 588
        //   126: invokevirtual 591	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   129: ifne +17 -> 146
        //   132: aload_1
        //   133: ldc_w 593
        //   136: invokevirtual 591	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   139: istore 9
        //   141: iload 9
        //   143: ifeq +11 -> 154
        //   146: dload_2
        //   147: dneg
        //   148: d2f
        //   149: fstore 8
        //   151: fload 8
        //   153: freturn
        //   154: dload_2
        //   155: d2f
        //   156: fstore 8
        //   158: goto -7 -> 151
        //   161: astore_0
        //   162: new 595	java/lang/IllegalArgumentException
        //   165: dup
        //   166: invokespecial 596	java/lang/IllegalArgumentException:<init>	()V
        //   169: athrow
        //   170: astore_0
        //   171: new 595	java/lang/IllegalArgumentException
        //   174: dup
        //   175: invokespecial 596	java/lang/IllegalArgumentException:<init>	()V
        //   178: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	179	0	paramString1	String
        //   0	179	1	paramString2	String
        //   40	115	2	d1	double
        //   73	34	4	d2	double
        //   104	11	6	d3	double
        //   149	8	8	f	float
        //   139	3	9	bool	boolean
        //   17	46	10	arrayOfString	String[]
        // Exception table:
        //   from	to	target	type
        //   0	106	161	java/lang/NumberFormatException
        //   122	141	161	java/lang/NumberFormatException
        //   0	106	170	java/lang/ArrayIndexOutOfBoundsException
        //   122	141	170	java/lang/ArrayIndexOutOfBoundsException
    }

    public static void copyExif(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2) {
        if ((paramExifInterface1 == null) || (paramExifInterface2 == null)) {
        }
        for (; ; ) {
            return;
            int i = Build.VERSION.SDK_INT;
            if (i >= 11) {
                str = paramExifInterface1.getAttribute("FNumber");
                if (str != null) {
                    paramExifInterface2.setAttribute("FNumber", str);
                }
                str = paramExifInterface1.getAttribute("ExposureTime");
                if (str != null) {
                    paramExifInterface2.setAttribute("ExposureTime", str);
                }
                str = paramExifInterface1.getAttribute("ISOSpeedRatings");
                if (str != null) {
                    paramExifInterface2.setAttribute("ISOSpeedRatings", str);
                }
            }
            if (i >= 9) {
                str = paramExifInterface1.getAttribute("GPSAltitude");
                if (str != null) {
                    paramExifInterface2.setAttribute("GPSAltitude", str);
                }
                str = paramExifInterface1.getAttribute("GPSAltitudeRef");
                if (str != null) {
                    paramExifInterface2.setAttribute("GPSAltitudeRef", str);
                }
            }
            String str = paramExifInterface1.getAttribute("FocalLength");
            if (str != null) {
                paramExifInterface2.setAttribute("FocalLength", str);
            }
            str = paramExifInterface1.getAttribute("GPSDateStamp");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSDateStamp", str);
            }
            str = paramExifInterface1.getAttribute("GPSProcessingMethod");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSProcessingMethod", str);
            }
            str = paramExifInterface1.getAttribute("GPSTimeStamp");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSTimeStamp", str);
            }
            str = paramExifInterface1.getAttribute("DateTime");
            if (str != null) {
                paramExifInterface2.setAttribute("DateTime", str);
            }
            str = paramExifInterface1.getAttribute("Flash");
            if (str != null) {
                paramExifInterface2.setAttribute("Flash", str);
            }
            str = paramExifInterface1.getAttribute("GPSLatitude");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSLatitude", str);
            }
            str = paramExifInterface1.getAttribute("GPSLatitudeRef");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSLatitudeRef", str);
            }
            str = paramExifInterface1.getAttribute("GPSLongitude");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSLongitude", str);
            }
            str = paramExifInterface1.getAttribute("GPSLongitudeRef");
            if (str != null) {
                paramExifInterface2.setAttribute("GPSLongitudeRef", str);
            }
            str = paramExifInterface1.getAttribute("ImageLength");
            if (str != null) {
                paramExifInterface2.setAttribute("ImageLength", str);
            }
            str = paramExifInterface1.getAttribute("ImageWidth");
            if (str != null) {
                paramExifInterface2.setAttribute("ImageWidth", str);
            }
            str = paramExifInterface1.getAttribute("Make");
            if (str != null) {
                paramExifInterface2.setAttribute("Make", str);
            }
            str = paramExifInterface1.getAttribute("Model");
            if (str != null) {
                paramExifInterface2.setAttribute("Model", str);
            }
            str = paramExifInterface1.getAttribute("Orientation");
            if (str != null) {
                paramExifInterface2.setAttribute("Orientation", str);
            }
            paramExifInterface1 = paramExifInterface1.getAttribute("WhiteBalance");
            if (paramExifInterface1 != null) {
                paramExifInterface2.setAttribute("WhiteBalance", paramExifInterface1);
            }
        }
    }

    public static boolean copyFile(File paramFile1, File paramFile2) {
        boolean bool2 = false;
        localObject2 = null;
        localObject1 = null;
        for (; ; ) {
            try {
                localFileInputStream = new java / io / FileInputStream;
                localFileInputStream.<init> (paramFile1);
            } catch (Exception paramFile1) {
                boolean bool1;
                paramFile1 = (File) localObject2;
                paramFile2 = (File) localObject1;
                continue;
            }
            try {
                paramFile1 = new java / io / FileOutputStream;
                paramFile1.<init> (paramFile2);
                try {
                    paramFile2 = new byte[32768];
                    int i = localFileInputStream.read(paramFile2);
                    if (i <= 0) {
                        paramFile1.close();
                        localFileInputStream.close();
                        bool1 = true;
                        return bool1;
                    }
                    paramFile1.write(paramFile2, 0, i);
                    continue;
                    if (paramFile1 == null) {
                    }
                } catch (Exception paramFile2) {
                    paramFile2 = paramFile1;
                    paramFile1 = localFileInputStream;
                }
            } catch (Exception paramFile1) {
                paramFile1 = localFileInputStream;
                paramFile2 = (File) localObject1;
                continue;
            }
            try {
                paramFile1.close();
                bool1 = bool2;
                if (paramFile2 == null) {
                    continue;
                }
                try {
                    paramFile2.close();
                    bool1 = bool2;
                } catch (IOException paramFile1) {
                    bool1 = bool2;
                }
            } catch (IOException paramFile1) {
            }
        }
    }

    /* Error */
    public static boolean copyPhoto(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
            throws OutOfMemoryException {
        // Byte code:
        //   0: new 218	java/io/File
        //   3: dup
        //   4: aload_1
        //   5: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   8: invokevirtual 685	java/io/File:getParent	()Ljava/lang/String;
        //   11: astore 15
        //   13: aload 15
        //   15: ifnull +71 -> 86
        //   18: new 218	java/io/File
        //   21: dup
        //   22: aload 15
        //   24: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   27: astore 15
        //   29: aload 15
        //   31: invokevirtual 528	java/io/File:exists	()Z
        //   34: ifne +52 -> 86
        //   37: aload 15
        //   39: invokevirtual 520	java/io/File:mkdirs	()Z
        //   42: ifne +44 -> 86
        //   45: aload 15
        //   47: invokevirtual 528	java/io/File:exists	()Z
        //   50: ifne +36 -> 86
        //   53: ldc 120
        //   55: new 203	java/lang/StringBuilder
        //   58: dup
        //   59: ldc_w 687
        //   62: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   65: aload 15
        //   67: invokevirtual 690	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   70: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 695	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   79: pop
        //   80: iconst_0
        //   81: istore 13
        //   83: iload 13
        //   85: ireturn
        //   86: aload_0
        //   87: invokestatic 698	com/dw/bcamera/util/Utils:getFileType	(Ljava/lang/String;)Ljava/lang/String;
        //   90: astore 15
        //   92: aload 15
        //   94: ifnull +59 -> 153
        //   97: aload 15
        //   99: ldc_w 700
        //   102: invokevirtual 703	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   105: ifeq +48 -> 153
        //   108: iconst_1
        //   109: istore 14
        //   111: iload 14
        //   113: invokestatic 707	com/dw/bcamera/util/Utils:createNativeAllocOptions	(Z)Landroid/graphics/BitmapFactory$Options;
        //   116: astore 17
        //   118: aload 17
        //   120: iconst_1
        //   121: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   124: aload_0
        //   125: aload 17
        //   127: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   130: pop
        //   131: aload 17
        //   133: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   136: ifle +11 -> 147
        //   139: aload 17
        //   141: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   144: ifgt +15 -> 159
        //   147: iconst_0
        //   148: istore 13
        //   150: goto -67 -> 83
        //   153: iconst_0
        //   154: istore 14
        //   156: goto -45 -> 111
        //   159: aconst_null
        //   160: astore 15
        //   162: new 607	android/media/ExifInterface
        //   165: astore 16
        //   167: aload 16
        //   169: aload_0
        //   170: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   173: aload 16
        //   175: astore 15
        //   177: iconst_0
        //   178: istore 11
        //   180: iconst_1
        //   181: istore 5
        //   183: aload 17
        //   185: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   188: istore 9
        //   190: aload 17
        //   192: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   195: istore 10
        //   197: iload 11
        //   199: istore 8
        //   201: iload 9
        //   203: istore 6
        //   205: iload 10
        //   207: istore 7
        //   209: aload 15
        //   211: ifnull +36 -> 247
        //   214: aload 15
        //   216: ldc_w 652
        //   219: iconst_0
        //   220: invokevirtual 729	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
        //   223: istore 12
        //   225: iload 12
        //   227: iconst_3
        //   228: if_icmpne +76 -> 304
        //   231: sipush 180
        //   234: istore 8
        //   236: iconst_1
        //   237: istore 5
        //   239: iload 10
        //   241: istore 7
        //   243: iload 9
        //   245: istore 6
        //   247: aload 17
        //   249: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   252: iload_3
        //   253: if_icmpgt +130 -> 383
        //   256: aload 17
        //   258: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   261: iload_2
        //   262: if_icmpgt +121 -> 383
        //   265: iload 8
        //   267: ifne +116 -> 383
        //   270: new 218	java/io/File
        //   273: dup
        //   274: aload_0
        //   275: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   278: new 218	java/io/File
        //   281: dup
        //   282: aload_1
        //   283: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   286: invokestatic 731	com/dw/bcamera/util/Utils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
        //   289: istore 13
        //   291: goto -208 -> 83
        //   294: astore 16
        //   296: aload 16
        //   298: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   301: goto -124 -> 177
        //   304: iload 12
        //   306: bipush 6
        //   308: if_icmpne +27 -> 335
        //   311: bipush 90
        //   313: istore 8
        //   315: aload 17
        //   317: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   320: istore 6
        //   322: aload 17
        //   324: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   327: istore 7
        //   329: iconst_1
        //   330: istore 5
        //   332: goto -85 -> 247
        //   335: iload 11
        //   337: istore 8
        //   339: iload 9
        //   341: istore 6
        //   343: iload 12
        //   345: istore 5
        //   347: iload 10
        //   349: istore 7
        //   351: iload 12
        //   353: bipush 8
        //   355: if_icmpne -108 -> 247
        //   358: sipush 270
        //   361: istore 8
        //   363: aload 17
        //   365: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   368: istore 6
        //   370: aload 17
        //   372: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   375: istore 7
        //   377: iconst_1
        //   378: istore 5
        //   380: goto -133 -> 247
        //   383: iload 7
        //   385: iload 6
        //   387: iload_2
        //   388: iload_3
        //   389: invokestatic 735	com/dw/bcamera/util/Utils:getFitInSize	(IIII)[I
        //   392: astore 15
        //   394: aload 15
        //   396: iconst_0
        //   397: iaload
        //   398: istore_2
        //   399: aload 15
        //   401: iconst_1
        //   402: iaload
        //   403: istore 9
        //   405: iload 6
        //   407: i2d
        //   408: iload 9
        //   410: i2d
        //   411: ddiv
        //   412: invokestatic 741	java/lang/Math:floor	(D)D
        //   415: d2i
        //   416: istore_3
        //   417: iload 7
        //   419: i2d
        //   420: iload_2
        //   421: i2d
        //   422: ddiv
        //   423: invokestatic 741	java/lang/Math:floor	(D)D
        //   426: d2i
        //   427: istore 10
        //   429: aload 17
        //   431: iload_3
        //   432: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   435: aload 17
        //   437: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   440: iload 10
        //   442: if_icmpge +10 -> 452
        //   445: aload 17
        //   447: iload 10
        //   449: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   452: aload 17
        //   454: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   457: iconst_1
        //   458: if_icmpge +9 -> 467
        //   461: aload 17
        //   463: iconst_1
        //   464: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   467: aload 17
        //   469: iconst_0
        //   470: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   473: aload_0
        //   474: aload 17
        //   476: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   479: astore 15
        //   481: aload 15
        //   483: ifnonnull +35 -> 518
        //   486: iconst_0
        //   487: istore 13
        //   489: goto -406 -> 83
        //   492: astore 15
        //   494: aload 15
        //   496: invokevirtual 363	java/lang/Exception:printStackTrace	()V
        //   499: aconst_null
        //   500: astore 15
        //   502: goto -21 -> 481
        //   505: astore_0
        //   506: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   509: dup
        //   510: aload_0
        //   511: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   514: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   517: athrow
        //   518: iload 8
        //   520: bipush 90
        //   522: if_icmpeq +17 -> 539
        //   525: iload_2
        //   526: istore 10
        //   528: iload 9
        //   530: istore_3
        //   531: iload 8
        //   533: sipush 270
        //   536: if_icmpne +9 -> 545
        //   539: iload_2
        //   540: istore_3
        //   541: iload 9
        //   543: istore 10
        //   545: aconst_null
        //   546: astore 17
        //   548: aload 15
        //   550: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   553: istore 9
        //   555: aload 15
        //   557: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   560: istore_2
        //   561: iload 9
        //   563: iload 10
        //   565: if_icmpgt +8 -> 573
        //   568: iload_2
        //   569: iload_3
        //   570: if_icmple +256 -> 826
        //   573: aload 15
        //   575: iload 10
        //   577: iload_3
        //   578: iconst_1
        //   579: invokestatic 752	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
        //   582: astore 16
        //   584: aload 16
        //   586: astore 17
        //   588: aload 17
        //   590: astore 16
        //   592: aload 17
        //   594: aload 15
        //   596: if_acmpeq +12 -> 608
        //   599: aload 15
        //   601: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   604: aload 17
        //   606: astore 16
        //   608: aload 16
        //   610: astore 17
        //   612: iload 8
        //   614: ifle +12 -> 626
        //   617: aload 16
        //   619: iload 8
        //   621: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   624: astore 17
        //   626: iconst_0
        //   627: istore 13
        //   629: iload 6
        //   631: istore_2
        //   632: iload 7
        //   634: istore_3
        //   635: aload 17
        //   637: ifnull +109 -> 746
        //   640: aconst_null
        //   641: astore 18
        //   643: aconst_null
        //   644: astore 19
        //   646: aload 18
        //   648: astore 15
        //   650: iload 7
        //   652: istore_3
        //   653: aload 17
        //   655: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   658: istore_2
        //   659: aload 18
        //   661: astore 15
        //   663: iload_2
        //   664: istore 6
        //   666: iload 7
        //   668: istore_3
        //   669: aload 17
        //   671: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   674: istore 7
        //   676: aload 18
        //   678: astore 15
        //   680: iload_2
        //   681: istore 6
        //   683: iload 7
        //   685: istore_3
        //   686: new 663	java/io/FileOutputStream
        //   689: astore 16
        //   691: aload 18
        //   693: astore 15
        //   695: iload_2
        //   696: istore 6
        //   698: iload 7
        //   700: istore_3
        //   701: aload 16
        //   703: aload_1
        //   704: invokespecial 757	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   707: iload 14
        //   709: ifeq +124 -> 833
        //   712: aload 17
        //   714: getstatic 760	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   717: iload 4
        //   719: aload 16
        //   721: invokevirtual 409	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   724: pop
        //   725: iconst_1
        //   726: istore 13
        //   728: aload 16
        //   730: ifnull +8 -> 738
        //   733: aload 16
        //   735: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   738: aload 17
        //   740: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   743: iload 7
        //   745: istore_3
        //   746: new 607	android/media/ExifInterface
        //   749: astore 15
        //   751: aload 15
        //   753: aload_0
        //   754: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   757: new 607	android/media/ExifInterface
        //   760: astore_0
        //   761: aload_0
        //   762: aload_1
        //   763: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   766: aload 15
        //   768: aload_0
        //   769: invokestatic 762	com/dw/bcamera/util/Utils:copyExif	(Landroid/media/ExifInterface;Landroid/media/ExifInterface;)V
        //   772: aload_0
        //   773: ldc_w 644
        //   776: iload_2
        //   777: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   780: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   783: aload_0
        //   784: ldc_w 646
        //   787: iload_3
        //   788: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   791: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   794: aload_0
        //   795: ldc_w 652
        //   798: iload 5
        //   800: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   803: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   806: aload_0
        //   807: invokevirtual 768	android/media/ExifInterface:saveAttributes	()V
        //   810: goto -727 -> 83
        //   813: astore_0
        //   814: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   817: dup
        //   818: aload_0
        //   819: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   822: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   825: athrow
        //   826: aload 15
        //   828: astore 16
        //   830: goto -222 -> 608
        //   833: aload 17
        //   835: getstatic 405	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   838: iload 4
        //   840: aload 16
        //   842: invokevirtual 409	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   845: pop
        //   846: goto -121 -> 725
        //   849: astore 18
        //   851: iload 7
        //   853: istore_3
        //   854: aload 16
        //   856: astore 15
        //   858: aload 18
        //   860: invokevirtual 769	java/io/FileNotFoundException:printStackTrace	()V
        //   863: iconst_0
        //   864: istore 13
        //   866: aload 16
        //   868: ifnull +8 -> 876
        //   871: aload 16
        //   873: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   876: aload 17
        //   878: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   881: goto -135 -> 746
        //   884: astore 15
        //   886: aload 15
        //   888: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   891: goto -15 -> 876
        //   894: astore_0
        //   895: aload 15
        //   897: ifnull +8 -> 905
        //   900: aload 15
        //   902: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   905: aload 17
        //   907: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   910: aload_0
        //   911: athrow
        //   912: astore_1
        //   913: aload_1
        //   914: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   917: goto -12 -> 905
        //   920: astore 15
        //   922: aload 15
        //   924: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   927: goto -189 -> 738
        //   930: astore_0
        //   931: aload_0
        //   932: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   935: goto -852 -> 83
        //   938: astore 16
        //   940: goto -352 -> 588
        //   943: astore 16
        //   945: goto -357 -> 588
        //   948: astore_0
        //   949: goto -18 -> 931
        //   952: astore_0
        //   953: goto -22 -> 931
        //   956: astore_0
        //   957: aload 16
        //   959: astore 15
        //   961: goto -66 -> 895
        //   964: astore 18
        //   966: iload 6
        //   968: istore_2
        //   969: aload 19
        //   971: astore 16
        //   973: goto -119 -> 854
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	976	0	paramString1	String
        //   0	976	1	paramString2	String
        //   0	976	2	paramInt1	int
        //   0	976	3	paramInt2	int
        //   0	976	4	paramInt3	int
        //   181	618	5	i	int
        //   203	764	6	j	int
        //   207	645	7	k	int
        //   199	421	8	m	int
        //   188	378	9	n	int
        //   195	381	10	i1	int
        //   178	158	11	i2	int
        //   223	133	12	i3	int
        //   81	784	13	bool1	boolean
        //   109	599	14	bool2	boolean
        //   11	471	15	localObject1	Object
        //   492	3	15	localException1	Exception
        //   500	357	15	localObject2	Object
        //   884	17	15	localIOException1	IOException
        //   920	3	15	localIOException2	IOException
        //   959	1	15	localObject3	Object
        //   165	9	16	localExifInterface	ExifInterface
        //   294	3	16	localIOException3	IOException
        //   582	290	16	localObject4	Object
        //   938	1	16	localStackOverflowError	StackOverflowError
        //   943	15	16	localException2	Exception
        //   971	1	16	localObject5	Object
        //   116	790	17	localObject6	Object
        //   641	51	18	localObject7	Object
        //   849	10	18	localFileNotFoundException1	java.io.FileNotFoundException
        //   964	1	18	localFileNotFoundException2	java.io.FileNotFoundException
        //   644	326	19	localObject8	Object
        // Exception table:
        //   from	to	target	type
        //   162	173	294	java/io/IOException
        //   473	481	492	java/lang/Exception
        //   473	481	505	java/lang/OutOfMemoryError
        //   573	584	813	java/lang/OutOfMemoryError
        //   712	725	849	java/io/FileNotFoundException
        //   833	846	849	java/io/FileNotFoundException
        //   871	876	884	java/io/IOException
        //   653	659	894	finally
        //   669	676	894	finally
        //   686	691	894	finally
        //   701	707	894	finally
        //   858	863	894	finally
        //   900	905	912	java/io/IOException
        //   733	738	920	java/io/IOException
        //   746	757	930	java/io/IOException
        //   573	584	938	java/lang/StackOverflowError
        //   573	584	943	java/lang/Exception
        //   757	766	948	java/io/IOException
        //   766	810	952	java/io/IOException
        //   712	725	956	finally
        //   833	846	956	finally
        //   653	659	964	java/io/FileNotFoundException
        //   669	676	964	java/io/FileNotFoundException
        //   686	691	964	java/io/FileNotFoundException
        //   701	707	964	java/io/FileNotFoundException
    }

    /* Error */
    public static boolean copyPhoto(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
            throws OutOfMemoryException {
        // Byte code:
        //   0: new 218	java/io/File
        //   3: dup
        //   4: aload_1
        //   5: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   8: invokevirtual 685	java/io/File:getParent	()Ljava/lang/String;
        //   11: astore 18
        //   13: aload 18
        //   15: ifnull +71 -> 86
        //   18: new 218	java/io/File
        //   21: dup
        //   22: aload 18
        //   24: invokespecial 514	java/io/File:<init>	(Ljava/lang/String;)V
        //   27: astore 18
        //   29: aload 18
        //   31: invokevirtual 528	java/io/File:exists	()Z
        //   34: ifne +52 -> 86
        //   37: aload 18
        //   39: invokevirtual 520	java/io/File:mkdirs	()Z
        //   42: ifne +44 -> 86
        //   45: aload 18
        //   47: invokevirtual 528	java/io/File:exists	()Z
        //   50: ifne +36 -> 86
        //   53: ldc 120
        //   55: new 203	java/lang/StringBuilder
        //   58: dup
        //   59: ldc_w 687
        //   62: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   65: aload 18
        //   67: invokevirtual 690	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   70: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 695	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   79: pop
        //   80: iconst_0
        //   81: istore 16
        //   83: iload 16
        //   85: ireturn
        //   86: aload_0
        //   87: invokestatic 698	com/dw/bcamera/util/Utils:getFileType	(Ljava/lang/String;)Ljava/lang/String;
        //   90: astore 18
        //   92: aload 18
        //   94: ifnull +59 -> 153
        //   97: aload 18
        //   99: ldc_w 700
        //   102: invokevirtual 703	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   105: ifeq +48 -> 153
        //   108: iconst_1
        //   109: istore 17
        //   111: iload 17
        //   113: invokestatic 707	com/dw/bcamera/util/Utils:createNativeAllocOptions	(Z)Landroid/graphics/BitmapFactory$Options;
        //   116: astore 20
        //   118: aload 20
        //   120: iconst_1
        //   121: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   124: aload_0
        //   125: aload 20
        //   127: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   130: pop
        //   131: aload 20
        //   133: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   136: ifle +11 -> 147
        //   139: aload 20
        //   141: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   144: ifgt +15 -> 159
        //   147: iconst_0
        //   148: istore 16
        //   150: goto -67 -> 83
        //   153: iconst_0
        //   154: istore 17
        //   156: goto -45 -> 111
        //   159: aconst_null
        //   160: astore 18
        //   162: new 607	android/media/ExifInterface
        //   165: astore 19
        //   167: aload 19
        //   169: aload_0
        //   170: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   173: aload 19
        //   175: astore 18
        //   177: iconst_0
        //   178: istore 14
        //   180: iconst_1
        //   181: istore 11
        //   183: aload 20
        //   185: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   188: istore 10
        //   190: aload 20
        //   192: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   195: istore 13
        //   197: iload 14
        //   199: istore 12
        //   201: iload 10
        //   203: istore 8
        //   205: iload 13
        //   207: istore 9
        //   209: aload 18
        //   211: ifnull +36 -> 247
        //   214: aload 18
        //   216: ldc_w 652
        //   219: iconst_0
        //   220: invokevirtual 729	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
        //   223: istore 15
        //   225: iload 15
        //   227: iconst_3
        //   228: if_icmpne +215 -> 443
        //   231: sipush 180
        //   234: istore 12
        //   236: iconst_1
        //   237: istore 11
        //   239: iload 13
        //   241: istore 9
        //   243: iload 10
        //   245: istore 8
        //   247: aload 20
        //   249: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   252: iload 4
        //   254: if_icmpge +13 -> 267
        //   257: aload 20
        //   259: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   262: iload 4
        //   264: if_icmplt +261 -> 525
        //   267: iload 9
        //   269: iload 8
        //   271: iload 4
        //   273: iload 4
        //   275: invokestatic 735	com/dw/bcamera/util/Utils:getFitInSize	(IIII)[I
        //   278: astore 18
        //   280: aload 18
        //   282: iconst_0
        //   283: iaload
        //   284: istore 10
        //   286: aload 18
        //   288: iconst_1
        //   289: iaload
        //   290: istore 4
        //   292: iload 10
        //   294: iload 4
        //   296: imul
        //   297: i2l
        //   298: lload_2
        //   299: lcmp
        //   300: ifle +222 -> 522
        //   303: iload 10
        //   305: iload 4
        //   307: imul
        //   308: i2d
        //   309: lload_2
        //   310: l2d
        //   311: ddiv
        //   312: invokestatic 773	java/lang/Math:sqrt	(D)D
        //   315: dstore 6
        //   317: iload 10
        //   319: i2d
        //   320: dload 6
        //   322: ddiv
        //   323: ldc2_w 774
        //   326: dadd
        //   327: d2i
        //   328: istore 10
        //   330: iload 4
        //   332: i2d
        //   333: dload 6
        //   335: ddiv
        //   336: ldc2_w 774
        //   339: dadd
        //   340: d2i
        //   341: istore 4
        //   343: iload 8
        //   345: i2d
        //   346: iload 4
        //   348: i2d
        //   349: ddiv
        //   350: invokestatic 741	java/lang/Math:floor	(D)D
        //   353: d2i
        //   354: istore 14
        //   356: iload 9
        //   358: i2d
        //   359: iload 10
        //   361: i2d
        //   362: ddiv
        //   363: invokestatic 741	java/lang/Math:floor	(D)D
        //   366: d2i
        //   367: istore 13
        //   369: aload 20
        //   371: iload 14
        //   373: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   376: aload 20
        //   378: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   381: iload 13
        //   383: if_icmpge +10 -> 393
        //   386: aload 20
        //   388: iload 13
        //   390: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   393: aload 20
        //   395: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   398: iconst_1
        //   399: if_icmpge +9 -> 408
        //   402: aload 20
        //   404: iconst_1
        //   405: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   408: aload 20
        //   410: iconst_0
        //   411: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   414: aload_0
        //   415: aload 20
        //   417: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   420: astore 18
        //   422: aload 18
        //   424: ifnonnull +192 -> 616
        //   427: iconst_0
        //   428: istore 16
        //   430: goto -347 -> 83
        //   433: astore 19
        //   435: aload 19
        //   437: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   440: goto -263 -> 177
        //   443: iload 15
        //   445: bipush 6
        //   447: if_icmpne +27 -> 474
        //   450: bipush 90
        //   452: istore 12
        //   454: aload 20
        //   456: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   459: istore 8
        //   461: aload 20
        //   463: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   466: istore 9
        //   468: iconst_1
        //   469: istore 11
        //   471: goto -224 -> 247
        //   474: iload 14
        //   476: istore 12
        //   478: iload 10
        //   480: istore 8
        //   482: iload 15
        //   484: istore 11
        //   486: iload 13
        //   488: istore 9
        //   490: iload 15
        //   492: bipush 8
        //   494: if_icmpne -247 -> 247
        //   497: sipush 270
        //   500: istore 12
        //   502: aload 20
        //   504: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   507: istore 8
        //   509: aload 20
        //   511: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   514: istore 9
        //   516: iconst_1
        //   517: istore 11
        //   519: goto -272 -> 247
        //   522: goto -179 -> 343
        //   525: iload 9
        //   527: iload 8
        //   529: imul
        //   530: i2l
        //   531: lload_2
        //   532: lcmp
        //   533: ifle +46 -> 579
        //   536: iload 9
        //   538: iload 8
        //   540: imul
        //   541: i2d
        //   542: lload_2
        //   543: l2d
        //   544: ddiv
        //   545: invokestatic 773	java/lang/Math:sqrt	(D)D
        //   548: dstore 6
        //   550: iload 9
        //   552: i2d
        //   553: dload 6
        //   555: ddiv
        //   556: ldc2_w 774
        //   559: dadd
        //   560: d2i
        //   561: istore 10
        //   563: iload 8
        //   565: i2d
        //   566: dload 6
        //   568: ddiv
        //   569: ldc2_w 774
        //   572: dadd
        //   573: d2i
        //   574: istore 4
        //   576: goto -233 -> 343
        //   579: iload 9
        //   581: istore 10
        //   583: iload 8
        //   585: istore 4
        //   587: goto -244 -> 343
        //   590: astore 18
        //   592: aload 18
        //   594: invokevirtual 363	java/lang/Exception:printStackTrace	()V
        //   597: aconst_null
        //   598: astore 18
        //   600: goto -178 -> 422
        //   603: astore_0
        //   604: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   607: dup
        //   608: aload_0
        //   609: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   612: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   615: athrow
        //   616: iload 12
        //   618: bipush 90
        //   620: if_icmpeq +19 -> 639
        //   623: iload 4
        //   625: istore 14
        //   627: iload 10
        //   629: istore 13
        //   631: iload 12
        //   633: sipush 270
        //   636: if_icmpne +11 -> 647
        //   639: iload 4
        //   641: istore 13
        //   643: iload 10
        //   645: istore 14
        //   647: aconst_null
        //   648: astore 20
        //   650: aload 18
        //   652: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   655: istore 10
        //   657: aload 18
        //   659: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   662: istore 4
        //   664: iload 10
        //   666: iload 13
        //   668: if_icmpgt +10 -> 678
        //   671: iload 4
        //   673: iload 14
        //   675: if_icmple +274 -> 949
        //   678: aload 18
        //   680: iload 13
        //   682: iload 14
        //   684: iconst_1
        //   685: invokestatic 752	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
        //   688: astore 19
        //   690: aload 19
        //   692: astore 20
        //   694: aload 20
        //   696: astore 19
        //   698: aload 20
        //   700: aload 18
        //   702: if_acmpeq +12 -> 714
        //   705: aload 18
        //   707: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   710: aload 20
        //   712: astore 19
        //   714: aload 19
        //   716: astore 20
        //   718: iload 12
        //   720: ifle +12 -> 732
        //   723: aload 19
        //   725: iload 12
        //   727: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   730: astore 20
        //   732: iconst_0
        //   733: istore 16
        //   735: iload 8
        //   737: istore 4
        //   739: iload 9
        //   741: istore 10
        //   743: aload 20
        //   745: ifnull +122 -> 867
        //   748: aconst_null
        //   749: astore 21
        //   751: aconst_null
        //   752: astore 22
        //   754: aload 21
        //   756: astore 18
        //   758: iload 8
        //   760: istore 10
        //   762: iload 9
        //   764: istore 8
        //   766: aload 20
        //   768: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   771: istore 4
        //   773: aload 21
        //   775: astore 18
        //   777: iload 4
        //   779: istore 10
        //   781: iload 9
        //   783: istore 8
        //   785: aload 20
        //   787: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   790: istore 9
        //   792: aload 21
        //   794: astore 18
        //   796: iload 4
        //   798: istore 10
        //   800: iload 9
        //   802: istore 8
        //   804: new 663	java/io/FileOutputStream
        //   807: astore 19
        //   809: aload 21
        //   811: astore 18
        //   813: iload 4
        //   815: istore 10
        //   817: iload 9
        //   819: istore 8
        //   821: aload 19
        //   823: aload_1
        //   824: invokespecial 757	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   827: iload 17
        //   829: ifeq +127 -> 956
        //   832: aload 20
        //   834: getstatic 760	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   837: iload 5
        //   839: aload 19
        //   841: invokevirtual 409	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   844: pop
        //   845: iconst_1
        //   846: istore 16
        //   848: aload 19
        //   850: ifnull +8 -> 858
        //   853: aload 19
        //   855: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   858: aload 20
        //   860: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   863: iload 9
        //   865: istore 10
        //   867: new 607	android/media/ExifInterface
        //   870: astore 18
        //   872: aload 18
        //   874: aload_0
        //   875: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   878: new 607	android/media/ExifInterface
        //   881: astore_0
        //   882: aload_0
        //   883: aload_1
        //   884: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   887: aload 18
        //   889: aload_0
        //   890: invokestatic 762	com/dw/bcamera/util/Utils:copyExif	(Landroid/media/ExifInterface;Landroid/media/ExifInterface;)V
        //   893: aload_0
        //   894: ldc_w 644
        //   897: iload 4
        //   899: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   902: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   905: aload_0
        //   906: ldc_w 646
        //   909: iload 10
        //   911: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   914: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   917: aload_0
        //   918: ldc_w 652
        //   921: iload 11
        //   923: invokestatic 765	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   926: invokevirtual 614	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
        //   929: aload_0
        //   930: invokevirtual 768	android/media/ExifInterface:saveAttributes	()V
        //   933: goto -850 -> 83
        //   936: astore_0
        //   937: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   940: dup
        //   941: aload_0
        //   942: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   945: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   948: athrow
        //   949: aload 18
        //   951: astore 19
        //   953: goto -239 -> 714
        //   956: aload 20
        //   958: getstatic 405	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   961: iload 5
        //   963: aload 19
        //   965: invokevirtual 409	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   968: pop
        //   969: goto -124 -> 845
        //   972: astore 18
        //   974: iload 9
        //   976: istore 8
        //   978: aload 18
        //   980: astore 21
        //   982: aload 19
        //   984: astore 18
        //   986: aload 21
        //   988: invokevirtual 769	java/io/FileNotFoundException:printStackTrace	()V
        //   991: iconst_0
        //   992: istore 16
        //   994: aload 19
        //   996: ifnull +8 -> 1004
        //   999: aload 19
        //   1001: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   1004: aload 20
        //   1006: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   1009: iload 8
        //   1011: istore 10
        //   1013: goto -146 -> 867
        //   1016: astore 18
        //   1018: aload 18
        //   1020: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   1023: goto -19 -> 1004
        //   1026: astore_0
        //   1027: aload 18
        //   1029: ifnull +8 -> 1037
        //   1032: aload 18
        //   1034: invokevirtual 669	java/io/FileOutputStream:close	()V
        //   1037: aload 20
        //   1039: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   1042: aload_0
        //   1043: athrow
        //   1044: astore_1
        //   1045: aload_1
        //   1046: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   1049: goto -12 -> 1037
        //   1052: astore 18
        //   1054: aload 18
        //   1056: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   1059: goto -201 -> 858
        //   1062: astore_0
        //   1063: aload_0
        //   1064: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   1067: goto -984 -> 83
        //   1070: astore 19
        //   1072: goto -378 -> 694
        //   1075: astore 19
        //   1077: goto -383 -> 694
        //   1080: astore_0
        //   1081: goto -18 -> 1063
        //   1084: astore_0
        //   1085: goto -22 -> 1063
        //   1088: astore_0
        //   1089: aload 19
        //   1091: astore 18
        //   1093: goto -66 -> 1027
        //   1096: astore 21
        //   1098: iload 10
        //   1100: istore 4
        //   1102: aload 22
        //   1104: astore 19
        //   1106: goto -124 -> 982
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1109	0	paramString1	String
        //   0	1109	1	paramString2	String
        //   0	1109	2	paramLong	long
        //   0	1109	4	paramInt1	int
        //   0	1109	5	paramInt2	int
        //   315	252	6	d	double
        //   203	807	8	i	int
        //   207	768	9	j	int
        //   188	911	10	k	int
        //   181	741	11	m	int
        //   199	527	12	n	int
        //   195	486	13	i1	int
        //   178	505	14	i2	int
        //   223	272	15	i3	int
        //   81	912	16	bool1	boolean
        //   109	719	17	bool2	boolean
        //   11	412	18	localObject1	Object
        //   590	3	18	localException1	Exception
        //   598	352	18	localObject2	Object
        //   972	7	18	localFileNotFoundException1	java.io.FileNotFoundException
        //   984	1	18	localObject3	Object
        //   1016	17	18	localIOException1	IOException
        //   1052	3	18	localIOException2	IOException
        //   1091	1	18	localObject4	Object
        //   165	9	19	localExifInterface	ExifInterface
        //   433	3	19	localIOException3	IOException
        //   688	312	19	localObject5	Object
        //   1070	1	19	localStackOverflowError	StackOverflowError
        //   1075	15	19	localException2	Exception
        //   1104	1	19	localObject6	Object
        //   116	922	20	localObject7	Object
        //   749	238	21	localFileNotFoundException2	java.io.FileNotFoundException
        //   1096	1	21	localFileNotFoundException3	java.io.FileNotFoundException
        //   752	351	22	localObject8	Object
        // Exception table:
        //   from	to	target	type
        //   162	173	433	java/io/IOException
        //   414	422	590	java/lang/Exception
        //   414	422	603	java/lang/OutOfMemoryError
        //   678	690	936	java/lang/OutOfMemoryError
        //   832	845	972	java/io/FileNotFoundException
        //   956	969	972	java/io/FileNotFoundException
        //   999	1004	1016	java/io/IOException
        //   766	773	1026	finally
        //   785	792	1026	finally
        //   804	809	1026	finally
        //   821	827	1026	finally
        //   986	991	1026	finally
        //   1032	1037	1044	java/io/IOException
        //   853	858	1052	java/io/IOException
        //   867	878	1062	java/io/IOException
        //   678	690	1070	java/lang/StackOverflowError
        //   678	690	1075	java/lang/Exception
        //   878	887	1080	java/io/IOException
        //   887	933	1084	java/io/IOException
        //   832	845	1088	finally
        //   956	969	1088	finally
        //   766	773	1096	java/io/FileNotFoundException
        //   785	792	1096	java/io/FileNotFoundException
        //   804	809	1096	java/io/FileNotFoundException
        //   821	827	1096	java/io/FileNotFoundException
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String createCaptureVideoName(long paramLong) {
        Date localDate = new Date(paramLong);
        return new SimpleDateFormat("'qbb6'_yyyyMMdd_HHmmss").format(localDate);
    }

    /* Error */
    public static BitmapFactory.Options createNativeAllocOptions(boolean paramBoolean) {
        // Byte code:
        //   0: new 709	android/graphics/BitmapFactory$Options
        //   3: dup
        //   4: invokespecial 802	android/graphics/BitmapFactory$Options:<init>	()V
        //   7: astore_3
        //   8: aconst_null
        //   9: astore_2
        //   10: ldc_w 709
        //   13: ldc_w 804
        //   16: invokevirtual 810	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   19: astore_1
        //   20: aload_1
        //   21: ifnull +14 -> 35
        //   24: aload_1
        //   25: iconst_1
        //   26: invokevirtual 816	java/lang/reflect/Field:setAccessible	(Z)V
        //   29: aload_1
        //   30: aload_3
        //   31: iconst_1
        //   32: invokevirtual 820	java/lang/reflect/Field:setBoolean	(Ljava/lang/Object;Z)V
        //   35: iload_0
        //   36: ifeq +10 -> 46
        //   39: aload_3
        //   40: getstatic 265	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
        //   43: putfield 823	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
        //   46: aload_3
        //   47: iconst_1
        //   48: putfield 826	android/graphics/BitmapFactory$Options:inInputShareable	Z
        //   51: aload_3
        //   52: iconst_1
        //   53: putfield 829	android/graphics/BitmapFactory$Options:inPurgeable	Z
        //   56: aload_3
        //   57: areturn
        //   58: astore_1
        //   59: aload_1
        //   60: invokevirtual 830	java/lang/SecurityException:printStackTrace	()V
        //   63: aload_2
        //   64: astore_1
        //   65: goto -45 -> 20
        //   68: astore 4
        //   70: aload_2
        //   71: astore_1
        //   72: getstatic 603	android/os/Build$VERSION:SDK_INT	I
        //   75: bipush 14
        //   77: if_icmpge -57 -> 20
        //   80: aload 4
        //   82: invokevirtual 831	java/lang/NoSuchFieldException:printStackTrace	()V
        //   85: aload_2
        //   86: astore_1
        //   87: goto -67 -> 20
        //   90: astore_1
        //   91: aload_1
        //   92: invokevirtual 832	java/lang/IllegalArgumentException:printStackTrace	()V
        //   95: goto -60 -> 35
        //   98: astore_1
        //   99: aload_1
        //   100: invokevirtual 833	java/lang/IllegalAccessException:printStackTrace	()V
        //   103: goto -68 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	paramBoolean	boolean
        //   19	11	1	localField	Field
        //   58	2	1	localSecurityException	SecurityException
        //   64	23	1	localObject1	Object
        //   90	2	1	localIllegalArgumentException	IllegalArgumentException
        //   98	2	1	localIllegalAccessException	IllegalAccessException
        //   9	77	2	localObject2	Object
        //   7	50	3	localOptions	BitmapFactory.Options
        //   68	13	4	localNoSuchFieldException	NoSuchFieldException
        // Exception table:
        //   from	to	target	type
        //   10	20	58	java/lang/SecurityException
        //   10	20	68	java/lang/NoSuchFieldException
        //   29	35	90	java/lang/IllegalArgumentException
        //   29	35	98	java/lang/IllegalAccessException
    }

    public static void createShortCut(Context paramContext, int paramInt1, int paramInt2) {
        Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("duplicate", false);
        localIntent.putExtra("android.intent.extra.shortcut.NAME", paramContext.getResources().getString(paramInt2));
        localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext.getApplicationContext(), paramInt1));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", new Intent(paramContext.getApplicationContext(), paramContext.getClass()));
        paramContext.sendBroadcast(localIntent);
    }

    public static boolean deleteFile(String paramString) {
        boolean bool2 = false;
        boolean bool1;
        if ((paramString == null) || (paramString.equals(""))) {
            bool1 = false;
        }
        for (; ; ) {
            return bool1;
            paramString = new File(paramString);
            bool1 = bool2;
            if (paramString != null) {
                bool1 = bool2;
                if (paramString.exists()) {
                    bool1 = paramString.delete();
                }
            }
        }
    }

    public static void deleteFolder(File paramFile) {
        if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
        }
        File[] arrayOfFile;
        int i;
        for (; ; ) {
            return;
            try {
                arrayOfFile = paramFile.listFiles();
                if (arrayOfFile != null) {
                    i = 0;
                    if (i < arrayOfFile.length) {
                        break;
                    }
                }
                paramFile.delete();
            } catch (Exception paramFile) {
            }
        }
        if (arrayOfFile[i].isDirectory()) {
            deleteFolder(arrayOfFile[i]);
        }
        for (; ; ) {
            i++;
            break;
            arrayOfFile[i].delete();
        }
    }

    public static void deleteTempPhoto() {
        Object localObject1 = new File(Config.PHOTO_EDIT_DIR);
        if (((File) localObject1).isDirectory()) {
            localObject1 = ((File) localObject1).listFiles();
            if ((localObject1 != null) && (localObject1.length != 0)) {
                break label33;
            }
        }
        for (; ; ) {
            return;
            label33:
            int j = localObject1.length;
            for (int i = 0; i < j; i++) {
                Object localObject2 = localObject1[i];
                if (((File) localObject2).isFile()) {
                    ((File) localObject2).delete();
                }
            }
        }
    }

    public static void deleteTempVideos(List<String> paramList) {
        if ((paramList != null) && (!paramList.isEmpty())) {
            new Thread(new Runnable() {
                public void run() {
                    Iterator localIterator = Utils.this.iterator();
                    for (; ; ) {
                        if (!localIterator.hasNext()) {
                            return;
                        }
                        File localFile = new File((String) localIterator.next());
                        if (localFile.exists()) {
                            localFile.delete();
                        }
                    }
                }
            }).start();
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(9)
    public static long downloadFile(Context paramContext, String paramString1, String paramString2) {
        long l;
        if ((paramString1 == null) || (paramString1.equals(""))) {
            l = -1L;
        }
        for (; ; ) {
            return l;
            if (!isSDCardValid()) {
                CommonUI.showTipInfo(paramContext, 2131427390);
                l = -1L;
                continue;
            }
            try {
                DownloadManager localDownloadManager = (DownloadManager) paramContext.getSystemService("download");
                DownloadManager.Request localRequest = new android / app / DownloadManager$Request;
                localRequest.<init> (Uri.parse(paramString1));
                paramContext = paramString2;
                if (TextUtils.isEmpty(paramString2)) {
                    paramContext = getFileNameByPath(paramString1);
                }
                localRequest.setTitle(paramContext);
                localRequest.setAllowedNetworkTypes(3);
                localRequest.setAllowedOverRoaming(false);
                localRequest.setShowRunningNotification(true);
                localRequest.setVisibleInDownloadsUi(true);
                paramString2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                if ((paramString2 != null) && (!paramString2.exists())) {
                    paramString2.mkdirs();
                }
                paramString1 = getFileNameByPath(paramString1);
                paramContext = paramString1;
                if (!TextUtils.isEmpty(paramString1)) {
                    paramContext = paramString1;
                    if (!paramString1.endsWith(".apk")) {
                        paramContext = new java / lang / StringBuilder;
                        paramContext.<init> (String.valueOf(paramString1));
                        paramContext = ".apk";
                    }
                }
                paramString1 = new java / io / File;
                paramString1.<init> (paramString2, paramContext);
                if (paramString1.exists()) {
                    paramString1.delete();
                }
                localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, paramContext);
                l = localDownloadManager.enqueue(localRequest);
            } catch (IllegalArgumentException paramContext) {
                for (; ; ) {
                    l = -1L;
                }
            } catch (SecurityException paramContext) {
                for (; ; ) {
                    Log.e("btime", "unauthorized destination code");
                    l = -1L;
                }
            } catch (IllegalStateException paramContext) {
                for (; ; ) {
                    l = -1L;
                }
            } catch (Exception paramContext) {
                for (; ; ) {
                    l = -1L;
                }
            } catch (NoClassDefFoundError paramContext) {
                for (; ; ) {
                    l = -1L;
                }
            }
        }
    }

    public static void enableComponentIfNeeded(Context paramContext, String paramString) {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null) {
            paramContext = new ComponentName(paramContext.getPackageName(), paramString);
            int i = localPackageManager.getComponentEnabledSetting(paramContext);
            if ((i != 1) || (i != 1)) {
                localPackageManager.setComponentEnabledSetting(paramContext, 1, 1);
            }
        }
    }

    public static boolean equals(List<ThemeDataNew> paramList1, List<ThemeDataNew> paramList2) {
        ArrayList localArrayList;
        int i;
        label38:
        boolean bool;
        if (paramList1.size() == paramList2.size()) {
            localArrayList = new ArrayList();
            i = 0;
            if (i >= paramList1.size()) {
                i = 0;
                if (i < paramList2.size()) {
                    break label82;
                }
                bool = true;
            }
        }
        for (; ; ) {
            return bool;
            localArrayList.add(Long.valueOf(((ThemeDataNew) paramList1.get(i)).resId));
            i++;
            break;
            label82:
            if (!localArrayList.contains(Long.valueOf(((ThemeDataNew) paramList2.get(i)).resId))) {
                bool = false;
            } else {
                i++;
                break label38;
                bool = false;
            }
        }
    }

    public static String formatInfo(Context paramContext, Date paramDate1, Date paramDate2) {
        long l = getCustomTimeInMillis(paramDate1, 0, 0, 0, 0);
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(l);
        l = getCustomTimeInMillis(paramDate2, 0, 0, 0, 0);
        Calendar localCalendar1 = Calendar.getInstance();
        localCalendar1.setTimeInMillis(l);
        int k = localCalendar1.get(5) - localCalendar2.get(5);
        int m = localCalendar1.get(2) - localCalendar2.get(2);
        int n = localCalendar1.get(1) - localCalendar2.get(1);
        if ((n < 0) || ((n == 0) && (m < 0)) || ((n == 0) && (m == 0) && (k <= 0))) {
            paramContext = paramContext.getResources().getString(2131427547);
        }
        for (; ; ) {
            return paramContext;
            if ((m == 0) && (k <= 0) && (k >= -7) && (k == 0)) {
                paramContext = paramContext.getResources().getString(2131427541, new Object[]{Integer.valueOf(n)});
            } else {
                int i = calculateDay(paramDate1, paramDate2);
                if (i == 30) {
                    paramContext = paramContext.getResources().getString(2131427542, new Object[]{paramContext.getResources().getString(2131427543)});
                } else if (i == 100) {
                    paramContext = paramContext.getResources().getString(2131427542, new Object[]{paramContext.getResources().getString(2131427544)});
                } else {
                    int j = getFullMonths(paramDate1, paramDate2);
                    if (j > 0) {
                        paramContext = paramContext.getResources().getString(2131427545, new Object[]{Integer.valueOf(j)});
                    } else if (i < 100) {
                        paramContext = paramContext.getResources().getString(2131427546, new Object[]{Integer.valueOf(i)});
                    } else {
                        i = k;
                        j = m;
                        if (k < 0) {
                            j = m - 1;
                            localCalendar1.add(2, -1);
                            if (localCalendar1.getActualMaximum(5) <= localCalendar2.get(5)) {
                                break label473;
                            }
                        }
                        label473:
                        for (i = localCalendar1.getActualMaximum(5) - localCalendar2.get(5) + localCalendar1.get(5); ; i = localCalendar1.get(5)) {
                            m = j;
                            k = n;
                            if (j < 0) {
                                m = (j + 12) % 12;
                                k = n - 1;
                            }
                            if (k <= 0) {
                                break label617;
                            }
                            if (k >= 2) {
                                break label515;
                            }
                            if (i <= 0) {
                                break label483;
                            }
                            paramContext = paramContext.getResources().getString(2131427548, new Object[]{Integer.valueOf(k * 12 + m), Integer.valueOf(i)});
                            break;
                        }
                        label483:
                        paramContext = paramContext.getResources().getString(2131427549, new Object[]{Integer.valueOf(k * 12 + m)});
                        continue;
                        label515:
                        if (m > 0) {
                            paramContext = paramContext.getResources().getString(2131427550, new Object[]{Integer.valueOf(k), Integer.valueOf(m)});
                        } else if (i > 0) {
                            paramContext = paramContext.getResources().getString(2131427551, new Object[]{Integer.valueOf(k), Integer.valueOf(i)});
                        } else {
                            paramContext = paramContext.getResources().getString(2131427552, new Object[]{Integer.valueOf(k)});
                            continue;
                            label617:
                            if ((m > 0) && (i > 0)) {
                                paramContext = paramContext.getResources().getString(2131427548, new Object[]{Integer.valueOf(m), Integer.valueOf(i)});
                            } else if ((m > 0) && (i == 0)) {
                                paramContext = paramContext.getResources().getString(2131427549, new Object[]{Integer.valueOf(m)});
                            } else {
                                paramContext = "";
                            }
                        }
                    }
                }
            }
        }
    }

    public static String formatNewLineChar(String paramString) {
        if (paramString.contains("\\n")) {
            paramString = paramString.replaceAll("\\\\n", "\n");
        }
        for (; ; ) {
            return paramString;
        }
    }

    public static ArrayList<Long> fromJson(String paramString) {
        Gson localGson = GsonUtil.createGson();
        Type localType = new TypeToken() {
        }.getType();
        Object localObject = null;
        try {
            paramString = (ArrayList) localGson.fromJson(paramString, localType);
            return paramString;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString.printStackTrace();
                paramString = (String) localObject;
            }
        }
    }

    public static String genRandomNum(int paramInt) {
        int i = 0;
        char[] arrayOfChar = new char[10];
        char[] tmp10_8 = arrayOfChar;
        tmp10_8[0] = 48;
        char[] tmp16_10 = tmp10_8;
        tmp16_10[1] = 49;
        char[] tmp22_16 = tmp16_10;
        tmp22_16[2] = 50;
        char[] tmp28_22 = tmp22_16;
        tmp28_22[3] = 51;
        char[] tmp34_28 = tmp28_22;
        tmp34_28[4] = 52;
        char[] tmp40_34 = tmp34_28;
        tmp40_34[5] = 53;
        char[] tmp46_40 = tmp40_34;
        tmp46_40[6] = 54;
        char[] tmp53_46 = tmp46_40;
        tmp53_46[7] = 55;
        char[] tmp60_53 = tmp53_46;
        tmp60_53[8] = 56;
        char[] tmp67_60 = tmp60_53;
        tmp67_60[9] = 57;
        tmp67_60;
        StringBuffer localStringBuffer = new StringBuffer("");
        Random localRandom = new Random();
        for (; ; ) {
            if (i >= paramInt) {
                return localStringBuffer.toString();
            }
            int j = Math.abs(localRandom.nextInt(10));
            if ((j >= 0) && (j < arrayOfChar.length)) {
                localStringBuffer.append(arrayOfChar[j]);
                i++;
            }
        }
    }

    public static String getApkVersionName(Context paramContext, String paramString) {
        Object localObject = null;
        if (TextUtils.isEmpty(paramString)) {
            paramContext = null;
        }
        for (; ; ) {
            return paramContext;
            try {
                paramString = paramContext.getPackageManager().getPackageInfo(paramString, 0);
                paramContext = (Context) localObject;
                if (paramString != null) {
                    paramContext = paramString.versionName;
                }
            } catch (PackageManager.NameNotFoundException paramContext) {
                for (; ; ) {
                    paramString = null;
                }
            }
        }
    }

    public static int getChannel(Context paramContext) {
        int i = 11000;
        String str = null;
        for (; ; ) {
            try {
                localInputStream = paramContext.getResources().getAssets().open("code.bt");
                paramContext = str;
                if (localInputStream != null) {
                    localBufferedReader = new java / io / BufferedReader;
                    paramContext = new java / io / InputStreamReader;
                    paramContext.<init> (localInputStream);
                    localBufferedReader.<init> (paramContext);
                    paramContext = new java / lang / StringBuilder;
                    paramContext.<init> ();
                }
            } catch (IOException paramContext) {
                InputStream localInputStream;
                BufferedReader localBufferedReader;
                paramContext = localIOException;
                continue;
            }
            try {
                str = localBufferedReader.readLine();
                if (str != null) {
                    continue;
                }
                localInputStream.close();
            } catch (IOException localIOException) {
                continue;
            }
            if (!TextUtils.isEmpty(paramContext)) {
                i = Integer.valueOf(paramContext.toString()).intValue();
            }
            return i;
            paramContext.append(str);
        }
    }

    public static Bitmap getCircleCornerBitmap(Bitmap paramBitmap, int paramInt)
            throws OutOfMemoryException {
        Object localObject3;
        if (paramBitmap == null) {
            localObject3 = null;
        }
        for (; ; ) {
            return (Bitmap) localObject3;
            try {
                Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                localObject3 = localBitmap;
                if (localBitmap == null) {
                    continue;
                }
                localObject3 = new Canvas(localBitmap);
                int i = paramBitmap.getWidth() - paramInt * 2;
                paramInt = paramBitmap.getHeight() - paramInt * 2;
                Paint localPaint = new Paint();
                Rect localRect = new Rect(0, 0, i, paramInt);
                localPaint.setAntiAlias(true);
                ((Canvas) localObject3).drawARGB(0, 0, 0, 0);
                localPaint.setColor(-12434878);
                ((Canvas) localObject3).drawCircle(i / 2, paramInt / 2, i / 2, localPaint);
                localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                ((Canvas) localObject3).drawBitmap(paramBitmap, localRect, localRect, localPaint);
                localObject3 = localBitmap;
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    Object localObject1 = null;
                }
            } catch (OutOfMemoryError paramBitmap) {
                throw new OutOfMemoryException(paramBitmap.getMessage());
            } catch (StackOverflowError localStackOverflowError) {
                for (; ; ) {
                    localStackOverflowError.printStackTrace();
                    Object localObject2 = null;
                }
            }
        }
    }

    public static long getCustomTimeInMillis(Date paramDate, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramDate == null) {
        }
        Calendar localCalendar;
        for (long l = 0L; ; l = localCalendar.getTimeInMillis()) {
            return l;
            localCalendar = Calendar.getInstance();
            localCalendar.setTime(paramDate);
            localCalendar.set(11, paramInt1);
            localCalendar.set(12, paramInt2);
            localCalendar.set(13, paramInt3);
            localCalendar.set(14, paramInt4);
        }
    }

    public static long getCustomTimeInMillis(Date paramDate, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
        if (paramDate == null) {
        }
        Calendar localCalendar;
        for (long l = 0L; ; l = localCalendar.getTimeInMillis()) {
            return l;
            localCalendar = Calendar.getInstance();
            localCalendar.setTime(paramDate);
            localCalendar.set(1, paramInt1);
            localCalendar.set(2, paramInt2);
            localCalendar.set(5, paramInt3);
            localCalendar.set(11, paramInt4);
            localCalendar.set(12, paramInt5);
            localCalendar.set(13, paramInt6);
            localCalendar.set(14, paramInt7);
        }
    }

    public static String getDateFormat(long paramLong, String paramString) {
        if ((paramLong == 0L) || (paramString == null) || (paramString.equals(""))) {
            paramString = null;
            return paramString;
        }
        if (mDate == null) {
            mDate = new Date(paramLong);
        }
        for (; ; ) {
            paramString = new SimpleDateFormat(paramString).format(mDate);
            break;
            mDate.setTime(paramLong);
        }
    }

    public static int[] getDateSegment(int paramInt) {
        int[] arrayOfInt = new int[3];
        if (paramInt < 10000) {
            arrayOfInt[0] = paramInt;
            arrayOfInt[1] = 0;
            arrayOfInt[2] = 0;
        }
        for (; ; ) {
            return arrayOfInt;
            if (paramInt < 1000000) {
                arrayOfInt[0] = (paramInt / 100);
                arrayOfInt[1] = (paramInt - paramInt / 100 * 100 - 1);
                arrayOfInt[2] = 0;
            } else {
                arrayOfInt[0] = (paramInt / 10000);
                arrayOfInt[1] = ((paramInt - paramInt / 10000 * 10000) / 100 - 1);
                arrayOfInt[2] = (paramInt - paramInt / 100 * 100);
            }
        }
    }

    public static String getDeviceId(Context paramContext) {
        Object localObject1 = null;
        Object localObject2 = (TelephonyManager) paramContext.getSystemService("phone");
        if (localObject2 != null) {
            localObject1 = ((TelephonyManager) localObject2).getDeviceId();
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence) localObject1)) {
            paramContext = ((WifiManager) paramContext.getSystemService("wifi")).getConnectionInfo();
            if (paramContext != null) {
                localObject1 = paramContext.getMacAddress();
            }
            if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                break label96;
            }
            localObject1 = BTEngine.singleton().getConfig();
            paramContext = ((Config) localObject1).getDeviceUuid();
            localObject2 = paramContext;
            if (TextUtils.isEmpty(paramContext)) {
                localObject2 = UUID.randomUUID().toString();
                ((Config) localObject1).setDeviceUuid((String) localObject2);
            }
        }
        for (; ; ) {
            return (String) localObject2;
            label96:
            localObject2 = ((String) localObject1).replaceAll(":", "-");
        }
    }

    public static DeviceInfo getDeviceInfo(Context paramContext) {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        DeviceInfo localDeviceInfo = new DeviceInfo();
        localDeviceInfo.setDW(Integer.valueOf(localDisplayMetrics.widthPixels));
        localDeviceInfo.setDH(Integer.valueOf(localDisplayMetrics.heightPixels));
        localDeviceInfo.setModel(Build.MODEL);
        localDeviceInfo.setVersion(Build.VERSION.RELEASE);
        localDeviceInfo.setOS("android");
        localDeviceInfo.setChannel(Integer.valueOf(getChannel(paramContext)));
        return localDeviceInfo;
    }

    public static Point getDisplaySize(Context paramContext) {
        Point localPoint = new Point();
        WindowManager localWindowManager = (WindowManager) paramContext.getSystemService("window");
        paramContext = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(paramContext);
        localPoint.x = paramContext.widthPixels;
        localPoint.y = paramContext.heightPixels;
        return localPoint;
    }

    public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        paramDouble1 = rad(paramDouble1);
        paramDouble3 = rad(paramDouble3);
        paramDouble2 = rad(paramDouble2);
        paramDouble4 = rad(paramDouble4);
        return Math.round(10000.0D * (2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 6378137.0D)) / 10000L;
    }

    public static long getExifDateTime(String paramString, long paramLong) {
        if (paramString == null) {
        }
        for (; ; ) {
            return paramLong;
            try {
                Object localObject = new android / media / ExifInterface;
                ((ExifInterface) localObject).<init> (paramString);
                localObject = ((ExifInterface) localObject).getAttribute("DateTime");
                l = paramLong;
                if (localObject != null) {
                    paramString = new java / text / SimpleDateFormat;
                    paramString.<init> ("yyyy:MM:dd HH:mm:ss");
                    paramString.setTimeZone(TimeZone.getTimeZone("Etc/Greenwich"));
                    l = paramString.parse((String) localObject).getTime();
                }
            } catch (Exception paramString) {
                for (; ; ) {
                    paramString.printStackTrace();
                    long l = paramLong;
                }
            }
            paramLong = l;
        }
    }

    public static String getExtension(String paramString) {
        if (paramString == null) {
            paramString = null;
        }
        for (; ; ) {
            return paramString;
            int i = paramString.lastIndexOf(".");
            if (i >= 0) {
                paramString = paramString.substring(i);
            } else {
                paramString = "";
            }
        }
    }

    public static String getFileNameByPath(String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        int i;
        if (paramString != null) {
            localObject1 = localObject2;
            if (!paramString.equals("")) {
                i = paramString.lastIndexOf("/");
                if (i != -1) {
                }
            }
        }
        for (paramString = null; ; paramString = (String) localObject1) {
            return paramString;
            localObject1 = paramString.substring(i + 1);
        }
    }

    public static String getFileType(String paramString) {
        String str = null;
        if ((paramString == null) || (paramString.equals(""))) {
            str = null;
        }
        for (; ; ) {
            return str;
            int i = paramString.lastIndexOf(".");
            if (i != -1) {
                str = paramString.substring(i);
            }
        }
    }

    public static int[] getFitInSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[1] = 0;
        arrayOfInt[0] = 0;
        double d1 = paramInt3 / paramInt1;
        double d2 = paramInt4 / paramInt2;
        if (d1 > d2) {
            arrayOfInt[0] = ((int) (paramInt1 * d2 + 0.5D));
            arrayOfInt[1] = paramInt4;
        }
        for (; ; ) {
            return arrayOfInt;
            arrayOfInt[0] = paramInt3;
            arrayOfInt[1] = ((int) (paramInt2 * d1 + 0.5D));
        }
    }

    public static Bitmap getFitOutBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
            throws OutOfMemoryException {
        Object localObject2;
        if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
            localObject2 = null;
        }
        do {
            return (Bitmap) localObject2;
            j = paramBitmap.getWidth();
            i = paramBitmap.getHeight();
            k = j - paramInt1;
            m = i - paramInt2;
            if (k != 0) {
                break;
            }
            localObject2 = paramBitmap;
        } while (m == 0);
        localPaint = new Paint(2);
        for (Object localObject1 = null; ; localObject1 = localObject2) {
            try {
                if (paramBitmap.getConfig() != null) {
                    break label213;
                }
                localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
                localObject1 = localObject2;
            } catch (OutOfMemoryError paramBitmap) {
                throw new OutOfMemoryException(paramBitmap.getMessage());
            } catch (StackOverflowError localStackOverflowError) {
                Rect localRect1;
                Rect localRect2;
                for (; ; ) {
                    localStackOverflowError.printStackTrace();
                }
                float f2 = 0.0F;
                float f1 = 0.0F;
                if (j * paramInt2 <= paramInt1 * i) {
                    break label353;
                }
                f2 = paramInt2 / i;
                f2 = (j - paramInt1 / f2) * 0.5F;
                for (; ; ) {
                    k = (int) (0.5F + f2);
                    m = (int) (0.5F + f1);
                    localRect1.set(k, m, j - k, i - m);
                    localRect2.set(0, 0, paramInt1, paramInt2);
                    localStackOverflowError.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
                    break;
                    f1 = paramInt1 / j;
                    f1 = (i - paramInt2 / f1) * 0.5F;
                }
            } catch (Exception localException) {
                label213:
                for (; ; ) {
                }
            }
            localObject2 = paramBitmap;
            if (localObject1 == null) {
                break;
            }
            localObject2 = new Canvas((Bitmap) localObject1);
            localRect1 = new Rect();
            localRect2 = new Rect();
            if ((k <= 0) || (k >= 10) || (m <= 0) || (m >= 10)) {
                break label254;
            }
            k /= 2;
            m /= 2;
            localRect1.set(k + 0, m + 0, j - k, i - m);
            localRect2.set(0, 0, paramInt1, paramInt2);
            ((Canvas) localObject2).drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
            localObject2 = localObject1;
            break;
            localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
        }
    }

    public static int[] getFitOutSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[1] = 0;
        arrayOfInt[0] = 0;
        double d2 = paramInt3 / paramInt1;
        double d1 = paramInt4 / paramInt2;
        if (d2 > d1) {
            arrayOfInt[0] = paramInt3;
            arrayOfInt[1] = ((int) (paramInt2 * d2 + 0.5D));
        }
        for (; ; ) {
            return arrayOfInt;
            arrayOfInt[0] = ((int) (paramInt1 * d1 + 0.5D));
            arrayOfInt[1] = paramInt4;
        }
    }

    public static int getFitTextSize(int paramInt) {
        if (paramInt < 720) {
            paramInt = 14;
        }
        for (; ; ) {
            return paramInt;
            if (paramInt < 1080) {
                paramInt = 19;
            } else if (paramInt < 1440) {
                paramInt = 32;
            } else {
                paramInt = 38;
            }
        }
    }

    public static int getFitTextSizeByHeight(int paramInt) {
        TextPaint localTextPaint = new TextPaint();
        for (int i = 30; ; i--) {
            int j;
            if (i <= 0) {
                j = 10;
            }
            Paint.FontMetrics localFontMetrics;
            do {
                return j;
                localTextPaint.setTextSize(i);
                localFontMetrics = localTextPaint.getFontMetrics();
                j = i;
            } while (localFontMetrics.descent - localFontMetrics.ascent <= paramInt);
        }
    }

    public static int getFitTextSizeByHeight2(int paramInt1, int paramInt2, int paramInt3) {
        TextPaint localTextPaint = new TextPaint();
        for (int i = 30; ; i--) {
            int j;
            if (i <= 0) {
                j = 10;
            }
            do {
                return j;
                localTextPaint.setTextSize(i);
                Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
                if (localFontMetrics.descent - localFontMetrics.ascent > paramInt2) {
                    break;
                }
                j = i;
            } while (localTextPaint.measureText("��") <= paramInt1 / paramInt3);
        }
    }

    public static int getFitTextSizeByWidth(int paramInt) {
        TextPaint localTextPaint = new TextPaint();
        for (int i = 30; ; i--) {
            int j;
            if (i <= 0) {
                j = 10;
            }
            do {
                return j;
                localTextPaint.setTextSize(i);
                j = i;
            } while (localTextPaint.measureText("��") <= paramInt);
        }
    }

    public static int getFullMonths(Date paramDate1, Date paramDate2) {
        Calendar localCalendar = DateUtils.calendarInstance();
        localCalendar.setTime(paramDate1);
        int i = localCalendar.get(1);
        int j = localCalendar.get(5);
        int k = localCalendar.get(2) + 1;
        localCalendar.setTime(paramDate2);
        int m = localCalendar.get(1);
        int n = localCalendar.get(5);
        int i1 = localCalendar.get(2) + 1;
        if (j == n) {
            if (i == m) {
                if (i1 - k <= 1) {
                    break label121;
                }
                i = i1 - k;
            }
        }
        for (; ; ) {
            return i;
            if (m - i == 1) {
                j = i1 + 12 - k;
                i = j;
                if (j < 12) {
                }
            } else {
                label121:
                i = -1;
            }
        }
    }

    public static String getIMEI(Context paramContext) {
        Object localObject = null;
        TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
        paramContext = (Context) localObject;
        if (localTelephonyManager != null) {
            paramContext = localTelephonyManager.getDeviceId();
        }
        return paramContext;
    }

    public static int[] getImageSize(String paramString, boolean paramBoolean) {
        int[] arrayOfInt = new int[2];
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        arrayOfInt[0] = localOptions.outWidth;
        arrayOfInt[1] = localOptions.outHeight;
        if (paramBoolean) {
            localObject = null;
        }
        try {
            ExifInterface localExifInterface = new android / media / ExifInterface;
            localExifInterface.<init> (paramString);
            paramString = localExifInterface;
        } catch (IOException paramString) {
            for (; ; ) {
                int i;
                paramString.printStackTrace();
                paramString = (String) localObject;
            }
        }
        if (paramString != null) {
            i = paramString.getAttributeInt("Orientation", 0);
            if ((i == 6) || (i == 8)) {
                arrayOfInt[0] = localOptions.outHeight;
                arrayOfInt[1] = localOptions.outWidth;
            }
        }
        return arrayOfInt;
    }

    public static boolean getLatLong(String paramString, float[] paramArrayOfFloat) {
        boolean bool1 = false;
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {
            return bool1;
            try {
                ExifInterface localExifInterface = new android / media / ExifInterface;
                localExifInterface.<init> (paramString);
                boolean bool2 = localExifInterface.getLatLong(paramArrayOfFloat);
                bool1 = bool2;
            } catch (Exception paramString) {
                paramString.printStackTrace();
            }
        }
    }

    public static String getLocalIpAddress() {
        try {
            localEnumeration = NetworkInterface.getNetworkInterfaces();
            if (localEnumeration.hasMoreElements()) {
            }
        } catch (SocketException localSocketException) {
            for (; ; ) {
                Enumeration localEnumeration;
                Object localObject;
                InetAddress localInetAddress;
                Log.e("WifiPreference IpAddress", localSocketException.toString());
            }
        }
        for (localObject = null; ; localObject = localInetAddress.getHostAddress().toString()) {
            return (String) localObject;
            localObject = ((NetworkInterface) localEnumeration.nextElement()).getInetAddresses();
            do {
                if (!((Enumeration) localObject).hasMoreElements()) {
                    break;
                }
                localInetAddress = (InetAddress) ((Enumeration) localObject).nextElement();
            } while (localInetAddress.isLoopbackAddress());
        }
    }

    public static String getMacAddress(Context paramContext) {
        Object localObject = null;
        WifiInfo localWifiInfo = ((WifiManager) paramContext.getSystemService("wifi")).getConnectionInfo();
        paramContext = (Context) localObject;
        if (localWifiInfo != null) {
            paramContext = localWifiInfo.getMacAddress();
        }
        return paramContext;
    }

    public static int getMaxPhotoWidth() {
        return BTEngine.singleton().getConfig().getMaxPhotoWidth();
    }

    public static int getMaxVideoBitrate() {
        return BTEngine.singleton().getConfig().getMaxVideoBitrate();
    }

    public static int getMaxVideoBitrateSoft() {
        return BTEngine.singleton().getConfig().getMaxVideoBitrateSoft();
    }

    public static int getMaxVideoDuration() {
        return BTEngine.singleton().getConfig().getMaxVideoDuration();
    }

    public static int getMaxVideoHeight() {
        return BTEngine.singleton().getConfig().getMaxVideoHeight();
    }

    public static int getMaxVideoWidth() {
        return BTEngine.singleton().getConfig().getMaxVideoWidth();
    }

    public static int getMediaType(String paramString) {
        int i;
        if ((paramString == null) || (paramString.equals(""))) {
            i = 0;
        }
        for (; ; ) {
            return i;
            int j = 0;
            i = j;
            if (!TextUtils.isEmpty(getFileType(paramString))) {
                paramString = getFileType(paramString).toLowerCase();
                i = j;
                if (paramString != null) {
                    if ((".jpg".equals(paramString)) || (".bmp".equals(paramString)) || (".png".equals(paramString)) || (".gif".equals(paramString)) || (".jpeg".equals(paramString))) {
                        i = 1;
                    } else if ((".mp4".equals(paramString)) || (".3gpp".equals(paramString))) {
                        i = 3;
                    } else if ((!".mp3".equals(paramString)) && (!".m4a".equals(paramString)) && (!".aac".equals(paramString))) {
                        i = j;
                        if (!".amr".equals(paramString)) {
                        }
                    } else {
                        i = 2;
                    }
                }
            }
        }
    }

    public static float[] getMesuredWH(String paramString, int paramInt) {
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(paramInt);
        float f = localTextPaint.measureText(paramString);
        paramString = localTextPaint.getFontMetrics();
        return new float[]{f, paramString.descent - paramString.ascent};
    }

    public static String getMimeType(String paramString) {
        paramString = getExtension(paramString);
        if ((paramString != null) && (paramString.length() > 0)) {
            paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString.substring(1));
            if (paramString == null) {
            }
        }
        for (; ; ) {
            return paramString;
            paramString = "*/*";
        }
    }

    public static Long getMonthEndTime(int paramInt1, int paramInt2) {
        Long localLong;
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
            localLong = null;
        }
        for (; ; ) {
            return localLong;
            if (paramInt2 == 12) {
                paramInt2 = paramInt1 + 1;
            }
            for (paramInt1 = 1; ; paramInt1 = i) {
                localLong = null;
                try {
                    if (getMonthStartTime(paramInt2, paramInt1) == null) {
                        break;
                    }
                    long l = getMonthStartTime(paramInt2, paramInt1).longValue();
                    localLong = Long.valueOf(l - 1L);
                } catch (Exception localException) {
                    int i;
                    Object localObject = null;
                }
                i = paramInt2 + 1;
                paramInt2 = paramInt1;
            }
        }
    }

    public static Long getMonthStartTime(int paramInt1, int paramInt2) {
        Long localLong;
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
            localLong = null;
        }
        for (; ; ) {
            return localLong;
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.set(1, paramInt1);
            localCalendar.set(2, paramInt2 - 1);
            localCalendar.set(5, 1);
            localCalendar.set(11, 0);
            localCalendar.set(12, 0);
            localCalendar.set(13, 0);
            localCalendar.set(14, 0);
            localLong = null;
            try {
                long l = localCalendar.getTime().getTime();
                localLong = Long.valueOf(l);
            } catch (Exception localException) {
            }
        }
    }

    public static int getNavBarHeight(Context paramContext) {
        k = 0;
        for (; ; ) {
            try {
                localResources = paramContext.getResources();
                i = paramContext.getResources().getConfiguration().orientation;
                if (!isTablet(paramContext)) {
                    continue;
                }
                if (i != 1) {
                    continue;
                }
                str = "navigation_bar_height";
                j = localResources.getIdentifier(str, "dimen", "android");
                i = k;
                if (j > 0) {
                    i = paramContext.getResources().getDimensionPixelSize(j);
                }
            } catch (Exception paramContext) {
                Resources localResources;
                String str;
                int j;
                int i = k;
                continue;
            }
            return i;
            str = "navigation_bar_height_landscape";
        }
        if (i == 1) {
        }
        for (str = "navigation_bar_height"; ; str = "navigation_bar_width") {
            j = localResources.getIdentifier(str, "dimen", "android");
            break;
        }
    }

    public static int getNetworkType(Context paramContext) {
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext == null) {
                break label32;
            }
            paramContext = paramContext.getActiveNetworkInfo();
            if (paramContext == null) {
                break label32;
            }
            i = paramContext.getType();
        } catch (Exception paramContext) {
            for (; ; ) {
                int i = -1;
            }
        } catch (SecurityException paramContext) {
            for (; ; ) {
            }
        } catch (NoSuchMethodError paramContext) {
            label32:
            for (; ; ) {
            }
        }
        return i;
    }

    public static String getParentPath(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            paramString = new File("/");
        }
        for (; ; ) {
            return paramString.toString();
            File localFile = new File(paramString).getParentFile();
            paramString = localFile;
            if (localFile == null) {
                paramString = new File("/");
            }
        }
    }

    public static File getRealFileName(String paramString1, String paramString2) {
        String[] arrayOfString = paramString2.split("/");
        paramString1 = new File(paramString1);
        int i;
        if (arrayOfString.length > 1) {
            i = 0;
            if (i >= arrayOfString.length - 1) {
                if (!paramString1.exists()) {
                    paramString1.mkdirs();
                }
                paramString2 = arrayOfString[(arrayOfString.length - 1)];
            }
            try {
                str = new java / lang / String;
                str.<init> (paramString2.getBytes("8859_1"), "GB2312");
                paramString2 = str;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                for (; ; ) {
                    String str;
                    localUnsupportedEncodingException2.printStackTrace();
                }
            }
            paramString1 = new File(paramString1, paramString2);
        }
        for (; ; ) {
            return paramString1;
            paramString2 = arrayOfString[i];
            try {
                str = new java / lang / String;
                str.<init> (paramString2.getBytes("8859_1"), "GB2312");
                paramString2 = str;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
                for (; ; ) {
                    localUnsupportedEncodingException1.printStackTrace();
                }
            }
            paramString1 = new File(paramString1, paramString2);
            i++;
            break;
        }
    }

    public static String getRedirect(String paramString) {
        Object localObject = null;
        try {
            URL localURL = new java / net / URL;
            localURL.<init> (paramString);
            paramString = (HttpURLConnection) localURL.openConnection();
            paramString.setInstanceFollowRedirects(false);
            paramString.setRequestMethod("GET");
            paramString.setConnectTimeout(5000);
            paramString.connect();
            paramString = paramString.getHeaderField("location");
            return paramString;
        } catch (MalformedURLException paramString) {
            for (; ; ) {
                paramString = (String) localObject;
            }
        } catch (IOException paramString) {
            for (; ; ) {
                paramString = (String) localObject;
            }
        }
    }

    public static String getRedirectUrl(String paramString) {
        Object localObject1;
        if (TextUtils.isEmpty(paramString)) {
            localObject1 = null;
        }
        label42:
        label47:
        do {
            Object localObject2;
            for (; ; ) {
                return (String) localObject1;
                for (int i = 0; ; i++) {
                    localObject2 = null;
                    localObject1 = localObject2;
                    if (i >= 5) {
                        break;
                    }
                    if (!TextUtils.isEmpty(null)) {
                        break label47;
                    }
                    if (TextUtils.isEmpty(null)) {
                        break label42;
                    }
                }
                localObject1 = paramString;
            }
            localObject1 = localObject2;
        } while (TextUtils.isEmpty(null));
        throw new NullPointerException();
    }

    public static List<String> getReplyNameList(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        Type localType;
        for (paramString = null; ; paramString = (List) GsonUtil.createGson().fromJson(paramString, localType)) {
            return paramString;
            localType = new TypeToken() {
            }.getType();
        }
    }

    public static long getRomAvailableSize() {
        try {
            File localFile = Environment.getDataDirectory();
            if (localFile == null) {
                break label48;
            }
            StatFs localStatFs = new android / os / StatFs;
            localStatFs.<init> (localFile.getPath());
            if (localStatFs == null) {
                break label48;
            }
            l = localStatFs.getBlockSize();
            int i = localStatFs.getAvailableBlocks();
            l *= i;
        } catch (Exception localException) {
            for (; ; ) {
                label48:
                long l = 0L;
            }
        }
        return l;
    }

    public static long getRomTotalSize() {
        try {
            File localFile = Environment.getDataDirectory();
            if (localFile == null) {
                break label48;
            }
            StatFs localStatFs = new android / os / StatFs;
            localStatFs.<init> (localFile.getPath());
            if (localStatFs == null) {
                break label48;
            }
            l = localStatFs.getBlockSize();
            int i = localStatFs.getBlockCount();
            l *= i;
        } catch (Exception localException) {
            for (; ; ) {
                label48:
                long l = 0L;
            }
        }
        return l;
    }

    public static Bitmap getRoundCornerBitmap(Bitmap paramBitmap, int paramInt)
            throws OutOfMemoryException {
        Object localObject3;
        if (paramBitmap == null) {
            localObject3 = null;
        }
        for (; ; ) {
            return (Bitmap) localObject3;
            try {
                Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                localObject3 = localBitmap;
                if (localBitmap == null) {
                    continue;
                }
                Canvas localCanvas = new Canvas(localBitmap);
                int i = paramBitmap.getWidth();
                int j = paramBitmap.getHeight();
                localObject3 = new Paint();
                Rect localRect = new Rect(0, 0, i, j);
                RectF localRectF = new RectF(localRect);
                float f = paramInt;
                ((Paint) localObject3).setAntiAlias(true);
                localCanvas.drawARGB(0, 0, 0, 0);
                ((Paint) localObject3).setColor(-12434878);
                localCanvas.drawRoundRect(localRectF, f, f, (Paint) localObject3);
                ((Paint) localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                localCanvas.drawBitmap(paramBitmap, localRect, localRect, (Paint) localObject3);
                localObject3 = localBitmap;
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    Object localObject1 = null;
                }
            } catch (OutOfMemoryError paramBitmap) {
                throw new OutOfMemoryException(paramBitmap.getMessage());
            } catch (StackOverflowError localStackOverflowError) {
                for (; ; ) {
                    localStackOverflowError.printStackTrace();
                    Object localObject2 = null;
                }
            }
        }
    }

    public static long getSDAvailableStore() {
        long l = -1L;
        if (isSDCardValid()) {
            StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            l = localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
        }
        return l;
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static float getSimilarRatioOfString(String paramString1, String paramString2) {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        }
        for (float f = 0.0F; ; f = 1.0F - compare(paramString1, paramString2) / Math.max(paramString1.length(), paramString2.length())) {
            return f;
        }
    }

    public static int getStatusBarHeight(Context paramContext) {
        int i = 0;
        try {
            Class localClass = Class.forName("com.android.internal.R$dimen");
            Object localObject = localClass.newInstance();
            int j = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
            j = paramContext.getResources().getDimensionPixelSize(j);
            i = j;
        } catch (Exception paramContext) {
            for (; ; ) {
                paramContext.printStackTrace();
            }
        }
        return i;
    }

    public static boolean getVideoClipHWSupport() {
        return BTEngine.singleton().getConfig().getVideoClipHWSupport();
    }

    public static long getWeekFromBirth(Date paramDate) {
        if (paramDate == null) {
        }
        Calendar localCalendar1;
        Calendar localCalendar2;
        for (long l = 0L; ; l = ((int) ((getCustomTimeInMillis(new Date(), 0, 0, 0, 0) - getCustomTimeInMillis(paramDate, 0, 0, 0, 0)) / 1000L / 60L / 60L / 24L) + 1) / 7 - 1) {
            return l;
            l = getCustomTimeInMillis(paramDate, 0, 0, 0, 0);
            localCalendar1 = Calendar.getInstance();
            localCalendar1.setTimeInMillis(l);
            l = getCustomTimeInMillis(new Date(), 0, 0, 0, 0);
            localCalendar2 = Calendar.getInstance();
            localCalendar2.setTimeInMillis(l);
            l = localCalendar1.getTimeInMillis();
            if (localCalendar2.getTimeInMillis() - l >= 0L) {
                break;
            }
        }
        int k = localCalendar2.get(5) - localCalendar1.get(5);
        int m = localCalendar2.get(2) - localCalendar1.get(2);
        int n = localCalendar2.get(1) - localCalendar1.get(1);
        int i = k;
        int j = m;
        if (k < 0) {
            j = m - 1;
            localCalendar2.add(2, -1);
            if (localCalendar2.getActualMaximum(5) <= localCalendar1.get(5)) {
                break label282;
            }
        }
        label282:
        for (i = localCalendar2.getActualMaximum(5) - localCalendar1.get(5) + localCalendar2.get(5); ; i = localCalendar2.get(5)) {
            m = j;
            k = n;
            if (j < 0) {
                m = (j + 12) % 12;
                k = n - 1;
            }
            l = i / 7 + m * 4 + k * 12 * 4;
            break;
        }
    }

    public static boolean hasNewVersion(Context paramContext) {
        Config localConfig = BTEngine.singleton().getConfig();
        boolean bool2 = false;
        paramContext = localConfig.getUpdateVersionItem();
        boolean bool1 = bool2;
        if (paramContext != null) {
            bool1 = bool2;
            if (paramContext.getLastVersionCode() > localConfig.getVersionCode()) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public static boolean hasStorage(boolean paramBoolean) {
        boolean bool = true;
        String str = Environment.getExternalStorageState();
        if ("mounted".equals(str)) {
            if (!paramBoolean) {
            }
        }
        for (bool = checkFsWritable(); ; bool = false) {
            do {
                return bool;
            } while ((!paramBoolean) && ("mounted_ro".equals(str)));
        }
    }

    public static void installApk(Context paramContext, File paramFile) {
        try {
            Intent localIntent = new android / content / Intent;
            localIntent.<init> ("android.intent.action.VIEW");
            localIntent.setFlags(268435456);
            localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
            paramContext.startActivity(localIntent);
            return;
        } catch (Exception paramContext) {
            for (; ; ) {
            }
        }
    }

    public static boolean is2GNetwork(Context paramContext) {
        boolean bool2 = true;
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext == null) {
                break label84;
            }
            paramContext = paramContext.getActiveNetworkInfo();
            if ((paramContext == null) || (paramContext.getType() != 0)) {
                break label84;
            }
            int i = paramContext.getSubtype();
            bool1 = bool2;
            if (i != 1) {
                bool1 = bool2;
                if (i != 2) {
                    bool1 = bool2;
                    if (i != 4) {
                        bool1 = bool2;
                        if (i != 7) {
                            bool1 = bool2;
                            if (i != 11) {
                                if (i != 0) {
                                    break label84;
                                }
                                bool1 = bool2;
                            }
                        }
                    }
                }
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                boolean bool1 = false;
            }
        } catch (SecurityException paramContext) {
            for (; ; ) {
            }
        } catch (NoSuchMethodError paramContext) {
            for (; ; ) {
            }
        }
        return bool1;
    }

    public static boolean is3GNetwork(Context paramContext) {
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext == null) {
                break label99;
            }
            paramContext = paramContext.getActiveNetworkInfo();
            if ((paramContext == null) || (paramContext.getType() != 0)) {
                break label99;
            }
            int i = paramContext.getSubtype();
            if ((i != 5) && (i != 6) && (i != 12) && (i != 8) && (i != 10) && (i != 9) && (i != 15) && (i != 3) && (i != 14) && (i != 13)) {
                break label99;
            }
            bool = true;
        } catch (Exception paramContext) {
            for (; ; ) {
                boolean bool = false;
            }
        } catch (SecurityException paramContext) {
            for (; ; ) {
            }
        } catch (NoSuchMethodError paramContext) {
            label99:
            for (; ; ) {
            }
        }
        return bool;
    }

    public static boolean isCantPlayVideo(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
        }
        for (int i = 0; ; i++) {
            if (i >= DO_NOY_PLAY_VIDEO_DEVICES.length) {
            }
            for (boolean bool = false; ; bool = true) {
                return bool;
                if (!paramString.equals(DO_NOY_PLAY_VIDEO_DEVICES[i])) {
                    break;
                }
            }
        }
    }

    public static boolean isDueDate(Date paramDate) {
        boolean bool = false;
        if (paramDate == null) {
        }
        for (; ; ) {
            return bool;
            if (getCustomTimeInMillis(paramDate, 0, 0, 0, 0) > getCustomTimeInMillis(new Date(), 0, 0, 0, 0)) {
                bool = true;
            }
        }
    }

    public static boolean isEmoji(String paramString) {
        if ((paramString == null) || (paramString.length() <= 0)) {
            bool = false;
            return bool;
        }
        int i = paramString.length();
        int j = paramString.codePointCount(0, i);
        if ((i <= 1) || (i == j)) {
        }
        for (boolean bool = false; ; bool = true) {
            break;
        }
    }

    public static boolean isEqual(List<StickerData> paramList1, List<StickerData> paramList2) {
        ArrayList localArrayList;
        int i;
        label38:
        boolean bool;
        if (paramList1.size() == paramList2.size()) {
            localArrayList = new ArrayList();
            i = 0;
            if (i >= paramList1.size()) {
                i = 0;
                if (i < paramList2.size()) {
                    break label82;
                }
                bool = true;
            }
        }
        for (; ; ) {
            return bool;
            localArrayList.add(Long.valueOf(((StickerData) paramList1.get(i)).spId));
            i++;
            break;
            label82:
            if (!localArrayList.contains(Long.valueOf(((StickerData) paramList2.get(i)).spId))) {
                bool = false;
            } else {
                i++;
                break label38;
                bool = false;
            }
        }
    }

    public static boolean isFileExist(String paramString) {
        return new File(paramString).exists();
    }

    public static boolean isGIF(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
        }
        String str;
        for (boolean bool = false; ; bool = ".gif".equalsIgnoreCase(str)) {
            return bool;
            str = null;
            int i = paramString.lastIndexOf(".");
            if (i != -1) {
                str = paramString.substring(i);
            }
        }
    }

    public static boolean isInvaildPassword(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
        }
        for (boolean bool = true; ; bool = paramString.matches("^(\\s|.*\\s+.*)$")) {
            return bool;
        }
    }

    public static boolean isLastYear(Date paramDate) {
        boolean bool = false;
        if (paramDate == null) {
            bool = false;
        }
        for (; ; ) {
            return bool;
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.setTime(new Date());
            int i = localCalendar.get(1);
            localCalendar.setTime(paramDate);
            if (i != localCalendar.get(1)) {
                bool = true;
            }
        }
    }

    public static boolean isPunctuation(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
        }
        for (boolean bool = false; ; bool = paramString.matches("(?i)[^a-zA-Z0-9��-��]")) {
            return bool;
        }
    }

    public static boolean isSDCardValid() {
        return hasStorage(true);
    }

    public static boolean isSpecLetter(String paramString) {
        boolean bool = true;
        if (Pattern.compile("[a-zA-Z��:=�������������������� ]").matcher(paramString).find()) {
        }
        for (; ; ) {
            return bool;
            if (!paramString.equals("\"")) {
                bool = false;
            }
        }
    }

    private static boolean isTablet(Context paramContext) {
        if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public static boolean isTheSameDay(long paramLong1, long paramLong2) {
        boolean bool = true;
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(paramLong1);
        int k = localCalendar.get(1);
        int j = localCalendar.get(2);
        int i = localCalendar.get(5);
        localCalendar.setTimeInMillis(paramLong2);
        if ((k == localCalendar.get(1)) && (j == localCalendar.get(2)) && (i == localCalendar.get(5))) {
        }
        for (; ; ) {
            return bool;
            bool = false;
        }
    }

    public static boolean isVaildEmail(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
        }
        for (boolean bool = false; ; bool = Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", paramString)) {
            return bool;
        }
    }

    public static boolean isVaildNum(String paramString) {
        return Pattern.matches("^[0-9]*$", paramString);
    }

    public static boolean isVaildPhonum(String paramString) {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("13")) || (paramString.startsWith("15")) || (paramString.startsWith("18")) || (paramString.startsWith("17"))) && (paramString.length() == 11)) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public static boolean isVaildUsername(String paramString) {
        if ((!isVaildEmail(paramString)) && (!isVaildPhonum(paramString))) {
        }
        for (boolean bool = false; ; bool = true) {
            return bool;
        }
    }

    public static boolean isValidImage(String paramString) {
        boolean bool2 = false;
        boolean bool1;
        if (!new File(paramString).exists()) {
            bool1 = bool2;
        }
        for (; ; ) {
            return bool1;
            paramString = getImageSize(paramString, false);
            bool1 = bool2;
            if (paramString[0] > 0) {
                bool1 = bool2;
                if (paramString[1] > 0) {
                    bool1 = true;
                }
            }
        }
    }

    public static void launcherApp(Context paramContext, String paramString) {
        Object localObject1 = paramContext.getPackageManager();
        try {
            Object localObject2 = ((PackageManager) localObject1).getPackageInfo(paramString, 0);
            paramString = new android / content / Intent;
            paramString.<init> ("android.intent.action.MAIN", null);
            paramString.addCategory("android.intent.category.LAUNCHER");
            paramString.setPackage(((PackageInfo) localObject2).packageName);
            localObject1 = (ResolveInfo) ((PackageManager) localObject1).queryIntentActivities(paramString, 0).iterator().next();
            if (localObject1 != null) {
                paramString = ((ResolveInfo) localObject1).activityInfo.packageName;
                localObject1 = ((ResolveInfo) localObject1).activityInfo.name;
                Intent localIntent = new android / content / Intent;
                localIntent.<init> ("android.intent.action.MAIN");
                localIntent.addCategory("android.intent.category.LAUNCHER");
                localObject2 = new android / content / ComponentName;
                ((ComponentName) localObject2).<init> (paramString, (String) localObject1);
                localIntent.setComponent((ComponentName) localObject2);
                paramContext.startActivity(localIntent);
            }
            return;
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                Log.e("com.dw.btime", "package do not installed");
            }
        } catch (ActivityNotFoundException paramContext) {
            for (; ; ) {
                Log.e("com.dw.btime", "activity do not exist");
            }
        }
    }

    public static Bitmap loadBitmap(String paramString)
            throws OutOfMemoryException {
        Object localObject1 = getFileType(paramString);
        boolean bool;
        Object localObject2;
        if ((localObject1 != null) && (((String) localObject1).equalsIgnoreCase(".png"))) {
            bool = true;
            localObject2 = createNativeAllocOptions(bool);
            localObject1 = null;
        }
        try {
            localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options) localObject2);
            localObject1 = localObject2;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        } catch (OutOfMemoryError paramString) {
            throw new OutOfMemoryException(paramString.getMessage());
        } catch (StackOverflowError localStackOverflowError) {
            for (; ; ) {
                localStackOverflowError.printStackTrace();
            }
            localObject3 = null;
        }
        if (localObject1 == null) {
            paramString = (String) localObject1;
        }
        for (; ; ) {
            return paramString;
            bool = false;
            break;
            try {
                ExifInterface localExifInterface = new android / media / ExifInterface;
                localExifInterface.<init> (paramString);
                localObject3 = localExifInterface;
            } catch (IOException paramString) {
                for (; ; ) {
                    Object localObject3;
                    int i;
                    int j;
                    paramString.printStackTrace();
                    continue;
                    if (j == 6) {
                        i = 90;
                    } else if (j == 8) {
                        i = 270;
                    }
                }
            }
            i = 0;
            paramString = (String) localObject1;
            if (localObject3 != null) {
                j = ((ExifInterface) localObject3).getAttributeInt("Orientation", 0);
                if (j != 3) {
                    break label165;
                }
                i = 180;
                paramString = (String) localObject1;
                if (i > 0) {
                    paramString = rotate((Bitmap) localObject1, i);
                }
            }
        }
    }

    /* Error */
    public static Bitmap loadFitInBitmap(String paramString, int paramInt1, int paramInt2)
            throws OutOfMemoryException {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 698	com/dw/bcamera/util/Utils:getFileType	(Ljava/lang/String;)Ljava/lang/String;
        //   4: astore 11
        //   6: aload 11
        //   8: ifnull +57 -> 65
        //   11: aload 11
        //   13: ldc_w 700
        //   16: invokevirtual 703	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   19: ifeq +46 -> 65
        //   22: iconst_1
        //   23: istore 10
        //   25: iload 10
        //   27: invokestatic 707	com/dw/bcamera/util/Utils:createNativeAllocOptions	(Z)Landroid/graphics/BitmapFactory$Options;
        //   30: astore 13
        //   32: aload 13
        //   34: iconst_1
        //   35: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   38: aload_0
        //   39: aload 13
        //   41: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   44: pop
        //   45: aload 13
        //   47: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   50: ifle +11 -> 61
        //   53: aload 13
        //   55: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   58: ifgt +13 -> 71
        //   61: aconst_null
        //   62: astore_0
        //   63: aload_0
        //   64: areturn
        //   65: iconst_0
        //   66: istore 10
        //   68: goto -43 -> 25
        //   71: aconst_null
        //   72: astore 11
        //   74: new 607	android/media/ExifInterface
        //   77: astore 12
        //   79: aload 12
        //   81: aload_0
        //   82: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   85: aload 12
        //   87: astore 11
        //   89: iconst_0
        //   90: istore 8
        //   92: aload 13
        //   94: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   97: istore 7
        //   99: aload 13
        //   101: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   104: istore 6
        //   106: iload 8
        //   108: istore_3
        //   109: iload 7
        //   111: istore 4
        //   113: iload 6
        //   115: istore 5
        //   117: aload 11
        //   119: ifnull +32 -> 151
        //   122: aload 11
        //   124: ldc_w 652
        //   127: iconst_0
        //   128: invokevirtual 729	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
        //   131: istore 9
        //   133: iload 9
        //   135: iconst_3
        //   136: if_icmpne +129 -> 265
        //   139: sipush 180
        //   142: istore_3
        //   143: iload 6
        //   145: istore 5
        //   147: iload 7
        //   149: istore 4
        //   151: iload 5
        //   153: iload 4
        //   155: iload_1
        //   156: iload_2
        //   157: invokestatic 735	com/dw/bcamera/util/Utils:getFitInSize	(IIII)[I
        //   160: astore 11
        //   162: aload 11
        //   164: iconst_0
        //   165: iaload
        //   166: istore_1
        //   167: aload 11
        //   169: iconst_1
        //   170: iaload
        //   171: istore_2
        //   172: iload 4
        //   174: i2d
        //   175: iload_2
        //   176: i2d
        //   177: ddiv
        //   178: invokestatic 741	java/lang/Math:floor	(D)D
        //   181: d2i
        //   182: istore 4
        //   184: iload 5
        //   186: i2d
        //   187: iload_1
        //   188: i2d
        //   189: ddiv
        //   190: invokestatic 741	java/lang/Math:floor	(D)D
        //   193: d2i
        //   194: istore 5
        //   196: aload 13
        //   198: iload 4
        //   200: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   203: aload 13
        //   205: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   208: iload 5
        //   210: if_icmpge +10 -> 220
        //   213: aload 13
        //   215: iload 5
        //   217: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   220: aload 13
        //   222: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   225: iconst_1
        //   226: if_icmpge +9 -> 235
        //   229: aload 13
        //   231: iconst_1
        //   232: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   235: aload 13
        //   237: iconst_0
        //   238: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   241: aload_0
        //   242: aload 13
        //   244: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   247: astore_0
        //   248: aload_0
        //   249: ifnonnull +115 -> 364
        //   252: goto -189 -> 63
        //   255: astore 12
        //   257: aload 12
        //   259: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   262: goto -173 -> 89
        //   265: iload 9
        //   267: bipush 6
        //   269: if_icmpne +23 -> 292
        //   272: bipush 90
        //   274: istore_3
        //   275: aload 13
        //   277: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   280: istore 4
        //   282: aload 13
        //   284: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   287: istore 5
        //   289: goto -138 -> 151
        //   292: iload 8
        //   294: istore_3
        //   295: iload 7
        //   297: istore 4
        //   299: iload 6
        //   301: istore 5
        //   303: iload 9
        //   305: bipush 8
        //   307: if_icmpne -156 -> 151
        //   310: sipush 270
        //   313: istore_3
        //   314: aload 13
        //   316: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   319: istore 4
        //   321: aload 13
        //   323: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   326: istore 5
        //   328: goto -177 -> 151
        //   331: astore_0
        //   332: aload_0
        //   333: invokevirtual 363	java/lang/Exception:printStackTrace	()V
        //   336: aconst_null
        //   337: astore_0
        //   338: goto -90 -> 248
        //   341: astore_0
        //   342: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   345: dup
        //   346: aload_0
        //   347: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   350: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   353: athrow
        //   354: astore_0
        //   355: aload_0
        //   356: invokevirtual 1190	java/lang/StackOverflowError:printStackTrace	()V
        //   359: aconst_null
        //   360: astore_0
        //   361: goto -113 -> 248
        //   364: iload_3
        //   365: bipush 90
        //   367: if_icmpeq +16 -> 383
        //   370: iload_1
        //   371: istore 5
        //   373: iload_2
        //   374: istore 4
        //   376: iload_3
        //   377: sipush 270
        //   380: if_icmpne +9 -> 389
        //   383: iload_1
        //   384: istore 4
        //   386: iload_2
        //   387: istore 5
        //   389: aload_0
        //   390: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   393: istore_2
        //   394: aload_0
        //   395: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   398: istore_1
        //   399: iload_2
        //   400: iload 5
        //   402: if_icmpgt +29 -> 431
        //   405: iload_1
        //   406: iload 4
        //   408: if_icmpgt +23 -> 431
        //   411: aload_0
        //   412: astore 11
        //   414: iload_3
        //   415: ifle +10 -> 425
        //   418: aload_0
        //   419: iload_3
        //   420: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   423: astore 11
        //   425: aload 11
        //   427: astore_0
        //   428: goto -365 -> 63
        //   431: aconst_null
        //   432: astore 12
        //   434: aconst_null
        //   435: astore 11
        //   437: aload_0
        //   438: iload 5
        //   440: iload 4
        //   442: iconst_1
        //   443: invokestatic 752	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
        //   446: astore 13
        //   448: aload 13
        //   450: astore 11
        //   452: aload 13
        //   454: aload_0
        //   455: if_acmpeq +19 -> 474
        //   458: aload 13
        //   460: astore 11
        //   462: aload 13
        //   464: astore 12
        //   466: aload_0
        //   467: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   470: aload 13
        //   472: astore 11
        //   474: aload 11
        //   476: astore_0
        //   477: iload_3
        //   478: ifle -415 -> 63
        //   481: aload 11
        //   483: iload_3
        //   484: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   487: astore_0
        //   488: goto -425 -> 63
        //   491: astore_0
        //   492: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   495: dup
        //   496: aload_0
        //   497: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   500: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   503: athrow
        //   504: astore_0
        //   505: aload_0
        //   506: invokevirtual 1190	java/lang/StackOverflowError:printStackTrace	()V
        //   509: goto -35 -> 474
        //   512: astore_0
        //   513: aload 12
        //   515: astore 11
        //   517: goto -43 -> 474
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	520	0	paramString	String
        //   0	520	1	paramInt1	int
        //   0	520	2	paramInt2	int
        //   108	376	3	i	int
        //   111	330	4	j	int
        //   115	324	5	k	int
        //   104	196	6	m	int
        //   97	199	7	n	int
        //   90	203	8	i1	int
        //   131	177	9	i2	int
        //   23	44	10	bool	boolean
        //   4	512	11	localObject1	Object
        //   77	9	12	localExifInterface	ExifInterface
        //   255	3	12	localIOException	IOException
        //   432	82	12	localObject2	Object
        //   30	441	13	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   74	85	255	java/io/IOException
        //   241	248	331	java/lang/Exception
        //   241	248	341	java/lang/OutOfMemoryError
        //   241	248	354	java/lang/StackOverflowError
        //   437	448	491	java/lang/OutOfMemoryError
        //   466	470	491	java/lang/OutOfMemoryError
        //   437	448	504	java/lang/StackOverflowError
        //   466	470	504	java/lang/StackOverflowError
        //   437	448	512	java/lang/Exception
        //   466	470	512	java/lang/Exception
    }

    /* Error */
    public static Bitmap loadFitOutBitmap(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
            throws OutOfMemoryException {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 698	com/dw/bcamera/util/Utils:getFileType	(Ljava/lang/String;)Ljava/lang/String;
        //   4: astore 12
        //   6: aload 12
        //   8: ifnull +57 -> 65
        //   11: aload 12
        //   13: ldc_w 700
        //   16: invokevirtual 703	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   19: ifeq +46 -> 65
        //   22: iconst_1
        //   23: istore 11
        //   25: iload 11
        //   27: invokestatic 707	com/dw/bcamera/util/Utils:createNativeAllocOptions	(Z)Landroid/graphics/BitmapFactory$Options;
        //   30: astore 14
        //   32: aload 14
        //   34: iconst_1
        //   35: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   38: aload_0
        //   39: aload 14
        //   41: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   44: pop
        //   45: aload 14
        //   47: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   50: ifle +11 -> 61
        //   53: aload 14
        //   55: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   58: ifgt +13 -> 71
        //   61: aconst_null
        //   62: astore_0
        //   63: aload_0
        //   64: areturn
        //   65: iconst_0
        //   66: istore 11
        //   68: goto -43 -> 25
        //   71: aconst_null
        //   72: astore 12
        //   74: new 607	android/media/ExifInterface
        //   77: astore 13
        //   79: aload 13
        //   81: aload_0
        //   82: invokespecial 725	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
        //   85: aload 13
        //   87: astore 12
        //   89: iconst_0
        //   90: istore 9
        //   92: aload 14
        //   94: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   97: istore 8
        //   99: aload 14
        //   101: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   104: istore 7
        //   106: iload 9
        //   108: istore 4
        //   110: iload 8
        //   112: istore 5
        //   114: iload 7
        //   116: istore 6
        //   118: aload 12
        //   120: ifnull +33 -> 153
        //   123: aload 12
        //   125: ldc_w 652
        //   128: iconst_0
        //   129: invokevirtual 729	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
        //   132: istore 10
        //   134: iload 10
        //   136: iconst_3
        //   137: if_icmpne +136 -> 273
        //   140: sipush 180
        //   143: istore 4
        //   145: iload 7
        //   147: istore 6
        //   149: iload 8
        //   151: istore 5
        //   153: iload 6
        //   155: iload 5
        //   157: iload_1
        //   158: iload_2
        //   159: invokestatic 1878	com/dw/bcamera/util/Utils:getFitOutSize	(IIII)[I
        //   162: astore 12
        //   164: aload 12
        //   166: iconst_0
        //   167: iaload
        //   168: istore 7
        //   170: aload 12
        //   172: iconst_1
        //   173: iaload
        //   174: istore 8
        //   176: iload 5
        //   178: i2d
        //   179: iload 8
        //   181: i2d
        //   182: ddiv
        //   183: invokestatic 741	java/lang/Math:floor	(D)D
        //   186: d2i
        //   187: istore 5
        //   189: iload 6
        //   191: i2d
        //   192: iload 7
        //   194: i2d
        //   195: ddiv
        //   196: invokestatic 741	java/lang/Math:floor	(D)D
        //   199: d2i
        //   200: istore 6
        //   202: aload 14
        //   204: iload 5
        //   206: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   209: aload 14
        //   211: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   214: iload 6
        //   216: if_icmple +10 -> 226
        //   219: aload 14
        //   221: iload 6
        //   223: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   226: aload 14
        //   228: getfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   231: iconst_1
        //   232: if_icmpge +9 -> 241
        //   235: aload 14
        //   237: iconst_1
        //   238: putfield 744	android/graphics/BitmapFactory$Options:inSampleSize	I
        //   241: aload 14
        //   243: iconst_0
        //   244: putfield 712	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
        //   247: aload_0
        //   248: aload 14
        //   250: invokestatic 718	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   253: astore_0
        //   254: aload_0
        //   255: ifnonnull +120 -> 375
        //   258: aconst_null
        //   259: astore_0
        //   260: goto -197 -> 63
        //   263: astore 13
        //   265: aload 13
        //   267: invokevirtual 362	java/io/IOException:printStackTrace	()V
        //   270: goto -181 -> 89
        //   273: iload 10
        //   275: bipush 6
        //   277: if_icmpne +24 -> 301
        //   280: bipush 90
        //   282: istore 4
        //   284: aload 14
        //   286: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   289: istore 5
        //   291: aload 14
        //   293: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   296: istore 6
        //   298: goto -145 -> 153
        //   301: iload 9
        //   303: istore 4
        //   305: iload 8
        //   307: istore 5
        //   309: iload 7
        //   311: istore 6
        //   313: iload 10
        //   315: bipush 8
        //   317: if_icmpne -164 -> 153
        //   320: sipush 270
        //   323: istore 4
        //   325: aload 14
        //   327: getfield 724	android/graphics/BitmapFactory$Options:outWidth	I
        //   330: istore 5
        //   332: aload 14
        //   334: getfield 721	android/graphics/BitmapFactory$Options:outHeight	I
        //   337: istore 6
        //   339: goto -186 -> 153
        //   342: astore_0
        //   343: aload_0
        //   344: invokevirtual 363	java/lang/Exception:printStackTrace	()V
        //   347: aconst_null
        //   348: astore_0
        //   349: goto -95 -> 254
        //   352: astore_0
        //   353: new 250	com/dw/bcamera/engine/OutOfMemoryException
        //   356: dup
        //   357: aload_0
        //   358: invokevirtual 747	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
        //   361: invokespecial 748	com/dw/bcamera/engine/OutOfMemoryException:<init>	(Ljava/lang/String;)V
        //   364: athrow
        //   365: astore_0
        //   366: aload_0
        //   367: invokevirtual 1190	java/lang/StackOverflowError:printStackTrace	()V
        //   370: aconst_null
        //   371: astore_0
        //   372: goto -118 -> 254
        //   375: iload 4
        //   377: bipush 90
        //   379: if_icmpeq +17 -> 396
        //   382: iload_1
        //   383: istore 6
        //   385: iload_2
        //   386: istore 5
        //   388: iload 4
        //   390: sipush 270
        //   393: if_icmpne +9 -> 402
        //   396: iload_1
        //   397: istore 5
        //   399: iload_2
        //   400: istore 6
        //   402: aload_0
        //   403: invokevirtual 259	android/graphics/Bitmap:getHeight	()I
        //   406: istore_1
        //   407: aload_0
        //   408: invokevirtual 256	android/graphics/Bitmap:getWidth	()I
        //   411: istore_2
        //   412: iload_3
        //   413: ifne +37 -> 450
        //   416: iload_1
        //   417: iload 5
        //   419: if_icmpgt +31 -> 450
        //   422: iload_2
        //   423: iload 6
        //   425: if_icmpgt +25 -> 450
        //   428: aload_0
        //   429: astore 12
        //   431: iload 4
        //   433: ifle +11 -> 444
        //   436: aload_0
        //   437: iload 4
        //   439: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   442: astore 12
        //   444: aload 12
        //   446: astore_0
        //   447: goto -384 -> 63
        //   450: aload_0
        //   451: iload 6
        //   453: iload 5
        //   455: invokestatic 1880	com/dw/bcamera/util/Utils:getFitOutBitmap	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
        //   458: astore 12
        //   460: aload 12
        //   462: aload_0
        //   463: if_acmpeq +7 -> 470
        //   466: aload_0
        //   467: invokevirtual 395	android/graphics/Bitmap:recycle	()V
        //   470: aload 12
        //   472: astore_0
        //   473: iload 4
        //   475: ifle -412 -> 63
        //   478: aload 12
        //   480: iload 4
        //   482: invokestatic 756	com/dw/bcamera/util/Utils:rotate	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   485: astore_0
        //   486: goto -423 -> 63
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	489	0	paramString	String
        //   0	489	1	paramInt1	int
        //   0	489	2	paramInt2	int
        //   0	489	3	paramBoolean	boolean
        //   108	373	4	i	int
        //   112	342	5	j	int
        //   116	336	6	k	int
        //   104	206	7	m	int
        //   97	209	8	n	int
        //   90	212	9	i1	int
        //   132	186	10	i2	int
        //   23	44	11	bool	boolean
        //   4	475	12	localObject	Object
        //   77	9	13	localExifInterface	ExifInterface
        //   263	3	13	localIOException	IOException
        //   30	303	14	localOptions	BitmapFactory.Options
        // Exception table:
        //   from	to	target	type
        //   74	85	263	java/io/IOException
        //   247	254	342	java/lang/Exception
        //   247	254	352	java/lang/OutOfMemoryError
        //   247	254	365	java/lang/StackOverflowError
    }

    public static String makeDeviceInfo(Context paramContext) {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        HashMap localHashMap = new HashMap();
        localHashMap.put("os", "android");
        localHashMap.put("version", Build.VERSION.RELEASE);
        localHashMap.put("model", Build.MODEL);
        localHashMap.put("dw", localDisplayMetrics.widthPixels);
        localHashMap.put("dh", localDisplayMetrics.heightPixels);
        localHashMap.put("appVersion", getApkVersionName(paramContext, "com.dw.videoclipper"));
        return localHashMap.toString();
    }

    public static String mergeOwner(String paramString) {
        String str = "";
        if (!TextUtils.isEmpty(paramString)) {
            if (paramString.length() <= 5) {
                break label47;
            }
        }
        label47:
        for (str = paramString.substring(0, 5) + "..."; ; str = paramString) {
            return str;
        }
    }

    private static int min(int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt1 < paramInt2) {
            if (paramInt1 >= paramInt3) {
                break label17;
            }
        }
        for (; ; ) {
            return paramInt1;
            paramInt1 = paramInt2;
            break;
            label17:
            paramInt1 = paramInt3;
        }
    }

    public static boolean networkIsAvailable(Context paramContext) {
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext == null) {
                break label38;
            }
            paramContext = paramContext.getActiveNetworkInfo();
            if (paramContext == null) {
                break label38;
            }
            bool = paramContext.isAvailable();
            if (!bool) {
                break label38;
            }
            bool = true;
        } catch (Exception paramContext) {
            for (; ; ) {
                boolean bool = false;
            }
        } catch (NoSuchFieldError paramContext) {
            for (; ; ) {
            }
        } catch (SecurityException paramContext) {
            for (; ; ) {
            }
        } catch (NoSuchMethodError paramContext) {
            label38:
            for (; ; ) {
            }
        }
        return bool;
    }

    public static boolean networkIsAvailable(Context paramContext, int paramInt) {
        try {
            paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
            if (paramContext == null) {
                break label39;
            }
            paramContext = paramContext.getNetworkInfo(paramInt);
            if (paramContext == null) {
                break label39;
            }
            bool = paramContext.isAvailable();
            if (!bool) {
                break label39;
            }
            bool = true;
        } catch (Exception paramContext) {
            for (; ; ) {
                boolean bool = false;
            }
        } catch (SecurityException paramContext) {
            for (; ; ) {
            }
        } catch (NoSuchMethodError paramContext) {
            label39:
            for (; ; ) {
            }
        }
        return bool;
    }

    public static String paramURIDecode(String paramString) {
        try {
            paramString = URLDecoder.decode(URLDecoder.decode(paramString, "utf-8"), "utf-8");
            return paramString;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString = null;
            }
        }
    }

    public static String paramURIEncode(String paramString) {
        try {
            paramString = URLEncoder.encode(URLEncoder.encode(paramString, "utf-8"), "utf-8");
            return paramString;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString = null;
            }
        }
    }

    public static long parseModUpdate(String paramString1, String paramString2) {
        Gson localGson;
        Type localType;
        if (!TextUtils.isEmpty(paramString1)) {
            localGson = GsonUtil.createGson();
            localType = new TypeToken() {
            }.getType();
        }
        for (; ; ) {
            try {
                paramString1 = (HashMap) localGson.fromJson(paramString1, localType);
                if ((paramString1 != null) && (paramString1.containsKey(paramString2))) {
                    l = ((Long) paramString1.get(paramString2)).longValue();
                    return l;
                }
            } catch (Exception paramString1) {
                paramString1 = null;
                continue;
            }
            long l = 0L;
        }
    }

    private static double rad(double paramDouble) {
        return 3.141592653589793D * paramDouble / 180.0D;
    }

    public static String replaceBlank(String paramString) {
        String str = "";
        if (!TextUtils.isEmpty(paramString)) {
            str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
        }
        return str;
    }

    public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
            throws OutOfMemoryException {
        Object localObject = paramBitmap;
        if (paramInt != 0) {
            localObject = paramBitmap;
            if (paramBitmap != null) {
                localObject = new Matrix();
                ((Matrix) localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
            }
        }
        try {
            Bitmap localBitmap3 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix) localObject, true);
            localObject = paramBitmap;
            if (paramBitmap != localBitmap3) {
                paramBitmap.recycle();
                localObject = localBitmap3;
            }
        } catch (OutOfMemoryError paramBitmap) {
            throw new OutOfMemoryException(paramBitmap.getMessage());
        } catch (StackOverflowError localStackOverflowError) {
            for (; ; ) {
                localStackOverflowError.printStackTrace();
                Bitmap localBitmap1 = paramBitmap;
            }
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
                Bitmap localBitmap2 = paramBitmap;
            }
        }
        return (Bitmap) localObject;
    }

    public static void sendAdScreenBroadcast(Context paramContext, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (Intent localIntent = new Intent("action_ad_screen_launch_intent"); ; localIntent = new Intent("action_ad_screen_launch_intent_return")) {
            paramContext.sendBroadcast(localIntent);
            return;
        }
    }

    public static void sendBroadcast(Context paramContext, String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            paramContext.sendBroadcast(new Intent(paramString));
        }
    }

    public static void sendGestureBroadcast(Context paramContext, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (Intent localIntent = new Intent("action_need_show_gesture_pwd"); ; localIntent = new Intent("action_not_need_show_gesture_pwd")) {
            paramContext.sendBroadcast(localIntent);
            return;
        }
    }

    public static void sendSms(Context paramContext, String paramString) {
        if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
        }
        for (; ; ) {
            return;
            try {
                sendAdScreenBroadcast(paramContext, true);
                sendGestureBroadcast(paramContext, false);
                Intent localIntent = new android / content / Intent;
                localIntent.<init> ("android.intent.action.VIEW");
                localIntent.putExtra("sms_body", paramString);
                localIntent.setType("vnd.android-dir/mms-sms");
                paramContext.startActivity(localIntent);
            } catch (ActivityNotFoundException paramString) {
                CommonUI.showTipInfo(paramContext, 2131427355);
            }
        }
    }

    public static int switchTextColor(int paramInt) {
        return Color.argb(255, (0xFF0000 & paramInt) >> 16, (0xFF00 & paramInt) >> 8, paramInt & 0xFF);
    }

    public static String toJson(ArrayList<Long> paramArrayList) {
        Object localObject = null;
        if (paramArrayList != null) {
        }
        try {
            localObject = new com / dw / bcamera / util / Utils$3;
            ((3) localObject).<init > ();
            localObject = ((3) localObject).getType();
            localObject = GsonUtil.createGson().toJson(paramArrayList, (Type) localObject);
            return (String) localObject;
        } catch (Exception paramArrayList) {
            for (; ; ) {
                localObject = null;
            }
        }
    }

    public static int unZipFile(File paramFile, String paramString)
            throws ZipException, IOException {
        paramFile = new ZipFile(paramFile);
        Enumeration localEnumeration = paramFile.entries();
        byte[] arrayOfByte = new byte['?'];
        for (; ; ) {
            if (!localEnumeration.hasMoreElements()) {
                paramFile.close();
                return 0;
            }
            localObject = (ZipEntry) localEnumeration.nextElement();
            if (!((ZipEntry) localObject).isDirectory()) {
                break;
            }
            new File(new String((paramString + ((ZipEntry) localObject).getName()).getBytes("8859_1"), "GB2312")).mkdir();
        }
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(paramString, ((ZipEntry) localObject).getName())));
        Object localObject = new BufferedInputStream(paramFile.getInputStream((ZipEntry) localObject));
        for (; ; ) {
            int i = ((InputStream) localObject).read(arrayOfByte, 0, 1024);
            if (i == -1) {
                ((InputStream) localObject).close();
                localBufferedOutputStream.close();
                break;
            }
            localBufferedOutputStream.write(arrayOfByte, 0, i);
        }
    }

    public static class AlarmType {
        public static final int BIRTHDAY = 1;
        public static final int LUNAR_BIRTHDAY = 2;
        public static final int VACCINE = 0;
    }

    public static class ErrorTpye {
        public static final int ERROR_CRASH = 20002;
        public static final int ERROR_LOG = 301;
    }

    public static class LatLong
            implements Serializable {
        private static final long serialVersionUID = 1L;
        public double latitude;
        public double longitude;
    }

    public static class MediaType {
        public static final int AUDIO = 2;
        public static final int IMAGE = 1;
        public static final int VIDEO = 3;
    }

    public static final class NotificationType {
        public static final int NOTI_ACT_FAIL = 1000;
        public static final int NOTI_GROW_ACT = 1001;
    }

    public static class RecommandType {
        public static final int TYPE_NONE = 0;
        public static final int TYPE_QQ = 105;
        public static final int TYPE_QQZONE = 104;
        public static final int TYPE_SINA = 100;
        public static final int TYPE_SMS = 1001;
        public static final int TYPE_TENCENT = 101;
        public static final int TYPE_WCHAT = 102;
        public static final int TYPE_WCHAT_TIMELINE = 103;
    }

    public static class SnsState {
        public static final int BINDED = 2;
        public static final int OVER = 3;
        public static final int UNBIND = 1;
    }
}

