package com.note8.sanxing;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Answer_question extends AppCompatActivity {

    private Button question_btn;//查看问题的按钮
    private Button type_btn;//选择添加回答类型的按钮
    private Button done_btn;//提交按钮
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
        //点击查看问题的按钮
        question_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Answer_question.this,"回忆一下"+'\n'+"上一次跟父母聊天是什么时候呢？",Toast.LENGTH_SHORT).show();
            }
        });
        //点击添加回答类型的按钮
        type_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Answer_question.this);
                View dialogView = LayoutInflater.from(Answer_question.this).inflate(R.layout.question_answer_dialog,null);
                builder.setView(dialogView);
                //插入图片
                ImageButton picture_btn = (ImageButton)dialogView.findViewById(R.id.dia_picture_btn);
                picture_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Answer_question.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                    }
                });
                //插入语音
                Button voice_btn = (Button)dialogView.findViewById(R.id.dia_voice_btn);
                voice_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Answer_question.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                    }
                });
                //插入表情
                Button emoticon_btn = (Button)dialogView.findViewById(R.id.dia_emoticon_btn);
                emoticon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Answer_question.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
                    }
                });
                //插入音乐
                ImageButton music_btn = (ImageButton)dialogView.findViewById(R.id.dia_music_btn);
                music_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Answer_question.this,"此功能尚未开通，敬请期待",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Answer_question.this,"保存成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

