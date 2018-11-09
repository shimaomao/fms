/**
 * Created by qiaohao on 2018/2/1.
 */
app.controller('act_ru_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'act_ru_task/findActRuTaskVosByCandidateOrAssigned',
            type:"GET",
        },
        //table的html id
        dataTableId:'act_ru_task_table',
        //table的列
        dataTableColumn: [
            /*defaultCheckBox(),*/
            {title:'流程名称',data:'title',width:'15%',sClass:'left'},
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
            {title:'提交人',data:'superiorTaskUser',width:'15%'},
            {title:'任务发起人',data:'startUserName',width:'15%'},
            {title:'任务信息',data:'serviceName',width:'15%'},
            {title:'任务信息备注',data:'serviceRemark',width:'15%'},
            {title:'创建时间',data:'createTime',width:'15%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox,
        scrollY: '150px',
    };

    $scope.name="";

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        /*params.name = $scope.name;
        params.processDefinitionKey = $scope.processDefinitionKey;*/
        setData.setter($scope.params);
        return params;
    }

    $scope.initDataTable = function(){
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.recordsFiltered = 0;
    $scope.nodeId = null;
    $scope.nodeTxt = '';

    $scope.callback = function (data) {
        if(CommonObjectUtils.isExist($scope.nodeId) && CommonObjectUtils.isExist(data) && CommonStringUtils.isNotTrimBlank($scope.nodeTxt)) {
            $scope.recordsFiltered = data.recordsFiltered;
            var txt = $scope.nodeTxt.substring(0, $scope.nodeTxt.indexOf('【')) + "【" + $scope.recordsFiltered + "】";
            var html = $("#task_tree li[data-nodeid='" + $scope.nodeId + "']").html();
            html = html.replace($scope.nodeTxt, txt);
            $("#task_tree li[data-nodeid='" + $scope.nodeId + "']").html(html);
        }
    };


    $scope.searchActReProcdef = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetActReProcdef = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);
    };

    $http.get('act_re_procdef/findProcdefTree').success(function (data) {
        if (data.code == Response.successCode) {
            //确定激活节点
            if($scope.params.nodeId == 0 || $scope.params.nodeId == undefined){
                data.data[0]['state'] = {selected:true};
            }else{
                var length = data.data[0].nodes.length;
                for(var i=0;i<length;i++){
                    if(data.data[0].nodes[i].id == $scope.params.processDefinitionKey){
                        data.data[0].nodes[i]['state'] = {selected:true};
                        break;
                    }
                }
            }
            //创建table
            if($scope.dataTable){
                $scope.searchActReProcdef();
            }else{
                $scope.initDataTable();
            }
            //初始化treeview
            $('#task_tree').treeview({
                data: data.data,
                emptyIcon: 'glyphicon glyphicon-minus',
                onNodeSelected: function (event, data) {
                    $scope.processDefinitionKey = data.id;
                    $scope.nodeId =  data.nodeId;
                    $scope.nodeTxt = data.text;

                    $scope.params.processDefinitionKey = data.id;
                    $scope.params.nodeId =  data.nodeId;
                    $scope.params.nodeTxt = data.text;
                    $scope.searchActReProcdef();
                }
            });
        }else {
            modalAlert($modal, data.message);
            $scope.submit = false;
        }
    }).error(function (data) {
        modalAlert($modal, data);
        $scope.submit = false;
    });

    $scope.approvalActRuTask = function(){
        var rows =  $scope.dataTable.getRows('id');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要确认的任务');
        else if(rows.length > 1)
            modalAlert($modal,'只能同时确认一条任务');
        else{
            locationPath(rows[0]);
        }
    };

    $scope.locationPathByRowId = function(rowId){
        var row = $scope.dataTable.getRow(rowId);
        locationPath(row);
    };

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
                var params = {'taskId': row['id'],'serviceType': row['serviceType'], 'serviceId': row['serviceId'],'taskDefinitionKey':row['taskDefinitionKey'],'serviceParameter':row['serviceParameter'],'processInstanceType':row['processInstanceType']};
            }

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


}])
;