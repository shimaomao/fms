/**
 * Created by qiaohao on 2018/1/9.
 */
app.controller('sys_code_type_list_select_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile', function ($scope, $http, $modal,$modalInstance, toaster,$compile) {
    /******************请求列表初始化开始*******************/
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_code_type/findSysCodeTypesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_code_select_table',

        //table的列
        dataTableColumn: [
            defaultCheckBox('codeTypeId'),
            defaultDetail('codeType','getRowData','数据字典类型代码','20%',$compile,$scope,'codeTypeId'),
            {title:'数据字典类型名称',data:'codeTypeName',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            }
        ],

        //列是单选还是多选 CheckBox 多选 Radio 单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.codeType = $scope.codeType;
        params.codeTypeName = $scope.codeTypeName;
        return params;
    }


     $scope.init = function(){
         //创建dataTable 封装了datatable
         $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
     }

    /******************请求列表初始化结束*******************/


    /******************请求列表查询开始*******************/
    $scope.searchSysCodeType = function(){
        $scope.dataTable.fnDraw(true);//框架内部方法
    }

    $scope.resetSysCodeType = function(){
        $scope.codeType = "";
        $scope.codeTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
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
    $scope.getRowData = function (codeTypeId) {
        var data = $scope.dataTable.getRow(codeTypeId,'codeTypeId');
        $modalInstance.close(data);
    }

    $scope.confirm = function(status){
        if(status != 'none') {
            var data = $scope.dataTable.getRow();
            if(data == null)
                modalAlert($modal,'请选择字典类型');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    }

}])
;