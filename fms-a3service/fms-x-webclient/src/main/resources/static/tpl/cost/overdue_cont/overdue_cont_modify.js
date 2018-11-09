/**
 * Created by yanfengbo on 2018-05-29.
 */
app.controller('overdue_cont_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http, $modal, toaster,$location,$compile) {

    $scope.overdueCont={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.contNo=$location.search()['contNo']
    $scope.serviceId=$location.search()['serviceId']
    var findUrl;
    if (isNotUndefinedNull($scope.contNo)&&!isNotUndefinedNull($scope.serviceId)){
        findUrl = 'overdue_cont/findOverdueContBycontNo?contNo='+ $scope.contNo;
    }
    if(!isNotUndefinedNull($scope.contNo)&&isNotUndefinedNull($scope.serviceId)){
        findUrl = 'overdue_cont/findOverdueContByServiceId?serviceId='+ $scope.serviceId;
    }
        $http.get(findUrl).success(function(data){
            $scope.overdueCont = data.data;
            console.log(data);
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'overdueCont_table',
                //table的列
                dataTableColumn: [
                    defaultCheckBox('contOverdueId'),
                    {title:'合同编号',data:'contNo',width:'20%'},
                    {title:'期数',data:'period',width:'20%'},
                    {title:'逾期天数',data:'overdueDays',width:'20%'},
                    {title:'罚息金额',data:'overdueAmount',width:'20%'},
                    {title:'罚息已收金额',data:'receiptAmount',width:'20%'},
                    {title:'以免除罚息金额',data:'exemptAmount',width:'20%'},
                    {title:'罚息剩余金额',data:'restOverdueAmount',width:'20%'},
                    {title:'免除金额',data:'manualExemptAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            return creatInput('manualExemptAmount',meta,data);
                        },
                    },
                ],
                dataTableSelectType: CheckBox,
                dataTableData: $scope.overdueCont.contOverdueVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $compile($("#overdueCont_table"))($scope);
        });



    function creatInput(name,meta,data) {
        var html = "";
        data = data*1;
        html += "<input name=\""+name+""+meta.row+"\" type=\"number\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"="+data+"\" />";
        html += "<span class=\"form-info\" ng-show=\" (form."+name+""+meta.row+".$dirty && form."+name+""+meta.row+".$error.required) || (form."+name+""+meta.row+".$error.required && formValidate)\">不能为空</span>";
        return html;
    }

    $scope.setInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
    };

    /**
     * 罚息免除
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.overdueCont.contOverdueVoList = $scope.dataTable.getRows();
            //alert($scope.overdueCont.contOverdueVoList)
            if(!isNotUndefinedNull($scope.overdueCont.contOverdueVoList) || $scope.overdueCont.contOverdueVoList.length==0){
                modalAlert($modal,"请先选择并填写明细！");
                return;
            }else {
                for(var i=0;i<$scope.overdueCont.contOverdueVoList.length;i++){
                    //alert($scope.overdueCont.contOverdueVoList[i].manualExemptAmount)
                    if(!isNotUndefinedNull($scope.overdueCont.contOverdueVoList[i].manualExemptAmount)){
                        modalAlert($modal,"已选中的明细中'免除金额'未正确填写！");
                        return;
                    }
                }
            }

            console.log($scope.overdueCont);
            //罚息免除
            alert($scope.serviceId)
            if (isNotUndefinedNull($scope.serviceId)){
                alert($scope.serviceId)
                $scope.overdueCont.serviceId = $scope.serviceId;
            }
            $http.post('overdue_cont/entryOverdueCont', $scope.overdueCont).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,'免除成功或等待审核');
                    $location.path('app/cost_overdue_cont_list')
                }
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/cost_overdue_cont_list");
    };

}]);


