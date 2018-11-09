
app.controller('bas_file_type_list_select_controller', ['$scope', '$http', '$modal','$modalInstance','setData', 'toaster','$compile','$location', function ($scope, $http, $modal,$modalInstance,setData, toaster,$compile,$location) {
    //参数配置
    if(!setData.checkboxOrRadio){
        setData.checkboxOrRadio = CheckBox;
    }

    $scope.dataTableProperties= {

        dataTableAjax : {
            url : 'bas_file_type/findBasFileTypeByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_file_type_select_table',

        //table的列
        dataTableColumn: [
            defaultCheckBox('fileTypeId'),
            defaultDetail('fileType','detailBasFileType','附件类型代码','20%',$compile,$scope,'fileTypeId'),
            {title:'附件类型名称',data:'fileTypeName',width:'20%'},
        ],

        //列是单选还是多选 CheckBox 多选 Radio 单选
        dataTableSelectType: setData.checkboxOrRadio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.fileTypeName = $scope.fileTypeName;
        return params;
    }


    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    }





    $scope.searchBasFileType = function(){
        $scope.dataTable.fnDraw(true);//框架内部方法
    }


   

    $scope.resetBasFileType = function(){
        $scope.fileTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };


    $scope.detailBasFileType = function (fileTypeId) {
        var data = $scope.dataTable.getRow(fileTypeId,'fileTypeId');
        var datas = [];
        datas.push(data)
        $modalInstance.close(datas);
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };


    $scope.confirm = function(status){
        if(status != 'none') {

            var data ;
            if(setData.checkboxOrRadio == 'radio'){
                data = $scope.dataTable.getRow();
            }else {
                data = $scope.dataTable.getRows();
            }
            if(data == null)
                modalAlert($modal,'请选择一个附件类型代码作为新增附件的上级类型代码');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.two,
            'bas_file_type/findParentFileTypes',dataTableParams($scope));
    }

}])
;
