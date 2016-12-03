package com.note8.sanxing;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by BenWwChen on 2016/12/4.
 */

public class NearbyAdapter extends ArrayAdapter<NearbyClass>{
    private int resourceId;

    public NearbyAdapter(Context context, int resource, List<NearbyClass> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final NearbyClass nearby = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView avatarImage = (ImageView) view.findViewById(R.id.avatarImageView);
        TextView userNameTextView = (TextView) view.findViewById(R.id.usernameTextView);
        TextView questionTextView = (TextView) view.findViewById(R.id.questionTextView);

        Button answerButton = (Button) view.findViewById(R.id.nearbyAnswerButton);
        Button likeButton = (Button) view.findViewById(R.id.nearbyLikeButton);
        Button deleteButton = (Button) view.findViewById(R.id.nearbyDeleteButton);
        Button moreButton = (Button) view.findViewById(R.id.nearbyMoreButton);
        Button[] buttons = {answerButton, likeButton, deleteButton, moreButton};

        // set avatar image and texts
        avatarImage.setImageResource(nearby.avatarId);
        userNameTextView.setText(nearby.userName);
        questionTextView.setText(nearby.question);

        // adjust button image sizes
        int[] buttonImageIDs = {R.drawable.nearby_icon_reply, R.drawable.nearby_icon_like,
                R.drawable.nearby_icon_delete, R.drawable.nearby_icon_more};
        for (int i = 0; i < 4; ++i) {
            Drawable buttonImage = ContextCompat.getDrawable(view.getContext(), buttonImageIDs[i]);
            buttonImage.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
            Log.d("Sanxing", "button:" + i + " "+ buttons[i]);
            buttons[i].setCompoundDrawables(buttonImage, null, null, null);//只放左边
        }

        // set onclick listeners
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "answer no." + position, Toast.LENGTH_SHORT).show();
            }
        });
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "like no." + position, Toast.LENGTH_SHORT).show();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "delete no." + position, Toast.LENGTH_SHORT).show();
            }
        });
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "more no." + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
