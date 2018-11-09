/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_company_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_company/findCstmCompanyByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_company_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('cstmCompanyId'),
            defaultDetail('applyNo','detailCstmCompany','订单编号','20%',$compile,$scope),
            {title:'企业名称',data:'name',width:'20%'},
            {title:'统一社会信用代码',data:'socialCertifNo',width:'20%'},
            {title:'组织机构代码',data:'compOrgNo',width:'20%'},
            {title:'机构信用代码',data:'compCertifNo',width:'20%'},
            {title:'中征码',data:'compEigenNo',width:'20%'},
            {title:'法定代表人',data:'compLegalRep',width:'20%'},
            {title:'法人证件类型',data:'certifType',width:'20%'},
            {title:'法人证件号码',data:'certifNo',width:'20%'},
            {title:'经营地址-省份',data:'compProv',width:'20%'},
            {title:'经营地址-城市',data:'compCity',width:'20%'},
            {title:'经营地址-区县',data:'compCounty',width:'20%'},
            {title:'经营地址-详细地址',data:'compAddr',width:'20%'},
            {title:'注册资金',data:'regCapital',width:'20%'},
            {title:'企业联系电话',data:'compTel',width:'20%'},
            {title:'企业性质',data:'compType',width:'20%'},
            {title:'成立年限',data:'establYear',width:'20%'},
            {title:'实际用车人',data:'driver',width:'20%'},
            {title:'实际用车人手机号码',data:'driverMobno',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.name = $scope.name;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCstmCompany = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmCompany = function(){
        $scope.applyNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmCompany = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_company/cstm_company_save.html'+getCacheTime(),
            controller: 'cstm_company_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加prebiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyCstmCompany = function(cstmCompanyId){
        var rowsIds =  $scope.dataTable.getRowsIds('cstmCompanyId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_company/cstm_company_modify.html'+getCacheTime(),
                controller: 'cstm_company_modify_controller',
                resolve:{
                    cstmCompanyId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑prebiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailCstmCompany = function(cstmCompanyId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_company/cstm_company_detail.html'+getCacheTime(),
            controller: 'cstm_company_detail_controller',
            resolve:{
                cstmCompany : function (){ return $scope.dataTable.getRow(cstmCompanyId,'cstmCompanyId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmCompany = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('cstmCompanyId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_company/deleteCstmCompanyByCstmCompanyIds',getDeleteData(rowsIds)).success(function (data) {
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