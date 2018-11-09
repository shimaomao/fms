app.controller('creditModelController', ['$scope', '$http', '$state', '$localStorage', '$filter', '$rootScope', '$modal', '$cookies', '$location','$stateParams',function($scope, $http, $state, $localStorage, $filter, $rootScope, $modal, $cookies, $location, $stateParams) {

    $scope.xtczry =  $location.search().xtczry;

    $scope.applyNo = $location.search().applyNo;

    $scope.isDisable =  false;

    $scope.zxbgId = $location.search().zxbgId;
    $scope.hit = "命中";
    $scope.noHit = "未命中";
    $scope.name_1 = "主申人";
    $scope.name_2 = "配偶";
    $scope.name_3 = "担保人";
    $scope.name_4 = "共申人";
    $scope.name_5 = "联系人1";
    $scope.name_6 = "联系人2";
    $scope.name_11 = "法人";
    $scope.zwyz = "二维一致";
    $scope.swyz = "三维一致";
    $scope.high = "高";
    $scope.low = "低";
    $scope.medium = "中等";
    $scope.sourceId_A = "信贷逾期风险";
    $scope.sourceId_B = "行政负面风险";
    $scope.sourceId_99 = "权限不足";
    $scope.rskMark_B1 = "失信被执行人";
    $scope.rskMark_B2 = "被执行人";
    $scope.rskMark_B3 = "交通严重违章";
    $scope.rskMark_B3 = "交通严重违章";
    $scope.dataStatus_1 = "已验证";
    $scope.dataStatus_2 = "未验证";
    $scope.dataStatus_3 = "异议中";
    $scope.isQhhmdShow = false;
    $scope.isQkjlShow = false;
    $scope.isQkShow = false;
    $scope.isBlxxShow = false;
    $scope.isDptjdShow = false;
    $scope.blxlsmList = [];
    $scope.dptdkList = [];
    $scope.phoneTabClass = [];
    $scope.phoneTabContentClass = [];
    $scope.jszTabClass = [];
    $scope.jszTabContentClass = [];
    $scope.hxdTabClass = [];
    $scope.hxdTabContentClass = [];
    $scope.hmdTabClass = [];
    $scope.hmdTabContentClass = [];
    $scope.qkTabClass = [];
    $scope.qkTabContentClass = [];
    $scope.jzTabClass = [];
    $scope.jzTabContentClass = [];
    $scope.jzmhTabClass = [];
    $scope.jzmhTabContentClass = [];
    $scope.tdTabClass = [];
    $scope.tdTabContentClass = [];
    $scope.tabNum = 0;
    $scope.tdTabNum = 0;
    $scope.scoreB = "";
    $scope.riskLevel = "";
    $scope.zxgzjs = "";
    $scope.zdrgaxxsfyz = "";
    $scope.pogaxxsfyz = "";
    $scope.gsrgaxxsfyz = "";
    $scope.dbrgaxxsfyz = "";

    function initDate() {
        $http.post('credit_model/findCustomerByApplyNo?applyNo=' + $scope.applyNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.applyInputVo = data.data;
                $scope.applyInputVo.cstmPerson.sex = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,$scope.applyInputVo.cstmPerson.sex);
                $scope.applyInputVo.cstmPerson.marriageStatus = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.marriageStatus,$scope.applyInputVo.cstmPerson.marriageStatus);
                $scope.applyInputVo.applyFinanceVo.vehicleForm = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.applyInputVo.applyFinanceVo.vehicleForm);


                echartsFunction($scope.applyInputVo.echartsMap.data,$scope.applyInputVo.echartsMap.links);

                var data = {"status":"SUCCESS","info":"","data":{"basqbh":3521782,"baddbh":65103994,"appf":"8","apxdjy":"人工","apxdbz":"","xtcjrq":"20180224","xtcjsj":"221757","hmxssj":1519481877000,"tsbz":null,"risklevel":null,"zxgzjs":null,"bakhxm":"王军","bakhxb":"男","bakhnl":"42","bacpcx":"乘用车","bacllx":"新车","bahyzk":"已婚有子女","basjhm":"13895716095","bazjhm":"211323197302061611","batjrq":"20150416","fxrzze":"43900","basqdq":null,"mobileAddress":"黑龙江省哈尔滨市","idCardAddress":"辽宁省朝阳市凌源县","clsycs":"哈尔滨市","bagzdq":"黑龙江省哈尔滨市","zxgzbz":null,"zxcxgz":"不查","gasfyz":"1#0#-1#-1","xczdj":"72900","zxtb001Jo2PojoList":[],"zxtb001Jo3PojoList":[],"zxtb001JszPojoList":[],"zxtb001QhhxdPojoList":[{"khxm":"王军","flag":"1","hxdfs":"609","hxdms":"良好"},{"khxm":"王军","flag":"1","hxdfs":"605","hxdms":"良好"}],"zxtb001QhhmdPojoList":[{"id":145404,"khxm":"王军","flag":"1","sourceid":"","yqts":"","yqje":"","rskmark":"","databuildtime":"","datastatus":""}],"zxtb001QkPojoList":[{"id":116054,"khxm":"王军","flag":"1","crimetype":"本数据库中未查得","count":null,"casetype":null,"casesource":null,"caseperiod":null,"caselevel":null}],"zxtb001JzzbPojoList":[{"khxm":"王军","flag":"1","zxtb001JzPojoList":[{"type":"执行公开信息","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"失信老赖名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"限制高消费名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"限制出入境名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"民商事裁判文书","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"民商事审判流程","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"罪犯及嫌疑人名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"行政违法记录","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"欠税名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"纳税非正常户","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null},{"type":"欠款欠费名单","sfmz":"未命中","zxtb001JzMxPojoList":[],"displayFlag":null}]}],"zxtb001MhzbPojoList":[],"zxtb001TdzbPojoList":[{"khxm":"王军","flag":"1","basqlx":null,"bacllx":null,"bacpcx":null,"fxrzze":null,"zxtb001Td1PojoList":[]}],"zxtb001HPLHisPojoList":[],"zxtb001DdxsjPojoList":[{"id":61744,"clrzjg":71500.0,"avgjg":null,"bili":null,"xtczrq":"20180224"}]}};
                $scope.zxtbData = data.data;
                initHide();
                $scope.phoneTabClass[0] = "active";
                $scope.phoneTabContentClass[0] = "tab-content";
                initJszHide();
                $scope.jszTabClass[0] = "active";
                $scope.jszTabContentClass[0] = "tab-content";
                initHxdHide();
                $scope.hxdTabClass[0] = "active";
                $scope.hxdTabContentClass[0] = "tab-content";
                initHmdHide();
                $scope.hmdTabClass[0] = "active";
                $scope.hmdTabContentClass[0] = "tab-content";
                initQkHide();
                $scope.qkTabClass[0] = "active";
                $scope.qkTabContentClass[0] = "tab-content";
                initJzHide();
                $scope.jzTabClass[0] = "active";
                $scope.jzTabContentClass[0] = "tab-content";
                initJzmhHide();
                $scope.jzmhTabClass[0] = "active";
                $scope.jzmhTabContentClass[0] = "tab-content";
                initTdHide();
                $scope.tdTabClass[0] = "active";
                $scope.tdTabContentClass[0] = "tab-content";
                if ($scope.zxtbData.gasfyz != null && $scope.zxtbData.gasfyz != "") {
                    var arr = $scope.zxtbData.gasfyz.split("#");
                    if (arr[0] == "1") {
                        $scope.zdrgaxxsfyz = "一致";
                    } else if (arr[0] == "0") {
                        $scope.zdrgaxxsfyz = "不一致";
                    }
                    if (arr[1] == "1") {
                        $scope.pogaxxsfyz = "一致";
                    } else if (arr[1] == "0") {
                        $scope.pogaxxsfyz = "不一致";
                    }
                    if (arr[2] == "1") {
                        $scope.gsrgaxxsfyz = "一致";
                    } else if (arr[2] == "0") {
                        $scope.gsrgaxxsfyz = "不一致";
                    }
                    if (arr[3] == "1") {
                        $scope.dbrgaxxsfyz = "一致";
                    } else if (arr[3] == "0") {
                        $scope.dbrgaxxsfyz = "不一致";
                    }
                }
                if ($scope.zxtbData.zxgzjs != null && $scope.zxtbData.zxgzjs != "") {
                    if ($scope.zxtbData.zxgzjs.substring(0,1) == "1") {
                        $scope.zxgzjs = $scope.zxgzjs + "主贷/"
                    }
                    if ($scope.zxtbData.zxgzjs.substring(1,2) == "1") {
                        $scope.zxgzjs = $scope.zxgzjs + "配偶/"
                    }
                    if ($scope.zxtbData.zxgzjs.substring(2,3) == "1") {
                        $scope.zxgzjs = $scope.zxgzjs + "担保/"
                    }
                    if ($scope.zxtbData.zxgzjs.substring(3,4) == "1") {
                        $scope.zxgzjs = $scope.zxgzjs + "共申/"
                    }
                    if ($scope.zxgzjs != "") {
                        $scope.zxgzjs = $scope.zxgzjs.substring(0, $scope.zxgzjs.length - 1);
                    }
                }
                $scope.scoreB = "";

            } else {
                modalAlert($modal,data.message);
            }
        }).error(function(data){
            modalAlert($modal,data);
        })




    }

    // 初期化
    function init() {
        initDate();
    };
    init();

    // 法院信息点击详情
    $scope.jzClick = function (num) {
        if ($scope.zxtbData.zxtb001JzzbPojoList[$scope.tabNum].zxtb001JzPojoList[num].displayFlag) {
            $scope.zxtbData.zxtb001JzzbPojoList[$scope.tabNum].zxtb001JzPojoList[num].displayFlag = false;
        } else {
            $scope.zxtbData.zxtb001JzzbPojoList[$scope.tabNum].zxtb001JzPojoList[num].displayFlag = true;
        }
    }

    // 法院信息点击详情
    $scope.tdClick = function (num) {
        if ($scope.zxtbData.zxtb001TdzbPojoList[$scope.tdTabNum].zxtb001Td1PojoList[num].displayFlag) {
            $scope.zxtbData.zxtb001TdzbPojoList[$scope.tdTabNum].zxtb001Td1PojoList[num].displayFlag = false;
        } else {
            $scope.zxtbData.zxtb001TdzbPojoList[$scope.tdTabNum].zxtb001Td1PojoList[num].displayFlag = true;
        }
    }

    $scope.phoneShow = true;

    // 切换手机号tab
    $scope.openPhoneInfo = function (num,info_flag) {
        initHide();
        if(info_flag == 5 || info_flag == 6)
            $scope.phoneShow = false;
        else
            $scope.phoneShow = true;
        $scope.phoneTabClass[num] = "active";
        $scope.phoneTabContentClass[num] = "tab-content";
        // var name = '#' + $scope.deviceInfoList[num].simCode;
        // $(name).fadeIn();
        // $scope.simIndex = num;
    };
    // tabClass初始化
    function initHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001Jo3PojoList.length; i++) {
            $scope.phoneTabClass[i] = "";
            $scope.phoneTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换驾驶证tab
    $scope.openJszInfo = function (num) {
        initJszHide();
        $scope.jszTabClass[num] = "active";
        $scope.jszTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initJszHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001JszPojoList.length; i++) {
            $scope.jszTabClass[i] = "";
            $scope.jszTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换好信度tab
    $scope.openHxdInfo = function (num) {
        initHxdHide();
        $scope.hxdTabClass[num] = "active";
        $scope.hxdTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initHxdHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001QhhxdPojoList.length; i++) {
            $scope.hxdTabClass[i] = "";
            $scope.hxdTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换黑名单tab
    $scope.openHmdInfo = function (num) {
        initHmdHide();
        $scope.hmdTabClass[num] = "active";
        $scope.hmdTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initHmdHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001QhhmdPojoList.length; i++) {
            $scope.hmdTabClass[i] = "";
            $scope.hmdTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换前科tab
    $scope.openQkInfo = function (num) {
        initQkHide();
        $scope.qkTabClass[num] = "active";
        $scope.qkTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initQkHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001QkPojoList.length; i++) {
            $scope.qkTabClass[i] = "";
            $scope.qkTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换法院tab
    $scope.openJzInfo = function (num) {
        initJzHide();
        $scope.tabNum = num;
        $scope.jzTabClass[num] = "active";
        $scope.jzTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initJzHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001JzzbPojoList.length; i++) {
            $scope.jzTabClass[i] = "";
            $scope.jzTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 切换法院模糊tab
    $scope.openJzmhInfo = function (num) {
        initJzmhHide();
        $scope.jzmhTabClass[num] = "active";
        $scope.jzmhTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initJzmhHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001MhzbPojoList.length; i++) {
            $scope.jzmhTabClass[i] = "";
            $scope.jzmhTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 借贷信息tab
    $scope.openTdInfo = function (num) {
        initTdHide();
        $scope.tdTabNum = num;
        $scope.tdTabClass[num] = "active";
        $scope.tdTabContentClass[num] = "tab-content";
    };
    // tabClass初始化
    function initTdHide() {
        for (var i = 0; i < $scope.zxtbData.zxtb001TdzbPojoList.length; i++) {
            $scope.tdTabClass[i] = "";
            $scope.tdTabContentClass[i] = "tab-content ng-hide";
        }
    }

    // 上报当地平均价
    $scope.sbddpjj = function (num) {
        var rtn = $modal.open({backdrop : 'static',size:'md',
            templateUrl: 'tpl/zxtb/sbddpjj.html',
            controller: 'sbddpjjController',
            resolve:{
                id:function () {
                    return $scope.zxtbData.zxtb001DdxsjPojoList[num].id;
                },
                xtczry:function () {
                    return $scope.xtczry;
                }
            }
        });
        rtn.result.then(function (status) {
            if(status != "close") {
                var arrStatus = status.split(",");
                $scope.zxtbData.zxtb001DdxsjPojoList[num].id = arrStatus[1];
                $scope.zxtbData.zxtb001DdxsjPojoList[num].avgjg = arrStatus[0];
                if ($scope.zxtbData.zxtb001DdxsjPojoList[num].clrzjg != null && $scope.zxtbData.zxtb001DdxsjPojoList[num].clrzjg != "") {
                    $scope.zxtbData.zxtb001DdxsjPojoList[num].bili = $scope.zxtbData.zxtb001DdxsjPojoList[num].clrzjg / $scope.zxtbData.zxtb001DdxsjPojoList[num].avgjg;
                }
                var year = new Date().getFullYear();
                var month = new Date().getMonth() + 1;
                month =(month<10 ? "0"+month:month);
                var day = new Date().getDate();
                $scope.zxtbData.zxtb001DdxsjPojoList[num].xtczrq = year.toString() + month.toString() + day.toString();
                win.alert("上传当地平均价成功。",'img/smiley_happy.png',function () {

                });
                // alert("上传当地平均价成功。");
            }
        },function(){
        });
    };


    function echartsFunction(data,links){
        var myChart = echarts.init(document.getElementById('main'));
        option = {
            title: { text: '主贷人及联系人关系' },
            tooltip: {
                formatter: function (x) {
                    return x.data.des;
                }
            },
            series: [
                {
                    type: 'graph',
                    layout: 'force',
                    symbolSize: 80,
                    roam: true,
                    edgeSymbol: ['circle', 'arrow'],
                    edgeSymbolSize: [4, 10],
                    edgeLabel: {
                        normal: {
                            textStyle: {
                                fontSize: 20
                            }
                        }
                    },
                    force: {
                        repulsion: 2500,
                        edgeLength: [10, 50]
                    },
                    draggable: true,
                    itemStyle: {
                        normal: {
                            color: '#4b565b'
                        }
                    },
                    lineStyle: {
                        normal: {
                            width: 2,
                            color: '#4b565b'

                        }
                    },
                    edgeLabel: {
                        normal: {
                            show: true,
                            formatter: function (x) {
                                return x.data.name;
                            }
                        }
                    },
                    label: {
                        normal: {
                            show: true,
                            textStyle: {
                            }
                        }
                    },
                    data: data,
                    links: links
                }
            ]
        };
        myChart.setOption(option);


    }

}]);
