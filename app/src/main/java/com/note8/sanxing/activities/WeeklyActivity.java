package com.note8.sanxing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.note8.sanxing.R;
import com.note8.sanxing.adapters.TodayAdapter;
import com.note8.sanxing.items.TodayClass;

import java.util.ArrayList;
import java.util.List;

public class WeeklyActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        listView = (ListView)findViewById(R.id.weekly_list_view);
        List<TodayClass> weeklyList = initWeeklyData();
        TodayAdapter adapter = new TodayAdapter(WeeklyActivity.this, R.layout.listview_today, weeklyList);
        listView.setAdapter(adapter);
    }

    private ArrayList<TodayClass> initWeeklyData() {
        ArrayList<TodayClass> list = new ArrayList<>();
        TodayClass temp = new TodayClass(0, "11-28\n~\n12-04", "一句让你觉得印象深刻的话", "The violent delights have violent ends.",
                R.drawable.weekly_list_photo3, true, "查看全部", true, true, "长路漫漫");
        list.add(temp);
        temp = new TodayClass(1, "11-21\n" +
                "~\n" +
                "11-27", "今晚做到比平时早睡了吗", "好多作业要写啊，实在没办法早睡。。。",
                R.drawable.weekly_list_photo2, true, "查看全部", true, true, "花径");
        list.add(temp);
        temp = new TodayClass(2, "11-14\n" +
                "~\n" +
                "11-20", "拍一张最能代表今天心情的照片", "夕阳无限好，可惜近黄昏",
                R.drawable.weekly_list_photo1, true, "查看全部", true, true, "夕阳");
        list.add(temp);
//        temp = new TodayClass(3, "11-07\n" +
//                "~\n" +
//                "11-13", "你今天想的最多的那个人是谁", "计网老师，明天期中考了，不知道有没有师生情啊",
//                0, false, "查看全部", true, true);
//        list.add(temp);
//        temp = new TodayClass(4, "11-01\n" +
//                "~\n" +
//                "11-06", "用天气描述你的心情", "晴有时多云，西南风2至3级，湿度10%",
//                0, false, "查看全部", true, true);
//        list.add(temp);
        return list;
    }
}
