package com.shouyiren.bbcamera.widget;

/**
 * 作者：ZhouJianxing on 2017/6/30 15:58
 * email:727933147@qq.com
 */


import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.dw.common.BTLog;
import com.dw.common.ScaleUtils;
import com.shouyiren.bbcamera.R;

public class TitleBar
        extends RelativeLayout {
    public static final int TOOL_BACK = 1;
    public static final int TOOL_BACK_BAO = 101;
    public static final int TOOL_CANCEL_BAO = 103;
    public static final int TOOL_CONFIRM_BAO = 104;
    public static final int TOOL_EMPTY = 0;
    public static final int TOOL_HOME = 5;
    public static final int TOOL_LEFT_CANCEL = 102;
    public static final int TOOL_NEXT_BAO = 100;
    public static final int TOOL_SAVE = 3;
    public static final int TOOL_SEND = 4;
    private ViewGroup mGroupLeft;
    private ViewGroup mGroupRight;
    private OnBackBaoListener mOnBackBaoListener = null;
    private OnBackListener mOnBackListener = null;
    private OnCancelBaoListener mOnCancelBaoListener = null;
    private OnClickTitleListener mOnClickTitleListener = null;
    private OnConfirmBaoListener mOnConfirmBaoListener = null;
    private OnHomeListener mOnHomeListener = null;
    private OnLeftCancelListener mOnLeftCancelListener = null;
    private OnNextBaoListener mOnNextBaoListener = null;
    private OnSaveListener mOnSaveListener = null;
    private OnSendListener mOnSendListener = null;
    private TextView mTextTitle;

    public TitleBar(Context paramContext) {
        super(paramContext);
        init();
    }

    public TitleBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public TitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private View addBack(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(R.layout.bao_bcamera_title_bar, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnBackListener != null) {
                    TitleBar.this.mOnBackListener.onBack(TitleBar.this);
                }
            }
        });
        Object localObject1 = (TextView) localView.findViewById(R.id.title_bar_title);
        if (localObject1 != null) {
            ((TextView) localObject1).setTextSize(0, ScaleUtils.scale(30));
            localObject1 = ((TextView) localObject1).getCompoundDrawables();
            if (localObject1 != null) {
                Object localObject2 = localObject1[0];
                if (localObject2 != null) {
                    int j = ScaleUtils.scale(20);
                    int i = ScaleUtils.scale(34);
                    localObject1 = ((Drawable) localObject2).getBounds();
                    int k = (((Rect) localObject1).width() - j) / 2;
                    int m = (((Rect) localObject1).height() - i) / 2;
                    ((Drawable) localObject2).setBounds(k, m, k + j, m + i);
                }
            }
        }
        localView.setTag(Integer.valueOf(1));
        paramViewGroup.addView(localView);
        return localView;
    }

    private View addBackBao(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968667, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnBackBaoListener != null) {
                    TitleBar.this.mOnBackBaoListener.onBackBao(TitleBar.this);
                }
            }
        });
        Object localObject = (TextView) localView.findViewById(2131231136);
        if (localObject != null) {
            ((TextView) localObject).setTextSize(0, ScaleUtils.scale(30));
            localObject = ((TextView) localObject).getCompoundDrawables();
            if (localObject != null) {
                localObject = localObject[0];
                if (localObject != null) {
                    int m = ScaleUtils.scale(20);
                    int j = ScaleUtils.scale(34);
                    Rect localRect = ((Drawable) localObject).getBounds();
                    int k = (localRect.width() - m) / 2;
                    int i = (localRect.height() - j) / 2;
                    ((Drawable) localObject).setBounds(k, i, k + m, i + j);
                }
            }
        }
        localView.setTag(Integer.valueOf(101));
        paramViewGroup.addView(localView);
        return localView;
    }

    private View addCancelBao(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968672, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnCancelBaoListener != null) {
                    TitleBar.this.mOnCancelBaoListener.onCancelBao(TitleBar.this);
                }
            }
        });
        localView.setTag(Integer.valueOf(103));
        paramViewGroup.addView(localView);
        paramViewGroup = (TextView) localView.findViewById(2131231139);
        if (paramViewGroup != null) {
            paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramViewGroup.setText(2131427393);
            paramViewGroup.setTextSize(0, ScaleUtils.scale(30));
        }
        return localView;
    }

    private View addConfirmBao(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968669, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnConfirmBaoListener != null) {
                    TitleBar.this.mOnConfirmBaoListener.onConfirmBao(TitleBar.this);
                }
            }
        });
        Object localObject1 = (TextView) localView;
        ((TextView) localObject1).setTextSize(0, ScaleUtils.scale(30));
        localObject1 = ((TextView) localObject1).getCompoundDrawables();
        if (localObject1 != null) {
            Object localObject2 = localObject1[2];
            if (localObject2 != null) {
                int k = ScaleUtils.scale(41);
                int m = ScaleUtils.scale(30);
                localObject1 = ((Drawable) localObject2).getBounds();
                int j = (((Rect) localObject1).width() - k) / 2;
                int i = (((Rect) localObject1).height() - m) / 2;
                ((Drawable) localObject2).setBounds(j, i, j + k, i + m);
            }
        }
        localView.setTag(Integer.valueOf(104));
        paramViewGroup.addView(localView);
        return localView;
    }

    private View addHome(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968670, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnHomeListener != null) {
                    TitleBar.this.mOnHomeListener.onHome(TitleBar.this);
                }
            }
        });
        localView.setTag(Integer.valueOf(5));
        paramViewGroup.addView(localView);
        paramViewGroup = (Button) localView.findViewById(2131231138);
        if (paramViewGroup != null) {
            paramViewGroup.setText(2131427416);
            paramViewGroup.setTextSize(0, ScaleUtils.scale(30));
            paramViewGroup = paramViewGroup.getCompoundDrawables();
            if (paramViewGroup != null) {
                paramViewGroup = paramViewGroup[2];
                if (paramViewGroup != null) {
                    int i = ScaleUtils.scale(34);
                    int j = ScaleUtils.scale(34);
                    Rect localRect = paramViewGroup.getBounds();
                    int m = (localRect.width() - i) / 2;
                    int k = (localRect.height() - j) / 2;
                    paramViewGroup.setBounds(m, k, m + i, k + j);
                }
            }
        }
        return localView;
    }

    private View addLeftCancel(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968668, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnLeftCancelListener != null) {
                    TitleBar.this.mOnLeftCancelListener.onLeftCancel(TitleBar.this);
                }
            }
        });
        localView.setTag(Integer.valueOf(102));
        paramViewGroup.addView(localView);
        paramViewGroup = (TextView) localView.findViewById(2131231136);
        if (paramViewGroup != null) {
            paramViewGroup = paramViewGroup.getCompoundDrawables();
            if (paramViewGroup != null) {
                Object localObject = paramViewGroup[0];
                if (localObject != null) {
                    int k = ScaleUtils.scale(34);
                    int m = ScaleUtils.scale(34);
                    paramViewGroup = ((Drawable) localObject).getBounds();
                    int i = (paramViewGroup.width() - k) / 2;
                    int j = (paramViewGroup.height() - m) / 2;
                    ((Drawable) localObject).setBounds(i, j, i + k, j + m);
                }
            }
        }
        return localView;
    }

    private View addNextBao(ViewGroup paramViewGroup, String paramString) {
        paramString = LayoutInflater.from(getContext()).inflate(2130968672, paramViewGroup, false);
        paramString.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnNextBaoListener != null) {
                    TitleBar.this.mOnNextBaoListener.onNextBao(TitleBar.this);
                }
            }
        });
        Object localObject1 = (TextView) paramString;
        ((TextView) localObject1).setTextSize(0, ScaleUtils.scale(30));
        localObject1 = ((TextView) localObject1).getCompoundDrawables();
        if (localObject1 != null) {
            Object localObject2 = localObject1[2];
            if (localObject2 != null) {
                int k = ScaleUtils.scale(20);
                int m = ScaleUtils.scale(34);
                localObject1 = ((Drawable) localObject2).getBounds();
                int i = (((Rect) localObject1).width() - k) / 2;
                int j = (((Rect) localObject1).height() - m) / 2;
                ((Drawable) localObject2).setBounds(i, j, i + k, j + m);
            }
        }
        paramString.setTag(Integer.valueOf(100));
        paramViewGroup.addView(paramString);
        return paramString;
    }

    private View addSave(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968673, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnSaveListener != null) {
                    TitleBar.this.mOnSaveListener.onSave(TitleBar.this);
                }
            }
        });
        localView.setTag(Integer.valueOf(3));
        paramViewGroup.addView(localView);
        paramViewGroup = (Button) localView.findViewById(2131231139);
        if (paramViewGroup != null) {
            paramViewGroup.setText(2131427411);
            paramViewGroup.setTextSize(0, ScaleUtils.scale(30));
            paramViewGroup = paramViewGroup.getCompoundDrawables();
            if (paramViewGroup != null) {
                Object localObject = paramViewGroup[2];
                if (localObject != null) {
                    int k = ScaleUtils.scale(41);
                    int i = ScaleUtils.scale(30);
                    paramViewGroup = ((Drawable) localObject).getBounds();
                    int j = (paramViewGroup.width() - k) / 2;
                    int m = (paramViewGroup.height() - i) / 2;
                    ((Drawable) localObject).setBounds(j, m, j + k, m + i);
                }
            }
        }
        return localView;
    }

    private View addSend(ViewGroup paramViewGroup) {
        View localView = LayoutInflater.from(getContext()).inflate(2130968672, paramViewGroup, false);
        localView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (TitleBar.this.mOnSendListener != null) {
                    TitleBar.this.mOnSendListener.onSend(TitleBar.this);
                }
            }
        });
        localView.setTag(Integer.valueOf(4));
        paramViewGroup.addView(localView);
        paramViewGroup = (TextView) localView.findViewById(2131231139);
        if (paramViewGroup != null) {
            paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramViewGroup.setText(2131427373);
            paramViewGroup.setTextSize(0, ScaleUtils.scale(30));
        }
        return localView;
    }

    private View addTool(ViewGroup paramViewGroup, int paramInt, String paramString) {
        Object localObject = null;
        switch (paramInt) {
            default:
                paramViewGroup = (ViewGroup) localObject;
        }
        for (; ; ) {
            return paramViewGroup;
            paramViewGroup = addBack(paramViewGroup);
            continue;
            paramViewGroup = addBackBao(paramViewGroup);
            continue;
            paramViewGroup = addNextBao(paramViewGroup, paramString);
            continue;
            paramViewGroup = addCancelBao(paramViewGroup);
            continue;
            paramViewGroup = addSave(paramViewGroup);
            continue;
            paramViewGroup = addSend(paramViewGroup);
            continue;
            paramViewGroup = addHome(paramViewGroup);
            continue;
            paramViewGroup = addLeftCancel(paramViewGroup);
            continue;
            paramViewGroup = addConfirmBao(paramViewGroup);
        }
    }

    private boolean enableTool(ViewGroup paramViewGroup, int paramInt, boolean paramBoolean) {
        int j = paramViewGroup.getChildCount();
        for (int i = 0; ; i++) {
            if (i >= j) {
            }
            for (paramBoolean = false; ; paramBoolean = true) {
                return paramBoolean;
                View localView = paramViewGroup.getChildAt(i);
                if (((Integer) localView.getTag()).intValue() != paramInt) {
                    break;
                }
                localView.setEnabled(paramBoolean);
            }
        }
    }

    private void init() {
    }

    private boolean selectTool(ViewGroup paramViewGroup, int paramInt, boolean paramBoolean) {
        int j = paramViewGroup.getChildCount();
        for (int i = 0; ; i++) {
            if (i >= j) {
            }
            for (paramBoolean = false; ; paramBoolean = true) {
                return paramBoolean;
                View localView = paramViewGroup.getChildAt(i);
                if (((Integer) localView.getTag()).intValue() != paramInt) {
                    break;
                }
                localView.setSelected(paramBoolean);
            }
        }
    }

    private boolean showTool(ViewGroup paramViewGroup, int paramInt, boolean paramBoolean) {
        int j = paramViewGroup.getChildCount();
        for (int i = 0; ; i++) {
            if (i >= j) {
                paramBoolean = false;
                return paramBoolean;
            }
            View localView = paramViewGroup.getChildAt(i);
            if (((Integer) localView.getTag()).intValue() == paramInt) {
                if (paramBoolean) {
                    localView.setVisibility(0);
                }
                for (; ; ) {
                    paramBoolean = true;
                    break;
                    localView.setVisibility(4);
                }
            }
        }
    }

    public void enableTool(int paramInt, boolean paramBoolean) {
        if (enableTool(this.mGroupRight, paramInt, paramBoolean)) {
        }
        for (; ; ) {
            return;
            enableTool(this.mGroupLeft, paramInt, paramBoolean);
        }
    }

    public String getTitle() {
        try {
            String str = this.mTextTitle.getText().toString();
            return str;
        } catch (Exception localException) {
            for (; ; ) {
                Object localObject = null;
            }
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        try {
            this.mTextTitle = ((TextView) findViewById(2131230918));
            TextView localTextView = this.mTextTitle;
            View.OnClickListener local1 = new com / dw / bcamera / widget / TitleBar$1;
            local1.<init> (this);
            localTextView.setOnClickListener(local1);
            this.mGroupLeft = ((ViewGroup) findViewById(2131230919));
            this.mGroupRight = ((ViewGroup) findViewById(2131230920));
            return;
        } catch (Resources.NotFoundException localNotFoundException) {
            for (; ; ) {
                BTLog.e("btime", "Can't find necessary layout elements for TitleBar");
            }
        }
    }

    public void selectTool(int paramInt, boolean paramBoolean) {
        if (selectTool(this.mGroupRight, paramInt, paramBoolean)) {
        }
        for (; ; ) {
            return;
            selectTool(this.mGroupLeft, paramInt, paramBoolean);
        }
    }

    public View setLeftTool(int paramInt) {
        this.mGroupLeft.removeAllViews();
        return addTool(this.mGroupLeft, paramInt, null);
    }

    public void setOnBackBaoListener(OnBackBaoListener paramOnBackBaoListener) {
        this.mOnBackBaoListener = paramOnBackBaoListener;
    }

    public void setOnBackListener(OnBackListener paramOnBackListener) {
        this.mOnBackListener = paramOnBackListener;
    }

    public void setOnCancelBaoListener(OnCancelBaoListener paramOnCancelBaoListener) {
        this.mOnCancelBaoListener = paramOnCancelBaoListener;
    }

    public void setOnClickTitleListener(OnClickTitleListener paramOnClickTitleListener) {
        this.mOnClickTitleListener = paramOnClickTitleListener;
    }

    public void setOnConfirmBaoListener(OnConfirmBaoListener paramOnConfirmBaoListener) {
        this.mOnConfirmBaoListener = paramOnConfirmBaoListener;
    }

    public void setOnHomeListener(OnHomeListener paramOnHomeListener) {
        this.mOnHomeListener = paramOnHomeListener;
    }

    public void setOnLeftCancelListener(OnLeftCancelListener paramOnLeftCancelListener) {
        this.mOnLeftCancelListener = paramOnLeftCancelListener;
    }

    public void setOnNextBaoListener(OnNextBaoListener paramOnNextBaoListener) {
        this.mOnNextBaoListener = paramOnNextBaoListener;
    }

    public void setOnSaveListener(OnSaveListener paramOnSaveListener) {
        this.mOnSaveListener = paramOnSaveListener;
    }

    public void setOnSendListener(OnSendListener paramOnSendListener) {
        this.mOnSendListener = paramOnSendListener;
    }

    public View setRightTool(int paramInt) {
        this.mGroupRight.removeAllViews();
        return addTool(this.mGroupRight, paramInt, null);
    }

    public View setRightTool(int paramInt, String paramString) {
        this.mGroupRight.removeAllViews();
        return addTool(this.mGroupRight, paramInt, paramString);
    }

    public void setTitle(int paramInt) {
        this.mTextTitle.setText(paramInt);
        this.mTextTitle.setTextSize(0, ScaleUtils.scale(36));
    }

    public void setTitle(String paramString) {
        this.mTextTitle.setText(paramString);
        this.mTextTitle.setTextSize(0, ScaleUtils.scale(36));
    }

    public void setTitleAndDrawableRight(String paramString, int paramInt) {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13, -1);
        this.mTextTitle.setLayoutParams(localLayoutParams);
        this.mTextTitle.setText(paramString);
        this.mTextTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
    }

    public void setTitleColor(int paramInt) {
        this.mTextTitle.setTextColor(paramInt);
    }

    public void showTool(int paramInt, boolean paramBoolean) {
        if (showTool(this.mGroupRight, paramInt, paramBoolean)) {
        }
        for (; ; ) {
            return;
            showTool(this.mGroupLeft, paramInt, paramBoolean);
        }
    }

    public static abstract interface OnActiListener {
        public abstract void onActi(View paramView);
    }

    public static abstract interface OnAddListener {
        public abstract void onAdd(View paramView);
    }

    public static abstract interface OnBabyListListener {
        public abstract void onBabyList(View paramView);
    }

    public static abstract interface OnBabyListener {
        public abstract void onBaby(View paramView);
    }

    public static abstract interface OnBackBaoListener {
        public abstract void onBackBao(View paramView);
    }

    public static abstract interface OnBackListener {
        public abstract void onBack(View paramView);
    }

    public static abstract interface OnCancelBaoListener {
        public abstract void onCancelBao(View paramView);
    }

    public static abstract interface OnCancelListener {
        public abstract void onCancel(View paramView);
    }

    public static abstract interface OnCleanListener {
        public abstract void onClean(View paramView);
    }

    public static abstract interface OnClickTitleListener {
        public abstract void onClickTitle(View paramView);
    }

    public static abstract interface OnConfirmBaoListener {
        public abstract void onConfirmBao(View paramView);
    }

    public static abstract interface OnDeleteListener {
        public abstract void onDelete(View paramView);
    }

    public static abstract interface OnDuihaoListener {
        public abstract void onDuihao(View paramView);
    }

    public static abstract interface OnHomeListener {
        public abstract void onHome(View paramView);
    }

    public static abstract interface OnInviteListener {
        public abstract void onInvite(View paramView);
    }

    public static abstract interface OnJoinListener {
        public abstract void onJoin(View paramView);
    }

    public static abstract interface OnLeftCancelListener {
        public abstract void onLeftCancel(View paramView);
    }

    public static abstract interface OnMenuListener {
        public abstract void onMenu(View paramView);
    }

    public static abstract interface OnModifyListener {
        public abstract void onModify(View paramView);
    }

    public static abstract interface OnMoreListener {
        public abstract void onMore(View paramView);
    }

    public static abstract interface OnMsgListener {
        public abstract void onMsg(View paramView);
    }

    public static abstract interface OnNextBaoListener {
        public abstract void onNextBao(View paramView);
    }

    public static abstract interface OnNextListener {
        public abstract void onNext(View paramView);
    }

    public static abstract interface OnOkListener {
        public abstract void onOk(View paramView);
    }

    public static abstract interface OnPlayListener {
        public abstract void onPlay(View paramView);
    }

    public static abstract interface OnPrevListener {
        public abstract void onPrev(View paramView);
    }

    public static abstract interface OnRegisterListener {
        public abstract void onRegister(View paramView);
    }

    public static abstract interface OnSaveListener {
        public abstract void onSave(View paramView);
    }

    public static abstract interface OnSearchListener {
        public abstract void onSearch(View paramView);
    }

    public static abstract interface OnSendListener {
        public abstract void onSend(View paramView);
    }

    public static abstract interface OnShareListener {
        public abstract void onShare(View paramView);
    }
}

