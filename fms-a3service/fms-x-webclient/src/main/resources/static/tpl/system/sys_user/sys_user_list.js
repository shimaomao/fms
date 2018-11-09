/**
 * Created by ningyangyang on 2018-03-20.
 */
app.controller('sys_user_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', '$timeout',function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
// 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加用户信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑用户信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_user/findSysUserVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_user_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('userId'),
            defaultDetail('user','detailSysUser','用户代码','20%',$compile,$scope,'userId'),
            {title:'用户名称',data:'userName',width:'20%'},
            {title:'机构(用户组)',data:'groupName',width:'20%'},
            {title:'角色信息',data:'roles',width:'300%',

                render: function (data, type, row, meta) {
                    var str = '';
                    for( var i in data ){
                        if(i == data.length-1){
                            str = str+data[i].roleName
                        }else

                            str = str+data[i].roleName+','
                    }
                    //var html = '<a ng-click="checkRole('+'\''+str+'\''+')">查看角色</a>';
                     return str;
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            {title:'用户电话',data:'userTelNo',width:'20%'},
            {title:'用户手机',data:'userMobileNo',width:'20%'},
            {title:'用户邮箱',data:'userMailAddress',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {

                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,data)
                    //consValue(common_constant_code.common_status,data)
                }

            },
            {title:'入职日期',data:'employDate',width:'20%'},
            {title:'用户性别',data:'sex',width:'20%',
                render: function (data, type, row, meta) {

                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,data)
                    //consValue(common_constant_code.gender,data)
                }
            },
            {title:'菜单权限类型',data:'validMenuType',width:'20%',
                render: function (data, type, row, meta) {

                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_validMenuType,data)
                    //consValue(common_constant_code.sys_validMenuType,data)
                }
            },
            {title:'最后登录时间',data:'lastLoginTime',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.user = $scope.user;
        params.userName = $scope.userName;
        params.groupName = $scope.groupName;
        params.roleName = $scope.roleName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    $scope.searchSysUser = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysUser = function(){
        $scope.user = "";
        $scope.userName = "";
        $scope.groupName = "";
        $scope.roleName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }



  //新增用户
    $scope.saveSysUser = function(){

          $location.path('/app/system_sys_user_save');

    }

    $scope.modifySysUser = function(userId){
        var rowsIds =  $scope.dataTable.getRowsIds('userId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/system_sys_user_modify').search({'userId':rowsIds[0]})


        }

    }


    $scope.detailSysUser = function(userId){
        var sysUser = $scope.dataTable.getRow(userId,'userId');
        var sysUserId = sysUser.userId;
        $location.path('/app/system_sys_user_detail').search({'userId': sysUserId});
    }

    $scope.deleteSysUser = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('userId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_user/deleteSysUserByIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除用户信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }
    //查看用户角色
     $scope.checkRole = function (data) {
        modalAlert($modal,data,'用户角色')
     }

     $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_user/findSysUserVoByPage',dataTableParams($scope));
     }

}])
;