/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_company_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'crm_company/findCrmCompanysByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'crm_company_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('companyId'),
            defaultDetail('name','detailCrmCompany','企业名称','20%',$compile,$scope),
            {title:'统一社会信用代码',data:'socialCertifNo',width:'20%'},
            {title:'法定代表人',data:'compLegalRep',width:'20%'},
            {title:'法人证件类型',data:'certifType',width:'20%'},
            {title:'法人证件号码',data:'certifNo',width:'20%'},
            {title:'法人手机号码',data:'mobileNo',width:'20%'},
            {title:'经营省份',data:'compProv',width:'20%'},
            {title:'经营城市',data:'compCity',width:'20%'},
            {title:'经营区县',data:'compCounty',width:'20%'},
            {title:'经营详细地址',data:'compAddr',width:'20%'},
            {title:'注册资金',data:'regCapital',width:'20%'},
            {title:'企业联系电话',data:'compTel',width:'20%'},
            {title:'企业性质',data:'compType',width:'20%'},
            {title:'成立年限',data:'establYear',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.name = $scope.name;
        params.socialCertifNo = $scope.socialCertifNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCrmCompany = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCrmCompany = function(){
        $scope.name = "";
        $scope.socialCertifNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCrmCompany = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/crm_company/crm_company_save.html'+getCacheTime(),
            controller: 'crm_company_save_controller',
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

    $scope.modifyCrmCompany = function(companyId){
        var rowsIds =  $scope.dataTable.getRowsIds('companyId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/crm_company/crm_company_modify.html'+getCacheTime(),
                controller: 'crm_company_modify_controller',
                resolve:{
                    companyId : function (){ return rowsIds[0] }
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


    $scope.detailCrmCompany = function(companyId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/crm_company/crm_company_detail.html'+getCacheTime(),
            controller: 'crm_company_detail_controller',
            resolve:{
                crmCompany : function (){ return $scope.dataTable.getRow(companyId,'companyId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCrmCompany = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('companyId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('crm_company/deleteCrmCompanysByCompanyIds',getDeleteData(rowsIds)).success(function (data) {
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