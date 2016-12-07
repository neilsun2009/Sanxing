package com.note8.sanxing.items;

import com.note8.sanxing.R;

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
    public boolean gotoAnswer;
    public String weeklyTitle;

    public TodayClass(int _id, String _date, String _title, String _content,
                      int _photoRes, boolean _hasPhoto, String _bottomText, boolean _showAnswer,
                      boolean _gotoAnswer, String _weeklyTitle) {
        id = _id;
        date = _date;
        title = _title;
        content = _content;
        photoRes = _photoRes;
        hasPhoto = _hasPhoto;
        bottomText = _bottomText;
        showAnswer = _showAnswer;
        gotoAnswer = _gotoAnswer;
        weeklyTitle = _weeklyTitle;

    }
    public static List<TodayClass> todayList = initTodayData();
    private static ArrayList<TodayClass> initTodayData() {
        ArrayList<TodayClass> list = new ArrayList<>();
        TodayClass temp = new TodayClass(0, "12-10", "今天最开心的事情是什么", "花了五六个小时，终于de好bug了",
                0, false, "今天回答(2/3)，继续回答", true, false, "");
        list.add(temp);
        temp = new TodayClass(1, "12-09", "今天看了什么美剧吗", "最近看了HBO的西部世界，探讨了很多关于人工智能获得自主意识之后，产生的矛盾，很适合程序员看~",
                0, false, "查看全部", true, true, "");
        list.add(temp);
        temp = new TodayClass(2, "12-08", "用手机拍一下今天的天空", "在实验楼旁边拍的，这个角度好美",
                R.drawable.today_list_photo, true, "查看全部", true, true, "");
        list.add(temp);
        temp = new TodayClass(3, "12-07", "用一首歌形容今天的心情吧", "崔健的《假行僧》，“我要从南走到北，我还要从白走到黑，我要人们都看到我，但不知道我是谁”",
                0, false, "查看全部", true, true, "");
        list.add(temp);
        temp = new TodayClass(4, "12-06", "还记得昨晚梦见了什么吗", "昨晚梦到在天河体育场看国足踢香港，五块钱一张票，然后，国足还是没赢。。。",
                0, false, "查看全部", true, true, "");
        list.add(temp);
        return list;
    }
}
