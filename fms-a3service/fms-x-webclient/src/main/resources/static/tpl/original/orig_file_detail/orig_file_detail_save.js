/**
 * Created by ningyangyang on 2018-05-03.
 */
app.controller('orig_file_detail_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', 'origFiles',function ($scope, $http,$modal, $modalInstance,toaster,origFiles) {

    $scope.fileSend={};

    $scope.origFilesDetails = origFiles;

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.$watch('origFilesDetails',function (data) {
        if(data){
            init();
            $scope.fileSend.origFileDetails = $scope.origFilesDetails;
        }
    })

    function init(){
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'orig_file_post_table',
            //table的列
            dataTableColumn: [
                //defaultDetail('bizCode','detailOrigFileDetail','资料邮寄业务号','20%',$compile,$scope,'origFileDetailId'),
                {title:'资料邮寄业务号',data:'bizCode',width:'20%'},
                {title:'资料邮寄业务类型',data:'bizCodeType',width:'20%'},
                {title:'附件类型',data:'fileType',width:'20%'},
                // {title:'文件数量',data:'fileCount',width:'20%'},
                // {title:'资料邮寄ID',data:'filePostId',width:'20%'},
                // {title:'归档编号',data:'fileRecordNo',width:'20%'},
                // {title:'文件状态',data:'origFileStatus',width:'20%'},
                // {title:'文件补充信息1',data:'fileInfo1',width:'20%'},
                // {title:'文件补充信息2',data:'fileInfo2',width:'20%'},
                // {title:'文件补充信息3',data:'fileInfo3',width:'20%'},
            ],
            dataTableData:$scope.origFilesDetails
        }
        $scope.dataTable =  CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

  init();
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            //$scope.fileSend.origFileDetails = $scope.origFilesDetails;
            console.log($scope.fileSend)
            $http.post('file_send/saveFileSend', $scope.fileSend).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


