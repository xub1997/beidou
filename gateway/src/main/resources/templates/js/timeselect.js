/*my97时间选择控件--开始*/
var md = ""; //第二个输入框最大值的全局变量

//第一个输入框选择好日期的时候操作
function pickedFunc() {

    var Y = $dp.cal.getP('y');
    var M = $dp.cal.getP('M');
    var D = $dp.cal.getP('d');
    var H = $dp.cal.getP('H');
    var M1 = $dp.cal.getP('m');
    var S = $dp.cal.getP('s');

    H = parseInt(H) + 2; //相差只能是两小时
    M = parseInt(M) - 1;
    D = parseInt(D);
    H = parseInt(H);
    M1 = parseInt(M1);
    S = parseInt(S);

    var d = new Date();
    d.setFullYear(Y, M, D); //设置时间
    d.setHours(H, M1, S);

    var nowDate = new Date();
    //跟现在的时间比较，如果算出来的值大于现在时间，修改全局变量md为现在时间。否则为算出来的时间。
    if(nowDate <= d) {
        md = "";
    } else {
        var month = d.getMonth() + 1; //月份的范围是（0到11）;
        md = d.getFullYear() + "-" + month + "-" + d.getDate() + " " + H + ":" + M1 + ":" + S; //直接把d给过去会有问题，所以拼成字符串发过去
    }
}

//第一个清空的时候的操作
function clearedFunc() {
    md = "";
}
//给第二个输入框定义规则
function picker2rule(ele) {
    if(md == "") {
        WdatePicker({
            el: ele,
            minDate: '#F{$dp.$D(\'datepicker1\')}',
            maxDate: '%y-%M-%d %H:%m:%s',
            dateFmt: 'yyyy-MM-dd HH:mm:ss'
        });
    } else {
        WdatePicker({
            el: ele,
            minDate: '#F{$dp.$D(\'datepicker1\')}',
            maxDate: md,
            dateFmt: 'yyyy-MM-dd HH:mm:ss'
        });
    }
}
/*my97时间选择控件--结束*/