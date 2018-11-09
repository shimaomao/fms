
/**
 * Created by niehaibing on 2018-03-23.
 */

app.controller('product_intrst_controller', ['$scope', '$http','$modal','$modalInstance', 'toaster','$compile','intrstData','$timeout', function ($scope, $http,$modal,$modalInstance,toaster,$compile,intrstData,$timeout) {
    $scope.prodIntrst = {
        prodIntrstFactorVoList:[],
        intrstRateMode: ""
    };
    $scope.checkValue = function (str,value) {
        if(str){
            var arr = str.split(',');
            if(arr.indexOf(value) != -1){
                return true;
            }else {
                return false;
            }
        }

    };
    console.log(intrstData);
    $scope.save = function () {
        var flag = false;
        $('.requireCheckbox').each(function(i,v){
            var name = $(v).attr('checkboxName');
            var itemChecked = '[name=' + name + ']:checked';
            var item = '[name=' + name + ']';
            var chk_value = [];
            $(item).each(function(k,m){
                $(m).change(function(){
                    var chk_val = [];
                    $(itemChecked).each(function(){
                        chk_val.push($(this).val());
                    });
                    if(chk_val.length == 0 || chk_val == undefined){
                        $(v).find('p').removeClass('hidden');
                    }else{
                        $(v).find('p').addClass('hidden');
                    }
                });
            });
            $(itemChecked).each(function(j,w){
                chk_value.push($(this).val());
            });
            if(chk_value.length == 0 || chk_value == undefined){
                $(v).find('p').removeClass('hidden');
                flag = true;
            }else{
                $(v).find('p').addClass('hidden');
                flag = false;
            }
        });
        if(!$scope.form.$invalid && !flag) {
            $scope.submit = true;
            $scope.close({
                "data":$scope.prodIntrst,
                "index":intrstData.index
            });

        }else{
            $scope.formValidate = true;
        }



    };

    $scope.close = function(status){
        $modalInstance.close(status);
    };
    /*获取利率因子*/
    $scope.init  = function(){
        var html = "";
        $http.get('intrst_factor/findIntrstFactorAllList').success(function (data) {
            var factorData = data.data;
            if(data.code == Response.successCode){
                $scope.factorData = factorData;
                for(var i=0;i<factorData.length;i++){
                    $scope.prodIntrst.prodIntrstFactorVoList.push({
                        "factorCode":factorData[i].factorCode
                    });

                    if(data.data[i].factorType == 1){
                        var child = CommonCodeUtils.getCommonCodes(factorData[i].factorCode);
                        html += "<div class=\"col-sm-6\"><div class=\"row\">"+
                            "<label class=\"col-sm-4 control-label text-right\"><b class=\"form-text-black\">"+factorData[i].factorName+"</b><b class=\"form-error\">*</b>:</label>";
                        html += "<div class=\"col-sm-8 requireCheckbox\" checkboxName=\""+factorData[i].factorCode+"Intrst\">";

                        for(var j=0;j<child.length;j++){
                            html += "<div class=\"checkbox\" style=\"margin-top: 2px;\">"+
                            "<label>"+
                            "<input type=\"checkbox\" name=\""+factorData[i].factorCode+"Intrst\" value=\""+child[j].codeValue+"\" ng-click=\"checked("+i+",'"+child[j].codeValue+"');\" ng-checked=\"checkValue(prodIntrst.prodIntrstFactorVoList["+i+"].factorValueFrom,'"+child[j].codeValue+"')\">"+child[j].codeValueName+""+
                            "</label> </div>";
                        }
                        html += "<p class=\"hidden\"><span class=\"form-info\">"+factorData[i].factorName+"不能为空</span></p></div></div></div>";

                    }else{
                        $scope.prodIntrst.prodIntrstFactorVoList[i].factorValueFrom = 0;
                        $scope.prodIntrst.prodIntrstFactorVoList[i].factorValueTo = 100;
                        html += "<div class=\"col-sm-12\"><div class=\"row\">"+
                            "<label class=\"col-sm-2 control-label text-right\"><b class=\"form-text-black\">"+factorData[i].factorName+"</b><b class=\"form-error\">%*</b>:</label>";
                        html += "<div class=\"col-sm-4\">";
                        html += "<input type=\"text\" name=\""+factorData[i].factorCode+"From\" placeholder=\"请输入"+factorData[i].factorName+"开始\" ng-model=\"prodIntrst.prodIntrstFactorVoList["+i+"].factorValueFrom\" class=\"form-control m-b-xs\" required>";
                        html += "<p><span class=\"form-info\" ng-show=\"(form."+factorData[i].factorCode+"From.$dirty && form."+factorData[i].factorCode+"From.$error.required) || (form."+factorData[i].factorCode+"From.$error.required && formValidate)\">"+factorData[i].factorName+"开始不能为空</span></p></div>";
                        html += "<div class=\"col-sm-2 control-label text-center\"><span>~</span></div>";
                        html += "<div class=\"col-sm-4\">";
                        html += "<input type=\"text\" name=\""+factorData[i].factorCode+"To\" placeholder=\"请输入"+factorData[i].factorName+"结尾\" ng-model=\"prodIntrst.prodIntrstFactorVoList["+i+"].factorValueTo\" class=\"form-control m-b-xs\" required>";
                        html += "<p><span class=\"form-info\" ng-show=\"(form."+factorData[i].factorCode+"To.$dirty && form."+factorData[i].factorCode+"To.$error.required) || (form."+factorData[i].factorCode+"To.$error.required && formValidate)\">"+factorData[i].factorName+"结尾不能为空</span></p></div>";
                        html +=  "</div></div>";

                    }

                }
                $('.intrst-main').append(html);
                $compile($('.intrst-main'))($scope);
                //intrstRateMode
                $scope.intrstRateModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.intrstRateMode);
                if(intrstData.data){
                    $scope.prodIntrst = intrstData.data;
                }
            }else{

            }
        }).error(function (err) {

        });

    };

    $scope.checked = function (i,value) {
        var item = $scope.prodIntrst.prodIntrstFactorVoList[i].factorValueFrom;
        if(item){
            item = item.split(',');
        }else{
            item = [];
        }

        var index = item.indexOf(value);
        if(index==-1) {
            //添加
            item.push(value);
        } else {
            //删除
            item.splice(index, 1);
        }
        $scope.prodIntrst.prodIntrstFactorVoList[i].factorValueFrom = CommonStringUtils.arrToString(item);
    };




}]);



