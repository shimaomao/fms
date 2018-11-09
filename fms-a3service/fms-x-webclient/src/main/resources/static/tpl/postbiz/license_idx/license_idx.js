
/**
 * Created by fangshaofeng on 2018-09-20.
 */

app.controller('license_idx_controller', ['$scope', '$http','$modal','$modalInstance', 'toaster','$compile','setData', 'syspambelongroup', function ($scope, $http,$modal,$modalInstance,toaster,$compile,setData,syspambelongroup) {
    //参数配置
    if(!setData.checkboxOrRadio){
        setData.checkboxOrRadio = CheckBox;
    }
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'license_idx/findLicenseIdxVoBylicenseIdxlist',
            type:"GET",
        },
        //table的html id
        dataTableId:'license_idx_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('licenseIdxId'),
            {
                title: '指标编号',
                data: 'licenseIdxNo',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"directSelect('"+row.licenseIdxNo+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            {title:'指标状态',data:'licenseIdxStatus',width:'20%',render:function(data){
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseIdxStatus,data);
            }},
            {title:'指标失效日',data:'idxInvalidDate',width:'20%'},
            {title:'指标有效天数',data:'idxValidDay',width:'20%'},
            {title:'指标所属分公司',data:'groupName',width:'20%'},
            {title:'指标所属区域',data:'groupDistrict',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: setData.checkboxOrRadio
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.licenseIdxNo = $scope.licenseIdxNo;
        params.syspambelongroup = syspambelongroup;
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchLicenseIdx = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetLicenseIdx = function(){
        $scope.licenseIdxNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        if(status != 'none') {
            var data;
            if(!setData.checkboxOrRadio){
                data = $scope.dataTable.getRows();
            }else{
                data = $scope.dataTable.getRow();
            }
            if(data == null)
                modalAlert($modal,'请选择一个用户');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    };
    $scope.close = function(status){
        $modalInstance.close(status);
    };

    $scope.directSelect = function (groupId) {
        var data = $scope.dataTable.getRow(groupId,'licenseIdxNo');
        $modalInstance.close(data);
    };
}]);