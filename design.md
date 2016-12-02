# 三醒页面设计文档

## 今日页面
> 类似于时间轴，在首页上显示每天三个问题中的一个
* 页面背景@color/colorBg
* 每日信息为列表项，推荐使用listview完成，即在另一个xml中完成列表项内部布局、java中添加数据
* 列表项整体左右边距28dp，两个项目之间16dp
* 列表左侧日期，颜色@color/colorTextHighlight, 数字大小为@dimen/text_normal，月份大小根据数字调整，可能是12dp
* 左侧圆点宽高18dp, 图片为today_list_point.png，线条为4dp宽，颜色@color/colorPrimary
* 问题显示部分，左侧线条宽度4dp，颜色@color/colorPrimary，问题部分背景@color/colorBgWhite
* 头像宽高40dp，图片为avatar.png，左右边距15dp
* 问题标题颜色@color/colorTextTitle，大小@dimen/text_normal
* 内容颜色@color/colorTextContent，大小@dimen/text_small
* 文字部分右边距20dp, 底边距15dp
* 查看详情颜色@color/colorTextShallow, 大小@dimen/text_small
* 右侧箭头30dp*25dp, 图片today_list_arrow.png
* 下拉查看最新和下箭头暂时不需要实现

