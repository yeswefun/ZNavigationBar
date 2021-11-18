package com.z.znavigation.navigation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.z.znavigation.R;

public class DefaultNavigation extends AbsNavigation<DefaultNavigation.DefaultBuilder.DefaultNavigationParams> {

    protected DefaultNavigation(DefaultNavigation.DefaultBuilder.DefaultNavigationParams params) {
        super(params);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.default_navigation;
    }

    /*
        应用参数
     */
    @Override
    public void apply() {
        setText(R.id.title, getParams().mTitle);
        setText(R.id.right_text, getParams().mRightText);

        setOnClickListener(R.id.right_text, getParams().mRightTextOnClickListener);

        if (!getParams().mDisableBackButton) {
            setText(R.id.back_button, "返回");
            setOnClickListener(R.id.back_button, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity)v.getContext()).finish();
                }
            });
        }
        // 左边的一般是默认的, finish();
    }

    public static class DefaultBuilder extends AbsNavigation.AbsBuilder {

        DefaultNavigationParams P;

        public DefaultBuilder(Context context, ViewGroup parent) {
            super(context, parent);
            P = new DefaultNavigationParams(context, parent);
        }

        /*
            AbstNavigation
         */
        @Override
        public DefaultNavigation create() {
//            DefaultNavigation navigation = new DefaultNavigation(P);
            return new DefaultNavigation(P);
        }

        // 设置参数
        public DefaultBuilder setTitle(String title) {
            P.mTitle = title;
            return this;
        }

        public DefaultBuilder setRightText(String text) {
            P.mRightText = text;
            return this;
        }

        public DefaultBuilder setRightTextOnClickListener(View.OnClickListener listener) {
            P.mRightTextOnClickListener = listener;
            return this;
        }

        public DefaultBuilder setRightIcon(int resId) {
            P.mRightIcon = resId;
            return this;
        }

        public DefaultBuilder disableBackButton() {
            P.mDisableBackButton = true;
            return this;
        }

        public static class DefaultNavigationParams extends AbsNavigation.AbsBuilder.AbsNavigationParams {

            // 存放参数
            public String mTitle;
            public String mRightText;
            public int mRightIcon;
            public View.OnClickListener mRightTextOnClickListener;
            public String mLeftText;
            public boolean mDisableBackButton;

            public DefaultNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }

}
