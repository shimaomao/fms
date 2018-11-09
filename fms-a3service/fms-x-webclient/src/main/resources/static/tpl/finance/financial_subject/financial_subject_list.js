/**
 * Created by yanfengbo on 2018-06-20.
 */
app.controller('financial_subject_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveFinancialSubject'){
            toaster_success('添加财务科目成功',toaster);
        }else if($scope.messageType=='modifyFinancialSubject'){
            toaster_success('编辑财务科目成功',toaster);
        }

    }, 5);

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

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchFinancialSubject = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialSubject = function(){
        $scope.subjectCd = "";
        $scope.subjectName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //添加
    $scope.saveFinancialSubject = function(){
        $location.path('app/finance_financial_subject_save').search({'frameTitle':'添加财务科目','operate':'save'});
    }

    //修改
    $scope.modifyFinancialSubject = function(subjectId){
        var rowsIds =  $scope.dataTable.getRowsIds('subjectId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/finance_financial_subject_modify').search({'frameTitle':'修改财务科目','operate':'update','subjectId': rowsIds[0]});
        }

    }

    //详情
    $scope.detailFinancialSubject = function(subjectId){
        $location.path('/app/finance_financial_subject_detail').search({'frameTitle':'财务科目详情','operate':'check','subjectId': subjectId});
    }

    //删除
    $scope.deleteFinancialSubject = function(){
        var rows =  $scope.dataTable.getRows('subjectId');
        if(rows.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('financial_subject/deleteFinancialSubjectsBySubjectIds',getDeleteData(rows)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除财务科目信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

}])
;