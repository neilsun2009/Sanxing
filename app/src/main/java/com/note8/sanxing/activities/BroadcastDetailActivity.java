package com.note8.sanxing.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.note8.sanxing.adapters.BDListViewAdapter;
import com.note8.sanxing.R;
import com.note8.sanxing.items.BDListViewItem;

import java.util.LinkedList;

public class BroadcastDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_question_detail);

        //  接收数据
        Bundle bundleFromMain = getIntent().getExtras();
        int index = bundleFromMain.getInt("index");
        boolean fromBroadcast = bundleFromMain.getBoolean("broadcast");
        boolean fromNearby = bundleFromMain.getBoolean("nearby");

        TextView title = (TextView) findViewById(R.id.bd_title);
        if (fromBroadcast) {
            //  处理广播详情数据
            title.setText("广播问题详情");
        } else if (fromNearby) {
            //  处理附近详情数据
            title.setText("附近问题详情");
        } else {
            //  no use
        }

        switch (index) {
            case -1:  //  来自广播当日问题详情
                break;
            default:  //  来自广播往日问题详情或来自附近问题的条目
                break;
        }

        ListView lv = (ListView) findViewById(R.id.bd_listview);
        LinkedList<BDListViewItem> staticList = new LinkedList<>();
        String content = "随时三醒一下，绘制我的专属生活轨迹，每日十分钟记录，每周一篇周报总结，每年不定期昨日重现......";
        for (int i = 0; i < 3; ++i) {
            staticList.add(new BDListViewItem(R.drawable.avatar, "测试者" + i, "2016-12-01", content));
        }
        BDListViewAdapter adapter = new BDListViewAdapter(this, staticList);
        lv.setAdapter(adapter);
    }
}
