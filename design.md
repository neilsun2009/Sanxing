# 三醒页面设计文档

## 今日页面
> 类似于时间轴，在首页上显示每天三个问题中的一个
今日问题在未回答时，不显示问题详情，只显示快去回答

* 页面背景@color/colorBg
* 每日信息为列表项，推荐使用listview完成，即在另一个xml中完成列表项内部布局、java中添加数据
* 列表项整体左右边距28dp，两个项目之间16dp
* 列表左侧日期，颜色@color/colorTextHighlight, 数字大小为@dimen/text_normal，月份大小根据数字调整，可能是12dp
* 左侧圆点宽高18dp, 图片为today_list_point.png，线条为4dp宽，颜色@color/colorPrimary
* 问题显示部分，左侧线条宽度4dp，颜色@color/colorPrimary，问题部分背景@color/colorBgWhite
* 头像宽高40dp，图片为avatar.png，左右边距15dp
* 问题标题颜色@color/colorTextTitle，大小@dimen/text_normal
* 内容颜色@color/colorTextContent，大小@dimen/text_small
* 内容如果为图片的话，充满容器，示例图片today_list_photo.jpg
* 文字部分右边距20dp, 底边距15dp
* 查看详情颜色@color/colorTextShallow, 大小@dimen/text_small
* 右侧箭头30dp*25dp, 图片today_list_arrow.png
* 下拉查看最新和下箭头暂时不需要实现

## 附近页面
> 显示附近问题

* 靶心宽高230dp，背景图nearby_circle.png
* 靶心中头像宽高40dp，暂时都统一这一个大小吧...边框颜色#f9b0a8
* 靶心所在部分背景灰色为@color/colorBg
* 数量框两个矩形横向各占50%，高度60dp，左侧颜色@color/colorAccent，右侧@color/colorAccentDarker
* '附近的人''附近的问题'字体大小@dimen/text_normal，上方数字适当用更大的字号
* 下方为一个listview，左右边距为44dp
* 头像资源为nearby_avatar1~3.png，横纵50dp
* 问题标题颜色@color/colorTextTitle，大小@dimen/text_normal
* 内容颜色@color/colorTextContent，大小@dimen/text_small
* 下方按钮大小15dp宽高，对应文字@color/colorTextShalow，大小@dimen/text_small，图标资源在nearby_icon_***.png

