/**
 * Created by qiaohao on 2018/4/3.
 */
app.controller('form_demo_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    $scope.$watch('fileValue.fileVoUrls.length',function(){
        alert("监听到了fileVoUrls");
    })

}])
;