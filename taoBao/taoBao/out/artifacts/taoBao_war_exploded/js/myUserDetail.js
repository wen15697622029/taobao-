/**
 * Created by destiny on 2018/6/26/0026.
 */
function checkPwd(pass) {
    document.getElementById(pass).innerHTML="6-16位字母、数字";
}
var p1;
var flag1=false;
function chenckPwd1(pwd,pass) {
    p1 = document.getElementById(pwd).value;
    var reg = /[A-z0-9]{6,16}/;
    if (p1.length < 6) {
        document.getElementById(pass).innerHTML = "长度小于6";
        flag1=false;
    } else if (p1.length > 16) {
        document.getElementById(pass).innerHTML = "长度大于16";
        flag1=false;
    } else if (!reg.test(p1)) {
        document.getElementById(pass).innerHTML = "不符合命名规范";
        flag1=false;
    } else {
        document.getElementById(pass).innerHTML = "符合规范";
        flag1=true;
    }
    hh();
}
var p2;
var flag2=false;
function chenckPwd2(pwd,pass) {
    p2 = document.getElementById(pwd).value;
    var reg = /[A-z0-9]{6,16}/;
    if (p2.length < 6) {
        document.getElementById(pass).innerHTML = "长度小于6";
        flag2=false;
    } else if (p2.length > 16) {
        document.getElementById(pass).innerHTML = "长度大于16";
        flag2=false;
    } else if (!reg.test(p2)) {
        document.getElementById(pass).innerHTML = "不符合命名规范";
        flag2=false;
    } else {
        document.getElementById(pass).innerHTML = "符合规范";
        flag2=true;
    }
    hh();
}
function hh() {
    if (flag1&&flag2){
        document.getElementById("change").disabled="";
    }else{
        document.getElementById("change").disabled="true";
    }
}