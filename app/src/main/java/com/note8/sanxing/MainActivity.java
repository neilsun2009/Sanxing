package com.note8.sanxing;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            List<TodayClass> todayList = initTodayData();
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

                    }
                });
                linearLayout.addView(imageView);
            }
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
