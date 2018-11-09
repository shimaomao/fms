/**
 * Created by qiaohao on 2018/1/9.
 */
app.controller('sys_user_list_select_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile','sysUserRoleCode', function ($scope, $http, $modal,$modalInstance, toaster,$compile,sysUserRoleCode) {

    /******************请求列表初始化开始*******************/
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_user/findSysUserVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_user_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('userId'),
            defaultDetail('user','getRowData','用户代码','20%',$compile,$scope,'userId'),
            {title:'用户名称',data:'userName',width:'20%'},
            {title:'机构(用户组)',data:'groupCode',width:'20%'},
            {title:'角色信息',data:'roles',width:'120%',

                render: function (data, type, row, meta) {
                    var str ='';
                    for( var i in data ){
                        if(i == data.length-1){
                            str = str+data[i].roleName
                        }else

                            str = str+data[i].roleName+','
                    }
                    return str
                }

            },
            {title:'用户电话',data:'userTelNo',width:'20%'},
            {title:'用户手机',data:'userMobileNo',width:'20%'},
            {title:'用户邮箱',data:'userMailAddress',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
     function dataTableParams($scope){
        params = {};
        params.user = $scope.user;
        params.userName = $scope.userName;
        if(CommonObjectUtils.isExist(sysUserRoleCode))
            params.role = sysUserRoleCode;
        return params;
    }


     $scope.init = function(){
         //创建dataTable 封装了datatable
         $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
     }

    /******************请求列表初始化结束*******************/


    /******************请求列表查询开始*******************/
    $scope.searchSysUser = function(){
        $scope.dataTable.fnDraw(true);//框架内部方法
    }
    $scope.resetSysUser = function(){
        $scope.user="";
        $scope.userName="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }
    /******************请求列表查询结束*******************/


    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };
    //点击一条开户行直接获取
    $scope.getRowData = function (userId) {
        var data = $scope.dataTable.getRow(userId,'userId');
        $modalInstance.close(data);
    }

    $scope.confirm = function(status){
        if(status != 'none') {
            var data = $scope.dataTable.getRow();
            if(data == null)
                modalAlert($modal,'请选择上级');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    }

}])
;