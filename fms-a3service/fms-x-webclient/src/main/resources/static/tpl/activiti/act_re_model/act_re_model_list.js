/**
 * Created by qiaohao on 2018/2/1.
 */
app.controller('act_re_model_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'act_re_model/findActReModelsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'act_re_model_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox(),
            {title:'流程分类',data:'category',width:'10%'},
            {title:'模型id',data:'id',width:'10%'},
            {title:'模型标识',data:'key',width:'10%'},
            {title:'模型名称',data:'name',width:'10%'},
            {title:'版本号',data:'version',width:'10%'},
            {title:'模型xml',data:'modelXml',width:'10%',
            render:function(data,type,row,meta){
                return "<a class='a1' href='act_re_model/findActReModelXmlByModelId?modelId="+row['id']+"' target='_blank'>点击查看</a>";
            }},
            {title:'创建时间',data:'createTime',width:'20%'},
            {title:'最后更新时间',data:'lastUpdateTime',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};

        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchActReModel = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetActReModel = function(){
        $scope.description="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }


    $scope.saveActReModel = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/activiti/act_re_model/act_re_model_save.html'+getCacheTime(),
            controller: 'act_re_model_save_controller',
            resolve:{

            }
        });
        rtn.result.then(function (modelId) {
            if(isNotUndefinedNull(modelId)) {
                drawingActReModelHrefUrl(modelId);
                drawingActReModel();
                toaster_success('添加模型成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyActReModel = function(sysResourceId){
        var rowsIds =  $scope.dataTable.getRowsIds('id');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            drawingActReModelHrefUrl();
            drawingActReModel();
        }

    }


    $scope.deleteActReModel = function(){
        var rowsIds =  $scope.dataTable.getRowsIds();
        if(rowsIds.length < 1){
            alert('请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('act_re_model/deleteActReModelByModelId',getDeleteData(rowsIds[0])).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除模型成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        toaster_success(data.message, toaster);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.deployActReModel = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('id');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要部署的数据');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时部署一条数据');
        else{
            $http.post('act_re_model/deployActReModel?modelId='+rowsIds[0]).success(function (data) {
                if(data.code == Response.successCode) {
                    toaster_success('部署成功', toaster);
                }else
                    alert(data.message);
            })
        }
    }


    function drawingActReModelHrefUrl(modelId){
        if(isUndefinedNull(modelId)) {
            var rowsIds = $scope.dataTable.getRowsIds('id');//主键
            modelId = rowsIds[0];
        }
        $("#drawingActReModelHref").attr("href","modeler.html?modelId="+modelId);
    }

    function drawingActReModel(){
        $("#drawingActReModelHrefSpan").click();
    }

}])
;