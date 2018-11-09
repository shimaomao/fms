'use strict';

/* Controllers */

angular.module('app')
  .controller('AppCtrl', ['$scope', '$translate', '$localStorage', '$window','$location','$rootScope',
    function($scope,$translate,$localStorage,$window,$location,$rootScope) {
      // add 'ie' classes to html
      var isIE = !!navigator.userAgent.match(/MSIE/i);
      isIE && angular.element($window.document.body).addClass('ie');
      isSmartDevice( $window ) && angular.element($window.document.body).addClass('smart');

      // config
      $scope.app = {
        name: '汽车金融平台',
        version: '1.3.3',
        // for chart colors
        color: {
          primary: '#7266ba',
          info:    '#23b7e5',
          success: '#27c24c',
          warning: '#fad733',
          danger:  '#f05050',
          light:   '#e8eff0',
          dark:    '#3a3f51',
          black:   '#1c2b36'
        },
      settings: {
          themeID: 8,
          navbarHeaderColor: 'bg-info dker',
          navbarCollapseColor: 'bg-info dker',
          asideColor: 'bg-light dker b-r',
          headerFixed: true,
          asideFixed: false,
          asideFolded: false,
          asideDock: false,
          container: false
        }
      }

      // save settings to local storage
      if ( angular.isDefined($localStorage.settings) ) {
        $scope.app.settings = $localStorage.settings;
      } else {
        $localStorage.settings = $scope.app.settings;
      }
      $scope.$watch('app.settings', function(){
        if( $scope.app.settings.asideDock  &&  $scope.app.settings.asideFixed ){
          // aside dock and fixed must set the header fixed.
          $scope.app.settings.headerFixed = true;
        }
        // save to local storage
        $localStorage.settings = $scope.app.settings;
      }, true);

      // angular translate
      $scope.lang = { isopen: false };
      $scope.langs = {en:'English', de_DE:'German', it_IT:'Italian'};
      $scope.selectLang = $scope.langs[$translate.proposedLanguage()] || "English";
      $scope.setLang = function(langKey, $event) {
        // set the current lang
        $scope.selectLang = $scope.langs[langKey];
        // You can change the language during runtime
        $translate.use(langKey);
        $scope.lang.isopen = !$scope.lang.isopen;
      };
      $translate.use("mycode");
      function isSmartDevice( $window )
      {
          // Adapted from http://www.detectmobilebrowsers.com
          var ua = $window['navigator']['userAgent'] || $window['navigator']['vendor'] || $window['opera'];
          // Checks for iOs, Android, Blackberry, Opera Mini, and Windows mobile devices
          return (/iPhone|iPod|iPad|Silk|Android|BlackBerry|Opera Mini|IEMobile/).test(ua);
      }


        if(CommonArrayUtils.vagueContains($location.url(),CommonRouterObjs.commonRouterFuzzyNames)){
            $scope.app.settings.headerFixed = false;
        }

        // if(   $location.url().indexOf('app/system') != -1){
        //     $scope.app.settings.headerFixed = false;
        // }


      

      var stateType = window.location.hash.split('/')[1];
      /*if(stateType == 'app'){
        $scope.app.overfllow = true;
      }else{
        $scope.app.overfllow = false;
      }*/
      $rootScope.iframeHeight = iframeHeight;
      //刷新时候   用户名消失
      if($localStorage.user){
        $rootScope.sysUserName = $localStorage.user.userName;
      }

      var http_url = window.location.href.split('#')[0];
      $scope.homeUrl = http_url + '/#/app/home';
  }]);