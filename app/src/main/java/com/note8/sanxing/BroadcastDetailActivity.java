package com.note8.sanxing;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BroadcastDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_question_detail);

        //  接收数据
        Bundle bundleFromMain = getIntent().getExtras();
        int index = bundleFromMain.getInt("index");

        switch (index) {
            case -1:  //  当日问题详情
                break;
            default:  //  往日问题详情
                break;
        }

        TextView tv = (TextView) findViewById(R.id.test);
        tv.setText("Test: " + index);
    }


}
