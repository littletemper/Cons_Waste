<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%  
    String path = request.getContextPath();  
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
    %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" name="viewport">
    <link href="<%=basePath %>/css/style.css" rel="stylesheet">
    <style>
#nextstep{
    text-decoration: none;
}
    </style>
      <script src="<%=basePath %>/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<header style="height:90px;width:1000px;margin: 0 auto;">
    <img src="<%=basePath %>/img/logo.png " width="128px" height="90px">
    <div style="font-size:20px;margin-top: -60px;margin-left: 130px;">
        <span >欢迎注册</span>
    </div>
</header>

<div style="background: #f5f5f5;width: 100%;height:650px;">
   <div style="height:30px;width: 1206px;margin:0px auto;padding-top:10px;text-align: right;">
        <p>我已注册，现在就　<a href="login.jsp" style="color: #ff6600;">登录</a></p>
   </div>
    <div  class="register-bg"  >
        <div style="margin-top:20px;width: 700px;height:30px;margin:0px auto;padding-top: 30px;">
            <span style="font-size: 20px;">会员注册</span>
        </div>
        <div style=" width:600px;height:400px;margin:0px auto;">
         <form id="loginform" class="form-vertical" action="<%=basePath %>/register.do" method="post">
     
        <p style="color:red">&nbsp;${msg}</p>
         <div class="register">
                <label><span style="color: red">*</span>用户类型：</label>
                 <input type="radio"name="userType" value="person"/>
                <span style="margin-right: 15px;" >个人</span>
                <input type="radio" name="userType" value="enter"/>
                <span style="margin-right: 15px;" >企业</span>
                <input type="radio" name="userType" value="gov"/>
                <span style="margin-right:15px;" >政府</span>
            </div>
            <div class="register">
                <label><span style="color: red">*</span>用户名：</label>
                <input type="text" style="width:235px;height:30px" id="username" name="username"/>
            </div>
            <div class="register">
                <label for="password"><span style="color: red">*</span>密码：</label>
                <input type="password" id="password" style="width:235px;height:30px" name="password" placeholder="6-20位字母、数字和符号"/>
                    <span id="safe">
                        <span class="pwd_strength">弱</span>
                        <span class="pwd_strength">中</span>
                        <span class="pwd_strength">强</span>
                    </span>
            </div>
            <div class="register">
                <label for="againPassword"><span style="color: red">*</span>确认密码：</label>
                <input type="password" name="rpsw" style="width:235px;height:30px" id="againPassword" placeholder="再次输入密码"/>
            </div>
            <div class="register-a">
                <a href="" id="nextstep"><input  type="submit" value="提交" id="send"/></a>

            </div>
         
        </form>
          
        </div>
    </div>
</div>

<!--foot-->
<footer style="border-top: 2px solid #309bbe;width: 100%;height:80px;">
    <div style="width: 700px;margin: 0px  auto;color: #333;text-align: center;font-size: 12px;padding-top: 10px;line-height: 20px;">
        <p> 平台介绍　　|　　大事记　　|　　公司动态　　|　　媒体报告　　|　　联系我们　　|　　物流官网</p>
        <p>Copyright © 必然科技物流平台 All rights reserved. 京ICP备14032800号-1-2-1-20</p>
        <p>物流专线sitemap 物流公司sitemap 物流专线sitemap-xml 物流公司sitemap-xml </p>
    </div>
</footer>
<script src="../../js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
  //   $('input:radio[name="userType"]').click({
  // var val=$('input:radio[name="userType"]:checked').val();

  //   alert(val);
  //   alert(111);

  //   })
    $('input:radio[name="userType"]').click(function(){
        var val=$(this).attr("value");
        if(val=="person")
            {
            $("#nextstep").attr("href","personal_register.html");
            }else if(val=="enter"){
             $("#nextstep").attr("href","enterprise_register.html");
        }
    });
    
</script>
</body>
