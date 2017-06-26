<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%  
    String path = request.getContextPath();  
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
    %>  

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" name="viewport">
    <link href="<%=basePath %>/css/style.css" rel="stylesheet">
   <script src="<%=basePath %>/js/jquery-2.1.4.min.js"></script>
    <style>

    </style> 
</head>
<body>
<header style="height:90px;width:1000px;margin: 0 auto;">
    <img src="<%=basePath %>/img/logo.png " width="128px" height="90px">
    <div style="font-size:20px;margin-top: -60px;margin-left: 130px;">
        <span >欢迎登录</span>
    </div>
</header>

<div class="login-bg">
     <div class="login-a">
            <div style="width: 280px;height: 20px;margin:0 auto;padding:15px;">
              <span style="font-size: 20px;margin-right:100px;">用户登录</span>
              <img src="<%=basePath %>/img/picture2.png">
              <span><a href="<%=basePath %>/view/register/register1.jsp" style="color: red">立即注册</a></span>
            </div>
            <form id="loginform" class="form-vertical" action="<%=basePath %>/login.do" method="post">
            <p style="color:red">&nbsp;${msg}</p>
            
                <div class="login-c">
                <input type="text" name="username" placeholder="邮箱/用户名/已验证手机" style="background: transparent url(<%=basePath %>/img/name.png) no-repeat left;padding-left: 40px">
            </div>
            <div class="login-c">
                <input type="text" name="userpwd" placeholder="密码" style="background: transparent url(<%=basePath %>/img/password.png) no-repeat left;padding-left: 40px">
            </div>
            <div class="login-d">
                <input type="text" placeholder="验证码">
                <input type="text"  style="background: transparent url(<%=basePath %>/img/3u29d.png) no-repeat left;width: 70px;margin-left: 10px;">
                <span style="font-size: 12px;"><a href="#" style="color: #333">看不清 换一张</a></span>
            </div>
            <div class="login-e">
                    <input type="checkbox"><span >自动登录</span>
                    <input type="checkbox" ><span>记住密码</span>
                    <span style="margin-left:20px;"><a href="#" style="color:#000000;text-decoration: none">忘记密码？</a></span>
            </div>
             <div class="login-f">
                 <input type="submit"  value="登        录">
             </div>
            </form>
           
        
    </div>
</div>
<!--foot-->
<footer style="border-top: 2px solid #309bbe;width: 100%;height:80px;position: relative;top:480px;">
    <div style="width: 700px;margin: 0px  auto;color: #333;text-align: center;font-size: 12px;padding-top: 10px;line-height: 20px;">
        <p> 平台介绍　　|　　大事记　　|　　公司动态　　|　　媒体报告　　|　　联系我们　　|　　物流官网</p>
        <p>Copyright © 必然科技物流平台 All rights reserved. 京ICP备14032800号-1-2-1-20</p>
        <p>物流专线sitemap 物流公司sitemap 物流专线sitemap-xml 物流公司sitemap-xml </p>
    </div>
</footer>
</body>
</html>