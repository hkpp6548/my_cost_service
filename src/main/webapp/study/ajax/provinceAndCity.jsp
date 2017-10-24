<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ajax开发---简单的省市级联</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>
<script type="text/javascript">
	var jsonobj = null;
	window.onload = function() {

			//第一步:得到XMLHttpRequest对象.
			var xmlhttp = getXmlHttpRequest();
			//2.设置回调函数
			xmlhttp.onreadystatechange = function() {
				//5.处理响应数据  当信息全部返回，并且是成功;
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var responseText = eval("(" + xmlhttp.responseText + ")");
                    jsonobj = responseText;
					var province = document.getElementById("province");
					for(var i = 0 ; i < responseText.length; i++){
                        var element = document.createElement("option");
                        element.innerHTML = responseText[i].name
						province.add(element);
					}
					//alert();
				}
			};
			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/provinceAndCityServlet");
			xmlhttp.send(null);
	};

	function fillCity() {

       /* var obj = document.getElementByIdx_x(”testSelect”); //定位id
			var index = obj.selectedIndex; // 选中索引
			var text = obj.options[index].text; // 选中文本
			var value = obj.options[index].value; // 选中值*/
        var city = document.getElementById("city");
        city.options.length=0;
        var element2 = document.createElement("option");
        element2.innerHTML =  "--请选择城市--";
        city.add(element2);
        var province = document.getElementById("province");
        var selectedIndex = province.selectedIndex;
        var text = province.options[selectedIndex].text;
        for(var i = 0 ; i < jsonobj.length; i++){
            if(jsonobj[i].name == text){
				var cityss = jsonobj[i].citys;
				for ( var j = 0 ; j < cityss.length; j++){
                    var element = document.createElement("option");
                    element.innerHTML = cityss[j].name
                    city.add(element);
				}
			}
        }
    }
</script>

</head>

<body>
	<select id="province" onchange="fillCity()">
		<option>--请选择省份--</option>
	</select>
	<select id="city">
		<option>--请选择城市--</option>
	</select>
</body>
</html>
