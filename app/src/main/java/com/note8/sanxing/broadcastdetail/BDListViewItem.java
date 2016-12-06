package com.note8.sanxing.broadcastdetail;

public class BDListViewItem {
    private int userAvatarRes;
    private String username;
    private String info;
    private String content;

    public BDListViewItem(int ua, String name, String i, String c) {
        this.userAvatarRes = ua;
        this.username = name;
        this.info = i;
        this.content = c;
    }

    public int getUserAvatarRes() { return this.userAvatarRes; }

    public String getUsername() { return this.username; }

    public String getInfo() { return this.info; }

    public String getContent() {return this.content; }
}
