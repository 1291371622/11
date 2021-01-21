<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/"%>">
    <title>Title</title>
    <link rel="stylesheet" href="../../lib/layer/ui/css/layui.css" media="all">
    <script type="text/javascript" src="../../lib/layer/ui/layui.js" charset="utf-8"></script>
</head>
<body>
<!-- 显示分页导航条-->
<div id="test1"></div>
<script type="text/javascript">
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage
            ,layer = layui.layer;
        //完整功能
        laypage.render({
            elem: 'test1'
            ,count: '${pageInfo.total}'
            ,limit: '${pageInfo.pageSize}'
            ,curr: '${pageInfo.pageNum}'
            ,layout: ['prev', 'page', 'next', 'limit', 'count']
            ,limits:[5,10,20,30]
            ,jump: function(obj,first){
                if(!first){
                    location.href="${url}?pageNum="+obj.curr+"&pageSize="+obj.limit;
                }
            }
        });
    });
</script>
</body>
</html>
