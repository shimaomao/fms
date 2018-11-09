/**
 * Created by ningyangyang on 2018/3/30.
 */
app.controller('borrower_info_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$rootScope',function ($scope, $http, $modal, toaster,$compile,$location,$rootScope) {
    $scope.borrowerList = [];
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.$watch('borrowerList',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("borrowerToFather",$scope.borrowerList);
    },true);
    $scope.mateCertifNo = $rootScope.mateCertifNo;
    if($scope.applyNo){
        $http.get('apply_input/findApplyGuaranteeByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.borrowerList = data.data.commonBorrowerList;
        });
    }


    $scope.modifyBorrower = function (index,data) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/common_borrower/common_borrower_modify.html'+getCacheTime(),
            controller: 'common_borrower_modify_controller',
            resolve:{
                borrower: function () {
                    if(data){
                        return {
                            "index": index,
                            "data":data
                        }
                    }else{
                        return {
                            "index": false,
                            "data":false
                        }
                    }

                }
            }
        });
        rtn.result.then(function (data) {
            if(data){
                if(data.data){
                    if(data.index === 0 || data.index){
                        $scope.borrowerList[data.index] = data.data;
                    }else{
                        $scope.borrowerList.push(data.data);
                    }
                }
            }
        },function(){
        });
    };
    //删除共同借款人
   $scope.delBorrower = function (index) {
       $scope.borrowerList.splice(index,1);
   };

   //获取个人基本信息里面的配偶信息
    $scope.$on('persMateToSon',function (e,data) {
        data.whetherSpouse = 0;
        var length = $scope.borrowerList.length;
        if(length == 0){
            if(data.isCommonBorrower == 1){
                $scope.borrowerList.push(data);
            }
        }else{
            for(var i=0;i<length;i++){
                if($scope.borrowerList[i].whetherSpouse == 0){
                    if(data.isCommonBorrower == 1){
                        $scope.borrowerList[i] = data;
                    }else{
                        $scope.borrowerList.splice(i,1);
                    }
                    return false;
                }
            }
            if(data.isCommonBorrower == 1){
                $scope.borrowerList.push(data);
            }
        }
    });
}])
;