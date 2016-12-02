# 三醒页面设计文档

## 整体页面
> 写到后面，难以一一详细说明了，就在置顶里大致说明了，主要就是：

* 配色，主题颜色的红色是@color/colorPrimary，背景颜色灰色是@color/colorBg，白色是@color/colorBgWhite
* 字体颜色，标题为@color/colorTextTitle，内容为@color/colorTextContent,更浅的字体为@color/colorTextShallow
* 字体大小，标题等大字体为@dimen/text_normal，内容等小字体为@dimen/text_small，其他可以自行定义
* 边距之类的基本就是16dp，8dp这样，得体即可
* 大小的话，dp和px在这套设计图里的换算关系是 1dp = 2px


## 今日页面
> 类似于时间轴，在首页上显示每天三个问题中的一个
今日问题在未回答时，不显示问题详情，只显示快去回答
周报的页面与此类似，只不过左侧日期会变成星期 12.5~12.11 之类的

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
* 右上方发起提问按钮，图像nearby_icon_add.png，大小36dp*36dp,右边距和上边距14dp

## 提问页面
> 在广播页面和附近页面会支持用户提交问题，也就是投稿或者提问
形式是一个对话框，AlertDialog之类的dialog
附近页面会多一个地理信息，那个雷达图标可以点击，一共三个状态，由深到浅分别500m(默认)\300m\100m

> via 明宇
提问部分，考虑到提问部分并不需要很多东西输入，制作成对话框更简洁。
第⼀一行默认标签那里可以左右滑动，第二行自定义标签那里可以输入，
⼀一旦输入，颜色变红。

## 问题详情
> 查看问题详情，三种问题模式都会有，其中广播页面和附近页面会加载所有人的评论（回答）
而今日问题和周报只会显示自己的评论，也就是回答
可以回答的时候，会显示“回答问题”按钮（eg. 回答今日问题和回答今日广播问题）
另外今日问题和周报分别有3个和7个问题，暂时就做成一个问题详情的列表形式好了...

## 回答问题
> 这里直接在另一个页面进行了，一个大的文本框，点击加号可以添加其他元素，暂时就是图片就好了
如果来不及，图片都可以先不加了orz...

> via 明宇
不使用弹出对话框，改成单独⼀一个输入页面（提供更专心的输入体验）。
默认隐藏原问题，通过点击上方!图标，原问题从上方划出显示⼀一段时间（或用Toast、对话框之类的实现）

## 其他布局问题
* 返回按钮可以不需要，在安卓规范里推荐用屏幕下方的虚拟按钮实现
* 问题详情和回答问题的顶栏自己在linearlayout规定一块矩形区域吧，因为整个app的actionBar是禁用的，背景就用主题红色即可


