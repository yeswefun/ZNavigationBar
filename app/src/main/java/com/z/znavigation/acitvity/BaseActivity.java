package com.z.znavigation.acitvity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.z.znavigation.R;

/*
动画
    在startActivity时调用overridePendingTransition(enterAnim, exitAnim)
    在finish时调用overridePendingTransition(enterAnim, exitAnim)

模板设计模式定义
    将子类中一些 相同的操作 抽取到父类

模板设计模式应用
    AsyncTask(只能执行一次?看源码分析)
    view的绘制流程

可以将BaseActivity声明成abstract, 将方法声明为abstract, 强制子类必须实现
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置布局
        initLayout();

        // 初始标题栏
        initTitle();

        // 初始化界面
        initView();

        // 初始化数据
        initData();
    }

    protected void initLayout() {
    }

    protected void initTitle() {
    }

    protected void initView() {

    }

    protected void initData() {
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // enterAnim, exitAnim
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        // enterAnim, exitAnim
        overridePendingTransition(R.anim.activity_left_in, R.anim.activity_right_out);
    }
}