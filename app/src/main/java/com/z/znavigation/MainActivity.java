package com.z.znavigation;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.z.znavigation.acitvity.BaseActivity;
import com.z.znavigation.acitvity.TestAActivity;
import com.z.znavigation.navigation.DefaultNavigation;

/*
    TODO: 既能显示图片，也能显示文字
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    protected void initTitle() {
        DefaultNavigation navigation = new DefaultNavigation
                .DefaultBuilder(this)
                //.DefaultBuilder(this, (ViewGroup) findViewById(R.id.view_group_main))
                .setTitle("投稿")
                .setRightText("发布")
                .setRightTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "发布", Toast.LENGTH_SHORT).show();
                    }
                })
                .disableBackButton()
                .create();
    }

    public void handleClickA(View view) {
        startActivity(new Intent(this, TestAActivity.class));
    }
}