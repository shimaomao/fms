'use strict';

/* Filters */
// need load the moment.js to use this filter. 
angular.module('app')
    .filter('fromNow', function() {
        return function(date) {
          return moment(date).fromNow();
        }
    })
    //获取数据字典name
    //用法  {{value | getName:'type'}}
    .filter('getName', function() {
        return function(codeValue,codeType) {
            try {
                return CommonCodeUtils.commonCodeValues[codeType + CommonStringUtils.LINE + codeValue].codeValueName;
            }catch (err){
                return '';
            }
        };
    })
    //获取地点(省、市、县)name
    //用法  {{value | getAreaName}}
    .filter('getAreaName', function() {
        return function(codeValue) {
            try {
                return common_area_value[common_area_code.getName][codeValue];
            }catch (err){
                return '';
            }
        };
    })
    //根据字典类型获取下方的字典集合
    //用法  ng-repeat="a in 'name' | getList"
    .filter('getList', function() {
        return function(name) {
            try{
                return CommonCodeUtils.commonCodeValuesTree[name];
            }catch (err){
                return '';
            }
        };
    })
    .filter('toArr', function() {
        return function(data) {
            if(data == null || !data){
                return []
            }
            return data.split(',');
        };
    })
    /*获取利率方案的codeValueName*/
    .filter('getCodeName', function() {
        return function(data,name,type,dataGroup) {
            if(type == 1){
                var result = '';
                if(data != null){
                    var dataArray=data.split(",");
                }
                for(var x in dataArray){
                    result+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes[name],dataArray[x])+",";
                }
                if(result!=""){
                    return result.substring(0,result.length-1);
                }else{
                    return "";
                }
                return result;
            }else{
                return dataGroup.factorValueFrom + '~' + dataGroup.factorValueTo;
            }

        };
    })
    /*利率方案intrstDelFlag*/
    .filter('intrstShow', function() {
        return function(data) {
            var flag = false;
            if(data.length != 0 && data){
                for(var i=0;i<data.length;i++){
                    if(data[i].intrstDelFlag != 1){
                        flag = false;
                        break;
                    }else {
                        flag = true;
                    }
                }
            }else{
                flag = true;
            }
            return flag;
        };
    })
    .filter('getTime', function() {
        return function(value) {
            if(isNotNullEmpty(value)){
                return new Date(value).Format("yyyy-MM-dd");
            }
            return "";
        };
    })
    .filter('thousandsFormat', function() {
        return function(num) {
            if(isNotNullEmpty(num)){
                num = num.toString();   //将输入的数字转换为字符串

                if(/^-?\d+\.?\d+$/.test(num)){  //判断输入内容是否为整数或小数
                    if(/^-?\d+$/.test(num)){    //判断输入内容是否为整数
                        num =num + ",00";   //将整数转为精度为2的小数，并将小数点换成逗号
                    }else{
                        num = num.replace(/\./,',');    //将小数的小数点换成逗号
                    }

                    while(/\d{4}/.test(num)){ //
                        /***
                         *判断是否有4个相连的数字，如果有则需要继续拆分，否则结束循环；
                         *将4个相连以上的数字分成两组，第一组$1是前面所有的数字（负数则有符号），
                         *第二组第一个逗号及其前面3个相连的数字；
                         * 将第二组内容替换为“,3个相连的数字，”
                         ***/
                        num = num.replace(/(\d+)(\d{3}\,)/,'$1,$2');
                    }

                    num = num.replace(/\,(\d*)$/,'.$1');   //将最后一个逗号换成小数点
                    return num;
                }
            }
            return "";
        };
    })
;