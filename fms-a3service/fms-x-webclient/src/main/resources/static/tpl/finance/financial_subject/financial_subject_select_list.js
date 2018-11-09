/**
 * Created by ningyangyang on 2018/6/23.
 */
/**
 * Created by yanfengbo on 2018-06-20.
 */
app.controller('financial_subject_select_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$modalInstance) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'financial_subject/findFinancialSubjectsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'financial_subject_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('subjectId'),
            defaultDetail('subjectCd','detailFinancialSubject','科目代码','20%',$compile,$scope,'subjectId'),
            {title:'科目名称',data:'subjectName',width:'20%'},
            {title:'辅助核算类型',data:'assisAccountTypeVos',width:'20%',
                render:function (data) {
                    var str = '';
                    for(var i in data){
                        if(i == data.length - 1){
                            str = str + data[i].assisAccountTypeName;
                        }else{
                            str = str + data[i].assisAccountTypeName + '/';
                        }
                    }
                    return str;
                }
            },
            {title:'用途备注',data:'subjectMemo',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.subjectCd = $scope.subjectCd;
        params.subjectName = $scope.subjectName;
        return params;
    }

    // //创建dataTable
    // $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.init = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchFinancialSubject = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialSubject = function(){
        $scope.subjectCd = "";
        $scope.subjectName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //关闭
    $scope.close = function (status) {
        $modalInstance.close(status);
    };

    //确定
    $scope.save = function (subjectId) {
        var subjectCd = $scope.dataTable.getRow(subjectId,'subjectCd');
        if(subjectCd){
            $scope.close(subjectCd);
        }else{
            modalAlert($modal,"请选择一条数据");
        }
    };
    $scope.detailFinancialSubject = function(subjectId){
        var subject = $scope.dataTable.getRow(subjectId,'subjectId');
        $scope.close(subject);
    }

}])
;
