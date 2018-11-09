/**
 * Created by yanfengbo on 2018-05-29.
 */
app.controller('overdue_exempt_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http, $modal, toaster,$location,$compile) {

    $scope.contOverdueOneVo={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.contNo=$location.search()['contNo']
    $scope.serviceId=$location.search()['serviceId']
    $scope.taskId = $location.search()['taskId'];
    var findUrl;
    if (isNotUndefinedNull($scope.contNo)&&!isNotUndefinedNull($scope.serviceId)){
        findUrl = 'overdue_exempt/findDetailBycontNo?contNo='+ $scope.contNo;
    }
    if(!isNotUndefinedNull($scope.contNo)&&isNotUndefinedNull($scope.serviceId)){
        findUrl = 'overdue_exempt/findDetailByServiceId?serviceId='+ $scope.serviceId;
    }
        $http.get(findUrl).success(function(data){
            $scope.overdueExempt = data.data;
            $scope.contOverdueOneVo = $scope.overdueExempt.contOverdueOneVo;
            /*//如果是从流程过来的，则拿到第一次申请所提交的所有逾期罚息明细总条数，为了后面判断退回再提交时所提交的总条数与第一次提交的总条数保持一致
            if(isNotUndefinedNull($scope.serviceId)){
                $scope.maxLength = $scope.overdueExempt.contOverdueVoList.length;
            }*/


            console.log(data);
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'overdueExempt_table',
                //table的列
                dataTableColumn: [
                    /*defaultCheckBox('contOverdueId'),*/
                    {title:'合同编号',data:'contNo',width:'20%'},
                    {title:'期数',data:'period',width:'20%'},
                    {title:'逾期天数',data:'overdueDays',width:'20%'},
                    {title:'还款日',data:'repayDate',width:'20%'},
                    {title:'每期客户租金',data:'eachRent',width:'20%'},
                    {title:'罚息金额',data:'overdueAmount',width:'20%'},
                    {title:'罚息已收金额',data:'receiptAmount',width:'20%'},
                    {title:'已免除罚息金额',data:'exemptAmount',width:'20%'},
                    {title:'罚息剩余金额',data:'restOverdueAmount',width:'20%'},
                    {title:'免除金额',data:'manualExemptAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            return creatInput('manualExemptAmount',meta,data);
                        },
                    },
                ],
                /*dataTableSelectType: CheckBox,*/
                dataTableData: $scope.overdueExempt.contOverdueVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $compile($("#overdueExempt_table"))($scope);
            $scope.callback = function () {
                var tableData = $scope.overdueExempt.contOverdueVoList;
                var eachRentSum=0,overdueAmountSum=0,receiptAmountSum=0,exemptAmountSum=0,restOverdueAmountSum=0,manualExemptAmountSum=0;
                for(var i=0;i<tableData.length;i++){
                    eachRentSum = tableData[i].eachRent*1 + eachRentSum;
                    overdueAmountSum = tableData[i].overdueAmount*1 + overdueAmountSum;
                    receiptAmountSum = tableData[i].receiptAmount*1 + receiptAmountSum;
                    exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;
                    restOverdueAmountSum = tableData[i].restOverdueAmount*1 + restOverdueAmountSum;
                    manualExemptAmountSum = tableData[i].manualExemptAmount*1 + manualExemptAmountSum;
                }
                var html = '<tr id="myHeader" class="header">' +
                    '<th>合计</th>' +
                    '<td colspan="3"></td>' +
                    '<td>'+eachRentSum.toFixed(2)+'</td>' +
                    '<td>'+overdueAmountSum.toFixed(2)+'</td>' +
                    '<td>'+receiptAmountSum.toFixed(2)+'</td>' +
                    '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
                    '<td>'+restOverdueAmountSum.toFixed(2)+'</td>' +
                    '<td>'+manualExemptAmountSum.toFixed(2)+'</td>' +
                    '</tr>';
                /*$('#overdueExempt_table tbody').append(html);*/
                //获取tab
                var  aa = document.getElementById('overdueExempt_table');
                //获取tab中ID=myHeader的tr
                if (document.getElementById('myHeader')) {
                    //有就去更新tr标签
                    var  bb = document.getElementById('myHeader');
                    bb.innerHTML =  html;
                }else {
                    //无则添加标签进去
                    $('#overdueExempt_table tbody').append(html);
                }
            };
            $scope.callback();
        });

    function creatInput(name,meta,data) {
        var html = "";
        data = data*1;
        html += "<input name=\""+name+""+meta.row+"\" type=\"number\" limit-number=\"6\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"="+data+"\" />";
        html += "<span class=\"form-info\" ng-show=\" (form."+name+""+meta.row+".$dirty && form."+name+""+meta.row+".$error.required) || (form."+name+""+meta.row+".$error.required && formValidate)\">不能为空</span>";
        return html;
    }

    $scope.setInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        if(a*1<=nTr[meta].restOverdueAmount){
            nTr[meta][name] = a;
        }else{
            nTr[meta][name] = 0;
            $scope[name+meta] = 0;
            modalAlert($modal,'申请免除金额不能超过罚息剩余金额!');
        }
        $scope.callback();
    };

    /**
     * 罚息免除
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            /*$scope.overdueExempt.contOverdueVoList = $scope.dataTable.getRows();*/
            //申请退回再提交时保持提交条数与初次提交一致
           /* if(isNotUndefinedNull($scope.serviceId)){
                if($scope.overdueExempt.contOverdueVoList.length!=$scope.maxLength){
                    modalAlert($modal,"与初次申请条数不一致,请全部选择再提交！");
                    $scope.submit = false;
                    return;
                }
            }*/
           /* //选择要免除的明细(checkbox),选择一条或多条
            if(!isNotUndefinedNull($scope.overdueExempt.contOverdueVoList) || $scope.overdueExempt.contOverdueVoList.length==0){
                modalAlert($modal,"请先选择并填写明细！");
                $scope.submit = false;
                return;
            }else {
                //免除金额输入框必须输入大于0的值
                for(var i=0;i<$scope.overdueExempt.contOverdueVoList.length;i++){
                    if(!isNotUndefinedNull($scope.overdueExempt.contOverdueVoList[i].manualExemptAmount)||($scope.overdueExempt.contOverdueVoList[i].manualExemptAmount<0)||($scope.overdueExempt.contOverdueVoList[i].manualExemptAmount==0)){
                        modalAlert($modal,"已选中的明细中'免除金额'未正确填写！");
                        $scope.submit = false;
                        return;
                    }
                }
            }*/
           /* //罚息剩余金额小于或等于0时则不进行罚息免除
            for(var i=0;i<$scope.overdueExempt.contOverdueVoList.length;i++){
                if ($scope.overdueExempt.contOverdueVoList[i].restOverdueAmount<0||$scope.overdueExempt.contOverdueVoList[i].restOverdueAmount==0){
                    modalAlert($modal,"罚息剩余金额已不具备免除申请条件！");
                    $scope.submit = false;
                    return;
                }
            }*/
            console.log($scope.overdueExempt);
            //罚息免除
            if (isNotUndefinedNull($scope.serviceId)){
                $scope.overdueExempt.serviceId = $scope.serviceId;
            }
            $scope.overdueExempt.taskId = $scope.taskId;
            $http.post('overdue_exempt/entryOverdueCont', $scope.overdueExempt).success(function (data) {
                if (data.code == Response.successCode&&isUndefinedNull($scope.serviceId)){
                    modalAlert($modal,'免除成功或等待审核');
                    $location.path('app/cost_overdue_exempt_list')
                }else if (data.code == Response.successCode&&!isUndefinedNull($scope.serviceId)){
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                }else {
                    modalAlert($modal,data.message);
                }
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){

        if (isUndefinedNull($scope.serviceId)){
            $location.path("app/cost_overdue_exempt_list");
        }else{
            $location.path('/app/home')
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.overdueExempt;
    $scope.wfLogNo = $scope.serviceId;

}]);


