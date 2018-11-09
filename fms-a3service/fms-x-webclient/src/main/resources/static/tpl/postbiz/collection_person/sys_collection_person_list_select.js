/**
 * Created by ningyangyang on 2018/3/21.
 */

app.controller('sys_collection_person_list_select_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile','sysUserRoleCode', function ($scope, $http, $modal,$modalInstance, toaster,$compile,sysUserRoleCode) {

    /******************请求列表初始化开始*******************/
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'collection_person/findCollectionPersonVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'collection_person_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('collectionPersonId'),
            defaultDetail('collectionPersonNum','getRowData','分配人员账号','20%',$compile,$scope,'collectionPersonId'),
            //{title:'催收人员账号',data:'collectionPersonNum',width:'20%'},
            //{title:'催收类型',data:'collectionType',width:'20%'},
            {title:'催收类型',data:'collectionType',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType, data);
                }
            },
            {title:'备注',data:'remark',width:'20%'},
        ],
      //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

  //请求的参数
   function dataTableParams($scope){
        params = {};
        /*params.collectionPersonNum = $scope.collectionPersonNum;
        params.collectionType = $scope.collectionType;*/
        if(CommonObjectUtils.isExist(sysUserRoleCode))
            params.role = sysUserRoleCode;
        return params;
    }


    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    }
    /******************请求列表初始化结束*******************/

    //确认催收人员
    //点击一条开户行直接获取
    $scope.getRowData = function (collectionPersonId) {
        var data = $scope.dataTable.getRow(collectionPersonId,'collectionPersonId');
        $modalInstance.close(data);//关闭窗口返回data（获取的一行（collectionPerson对象））到overdue_rwfp.js中
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


    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };


}])
;