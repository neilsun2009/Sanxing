package com.note8.sanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/12/3.
 */
// a testing class for timeline in today
public class TodayClass{
    public int id;
    public String date;
    public String title;
    public String content;
    public int photoRes;
    public boolean hasPhoto;
    public String bottomText;
    public boolean showAnswer;
    public TodayClass(int _id, String _date, String _title, String _content,
                      int _photoRes, boolean _hasPhoto, String _bottomText, boolean _showAnswer) {
        id = _id;
        date = _date;
        title = _title;
        content = _content;
        photoRes = _photoRes;
        hasPhoto = _hasPhoto;
        bottomText = _bottomText;
        showAnswer = _showAnswer;
    }
    public static List<TodayClass> todayList = initTodayData();
    private static ArrayList<TodayClass> initTodayData() {
        ArrayList<TodayClass> list = new ArrayList<>();
        TodayClass temp = new TodayClass(0, "12-10", "今天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                0, false, "快去回答", false);
        list.add(temp);
        temp = new TodayClass(1, "12-09", "昨天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                0, false, "查看全部", true);
        list.add(temp);
        temp = new TodayClass(2, "12-08", "前天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                R.drawable.today_list_photo, true, "查看全部", true);
        list.add(temp);
        temp = new TodayClass(3, "12-07", "大前天的问题", "我还是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                0, false, "查看全部", true);
        list.add(temp);
        temp = new TodayClass(4, "12-06", "标题特别特别长的问题", "我还是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                0, false, "查看全部", true);
        list.add(temp);
        return list;
    }
}
