package com.z.znavigation.acitvity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.z.znavigation.R;
import com.z.znavigation.navigation.DefaultNavigation;

public class TestBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_b);
        initTitle();
    }

    private void initTitle() {
        DefaultNavigation navigation = new DefaultNavigation
                .DefaultBuilder(this, (ViewGroup)findViewById(R.id.view_group_b))
                .setTitle("B页面")
                .setRightText("帮助")
                .setRightTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TestBActivity.this, "帮助", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
    }
}