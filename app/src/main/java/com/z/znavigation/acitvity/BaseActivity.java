package com.z.znavigation.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.z.znavigation.R;

/*
    在startActivity时调用overridePendingTransition(enterAnim, exitAnim)
    在finish时调用overridePendingTransition(enterAnim, exitAnim)
 */
public class BaseActivity extends AppCompatActivity {

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