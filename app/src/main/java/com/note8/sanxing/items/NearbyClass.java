package com.note8.sanxing.items;

import com.note8.sanxing.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by BenWwChen on 2016/12/4.
 */

public class NearbyClass {
    public int avatarId;
    public String userName;
    public String question;
    public NearbyClass(int _avatarId, String _userName, String _question) {
        avatarId = _avatarId;
        userName = _userName;
        question = _question;
    }
    public static ArrayList<NearbyClass> nearbyList = initNearbyData();
    private static ArrayList<NearbyClass> initNearbyData() {
        NearbyClass[] nearbyArray = {
                new NearbyClass(R.drawable.nearby_avatar1, "单身狗狗", "你觉得在中大东校园读书必做的十件事有哪些？"),
                new NearbyClass(R.drawable.nearby_avatar2, "美琪", "巴啦啦正能量可以消除你今天的什么烦恼？"),
                new NearbyClass(R.drawable.nearby_avatar3, "啦啦啦", "中大一饭什么最好吃？")
        };

        ArrayList<NearbyClass> nearbyList = new ArrayList(Arrays.asList(nearbyArray));

        return nearbyList;
    }
}
