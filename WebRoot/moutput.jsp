<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  

   <body onload="fun()">
    <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
    <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
    
   
<div>  <form action="moutput.do">
 	
    	时间：<select name="timeselect" style="width: 100px">
    	<%
    	List list=(List)request.getAttribute("yearlist");
    	for(int i=0;i<list.size();i++){
    	%>
    	<option value="<%=list.get(i) %>"><%=list.get(i) %></option>
    	<% }
    	
    	 %>
    	
    	</select>
    	
    	
    	<input type="submit" value="点击查询" />
    </form>
    
    </div>
    <div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

    <!--Step:2 Import echarts-all.js-->
    <!--Step:2 引入echarts-all.js-->
   <script src="${pageContext.request.contextPath}/js/echarts-all.js"></script>
    
    
</body>
	

 <!--Step:2 Import echarts-all.js-->
    <!--Step:2 引入echarts-all.js-->
    <script src="${pageContext.request.contextPath}/js/echarts-all.js"></script>
<script type="text/javascript">
        // Step:3 echarts & zrender as a Global Interface by the echarts-plain.js.
        // Step:3 echarts和zrender被echarts-plain.js写入为全局接口
        
        function fun(){
        
		var name = '全部商品';
		var list1 = ${listm};
		var list2 = ${listv};   
        
        var myChart = echarts.init(document.getElementById('main'));
        myChart.setOption({
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:[name]
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                	name:'月份',
                    type : 'category',
                    data : list1
                }
            ],
            yAxis : [
                {	name:'销项税',
                    type : 'value',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:name,
                    type:'bar',
                    data:list2
                }
            ]
        });
        }
    </script>



</html>
