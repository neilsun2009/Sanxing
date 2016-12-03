package com.note8.sanxing;

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
}
