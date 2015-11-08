# 页面截图：
![1](http://ww2.sinaimg.cn/mw1024/d39fda55gw1extvn60tjbj20s80fxwj5.jpg)
# 前台代码：

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	校医院管理信息系统
</title><link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
            showUnreadSysMsgCount();
        });

        //我的信息头部选项卡
        function setStudMsgHeadTabCheck() {
            var currentUrl = window.location.href;
            currentUrl = currentUrl.toLowerCase();
            var asmhm = "";
            $("#ulStudMsgHeadTab li").each(function () {
                asmhm = $(this).find('a').attr("href").toLowerCase();
                if (currentUrl.indexOf(asmhm) > 0) {
                    $(this).find('a').attr("class", "tab1");
                    return;
                }
            });
        }

        //显示未读系统信息
        function showUnreadSysMsgCount() {
            var unreadSysMsgCount = "0";
            if (Number(unreadSysMsgCount) > 0) {
                $("#unreadSysMsgCount").html("(" + unreadSysMsgCount + ")");
            }
        }

        //退出
        function loginOut() {
            if (confirm("确定退出吗？")) {
                StudentLogin.loginOut(function (data) {
                    if (data == "true") {
                        window.location = "/Login.aspx";
                    }
                    else {
                        jBox.alert("退出失败！", "提示", new { buttons: { "确定": true} });
                    }
                });
            }
        }
        //更改
        function changeCateory(thisObj, id) {
            var oldCateoryId = $("#cateoryId").val();
            var cateoryId = "";
            if (id != null) {
                cateoryId = id;
            }
            else {
                cateoryId = thisObj.val();
            }
            var studentId = $("#studentId").val();
            if (cateoryId.length <= 0) {
                jBox.tip("不能为空！");
                if (id == null) {
                    thisObj.val(oldCateoryId);
                }
            }
            else {
                studentInfo.changeStudentCateory(cateoryId, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        window.location.href = "/Index.aspx";
                    }
                    else {
                        jBox.tip(result.message);
                    }
                });
            }
        }
    </script>
    
    <script src="Script/changeOption.js" type="text/javascript"></script>
    <script src="Script/rl.js" type="text/javascript"></script>
</head>
<body>



    <div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="Index.aspx.html">
                        
                    </a>
                </div>
                <div class="topxx">
                    <select onchange="changeCateory($(this))" style="font-size: 11px; background: #4991cf;
                        color: #fff;">
                        
                        <option 
                            value="4">
                            1</option>
                        
                        <option selected='selected'
                            value="1">
                            2</option>
                        
                    </select>
                    9133630医生：常得琳，欢迎您！ <a href="MyInfo/Index.aspx.html">我的信息</a> <a href="User/StudentInfor/systemMsge.aspx.html">
                        通知</a> <a href="User/Account/ChangePasswd.aspx.html">密码修改</a> <a onclick="loginOut()"
                            href="javascript:">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="Index.aspx.html">药品查询</a></li>
                        <li><a href="EducationCenter/Score.aspx.html">药品管理</a></li>
                        <li><a href="MyAccount/wdcw.aspx.html">预购药品</a></li>
                        <li><a href="OnlineTeaching/StudentMaterial.aspx.html">过期处理</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="MyInfo/Index.aspx.html">个人信息</a></div>
                        <div>
                            <a href="MyInfo/ClassInfo.aspx.html">账号信息 </a>
                        </div>
                        <div>
                            <a href="User/StudentInfor/Letter.aspx.html">短信息</a></div>
                        <div>
                            <a href="User/StudentInfor/systemMsge.aspx.html">其他通知</a></div>
                        <div>
                            <a href="MyInfo/Objection.aspx.html">我的反馈</a></div>
                    </div>
                    <div class="ta1">
                        <strong>药房中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="EducationCenter/Application.aspx.html">中药</a></div>
                        <div>
                            <a href="EducationCenter/Score.aspx.html">西药</a></div>
                        <div>
                            <a href="EducationCenter/Book.aspx.html">儿童专区</a></div>
                    </div>
                    <div class="ta1">
                        <strong>订单中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="OnlineTeaching/StudentMaterial.aspx.html">入库订单</a></div>
                        <div>
                            <a href="OnlineTeaching/StudentStudyRecordList.aspx.html">出库订单</a></div>
                    </div>
                   
                    <div class="ta1">
                        <strong>反馈中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="MyAccount/wdcw.aspx.html">我要反馈</a></div>
                    </div>
<div class="ta1">
                        <a href="#" target="_blank"><strong>其他内容</strong></a>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        快速访问&nbsp;&nbsp;&nbsp;&nbsp;</h2>

    <div class="dhbg">
        <div class="dh1" style="margin: 0 27px 15px 0;">
            <div class="dhwz">
                <p>
                    药品库中共有 <span class="red">128 </span>类中药
                </p>
                <p>
                    共有 <span class="red">234 </span>类西药
                </p>
                <p>
                    有 <span class="red">12</span>类药品存在缺货</p>
                <div class="btright">
                    <a href="User/StudentInfor/Letter.aspx.html">
                        <img src="images/Student/default/bt_bzr.jpg" alt="给班主任发消息" width="121" height="25" /></a></div>
            </div>
        </div>
        <div class="dh2">
            <div class="dhwz">
                <form action="">
                <p>
                    药品名称：<input type="text" name="" id="" />
                </p>
                <p>
                    药品编号：<input type="text" name="" id="" />
                </p>
                <p>
                    药品代码：<input type="text" name="" id="" />
                </p>
                <div class="btright">
                    <a href="EducationCenter/Application.aspx.html">
                        <img src="images/Student/default/bt_jw.jpg" alt="点击出库" width="121" height="25" /></a></div>
                </form>
            </div>
        </div>
        <div class="dh3" style="margin: 0 27px 15px 0;">
            <div class="dhwz">
                <p>
                    药品名称：<input type="text" name="" id="" />
                </p>
                <p>
                    OR                
                </p>
                <p>
                    药品编号：<input type="text" name="" id="" />
                </p>
                <div class="btright">
                    <a href="http://sm.zk0731.com/User/ExamCenter/ExamPractice/ListExam.aspx?ptid=1">
                        <img src="images/Student/default/bt_ks.jpg" alt="进入考试中心" width="121" height="25" /></a></div>
            </div>
        </div>
        <div class="dh4">
            <div class="dhwz">
                <p>
                    过期药品共有<span class="blue">12</span> 类，数量<span class="green">290</span></p>
                    <p>
                    将要过期的药品共有 <span class="blue">10</span> 类，数量<span class="green">190</span></p>
                <p>
                    <span class="red">请及时处理！</span>
                </p>
                
                <div class="btright">
                    <a href="MyAccount/wdcw.aspx.html">
                        <img src="images/Student/default/bt_cw.jpg" alt="进入财务中心" width="121" height="25" /></a></div>
            </div>
        </div>
    </div>

 
        <div class="footer">
            <p>
                &copy;copyright 2015 THE ONE TEAM 版权所有 </p>
        </div>
    </div>
	<div style="text-align:center;">
</div>
</body>
</html>
