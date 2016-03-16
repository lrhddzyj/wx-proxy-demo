<%--
  Created by IntelliJ IDEA.
  User: rocky
  Date: 14/12/25
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微信支付</title>
</head>
<body onload="detectWeixinApi()">
<script type="text/javascript">

    function detectWeixinApi(){
        if(typeof window.WeixinJSBridge == 'undefined' || typeof window.WeixinJSBridge.invoke == 'undefined'){
            setTimeout(function(){
                detectWeixinApi();
            },200);
        }else{
            initPay();
        }
    }

    function initPay() {
        var jsapi = "${jsapi}";
        if (jsapi === undefined || jsapi === "" || jsapi === null) {
            alert("无此订单！");
        }
        if (typeof WeixinJSBridge != "undefined") {
            WeixinJSBridge.invoke('getBrandWCPayRequest' , {
                "appId"     : "${jsapi.appId}" ,
                "timeStamp" : "${jsapi.timeStamp}" ,
                "nonceStr"  : "${jsapi.nonceStr}" ,
                "package"   : "${jsapi.packageStr}" ,
                "signType"  : "${jsapi.signType}" ,
                "paySign"   : "${jsapi.paySign}"
            } , function(res){
                if (res.err_msg == "get_brand_wcpay_request:ok") {
                    window.location.href = "${jsapi.successCallbackUrl}";
                } else if (res.err_msg == "get_brand_wcpay_request:cancel") {
                    window.location.href = "${jsapi.cancelCallbackUrl}";
                } else if (res.err_msg == "get_brand_wcpay_request:fail") {
                    window.location.href = "${jsapi.errCallbackUrl}";
                } else {

                }
            });
        } else {
            alert('请使用微信进行支付！');
        }
    }
</script>
</body>
</html>
