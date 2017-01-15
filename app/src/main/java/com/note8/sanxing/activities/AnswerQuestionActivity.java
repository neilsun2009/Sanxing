package com.note8.sanxing.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.note8.sanxing.R;
import com.note8.sanxing.items.TodayClass;

public class AnswerQuestionActivity extends AppCompatActivity {
    private Button question_btn;//查看问题的按钮
    private Button type_btn;//选择添加回答类型的按钮
    private Button done_btn;//提交按钮
    private String title = "回忆一下"+'\n'+"上一次跟父母聊天是什么时候呢？";
    private int type = 1;
    EditText text;

    void findView(){
        question_btn = (Button)findViewById(R.id.answer_question_btn);
        type_btn = (Button)findViewById(R.id.answer_type_btn);
        done_btn = (Button)findViewById(R.id.answer_done_btn);
        text = (EditText) findViewById(R.id.answer_text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_answer_main);
        findView();

        //获得传入问题的标题和类型（默认为0）
        Intent intent = getIntent();
        if (intent.hasExtra("title"))
            title = intent.getStringExtra("title");
        type = intent.getIntExtra("type", 0);

        //点击查看问题的按钮
        question_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(AnswerQuestionActivity.this,title,Toast.LENGTH_SHORT).show();
                Snackbar.make(v,"问题："+title, Snackbar.LENGTH_LONG)
                        .setAction("知道了", new View.OnClickListener() {
                            @Override
                            public void onClick(View view1) {
                            }
                        }).show();
            }
        });
        //点击添加回答类型的按钮
        type_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AnswerQuestionActivity.this);
                final View dialogView = LayoutInflater.from(AnswerQuestionActivity.this).inflate(R.layout.question_answer_dialog,null);
                builder.setView(dialogView);
                //插入图片
                ImageButton picture_btn = (ImageButton)dialogView.findViewById(R.id.dia_picture_btn);
                picture_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(AnswerQuestionActivity.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                        Snackbar.make(dialogView,"图片功能尚未开通，敬请期待", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();

                    }
                });
                //插入语音
                Button voice_btn = (Button)dialogView.findViewById(R.id.dia_voice_btn);
                voice_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(AnswerQuestionActivity.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                        Snackbar.make(dialogView,"语音功能尚未开通，敬请期待", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();
                    }
                });
                //插入表情
                Button emoticon_btn = (Button)dialogView.findViewById(R.id.dia_emoticon_btn);
                emoticon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(AnswerQuestionActivity.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                        Snackbar.make(dialogView,"表情功能尚未开通，敬请期待", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();
                    }
                });
                //插入音乐
                ImageButton music_btn = (ImageButton)dialogView.findViewById(R.id.dia_music_btn);
                music_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(AnswerQuestionActivity.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                        Snackbar.make(dialogView,"音乐功能尚未开通，敬请期待", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();
                    }
                });
                builder.show();
            }
        });
        //点击提交按钮
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer_text = text.getText().toString();//回答的内容
                if (type == 2 || type == 3) {
                    if (!answer_text.equals("")){
                        Snackbar.make(v,"提交成功，等待审核", Snackbar.LENGTH_LONG)
                                .setAction("返回主页面", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                        finish();
                                    }
                                }).show();
                    }
                    else {
                        //Toast.makeText(AnswerQuestionActivity.this,"回答内容不能为空",Toast.LENGTH_SHORT).show();
                        Snackbar.make(v,"回答内容不能为空", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();
                    }
                    //Toast.makeText(AnswerQuestionActivity.this,"提交成功，等待审核",Toast.LENGTH_SHORT).show();
                }
                if (type == 1) {
                    if(!answer_text.equals("")){

                        TodayClass.todayList.get(0).bottomText = "今日三问已完成，查看全部";
                        TodayClass.todayList.get(0).title = title;
                        TodayClass.todayList.get(0).content = answer_text;
                        TodayClass.todayList.get(0).gotoAnswer = true;
                        //Toast.makeText(AnswerQuestionActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                        Snackbar.make(v,"保存成功", Snackbar.LENGTH_LONG)
                                .setAction("返回时光轴", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                        Intent intent = new Intent(AnswerQuestionActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).show();
                        Intent intent = new Intent(AnswerQuestionActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        //Toast.makeText(AnswerQuestionActivity.this,"回答内容不能为空",Toast.LENGTH_SHORT).show();
                        Snackbar.make(v,"回答内容不能为空", Snackbar.LENGTH_LONG)
                                .setAction("知道了", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view1) {
                                    }
                                }).show();
                    }
                }
            }
//            @Override
//            public void onClick(View v) {
//                String answer_text = text.getText().toString();//回答的内容
//                Toast.makeText(AnswerQuestionActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
//                finish();
//            }
        });
    }
}

