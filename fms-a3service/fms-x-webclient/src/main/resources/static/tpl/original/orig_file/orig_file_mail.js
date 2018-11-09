app.controller('orig_file_mail_controller', ['$scope', '$http','$modal','$compile','$location','toaster', function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.origFileMailVo = {};
    $scope.origFileVo = {};
    $scope.submit = false;
    $scope.formValidate = false;
    $scope.origFileMailVo.bizCode = $location.search()['bizCode'];
    $scope.origFileMailVo.bizCodeType = $location.search()['bizCodeType'];

    $http.get('orig_file/findOrigFileInfoByBizCodeAndBizCodeType?bizCode='+$scope.origFileMailVo.bizCode+'&bizCodeType='+$scope.origFileMailVo.bizCodeType).success(function (data) {
        $scope.origFileVo = data.data;
    });

    $http.get('orig_file/findOrigFileMailList?bizCode='+$location.search()['bizCode']+"&bizCodeType="+$location.search()['bizCodeType']).success(function (data) {
        if(data.code == Response.successCode){
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'orig_file_borrow_mail_table',
                //table的列
                dataTableColumn: [
                    {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                        data:'bizCode',
                        width:'3%',
                        render: function(data,type,row,meta){
                            var dataName = replaceIdData('bizCode');
                            var dataCheckBoxName = replaceIdData('ids','');
                            return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'"><i></i></label>'
                        }
                    },
                    {title:'合同号',data:'bizCode',width:'20%'},
                    // {title:'业务类型',data:'bizCodeType',width:'20%',
                    //     render: function (data, type, row, meta) {
                    //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
                    //     }
                    // },
                    {title:'附件类型',data:'fileTypeName',width:'20%'},
                    // {title:'归档编号',data:'fileRecordNo',width:'20%'},
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                        }
                    },
                    {title:'是否需要归档',data:'origFlag',width:'20%',
                        render:function (data,type,row,meta) {
                            var html = "";
                            html+="<div class=\"radio\" ng-repeat=\"a in 'origFlag' | getList\">";
                            html+="<label><input type=\"radio\" ng-value=\"a.codeValue\" ng-model=\"$parent.origFlagMode"+meta.row+"\" ng-change=\"changeValue("+meta.row+")\" ng-init=\"$parent.origFlagMode"+meta.row+"="+data+"\" disabled>{{a.codeValueName}}</label>";
                            html+="</div>";
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'快递公司',data:'postComp',width:'20%'},
                    {title:'快递编号',data:'postNo',width:'20%'},
                    {title:'邮寄日期',data:'postDate',width:'20%'},
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: CheckBox,
                dataTableData: data.data
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
        }else {
            modalAlert($modal, data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //资料邮寄
    $scope.mailConfirm = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            var rows = $scope.dataTable.getRows();
            if (rows.length < 1){
                modalAlert($modal, "请至少选择一条数据")
            } else {
                $scope.origFileMailVo.origFileDetailVoList = rows;
                $scope.origFileMailVo.bizCode = $location.search()['bizCode'];
                $scope.origFileMailVo.bizCodeType = $location.search()['bizCodeType'];
                $http.post('orig_file/mailConfirm',$scope.origFileMailVo).success(function (data) {
                    if(data.code == Response.successCode){
                        $location.path("app/orig_file_archive_list").search({"type": 'submit', "msg":'资料邮寄成功'});
                    }else {
                        modalAlert($modal, data.message);
                    }
                    $scope.submit = false;
                }).error(function (err) {
                    modalAlert($modal,err);
                });
            }
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //提交
    $scope.submitOrigFileBorrow = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('orig_file_detail/borrowTaskMail',$scope.borrowTaskVo).success(function (data) {
                if(data.code == Response.successCode){
                    $location.path("app/home").search({"type": 'homeToastInfo', "msg":'资管邮寄提交成功'});
                }else {
                    modalAlert($modal, data.message);
                }
                $scope.submit = false;
            }).error(function (err) {
                modalAlert($modal,err);
            });
        } else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //返回
    $scope.backUp= function () {
        $location.path('app/orig_file_archive_list');
    };

}]);


