 /**
 * Created by lijunjun on 2018-04-28.
 */
app.controller('postbiz_pers_basic_hi_change_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage', 'applyNo', '$modalInstance', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage, applyNo, $modalInstance) {

    $scope.applyNo = applyNo;
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'basic_change_task/findBasicPersChangeHistory',
            type: "GET",
        },
        //table的html id
        dataTableId: 'basic_change_pers_table',
        //table的列
        dataTableColumn: [
            {title: '任务号', data: 'taskNo', width: '10%'},
            {title: '任务状态', data: 'basicTaskStatus', width: '10%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }},
            {title: '变更发起人', data: 'submitUser', width: '10%'},
            {title: '变更发起时间', data: 'submitDate', width: '10%'},
            {title: '备注', data: 'remark', width: '10%'},
            {title: '变更后承租人', data: 'name', width: '10%'},
            {title: '变更后手机号码', data: 'mobileNo', width: '10%'},
            {title: '变更后居住省份', data: 'resideProv', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后居住城市', data: 'resideCity', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后居住区县', data: 'resideCounty', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后居住详细地址', data: 'resideAddr', width: '10%'},
            {title: '变更后联系人', data: 'contacts', width: '10%'},
            {title: '变更前承租人', data: 'nameOld', width: '10%'},
            {title: '变更前手机号码', data: 'mobileNoOld', width: '10%'},
            {title: '变更前居住省份', data: 'resideProvOld', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更前居住城市', data: 'resideCityOld', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更前居住区县', data: 'resideCountyOld', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更前居住详细地址', data: 'resideAddrOld', width: '10%'},
            {title: '变更前联系人', data: 'contactsOld', width: '10%'},
        ]
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        return params;
    }

    $scope.init = function () {
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);
    }

    $scope.close = function(){
        $modalInstance.close();
    };

}])
;