/**
 * Created by qiaomengnan on 2018-05-30.
 */
app.controller('equ_mor_apply_input_controller', ['$scope', '$http','toaster','$location','$modal','$rootScope','$compile','setData', function ($scope, $http,toaster,$location,$modal,$rootScope,$compile,setData) {

    //查询参数
    $scope.params = setData.getter();
    $scope.equMorApplyVo = {contNos : []};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.managementList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.management);
    $scope.mortgageProcessList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageProcess);


    //判断是否从工作流传入
    $scope.taskId = $location.search()['taskId'];
    $scope.equMorTaskNo = $location.search()['serviceId'];

    $scope.applyDataTableFunction = function () {
        //参数配置
        $scope.applyDataTableProperties= {
            //table的html id
            dataTableId:'equ_mor_charge_apply_input_table',
            dataTableData: $scope.applyData,
            //table的列
            dataTableColumn: [
                {title:'序号',data:'index',width:'10%'},
                {title:'品牌',data:'vehBrandCodeName',width:'10%'},
                {title:'业务类型',data:'licenseAttr',width:'10%',render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }},
                {title:'出租人',data:'belongGroupName',width:'10%'},
                {title:'客户姓名',data:'lessee',width:'10%'},
                {title:'合同号',data:'contNo',width:'10%'},
                {title:'车架号',data:'vinNo',width:'10%'},
                {title:'融资金额',data:'finTotal',width:'10%'},
                {title:'融资期限',data:'finPeriodType',width:'10%'},
                {title:'放款日期',data:'contractValidDate',width:'10%'},
                {title:'租金',data:'rent',width:'10%'},
                {title:'剩余期数',data:'surplusPeriod',width:'10%'},
                {title:'剩余租金',data:'surplusRent',width:'10%'},
                {title:'操作',data:'index',width:'20%',
                    render: function (data, type, row, meta) {
                        var html = '<a style="color:#2dc9ff" ng-click="del('+'\''+data+'\''+')"></i>删除</a>'
                            + '&nbsp<a style="color:#2dc9ff" ng-click="Detail('+'\''+data+'\''+')"></i>查看归档资料</a>';
                        return html;
                    },
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                        $compile(nTd)($scope);
                    }
                },
            ]
        }
    }
    $scope.callback = function () {
        var tableData = $scope.applyData;
        var finTotalSum = 0,rentSum=0,surplusRentSum=0;
        for(var i=0;i<tableData.length;i++){
            finTotalSum = tableData[i].finTotal*1 + finTotalSum;
            rentSum = tableData[i].rent*1 + rentSum;
            surplusRentSum = tableData[i].surplusRent*1 + surplusRentSum;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="6"></td>' +
            '<td>'+finTotalSum.toFixed(2)+'</td>' +
            '<td colspan="2"></td>' +
            '<td>'+rentSum.toFixed(2)+'</td>' +
            '<td colspan="1"></td>' +
            '<td>'+surplusRentSum.toFixed(2)+'</td>' +
            '<td colspan="2"></td>' +
            '</tr>';
        $('#equ_mor_charge_apply_input_table tbody').append(html);
    };
    /*$scope.callback();*/


    if(CommonObjectUtils.isExist($scope.taskId)){
        //工作流退回,查询详情
        $http.get('equ_mor_apply/findEquMorTaskVoByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.equMorApplyVo = data.data;
                $scope.equMorApplyVo.contNos = [];
                $scope.applyData = data.data.equMorApplyVos;
                //拿到全部的合同号
                for(var i in $scope.applyData){
                    $scope.equMorApplyVo.contNos.push($scope.applyData[i]['contNo']);
                }
                setIndex($scope.applyData);
                $scope.applyDataTableFunction();
                $scope.applyDataTableProperties.dataTableData = $scope.applyData;
                CommonDataTableUtils.createDataTableForData($scope.applyDataTableProperties);
                $scope.callback();
            }
            else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
        })
    }else{
        $scope.applyData = JSON.parse($location.search()['applyData']);
        setIndex($scope.applyData);
        //拿到全部的合同号
        for(var i in $scope.applyData){
            $scope.equMorApplyVo.contNos.push($scope.applyData[i]['contNo']);
        }
        $scope.applyDataTableFunction();
        CommonDataTableUtils.createDataTableForData($scope.applyDataTableProperties);
        $scope.callback();
    }

    /**
     * 保存
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            var check = true;
            if($scope.equMorApplyVo.contNos.length < 1){
                modalAlert($modal,"请选择需要申请的合同");
                check = false;
            }

            if(check) {
                var url = 'equ_mor_apply/saveEquMorOtherApply';
                if(CommonObjectUtils.isExist($scope.taskId)) {
                    $scope.equMorApplyVo.taskId = $location.search()['taskId'];
                    $scope.equMorApplyVo.taskDefinitionKey = $location.search()['taskDefinitionKey']
                    url = 'equ_mor_apply/modifyEquMorOtherApply';
                }
                $http.post(url, $scope.equMorApplyVo).success(function (data) {
                    if (data.code == Response.successCode) {
                        if(CommonObjectUtils.isExist($scope.taskId)){
                            $location.path("/app/home").search({type:'homeToastInfo', msg:'申请成功'});
                        }else{
                            $location.path("app/asset_equ_mor_apply_list").search({msg:'申请成功'});
                        }
                    } else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })
            }else{
                $scope.submit = false;
            }

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    //返回到主页
    $scope.goBack = function () {
        if(CommonObjectUtils.isExist($scope.taskId)){
            $location.path('app/home');
        }else{
            $location.path("app/asset_equ_mor_apply_list");
        }
    }


    $scope.download = function() {
        if($scope.equMorApplyVo.contNos.length < 1){
            modalAlert($modal,"请选择需要申请的合同");
        }else{
            var str = "";
            for(var i in $scope.equMorApplyVo.contNos){
                str += "contNos=" + $scope.equMorApplyVo.contNos[i] + "&";
            }
            if(str != "")
                str = str.substring(0,str.length - 1);
            CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,'equ_mor_apply/exportEquMorApplyVos?'+str);
        }
    }


    //取消
    $scope.cancel = function(){
        $scope.equMorApplyVo.taskId = $location.search()['taskId'];
        $scope.equMorApplyVo.taskDefinitionKey = $location.search()['taskDefinitionKey'];
        $scope.equMorApplyVo.serviceId = $location.search()['serviceId'];

        $scope.submit = true;
        $http.post('equ_mor_apply/equMorApplyCancel', $scope.equMorApplyVo).success(function (data) {
            if (data.code == Response.successCode) {
                $location.path("/app/home").search({type:'homeToastInfo', msg:'取消成功'});
            } else {
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //选择合同
    $scope.selectContract = function(a){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/contract/contract_list_select.html?datetime='+getTimestamp(),
            controller: 'contract_select_controller',
            resolve:{
                selectData: function () {
                    return {}
                }
            }
        });
        rtn.result.then(function (rows) {
            console.log(rows)
            if(rows != null && rows.length>=0) {
                rows.forEach(function(row,index){
                    var data = row;
                    data.lessee = row.name;
                    data.belongGroupName = row.groupName;
                    //重新拿到全部的合同号
                    if($.inArray(row.contNo, $scope.equMorApplyVo.contNos) == -1){
                        $scope.equMorApplyVo.contNos.push(row.contNo);
                        $scope.applyData.push(data);
                    }
                });
                //重新设置序号
                setIndex($scope.applyData);
                $scope.applyDataTableProperties.dataTableData = $scope.applyData;
                CommonDataTableUtils.createDataTableForData($scope.applyDataTableProperties);
                $scope.callback();
            }
        },function(){
        });
    }

    //重新设置序号
    function setIndex(data){
        for(var i = 0;i < data.length;i++){
            data[i].index = i+1;
        }
    }

    //删除已选择的合同
    $scope.del = function(index){
        $scope.applyData.splice(index-1,1);
        //重新拿到全部的合同号
        $scope.equMorApplyVo.contNos = [];
        for(var i in $scope.applyData){
            $scope.equMorApplyVo.contNos.push($scope.applyData[i]['contNo']);
        }
        setIndex($scope.applyData);
        $scope.applyDataTableProperties.dataTableData = $scope.applyData;
        CommonDataTableUtils.createDataTableForData($scope.applyDataTableProperties);
        $scope.callback();
    }

    //查看明细
    $scope.Detail = function (index) {
        var id = $scope.applyData[index-1]['contNo'];

        var url = 'app.orig_file_sort?bizCode=' + $scope.applyData[index-1]['contNo']
            + '&detail=true&bizCodeType=0&equMorOtherApplyInput=true'
            +"&taskId=" + $location.search()['taskId']
            +"&serviceId=" + $location.search()['serviceId'];
        var title = '归档资料';
        var html = "<a data-id=\""+id+"\"  data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    };

}]);


