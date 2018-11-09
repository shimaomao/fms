/**
 * Created by qiaohao on 2018/6/19.
 */
//自定义repeat完成指令
app.directive('repeatFinish',function($timeout){
    return {
        restrict: 'A',
        link: function(scope,elem,attr){
            //当前循环至最后一个
            if (scope.$last === true) {

                $timeout(function () {
                    //向父控制器传递事件消息
                    scope.$broadcast('repeatFinishCallback');
                },100);

            }
        }
    }
});