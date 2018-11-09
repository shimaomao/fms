'use strict';


var leadu_app = angular.module('app', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ngStorage',
    'ui.router',
    'ui.bootstrap',
    'ui.load',
    'ui.jq',
    'ui.validate',
    'oc.lazyLoad',
    'pascalprecht.translate',
    'ivh.treeview'
]).run(
    function($rootScope){
        //在ng中保存通用的常量
        //业务类型
        $rootScope.bizTypes = CommonCodeUtils.bizTypes;
        //资方集合
        $rootScope.managements = CommonCodeUtils.managements;
        //手机号验证
        $rootScope.phonePattern = new RegExp(CommonCodeUtils.phonePattern);
        //gps厂商代码
        $rootScope.gpsSellerTypes = CommonCodeUtils.gpsSellerTypes;
        //是否代码
        $rootScope.yesNoFlag = CommonCodeUtils.yesNoFlag;
        //字典类型
        $rootScope.codeTypes = CommonCodeUtils.codeTypes;
        //字典类型utils
        $rootScope.CommonCodeUtils = CommonCodeUtils;
        //附件类型
        $rootScope.basFileTypes = CommonCodeUtils.basFileTypes;
        //附件类型路径
        $rootScope.fileTypePaths = CommonCodeUtils.fileTypePaths;
        //对象util
        $rootScope.CommonObjectUtils = CommonObjectUtils;
    }
);

leadu_app.value('sysUserRoleCode',null);