/**
 * Created by yanfengbo on 2018-03-19.
 */
app.controller('bas_file_type_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.basFileType={};


    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;
    var fileType ='';
    var fileTypeName = '';
    if ($scope.showCheck) {

        $http.get('bas_file_type/findBasFileTypeVoByFileTypeId?fileTypeId='+ $location.search()['fileTypeId']).success(function(data){
            $scope.basFileType = data.data;
            if(isNotNull($scope.basFileType.chiBasFiles)){
                for( var i in  $scope.basFileType.chiBasFiles ){
                    if(i ==  $scope.basFileType.chiBasFiles.length-1){
                        fileType = fileType+ $scope.basFileType.chiBasFiles[i].fileType;
                        fileTypeName = fileTypeName+ $scope.basFileType.chiBasFiles[i].fileTypeName;
                    }else{
                        fileType = fileType+ $scope.basFileType.chiBasFiles[i].fileType+',';
                        fileTypeName =  fileTypeName+ $scope.basFileType.chiBasFiles[i].fileTypeName+',';
                    }
                }
                $scope.basFileType.parentFileType = fileType;
                $scope.basFileType.parentFileTypeName = fileTypeName;
            }
            $scope.basFileType.actualFileName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.actualFile,$scope.basFileType.fileFlag);
            $scope.basFileType.requiredStateName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.requiredState,$scope.basFileType.fileChkFlag);
        });
    }



    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_file_type_list");
    };

}]);


