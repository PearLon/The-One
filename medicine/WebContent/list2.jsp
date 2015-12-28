<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="main.jsp"%>

<%@ page import="formbean.*,java.sql.*,java.util.*"%>
<%
 userform user=(userform)session.getAttribute("user");

%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxpage=Integer.parseInt((String)request.getAttribute("maxpage"));
int pagenumber=Integer.parseInt((String)request.getAttribute("pagenumber"));
int start=number*8;//开始条数
int over=(number+1)*8;//结束条数
int count=pagenumber-over;//还剩多少条记录
if(count<=0){
  over=pagenumber;
  }
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
					<a href="manageuser.jsp"> 管理用户</a>
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

				<h2 class="mbx">药房中心 &gt; 中药</h2>

				<div class="cztable">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th style="text-align: left;" width="5%">编号</th>
							<th style="text-align: left;" width="10%">名称</th>
							<th width="5%">中西药</th>
							<th width="5%">儿童药</th>
							<th style="text-align: left;" width="10%">生产日期</th>
							<th style="text-align: left;" width="5%">保质期</th>
							<th style="text-align: left;" width="5%">库存</th>
							<th style="text-align: left;" width="15%">其他信息</th>
						</tr>
						<%for(int i=start;i<over;i++) {
        	String class1=null;
        	String class2=null;
             medicineform medicine=(medicineform)list.get(i);   
             if(medicine.getCLASS1()==1){
            	  class1="中药";
             }
             else{
            	  class1="西药";
             }
             if(medicine.getCLASS2()==1){
            	 class2="是";
             }
             else{
            	  class2="否";
             }
         %>
						<tr>
							<td><center>
									<%=medicine.getID() %></center></td>
							<td><center>
									<%=medicine.getNAME() %></center></td>
							<td><center>
									<%=class1 %></center></td>
							<td><center>
									<%=class2 %></center></td>
							<td><center>
									<%=medicine.getDATE() %></center></td>
									<td><center>
									<%=medicine.getDAYS() %></center></td>
							<td><center>
									<%=medicine.getNUMBER() %></center></td>
							<td><center>
									<%=medicine.getOTHERS() %></center></td>
						</tr>
						<%} %>


					</table>
					<br />
					<table width="90%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td width="13%">共为<%=maxpage%>页
							</td>
							<td width="16%">共有<%=pagenumber%>条记录
							</td>
							<td width="14%">当前为第<%=number+1%>页
							</td>
							<td width="19%">
								<form action="medicine.do" method="post">
									<input type="hidden" name="action" value="search1" />
									<%if((number+1)==1){%>
									已是第一页
									<%}else{%>

									<input type="hidden" name="i" value=<%=number-1 %> />
									<button type="submit">上一页</button>
							</td>
							<%}%>
							<td width="18%">
								<%if(maxpage<=(number+1)){%> 已是最后一页 <%}else{%> <input type="hidden"
								name="i" value=<%=number+1 %> />
								<button type="submit">下一页</button> <%}%>
								</form>
						</tr>
					</table>
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
