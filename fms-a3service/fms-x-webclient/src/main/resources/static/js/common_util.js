/**
 * Created by qiaohao on 2017/5/6.
 */

/*给iframe设置高度*/
var iframeHeight;
function setIframeHeight() {
    iframeHeight = $(window.parent).height()-100;
    if(iframeHeight <= 500){
        iframeHeight = 500;
    }else{
        iframeHeight = $(window.parent).height()-100;
    }
}
setIframeHeight();
$(window).resize(function () {
    setIframeHeight();
    $('iframe').height(iframeHeight);
});
// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "H+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}
//获取当前日期
function getToday() {
    return (new Date()).Format("yyyy-MM-dd");
}
//获取指定日期
function getYMD(date) {
    return date.Format("yyyy-MM-dd");
}
/**
 * 判断是否为null
 * @param data
 * @returns {boolean}
 */
function isNull(data){
    if(data == null)
        return true;
}

/**
 * 判断是否非null
 * @param data
 * @returns {boolean}
 */
function isNotNull(data){
    return !isNull(data);
}


/**
 * 返回年月日时的时间戳
 * @returns {number}
 */
function getTimestamp(){

    var date = new Date();
    //date.getFullYear();
    //date.getMonth() + 1;
    //date.getDate();
    //date.getHours();
    //date.getSeconds();
    var newDate = new Date(date.getFullYear(),date.getMonth(),date.getDate(),date.getHours());
    return newDate.getTime();
}

/**
 * url后跟上缓存的时间戳
 * @returns {string}
 */
function getCacheTime(){
    return '?datetime='+getTimestamp();
}



/**
 * 判断是否为空
 * @param data
 * @returns {boolean}
 */
function isEmpty(data){
    if(data == "")
        return true;
}

/**
 * 判断是否非空
 * @param data
 * @returns {boolean}
 */
function isNotEmpty(data){
    return !isEmpty(data);
}


/**
 * 判断一个值是否是未定义
 * @param val
 * @returns {boolean}
 */
function isUndefined(data){
    if(typeof(data) == undefineds.str || typeof(data) == undefineds.obj){
        return true;
    }else if(data == undefineds.str || data == undefineds.obj){
        return true;
    }else{
        return false;
    }
}

/**
 * 判断一个值是否非未定义
 * @param data
 * @returns {boolean}
 */
function isNotUndefined(data){
    return !isUndefined(data);
}

/**
 * 判断一个值是否不为null和空字符
 * @param data
 * @returns {boolean}
 */
function isNotNullEmpty(data){
    return isNotNull(data) && isNotEmpty(data);
}

/**
 * 判断一个值是否为null或者空字符
 * @param data
 * @returns {boolean}
 */
function isNullEmpty(data){
    return isNull(data)  || isEmpty(data);

}

/**
 * 判断一个值是否不是未定义 并且 不为空
 * @param data
 * @returns {boolean}
 */
function isNotUndefinedNull(data){
    return isNotUndefined(data) && isNotNull(data);

}

/**
 * 判断一个值是否未定义 或者 为空
 * @param data
 * @returns {boolean}
 */
function isUndefinedNull(data){
    return isUndefined(data) || isNull(data);
}



var undefineds = {
    obj : undefined,
    str : "undefined"
}


function toaster_success (text,toaster){
    toaster.pop('success','',text);
}

function toaster_info (text,toaster){
    toaster.pop('info','',text);
}

function toaster_error (text,toaster){
    toaster.pop('error','',text);
}

//设置AJAX的全局默认选项
$.ajaxSetup({
    error: function(jqXHR, textStatus, errorMsg){ // 出错时默认的处理函数
        if(jqXHR.status == 401 && location.href.indexOf('access/signin') == -1)
            window.parent.location.href = "/#/access/signin";
    }
});


function modalConfirm($modal,confirm,cancel,info,header,size){
    if(isUndefined(header) || isNull(header))
        header = '提示信息';
    if(isUndefined(info) || isNull(info))
        info = '您确定需要执行当前动作吗？';
    if(isUndefined(size) || isNull(size))
        size = 'sm';
    var rtn = $modal.open({
        backdrop : 'static',
        size: size,
        templateUrl: 'tpl/alert/confirm.html'+getCacheTime(),
        controller: 'modal_confirm_controller',
        resolve:{
            header : function(){return header},
            info : function(){return info}
        }
    });
    rtn.result.then(function (status) {
        if(status == Response.successMark) {
            if(isNotUndefined(confirm))
                confirm();
        }
    },function(reason){
        if(isNotUndefined(cancel))
            cancel();
    });
}


function modalAlert($modal,info,header){
    if(isUndefined(header) || isNull(header))
        header = '提示信息';
    if(isUndefined(info) || isNull(info))
        info = '警告';

    var rtn = $modal.open({
        backdrop : 'static',
        size:'sm',
        templateUrl: 'tpl/alert/alert.html'+getCacheTime(),
        controller: 'modal_alert_controller',
        resolve:{
            header : function(){return header},
            info : function(){return info}
        }
    });
    rtn.result.then(function (status) {

    },function(){

    });
}

function getDeleteData(data){
    return {data:data,headers:{"Content-Type": "application/json;charset=utf-8"}}
}


var promptInfo = {
    submitWarn : "请填写正确的信息"
}

var fms_iframe_id='fms_iframe_id_';
var fms_tab_width=150;

function getFmsTabLi(data_id,data_title){
    var fms_tab_li = '<li style="position: relative;" class="nav-bar-active '+data_id+'">' +
        '<a href="javascript:void(0);" data-toggle="tab" data-id="'+data_id+'" onclick="switchTab(this)">' +
        data_title+
        '&nbsp;<i class="glyphicon glyphicon-remove" style="top: 1px;font-size: 8px;" data-id="'+data_id+'" onclick="removeTab(this)"></i></a>'+
        '</li>';
    return fms_tab_li;
}

function getFmsIframe(data_id,data_url){
    var iframe = '<iframe id="'+data_id+'" src="'+data_url+'" height="'+iframeHeight+'px" style="overflow: auto;border: 0;display: block;" width="100%" marginwidth="0" marginheight="0"></iframe>';
    return iframe;
}

function addTab(obj){
    var obj_this  = $(obj);
    var data_id = fms_iframe_id+obj_this.attr("data-id");
    if($("#"+data_id).length != 0)
        switchTabById(data_id);
    else{
        //主页常用功能
        var menuLink = obj_this.attr("data-url");
        $.ajax({
            url: 'sys_menu_clicks/saveSysMenuClicks',
            type: 'POST',
            headers:{
                "Content-Type":"application/json;charset=UTF-8"
            },
            data: JSON.stringify({"menuLink":menuLink}),
            success: function (data) {

            },
            error: function (err) {
                console.log(err);
            }
        });
        var data_title = obj_this.attr("data-title");
        var http_url = window.location.href.split('#')[0];
        var data_url = http_url + '/#/'+obj_this.attr("data-url").replace('.','/');
        var tab = getFmsTabLi(data_id,data_title);

        /*$("#widthCalculator").html(tab);
        var tabWidth = parseInt($("#widthCalculator").css("width").replace('px',''));
        var width = parseInt($("#fms_app_tabs").css("width").replace('px',''));
        $("#fms_app_tabs").css("width",(width + tabWidth + 25)+'px');*/


        var iframe = getFmsIframe(data_id,data_url);
        $("#fms_app_tabs").append(tab);
        $("." + data_id).siblings().removeClass("nav-bar-active");
        $("#fms_app_iframes iframe").css('display','none');
        $("#fms_app_iframes").append(iframe);
    }
}
function loadingOpen() {
    var loader = document.getElementById("loading-bar-spinner");
    loader.style.display = "block";
}
function loadingClose() {
    var loader = document.getElementById("loading-bar-spinner");
    loader.style.display = "none";
}
function stateChangeIE(_frame) {
    if (_frame.readyState == "complete"){
        var loader = document.getElementById("loading-bar-spinner");
        setTimeout(function () {
            loader.style.display = "none";
        },500);
    }
}
function stateChangeFirefox(_frame) {
    var loader = document.getElementById("loading-bar-spinner");
    setTimeout(function () {
        loader.style.display = "none";
    },500);
}
function switchTab(obj){
    var obj_this  = $(obj);
    var data_id = obj_this.attr("data-id");
    switchTabById(data_id);
    //obj_this.parent().addClass("nav-bar-active")
    //obj_this.parent().siblings().removeClass("nav-bar-active");
}

function switchHome(){
    switchTabById("fms_iframe_id_home");
    var locationStr = document.getElementById('fms_iframe_id_home').contentWindow.location + "";
    if(locationStr.indexOf('app/home') != -1)
        document.getElementById('fms_iframe_id_home').contentWindow.location.reload(true);
}

function closeTabFormHomeParent(frameId){
    $("#fms_app_tabs li a i[data-id='" + frameId + "']").click();
    document.getElementById('fms_iframe_id_home').contentWindow.location.reload(true);
    switchTabById("fms_iframe_id_home");
}

function closeTabFormHome(){
    var frameId = window.frameElement && window.frameElement.id || '';
    window.parent.closeTabFormHomeParent(frameId);
}


function switchTabById(id){
    $("#fms_app_iframes iframe").css('display', 'none');
    var iframe = $("#" + id);
    iframe.css('display', 'block');
    $("." + id).addClass("nav-bar-active").siblings().removeClass("nav-bar-active");
    //datatable列表宽度重新计算
    iframe[0].contentWindow.dataTableWidth();
}

function removeTab(obj){
    var obj_this  = $(obj);
    var data_id = obj_this.attr("data-id");
    var prev_id = $("#" + data_id).prev().attr("id");
    $("#" + data_id).remove();
    obj_this.parent().parent().remove();
    /*var liWidth = parseInt(obj_this.parent().parent().width());
    var width = parseInt($("#fms_app_tabs").css("width").replace('px'));
    $("#fms_app_tabs").css("width",(width-liWidth-10)+'px');*/
    switchTabById(prev_id);
    left();
    var event = window.event || arguments.callee.caller.arguments[0];
    event.stopPropagation();
}

// 根据id关闭页签
function removeTabById(frameId) {
    var prev_id = $("#" + frameId).prev().attr("id");
    $("#" + frameId).remove();
    $("#fms_app_tabs li a i[data-id='" + frameId + "']").parent().parent().remove();
    switchTabById(prev_id);
    left();
    var event = window.event || arguments.callee.caller.arguments[0];
    event.stopPropagation();
}

function left(){
    var left = parseInt($("#fms_app_tabs").css("left").replace('px',''));
    if(left < 20)
    //$("#fms_app_tabs").css("left",(left+fms_tab_width)+'px');
        $("#fms_app_tabs").animate({"left":(left+fms_tab_width)+'px'},500);
}

function right(){
    //tabs元素现在的宽度
    var fms_app_tabs_width = parseInt($("#fms_app_tabs").css("width").replace('px',''));
    //tabs元素的偏移度负数转正数
    var left = parseInt($("#fms_app_tabs").css("left").replace('px','').replace('-',''));
    //tabs元素的真实偏移度
    var left_original = parseInt($("#fms_app_tabs").css("left").replace('px',''));
    //当前窗口宽度
    var fms_app_content_width = parseInt($("#fms_app_content").width());
    if(fms_app_tabs_width > fms_app_content_width && (fms_app_tabs_width - left) > fms_app_content_width){
        //$("#fms_app_tabs").css("left",(left_original-fms_tab_width)+'px');
        $("#fms_app_tabs").animate({"left":(left_original-fms_tab_width)+'px'},500);
        //还可继续滑动
        return true;
    }else{
        //不可继续滑动
        return false;
    }
}
// 页面页签切换
function switchPageTab(element, tabUlName) {
    var $element = $(element);
    var $parent = $('#' + tabUlName).find('.active');
    var parentContentId = $parent.children().attr('data-id');
    var contentId = $element.attr('data-id');
    $parent.removeClass('active');
    $element.parent().addClass('active');
    $('#' + parentContentId).removeClass('in active');
    $('#' + contentId).addClass('in active');
    //datatable插件应用于tab切换出现表头错位问题
    dataTableWidth();
}

function dataTableWidth(time) {
    if(time){
        setTimeout(function () {
            $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
        },500)
    }else{
        $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
    }
}

/**
 * CommonArrayUtils 数组共通处理
 *
 */
var CommonArrayUtils = new Object();
/**
 * 判断vals中的值是否能被val模糊匹配到
 * @param val
 * @param vals
 * @returns {boolean}
 */
CommonArrayUtils.vagueContains = function(val,vals){
    for(var index in vals){
        if((val + "").indexOf((vals[index] + "")) != -1)
            return true;
    }
    return false;
}

/**
 * 判断数组是否不存在或者长度为0
 * @param vals
 * @returns {boolean}
 */
CommonArrayUtils.isNullOrLengthZero = function(vals){
    if(CommonObjectUtils.isNotExist(vals) || vals.length < 1)
        return true;
    else
        return false;
}

/**
 * 判断数组是否存在并且长度大于0
 * @param vals
 * @returns {boolean}
 */
CommonArrayUtils.isNotNullAndLengthNotZero = function(vals){
    return !this.isNullOrLengthZero(vals);
}

/**
 * 判断一个对象数组中是否存在了一个对象
 * @param val
 * @param vals
 * @returns {boolean}
 */
CommonArrayUtils.isContains = function(val,vals){
    for(var i in vals){
        if(val == vals[i])
            return true;
    }
    return false;
}

/**
 * 模块路由记录
 */
var CommonRouterObjs = new Object();
CommonRouterObjs.commonRouterFuzzyNames = ["app/system","app/activiti","app/home","app/prebiz","app/product","app/baseinfo","app/asset","app/cost"];

/**
 * Object共通方法处理
 */
var CommonObjectUtils = new Object();

CommonObjectUtils.UNDEFINEDS = {
    obj : undefined,
    str : "undefined"
}

CommonObjectUtils.isUndefined = function(data){
    if(typeof(data) == this.str || typeof(data) == this.obj){
        return true;
    }else if(data == this.str || data == this.obj){
        return true;
    }else{
        return false;
    }
}

CommonObjectUtils.isNotUndefined = function(data){
    return !this.isUndefined(data);
}

CommonObjectUtils.isNull = function(data){
    if(data == null || data == "null" || data == "\"null\"" || data == "'null'")
        return true;
    return false;
}

CommonObjectUtils.isNotNull = function(data){
    return !this.isNull(data);
}

CommonObjectUtils.isExist = function(data){
    if(this.isNotUndefined(data) && this.isNotNull(data))
        return true;
    return false;
}

CommonObjectUtils.isExistDatas = function(datas){
    for(var i in datas){
        if(this.isNotExist(datas[i]))
            return false;
    }
    return true;
}

CommonObjectUtils.isNotExist = function(data){
    return !this.isExist(data);
}

/**
 * Number共通方法处理
 */
var CommonNumberUtils = new Object();

//返回是否不是number类型,true 非number类型  false number类型
CommonNumberUtils.isNotNum = function(data){
    return isNaN(data);
}

//返回是否是number类型,true 是number类型  false 不是number类型
CommonNumberUtils.isNum = function(data){
    return !CommonNumberUtils.isNotNum(data);
}


//判断是否包含非num类型的属性 true包含  false不包含
CommonNumberUtils.isContainNotNumArr = function(datas){
    for(var i in datas){
        if(this.isNotNum(datas[i]))
            return true;
    }
    return false;
}

//判断是否不包含非num类型的属性 true不包含  false 包含
CommonNumberUtils.isNotContainNumArr = function(datas){
    return !this.isContainTrimBlankArr(datas);
}

//相加求和
CommonNumberUtils.addTotal = function(datas){
    var total = 0;
    for(var i in datas){
        if(this.isNum(datas[i]))
            total += Number(datas[i]);
    }
    return total;
}

/**
 * String共通方法处理
 */

if (!String.prototype.trim) {
    String.prototype.trim = function () {
        return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
    };
}

var CommonStringUtils = new Object();

//英文逗号
CommonStringUtils.COMMA = ",";
CommonStringUtils.LINE = "_"

//判断字符是否为null和空字符串
CommonStringUtils.isTrimBlank = function(data){
    if(CommonObjectUtils.isUndefined(data) || data == null || data.trim() == ""){
        return true;
    }
    return false;
}

//判断字符是否包含null或空字符串
CommonStringUtils.isContainTrimBlankArr = function(datas){
    for(var i in datas){
        if(this.isTrimBlank(datas[i]))
            return true;
    }
    return false;
}

//判断字符是否不为null和空字符串
CommonStringUtils.isNotTrimBlank = function(data){
    if(CommonObjectUtils.isNotUndefined(data) && data != null && (data+"").trim() != ""){
        return true;
    }
    return false;
}

//判断字符是否不包含null或空字符串
CommonStringUtils.isNotContainTrimBlankArr = function(datas){
   return !this.isContainTrimBlankArr(datas);
}

/*checkbox数组转成字符串*/
CommonStringUtils.arrToString = function(dataArray) {
    var result = '';
    for(x in dataArray){
        result += dataArray[x]+",";
    }
    if(result!=""){
        return result.substring(0,result.length-1);
    }else{
        return "";
    }
    return result;
}

/*过滤重复数组
* @value arry
* @params name
* */
CommonStringUtils.filterDuplication = function (array,name){
    var r = [];
    for(var i = 0, l = array.length; i<l; i++){
        for(var j = i + 1; j < l; j++)
            if(array[i][name] == array[j][name]) j == ++i;
        r.push(array[i]);
    }
    return r;
}

//判断数组字符串是否全部不为null和空字符串
CommonStringUtils.isNotTrimBlankArrays = function(datas){
    for(var index in datas){
        if(this.isTrimBlank(datas[index]))
            return false;
    }
    return true;
}

//根据分割符将字符串分割成数组返回
CommonStringUtils.split = function(comma,val){
    var arrays = null;
    if(this.isNotTrimBlankArrays([comma,val])){
        arrays = val.split(comma);
    }
    return arrays;
}

//通过英文,号分割字符串返回数组
CommonStringUtils.splitComma = function(val){
    var arrays = null;
    if(this.isNotTrimBlank(val)){
        arrays = val.split(this.COMMA);
    }
    return arrays;
}

//判断字符val2是否包含val
CommonStringUtils.isLikeEqual = function(val, val2){
    if(CommonObjectUtils.isUndefined(val) || CommonObjectUtils.isUndefined(val2)){
        return false;
    }
    if(val2.indexOf(val) != -1){
        return true;
    } else {
        return false;
    }
};


var CommonDecimalUtils = new Object();

// 判断value值是否在区间内
CommonDecimalUtils.isValueSection = function (vaule, startValue, endValue) {
    if (startValue == endValue) {
        if (vaule == startValue) {
            return true;
        }
        return false;
    } else {
        if (Number(vaule) >= Number(startValue) && Number(vaule) < Number(endValue)) {
            return true;
        }
        return false;
    }
};

// 判断当前数据是否为undefined或null或0
CommonDecimalUtils.isNotUndefinedNullZero = function (value) {
    if (isNotUndefinedNull(value) && Number(value) != 0.0) {
        return true;
    }
    return false;
};

//格式化空数据为0（undefined,'',null）
CommonDecimalUtils.TrimDecimal=function (value) {
    var index = 0;
    if (!value){
        return index;
    } else if (isUndefined(value)){
        return index;
    } else if (value === 'null'){
        return index;
    } else {
        return value*1;
    }
};

// 格式化数据四舍五入保留小数点
CommonDecimalUtils.formatDecimal = function (value, point) {
    if (isNotUndefinedNull(value)) {
        return Math.round(Number(value) * Math.pow(10, point)) / Math.pow(10, point);
    }
    return 0.0;
};

// 格式化数据向上取整
CommonDecimalUtils.formatCeil = function (value, point) {
    if (isNotUndefinedNull(value)) {
        return Math.ceil(Number(value) * Math.pow(10, point)) / Math.pow(10, point);
    }
    return 0.0;
};

// 根据金额数和总额计算出百分比例
CommonDecimalUtils.getPercByAmount = function (amount, total, point) {
    if (this.isNotUndefinedNullZero(amount) && this.isNotUndefinedNullZero(total)) {
        var perc = (Number(amount) / Number(total)) * 100;
        return this.formatDecimal(perc, point);
    }
    return 0.0;
};

// 根据总额和百分比计算金额
CommonDecimalUtils.getAmountByPerc = function (perc, total, point) {
    if (this.isNotUndefinedNullZero(perc) && this.isNotUndefinedNullZero(total)) {
        var amount = mul(div(Number(perc),100)  , Number(total));
        return this.formatCeil(amount, point);
    }
    return 0.0;
};


// 根据总额和百分比计算金额,并向上取整
CommonDecimalUtils.getAmountByPercAndCeil = function (perc, total, point) {
    if (this.isNotUndefinedNullZero(perc) && this.isNotUndefinedNullZero(total)) {
        var amount = (Number(perc) / 100) * Number(total);
        return Math.ceil(this.formatDecimal(amount, point));
    }
    return 0.0;
};

//将两个数转换成整数进行计算，d是要保留的小数位，可以不传
function mul (arg1, arg2,d) {
    var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal;
    m = (r1.split(".")[1] ? r1.split(".")[1].length : 0) + (r2.split(".")[1] ? r2.split(".")[1].length : 0);
    resultVal = Number(r1.replace(".", "")) * Number(r2.replace(".", "")) / Math.pow(10, m);
    return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
}

function div(arg1, arg2,d) {
    var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal;
    m = (r2.split(".")[1] ? r2.split(".")[1].length : 0) - (r1.split(".")[1] ? r1.split(".")[1].length : 0);
    resultVal = Number(r1.replace(".", "")) / Number(r2.replace(".", "")) * Math.pow(10, m);
    return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
}

// 传入一个数值，使其十位和个位为0
CommonDecimalUtils.getTowZero = function (value) {
    if (this.isNotUndefinedNullZero(value)) {
        if(value <= 100){
            return 0;
        } else {
            return (Math.floor(value/100)) * 100;
        }
    }
    return 0;
};

//文件工具类
var CommonFileUtils = new Object();
//文件完整路径属性
CommonFileUtils.fileCompletePath = "fileCompletePath";
//获取文件路径集合
CommonFileUtils.getFileVoUrls = function(images){
    var fileVoUrls = [];
    for(var i in images){
        fileVoUrls.push(images[i][this.fileCompletePath]);
    }
    return fileVoUrls;
}
//文件上传标识
CommonFileUtils.detailFlags = {upload:1,detail:0};
//通过文件url路径将文件删除
CommonFileUtils.deleteFileVosByVos = function(deleteFileVos,fileVos){
    if(deleteFileVos.length > 0){
        var existFileVos = [];
        for(var i in fileVos){
            //为true代表不删
            var result = true;
            for(var j in deleteFileVos){
                if(deleteFileVos[j] == fileVos[i]){
                    result = false;
                }
            }
            if(result){
                existFileVos.push(fileVos[i]);
            }
        }
        return existFileVos;
    }

    return null;
}

CommonFileUtils.getBizFiles = function(fileType,files){
    var bizFiles = [];
    for(var i in files){
        var file = files[i];
        var bizFile = {fileType:fileType,fileName:file.fileOriginalName,filePath:file.fileCompletePath};
        bizFiles.push(bizFile);
    }
    return bizFiles;
}

CommonFileUtils.downloadFile = function(url){
    window.parent.open('file/downloadFile?fileCompletePath='+url);
}

CommonFileUtils.downloadFile = function(url,name){
    window.parent.open('file/downloadFile?fileCompletePath='+url+'&fileName='+name);
}


CommonFileUtils.downloadFileGet = function(url,params,$http,$modal,$scope){
    $scope.submit = true;
    $http.get(url+'?'+CommonHttpUtils.getParamsUrl(params)).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.submit = false;
            $scope.$apply();
            window.parent.open('file/downloadFile?fileCompletePath='+data.data);
        } else {
            modalAlert($modal, data.message);
            $scope.submit = false;
            $scope.$apply();
        }
    }).error(function (data) {
        modalAlert($modal, data);
        $scope.submit = false;
        $scope.$apply();
    })
}

CommonFileUtils.downloadFilePost = function(url,params,$http,$modal,$scope){
    $scope.submit = true;
    $http.post(url,params).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.submit = false;
            $scope.$apply();
            window.parent.open('file/downloadFile?fileCompletePath='+data.data);
        } else {
            modalAlert($modal, data.message);
            $scope.submit = false;
            $scope.$apply();
        }
    }).error(function (data) {
        modalAlert($modal, data);
        $scope.submit = false;
        $scope.$apply();
    })
}


//http工具类
var CommonHttpUtils = new Object();
CommonHttpUtils.getParamsUrl = function(params){
    var url = "";
    if(CommonObjectUtils.isExist(params)){
        for(var key in params){
            if(CommonObjectUtils.isExist(key) && CommonObjectUtils.isExist(params[key])) {
                if (url == "")
                    url = key + "=" + params[key];
                else
                    url = url + '&' + key + "=" + params[key];
            }
        }
    }
    return url;
}

//服务工具类
var CommonServiceType = new Object();

//服务类型
CommonServiceType.serviceTypes = {
    system: 0,
    baseinfo: 1,
    file: 2,
    activiti: 3,
    prebiz: 4,
    postbiz: 5,
    product: 6,
    finance:7,
    asset:11,
    insurance:8,
}

//excel导出类型
CommonServiceType.excelTypes = {
    one: 1,
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    sex: 6,
    seven:7,
    eight:8,
    nine:9,
}

//导出excel
CommonServiceType.exportExcel = function(serviceType,excelType,url,params){
    var hrefUrl =  '/excel/exportExcel?serviceFlag='+serviceType+'&requestUrl='+url+'&excelType='+excelType;
    if(CommonObjectUtils.isExist(params)){
        for(var key in params){
            if(CommonObjectUtils.isExist(key) && CommonObjectUtils.isExist(params[key]))
                hrefUrl = hrefUrl + '&' + key + "=" + params[key];
        }
    }
    window.parent.open(hrefUrl);
}

CommonServiceType.exportExcelMaxData = function(serviceType,excelType,url,params){
    var hrefUrl =  '/excel/exportExcel?serviceFlag='+serviceType+'&requestUrl='+url+'&excelType='+excelType+'&excelDataMax=1';
    if(CommonObjectUtils.isExist(params)){
        for(var key in params){
            if(CommonObjectUtils.isExist(key) && CommonObjectUtils.isExist(params[key]))
                hrefUrl = hrefUrl + '&' + key + "=" + params[key];
        }
    }
    window.parent.open(hrefUrl);
}

//check身份证长度
function cardIdCheck(obj,id,$compile,$scope) {

    /*var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,obj);
    var CertiNo = document.getElementById(id);
    if(certiType == '身份证'){
        CertiNo.setAttribute('ng-pattern','/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$/');//ng-pattern="/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/"
        $compile(CertiNo)($scope);
    }else{
        CertiNo.setAttribute('ng-pattern','/^[0-9a-zA-Z]+$/');
        $compile(CertiNo)($scope);
    }*/
    if(obj == 0){
        $scope[id] = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
    }else{
        $scope[id] = /^[0-9a-zA-Z]+$/;
    }
}
//验证身份证合法性
function cardIdValidation(obj,certifNo,$modal){
    var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,obj);
    if(certifNo && certiType=='身份证'){
        var code = certifNo;
        var city = {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
        var tip = "";
        if(!city[code.substr(0,2)]){
            modalAlert($modal,"身份证地址编码错误");
            return  false;
        }
        else{
            //18位身份证需要验证最后一位校验位
            if(code.length == 18){
                code = code.split('');
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = code[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                var last = parity[sum % 11];
                if(parity[sum % 11] != code[17]){
                    modalAlert($modal,"身份证校验位错误");
                    return  false;
                }
            }
        }
    }


  return true;
}
//----------------------------------------------------------
//  功能：根据身份证获取生肖
//  参数：身份证号 psidNo
//  返回值：
//  生肖
//----------------------------------------------------------
function getPet(psidNo) {
    var birthDayNo,birthDayTemp,birthYear;
    if(psidNo.length==18){
        birthDayNo=psidNo.substring(6,14)
    }else if(psidNo.length==15){
        birthDayTemp=psidNo.substring(6,12);
        birthDayNo="19"+birthDayTemp;
    }
    birthYear = birthDayNo.substring(0,4);
    var toYear = 1997;
    var birthPet="Ox";
    var x = (toYear - birthYear) % 12;
    if ((x == 1) || (x == -11)) {
        birthPet="1" }//鼠
    else {
        if (x == 0) {
            birthPet="2" }//牛
        else {
            if ((x == 11) || (x == -1)) {
                birthPet="3" }//虎
            else {
                if ((x == 10) || (x == -2)) {
                    birthPet="4" }//兔
                else {
                    if ((x == 9) || (x == -3)) {
                        birthPet="5" }//龙
                    else {
                        if ((x == 8) || (x == -4)) {
                            birthPet="6" }//蛇
                        else {
                            if ((x == 7) || (x == -5)) {
                                birthPet="7" }//马
                            else {
                                if ((x == 6) || (x == -6)) {
                                    birthPet="8" }//羊
                                else {
                                    if ((x == 5) || (x == -7)) {
                                        birthPet="9" }//猴
                                    else {
                                        if ((x == 4) || (x == -8)) {
                                            birthPet="10" }//鸡
                                        else {
                                            if ((x == 3) || (x == -9)) {
                                                birthPet="11" }//狗
                                            else {
                                                if ((x == 2) || (x == -10)) {
                                                    birthPet="12" }//猪
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return birthPet;
}
//----------------------------------------------------------
//  功能：根据身份证号获得出生日期
//  参数：身份证号 psidNo
//  返回值：
//  出生日期
//----------------------------------------------------------
function getBirthday(psidNo){
    var birthDayNo,birthDayTemp,birthDay;
    if(psidNo.length==18){
        birthDayNo=psidNo.substring(6,14)
    }else if(psidNo.length==15){
        birthDayTemp=psidNo.substring(6,12);
        birthDayNo="19"+birthDayTemp;
    }else{
        return false;
    }
    birthDay = birthDayNo.substring(0,4)+"-"+birthDayNo.substring(4,6)+"-"+birthDayNo.substring(6,8);
    return birthDay;
}

//----------------------------------------------------------
//  功能：根据身份证号获得性别
//  参数：身份证号 psidNo
//  返回值：
//  性别
//----------------------------------------------------------
function getSex(psidNo){
    var sexNo,sex;
    if(psidNo.length==18){
        sexNo=psidNo.substring(16,17);
    }else if(psidNo.length==15){
        sexNo=psidNo.substring(14,15);
    }else{
        return false;
    }
    var tempId=sexNo%2;
    if(tempId==0){
        sex='1';
    }else{
        sex='0';
    }
    return sex;
}
//----------------------------------------------------------
//  功能：根据身份证号获得年龄
//  参数：身份证号 psidNo
//  返回值：
//  年龄
//----------------------------------------------------------
function getAge(psidNo){
    var birthDayNo,birthDayTemp,birthDay;
    if(psidNo.length==18){
        birthDayNo=psidNo.substring(6,14)
    }else if(psidNo.length==15){
        birthDayTemp=psidNo.substring(6,12);
        birthDayNo="19"+birthDayTemp;
    }else{
        return false;
    }
    arr1 = [birthDayNo.substring(0,4),birthDayNo.substring(4,6),birthDayNo.substring(6,8)];
    var arr2 = [];
    var myDate = new Date();
    arr2[0] = myDate.getFullYear();
    arr2[1] = myDate.getMonth()+1;
    arr2[2] = myDate.getDate();
    var age = arr2[0] - arr1[0];
    if(arr2[1]-arr1[1]<0){
        age = age - 1;
    }else if(arr2[1]-arr1[1]==0){
        if(arr2[2]-arr1[2]<0){
            age = age - 1;
        }
    }else{

    }
    return age;
}

//----------------------------------------------------------
//  功能：根据初次领证日期算驾龄
//  参数：初次领证日期time
//  返回值：
//----------------------------------------------------------
function getDrivingAge(time) {
    var arr1 = time.split('-');
    var arr2 = [];
    var year = 0,month = 0,num = 0;
    var myDate = new Date();
    arr2[0] = myDate.getFullYear();
    arr2[1] = myDate.getMonth()+1;
    arr2[2] = myDate.getDate();
    year = arr2[0] - arr1[0];
    if(arr2[1]-arr1[1]<0){
        year = year - 1;
    }else if(arr2[1]-arr1[1]==0){
        if(arr2[2]-arr1[2]<0){
            year = year - 1;
        }
    }else{

    }
    if(year<=0){
        year = 1
    }
    return year;
}
//----------------------------------------------------------
//  功能：最早卡户记录距今月数
//  参数：初次领证卡time
//  返回值：
//  月数
//----------------------------------------------------------
function getMonNum(time) {
    var arr1 = time.split('-');
    var arr2 = [];
    var num = 0,year = 0,month = 0;
    var myDate = new Date();
    arr2[0] = myDate.getFullYear();
    arr2[1] = myDate.getMonth()+1;
    year = arr2[0] - arr1[0];
    month = arr2[1] - arr1[1];

    return year*12 + month;
}
//表单验证消息提醒
function remindMsg(timeout,toaster) {
    timeout(function () {
        if($(".form-info:not(.ng-hide)").length > 0){
            $(".form-info:not(.ng-hide)").each(function (i,v) {
                var text = $(v).text();
                toaster_info(text,toaster);
                return false;
            });
        }else{
            toaster_info(promptInfo.submitWarn,toaster);
        }
    });
}

CommonNumberUtils.numberLength = function(length,obj){
    if(obj.value.length > length)
        obj.value = obj.value.slice(0,length);
}

CommonNumberUtils.numberKeyPress = function(event){
    if (String.fromCharCode(event.keyCode).match(/[0-9\.]/) == null) {
        return false;
    }
    return true;
}

CommonNumberUtils.compare = function (prop) {
    return function (obj1, obj2) {
        var val1 = obj1[prop];
        var val2 = obj2[prop];
        if (!isNaN(Number(val1)) && !isNaN(Number(val2))) {
            val1 = Number(val1);
            val2 = Number(val2);
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
