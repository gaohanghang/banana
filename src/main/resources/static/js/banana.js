$(document).ready(function () {

    //提交按钮
    $("#submitButton").click(function () {
        getBanana();
    });

    //重置按钮
    $("#reset").click(function () {
        $("#input").val("");
    });

    //下拉选发生改变就ajax提交
    $("#font").change(function () {
        getBanana();
    });

    //发送ajax请求获取数据
    function getBanana() {

        //获取输入的文本
        var input = $("#input").val();

        //获取选择的字体
        var font = $("#font option:selected").text();

        //输入内容非空判断
        if (input == null || input == "" || input == undefined) {
            swal({
                text: "输入的内容不能为空",
                type: "error"
            });
            return;
        }

        //是否含有中文判断
        if (/.*[\u4e00-\u9fa5]+.*/.test(input)) {
            swal({
                text: "暂不支持中文",
                type: "error"
            });
        }

        $.ajax({
            url: "/getBanana",
            type: "POST",
            data: {text: input, font : font},
            success: function (result) {
                $("#output").text(result)
            }
        })

    }
})