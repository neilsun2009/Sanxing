package com.note8.sanxing.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.note8.sanxing.R;
import com.note8.sanxing.adapters.TodayDetailAdapter;

import java.util.ArrayList;

public class TodayDetailActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_question_detail);

        Bundle receiveData = getIntent().getExtras();
        boolean ans = receiveData.getBoolean("newAns");

        ListView lv = (ListView) findViewById(R.id.td_listview);
        Button ansButton = (Button) findViewById(R.id.td_answer);
        Button changeButton = (Button) findViewById(R.id.td_change);
        TextView ansView = (TextView) findViewById(R.id.td_ans_view);
        TextView label = (TextView) findViewById(R.id.td_ans_label);
        View div1 = findViewById(R.id.td_div_1);
        if (ans) {
            //  Static Data, should be replaced by data returning from the server
            ArrayList<String> staticData = new ArrayList<>();
            staticData.add("今晚做到比平时早睡了吗？");
            staticData.add("你今天想的最多的那个人是谁?");
            staticData.add("请用今天的天气描述你的心情。");
            TodayDetailAdapter adapter = new TodayDetailAdapter(TodayDetailActivity.this,
                    R.layout.today_detail_item, staticData);

            ansButton.setOnClickListener(this);

            lv.setAdapter(adapter);
            lv.setVisibility(View.VISIBLE);
            changeButton.setVisibility(View.VISIBLE);
            ansButton.setVisibility(View.VISIBLE);
            ansView.setVisibility(View.GONE);
            div1.setVisibility(View.VISIBLE);
            label.setText("已回答问题");
        } else {
            div1.setVisibility(View.INVISIBLE);
            lv.setVisibility(View.INVISIBLE);
            changeButton.setVisibility(View.GONE);
            ansButton.setVisibility(View.GONE);
            ansView.setVisibility(View.VISIBLE);
            label.setText("我的回答");
            String date = receiveData.getString("date") + " 问题回顾";
            String title = receiveData.getString("title");
            String content = receiveData.getString("content");
            String bottomText = receiveData.getString("bottomText");
            TextView titleView = (TextView) findViewById(R.id.td_title);
            titleView.setText(date);
            TextView contentView = (TextView) findViewById(R.id.td_main_content);
            contentView.setText(title);
            Log.d("TDA", content);
            ansView.setText(content);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(TodayDetailActivity.this, AnswerQuestionActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("title", "曾子曰：吾日三省吾身，\n为人谋而不忠乎？\n与朋友交而不信乎？\n传不习乎？");
        startActivity(intent);
    }
}