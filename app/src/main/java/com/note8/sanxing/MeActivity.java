package com.note8.sanxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class MeActivity extends AppCompatActivity {

    private ListView listView;
    private ListView listView2;
    private static final String[] listViewStr = {"退出登录"};
    private static final String[] listView2Str = {"问题反馈", "推荐给朋友", "清理缓存", "关于三醒"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        listView = (ListView) findViewById(R.id.me_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MeActivity.this, android.R.layout.simple_list_item_activated_1, listViewStr);
        listView.setAdapter(adapter);
        listView2 = (ListView) findViewById(R.id.me_list_view2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MeActivity.this, R.layout.listview_me, listView2Str);
        listView2.setAdapter(adapter2);
    }
}

