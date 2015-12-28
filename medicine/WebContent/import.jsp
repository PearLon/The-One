<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="login.jsp"%>
<%@ page import="formbean.*,java.sql.*,java.util.*"%>
<%
 userform user=(userform)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校医院管理信息系统</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
<script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
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
					<a href="Index.aspx.html"> </a>
				</div>
				<div class="topxx">


					<%=user.getNAME()%></>医生，欢迎您！ <a href="myinfo.jsp">我的信息</a>
					<%if(user.getCLASS()==1){ %>
					<a href="management.jsp"> 管理用户</a>
					<%}else{
                    		 }%>

					<a href="password.jsp">密码修改</a> <a
						onclick="javascript:if (confirm('确定离开吗？')) { return true;}else{return false;};"
						href="loginOut.jsp">安全退出</a>
				</div>
				<div class="blog_nav">
					<ul>
						<li><a href="#">药品查询</a></li>
						<li><a href="#">药品管理</a></li>
						<li><a href="total.do?action=search">销售明细</a></li>
                        <li><a href="date.jsp">过期处理</a></li>
                        <li><a href="medicine.do?action=searchn">返回首页</a></li>
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
                            <a href="myinfo.jsp">个人信息</a></div>

                        <div>
                            <%if(user.getCLASS()==1){ %>
                    		<a href="manageuser.jsp"> 管理用户</a>
                    		 <%}else{
                    		 }%></div>
                        <div>
                           <a href="password.jsp">密码修改</a></div>
                        
                    </div>
                    <div class="ta1">
                        <strong>药房中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="medicine.do?action=search1">中药</a></div>
                        <div>
                            <a href="medicine.do?action=search2">西药</a></div>
                        <div>
                            <a href="medicine.do?action=search3">儿童专区</a></div>
                    </div>
                    <div class="ta1">
                        <strong>订单中心</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="import.do?action=search">入库订单</a></div>
                        <div>
                            <a href="total.do?action=search">出库订单</a></div>
                    </div>
                   
                    <div class="ta1">
                        <strong>其他操作</strong><div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="date.jsp">过期处理</a></div>
                             <div>
                            <a href="total.do?action=search">销售明细</a></div>
                    </div>
<div class="ta1">
                        <a href="#"><strong>团队介绍</strong></a>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                </div>
            </div>
			<div class="rightbox">

				<h2 class="mbx">快速访问 &gt; 药品入库</h2>



				<div class="cztable">

					<div class="tis red">注：认真填写以下各项信息，确保准确无误。</div>

					<form method="post" action="medicine.do?action=add">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td width="15%" align="right"><div align="center">药品名称
									</div></td>
								<td><input id="Ctitle" size="20" name="NAME"
									class="input_2" /></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">药品编号
									</div></td>
								<td><input id="Ctitle" size="20" name="ID" class="input_2" /></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">
										药品种类</div></td>
								<td><select id="Ctype" name="CLASS1">
										<option value="Unselected">请选择</option>
										<option value="1">中药</option>
										<option value="2">西药</option>
								</select></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">
										是否儿童药</div></td>
								<td><select id="Ctype" name="CLASS2">
										<option value="Unselected">请选择</option>
										<option value="1">是</option>
										<option value="2">否</option>
								</select></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">生产日期
									</div></td>
								<script language="javascript" type="text/javascript"
									src="My97DatePicker/WdatePicker.js"></script>


								<td><input class="Wdate" type="text"
									onClick="WdatePicker()" name="DATE"> <font color=blue>&lt;&lt;点击选择</font></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">保质期
									</div></td>
								<td><input id="Ctitle" size="20" name="DAYS"
									class="input_2" /><span class="tis red"> 单位：月 </span></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">入库数量
									</div></td>
								<td><input id="Ctitle" size="20" name="NUMBER"
									class="input_2" /></td>
							</tr>
							<tr>
								<td width="15%" align="right"><div align="center">
										备注信息</div></td>
								<td><textarea name="OTHERS" cols="80" rows="5"
										id="Ccontent" class="input_2"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div align="center">
										<input
											onclick="javascript:if (confirm('确认？')) { return true;}else{return false;};"
											type="submit" value="提交" class="input2" /> <a
											href="medicine.do?action=searchn"><input type="button" value="返回"
											class="input2" /></a>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>

			</div>
		</div>


		<div class="footer">
			<p>&copy;copyright 2015 THE ONE TEAM 版权所有</p>
		</div>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>
