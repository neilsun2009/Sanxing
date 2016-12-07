package com.note8.sanxing.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.note8.sanxing.R;
import com.note8.sanxing.activities.AnswerQuestionActivity;
import com.note8.sanxing.activities.TodayDetailActivity;
import com.note8.sanxing.items.TodayClass;

import java.util.List;

/**
 * Created by lenovo on 2016/12/3.
 */
public class TodayAdapter extends ArrayAdapter<TodayClass> {

    private int resourceId;

    public TodayAdapter(Context context, int resource, List<TodayClass> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final TodayClass today = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView dateTxt = (TextView) view.findViewById(R.id.today_date_txt);
        TextView titleTxt = (TextView) view.findViewById(R.id.today_title_txt);
        TextView answerTxt = (TextView) view.findViewById(R.id.today_answer_txt);
        TextView bottomTxt = (TextView) view.findViewById(R.id.today_bottom_txt);
        ImageView answerImg = (ImageView) view.findViewById(R.id.today_answer_img);
        LinearLayout upperLayout = (LinearLayout) view.findViewById(R.id.today_upper_layout);
        LinearLayout totalLayout = (LinearLayout) view.findViewById(R.id.today_total_layout);

        ImageView goBtn = (ImageView) view.findViewById(R.id.today_go_btn);
        dateTxt.setText(today.date);
        titleTxt.setText(today.title);
        answerTxt.setText(today.content);
        bottomTxt.setText(today.bottomText);
        if (!today.showAnswer) {
            upperLayout.setVisibility(View.GONE);
        }
        if (today.hasPhoto) {
            answerImg.setImageResource(today.photoRes);
            answerImg.setVisibility(View.VISIBLE);
            answerTxt.setVisibility(View.GONE);
        } else {
            answerImg.setVisibility(View.GONE);
            answerTxt.setVisibility(View.VISIBLE);
        }
        totalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), today.date, Toast.LENGTH_SHORT).show();
                Intent intent;
                Bundle bundle = new Bundle();
                bundle.putString("date", today.date);
                bundle.putString("title", today.title);
                bundle.putString("content", today.content);
                bundle.putString("bottomText", today.bottomText);
//                if (position == 0) {  //  第一个item进入问题回答界面
//                    bundle.putBoolean("newAns", true);
//                } else {              //  其他进入当天问题及回答浏览界面
//                    bundle.putBoolean("newAns", false);
//                }
                bundle.putBoolean("newAns", !today.showAnswer);
                intent = new Intent(view.getContext(), TodayDetailActivity.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), today.date, Toast.LENGTH_SHORT).show();
                Intent intent;
                Bundle bundle = new Bundle();
                bundle.putString("date", today.date);
                bundle.putString("title", today.title);
                bundle.putString("content", today.content);
                bundle.putString("bottomText", today.bottomText);
                if (position == 0) {  //  第一个item进入问题回答界面
                    bundle.putBoolean("newAns", true);
                } else {              //  其他进入当天问题及回答浏览界面
                    bundle.putBoolean("newAns", false);
                }
                intent = new Intent(view.getContext(), TodayDetailActivity.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
        // the first vertical line of the view should be cut short
        if (today.id == 0) {
            FrameLayout line = (FrameLayout) view.findViewById(R.id.today_line_layout);
            FrameLayout line1 = (FrameLayout) view.findViewById(R.id.today_line_1_layout);
            line.setVisibility(View.GONE);
            line1.setVisibility(View.VISIBLE);
        }
        return view;
    }
}

