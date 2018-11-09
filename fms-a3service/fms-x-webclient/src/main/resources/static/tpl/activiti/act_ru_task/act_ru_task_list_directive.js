app.directive('actRuTaskListDirective',function(){
    return {
        restrict: 'E',
        templateUrl: 'tpl/activiti/act_ru_task/act_ru_task_list_directive.html',
        replace : true,
        transclude : true,
        scope:{
            defKey : '=defKey',
            defName : '=defName'
        },
        controller: function($scope, $http, $modal, toaster,$compile,$location,$timeout){

            //参数配置
            $scope.dataTableProperties= {
                //ajax url 和类型
                dataTableAjax : {
                    url : 'act_ru_task/findActRuTaskVosByCandidateOrAssigned',
                    type:"GET",
                },
                //table的html id
                dataTableId:'act_ru_task_table_' + $scope.defKey,
                //table的列
                dataTableColumn: [
                    defaultCheckBox(),
                    {title:'流程名称',data:'title',width:'15%'},
                    {title:'当前环节',data:'name',width:'15%',render: function(data,type,row,meta){
                        var value = data;
                        if(CommonStringUtils.isNotTrimBlank(row['codeName'])){
                            var tmpValue = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,row['codeName']);
                            if(CommonStringUtils.isNotTrimBlank(tmpValue))
                                value = tmpValue;
                        }
                        return "<a class='a1' ng-click='locationPathByRowId(\""+row['id']+"\")'>"+value+"</a>"
                    },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }},
                    {title:'任务业务号',data:'serviceId',width:'15%',render: function(data,type,row,meta){
                        //如果是合同生成或之后节点，显示合同号
                        if(CommonObjectUtils.isNotUndefined(row['serviceParameter']['contractQuantity'])){
                            return row['serviceParameter']['contractQuantity']['contNo'];
                        }
                        return data;

                    }},
                    {title:'任务信息',data:'serviceName',width:'15%'},
                    {title:'任务信息备注',data:'serviceRemark',width:'15%'},
                    {title:'最新操作时间',data:'createTime',width:'15%'}
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: CheckBox
            }

            $scope.name="";

            //请求的参数
            function dataTableParams($scope){
                var params = {};
                params.name = $scope.name;
                params.processDefinitionKey = $scope.defKey;
                return params;
            }

            $scope.searchActReProcdef = function(){
                $scope.dataTable.fnDraw(true);
            }

            $scope.initValue = true;
            $scope.init = function () {
                if($scope.initValue){
                    //创建dataTable
                    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
                    $scope.initValue = false;
                }
            }

            $scope.resetActReProcdef = function(){
                $scope.name="";
                $scope.dataTable.fnDraw(true);//框架内部方法
            }

            $http.get('act_re_procdef/findActReProcdefVosByUserOrGroup').success(function (data) {
                if (data.code == Response.successCode) {
                    $scope.defs = data.data;
                }else {
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
            }).error(function (data) {
                modalAlert($modal, data);
                $scope.submit = false;
            })



            $scope.approvalActRuTask = function(){
                var rows =  $scope.dataTable.getRows('id');//主键
                if(rows.length < 1)
                    modalAlert($modal,'请您选择需要确认的任务');
                else if(rows.length > 1)
                    modalAlert($modal,'只能同时确认一条任务');
                else{
                    locationPath(rows[0]);
                }
            }

            $scope.locationPathByRowId = function(rowId){
                var row = $scope.dataTable.getRow(rowId);
                locationPath(row);
            }

            function locationPath(row){
                var url = CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']].url;
                var type = CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']].type;
                if(CommonObjectUtils.isExist(url) && ( typeof(url) == "object" || CommonStringUtils.isNotTrimBlank(url) )){

                    if(row['processInstanceType'] == CommonCodeUtils.actRuTaskApprovalUrl.contract_generation.name) {
                        var params = {'taskId': row['id'], 'applyNo': row['serviceId'], 'applyType': row['serviceType'] ,'taskDefinitionKey':row['taskDefinitionKey'],'serviceParameter':row['serviceParameter']};
                        if(CommonObjectUtils.isNotUndefined(row['serviceParameter']['contractQuantity'])){
                            params.contNo = row['serviceParameter']['contractQuantity']['contNo'];
                        }
                    } else {
                        var params = {'taskId': row['id'], 'serviceId': row['serviceId'],'taskDefinitionKey':row['taskDefinitionKey'],'serviceParameter':row['serviceParameter']};
                    };

                    console.log(JSON.stringify(params));
                    if(type == CommonCodeUtils.urlType.back){
                        $http.post(url,params).success(function (data) {
                            if (data.code == Response.successCode)
                            // $scope.close(Response.successMark);
                                modalAlert($modal,"确认成功");
                            else
                                modalAlert($modal,data.message);
                        }).error(function(data){
                            modalAlert($modal,data);
                        })
                    }else{
                        // if(row['taskDefinitionKey'] == CommonCodeUtils.actRuTaskApprovalUrl.contract_generation.contract_generation_apply.name) {
                        //     $location.path(CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']].url[row['serviceType']]).search(params);
                        // }

                        if(CommonCodeUtils.yesNoFlag.yes == CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']]['serviceType']){
                            $location.path(CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']].url[row['serviceType']]).search(params);
                        } else {
                            var serviceTypeUrls = CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']]['serviceTypeUrls'];
                            if(CommonObjectUtils.isNotExist(serviceTypeUrls))
                                $location.path(CommonCodeUtils.actRuTaskApprovalUrl[row['processInstanceType']][row['taskDefinitionKey']].url).search(params);
                            else{
                                $location.path(serviceTypeUrls[row['serviceType']]).search(params);
                            }
                        }
                    }
                }else{
                    alert(row['taskDefinitionKey']);
                }

            }

            $scope.exportExcel = function(){
                CommonServiceType.exportExcel(CommonServiceType.serviceTypes.activiti,CommonServiceType.excelTypes.one,
                    'act_ru_task/findActRuTaskVosByCandidateOrAssigned',dataTableParams($scope));
            }


        }

    }
})