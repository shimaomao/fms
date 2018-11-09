/**
 * Created by ningyangyang on 2018/3/20.
 */


app.controller('sys_user_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http, $modal, toaster,$location,$compile) {

    $scope.sysUser ={
    };
    $scope.sysUser.enableFlag = 0;
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.rolenames=[]

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.common_status);
    //性别
    $scope.genderList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gender)
    //菜单权限类型
    $scope.validMenuTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.sys_validMenuType)
    //证件类型
    $scope.certifTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    $scope.userDeptLevelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.userDeptLevel)
    var str ='';

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid && checkRole()) {

            $scope.submit = true;
            $scope.sysUser.roles =  $scope.rolenames
            console.log($scope.sysUser)
            $http.post('sys_user/saveSysUser', $scope.sysUser).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/system_sys_user_list").search({type:'save'});
                }

                else{
                    modalAlert($modal,data.message);
                    $scope.sysUser.roles = str;
                    $scope.submit = false;
                }
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    initTable();
   //初始化角色table
    function initTable(){
        var tableData =[];
        if($scope.rolenames.length>0){
            for(var i in  $scope.rolenames){
                var node = [$scope.rolenames[i].role,$scope.rolenames[i].roleName,$scope.rolenames[i].role]
                tableData.push(node)
            }
        }
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'user_table',
            //table的列
            dataTableColumn: [
                {DataProp : "role", title:'角色代码', class:'center'},
                { DataProp : "roleName",title:'角色名称', class:'center'},
                {title:'操作', "render":function(data, type,row){
                                var html = '<a style="color:#2dc9ff"  ng-click="alt('+'\''+data+'\''+')"></i>删除</a>';
                                return html;},
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {$compile(nTd)($scope);}}
            ],
            dataTableData: tableData
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }
  $scope.alt = function(data) {
     for(var i in $scope.rolenames){
        if($scope.rolenames[i].role==data)
            $scope.rolenames.splice(i,1)
     }
      initTable();
  }

    //选择用户组
    $scope.selectSysUserGroup = function () {
        var rtn = $modal.open({

            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group/sys_group_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_list_select_controller',
            resolve:{
                parentGroup:function () {
                    return {parentType:'1'};
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysUser.groupName = data.groupName;
                $scope.sysUser.groupCode = data.groupCode;
            }
        },function(){

        });

    }
    //选择角色
    $scope.selectSysUserRoles = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_role/sys_role_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_role_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {

            if(data != null) {
                for( var i in data ){
                    if($scope.rolenames.length>0){
                        for(var j in $scope.rolenames){
                            if($scope.rolenames[j].role==data[i].role)
                                break;
                            else if(j == $scope.rolenames.length-1){
                                $scope.rolenames.push(data[i]);
                            }
                        }
                    }else{
                        $scope.rolenames.push(data[i]);
                    }
                }
                initTable();
                $('#userRoles').val(str)
                $scope.sysUser.roles = str;
            }
        },function(){

        });


    }

    function checkRole(){
        if($scope.rolenames.length==0){
            modalAlert($modal,'用户角色不能为空');
            return false;
        }
        return true;
    }
    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_user_list");
    };

}]);