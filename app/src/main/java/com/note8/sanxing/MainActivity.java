package com.note8.sanxing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private ImageView mainUserImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mainUserImg = (ImageView) findViewById(R.id.main_user_img);
        mainUserImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeActivity.class);
                startActivity(intent);
            }
        });

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";



        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int num = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView = null;
            switch (num) {
                case 1: // today
                    rootView = inflater.inflate(R.layout.fragment_today, container, false);
                    initToday(rootView);
                    break;
                case 2: // broadcast
                    rootView = inflater.inflate(R.layout.fragment_broadcast, container, false);
                    initBroadcast(rootView);
                    break;
                case 3: // nearby
                    rootView = inflater.inflate(R.layout.fragment_nearby, container, false);
                    initNearby(rootView);
                    break;
                case 4: // find
                    rootView = inflater.inflate(R.layout.fragment_find, container, false);
                    initFind(rootView);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_main, container, false);
                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    break;
            }
            return rootView;
        }

        private void initToday(final View rootView) {
            // declare
            ListView listView = (ListView) rootView.findViewById(R.id.today_list);

            List<TodayClass> todayList = TodayClass.todayList;
            TodayAdapter adapter = new TodayAdapter(rootView.getContext(), R.layout.listview_today, todayList);
            listView.setAdapter(adapter);
        }

        private ArrayList<TodayClass> initTodayData() {
            ArrayList<TodayClass> list = new ArrayList<>();
            TodayClass temp = new TodayClass(0, "12-10", "今天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                    0, false, "快去回答", false);
            list.add(temp);
            temp = new TodayClass(1, "12-09", "昨天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                    0, false, "查看回答", true);
            list.add(temp);
            temp = new TodayClass(2, "12-08", "前天的问题", "我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                    R.drawable.today_list_photo, true, "查看回答", true);
            list.add(temp);
            temp = new TodayClass(3, "12-07", "大前天的问题", "我还是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                    0, false, "查看回答", true);
            list.add(temp);
            temp = new TodayClass(4, "12-06", "标题特别特别长的问题", "我还是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案我是答案",
                    0, false, "查看回答", true);
            list.add(temp);
            return list;
        }

        private void initBroadcast(final View rootView) {
            // declare
            ImageView todayImg = (ImageView) rootView.findViewById(R.id.broadcast_today_img);
            ImageView submitImg = (ImageView) rootView.findViewById(R.id.broadcast_submit_img);
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.broadcast_list_layout);

            // open send question dialog
            sendBroadcastQuestion(rootView, submitImg);

            // list of history broadcast questions
            final int[] listImg = new int[] {R.drawable.broadcast_img_2, R.drawable.broadcast_img_3, R.drawable.broadcast_img_4};
            for (int i = 0; i < 3; ++i) {
                ImageView imageView = new ImageView(rootView.getContext());
                imageView.setImageResource(listImg[i]);
//                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.broadcast_image_height)));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)getResources().getDimension(R.dimen.broadcast_image_height));
                lp.setMargins(0, (int)getResources().getDimension(R.dimen.model_margin_title), 0, 0);
                imageView.setLayoutParams(lp);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // todo: open question detail activity
                    }
                });
                linearLayout.addView(imageView);
            }
        }

        private void initNearby(final View rootView) {
            // get the listview and set its adapter
            ListView listView = (ListView) rootView.findViewById(R.id.nearbyListView);
            List<NearbyClass> nearbyList = initNearbyData();
            NearbyAdapter adapter = new NearbyAdapter(
                    rootView.getContext(), R.layout.fragment_nearby_list_item, nearbyList
            );
//            SimpleAdapter adapter = new SimpleAdapter(
//                    rootView.getContext(), nearbyList,
//                    R.layout.fragment_nearby_list_item,
//                    new String[] {"avatar", "username", "question"},
//                    new int[] {R.id.avatarImageView, R.id.usernameTextView, R.id.questionTextView}
//                    );
            listView.setAdapter(adapter);

            // get the ask question button and set listener
            ImageButton askButton = (ImageButton) rootView.findViewById(R.id.askNearbyButton);
            askButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(rootView.getContext(), "put intent to ask page here", Toast.LENGTH_SHORT).show();
                }
            } );
            /******************************** Add by Wiki ************************************/
            //点击编辑问题的按钮弹出问题编辑对话框（暂将该按钮随意放在附近页面）
            // final Button send_nearby_btn = (Button)rootView.findViewById(R.id.send_nearby_btn);
            sendNearbyQuestion(rootView, askButton);

            // get and set the nums text
            TextView numOfPeopleNearbyTextView = (TextView) rootView.findViewById(R.id.numOfPeopleNearByTextView);
            TextView numOfQuestionNearbyTextView = (TextView) rootView.findViewById(R.id.numOfQuestionsNearByTextView);
            numOfPeopleNearbyTextView.setText("3");
            numOfQuestionNearbyTextView.setText("20");
        }

        private ArrayList<NearbyClass> initNearbyData() {
            NearbyClass[] nearbyArray = {
                    new NearbyClass(R.drawable.nearby_avatar1, "提问者1", "我是问题1我是问题1我是问题1我是问题1我是问题1我是问题1我是问题1"),
                    new NearbyClass(R.drawable.nearby_avatar2, "提问者2", "我是问题2我是问题2我是问题2我是问题2我是问题2我是问题2我是问题2我是问题2我是问题2"),
                    new NearbyClass(R.drawable.nearby_avatar3, "提问者3", "我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3我是问题3")
            };

            ArrayList<NearbyClass> nearbyList = new ArrayList(Arrays.asList(nearbyArray));

            return nearbyList;
        }

        private void initFind(final View rootView) {
//            rootView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            // declare
            Button btn1 = (Button) rootView.findViewById(R.id.find_btn_1);
            Button btn2 = (Button) rootView.findViewById(R.id.find_btn_2);
            Button btn3 = (Button) rootView.findViewById(R.id.find_btn_3);
            // listener
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(rootView.getContext(), "该功能尚未开通", Toast.LENGTH_SHORT).show();
                }
            };
            btn1.setOnClickListener(onClickListener);
            btn2.setOnClickListener(onClickListener);
            btn3.setOnClickListener(onClickListener);
        }

        /******************************** Add by Wiki ************************************/
        //除雷达部分外对话框的事件处理
        private void sendQuestion(final View dialogView,final AlertDialog.Builder builder){
            final EditText user_def_tag = (EditText)dialogView.findViewById(R.id.user_def_tag);
            user_def_tag.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus || !user_def_tag.getText().toString().equals("")){
                        user_def_tag.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        user_def_tag.setTextColor(getResources().getColor(R.color.colorTextWhite));
                        user_def_tag.setHint("");
                    }
                    else{
                        user_def_tag.setBackground(getResources().getDrawable(R.drawable.border_shadow_tang));
                        user_def_tag.setHint("自定义标签");
                    }
                }
            });
            //可多选标签项
            CheckBox tag1 = (CheckBox)dialogView.findViewById(R.id.tag1);
            CheckBox tag2 = (CheckBox)dialogView.findViewById(R.id.tag2);
            CheckBox tag3 = (CheckBox)dialogView.findViewById(R.id.tag3);
            CheckBox tag4 = (CheckBox)dialogView.findViewById(R.id.tag4);
            CheckBox tag5 = (CheckBox)dialogView.findViewById(R.id.tag5);
            CheckBox tag6 = (CheckBox)dialogView.findViewById(R.id.tag6);

            //用户编辑问题输入框
            EditText send_broadcast_que = (EditText)dialogView.findViewById(R.id.send_broadcast_que);

            //对话框确定和取消按钮
            final Button cancel_btn = (Button)dialogView.findViewById(R.id.cancel_btn);
            final Button sure_btn = (Button)dialogView.findViewById(R.id.sure_btn);
            final Dialog dialog = builder.show();

            cancel_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            sure_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(getActivity(),"提交成功，等待审核",Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();

        }

        /******************************** Add by Wiki ************************************/
        //向附近发送问题的按钮的监听事件处理方法
        private void sendNearbyQuestion(final View rootView,ImageButton send_nearby_btn){
            send_nearby_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    final View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.send_question_dialog,null);
                    builder.setView(dialogView);

                    final Button radar_btn = (Button)dialogView.findViewById(R.id.radar_hint);
                    final TextView distance_hint = (TextView)dialogView.findViewById(R.id.distance_hint);
                    TextView dialog_title = (TextView)dialogView.findViewById(R.id.dialog_title);
                    dialog_title.setText("向附近的人提问");

                    final String[] distance = {"向500米内\n小伙伴们提问","向300米内\n小伙伴们提问","向100米内\n小伙伴们提问"};
                    final int[] radar_pic = {R.drawable.nearby_icon_radar1,R.drawable.nearby_icon_radar2,R.drawable.nearby_icon_radar3};

                    SpannableStringBuilder style = new SpannableStringBuilder(distance_hint.getText().toString());
                    style.setSpan(new ForegroundColorSpan(Color.RED),1,5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                    distance_hint.setText(style);
                    radar_btn.setTag(0);
                    radar_btn.setOnClickListener(new View.OnClickListener() {
                        int tag = (Integer)radar_btn.getTag();
                        @Override
                        public void onClick(View v) {
                            tag = (Integer)radar_btn.getTag();
                            if(tag == 2) tag = -1;
                            tag++;
                            radar_btn.setTag(tag);
                            radar_btn.setBackground(getResources().getDrawable(radar_pic[tag]));
                            String distant_text = distance[tag];
                            SpannableStringBuilder style = new SpannableStringBuilder(distant_text);
                            style.setSpan(new ForegroundColorSpan(Color.RED),1,5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                            distance_hint.setText(style);
                        }
                    });
                    //调用方法处理组件数据
                    sendQuestion(dialogView,builder);
                }
            });
        }
        /******************************** Add by Wiki ************************************/
        //发送广播问题的按钮的监听事件处理方法
        private void sendBroadcastQuestion(final View rootView,ImageView send_broadcast_btn){
            send_broadcast_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    final View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.send_question_dialog,null);
                    builder.setView(dialogView);
                    dialogView.findViewById(R.id.radar_view).setVisibility(View.GONE);

                    TextView dialog_title = (TextView)dialogView.findViewById(R.id.dialog_title);
                    dialog_title.setText("广播提问");
                    sendQuestion(dialogView,builder);
                }
            });
        }
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "时光轴";
                case 1:
                    return "广播";
                case 2:
                    return "附近";
                case 3:
                    return "发现";

            }
            return null;
        }
    }
}
