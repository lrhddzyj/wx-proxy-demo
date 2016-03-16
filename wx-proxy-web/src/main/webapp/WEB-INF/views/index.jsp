<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微信auth2调用说明</title>
</head>
<body>
<h3>前提: 在配置中心配置过微信的appId和appSecret等信息</h3>
<li>基本授权: 仅获取openId 步骤:</li><br>
http://<%=request.getServerName()+request.getContextPath()%>/oauth2?appId=<font color="red"><strong>wx8654c45a1beb6837</strong></font>&scope=snsapi_base&state=<font color="red"><strong>123</strong></font>&url=<font color="red"><strong>http://liuyh.ematong.com/test</strong></font> <br>
  <p></p>替换上面的红色部分.当微信客户端打开该地址后,会跳转到红色的url部分,并且附带 <font color="red"><strong>state</strong></font> 和 <font color="red"><strong>openId</strong></font>参数,
<p></p>类似
  http://liuyh.ematong.com/test?state=123&openId=j23jojfsos23dcd <p></p> <br><br><br><br>

<li>userinfo授权: 获取用户信息 步骤:</li><br>
http://<%=request.getServerName()+request.getContextPath()%>/oauth2?appId=<font color="red"><strong>wx8654c45a1beb6837</strong></font>&scope=snsapi_userinfo&state=<font color="red"><strong>123</strong></font>&url=<font color="red"><strong>http://liuyh.ematong.com/test</strong></font> <br><br>
<p></p>替换上面的红色部分.当微信客户端打开该地址并且通过用户登录授权后,会跳转到红色的url部分,并且附带 <font color="red"><strong>state</strong></font> 和 <font color="red"><strong>openId</strong></font>参数,参考获取基本信息返回的url <br>
这个时候可以调用dubbo接口来获取用户的基本信息:<br><br>
com.mind.weixin.service.WxUserInfoRecordService.getUserInfo(openId) <br><br><br>

------------------------------------------------------------------------------------------------------------------<br><br>
<font size="2">
注意: 该接口获取的用户信息包含有 createTime (记录的创建时间) ,业务可以在需要获取用户信息之前,先调用该接口获取下用户信息.<br>
<br><br> 1. 没有返回用户信息的情况下,表示需要走用户授权,获取一次
<br><br> 2. 获取到的用户信息的createTime创建时间超过1/3个月(具体时间由业务判断),来选择性的是否需要用户授权
<br><br> 3. 如果进行跳转前,获取到的用户信息是比较新的,故而可以省略url跳转这一步
</font>
</body>
</html>
