/**
 * Created by yanfengbo on 2018-03-19.
 */
app.controller('bas_file_type_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {
    //是否实际文件
    $scope.actualFileList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.actualFile);
    //是否必填
    $scope.requiredStateList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.requiredState);

    $scope.basFileType={};

    $scope.formValidate = false;

    $scope.submit = false;


    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;
    $scope.chiBasFiles=[];


    initTable();
    //初始化下级附件类型table
    function initTable(){
        // var tableData =[];
        // if($scope.rolenames.length>0){
        //     for(var i in  $scope.rolenames){
        //         var node = [$scope.rolenames[i].role,$scope.rolenames[i].roleName,$scope.rolenames[i].role]
        //         tableData.push(node)
        //     }
        // }
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'file_type_table',
            //table的列
            dataTableColumn: [
                {data : "fileType", title:'附件代码', class:'center'},
                { data : "fileTypeName",title:'附件名称', class:'center'},
                {data : "fileType",title:'操作', "render":function(data, type,row){
                    var html = '<a style="color:#2dc9ff"  ng-click="alt('+'\''+data+'\''+')"></i>删除</a>';
                    return html;},
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {$compile(nTd)($scope);}}
            ],
            dataTableData: $scope.chiBasFiles
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }
    $scope.alt = function(data) {
        for(var i in $scope.chiBasFiles){
            if($scope.chiBasFiles[i].fileType==data)
                $scope.chiBasFiles.splice(i,1)
        }
        initTable();
    }


    //选择下级附件类型代码
    $scope.selectParentFileType = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_file_type_list_select_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": CheckBox
                    };
                }
            }
        })

        rtn.result.then(function (data) {
            if(data != null) {
                // $scope.basFileType.parentFileType = data[0].fileType;
                // $scope.basFileType.parentFileTypeName = data[0].fileTypeName;
                //console.log($scope.basFileType.parentFileType)
                /* $scope.fileTypeName = data.fileTypeName;*/
                for( var i in data ){
                    if($scope.chiBasFiles.length>0){
                        for(var j in $scope.chiBasFiles){
                            if($scope.chiBasFiles[j].fileType==data[i].fileType)
                                break;
                            else if(j == $scope.chiBasFiles.length-1){
                                $scope.chiBasFiles.push(data[i]);
                            }
                        }
                    }else{
                        $scope.chiBasFiles.push(data[i]);
                    }
                }
                initTable();
            }
        },function(){

        });

    }


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.basFileType.chiBasFiles = $scope.chiBasFiles;
            $http.post('bas_file_type/saveBasFileType', $scope.basFileType).success(function (data) {
                if (data.code == Response.successCode){
                    //toaster_success('添加成功',toaster);
                    $location.path("app/baseinfo_bas_file_type_list").search({messageType:'saveBasFileType'});
                }

                else{
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
    };
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_file_type_list");
    };
}]);


