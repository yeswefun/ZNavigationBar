package com.z.znavigation.navigation;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
    头部基类
 */
public abstract class AbsNavigation<T extends AbsNavigation.AbsBuilder.AbsNavigationParams> implements INavigation {

    private final T mParams;
    private View mNavigationView;

    protected AbsNavigation(T params) {
        mParams = params;
        createAndBindView();
    }

    protected T getParams() {
        return mParams;
    }

    /*
        false
     */
    private void createAndBindView() {
        // 加载顶部导航的布局
        mNavigationView = LayoutInflater.from(mParams.mContext)
                .inflate(getLayoutResId(), mParams.mParent, false);
        // 添加到父布局的第一个位置
        mParams.mParent.addView(mNavigationView, 0);
        apply();
    }

    public static abstract class AbsBuilder {

        public AbsBuilder(Context context, ViewGroup parent) {
        }

        //        public abstract <P extends AbsNavigation> P create();
        public abstract AbsNavigation create();

        public static class AbsNavigationParams {

            public Context mContext;
            public ViewGroup mParent;

            public AbsNavigationParams(Context context, ViewGroup parent) {
                mContext = context;
                mParent = parent;
            }
        }
    }

    /*
     * 将公共的方法抽取到父类中
     */
    protected void setText(int viewId, String text) {
        TextView textView = findView(viewId);
        if (textView != null && !TextUtils.isEmpty(text)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(text);
        }
    }

    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = findView(viewId);
        if (view != null && listener != null) {
            view.setOnClickListener(listener);
        }
    }

    private <R extends View> R findView(int viewId) {
        return (R) mNavigationView.findViewById(viewId);
    }
}
