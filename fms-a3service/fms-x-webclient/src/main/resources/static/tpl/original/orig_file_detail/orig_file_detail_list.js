/**
 * Created by ningyangyang on 2018-05-03.
 */
app.controller('orig_file_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location',function ($scope, $http, $modal, toaster,$compile,$location) {

    $scope.origFileDetailVo={}
    $scope.origFileDetailBizCodes = $location.search()['bizCodesList'];
    $scope.fileSend={}
    $scope.fileSolveFlag = 'mail';

    $scope.formValidate = false;

    $scope.submit = false;

    // if($scope.origFileDetailBizCodes.length!=0){
    //     init();
    // }
    init();
    //参数配置
    function init(){

        $http.get('orig_file_detail/findOrigFileDetailsByPage?origFileDetailBizCodes='+$scope.origFileDetailBizCodes+'&fileSolveFlag='+ $scope.fileSolveFlag).success(function (data) {
            $scope.origFileDetailVoList = data.data;

            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'orig_file_detail_table',
                //table的列
                dataTableColumn: [
                    defaultCheckBox('origFileDetailId'),
                    defaultDetail('bizCode','detailOrigFileDetail','资料邮寄业务号','20%',$compile,$scope,'origFileDetailId'),
                    {title:'资料邮寄业务类型',data:'bizCodeType',width:'20%',
                        render:function (data) {
                            return  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data)
                        }
                    },
                    {title:'文件类型',data:'fileType',width:'20%'},
                    {title:'文件数量',data:'fileQtyLimit',width:'20%'},
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render:function (data) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                        }
                    },
                ],
                dataTableSelectType: CheckBox,
                dataTableData:$scope.origFileDetailVoList
            }
            //创建dataTable
            //$scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
            $scope.dataTable =  CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
        })
       }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.bizCode = $scope.bizCode;
        params.bizCodeType = $scope.bizCodeType;
        params.fileSolveFlag = 'mail';
        return params;
    }
    // $scope.searchOrigFileDetail = function(){
    //     $scope.dataTable.fnDraw(true);
    // }
    //
    // $scope.resetOrigFileDetail = function(){
    //     $scope.bizCode = "";
    //     $scope.bizCodeType = "";
    //     $scope.dataTable.fnDraw(true);//刷新
    // }
    /**
     * 资料邮寄
     */
    $scope.filePost = function () {

        if(!$scope.form.$invalid && checkData()) {

            $scope.submit = true;
            $scope.fileSend.origFileDetails = $scope.dataTable.getRows();
            console.log($scope.fileSend)
            $http.post('file_send/saveFileSend', $scope.fileSend).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,"资料邮寄成功");
                    $scope.submit = false;
                    $location.path('app/original_orig_file_list')
                }else
                    {
                    modalAlert($modal,"资料邮寄失败");
                    $scope.submit = false;
                }

            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }

    $scope.close = function () {
        $location.path('app/original_orig_file_list')
    }

    function checkData(){
        var rows = $scope.dataTable.getRows();
        if(rows.length<1){
            modalAlert($modal,'请选择要操作的数据');
            return false;
        }
        return true;
    }

}])
;