/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('collection_task_save_controller', ['$scope', '$http','$modal','toaster', '$location','$timeout',function ($scope, $http,$modal,toaster,$location,$timeout) {

    $scope.collectionTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.collectionTaskNo = "";
    $scope.overdueContId = $location.search()['overdueContId'];
    $scope.taskId = $location.search()['taskId'];
    if ($location.search()['serviceId']){
        $scope.collectionTaskNo = $location.search()['serviceId'];
    } else if($location.search()['collectionTaskNo']){
        $scope.collectionTaskNo = $location.search()['collectionTaskNo'];
    }
    if ($location.search()['overdueCstmId']){
        $scope.overdueCstmId = $location.search()['overdueCstmId'];
    }
    if (CommonStringUtils.isNotTrimBlank($scope.taskId)){
      if ($scope.collectionTaskNo){
        // 如果是派单退回
        $http.get('collection_task/findCollectionTasksByTaskNo?collectionTaskNo='+ $scope.collectionTaskNo).success(function (data) {
          if (data.code == Response.successCode){
            $scope.collectionTaskVo = data.data;
            $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
            $scope.collectionTaskVo.remark = "";
            initDetailTable();
          }else{
            modalAlert($modal,data.message);
          }
        });
      }
    } else {
      if ($scope.overdueCstmId){
        // 如果是从一览界面选择任务进入
        $http.get('collection_task/findCstmAddrInfosByOverdueCstmId?overdueCstmId='+ $scope.overdueCstmId).success(function (data) {
          $scope.collectionTaskVo = data.data;
          if ($scope.collectionTaskNo){
            $scope.collectionTaskVo.collectionTaskNo = $scope.collectionTaskNo;
          }
          $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
          $scope.collectionTaskVo.remark = "";
          console.log(data.data);
          initDetailTable();
        });
      }
    }
    /*if ($scope.collectionTaskNo){
        // 如果是派单退回
        $http.get('collection_task/findCollectionTasksByTaskNo?collectionTaskNo='+ $scope.collectionTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.collectionTaskVo = data.data;
                $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
                $scope.collectionTaskVo.remark = "";
                initDetailTable();
            }else{
                modalAlert($modal,data.message);
            }
        });
    } else if ($scope.overdueCstmId){
        // 如果是从一览界面选择任务进入
        $http.get('collection_task/findCstmAddrInfosByOverdueCstmId?overdueCstmId='+ $scope.overdueCstmId).success(function (data) {
            $scope.collectionTaskVo = data.data;
            $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
            $scope.collectionTaskVo.remark = "";
                console.log(data.data);
            initDetailTable();
        });
    }*/


    /*出租人地址信息*/
    function initDetailTable(){
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'cstm_contact_table',
            dataTableColumn:[
                {title:'申请编号',data:'applyNo'},
                {title:'联系人姓名',data:'name'},
                {title:'联系人关系',data:'relationType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.relation, data);
                    }
                },
                {title:'联系人号码',data:'mobileNo'},
                {title:'地址类型',data:'addrType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.addressType, data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        }
        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    $scope.selectCstmName = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/collection_task/cstm_select_list.html'+getCacheTime(),
            controller: 'cstm_select_list_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.collectionTaskVo.cstmName = data.cstmName;
                $scope.collectionTaskVo.certifNo = data.certifNo;
                $scope.collectionTaskVo.overdueCstmId = data.overdueCstmId;
                $http.post('collection_task/isCollectionTaskExit', $scope.collectionTaskVo).success(function (data) {
                    if (data.code == Response.successCode){
                        $http.get('collection_task/findCstmAddrInfosByOverdueCstmId?overdueCstmId='+ $scope.collectionTaskVo.overdueCstmId).success(function (data) {
                            $scope.cstmContactList = data.data.cstmAddrInfoVoList;
                            initDetailTable();
                        });
                    } else {
                        $scope.collectionTaskVo.cstmName = "";
                        $scope.collectionTaskVo.certifNo = "";
                        $scope.collectionTaskVo.overdueCstmId = "";
                        modalAlert($modal,data.message);
                    }
                });
            }
        },function(){
        });
    };

    /**
     * 上门催收申请提交
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            var applyVisitDate = new Date($scope.collectionTaskVo.applyVisitDate).getTime();
            var nowDate = new Date(getNowDateYYMMDD()).getTime();
            if (applyVisitDate < nowDate){
                modalAlert($modal,"申请上门时间需要大于等于当前日期");
                return ;
            }
            $scope.submit = true;
            $scope.collectionTaskVo.taskId = $location.search()['taskId'];
            $http.post('collection_task/saveCollectionTask', $scope.collectionTaskVo).success(function (data) {
                if (data.code == Response.successCode){
                    if ($location.search()['type'] == 'list'){
                        $location.path('app/postbiz_collection_task_list').search({type:'submit', msg:'上门催收申请成功'});
                    } else if ($location.search()['type'] == 'overdueCstm'){
                        $location.path('app/postbiz_overdue_cstm_modify').search({overdueCstmId:$scope.overdueCstmId,overdueContId:$scope.overdueContId,type:'submit', msg:'上门催收申请成功'});
                    } else {
                        $location.path('app/home');
                    }
                } else {
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        var overdueCstmId = $scope.collectionTaskVo.overdueCstmId;
        if(CommonStringUtils.isTrimBlank(overdueCstmId)){
            modalAlert($modal,'请选择逾期客户');
        } else {
            var id = overdueCstmId;
            var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                + '&detail=true&isTab=true';
            var title = '逾期详情';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }
    };

    function getNowDateYYMMDD(){
        //获取当前时间
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        if (month < 10) {
            month = "0" + month;
        }
        if (day < 10) {
            day = "0" + day;
        }
        var nowDate = year + "-" + month + "-" + day;
        return nowDate;
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        var type = $location.search()['type'];
        if (type == 'list'){
            $location.path('app/postbiz_collection_task_list').search({type:'list'});
        } else if (type == 'overdueCstm'){
            $location.path('app/postbiz_overdue_cstm_modify').search({overdueCstmId:$scope.overdueCstmId,overdueContId:$scope.overdueContId});
        } else {
            $location.path('app/home');
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.collectionTask;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }

}]);


