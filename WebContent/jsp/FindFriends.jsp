<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.icode.chengcheng.vo.ShowActInIndex"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
<title>城程网</title>
<meta name="keywords" content="活动,交友,出游,购物" />
<meta name="description" content="立足活动圈，管理休闲时间，找到活动同伴" />
<link href="/chengcheng/css/chengcheng.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/chengcheng/favicon.ico">
<script language="javascript">
function message(id,bid,bid1){
	// 获取页面中所有的消息回复表单行对象的集合
	var lstTr = document.getElementsByName("text");
	var lstTrb = document.getElementsByName("button");
	var lstTrb1 = document.getElementsByName("button1");
	// 使用循环遍历每个对象将其显示属性设置为none
	for(var i=0; i<lstTr.length; i++){
		lstTr[i].style.display = "none";
	}
	for(var i=0; i<lstTrb.length; i++){
		lstTrb[i].style.display = "none";
	}
	for(var i=0; i<lstTrb1.length; i++){
		lstTrb1[i].style.display = "none";
	}
	// 将需要显示的回复表单行对象进行显示
	document.getElementById(id).style.display = "block";
	document.getElementById(bid).style.display = "block";
	document.getElementById(bid1).style.display = "block";
}
function stopmessage(id,bid,bid1){
	document.getElementById(id).style.display = "none";
	document.getElementById(bid).style.display = "none";
	document.getElementById(bid1).style.display = "none";
}
</script>
</head>
<body onLoad="findFriend()">

<div id="templatemo_body_wrapper6">
  <div id="templatemo_wrapper6">
    <div id="templatemo_header">
     <div id="site_title"> <a href="#" ><img src="/chengcheng/images/logo.png" width="103" height="97" /><span>chengcheng</span> </a> </div>
    </div>
    <!-- end of templatemo_header -->
    <div id="templatemo_menu6">
      <div id="search_box">
         <form action="/chengcheng/SearchActServlet" method="get">
          <input type="text" value="" name="search" size="45" id="search" title="usernmae" />
          <label>
            <select name="select" id="select">
              <option value="actname" selected>活动名称</option>
              <option value="acttopic">活动主题</option>
              <option value="actcontent">活动内容</option>
            </select>
          </label>
          <input type="submit" name="login" value="找活动" alt="login" id="submit_btn" title="Login" />
        </form>
      </div>
      <ul>
          <li><a href="/chengcheng/ShowInIndexServlet">首页</a></li>
        <li><a href="/chengcheng/ShowInPersonalServlet">个人主页</a></li>
        <li><a href="/chengcheng/FriendServlet"class="current">好友</a></li>
        <li></li>
       <li><a href="/chengcheng/ShowInActivityCircleServlet?type=0">活动</a></li>
        <li><a href="/chengcheng/jsp/chatrooms.jsp">聊天室</a></li>
       <li>   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;                               
         &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp; </li>   
                    <span> <a href="/chengcheng/jsp/login.jsp">退出登录</a></span>
    </ul>
    </div>
    <!-- end of templatemo_menu -->
    <div id="templatemo_content_wrapper">
      <div class="templatemo_sidebar_wrapper float_l">
        <div class="templatemo_sidebar_top"></div>
        <div class="templatemo_sidebar">
          <div class="sidebar_box">
            <h2>个人信息</h2>
        <div class="sidebar_box_content">
          <div>
            <span> <img src="/chengcheng/upload/images/photo/${sessionScope.user.uphoto}" width="150" height="158" /><img src="/chengcheng/images/xrw.png" width="27" height="29" /> ${sessionScope.user.uname}</span>
        </div>
              <div class="discount">更多</div>
          </div>
          <div class="sidebar_box">
            <h2>城程应用</h2>
              <div class="sidebar_box_content">
              <ul class="categories_list">
                <li><a href="/chengcheng/jsp/publishactivity.jsp">发活动</a></li>
                <li><a href="/chengcheng/ShowInActivityCircleServlet?type=0">活动圈</a></li>
                <li><a href="/chengcheng/ShowInAboutMeServlet">与我相关</a></li>
                <li><a href="/chengcheng/FriendServlet">好友</a></li>
                <li><a href="/chengcheng/ShowActByAdminServlet">活动广场</a></li>
              </ul>
            </div>
            </div>
          </div>
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div id="templatemo_content">
       <div id="content_top"></div>
        <div id="content_middle">
     
          <table width="100%" border="0">
            <tr align="center" valign="middle">
              <td width="33%" height="30"><h2><strong><a href="/chengcheng/FriendServlet">好友</a></strong></h2></td>
              <td width="34%" height="30"><h2><strong><a href="/chengcheng/FindFriendsServlet">添加好友</a></strong></h2></td>
              <td width="33%" height="30"><form action="/chengcheng/SearchNewFriendServlet" method="get">
             <input type="text" name="searchfri"  id="searchfri"  value="" size="15" />
           
            <input type="submit" name="submit_btn2"   id="submit_btn2"value="寻找新朋友"  />
             </form></td>
            </tr>
          </table>
            <table width="741" height="300" border="1" style="border:none">
           <%int br = 0; %>    
           <c:forEach items="${ requestScope.lsts}" var="friend">
            <% if(br%3==0) out.println("<tr align='center'>");%>
         
              <td width="247" align="center" valign="top"><p><img src="/chengcheng/upload/images/photo/${friend.uphoto}"  alt="" width="240" height="240" align="middle"/></p>
                  <form name="form1" method="post" action="/chengcheng/WantFriendServlet" onSubmit="javascript:confirm('请求加好友信息已发送，请耐心等待对方回复')">
                  <input  type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;${friend.ugender}&nbsp; &nbsp;&nbsp; &nbsp;   ${friend.uname }</p>
                 
                    <p>
                       &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="button2" id="button2" value="添加好友" >&nbsp;
                      </p>
                  </form>
                  <p>
                       &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <input type="submit" name="button3" id="button3" onClick="javascript:message('text${friend.uccid}','button${friend.uccid}','button1${friend.uccid}');" value="发送消息" >
                    </p>
                    <table width="200" height="10" border="0" align="left" style="border:none">
                 <tr id="message" name="message" style="display:none;">
                 <form name="form2" method="post" action="/chengcheng/FindToNewsServlet">
                 <input type="hidden" id="nuser" name="nuser" value="${friend.uccid}">
                 <p align="center">
                   <label>
                     <textarea name="text" id="text${friend.uccid}" cols="30" rows="2" style="display:none;"></textarea>
                   </label>
                 </p>
                 <p align="center">
                 <div align="center">
                   <input align="middle"  type="submit" name="button" id="button${friend.uccid}" value="  发送  " style="display:none;">
                     <input align="middle" type="button" name="button1" id="button1${friend.uccid}" onClick="javascript:stopmessage('text${friend.uccid}','button${friend.uccid}','button1${friend.uccid}');" value="  关闭  " style="display:none;">
                    </div>
                 </p>
                 </form>
                </tr>
                </table>
              
              </td>
            
         
            <%if(br%3==2) out.println("</tr>");br++;%> 
           </c:forEach>
          </table>
        </div>
        <div id="content_bottom"></div>
      </div>
      <div class="templatemo_sidebar_wrapper float_r">
        <div class="templatemo_sidebar_top"></div>
        <div class="templatemo_sidebar">
          <div class="sidebar_box">
               <h2>推送</h2>
            <div class="sidebar_box_content">
              <div class="news_box">
                <h4><a href="#">天气预报</a></h4>
                
<iframe allowtransparency="true" frameborder="0" width="180" height="203" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=0&v=1&d=2&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=140&h=203&align=center"></iframe>

</div>
               <div class="news_box">
                <h4><a href="/chengcheng/FindFriendsServlet">好友推荐</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="javascript:divrefresh();" value="换一批" />
                <a href="/chengcheng/FindFriendsServlet">更多</a></h4>           
<div id="f1" style="display:block;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar1 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar1>2) break;%>
      <% if(ar1%3==0) out.println("<tr align='center'>");%>
   
         
              <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/chengcheng/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
            
       <%if(ar1%3==2) out.println("</tr>");ar1++;%> 
   </c:forEach>
</table>
</div>

<div id="f2" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar2 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar2>2&&ar2<=5) {
	   if(ar2%3==0) 
		   out.println("<tr align='center'>");%>
       
              <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/chengcheng/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
         
       <%
	   if(ar2%3==2) out.println("</tr>");
	   }ar2++;%>
   </c:forEach>
</table>
</div>

<div id="f3" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int ar3 = 0; %>    
   <c:forEach items="${ sessionScope.lsts}" var="friend">
   <% if(ar3>5&&ar3<=8) {
	   if(ar3%3==0) 
		   out.println("<tr align='center'>");%>
       
              <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${friend.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <input type="hidden" name="uccid" id="uccid" value="${friend.uccid}" />
                    <p>${friend.ugender }</p>
                    <p>${friend.uname }</p>
                    <h5><a href="/chengcheng/WantFriendsServlet?uccid=${friend.uccid}">添加好友</a></h5>
                   </td>
            
       <%
       if(ar3%3==2) out.println("</tr>");
       }ar3++;%>
   </c:forEach>
</table>
</div>

<script type="text/javascript">
function divrefresh(){
   var m1=document.getElementById('f1');
   var m2=document.getElementById('f2');
   var m3=document.getElementById('f3');
   if(m1.style.display=='block'){
      m1.style.display='none';
      m2.style.display='block';
   }else if(m2.style.display=='block'){
      m2.style.display='none';
      m3.style.display='block';
   }else{
      m3.style.display='none';
      m1.style.display='block';
   }
}
</script>
             
              </div>
              <div class="news_box">
                            <h4><a href="/chengcheng/ShowActByAdminServlet">活动推荐</a> 
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="javascript:divrefresh2();" value="换一批" />
                <a href="/chengcheng/ShowActByAdminServlet">更多</a></h4>          
<div id="c1" style="display:block;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr1 = 0; %>   
  <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr1>2) break;%>
      <% if(cr1%3==0) out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
              <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/chengcheng/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%if(cr1%3==2) out.println("</tr>");cr1++;%> 
   </c:forEach>
</table>
</div>

<div id="c2" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr2 = 0; %>    
   <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr2>2&&cr2<=5) {
	   if(cr2%3==0) out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
              <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/chengcheng/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%
	   if(cr2%3==2) out.println("</tr>");
	   }cr2++;%>
   </c:forEach>
</table>
</div>

<div id="c3" style="display:none;">
<table width="100" height="50" border="1" style="border:none">
 <%int cr3 = 0; %>    
   <c:forEach items="${ sessionScope.lstAct1}" var="act">
   <% if(cr3>5&&cr3<=8) {
	   if(cr3%3==0) 
		   out.println("<tr align='center'>");%>
        <c:if test="${act.ptype=='0'}">
             <td width="50" align="center" valign="middle">
              <p><img src="/chengcheng/upload/images/photo/${act.uphoto}"  alt="" width="50" height="50" align="middle"/></p>
                  <form name="form1" method="post" action="/chengcheng/ToCommentServlet">
                  <input type="hidden" name="aid" id="aid" value="${act.aid}">
                    <p>${act.aname}</p>
                    <input type="submit" name="buttons" id="buttons" value="详情">
                  </form>
              </td>
              </c:if>
       <%
       if(cr3%3==2) out.println("</tr>");
       }cr3++;%>
   </c:forEach>
</table>
</div>


<script type="text/javascript">
function divrefresh2(){
   var m1=document.getElementById('c1');
   var m2=document.getElementById('c2');
   var m3=document.getElementById('c3');
   if(m1.style.display=='block'){
      m1.style.display='none';
      m2.style.display='block';
   }else if(m2.style.display=='block'){
      m2.style.display='none';
      m3.style.display='block';
   }else{
      m3.style.display='none';
      m1.style.display='block';
   }
}
</script>
              </div>
              <div class="news_box">
      <h4><a href="/chengcheng/ShowInPersonalServlet">近日行程表</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/chengcheng/ShowInPersonalServlet">更多</a></h4>
      <tr>
        <td>日程太空？去<a href="/chengcheng/ShowInActivityCircleServlet?type=0">活动圈</a>逛逛吧！</td>
      </tr>
      <tr>
        <td></td>
      </tr>
             <div id="c1" style="display:block;">
<table width="170" height="50" border="1" style="border:none">
 <%int m = 0; %>  
 <c:if test="${!empty sessionScope.lstmyAct}">  
  <%List<ShowActInIndex> lstmyAct = (List<ShowActInIndex>)session.getAttribute("lstmyAct");
    for (ShowActInIndex myact : lstmyAct){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    String n = formatter.format(new Date()) ;
    if((formatter.format(myact.getAdate()).compareTo(n))>0){ %>
   <% if(m>2) break;%>
      <% if(m%3==0) out.println("<tr align='center'>");%>
         <%if(myact.getPtype()==1){%>
              <tr>
              <td>
               <p><a href="/chengcheng/ShowInOthersServlet?uccid=<%=myact.getUccid() %>"></a><%=myact.getAdate() %></p>
             
                <p><%=myact.getUname() %>将参加<%=myact.getOwner_id() %>发布的：<%=myact.getAname() %></p>
              
                <p align="center"><a href="/chengcheng/ToCommentServlet?aid=<%=myact.getAid() %>">查看详细内容</a></p>
                </td>
              </tr>
         <%}else{if(myact.getPtype()==0){%>
             <tr>
             <td>
               <p><a href="/chengcheng/ShowInOthersServlet?uccid=<%=myact.getUccid() %>"></a><%=myact.getPdate() %></p>
             
               <p><%=myact.getUname() %>发布活动：<%=myact.getAname() %></p>
             
               <p align="center"><a href="/chengcheng/ToCommentServlet?aid=<%=myact.getAid() %>">查看详细内容</a></p>
               </td>
             </tr>
         <%}}%>
       <%if(m%3==2) out.println("</tr>");m++;%> 
      <%}} %>
   </c:if>
         <c:if test="${empty sessionScope.lstmyAct}">
          <table width="720" border="0" style="border:none">
            <tr>
              <td>你还没有活动哦，赶快去活动圈找一找有趣的活动吧！
              </td>
            </tr>
           </table>
         </c:if>
</table>
</div>
</div>
            </div>
            <!-- end of sidebar_box_content -->
          </div>
          <!-- end of sidebar_box ( news ) -->
        </div>
        <div class="templatemo_sidebar_bottom"></div>
        <!-- end of sidebar -->
      </div>
      <!-- end of templatemo_sidebar_wrapper -->
      <div class="cleaner"></div>
    </div>
    <!-- end of templatemo_content_wrapper -->
  </div>
  <!-- end of templatemo_wrapper4 -->
  <div class="cleaner"></div>
<!-- end of templatemo_body_wrapper64 -->
<div id="templatemo_footer_wrapper6">
  <div id="templatemo_footer">
    <ul class="footer_menu">
      <li>
      Copyright © 2048&nbsp; <a href="#">I_code</a>| 
    Designed by I_code| 
    Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a></li>
      <!-- end of footer -->
</ul>
</div>
</div>
<!-- end of templatmeo_footer_wrapper -->
</body>
</html>