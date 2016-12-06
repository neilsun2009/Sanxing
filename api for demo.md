> 只是针对demo而已。。。

**全都直接用intent的putExtra()和getIntExtra(), getStringExtra()那些传递数据吧，不用bundle了。**

# 时光轴 - 展博
点击箭头进入问题详情页面
传递参数
    num = 3
    title = 问题题目
    type = 1
    anAnswer = true（今日）false（往日）
    answer = 答案
注意按照问题清单初始化假问题

# 广播 - 展博
单击图片进入问题详情页面
传递参数
    num = 1
    title = 问题题目
    type = 2
    canAnswer = true（今日）false（往日）
    answer = ""
    
# 附近 - 伟威
点击回答，直接进入回答问题界面，传递参数问题题目title, 和问题type=3，参见回答问题页面
点击更多，进入问题详情页面，对应参数为：
    num = 1
    title = 问题题目
    type = 3
    canAnswer = true
    answer = ""
删除和喜欢先不做逻辑了
注意按照问题清单初始化假问题

# 发现 - 展博
不需要实现啊哈哈哈哈哈

# 个人中心 - 展博
提问和收藏先不理，周报与时光轴近似，传递数据中个数改为7而已

# 问题详情页面 - 明宇
> 不知道明宇现在做的界面样式如何，这个页面会显示一个或多个问题的详情
这里传进来的参数只决定第一个问题，后面的全是静态数据
回答那一项，如果实现很麻烦的话，就暂时只做当前用户那一个人的回答吧...

接收一群参数：
* int num 问题个数，也就是listview里有多少个问题及答案，正常是1，时间轴点进来是3，周报点进来是7
* String title 问题题目
* int type 问题种类 1: 普通投放问题，2: 广播问题，3：附近问题
* boolean canAnswer 是否允许回答，也就是是否显示去回答按钮
* String answer 问题答案，只有时光轴和周报会传递答案，放在第一条问题的第一个回答吧，如果为空字符串，就填一个普通的静态数据

点击回答按钮，去往回答问题页面，并传递参数title和type

# 提问对话框 - 文洁
暂时假定提问都需要审核？就不做逻辑了~

# 回答问题页面 - 文洁
接受两个参数，
* string title 问题标题
* int type 问题种类 1: 普通投放问题，2: 广播问题，3：附近问题
提交回答后，如果问题种类为 1 也即普通投放问题，更新todayclass的静态list的数据
    TodayClass today = TodayClass.todayList.get(0);
    today.bottomText = "查看全部";
    today.title = 问题标题;
    today.content = 答案;
    today.showAnswer = true;
其他问题类型不需要考虑