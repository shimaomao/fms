/**
 * Created by root on 2018/10/29.
 */
app.controller('equ_mor_charge_import_tab_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {

  $scope.equMorChargeVos = [];
  $scope.equMorRepayVos = [];
  $scope.basBankInfoVo = null;
  $scope.equMorChargeImportVo = {equMorTaskNo:$location.search()['serviceId'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};
  $scope.equMorTaskNo = $location.search()['serviceId'];
  $scope.equMorChargeImportVo.bizFilesList = [];
  $scope.equMorChargeImportVo.notUpload = false;
  $scope.equMorChargeImportVo.notUploadInfo = "";

  $http.get('equ_mor_apply/findEquMorDetailVosAndFileByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
    if (data.code == Response.successCode) {
      $scope.equMorDetails = data.data;
      var management = "";
      if ($scope.equMorDetails && $scope.equMorDetails.length > 0){
        for(var index in $scope.equMorDetails){
          if (!management){
            $scope.management = $scope.equMorDetails[index].management;
            break;
          }
        }
      }
    }
    else
      modalAlert($modal,data.message);
  }).error(function(data){
    modalAlert($modal,data);
  })


  $http.get('equ_mor_apply/findEquMorChargeImportVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
    if (data.code == Response.successCode) {
      $scope.equMorChargeVos = data.data.equMorCharges;
      $scope.equMorRepayVos = data.data.equMorRepays;
      $scope.basBankInfoVo = data.data.basBankInfoVo;
      $scope.equMorChargeImportVo.bizFilesList = data.data.bizFilesList;
    }
    else {
      modalAlert($modal, data.message);
    }
  }).error(function(data){
    modalAlert($modal,data);
  })


  //导入付款信息
  $scope.importPaymentExcel = function () {
    var rtn = $modal.open({
      backdrop : 'static',
      size:'lg',
      templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
      controller: 'file_upload_controller',
      resolve:{
        fileTypePath:function () {
          return CommonCodeUtils.fileTypePaths.upLoad;
        },
        secondPath:function () {
          return CommonCodeUtils.secondPath.payMentFiles;
        }
      }
    });
    rtn.result.then(function (data) {
      if(CommonObjectUtils.isExist(data) && data.length > 0 && CommonStringUtils.isNotTrimBlank(data[0].fileCompletePath)){
        $scope.equMorChargeVos = [];
        $scope.payment_file_name = '';
        for(var i in data){
          $scope.payment_file_name += data[i].fileOriginalName + ",";
          $scope.parseEquMorChargeExcel(data[i].fileCompletePath);
        }
        $scope.payment_file_name = $scope.payment_file_name.substring(0,$scope.payment_file_name.length - 1);
      }
    },function(){

    });
  }
  $scope.parseEquMorChargeExcel = function(filePath){
    $http.get('equ_mor_apply/parseEquMorChargeExcel?filePath=' + filePath).success(function (data) {
      if (data.code == Response.successCode) {
        if($scope.equMorChargeVos == null)
          $scope.equMorChargeVos = data.data;
        else
          Array.prototype.push.apply($scope.equMorChargeVos,data.data);
      }  else
        modalAlert($modal, data.message);
    }).error(function (data) {
      modalAlert($modal, data);
    })
  }



  $scope.callback = function (data) {
    var tableData = data;
    var rentSum=0;
    for(var i=0;i<tableData.length;i++){
      rentSum = tableData[i].rent*1 + rentSum;
    }
    var html = '<tr id="myHeader" class="header">' +
        '<th>合计</th>' +
        '<td colspan="3"></td>' +
        '<td class="text-center">'+rentSum.toFixed(2)+'</td>' +
        '</tr>';
        //获取ta
        var  aa = document.getElementById('equ_mor_charge_import_plan');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('myHeader')) {
            //有就去更新tr标签
            var  bb = document.getElementById('myHeader');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#equ_mor_charge_import_plan tbody').append(html);
        }
  };


  //银行选择
  $scope.selectBasBankInfo = function(){
    var rtn = $modal.open({
      backdrop : 'static',
      size:'lg',
      templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
      controller: 'bas_bank_info_select_controller',
      resolve:{
        selectBank: function () {
          return {organizationType: CommonCodeUtils.organizationType.mortgages}
        }
      }
    });
    rtn.result.then(function (data) {
      if(data != null) {
        $scope.basBankInfoVo = data;
      }
    },function(){

    });
  }



  //导入客户还款计划表
  $scope.importRepaymentPlanExcel = function () {
    var rtn = $modal.open({
      backdrop : 'static',
      size:'lg',
      templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
      controller: 'file_upload_controller',
      resolve:{
          fileTypePath:function () {
              return CommonCodeUtils.fileTypePaths.upLoad;
          },
          secondPath:function () {
              return CommonCodeUtils.secondPath.rePayMentFiles;
          }
      }
    });
    rtn.result.then(function (data) {
      if(CommonObjectUtils.isExist(data) && data.length > 0 && CommonStringUtils.isNotTrimBlank(data[0].fileCompletePath)){
        $scope.equMorRepayVos = [];
        $scope.repayment_plan_file_name = '';
        for(var i in data){
          $scope.repayment_plan_file_name += data[i].fileOriginalName + ",";
          $scope.parseEquMorRepayExcel(data[i].fileCompletePath);
        }
        $scope.repayment_plan_file_name = $scope.repayment_plan_file_name.substring(0,$scope.repayment_plan_file_name.length - 1);
      }
    },function(){

    });
  }

  $scope.parseEquMorRepayExcel = function(filePath){
    $http.get('equ_mor_apply/parseEquMorRepayVoExcel?filePath=' + filePath).success(function (data) {
      if (data.code == Response.successCode) {
        if($scope.equMorRepayVos == null){
            $scope.equMorRepayVos = data.data;
        } else{
            Array.prototype.push.apply($scope.equMorRepayVos,data.data);
            $scope.callback(data.data);
        }

      } else
        modalAlert($modal, data.message);
    }).error(function (data) {
      modalAlert($modal, data);
    })
  }

  $scope.save = function(){

    if(!$scope.form.$invalid) {

      $scope.submit = true;
      var check = true;
      if($scope.equMorChargeVos.length < 1){
        modalAlert($modal,"请导入付款信息");
        check = false;
      }
      if($scope.equMorRepayVos < 1 && check){
        modalAlert($modal,"请导入客户还款计划信息");
        check = false;
      }

      if($scope.basBankInfoVo == null && check){
        modalAlert($modal,"请选择付款银行");
        check = false;
      }

      if($scope.equMorChargeImportVo.notUpload){
        modalAlert($modal,$scope.equMorChargeImportVo.notUploadInfo);
        check = false;
      }

      if(check){
        $scope.equMorChargeImportVo.equMorChargeVos = $scope.equMorChargeVos;
        $scope.equMorChargeImportVo.equMorRepayVos = $scope.equMorRepayVos;
        $scope.equMorChargeImportVo.basBankInfoVo = $scope.basBankInfoVo;
        // $scope.equMorChargeImportVo.bizFilesList = $scope.bizFilesList;
        $http.post('equ_mor_apply/equMorChargeImport', $scope.equMorChargeImportVo).success(function (data) {
          if (data.code == Response.successCode) {
            $location.path("/app/home").search({type:'homeToastInfo', msg:'导入费用成功'});
          }
          else {
            modalAlert($modal, data.message);
            $scope.submit = false;
          }
        }).error(function(data){
          modalAlert($modal,data);
          $scope.submit = false;
        })
      }else{
        $scope.submit = false;
      }
    }else{
      $scope.formValidate = true;
      toaster_info(promptInfo.submitWarn,toaster);
    }

  }


  //返回到主页
  $scope.goBack = function () {
    $location.path("app/home");
  }

  //退回上一级
  $scope.returnSuperior = function(){
    if(CommonStringUtils.isNotTrimBlank($scope.equMorChargeImportVo.memo)){
      $scope.submit = true;
      $http.post('equ_mor_apply/equMorChargeImportReturn', $scope.equMorChargeImportVo).success(function (data) {
        if (data.code == Response.successCode) {
          $location.path("/app/home").search({type:'homeToastInfo', msg:'退回成功'});
        } else {
          modalAlert($modal, data.message);
          $scope.submit = false;
        }
      }).error(function(data){
        modalAlert($modal,data);
        $scope.submit = false;
      })
    }else{
      modalAlert($modal,"请填写备注");
    }
  }


  $scope.downloadImportPaymentExcel = function(){
    window.parent.open('equ_mor_apply/downloadEquMorChargeImportTemplate');

  }

  $scope.downloadImportRepaymentPlanExcel = function(){
    window.parent.open('equ_mor_apply/downloadEquMorRepayExcelTemplate');

  }
}]);