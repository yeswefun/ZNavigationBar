package com.z.znavigation.acitvity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.z.znavigation.R;
import com.z.znavigation.navigation.DefaultNavigation;

public class TestAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);
        initTitle();
    }

    private void initTitle() {
        DefaultNavigation navigation = new DefaultNavigation
                .DefaultBuilder(this, (ViewGroup)findViewById(R.id.view_group_a))
                .setTitle("A页面")
                .setRightText("设置")
                .setRightTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TestAActivity.this, "设置", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
    }

    public void handleClickB(View view) {
        startActivity(new Intent(this, TestBActivity.class));
    }
}