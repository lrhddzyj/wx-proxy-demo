<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/25
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
<form method="POST" enctype="multipart/form-data"
      action="${pageContext.request.contextPath}/media/upload">
   <li/><input type="file" name="file">
   <li/><input type="file" name="file">
   <li/><input type="file" name="file">
    <%--<li/> <input type="file" name="files"><br/>--%>
    <li/>多媒体类型: <select id="type" name="type">
        <option value="image" selected="selected">图片</option>
        <option value="voice">语音</option>
        <option value="video">视频</option>
        <option value="thumb">缩略图</option>
    </select>

    <li/>业务businessKey: <input
        type="text" name="appId" value="wx8654c45a1beb6837"><br/>
    <br/><br/><br/><br/><br/><br/>
    <input type="submit" value="上传" style="width: 100px;height: 50px">
</form>
</body>

</html>
