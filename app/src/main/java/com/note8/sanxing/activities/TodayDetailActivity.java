package com.note8.sanxing.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.note8.sanxing.R;
import com.note8.sanxing.adapters.TodayDetailAdapter;

import java.util.ArrayList;

public class TodayDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_question_detail);

        ListView lv = (ListView) findViewById(R.id.td_listview);
        //  Static Data, should be replaced by data returning from the server
        ArrayList<String> staticData = new ArrayList<>();
        staticData.add("今晚做到比平时早睡了吗？");
        staticData.add("你今天想的最多的那个人是谁?");
        staticData.add("请用今天的天气描述你的心情。");
        TodayDetailAdapter adapter = new TodayDetailAdapter(TodayDetailActivity.this,
                R.layout.today_detail_item, staticData);
        lv.setAdapter(adapter);
    }
}