app.controller('cont_backinput_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location, $timeout) {
    var filBackfillId = $location.search()["filBackfillId"];
    $scope.isDetail = $location.search()["isDetail"];
    $scope.type = $location.search()["type"];
    console.log(filBackfillId);
    $http.get('fin_backfill/findFinBackfillByFilBackfillId?filBackfillId='+filBackfillId).success(function (data) {
        console.log(data);
        if(data.code == Response.successCode){
            $scope.finBackData = data.data;
            $scope.finBackData.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.finBackData.licenseAttr);
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'backinput_table',
                //table的列
                dataTableColumn: [
                    {title:'序号',data:'finItemName',width:'5%',
                        render: function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {title:'融资项目名称',data:'finItemName',width:'20%'},
                    {title:'融资项目年限',data:'finItemYear',width:'20%'},
                    {title:'融资费用金额',data:'finAmount',width:'20%'},
                    {title:'实际发票金额',data:'actualFinAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            if(!data){
                                data = 0
                            }
                            return creatInput('actualFinAmount',meta,data, row);
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'实际成本金额',data:'actualCostAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            if(!data){
                                data = 0
                            }
                            return creatInput('actualCostAmount',meta,data,row);
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'实际税金金额',data:'actualTaxAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            if(!data){
                                data = 0
                            }
                            return creatInput('actualTaxAmount',meta,data,row);
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                ],
                dataTableData: data.data.finBackfillDetailVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $scope.callback();
        }else{
            modalAlert($modal,data.message);
        }


    }).error(function (err) {
        modalAlert($modal,err);
    });

    $scope.callback = function () {
        //var data = $scope.dataTable;
        var tableData = $scope.finBackData.finBackfillDetailVoList;
        var /*chargeSum=0,*/finAmountSum=0,actualFinAmountSum=0,actualCostAmountSum=0,actualTaxAmountSum=0;
        for(var i=0;i<tableData.length;i++){
            finAmountSum = tableData[i].finAmount*1 + finAmountSum;
            actualFinAmountSum = tableData[i].actualFinAmount*1 + actualFinAmountSum;
            actualCostAmountSum = tableData[i].actualCostAmount*1 + actualCostAmountSum;
            actualTaxAmountSum = tableData[i].actualTaxAmount*1 + actualTaxAmountSum;
        }
        var html = '<tr id="myHeader" class="header">' +
            '<th >合计</th>' +
            '<td colspan="2"></td>' +
            '<td>'+finAmountSum.toFixed(2)+'</td>' +
            '<td>'+actualFinAmountSum.toFixed(2)+'</td>' +
            '<td>'+actualCostAmountSum.toFixed(2)+'</td>' +
            '<td>'+actualTaxAmountSum.toFixed(2)+'</td>' +
            '</tr>';
        //获取tab
        var  aa = document.getElementById('backinput_table');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('myHeader')) {
            //有就去更新tr标签
            var  bb = document.getElementById('myHeader');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#backinput_table tbody').append(html);
        }
    };

    $scope.setInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        var total = 0;
        nTr[meta][name] = a;
        for(var i=0;i<nTr.length;i++){
            if(nTr[i].actualCostAmount && nTr[i].actualCostAmount!= null){
                if( nTr[i].showDetail != CommonCodeUtils.yesNoFlag.yes)
                    total+=nTr[i].actualCostAmount*1;
            }
        }
        $scope.finBackData.investTotal = total.toFixed(2);
        $scope.finBackData.finTotal = (total - $scope.finBackData.initAmount).toFixed(2);
    };



    //暂存
    $scope.save = function () {
        var nTr = $scope.dataTable.fnGetData();
        var params = $scope.finBackData;
        params.finBackfillDetailVoList = nTr ;
        params.flag = CommonCodeUtils.yesNoFlag.yes
        $http.post('fin_backfill/finBackfill',params).success(function (data) {
            if(data.code == Response.successCode){
                $location.path('/app/prebiz_cont_backfill').search({ "msg":'暂存成功'});
            }else {
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    //回填
    $scope.saveInput = function () {
        var nTr = $scope.dataTable.fnGetData();
        var params = $scope.finBackData;
        params.finBackfillDetailVoList = nTr ;
        params.flag = CommonCodeUtils.yesNoFlag.no
        $http.post('fin_backfill/finBackfill',params).success(function (data) {
            if(data.code == Response.successCode){
                $location.path('/app/prebiz_cont_backfill').search({"msg":'财务回填成功'});
            }else {
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    $scope.getSum = function(a,meta,name){

        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
        var total = 0;
        var name1 = 'actualFinAmount_' + meta;
        var name2 = 'actualCostAmount_' + meta;
        var name3 = 'actualTaxAmount_' + meta;
        if("actualFinAmount" == name){
            $scope[name2] = ($scope[name1] / (1 + nTr[meta].finTax/100)).toFixed(2);
            $scope[name3] = ($scope[name1] - $scope[name2]).toFixed(2);
            nTr[meta]['actualCostAmount'] = $scope[name2]*1;
            nTr[meta]['actualTaxAmount'] = $scope[name3]*1;
        }else{
            $scope[name1] = ($scope[name2]*1 + $scope[name3]*1).toFixed(2);
            nTr[meta]['actualFinAmount'] = $scope[name1]*1;
        }


        /*var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
        var total = 0;
        var name1 = 'actualFinAmount_' + meta;
        var name2 = 'actualCostAmount_' + meta;
        var name3 = 'actualTaxAmount_' + meta;

        $scope[name2] = ($scope[name1] / (1 + nTr[meta].finTax/100)).toFixed(2);
        $scope[name3] = ($scope[name1] - $scope[name2]).toFixed(2);
        nTr[meta]['actualCostAmount'] = $scope[name2]*1;
        nTr[meta]['actualTaxAmount'] = $scope[name3]*1;*/
        for(var i=0;i<nTr.length;i++){
            if(nTr[i].actualCostAmount && nTr[i].actualCostAmount!= null){
                if( nTr[i].showDetail != CommonCodeUtils.yesNoFlag.yes)
                    total+=nTr[i].actualCostAmount*1;
            }
        }
        $scope.finBackData.investTotal = total.toFixed(2);
        $scope.finBackData.finTotal = (total - $scope.finBackData.initAmount).toFixed(2);
        $scope.callback();
    }

    //返回
    $scope.goBack = function () {
        $location.path('/app/prebiz_cont_backfill').search({"filBackfillId": null});
    };

    function creatInput(name,meta,data,row) {

        if (name == 'actualFinAmount'){
            if ($scope.type == 'renewal' && row.finItemYear <= 1){
                return "<input class=\"form-control\" ng-model=\"" + name + "_" + meta.row + "\"  ng-change=\"getSum(actualFinAmount_" + meta.row + "," + meta.row + ",'actualFinAmount')\"  ng-blur=\"setInputVal(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "');\" ng-init=\"" + name + "_" + meta.row + "='" + data + "'\" disabled/>";
            } else {
                return "<input class=\"form-control\" ng-model=\"" + name + "_" + meta.row + "\"  ng-change=\"getSum(actualFinAmount_" + meta.row + "," + meta.row + ",'actualFinAmount')\"  ng-blur=\"setInputVal(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "');\" ng-init=\"" + name + "_" + meta.row + "='" + data + "'\" ng-disabled=\"isDetail\"/>";
            }
        } else {
            if ($scope.type == 'renewal' && row.finItemYear <= 1){
                return "<input class=\"form-control\" ng-model=\"" + name + "_" + meta.row + "\" ng-change=\"getSum(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "')\"  ng-blur=\"setInputVal(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "');\" ng-init=\"" + name + "_" + meta.row + "='" + data + "'\" disabled/>";
            } else {
                return "<input class=\"form-control\" ng-model=\"" + name + "_" + meta.row + "\" ng-change=\"getSum(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "')\"  ng-blur=\"setInputVal(" + name + "_" + meta.row + "," + meta.row + ",'" + name + "');\" ng-init=\"" + name + "_" + meta.row + "='" + data + "'\" ng-disabled=\"isDetail\" />";
            }
        }

    }
    //当前销售未还本金
    $scope.overdueSales = function (num) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
            controller: 'overdue_sales_controller',
            resolve:{
                paramsData: function () {
                    return {
                        "contNo": num
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };

    //当前财务未还本金
    $scope.overdueFinance = function (num,type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_finance.html'+getCacheTime(),
            controller: 'overdue_finance_controller',
            resolve:{
                paramsData: function () {
                    return {
                        "contNo": num
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };
}])
;
