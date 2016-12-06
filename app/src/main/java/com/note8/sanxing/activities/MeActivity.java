package com.note8.sanxing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.note8.sanxing.R;


public class MeActivity extends AppCompatActivity {

    private ListView listView;
    private ListView listView2;
    private ImageView askBtn;
    private ImageView weeklyBtn;
    private ImageView favoriteBtn;

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


        // listener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.me_ask_btn :
                        Toast.makeText(MeActivity.this, "此功能尚未开通", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.me_favorite_btn :
                        Toast.makeText(MeActivity.this, "此功能尚未开通", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.me_weekly_btn :
                        Intent intent = new Intent(MeActivity.this, WeeklyActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };

        // buttons
        askBtn = (ImageView) findViewById(R.id.me_ask_btn);
        weeklyBtn = (ImageView) findViewById(R.id.me_weekly_btn);
        favoriteBtn = (ImageView) findViewById(R.id.me_favorite_btn);

        askBtn.setOnClickListener(listener);
        weeklyBtn.setOnClickListener(listener);
        favoriteBtn.setOnClickListener(listener);

    }
}

