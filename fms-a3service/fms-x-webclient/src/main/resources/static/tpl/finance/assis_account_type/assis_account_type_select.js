/**
 * Created by ningyangyang on 2018/6/23.
 */
app.controller('assis_account_type_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$modalInstance',function ($scope, $http, $modal, toaster,$compile,$modalInstance) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'assis_account_type/findAssisAccountTypesByPage2',
            type:"GET",
        },
        //table的html id
        dataTableId:'assis_account_type_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('assisAccountTypeId'),
            defaultDetail('assisAccountType','detailAssisAccountType','辅助核算类型','20%',$compile,$scope,'assisAccountTypeId'),
            {title:'辅助核算类型名称',data:'assisAccountTypeName',width:'20%'},
            {title:'核算项目值设值',data:'assisAccountValue',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.assisAccountType = $scope.assisAccountType;
        params.assisAccountTypeName = $scope.assisAccountTypeName;
        return params;
    }

    // //创建dataTable
    // $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    $scope.init = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchAssisAccountType = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetAssisAccountType = function(){
        $scope.assisAccountType = "";
        $scope.assisAccountTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //关闭
    $scope.close = function (status) {
        $modalInstance.close(status);
    };

    //确定
    $scope.save = function () {
        var subjectCd = $scope.dataTable.getRows();
        if(subjectCd){
            $scope.close(subjectCd);
        }else{
            modalAlert($modal,"请选择一条数据");
        }
    };
    $scope.detailAssisAccountType = function(assisAccountTypeId){
        var assisAccountType = $scope.dataTable.getRow(assisAccountTypeId,'assisAccountTypeId');
        var datas = [];
        datas.push(assisAccountType)
        $scope.close(datas);
    }


}])
;
