
function layer_show_dept(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=800;
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2, // 弹框框的类型，ifream
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true, //  最大最小化
        shade:0.4,
        title: title,
        content: url,
        end:function(){

            // 1.获取id和名称
            var deptId = $.session.get("deptId");
            var deptName = $.session.get("deptName");

            // 2.赋值
            $("#parentDeptId").val(deptId);
            $("#parentDeptName").val(deptName);
        }
    });
}