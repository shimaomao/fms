/**
 * Created by ningyangyang on 2018-05-04.
 */
app.controller('file_send_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location',function ($scope, $http, $modal, toaster,$compile,$location) {


    $scope.fileSend ={
        filePostId:'',
        taskId:''
    }

    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId'];
    init();
    function init(){

        $http.get('file_send/findFileSendsByPage?postNo='+$scope.serviceId).success(function (data) {
            $scope.fileSends = data.data.data;
            $scope.filesend = $scope.fileSends[0];
            console.log($scope.fileSends)
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'file_send_table',
                //table的列
                dataTableColumn: [
                    //defaultCheckBox('filePostId'),
                    //defaultDetail('postComp','detailFileSend','快递公司','20%',$compile,$scope,'filePostId'),
                    {title:'快递公司',data:'postComp',width:'20%'},
                    {title:'快递编号',data:'postNo',width:'20%'},
                ],
                dataTableData: $scope.fileSends
            }

            //创建dataTable
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);

        })
        }

    $scope.modifyFileSend = function(){
            $scope.fileSend.filePostId = $scope.filesend.filePostId;
            $scope.fileSend.taskId = $scope.taskId;
        if(isUndefinedNull($scope.fileSend.filePostId)){
            modalAlert($modal,'当前没有等待签收的快递');
            $location.path('app/home');
        }else {
            $http.put('file_send/modifyFileSend', $scope.fileSend).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,'签收成功');
                    $location.path('app/home');
                    $scope.submit = false;
                }else {
                    modalAlert($modal,'签收失败');
                }

            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }

    }


    $scope.detailFileSend = function(filePostId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/file_send/file_send_detail.html'+getCacheTime(),
            controller: 'file_send_detail_controller',
            resolve:{
                fileSend : function (){ return $scope.dataTable.getRow(filePostId,'filePostId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteFileSend = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('filePostId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('file_send/deleteFileSendByFilePostIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除prebiz信息成功', toaster);
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