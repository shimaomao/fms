/**
 * Created by bbk on 2018/5/10.
 */
angular.module('app')
    .directive('setNgAnimate', ['$animate', function ($animate) {
        return {
            link: function ($scope, $element, $attrs) {
                $scope.$watch( function() {
                    return $scope.$eval($attrs.setNgAnimate, $scope);
                }, function(valnew, valold){
                    $animate.enabled(!!valnew, $element);
                });
            }
        };
    }])
    .directive('repeatFinish', ['$timeout',function ($timeout) {
        return {
            restrict: 'A',
            link: function(scope, element, attr) {
                if (scope.$last) {
                    $timeout(function() {
                        scope.$emit('ngRepeatFinished',element);
                    });
                }
            }
        }
    }])
    .directive('uiButterbar', ['$rootScope', '$anchorScroll', function($rootScope, $anchorScroll) {
        return {
            restrict: 'AC',
            template:'<span class="bar"></span>',
            link: function(scope, el, attrs) {
                el.addClass('butterbar hide');
                scope.$on('$stateChangeStart', function(event) {
                    $anchorScroll();
                    el.removeClass('hide').addClass('active');
                });
                scope.$on('$stateChangeSuccess', function( event, toState, toParams, fromState ) {
                    event.targetScope.$watch('$viewContentLoaded', function(){
                        el.addClass('hide').removeClass('active');
                    })
                });
            }
        };
    }])
    .directive('uiFocus', ['$timeout','$parse',function($timeout, $parse) {
        return {
            link: function(scope, element, attr) {
                var model = $parse(attr.uiFocus);
                scope.$watch(model, function(value) {
                    if(value === true) {
                        $timeout(function() {
                            element[0].focus();
                        });
                    }
                });
                element.bind('blur', function() {
                    scope.$apply(model.assign(scope, false));
                });
            }
        };
    }])
    .directive('uiFullscreen', ['uiLoad', '$document', '$window', function(uiLoad, $document, $window) {
        return {
            restrict: 'AC',
            template:'<i class="fa fa-expand fa-fw text"></i><i class="fa fa-compress fa-fw text-active"></i>',
            link: function(scope, el, attr) {
                el.addClass('hide');
                uiLoad.load('vendor/libs/screenfull.min.js').then(function(){
                    // disable on ie11
                    if (screenfull.enabled && !navigator.userAgent.match(/Trident.*rv:11\./)) {
                        el.removeClass('hide');
                    }
                    el.on('click', function(){
                        var target;
                        attr.target && ( target = $(attr.target)[0] );
                        screenfull.toggle(target);
                    });
                    $document.on(screenfull.raw.fullscreenchange, function () {
                        if(screenfull.isFullscreen){
                            el.addClass('active');
                        }else{
                            el.removeClass('active');
                        }
                    });
                });
            }
        };
    }])
    .directive('uiModule', ['MODULE_CONFIG','uiLoad', '$compile', function(MODULE_CONFIG, uiLoad, $compile) {
        return {
            restrict: 'A',
            compile: function (el, attrs) {
                var contents = el.contents().clone();
                return function(scope, el, attrs){
                    el.contents().remove();
                    uiLoad.load(MODULE_CONFIG[attrs.uiModule])
                        .then(function(){
                            $compile(contents)(scope, function(clonedElement, scope) {
                                el.append(clonedElement);
                            });
                        });
                }
            }
        };
    }])
    .directive('uiNav', ['$timeout', function($timeout) {
        return {
            restrict: 'AC',
            link: function(scope, el, attr) {
                var _window = $(window),
                    _mb = 768,
                    wrap = $('.app-aside'),
                    next,
                    backdrop = '.dropdown-backdrop';
                // unfolded
                el.on('click', 'a', function(e) {
                    //next && next.trigger('mouseleave.nav');
                    var _this = $(this);
                    _this.parent().siblings( ".active" ).toggleClass('active');
                    _this.next().is('ul') &&  _this.parent().toggleClass('active') &&  e.preventDefault();
                    // mobile
                    _this.next().is('ul') || ( ( _window.width() < _mb ) && $('.app-aside').removeClass('show off-screen') );

                    //点击事件
                    if($('.aside-wrap').next().length>0){
                        $('.aside-wrap').next().toggleClass('hidden');
                    }


                });

                // folded & fixed
                el.on('mouseenter', 'a', function(e){
                    next && next.trigger('mouseleave.nav');
                    $('> .nav', wrap).remove();
                    if ( !$('.app-aside-fixed.app-aside-folded').length || ( _window.width() < _mb ) || $('.app-aside-dock').length) return;
                    var _this = $(e.target)
                        , top
                        , w_h = $(window).height()
                        , offset = 50
                        , min = 150;

                    !_this.is('a') && (_this = _this.closest('a'));
                    if( _this.next().is('ul') ){
                        next = _this.next();
                    }else{
                        return;
                    }

                    /*_this.parent().addClass('active');*/
                    top = _this.parent().position().top + offset;
                    next.css('top', top);
                    if( top + next.height() > w_h ){
                        next.css('bottom', 0);
                    }
                    if(top + min > w_h){
                        next.css('bottom', w_h - top - offset).css('top', 'auto');
                    }

                    next.addClass('hidden');
                    next.appendTo(wrap);



                    next.on('mouseleave.nav', function(e){
                        $(backdrop).remove();
                        next.appendTo(_this.parent());
                        next.off('mouseleave.nav').css('top', 'auto').css('bottom', 'auto');
                        _this.parent().removeClass('active');
                    });

                    $('.smart').length && $('<div class="dropdown-backdrop"/>').insertAfter('.app-aside').on('click', function(next){
                        next && next.trigger('mouseleave.nav');
                    });

                });

                wrap.on('mouseleave', function(e){
                    next && next.trigger('mouseleave.nav');
                    $('> .nav', wrap).remove();
                });
            }
        };
    }])
    .directive('uiScroll', ['$location', '$anchorScroll', function($location, $anchorScroll) {
        return {
            restrict: 'AC',
            link: function(scope, el, attr) {
                el.on('click', function(e) {
                    $location.hash(attr.uiScroll);
                    $anchorScroll();
                });
            }
        };
    }])
    .directive('uiShift', ['$timeout', function($timeout) {
        return {
            restrict: 'A',
            link: function(scope, el, attr) {
                // get the $prev or $parent of this el
                var _el = $(el),
                    _window = $(window),
                    prev = _el.prev(),
                    parent,
                    width = _window.width()
                    ;

                !prev.length && (parent = _el.parent());

                function sm(){
                    $timeout(function () {
                        var method = attr.uiShift;
                        var target = attr.target;
                        _el.hasClass('in') || _el[method](target).addClass('in');
                    });
                }

                function md(){
                    parent && parent['prepend'](el);
                    !parent && _el['insertAfter'](prev);
                    _el.removeClass('in');
                }

                (width < 768 && sm()) || md();

                _window.resize(function() {
                    if(width !== _window.width()){
                        $timeout(function(){
                            (_window.width() < 768 && sm()) || md();
                            width = _window.width();
                        });
                    }
                });
            }
        };
    }])
    .directive('uiToggleClass', ['$timeout', '$document', function($timeout, $document) {
        return {
            restrict: 'AC',
            link: function(scope, el, attr) {
                el.on('click', function(e) {
                    e.preventDefault();
                    var classes = attr.uiToggleClass.split(','),
                        targets = (attr.target && attr.target.split(',')) || Array(el),
                        key = 0;
                    angular.forEach(classes, function( _class ) {
                        var target = targets[(targets.length && key)];
                        ( _class.indexOf( '*' ) !== -1 ) && magic(_class, target);
                        $( target ).toggleClass(_class);
                        key ++;
                    });
                    $(el).toggleClass('active');

                    function magic(_class, target){
                        var patt = new RegExp( '\\s' +
                            _class.
                            replace( /\*/g, '[A-Za-z0-9-_]+' ).
                            split( ' ' ).
                            join( '\\s|\\s' ) +
                            '\\s', 'g' );
                        var cn = ' ' + $(target)[0].className + ' ';
                        while ( patt.test( cn ) ) {
                            cn = cn.replace( patt, ' ' );
                        }
                        $(target)[0].className = $.trim( cn );
                    }
                });
            }
        };
    }])
    .directive("clickHide", ['$http',function ($http) {
        return {
            restrict: "A",
            link: function (scope, element, attrs) {
                var defaultHeight,height,flag = true;
                if(attrs.clickHide){
                    defaultHeight = attrs.clickHide*1;
                }else{
                    defaultHeight = 33;
                }
                $(element).click(function () {
                    if(flag){
                        flag = false;
                        var $this = $(this);
                        var ele = $(element).children().find('i');
                        if(ele.hasClass('glyphicon-chevron-up')){
                            setTimeout(function () {
                                $this.parent().css({"height":"auto"});
                                flag = true;
                                dataTableWidth();
                            },350);
                            $this.parent().css({"height": defaultHeight});
                            $this.next().removeClass('hidden');
                            height = $(this).next().height() + defaultHeight;
                            $this.parent().animate({"height": height},300);
                            ele.removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                        }else{
                            setTimeout(function () {
                                $this.next().addClass('hidden');
                                $this.parent().css({"height":"auto"});
                                flag = true;
                                dataTableWidth();
                            },350);
                            $this.parent().animate({"height": defaultHeight},300);
                            ele.removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                        }
                    }
                });
            }
        }
    }])
    .directive("inputCheckbox", ['$http','$filter',function ($http,$filter) {
        return {
            restrict : 'EA',
            replace : true,
            transclude : true,
            scope : {
                name : '@',
                value: '=value',
                form: '=form'
            },
            template : '<div class="checkbox" ng-repeat="a in dataList">'
            + '<label>'
            + '<input type="checkbox" name="{{$parent.name}}" value="{{a.codeValue}}" ng-model="a.checked" ng-click="$parent.checkboxValue(a.codeValue);" ng-checked="($parent.value | toArr).indexOf(a.codeValue) != -1">{{a.codeValueName}}'
            + '</label> </div>',
            link : function(scope, element, attrs) {
                scope.dataList = $filter('getList')(scope.name);
                scope.checkboxValue = function (value) {
                    console.log(value);
                    var item = scope.value.split(',');
                    var index = item.indexOf(value);
                    if(index==-1){
                        item.push(value);
                    }else{
                        item.splice(index,1);
                    }
                    scope.value = CommonStringUtils.arrToString(item);
                };
            }
        }
    }])
    .directive('numberFormat', ['$parse','$filter',function($parse,$filter) {
        var numberFilter = $filter('number');
        return {
            require: 'ngModel',
            link: function (scope, element, attrs, ngModelCtrl) {
                //控制输入框只能输入数字和小数点
                function limit(){
                    var limitV=element[0].value;
                    limitV=limitV.replace(/[^-0-9.]/g,"");
                    element[0].value=limitV;
                    $parse(attrs['ngModel']).assign(scope, limitV);
                    format();
                }

                //对输入数字的整数部分插入千位分隔符
                function format(){
                    var formatV=element[0].value;
                    var array=new Array();
                    array=formatV.split(".");
                    var re=/(-?\d+)(\d{3})/;
                    while(re.test(array[0])){
                        array[0]=array[0].replace(re,"$1,$2")
                    }
                    var returnV=array[0];
                    for(var i=1;i<array.length;i++){
                        returnV+="."+array[i];
                    }
                    element[0].value=returnV;
                    $parse(attrs['ngModel']).assign(scope, formatV);
                    //页面显示值转为model
                    ngModelCtrl.$parsers.unshift(function(){
                        element.val(numberFilter(element.val().replace(/[^0-9.]/g,"")));
                        return element.val().replace(/[^0-9.]/g,"");
                    });
                }
                scope.$watch(attrs.ngModel,function(newVal,oldVal){
                    limit();
                })
            }
        };
    }])
    .directive('limitNumber', ['$parse',function ($parse) {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function(scope, element, attr) {
                var changeFlag = false;
                if(attr.limitChange && attr.limitChange == 1){
                    changeFlag = true;
                }
                var num = attr.limitNumber;
                var maxNum;
                if(num){
                    maxNum = Math.pow(10,num)-1;
                }else{
                    maxNum = Math.pow(10,10)-1;
                }

                /*$(element).keyup(function () {
                   clearNoNum($(element));
                });*/
                scope.$watch(attr.ngModel,function(newVal,oldVal){
                    clearNoNum($(element));
                });

                function clearNoNum(obj){
                    var val = obj.val();
                    val = val.replace(/[^\d.]/g,"");//清除“数字”和“.”以外的字符
                    val = val.replace(/\.{2,}/g,".");//只保留第一个. 清除多余的
                    val = val.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
                    val = val.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数
                    //以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
                    if(val !=""){
                        var index = val.indexOf(".");
                        if(index <= 0){
                            val = parseFloat(val);
                        }else{
                            if((index+1) != val.length){
                                val = val*1;
                            }
                        }
                    }
                    if(val > maxNum){
                        val = maxNum;
                    }
                    $parse(attr['ngModel']).assign(scope, val);
                    obj.val(val);
                    if(changeFlag){
                        if(attr.ngChange){
                         scope.$eval(attr.ngChange);
                         }
                    }
                }
            }
        }
    }])
    .directive('limitWord', ['$timeout',function ($timeout) {
        return {
            restrict: 'A',
            link: function(scope, element, attr) {
                var num = attr.limitWord;
                if(!num){
                    num = 500;
                }
                $(element).attr('maxlength',num);
            }
        }
    }])
    .directive('clickTr',function () {
        return {
            restrict: 'A',
            link: function(scope, element, attr) {
                $(element).click(function () {
                    $(this).addClass('tr-bg');
                    $(this).siblings().removeClass('tr-bg');
                });
            }
        }
    })
    .directive('datePicker', ['$parse',function ($parse) {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function (scope, element, attr) {
                //WdatePicker参数
                var option = {
                    oncleared: getValue,
                    onpicked: getValue,
                    dateFmt: 'yyyy-MM-dd',
                    skin:'twoer',
                    autoUpdateOnChanged: true
                };

                var obj = attr.datePicker;
                if(obj){
                    obj = JSON.parse(obj);
                    option = $.extend(true,option,obj);
                }
                //屏蔽浏览器表单默认的记忆功能
                element.attr('autocomplete','off');
                //手动输入时更新ngModel
                element.on("input propertychange change", function () {
                    $parse(attr['ngModel']).assign(scope, element.val());
                });
                //插件点击时更新ngModel
                function getValue(dp) {
                    $(this).trigger('change');
                    $parse(attr['ngModel']).assign(scope,element.val());
                }
                //初始化
                element.bind('click', function () {
                    WdatePicker(option)
                });
            }
        };
    }])
    .directive('pressEnter',function () {
        return {
            restrict: 'A',
            link: function(scope, element, attr) {
                $(element).parents().find('.keyUp').keyup(function (e) {
                    if(e.keyCode==13){
                        if(attr.ngClick){
                            scope.$eval(attr.ngClick);
                        }
                    }
                });
            }
        }
    });
