package com.z.znavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.z.znavigation.acitvity.TestAActivity;
import com.z.znavigation.navigation.DefaultNavigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle();
    }

    private void initTitle() {
        DefaultNavigation navigation = new DefaultNavigation
                .DefaultBuilder(this, (ViewGroup)findViewById(R.id.view_group_main))
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