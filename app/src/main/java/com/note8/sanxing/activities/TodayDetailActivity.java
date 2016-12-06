package com.note8.sanxing.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.note8.sanxing.R;

public class TodayDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_question_detail);

        ListView lv = (ListView) findViewById(R.id.td_listview);

    }
}