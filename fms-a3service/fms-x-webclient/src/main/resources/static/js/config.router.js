'use strict';

/**
 * Config for the router
 */
angular.module('app')
  .run(
    [          '$rootScope', '$state', '$stateParams','$location',
      function ($rootScope,   $state,   $stateParams,$location) {
          $rootScope.$state = $state;
          $rootScope.$stateParams = $stateParams;

          $rootScope.$on('$locationChangeStart', locationChangeStart);

          function locationChangeStart(event) {
              if($location.url()=="/access/signin"||$location.url()=="/access/signup") {
                  document.body.style.backgroundImage = "url('img/wl02.png')";
              }else{
                  document.body.style.backgroundImage = "";
              }
          }
      }
    ]
  )
  .config(
    [          '$stateProvider', '$urlRouterProvider',
      function ($stateProvider,   $urlRouterProvider) {

          $urlRouterProvider
              .otherwise('/access/signin');

          $stateProvider
              // .state('app', {
              //     abstract: true,
              //     url: '/app',
              //     templateUrl: 'tpl/app.html',
              //     resolve: {
              //         deps: ['$ocLazyLoad',
              //             function( $ocLazyLoad ){
              //                 return $ocLazyLoad.load([
              //                     'tpl/blocks/nav.js'+getCacheTime(),
              //                     'tpl/blocks/header_nav.js'+getCacheTime(),
              //                     'tpl/alert/alert.js'+getCacheTime(),
              //                     'tpl/alert/confirm.js'+getCacheTime()]);
              //             }]
              //     }
              // })
              // .state('app.dashboard-v1', {
              //     url: '/dashboard-v1',
              //     templateUrl: 'tpl/test.html',
              //     resolve: {
              //       deps: ['$ocLazyLoad',
              //         function( $ocLazyLoad ){
              //           return $ocLazyLoad.load(['js/controllers/chart.js']);
              //       }]
              //     }
              // })

              .state('app_tpl', {
                  abstract: true,
                  url: '/app_tpl',
                  templateUrl: 'tpl/app.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load([
                                  'tpl/blocks/nav.js'+getCacheTime(),
                                  'tpl/blocks/header_nav.js'+getCacheTime(),
                                  'vendor/jquery/bootstrap-dropdown-hover.js'+getCacheTime(),
                                  'tpl/alert/alert.js'+getCacheTime(),
                                  'tpl/alert/confirm.js'+getCacheTime()]);
                          }]
                  }
              })
              .state('app_tpl.dashboard-v1', {
                  url: '/dashboard-v1',
                  templateUrl: 'tpl/home.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/chart.js']);
                          }]
                  }
              })
              .state('app', {
                  abstract: true,
                  url: '/app',
                  template: '<div ui-view></div>',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load([
                                  'tpl/alert/alert.js'+getCacheTime(),
                                  'tpl/alert/confirm.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list_directive.js'+getCacheTime(),]);
                          }]
                  }
              })
              .state('app.home',{
                  url: '/home',
                  templateUrl: 'tpl/home/home.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/activiti/act_ru_task/act_ru_task_list.js'+getCacheTime(),
                                  'tpl/activiti/act_ru_task/act_ru_task_complete_test.js'+getCacheTime(),
                                  'tpl/home/home.js',
                                  'tpl/home/desk.js'
                                  ,'tpl/activiti/act_ru_task/act_ru_task_list_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //用户管理
              .state('app.system_sys_user_list', {
                  url: '/system_sys_user_list',
                  templateUrl: 'tpl/system/sys_user/sys_user_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user/sys_user_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //新增用户
              .state('app.system_sys_user_save', {
                  url: '/system_sys_user_save',
                  templateUrl: 'tpl/system/sys_user/sys_user_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user/sys_user_save.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_role/sys_role_list_select.js'+getCacheTime()

                              ]);
                          }]
                  }
              })
              //修改用户
              .state('app.system_sys_user_modify', {
                  url: '/system_sys_user_modify',
                  templateUrl: 'tpl/system/sys_user/sys_user_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user/sys_user_modify.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_role/sys_role_list_select.js'+getCacheTime()

                              ]);
                          }]
                  }
              })
              //用户详情
              .state('app.system_sys_user_detail', {
                  url: '/system_sys_user_detail',
                  templateUrl: 'tpl/system/sys_user/sys_user_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user/sys_user_detail.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_role/sys_role_list_select.js'+getCacheTime()

                              ]);
                          }]
                  }
              })
              //合同生成
              .state('app.prebiz_cont_create', {
                  url: '/prebiz_cont_create',
                  templateUrl: 'tpl/prebiz/cont_create/cont_create.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_create/cont_create.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/license_idx/license_idx.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同信息测试
              .state('app.prebiz_contract_finance', {
                  url: '/prebiz_contract_finance',
                  templateUrl: 'tpl/prebiz/contract_finance/contract_finance_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/contract_finance/contract_finance_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同一览查询
              .state('app.prebiz_contract_list', {
                  url: '/prebiz_contract_list',
                  templateUrl: 'tpl/prebiz/contract/contract_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/contract/contract_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //新增放款车辆明细一览查询
              .state('app.prebiz_new_loan_list', {
                  url: '/prebiz_new_loan_list',
                  templateUrl: 'tpl/prebiz/new_loan/new_loan_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/new_loan/new_loan_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //客户还款信息一览查询
              .state('app.prebiz_cont_repay_account_list', {
                  url: '/prebiz_cont_repay_account_list',
                  templateUrl: 'tpl/prebiz/cont_repay_account/cont_repay_account_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_repay_account/cont_repay_account_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 客户还款信息修改
              .state('app.prebiz_cont_repay_account_modify', {
                  url: '/prebiz_cont_repay_account_modify',
                  templateUrl: 'tpl/prebiz/cont_repay_account/cont_repay_account_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_repay_account/cont_repay_account_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //经销商请款
              .state('app.prebiz_cont_request_pay', {
                  url: '/prebiz_cont_request_pay',
                  templateUrl: 'tpl/prebiz/cont_request_pay/cont_request_pay.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_request_pay/cont_request_pay.js'+getCacheTime(),
                                              'tpl/prebiz/cont_create/cont_create_detail.js'+getCacheTime(),
                                              'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                              'js/fileinput/fileinput.min.js'+getCacheTime(),
                                              'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                              'css/fileinput/fileinput.min.css'+getCacheTime(),
                                              'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                              'tpl/common/file/file_list.js'+getCacheTime(),
                                              'tpl/common/file/file_upload.js'+getCacheTime(),
                                              'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                              'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                              'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                              //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                              'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                              'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                              'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                                              'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime()

                              ]);
                          }]
                  }
              })
              //贷前确认收款
              .state('app.prebiz_cont_charge',{
                      url: '/prebiz_cont_charge',
                      templateUrl: 'tpl/prebiz/cont_receipt_pay/cont_charge.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/prebiz/cont_receipt_pay/cont_charge.js'+getCacheTime(),
                                      'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //贷前财务制单
              .state('app.prebiz_cont_make_voucher',{
                      url: '/prebiz_cont_make_voucher',
                      templateUrl: 'tpl/prebiz/cont_receipt_pay/cont_make_voucher.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/prebiz/cont_receipt_pay/cont_make_voucher.js'+getCacheTime(),
                                      'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //贷前财务付款
              .state('app.prebiz_receipt_cont_payment',{
                      url: '/prebiz_receipt_cont_payment',
                      templateUrl: 'tpl/prebiz/cont_receipt_pay/cont_payment.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/prebiz/cont_receipt_pay/cont_payment.js'+getCacheTime(),
                                      'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              .state('app.updatePassWord', {
                  url: '/updatePassWord',
                  templateUrl: 'tpl/page_updatePSW.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['tpl/page_updatePSW.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //角色管理
              .state('app.system_sys_role_list', {
                  url: '/system_sys_role_list',
                  templateUrl: 'tpl/system/sys_role/sys_role_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role/sys_role_list.js?datetime='+getTimestamp(),
                              ]);
                          }]
                  }
              })
              //新添角色
              .state('app.system_sys_role_save', {
                  url: '/system_sys_role_save',
                  templateUrl: 'tpl/system/sys_role/sys_role_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role/sys_role_save.js?datetime='+getTimestamp(),
                              ]);
                          }]
                  }
              })
              //修改角色
              .state('app.system_sys_role_modify', {
                  url: '/system_sys_role_modify',
                  templateUrl: 'tpl/system/sys_role/sys_role_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role/sys_role_modify.js?datetime='+getTimestamp(),
                              ]);
                          }]
                  }
              })
              //角色详情
              .state('app.system_sys_role_detail', {
                  url: '/system_sys_role_detail',
                  templateUrl: 'tpl/system/sys_role/sys_role_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role/sys_role_detail.js?datetime='+getTimestamp(),
                              ]);
                          }]
                  }
              })

              // 用户组层级管理
              .state('app.system_sys_group_level_list', {
                  url: '/system_sys_group_level_list',
                  templateUrl: 'tpl/system/sys_group_level/sys_group_level_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group_level/sys_group_level_list.js'+getCacheTime() ]);
                          }]
                  }
              })

              // 用户组层级管理 添加
              .state('app.system_sys_group_level_save', {
                  url: '/system_sys_group_level_save',
                  templateUrl: 'tpl/system/sys_group_level/sys_group_level_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group_level/sys_group_level_save.js'+getCacheTime() ]);
                          }]
                  }
              })
              // 用户组层级管理 修改
              .state('app.system_sys_group_level_modify', {
                  url: '/system_sys_group_level_modify',
                  templateUrl: 'tpl/system/sys_group_level/sys_group_level_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group_level/sys_group_level_modify.js'+getCacheTime() ]);
                          }]
                  }
              })
              // 用户组层级管理 详情
              .state('app.system_sys_group_level_detail', {
                  url: '/system_sys_group_level_detail',
                  templateUrl: 'tpl/system/sys_group_level/sys_group_level_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group_level/sys_group_level_detail.js'+getCacheTime() ]);
                          }]
                  }
              })

              //数据字典数值
              .state('app.system_code_list', {
                  url: '/system_code_list',
                  templateUrl: 'tpl/system/sys_code/sys_code_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_code/sys_code_list.js'+getCacheTime(),
                                  'tpl/system/sys_code/sys_code_handler.js'+getCacheTime(),
                                  'tpl/system/sys_code_type/sys_code_type_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //经销商list
              .state('app.baseinfo_bas_partner_list', {
                  url: '/baseinfo_bas_partner_list',
                  templateUrl: 'tpl/baseinfo/bas_partner/bas_partner_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_partner/bas_partner_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 经销商信息管理 编辑：添加、修改、详情
              .state('app.baseinfo_bas_partner_handler', {
                  url: '/baseinfo_bas_partner_handler',
                  templateUrl: 'tpl/baseinfo/bas_partner/bas_partner_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_partner/bas_partner_handler.js'+getCacheTime(),
                                  'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_group_level/sys_group_level_list_select.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 经销商信息详情
              .state('app.baseinfo_bas_partner_detail', {
                  url: '/baseinfo_bas_partner_detail',
                  templateUrl: 'tpl/baseinfo/bas_partner/bas_partner_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_partner/bas_partner_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //还款日规则管理
              .state('app.baseinfo_bas_repay_rule_list', {
                  url: '/baseinfo_bas_repay_rule_list',
                  templateUrl: 'tpl/baseinfo/bas_repay_rule/bas_repay_rule_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_repay_rule/bas_repay_rule_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 还款日规则管理 编辑：添加、修改、详情
              .state('app.baseinfo_bas_repay_rule_handler', {
                  url: '/baseinfo_bas_repay_rule_handler',
                  templateUrl: 'tpl/baseinfo/bas_repay_rule/bas_repay_rule_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_repay_rule/bas_repay_rule_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 数据字典数值管理 编辑：添加、修改、详情
                 .state('app.system_code_handler', {
                  url: '/system_code_handler',
                  templateUrl: 'tpl/system/sys_code/sys_code_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_code/sys_code_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 数据字典类型管理 编辑：添加、修改、详情
              .state('app.system_code_type_handler', {
                  url: '/system_code_type_handler',
                  templateUrl: 'tpl/system/sys_code_type/sys_code_type_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_code_type/sys_code_type_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //数据字典类型
              .state('app.system_code_type_list', {
                  url: '/system_code_type_list',
                  templateUrl: 'tpl/system/sys_code_type/sys_code_type_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_code_type/sys_code_type_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 画面控件管理
              .state('app.sys_widget_list', {
                  url: '/sys_widget_list',
                  templateUrl: 'tpl/system/sys_widget/sys_widget_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_widget/sys_widget_list.js'+getCacheTime(),
                                  'tpl/system/sys_widget/sys_widget_detail.js'+getCacheTime(),
                                  'tpl/system/sys_widget_attribute/sys_widget_attribute_list.js'+getCacheTime(),
                                  'tpl/system/sys_widget_attribute/sys_widget_attribute_handler.js'+getCacheTime(),
                                  'tpl/system/sys_widget/sys_widget_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 用户组管理
              .state('app.system_sys_group_list', {
                  url: '/system_sys_group_list',
                  templateUrl: 'tpl/system/sys_group/sys_group_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group/sys_group_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 用户组管理 添加
              .state('app.system_sys_group_save', {
                  url: '/system_sys_group_save',
                  templateUrl: 'tpl/system/sys_group/sys_group_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group/sys_group_save.js'+getCacheTime(),
                                  'tpl/system/sys_group_level/sys_group_level_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })// 用户组管理 修改
              .state('app.system_sys_group_modify', {
                  url: '/system_sys_group_modify',
                  templateUrl: 'tpl/system/sys_group/sys_group_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group/sys_group_modify.js'+getCacheTime(),
                                  'tpl/system/sys_group_level/sys_group_level_list_select.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 用户组管理 详情
              .state('app.system_sys_group_detail', {
                  url: '/system_sys_group_detail',
                  templateUrl: 'tpl/system/sys_group/sys_group_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_group/sys_group_detail.js'+getCacheTime()]);
                          }]
                  }
              })
              //工作台
              .state('app.desk',{
                  url: '/desk',
                  templateUrl: 'tpl/home/desk.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/home/desk..js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //工作流模型管理
              .state('app.activiti_act_re_model_list',{
                  url: '/activiti_act_re_model_list',
                  templateUrl: 'tpl/activiti/act_re_model/act_re_model_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/activiti/act_re_model/act_re_model_list.js'+getCacheTime(),
                                  'tpl/activiti/act_re_model/act_re_model_save.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //流程定义管理
              .state('app.activiti_act_re_procdef_list',{
                  url: '/activiti_act_re_procdef_list',
                  templateUrl: 'tpl/activiti/act_re_procdef/act_re_procdef_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/activiti/act_re_procdef/act_re_procdef_list.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })

              //我的请假
              .state('app.activiti_act_user_leave_list',{
                  url: '/activiti_act_user_leave_list',
                  templateUrl: 'tpl/activiti/act_user_leave/act_user_leave_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/activiti/act_user_leave/act_user_leave_list.js'+getCacheTime(),
                                  'tpl/activiti/act_user_leave/act_user_leave_save.js'+getCacheTime(),
                                  'tpl/activiti/act_user_leave/act_user_leave_modify.js'+getCacheTime(),
                                  'tpl/activiti/act_user_leave/act_user_leave_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //我的任务
              .state('app.activiti_act_ru_task_list',{
                  url: '/activiti_act_ru_task_list',
                  templateUrl: 'tpl/activiti/act_ru_task/act_ru_task_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/activiti/act_ru_task/act_ru_task_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //省市县信息维护
              .state('app.baseinfo_bas_area_list', {
                  url: '/baseinfo_bas_area_list',
                  templateUrl: 'tpl/baseinfo/bas_area/bas_area_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_area/bas_area_list.js'+getCacheTime()
                                  // 'tpl/system/bas_area/bas_area_save.js'+getCacheTime(),
                                  //  'tpl/system/bas_area/bas_area_modify.js'+getCacheTime(),
                                  // 'tpl/system/bas_area/bas_area_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //省市县信息维护 添加
              .state('app.baseinfo_bas_area_save', {
                  url: '/baseinfo_bas_area_save',
                  templateUrl: 'tpl/baseinfo/bas_area/bas_area_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_area/bas_area_save.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_area/bas_area_select_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //省市县信息维护 修改
              .state('app.baseinfo_bas_area_modify', {
                  url: '/baseinfo_bas_area_modify',
                  templateUrl: 'tpl/baseinfo/bas_area/bas_area_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_area/bas_area_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //省市县信息维护 详情
              .state('app.baseinfo_bas_area_detail', {
                  url: '/baseinfo_bas_area_detail',
                  templateUrl: 'tpl/baseinfo/bas_area/bas_area_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_area/bas_area_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //产品大类维护
              .state('app.product_product_catg_list', {
                  url: '/product_product_catg_list',
                  templateUrl: 'tpl/product/product_catg/product_catg_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product_catg/product_catg_list.js'+getCacheTime(),
                                  //   'tpl/system/product_catg/product_catg_save.js'+getCacheTime(),
                                  //  'tpl/system/product_catg/product_catg_modify.js'+getCacheTime(),
                                  //   'tpl/system/product_catg/product_catg_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 产品大类维护 添加
              .state('app.product_product_catg_save', {
                  url: '/product_product_catg_save',
                  templateUrl: 'tpl/product/product_catg/product_catg_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product_catg/product_catg_save.js'+getCacheTime()
                                  // , 'tpl/system/product_catg/product_catg_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              .state('app.product_product_catg_modify', {
                  url: '/product_product_catg_modify',
                  templateUrl: 'tpl/product/product_catg/product_catg_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product_catg/product_catg_modify.js'+getCacheTime()

                              ]);
                          }]
                  }
              })
              // 产品大类维护 详情
              .state('app.product_product_catg_detail', {
                  url: '/product_product_catg_detail',
                  templateUrl: 'tpl/product/product_catg/product_catg_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product_catg/product_catg_detail.js'+getCacheTime()]);
                          }]
                  }
              })
              // 融资费用管理
              .state('app.product_fin_item_list', {
                  url: '/product_fin_item_list',
                  templateUrl: 'tpl/product/fin_item/fin_item_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/fin_item/fin_item_list.js'+getCacheTime()
                                  //    'tpl/system/fin_item/fin_item_save.js'+getCacheTime(),
                                  //   'tpl/system/fin_item/fin_item_modify.js'+getCacheTime(),
                                  //   'tpl/system/fin_item/fin_item_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 融资费用管理 添加
              .state('app.product_fin_item_save', {
                  url: '/product_fin_item_save',
                  templateUrl: 'tpl/product/fin_item/fin_item_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/fin_item/fin_item_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 融资费用管理 修改
              .state('app.product_fin_item_modify', {
                  url: '/product_fin_item_modify',
                  templateUrl: 'tpl/product/fin_item/fin_item_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/fin_item/fin_item_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 融资费用管理 详情
              .state('app.product_fin_item_detail', {
                  url: '/product_fin_item_detail',
                  templateUrl: 'tpl/product/fin_item/fin_item_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/fin_item/fin_item_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 产品中心
              .state('app.product_product_center', {
                  url: '/product_product_center',
                  templateUrl: 'tpl/product/product/product_center.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product/product_center.js'+getCacheTime(),
                                  'tpl/product/product/product_intrst.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_vehicle/bas_vehicle_list_level_select.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_file_type/bas_file_type_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 产品方案一览
              .state('app.product_product_list', {
                  url: '/product_product_list',
                  templateUrl: 'tpl/product/product/product_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product/product_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //产品方案预览
              .state('app.product_product_detail', {
                  url: '/product_product_detail',
                  templateUrl  : 'tpl/product/product/product_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/product/product_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //车辆信息维护 添加
              .state('app.baseinfo_bas_vehicle_save', {
                  url: '/baseinfo_bas_vehicle_save',
                  templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_vehicle/bas_vehicle_save.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_vehicle/bas_vehicle_list_level_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //车辆信息维护 修改
              .state('app.baseinfo_bas_vehicle_modify', {
                  url: '/baseinfo_bas_vehicle_modify',
                  templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_vehicle/bas_vehicle_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_vehicle/bas_vehicle_list_level_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //车辆信息维护 详情
              .state('app.baseinfo_bas_vehicle_detail', {
                  url: '/baseinfo_bas_vehicle_detail',
                  templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_vehicle/bas_vehicle_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //车辆信息维护
              .state('app.baseinfo_bas_vehicle_list', {
                  url: '/baseinfo_bas_vehicle_list',
                  templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_vehicle/bas_vehicle_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              .state('access', {
                  url: '/access',
                  template: '<div ui-view class="fade-in-right-big smooth"></div>'
              })
              .state('access.signin', {
                  url: '/signin',
                  templateUrl: 'tpl/page_signin.html'+getCacheTime(),
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['tpl/page_signin.js'+getCacheTime()] );
                      }]
                  }
              })
              .state('access.signup', {
                  url: '/signup',
                  templateUrl: 'tpl/page_signup.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['tpl/page_signup.js'+getCacheTime()] );
                      }]
                  }
              })
              // 合同生成前确认
              .state('app.prebiz_cont_confirm_bef', {
                  url: '/prebiz_cont_confirm_bef',
                  templateUrl: 'tpl/prebiz/cont_confirm_bef/cont_confirm_bef.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_confirm_bef/cont_confirm_bef.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 合同打印
              .state('app.prebiz_cont_print', {
                  url: '/prebiz_cont_print',
                  templateUrl: 'tpl/prebiz/cont_print/cont_print.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_print/cont_print.js'+getCacheTime(),
                                  'tpl/prebiz/cont_print/cont_print_detail.js'+getCacheTime(),
                                  'tpl/prebiz/cont_create/cont_create_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 合同资管
              .state('app.prebiz_cont_qualification', {
                  url: '/prebiz_cont_qualification',
                  templateUrl: 'tpl/prebiz/cont_qualification/cont_qualification.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_qualification/cont_qualification.js'+getCacheTime(),
                                  'tpl/prebiz/cont_qualification/cont_qualification_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 申请一览
              .state('app.prebiz_apply_list', {
                  url: '/prebiz_apply_list',
                  templateUrl: 'tpl/prebiz/apply/apply_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply/apply_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 申请信息一览
              .state('app.prebiz_apply_list_search', {
                  url: '/prebiz_apply_list_search',
                  templateUrl: 'tpl/prebiz/apply/apply_list_search.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply/apply_list_search.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 短信模板类型管理
              .state('app.system_sys_tpl_type_msg_list', {
                  url: '/system_sys_tpl_type_msg_list',
                  templateUrl: 'tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板类型管理 添加
              .state('app.system_sys_tpl_type_msg_save', {
                  url: '/system_sys_tpl_type_msg_save',
                  templateUrl: 'tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_save.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_item/sys_tpl_item_add.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板类型管理 修改
              .state('app.system_sys_tpl_type_msg_modify', {
                  url: '/system_sys_tpl_type_msg_modify',
                  templateUrl: 'tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_modify.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_item/sys_tpl_item_add.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板类型管理 详情
              .state('app.system_sys_tpl_type_msg_detail', {
                  url: '/system_sys_tpl_type_msg_detail',
                  templateUrl: 'tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_msg/sys_tpl_type_msg_detail.js'+getCacheTime()]);
                          }]
                  }
              })
              // 短信模板管理
              .state('app.system_sys_tpl_msg_list', {
                  url: '/system_sys_tpl_msg_list',
                  templateUrl: 'tpl/system/sys_tpl_msg/sys_tpl_msg_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_msg/sys_tpl_msg_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板管理 添加
              .state('app.system_sys_tpl_msg_save', {
                  url: '/system_sys_tpl_msg_save',
                  templateUrl: 'tpl/system/sys_tpl_msg/sys_tpl_msg_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_msg/sys_tpl_msg_save.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_type_msg/sys_tpl_type_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板管理 修改
              .state('app.system_sys_tpl_msg_modify', {
                  url: '/system_sys_tpl_msg_modify',
                  templateUrl: 'tpl/system/sys_tpl_msg/sys_tpl_msg_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_msg/sys_tpl_msg_modify.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_type_msg/sys_tpl_type_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 短信模板管理 详情
              .state('app.system_sys_tpl_msg_detail', {
                  url: '/system_sys_tpl_msg_detail',
                  templateUrl: 'tpl/system/sys_tpl_msg/sys_tpl_msg_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_msg/sys_tpl_msg_detail.js'+getCacheTime()]);
                          }]
                  }
              })

              // 合同模板类型管理
              .state('app.system_sys_tpl_type_contract_list', {
                  url: '/system_sys_tpl_type_contract_list',
                  templateUrl: 'tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板类型管理 添加
              .state('app.system_sys_tpl_type_contract_save', {
                  url: '/system_sys_tpl_type_contract_save',
                  templateUrl: 'tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_save.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_item/sys_tpl_item_add.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板类型管理 修改
              .state('app.system_sys_tpl_type_contract_modify', {
                  url: '/system_sys_tpl_type_contract_modify',
                  templateUrl: 'tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_modify.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_item/sys_tpl_item_add.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板类型管理 详情
              .state('app.system_sys_tpl_type_contract_detail', {
                  url: '/system_sys_tpl_type_contract_detail',
                  templateUrl: 'tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_type_contract/sys_tpl_type_contract_detail.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_item/sys_tpl_item_add.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板管理
              .state('app.system_sys_tpl_contract_list', {
                  url: '/system_sys_tpl_contract_list',
                  templateUrl: 'tpl/system/sys_tpl_contract/sys_tpl_contract_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_contract/sys_tpl_contract_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板管理 添加
              .state('app.system_sys_tpl_contract_save', {
                  url: '/system_sys_tpl_contract_save',
                  templateUrl: 'tpl/system/sys_tpl_contract/sys_tpl_contract_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_contract/sys_tpl_contract_save.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_type_msg/sys_tpl_type_list_select.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板管理 修改
              .state('app.system_sys_tpl_contract_modify', {
                  url: '/system_sys_tpl_contract_modify',
                  templateUrl: 'tpl/system/sys_tpl_contract/sys_tpl_contract_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_contract/sys_tpl_contract_modify.js'+getCacheTime()
                                  , 'tpl/system/sys_tpl_type_msg/sys_tpl_type_list_select.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 合同模板管理 详情
              .state('app.system_sys_tpl_contract_detail', {
                  url: '/system_sys_tpl_contract_detail',
                  templateUrl: 'tpl/system/sys_tpl_contract/sys_tpl_contract_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_tpl_contract/sys_tpl_contract_detail.js'+getCacheTime()]);
                          }]
                  }
              })

              // 菜单管理
              .state('app.system_sys_menu_list', {
                  url: '/system_sys_menu_list',
                  templateUrl: 'tpl/system/sys_menu/sys_menu_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_menu/sys_menu_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //新增菜单
              .state('app.system_sys_menu_save', {
                  url: '/system_sys_menu_save',
                  templateUrl: 'tpl/system/sys_menu/sys_menu_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_menu/sys_menu_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //修改菜单
              .state('app.system_sys_menu_modify', {
                  url: '/system_sys_menu_modify',
                  templateUrl: 'tpl/system/sys_menu/sys_menu_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_menu/sys_menu_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              // 菜单详情
              .state('app.system_sys_menu_detail', {
                  url: '/system_sys_menu_detail',
                  templateUrl: 'tpl/system/sys_menu/sys_menu_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_menu/sys_menu_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //角色菜单树管理
              .state('app.system_sys_role_menu_list', {
                  url: '/system_sys_role_menu_list',
                  templateUrl: 'tpl/system/sys_role_menu/sys_role_menu_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role_menu/sys_role_menu_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //角色菜单分配
              .state('app.system_sys_role_menu_set', {
                  url: '/system_sys_role_menu_set',
                  templateUrl: 'tpl/system/sys_role_menu/sys_role_menu_set.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_role_menu/sys_role_menu_set.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //用户菜单树
              .state('app.system_sys_user_menu_list', {
                  url: '/system_sys_user_menu_list',
                  templateUrl: 'tpl/system/sys_user_menu/sys_user_menu_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user_menu/sys_user_menu_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //用户菜单分配
              .state('app.system_sys_user_menu_set', {
                  url: '/system_sys_user_menu_set',
                  templateUrl: 'tpl/system/sys_user_menu/sys_user_menu_set.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_user_menu/sys_user_menu_set.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //附件类型管理
              .state('app.baseinfo_bas_file_type_list', {
                  url: '/baseinfo_bas_file_type_list',
                  templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_file_type/bas_file_type_list.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_file_type/bas_file_type_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

             /* // 附件类型管理 编辑：添加、修改
              .state('app.baseinfo_bas_file_type_handler', {
                  url: '/baseinfo_bas_file_type_handler',
                  templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_file_type/bas_file_type_handler.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_file_type/bas_file_type_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })*/

              // 附件类型管理增加
              .state('app.baseinfo_bas_file_type_save', {
                  url: '/baseinfo_bas_file_type_save',
                  templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_file_type/bas_file_type_save.js'+getCacheTime()

                              ]);
                          }]
                  }
              })

              // 附件类型管理修改
              .state('app.baseinfo_bas_file_type_modify', {
                  url: '/baseinfo_bas_file_type_modify',
                  templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_file_type/bas_file_type_modify.js'+getCacheTime()

                              ]);
                          }]
                  }
              })

              // 附件类型管理详情
              .state('app.baseinfo_bas_file_type_detail', {
                  url: '/baseinfo_bas_file_type_detail',
                  templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_file_type/bas_file_type_detail.js'+getCacheTime()

                              ]);
                          }]
                  }
              })

              //银行账号维护
              .state('app.baseinfo_bas_bank_info_list', {
                  url: '/baseinfo_bas_bank_info_list',
                  templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_bank_info/bas_bank_info_list.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 银行账号维护 编辑：添加、修改
              .state('app.baseinfo_bas_bank_info_handler', {
                  url: '/baseinfo_bas_bank_info_handler',
                  templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_bank_info/bas_bank_info_handler.js'+getCacheTime(),
                                  'tpl/system/sys_group/sys_group_list_select.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_sales/bas_sales_list_select.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime(),
                                  'tpl/postbiz/car_collect_comp/car_collect_comp_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),

                              ]);
                          }]
                  }
              })


              // 银行账号维护详情
              .state('app.baseinfo_bas_bank_info_detail', {
                  url: '/baseinfo_bas_bank_info_detail',
                  templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_bank_info/bas_bank_info_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 银行账号维护审核
              .state('app.baseinfo_bas_bank_info_approve', {
                  url: '/baseinfo_bas_bank_info_approve',
                  templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_bank_info/bas_bank_info_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //黑名单管理List画面
              .state('app.baseinfo_bas_blacklist_list', {
                  url: '/baseinfo_bas_blacklist_list',
                  templateUrl: 'tpl/baseinfo/bas_blacklist/bas_blacklist_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_blacklist/bas_blacklist_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 黑名单管理 编辑：添加、修改
              .state('app.baseinfo_bas_blacklist_handler', {
                  url: '/baseinfo_bas_blacklist_handler',
                  templateUrl: 'tpl/baseinfo/bas_blacklist/bas_blacklist_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_blacklist/bas_blacklist_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 黑名单详情
              .state('app.baseinfo_bas_blacklist_detail', {
                  url: '/baseinfo_bas_blacklist_detail',
                  templateUrl: 'tpl/baseinfo/bas_blacklist/bas_blacklist_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_blacklist/bas_blacklist_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //实际销售方一览
              .state('app.baseinfo_bas_sales_list', {
                  url: '/baseinfo_bas_sales_list',
                  templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_sales/bas_sales_list.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 实际销售方添加
              .state('app.baseinfo_bas_sales_save', {
                  url: '/baseinfo_bas_sales_save',
                  templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_sales/bas_sales_save.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 实际销售方修改
              .state('app.baseinfo_bas_sales_modify', {
                  url: '/baseinfo_bas_sales_modify',
                  templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_sales/bas_sales_modify.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })



              //实际销售方详情
              .state('app.baseinfo_bas_sales_detail', {
                  url: '/baseinfo_bas_sales_detail',
                  templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_sales/bas_sales_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              //实际销售方审核
              .state('app.baseinfo_bas_sales_approve', {
                  url: '/baseinfo_bas_sales_approve',
                  templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_sales/bas_sales_approve.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })




              // 融资申请取消
              .state('app.prebiz_apply_cancel_list', {
                  url: '/prebiz_apply_cancel_list',
                  templateUrl: 'tpl/prebiz/apply_cancel/apply_cancel_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_cancel/apply_cancel_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 融资申请取消操作
              .state('app.prebiz_apply_cancel_handler', {
                  url: '/prebiz_apply_cancel_handler',
                  templateUrl: 'tpl/prebiz/apply_cancel/apply_cancel_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_cancel/apply_cancel_handler.js'+getCacheTime()

                              ]);
                          }]
                  }
              })


              // 融资合同取消
              .state('app.prebiz_contract_cancel_list', {
                  url: '/prebiz_contract_cancel_list',
                  templateUrl: 'tpl/prebiz/contract_cancel/contract_cancel_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/contract_cancel/contract_cancel_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 融资合同取消操作
              .state('app.prebiz_contract_cancel_handler', {
                  url: '/prebiz_contract_cancel_handler',
                  templateUrl: 'tpl/prebiz/contract_cancel/contract_cancel_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/contract_cancel/contract_cancel_handler.js'+getCacheTime()

                              ]);
                          }]
                  }
              })


              // 短信发送管理
              .state('app.baseinfo_bas_msg_list', {
                  url: '/baseinfo_bas_msg_list',
                  templateUrl: 'tpl/baseinfo/bas_msg/bas_msg_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_msg/bas_msg_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 短信发送管理 编辑：添加、修改、详情
              .state('app.baseinfo_bas_msg_handler', {
                  url: '/baseinfo_bas_msg_handler',
                  templateUrl: 'tpl/baseinfo/bas_msg/bas_msg_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/baseinfo/bas_msg/bas_msg_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 系统常量维护
              .state('app.system_sys_param_list', {
                  url: '/system_sys_param_list',
                  templateUrl: 'tpl/system/sys_param/sys_param_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_param/sys_param_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

             /* // 系统常量维护 编辑：添加、修改
              .state('app.system_sys_param_handler', {
                  url: '/system_sys_param_handler',
                  templateUrl: 'tpl/system/sys_param/sys_param_handler.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_param/sys_param_handler.js'+getCacheTime()
                              ]);
                          }]
                  }
              })*/

              // 系统常量维护添加
              .state('app.system_sys_param_save', {
                  url: '/system_sys_param_save',
                  templateUrl: 'tpl/system/sys_param/sys_param_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_param/sys_param_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 系统常量维护修改
              .state('app.system_sys_param_modify', {
                  url: '/system_sys_param_modify',
                  templateUrl: 'tpl/system/sys_param/sys_param_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_param/sys_param_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })



              // 系统常量维护详情
              .state('app.system_sys_param_detail', {
                  url: '/system_sys_param_detail',
                  templateUrl: 'tpl/system/sys_param/sys_param_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_param/sys_param_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 逾期状态维护
              .state('app.postbiz_overdue_condition_list', {
                  url: '/postbiz_overdue_condition_list',
                  templateUrl: 'tpl/postbiz/overdue_condition/overdue_condition_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_condition/overdue_condition_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 逾期状态维护添加
              .state('app.postbiz_overdue_condition_save', {
                  url: '/postbiz_overdue_condition_save',
                  templateUrl: 'tpl/postbiz/overdue_condition/overdue_condition_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_condition/overdue_condition_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 逾期状态维护修改
              .state('app.postbiz_overdue_condition_modify', {
                  url: '/postbiz_overdue_condition_modify',
                  templateUrl: 'tpl/postbiz/overdue_condition/overdue_condition_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_condition/overdue_condition_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })



              // 逾期状态维护详情
              .state('app.postbiz_overdue_condition_detail', {
                  url: '/postbiz_overdue_condition_detail',
                  templateUrl: 'tpl/postbiz/overdue_condition/overdue_condition_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_condition/overdue_condition_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //逾期任务分配
              .state('app.postbiz_overdue_rwfp', {
                  url: '/postbiz_overdue_rwfp',
                  templateUrl: 'tpl/postbiz/overdue_cstm/overdue_rwfp.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_cstm/overdue_rwfp.js'+getCacheTime(),
                                  'tpl/postbiz/collection_person/sys_collection_person_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 保险理赔一览
              .state('app.insurance_cont_insur_claim_list', {
                  url: '/insurance_cont_insur_claim_list',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 保险理赔查询
              .state('app.insurance_cont_insur_claim_list_query', {
                  url: '/insurance_cont_insur_claim_list_query',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_list_query.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_list_query.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 续保任务一览
              .state('app.insurance_renewal_register_list', {
                  url: '/insurance_renewal_register_list',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //续保上传
              .state('app.insurance_renewal_register_save', {
                  url: '/insurance_renewal_register_save',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //续保确认收款
              .state('app.insurance_renewal_register_receipt', {
                  url: '/insurance_renewal_register_receipt',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_receipt.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_receipt.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //续保请款
              .state('app.insurance_renewal_register_withdraw', {
                  url: '/insurance_renewal_register_withdraw',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_withdraw.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_withdraw.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //续保制单
              .state('app.insurance_renewal_register_voucher', {
                  url: '/insurance_renewal_register_voucher',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_voucher.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //续保财务付款
              .state('app.insurance_renewal_register_payment', {
                  url: '/insurance_renewal_register_payment',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_payment.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //续保资管确认客户类型
              .state('app.insurance_renewal_register_confirm', {
                  url: '/insurance_renewal_register_confirm',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_confirm.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //续保信息详情
              .state('app.insurance_renewal_register_detail', {
                  url: '/insurance_renewal_register_detail',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/renewal_register/renewal_register_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //续保审核
              .state('app.insurance_renewal_register_review',{
                  url: '/insurance_renewal_register_review',
                  templateUrl: 'tpl/insurance/renewal_register/renewal_register_review.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/insurance/renewal_register/renewal_register_review.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 收车机构一览
              .state('app.postbiz_car_collect_comp_list', {
                  url: '/postbiz_car_collect_comp_list',
                  templateUrl: 'tpl/postbiz/car_collect_comp/car_collect_comp_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/car_collect_comp/car_collect_comp_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 收车机构信息添加
              .state('app.postbiz_car_collect_comp_save', {
                  url: '/postbiz_car_collect_comp_save',
                  templateUrl: 'tpl/postbiz/car_collect_comp/car_collect_comp_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/car_collect_comp/car_collect_comp_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 收车机构信息修改
              .state('app.postbiz_car_collect_comp_modify', {
                  url: '/postbiz_car_collect_comp_modify',
                  templateUrl: 'tpl/postbiz/car_collect_comp/car_collect_comp_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/car_collect_comp/car_collect_comp_modify.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })



              //收车机构信息详情
              .state('app.postbiz_car_collect_comp_detail', {
                  url: '/postbiz_car_collect_comp_detail',
                  templateUrl: 'tpl/postbiz/car_collect_comp/car_collect_comp_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/car_collect_comp/car_collect_comp_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              // 罚息免除一览展示
              .state('app.cost_overdue_exempt_list_query', {
                  url: '/cost_overdue_exempt_list_query',
                  templateUrl: 'tpl/cost/overdue_exempt/overdue_exempt_list_query.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/overdue_exempt/overdue_exempt_list_query.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 罚息免除一览展示明细
              .state('app.cost_overdue_exempt_detail_query', {
                  url: '/cost_overdue_exempt_detail_query',
                  templateUrl: 'tpl/cost/overdue_exempt/overdue_exempt_detail_query.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/overdue_exempt/overdue_exempt_detail_query.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 罚息免除申请一览
              .state('app.cost_overdue_exempt_list', {
                  url: '/cost_overdue_exempt_list',
                  templateUrl: 'tpl/cost/overdue_exempt/overdue_exempt_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/overdue_exempt/overdue_exempt_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 罚息免除
              .state('app.cost_overdue_exempt_modify', {
                  url: '/cost_overdue_exempt_modify',
                  templateUrl: 'tpl/cost/overdue_exempt/overdue_exempt_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/overdue_exempt/overdue_exempt_modify.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 罚息免除审核
              .state('app.cost_overdue_exempt_approve', {
                  url: '/cost_overdue_exempt_approve',
                  templateUrl: 'tpl/cost/overdue_exempt/overdue_exempt_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/overdue_exempt/overdue_exempt_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 财务科目维护
              .state('app.finance_financial_subject_list', {
                  url: '/finance_financial_subject_list',
                  templateUrl: 'tpl/finance/financial_subject/financial_subject_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/financial_subject/financial_subject_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 辅助核算类型管理
              .state('app.assis_account_type_list', {
                  url: '/assis_account_type_list',
                  templateUrl: 'tpl/finance/assis_account_type/assis_account_type_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/assis_account_type/assis_account_type_list.js'+getCacheTime(),
                                  'tpl/finance/assis_account_type/assis_account_type_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 辅助核算类型添加
              .state('app.assis_account_type_save', {
                      url: '/assis_account_type_save',
                      templateUrl: 'tpl/finance/assis_account_type/assis_account_type_save.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/finance/assis_account_type/assis_account_type_save.js'+getCacheTime(),
                                  ]);
                              }]
                      }
              })

              // 辅助核算类型修改
              .state('app.assis_account_type_modify', {
                    url: '/assis_account_type_modify',
                    templateUrl: 'tpl/finance/assis_account_type/assis_account_type_modify.html'+getCacheTime(),
                    resolve: {
                        deps: ['$ocLazyLoad',
                            function( $ocLazyLoad ){
                                return $ocLazyLoad.load(['toaster',
                                    'tpl/finance/assis_account_type/assis_account_type_modify.js'+getCacheTime(),
                                ]);
                            }]
                    }
              })

              // 辅助核算类型详情
              .state('app.assis_account_type_detail', {
                      url: '/assis_account_type_detail',
                      templateUrl: 'tpl/finance/assis_account_type/assis_account_type_detail.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/finance/assis_account_type/assis_account_type_detail.js'+getCacheTime(),
                                  ]);
                              }]
                      }
              })


              // 财务科目维护添加
              .state('app.finance_financial_subject_save', {
                  url: '/finance_financial_subject_save',
                  templateUrl: 'tpl/finance/financial_subject/financial_subject_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_subject/financial_subject_save.js'+getCacheTime(),
                                  'tpl/finance/assis_account_type/assis_account_type_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              // 财务科目维护修改
              .state('app.finance_financial_subject_modify', {
                  url: '/finance_financial_subject_modify',
                  templateUrl: 'tpl/finance/financial_subject/financial_subject_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_subject/financial_subject_modify.js'+getCacheTime(),
                                  'tpl/finance/assis_account_type/assis_account_type_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })



              // 财务科目维护详情
              .state('app.finance_financial_subject_detail', {
                  url: '/finance_financial_subject_detail',
                  templateUrl: 'tpl/finance/financial_subject/financial_subject_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/financial_subject/financial_subject_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 利率因子维护
              .state('app.product_intrst_factor_list', {
                  url: '/product_intrst_factor_list',
                  templateUrl: 'tpl/product/intrst_factor/intrst_factor_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/intrst_factor/intrst_factor_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 利率因子维护添加
              .state('app.product_intrst_factor_save', {
                  url: '/product_intrst_factor_save',
                  templateUrl: 'tpl/product/intrst_factor/intrst_factor_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/intrst_factor/intrst_factor_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              // 利率因子维护修改
              .state('app.product_intrst_factor_modify', {
                  url: '/product_intrst_factor_modify',
                  templateUrl: 'tpl/product/intrst_factor/intrst_factor_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/intrst_factor/intrst_factor_modify.js'+getCacheTime()
                              ]);
                          }]
                  }
              })



              // 利率因子维护详情
              .state('app.product_intrst_factor_detail', {
                  url: '/product_intrst_factor_detail',
                  templateUrl: 'tpl/product/intrst_factor/intrst_factor_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/product/intrst_factor/intrst_factor_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 公告信息一览
              .state('app.system_sys_announcement_list', {
                  url: '/system_sys_announcement_list',
                  templateUrl: 'tpl/system/sys_announcement/sys_announcement_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_announcement/sys_announcement_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 添加公告信息画面
              .state('app.system_sys_announcement_save', {
                  url: '/system_sys_announcement_save',
                  templateUrl: 'tpl/system/sys_announcement/sys_announcement_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_announcement/sys_announcement_save.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 修改公告信息画面
              .state('app.system_sys_announcement_modify', {
                  url: '/system_sys_announcement_modify',
                  templateUrl: 'tpl/system/sys_announcement/sys_announcement_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_announcement/sys_announcement_modify.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 公告信息详情画面
              .state('app.system_sys_announcement_detail', {
                  url: '/system_sys_announcement_detail',
                  templateUrl: 'tpl/system/sys_announcement/sys_announcement_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_announcement/sys_announcement_detail.js'+getCacheTime()
                                  , 'js/fileinput/fileinput.min.js'+getCacheTime()
                                  , 'js/fileinput/bootstrap.min.js'+getCacheTime()
                                  , 'css/fileinput/fileinput.min.css'+getCacheTime()
                                  , 'tpl/common/file/file_list.js'+getCacheTime()
                                  , 'tpl/common/file/file_upload.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

                //日志管理一览
              .state('app.system_sys_log_list', {
                  url: '/system_sys_log_list',
                  templateUrl: 'tpl/system/sys_log/sys_log_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_log/sys_log_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })




              // 日志管理详情
              .state('app.system_sys_log_detail', {
                  url: '/system_sys_log_detail',
                  templateUrl: 'tpl/system/sys_log/sys_log_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/system/sys_log/sys_log_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              //财务付款
              .state('app.prebiz_cont_payment', {
                  url: '/prebiz_cont_payment',
                  templateUrl: 'tpl/prebiz/cont_payment/cont_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_payment/cont_payment.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //财务回填
              .state('app.prebiz_cont_backfill', {
                  url: '/prebiz_cont_backfill',
                  templateUrl: 'tpl/prebiz/cont_payment/cont_backfill.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_payment/cont_backfill.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              .state('app.prebiz_cont_backinput', {
                  url: '/prebiz_cont_backinput',
                  templateUrl: 'tpl/prebiz/cont_payment/cont_backinput.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_payment/cont_backinput.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_finance.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              //合同文件核查
              .state('app.prebiz_cont_inspect', {
                  url: '/prebiz_cont_inspect',
                  templateUrl: 'tpl/prebiz/cont_inspect/cont_inspect.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/cont_inspect/cont_inspect.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/cont_create/cont_create_detail.js'+getCacheTime(),
                                  'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })

              // 融资申请录入(个人)
              .state('app.prebiz_apply_input', {
                  url: '/prebiz_apply_input',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_sales/bas_sales_list_select.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_person_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                                  ,'tpl/prebiz/common_borrower/common_borrower_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/borrower_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/apply_finance_vehicle.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请录入(二手车)
              .state('app.old_apply_input', {
                  url: '/old_apply_input',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_sales/bas_sales_list_select.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_person_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                                  ,'tpl/prebiz/common_borrower/common_borrower_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/borrower_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/apply_finance_vehicle.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请录入(企业)
              .state('app.prebiz_apply_input_company', {
                  url: '/prebiz_apply_input_company',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input_company.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input_company.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_sales/bas_sales_list_select.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_company_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/apply_finance_vehicle.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请录入(企业二手车)
              .state('app.old_apply_input_company', {
                  url: '/old_apply_input_company',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input_company.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input_company.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_partner/bas_partner_list_select.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_sales/bas_sales_list_select.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_company_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/apply_finance_vehicle.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //担保个人信息录入
              .state('app.prebiz_guarantee_pers_save', {
                  url: '/prebiz_guarantee_pers_save',
                  templateUrl: 'tpl/prebiz/apply_input/guarantee_pers_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //担保企业信息录入
              .state('app.prebiz_guarantee_comp_save', {
                  url: '/prebiz_guarantee_comp_save',
                  templateUrl: 'tpl/prebiz/apply_input/guarantee_comp_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //担保信息列表
              .state('app.prebiz_guarantee_info', {
                  url: '/prebiz_guarantee_info',
                  templateUrl: 'tpl/prebiz/apply_input/guarantee_info.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime()
                                  ,'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //个人客户信息详情
              .state('app.prebiz_apply_input_detail', {
                  url: '/prebiz_apply_input_detail',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/cont_create/cont_create_detail.js'+getCacheTime(),
                                  'tpl/prebiz/cont_receipt_pay/cont_payment_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                                  //展期、变更承租人、增加保证金子页签
                                  'tpl/postbiz/defer_task/defer_task_detail.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/basic_change/basic_change_lessee.js'+getCacheTime(),
                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业客户信息详情
              .state('app.prebiz_apply_input_company_detail', {
                  url: '/prebiz_apply_input_company_detail',
                  templateUrl: 'tpl/prebiz/apply_input/apply_input_company_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/apply_input_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/prebiz/cont_request_pay/cont_request_pay_detail.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              .state("app.file_demo",{
                  url: '/file_demo',
                  templateUrl: 'tpl/common/file/file_demo.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load([
                                  'toaster',
                                  'tpl/common/file/file_demo.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              .state("app.file_list",{
                  url: '/file_list',
                  templateUrl: 'tpl/common/file/file_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load([
                                  'toaster',
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 后台测试
              .state('app.test_test', {
                  url: '/test_test',
                  templateUrl: 'tpl/test/test.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/test/test.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //融资申请录入save
              .state('app.prebiz_cstm_person_save', {
                  url: '/prebiz_cstm_person_save',
                  templateUrl: 'tpl/prebiz/apply_input/cstm_person_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/apply_input/cstm_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/cstm_person/cstm_person_save.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //融资申请风控审批
              .state('app.prebiz_apply_approve', {
                  url: '/prebiz_apply_approve',
                  templateUrl: 'tpl/prebiz/apply_approve/apply_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_approve/apply_approve.js'+getCacheTime(),
                                  'tpl/prebiz/apply_approve/apply_approve_approval.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请有条件同意
              .state('app.prebiz_apply_conditional_agree', {
                  url: '/prebiz_apply_conditional_agree',
                  templateUrl: 'tpl/prebiz/apply_conditional_agree/apply_conditional_agree.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_conditional_agree/apply_conditional_agree.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请总经理审核
              .state('app.prebiz_apply_manage_approve', {
                  url: '/prebiz_apply_manage_approve',
                  templateUrl: 'tpl/prebiz/apply_manage_approve/apply_manage_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_manage_approve/apply_manage_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资申请有条件同意录入员确认页面
              .state('app.prebiz_apply_agree', {
                  url: '/prebiz_apply_agree',
                  templateUrl: 'tpl/prebiz/apply_agree/apply_agree.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_agree/apply_agree.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //审核意见备注
              .state('app.prebiz_apply_approve_approval', {
                  url: '/prebiz_apply_approve_approval',
                  templateUrl: 'tpl/prebiz/apply_approve/apply_approve_approval.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_approve/apply_approve_approval.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //天启模板
              .state('app.zxtb', {
                  url: '/zxtb',
                  templateUrl: 'tpl/zxtb/zxtb.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/zxtb/zxtb.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //资料邮寄附件一览
              .state('app.original_orig_file_list', {
                  url: '/original_orig_file_list',
                  templateUrl: 'tpl/original/orig_file/orig_file_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料邮寄附件详情
              .state('app.original_orig_file_detail_list', {
                  url: '/original_orig_file_detail_list',
                  templateUrl: 'tpl/original/orig_file_detail/orig_file_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file_detail/orig_file_detail_list.js'+getCacheTime(),
                                  'tpl/original/orig_file_detail/orig_file_detail_save.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料邮寄签收
              .state('app.prebiz_file_send_list', {
                  url: '/prebiz_file_send_list',
                  templateUrl: 'tpl/original/file_send/file_send_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/file_send/file_send_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //文件归档
              .state('app.orig_file_archive', {
                  url: '/orig_file_archive',
                  templateUrl: 'tpl/original/orig_file/orig_file_archive.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_archive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //文件归档
              .state('app.orig_file_sort', {
                  url: '/orig_file_sort',
                  templateUrl: 'tpl/original/orig_file/orig_file_sort.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_sort.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //归档审核
              .state('app.orig_file_sort_examine', {
                  url: '/orig_file_sort_examine',
                  templateUrl: 'tpl/original/orig_file/orig_file_sort_examine.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_sort_examine.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //归档(资料邮寄使用一览)
              .state('app.orig_file_archive_list', {
                  url: '/orig_file_archive_list',
                  templateUrl: 'tpl/original/orig_file/orig_file_archive_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_archive_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料邮寄
              .state('app.orig_file_mail', {
                  url: '/orig_file_mail',
                  templateUrl: 'tpl/original/orig_file/orig_file_mail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_mail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料上传
              .state('app.orig_file_upload', {
                  url: '/orig_file_upload',
                  templateUrl: 'tpl/original/orig_file/orig_file_upload.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_upload.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保单归档
              .state('app.orig_file_renewal_archive_list', {
                  url: '/orig_file_renewal_archive_list',
                  templateUrl: 'tpl/original/orig_file/orig_file_renewal_archive_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_renewal_archive_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保单归档明细
              .state('app.orig_file_renewal_sort', {
                  url: '/orig_file_renewal_sort',
                  templateUrl: 'tpl/original/orig_file/orig_file_renewal_sort.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_renewal_sort.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //续保归档明细
              .state('app.orig_file_renewal_detail', {
                  url: '/orig_file_renewal_detail',
                  templateUrl: 'tpl/original/orig_file/orig_file_renewal_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_renewal_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //文档借阅
              .state('app.original_file_borrow', {
                  url: '/original_file_borrow',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //文档借阅明细
              .state('app.original_file_borrow_detail', {
                  url: '/original_file_borrow_detail',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅审批
              .state('app.original_file_borrow_examine', {
                  url: '/original_file_borrow_examine',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_examine.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_examine.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //邮寄资料-借阅
              .state('app.original_file_borrow_mail', {
                  url: '/original_file_borrow_mail',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_mail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_mail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资管复核
              .state('app.original_file_borrow_re_examine', {
                  url: '/original_file_borrow_re_examine',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_re_examine.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_re_examine.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料回寄一览
              .state('app.original_file_borrow_back_send_list', {
                  url: '/original_file_borrow_back_send_list',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_back_send_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_back_send_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料回寄明细
              .state('app.original_file_borrow_back_send_detail', {
                  url: '/original_file_borrow_back_send_detail',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_back_send_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_back_send_detail.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //资料回寄资管复核
              .state('app.original_file_borrow_back_send_examine', {
                  url: '/original_file_borrow_back_send_examine',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_back_send_examine.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_borrow_back_send_examine.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅制单
              .state('app.finance_borrow_task_make_voucher',{
                  url: '/finance_borrow_task_make_voucher',
                  templateUrl: 'tpl/finance/orig_file_borrow_task/borrow_task_make_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/orig_file_borrow_task/borrow_task_make_voucher.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅打款
              .state('app.finance_borrow_task_payment',{
                  url: '/finance_borrow_task_payment',
                  templateUrl: 'tpl/finance/orig_file_borrow_task/borrow_task_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/orig_file_borrow_task/borrow_task_payment.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅资管确认
              .state('app.original_borrow_task_confirm',{
                  url: '/original_borrow_task_confirm',
                  templateUrl: 'tpl/original/orig_file/orig_file_borrow_back_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/original/orig_file/orig_file_borrow_back_confirm.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅财务确认收款
              .state('app.original_file_borrow_task_finance', {
                  url: '/original_file_borrow_task_finance',
                  templateUrl: 'tpl/finance/orig_file_borrow_task/orig_file_borrow_task_finance.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/orig_file_borrow_task/orig_file_borrow_task_finance.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 提前还款申请一览画面
              .state('app.cost_cont_prepayment_list', {
                  url: '/cost_cont_prepayment_list',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_list.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //申请提前还款
              .state('app.cost_cont_prepayment_modify', {
                  url: '/cost_cont_prepayment_modify',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款审批
              .state('app.cost_cont_prepayment_approve', {
                  url: '/cost_cont_prepayment_approve',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款财务确认收款（新）
              .state('app.cost_cont_prepayment_receipt_confirm', {
                  url: '/cost_cont_prepayment_receipt_confirm',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_receipt_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_receipt_confirm.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款财务确认（旧）
              .state('app.cost_cont_prepayment_confirm', {
                  url: '/cost_cont_prepayment_confirm',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_confirm.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_confirm_select_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款财务经理审批
              .state('app.cost_cont_prepayment_payment', {
                  url: '/cost_cont_prepayment_payment',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_payment.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款总经理审批
              .state('app.cost_cont_prepayment_check', {
                  url: '/cost_cont_prepayment_check',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_check.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_check.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款车辆出库
              .state('app.cost_cont_prepayment_vehicle_export', {
                  url: '/cost_cont_prepayment_vehicle_export',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_vehicle_export.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_vehicle_export.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  // 车辆出库
                                  'tpl/postbiz/vehicle_disposal/vehicle_export.js'+getCacheTime(),
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //提前还款取消页面
              .state('app.cost_cont_prepayment_cancel', {
                  url: '/cost_cont_prepayment_cancel',
                  templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_cancel.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/cont_prepayment/cont_prepayment_cancel.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/cont_prepayment/cont_prepayment_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //解抵押一览画面
              .state('app.asset_mortgage_register_list', {
                  url: '/asset_mortgage_register_list',
                  templateUrl: 'tpl/asset/mortgage_register/mortgage_register_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_register/mortgage_register_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 解除抵押画面
              .state('app.asset_mortgage_register_modify', {
                  url: '/asset_mortgage_register_modify',
                  templateUrl: 'tpl/asset/mortgage_register/mortgage_register_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_register/mortgage_register_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //邮寄画面
              .state('app.asset_mortgage_register_mail', {
                  url: '/asset_mortgage_register_mail',
                  templateUrl: 'tpl/asset/mortgage_register/mortgage_register_mail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_register/mortgage_register_mail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 手动扣款勾稽一览画面
              .state('app.finance_cont_receipt_list', {
                  url: '/finance_cont_receipt_list',
                  templateUrl: 'tpl/finance/cont_receipt/cont_receipt_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_receipt/cont_receipt_list.js'+getCacheTime(),
                                  'tpl/finance/cont_repay_sked/cont_repay_sked_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 手动勾稽画面
              .state('app.finance_cont_receipt_manual_checked', {
                  url: '/finance_cont_receipt_manual_checked',
                  templateUrl: 'tpl/finance/cont_receipt/cont_receipt_manual_checked.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_receipt/cont_receipt_manual_checked.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 勾稽明细查询
              .state('app.finance_cont_receipt_detail_list', {
                  url: '/finance_cont_receipt_detail_list',
                  templateUrl: 'tpl/finance/cont_receipt/cont_receipt_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_receipt/cont_receipt_detail_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              // 勾稽明细开具发票
              .state('app.finance_cont_receipt_detail_invoice', {
                  url: '/finance_cont_receipt_detail_invoice',
                  templateUrl: 'tpl/finance/cont_receipt/cont_receipt_detail_invoice.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_receipt/cont_receipt_detail_invoice.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 认领详情画面
              .state('app.finance_cont_repay_sked_list', {
                  url: '/finance_cont_repay_sked_list',
                  templateUrl: 'tpl/finance/cont_repay_sked/cont_repay_sked_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_repay_sked/cont_repay_sked_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 收款明细导入
              .state('app.finance_cont_receipt_import', {
                  url: '/finance_cont_receipt_import',
                  templateUrl: 'tpl/finance/cont_receipt/cont_receipt_import.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_receipt/cont_receipt_import.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //归档明细
              .state('app.original_orig_file_archive_detail', {
                  url: '/original_orig_file_archive_detail',
                  templateUrl: 'tpl/original/orig_file/orig_file_archive_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/orig_file/orig_file_archive_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保险理赔申请
              .state('app.insurance_cont_insur_claim_save', {
                  url: '/insurance_cont_insur_claim_save',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_save.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保险理赔详情
              .state('app.insurance_cont_insur_claim_detail', {
                  url: '/insurance_cont_insur_claim_detail',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保险理赔审核
              .state('app.insurance_cont_insur_claim_approve', {
                  url: '/insurance_cont_insur_claim_approve',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_approve.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/insurance/cont_insur_claim/cont_insur_claim_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保险理赔审核确认
              .state('app.insurance_cont_insur_claim_confirm', {
                  url: '/insurance_cont_insur_claim_confirm',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_confirm.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/insurance/cont_insur_claim/cont_insur_claim_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              //保险理赔制单
              .state('app.finance_cont_insur_claim_make_voucher',{
                  url: '/finance_cont_insur_claim_make_voucher',
                  templateUrl: 'tpl/finance/cont_insur_claim_pay/cont_insur_claim_make_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/cont_insur_claim_pay/cont_insur_claim_make_voucher.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //保险理赔付款
              .state('app.finance_cont_insur_claim_payment',{
                  url: '/finance_cont_insur_claim_payment',
                  templateUrl: 'tpl/finance/cont_insur_claim_pay/cont_insur_claim_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/cont_insur_claim_pay/cont_insur_claim_payment.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //关系图
              .state('app.relation_echarts',{
                  url: '/relation_echarts',
                  templateUrl: 'tpl/zxtb/relation_echarts.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','js/echarts/echarts.min.js'+getCacheTime(),
                                  ,'tpl/zxtb/relation_echarts.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //贷前模型
              .state('app.credit_model', {
                  url: '/credit_model',
                  templateUrl: 'tpl/prebiz/credit_model/credit_model.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'js/echarts/echarts.min.js'+getCacheTime(),
                                  'tpl/prebiz/credit_model/credit_model.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //逾期客户电话登记
              .state('app.postbiz_overdue_cstm_list', {
                  url: '/postbiz_overdue_cstm_list',
                  templateUrl: 'tpl/postbiz/overdue_cstm/overdue_cstm_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_cstm/overdue_cstm_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //逾期客户电话登记修改
              .state('app.postbiz_overdue_cstm_modify', {
                  url: '/postbiz_overdue_cstm_modify',
                  templateUrl: 'tpl/postbiz/overdue_cstm/overdue_cstm_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/overdue_cstm/overdue_cstm_modify.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_cstm_save.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sum.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_state.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_finance.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              //规则引擎项目管理
              .state('app.baseinfo_rule_item',{
                  url: '/baseinfo_rule_item',
                  templateUrl: 'tpl/baseinfo/rule_item/rule_item_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule_item/rule_item_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //规则引擎项目添加
              .state('app.baseinfo_rule_item_save',{
                  url: '/baseinfo_rule_item_save',
                  templateUrl: 'tpl/baseinfo/rule_item/rule_item_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule_item/rule_item_save.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //规则引擎项目修改
              .state('app.baseinfo_rule_item_modify',{
                  url: '/baseinfo_rule_item_modify',
                  templateUrl: 'tpl/baseinfo/rule_item/rule_item_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule_item/rule_item_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //规则引擎项目详情
              .state('app.baseinfo_rule_item_detail',{
                  url: '/baseinfo_rule_item_detail',
                  templateUrl: 'tpl/baseinfo/rule_item/rule_item_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule_item/rule_item_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })



              //规则引擎管理
              .state('app.baseinfo_rule',{
                  url: '/baseinfo_rule',
                  templateUrl: 'tpl/baseinfo/rule/rule_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule/rule_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //规则引擎新增
              .state('app.baseinfo_rule_save',{
                  url: '/baseinfo_rule_save',
                  templateUrl: 'tpl/baseinfo/rule/rule_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule/rule_save.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_condition_save.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_consequence_save.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_condition_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_consequence_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })


              //规则引擎修改
              .state('app.baseinfo_rule_modify',{
                  url: '/baseinfo_rule_modify',
                  templateUrl: 'tpl/baseinfo/rule/rule_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule/rule_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_condition_save.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_consequence_save.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_condition_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/rule/rule_consequence_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //规则引擎详情
              .state('app.baseinfo_rule_detail',{
                  url: '/baseinfo_rule_detail',
                  templateUrl: 'tpl/baseinfo/rule/rule_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/baseinfo/rule/rule_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //CRM信息
              .state('app.crm_person_list', {
                  url: '/crm_person_list',
                  templateUrl: 'tpl/prebiz/crm_person/crm_person_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/crm_person/crm_person_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //CRM个人修改/录入
              .state('app.crm_person_modify', {
                  url: '/crm_person_modify',
                  templateUrl: 'tpl/prebiz/crm_person/crm_person_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/crm_person/crm_person_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //CRM个人详情
              .state('app.crm_person_detail', {
                  url: '/crm_person_detail',
                  templateUrl: 'tpl/prebiz/crm_person/crm_person_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/crm_person/crm_person_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //CRM企业修改/录入
              .state('app.crm_company_modify', {
                  url: '/crm_company_modify',
                  templateUrl: 'tpl/prebiz/crm_company/crm_company_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/crm_company/crm_company_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //CRM企业详情
              .state('app.crm_company_detail', {
                  url: '/crm_company_detail',
                  templateUrl: 'tpl/prebiz/crm_company/crm_company_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/prebiz/crm_company/crm_company_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //万量融资租赁报价器信息录入
              .state('app.prebiz_quotation_device_list',{
                  url: '/prebiz_quotation_device_list',
                  templateUrl: 'tpl/prebiz/quotation_device/quotation_device_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/quotation_device/quotation_device_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //万量融资租赁报价器信息修改
              .state('app.prebiz_quotation_device_modify',{
                  url: '/prebiz_quotation_device_modify',
                  templateUrl: 'tpl/prebiz/quotation_device/quotation_device_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/quotation_device/quotation_device_modify.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //万量融资租赁报价器信息录入
              .state('app.prebiz_quotation_device_calculate',{
                  url: '/prebiz_quotation_device_calculate',
                  templateUrl: 'tpl/prebiz/quotation_device/quotation_device_calculate.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/quotation_device/quotation_device_calculate.js'+getCacheTime()
                                  ,'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime()
                                  ,'tpl/product/product/product_user.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //gps派单录入
              .state('app.cost_gps_dispatch_list',{
                  url: '/cost_gps_dispatch_list',
                  templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/gps_dispatch/gps_dispatch_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              .state('app.cost_gps_dispatch_input',{
                  url: '/cost_gps_dispatch_input',
                  templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_input.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/gps_dispatch/gps_dispatch_input.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })

              .state('app.cost_gps_dispatch_detail',{
                  url: '/cost_gps_dispatch_detail',
                  templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/gps_dispatch/gps_dispatch_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //gps派单月结查询
              .state('app.cost_gps_dispatch_monthly_list',{
                  url: '/cost_gps_dispatch_monthly_list',
                  templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_monthly_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/gps_dispatch/gps_dispatch_monthly_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //gps派单申请月结
              .state('app.cost_gps_dispatch_monthly_modify',{
                  url: '/cost_gps_dispatch_monthly_modify',
                  templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_monthly_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/gps_dispatch/gps_dispatch_monthly_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //gps派单月结复核
              .state('app.cost_gps_dispatch_monthly_approve',{
                  url: '/cost_gps_dispatch_monthly_approve',
                  templateUrl: 'tpl/cost/monthly_settlement/monthly_settlement_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/monthly_settlement/monthly_settlement_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })

              //gps派单月结制单
              .state('app.finance_gps_monthly_make_voucher',{
                  url: '/finance_gps_monthly_make_voucher',
                  templateUrl: 'tpl/finance/gps_monthly_pay/gps_monthly_make_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/gps_monthly_pay/gps_monthly_make_voucher.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //gps派单月结付款
              .state('app.finance_gps_monthly_payment',{
                  url: '/finance_gps_monthly_payment',
                  templateUrl: 'tpl/finance/gps_monthly_pay/gps_monthly_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/gps_monthly_pay/gps_monthly_payment.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })


              // 盗抢险信息一览
              .state('app.cost_pilfer_insurance_list', {
                  url: '/cost_pilfer_insurance_list',
                  templateUrl: 'tpl/cost/pilfer_insurance/pilfer_insurance_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/pilfer_insurance/pilfer_insurance_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })

              // 盗抢险录入
              .state('app.cost_pilfer_insurance_input', {
                  url: '/cost_pilfer_insurance_input',
                  templateUrl: 'tpl/cost/pilfer_insurance/pilfer_insurance_input.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/pilfer_insurance/pilfer_insurance_input.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //盗抢险详情
              .state('app.cost_pilfer_insurance_detail', {
                  url: '/cost_pilfer_insurance_detail',
                  templateUrl: 'tpl/cost/pilfer_insurance/pilfer_insurance_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/cost/pilfer_insurance/pilfer_insurance_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //盗抢险月结查询
              .state('app.cost_pilfer_insurance_monthly_list',{
                  url: '/cost_pilfer_insurance_monthly_list',
                  templateUrl: 'tpl/cost/pilfer_insurance/pilfer_insurance_monthly_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/pilfer_insurance/pilfer_insurance_monthly_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //申请盗抢险月结
              .state('app.cost_pilfer_insurance_monthly_modify',{
                  url: '/cost_pilfer_insurance_monthly_modify',
                  templateUrl: 'tpl/cost/pilfer_insurance/pilfer_insurance_monthly_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/pilfer_insurance/pilfer_insurance_monthly_modify.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //盗抢险月结复核
              .state('app.cost_monthly_pilfer_insurance_approve',{
                  url: '/cost_monthly_pilfer_insurance_approve',
                  templateUrl: 'tpl/cost/monthly_pilfer_insurance/monthly_pilfer_insurance_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/cost/monthly_pilfer_insurance/monthly_pilfer_insurance_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //盗抢险月结制单
              .state('app.finance_pilfer_monthly_make_voucher',{
                  url: '/finance_pilfer_monthly_make_voucher',
                  templateUrl: 'tpl/finance/pilfer_monthly_pay/pilfer_monthly_make_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/pilfer_monthly_pay/pilfer_monthly_make_voucher.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //盗抢险月结付款
              .state('app.finance_pilfer_monthly_payment',{
                  url: '/finance_pilfer_monthly_payment',
                  templateUrl: 'tpl/finance/pilfer_monthly_pay/pilfer_monthly_payment.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/pilfer_monthly_pay/pilfer_monthly_payment.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押还款计划详情一览
              .state('app.asset_equ_mor_repay_detail_list',{
                  url: '/asset_equ_mor_repay_detail_list',
                  templateUrl: 'tpl/asset/equ_mor_repay_detail/equ_mor_repay_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_repay_detail/equ_mor_repay_detail_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押还款计划详情一览更新状态
              .state('app.asset_equ_mor_repay_detail_invoice',{
                  url: '/asset_equ_mor_repay_detail_invoice',
                  templateUrl: 'tpl/asset/equ_mor_repay_detail/equ_mor_repay_detail_invoice.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_repay_detail/equ_mor_repay_detail_invoice.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
          //资方抵押解除一览
              .state('app.asset_equ_mor_detail_list',{
                  url: '/asset_equ_mor_detail_list',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除申请
              .state('app.asset_equ_mor_detail_apply',{
                  url: '/asset_equ_mor_detail_apply',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_apply.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_apply.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除复审
              .state('app.asset_equ_mor_detail_review',{
                  url: '/asset_equ_mor_detail_review',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_review.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_review.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除制单
              .state('app.asset_equ_mor_detail_voucher',{
                  url: '/asset_equ_mor_detail_voucher',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_voucher.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_voucher.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除财务付款
              .state('app.asset_equ_mor_detail_finance',{
                  url: '/asset_equ_mor_detail_finance',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_finance.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_finance.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除财务确认收款
              .state('app.asset_equ_mor_detail_receipt',{
                  url: '/asset_equ_mor_detail_receipt',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_receipt.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_receipt.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除确认
              .state('app.asset_equ_mor_detail_confirm',{
                  url: '/asset_equ_mor_detail_confirm',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_confirm.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //资方抵押解除详细页面
              .state('app.asset_equ_mor_detail_detail',{
                  url: '/asset_equ_mor_detail_detail',
                  templateUrl: 'tpl/asset/equ_mor_detail/equ_mor_detail_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_detail/equ_mor_detail_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })

              //资产抵押申请
              .state('app.asset_equ_mor_apply_list',{
                  url: '/asset_equ_mor_apply_list',
                  templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_other_apply_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/asset/equ_mor_apply/equ_mor_other_apply_list.js'+getCacheTime(),
                                  'tpl/asset/equ_mor_apply/equ_mor_other_apply_input.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //资产抵押申请录入
              .state('app.asset_equ_mor_apply_input',{
                      url: '/asset_equ_mor_apply_input',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_other_apply_input.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_other_apply_input.js'+getCacheTime(),
                                      'tpl/prebiz/contract/contract_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )



              //海翼资产抵押申请
              .state('app.asset_equ_mor_sea_wing_apply_list',{
                      url: '/asset_equ_mor_sea_wing_apply_list',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              // 海翼资产抵押申请详情
              .state('app.asset_equ_mor_sea_wing_apply_list_detail', {
                  url: '/asset_equ_mor_sea_wing_apply_list_detail',
                  templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime()
                              ]);
                          }]
                  }
              })


              //海翼资产抵押申请录入
              .state('app.asset_equ_mor_sea_wing_apply_input',{
                      url: '/asset_equ_mor_sea_wing_apply_input',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_input.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_input.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //风控界面初审(个人)
              .state('app.risk_person_save',{
                  url: '/risk_person_save',
                  templateUrl: 'tpl/prebiz/apply_risk/risk_person_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_risk/risk_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //风控界面初审(企业)
              .state('app.risk_company_save',{
                  url: '/risk_company_save',
                  templateUrl: 'tpl/prebiz/apply_risk/risk_company_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_risk/risk_company_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_finance_vehicle_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/apply_input_file_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/home_visit_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //资产抵押费用导入
              .state('app.asset_equ_mor_charge_import_tab',{
                      url: '/asset_equ_mor_charge_import_tab',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_import_tab.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_import_tab.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_import.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //资产抵押费用导入
              .state('app.asset_equ_mor_charge_import',{
                      url: '/asset_equ_mor_charge_import',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_import.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_import.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //资产抵押资料归档
              .state('app.asset_equ_mor_archive',{
                      url: '/asset_equ_mor_archive',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_archive.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_archive.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //资产抵押资料归档
              .state('app.asset_equ_mor_archive_tab',{
                      url: '/asset_equ_mor_archive_tab',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_archive_tab.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_archive_tab.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //资管复核
              .state('app.asset_equ_mor_archive_review',{
                      url: '/asset_equ_mor_archive_review',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_archive_review.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_archive_review.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务制单
              .state('app.asset_equ_mor_charge_finance_touching',{
                      url: '/asset_equ_mor_charge_finance_touching',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_finance_touching.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_touching.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务制单
              .state('app.asset_equ_mor_finance_touching_tab',{
                      url: '/asset_equ_mor_finance_touching_tab',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_finance_touching_tab.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_finance_touching_tab.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_touching.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //总经理审批
              .state('app.asset_equ_mor_charge_manager_approval',{
                      url: '/asset_equ_mor_charge_manager_approval',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_manager_approval.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_manager_approval.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务付款
              .state('app.asset_equ_mor_charge_finance_pay',{
                      url: '/asset_equ_mor_charge_finance_pay',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_finance_pay.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_pay.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务付款
              .state('app.asset_equ_mor_charge_finance_pay_tab',{
                      url: '/asset_equ_mor_charge_finance_pay_tab',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_finance_pay_tab.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_pay_tab.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务收款
              .state('app.asset_equ_mor_charge_finance_receipt',{
                      url: '/asset_equ_mor_charge_finance_receipt',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_finance_receipt.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_receipt.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //财务收款
              .state('app.asset_equ_mor_charge_finance_receipt_tab',{
                      url: '/asset_equ_mor_charge_finance_receipt_tab',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_finance_receipt_tab.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_finance_receipt_tab.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'tpl/asset/equ_mor_apply/equ_mor_sea_wing_apply_list_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //费用导入复核
              .state('app.asset_equ_mor_charge_import_review',{
                      url: '/asset_equ_mor_charge_import_review',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_charge_import_review.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_charge_import_review.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //抵押详情
              .state('app.asset_equ_mor_apply_detail',{
                      url: '/asset_equ_mor_apply_detail',
                      templateUrl: 'tpl/asset/equ_mor_apply/equ_mor_apply_detail.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/asset/equ_mor_apply/equ_mor_apply_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //凭证类型保存
              .state('app.financial_voucher_save',{
                  url: '/financial_voucher_save',
                  templateUrl: 'tpl/finance/financial_voucher/financial_voucher_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher/financial_voucher_save.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })

              //凭证类型修改
              .state('app.financial_voucher_modify',{
                  url: '/financial_voucher_modify',
                  templateUrl: 'tpl/finance/financial_voucher/financial_voucher_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher/financial_voucher_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //凭证类型管理
              .state('app.financial_voucher_detail_list',{
                  url: '/financial_voucher_detail_list',
                  templateUrl: 'tpl/finance/financial_voucher_detail/financial_voucher_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_detail/financial_voucher_detail_list.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher/financial_voucher_save.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher/financial_voucher_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //凭证类型明细
              .state('app.financial_voucher_detail_save',{
                  url: '/financial_voucher_detail_save',
                  templateUrl: 'tpl/finance/financial_voucher_detail/financial_voucher_detail_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_detail/financial_voucher_detail_save.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_detail/financial_voucher_list_select.js'+getCacheTime(),
                                  'tpl/finance/financial_subject/financial_subject_select_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })

              //凭证类型明细
              .state('app.financial_voucher_detail_modify',{
                  url: '/financial_voucher_detail_modify',
                  templateUrl: 'tpl/finance/financial_voucher_detail/financial_voucher_detail_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_detail/financial_voucher_detail_modify.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_detail/financial_voucher_list_select.js'+getCacheTime(),
                                  'tpl/finance/financial_subject/financial_subject_select_list.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })
              //凭证类型明细
              .state('app.financial_voucher_detail_detail',{
                  url: '/financial_voucher_detail_detail',
                  templateUrl: 'tpl/finance/financial_voucher_detail/financial_voucher_detail_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_detail/financial_voucher_detail_detail.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_detail/financial_voucher_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }

              })


              //风控主管派单列表
              .state('app.prebiz_apply_dispatch_list',{
                  url: '/prebiz_apply_dispatch_list',
                  templateUrl: 'tpl/prebiz/apply_dispatch/apply_dispatch_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_dispatch/apply_dispatch_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //风控主管派单
              .state('app.prebiz_apply_dispatch',{
                  url: '/prebiz_apply_dispatch',
                  templateUrl: 'tpl/prebiz/apply_dispatch/apply_dispatch.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/prebiz/apply_dispatch/apply_dispatch.js'+getCacheTime(),
                                  'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

             //财务凭证数据一览
              .state('app.financial_voucher_summary_list',{
                  url: '/financial_voucher_summary_list',
                  templateUrl: 'tpl/finance/financial_voucher_summary/financial_voucher_summary_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_summary/financial_voucher_summary_list.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_data/financial_voucher_assis_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              .state('app.financial_voucher_data_list',{
                  url: '/financial_voucher_data_list',
                  templateUrl: 'tpl/finance/financial_voucher_data/financial_voucher_data_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_data/financial_voucher_data_list.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_data/financial_voucher_assis_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //财务凭证数据详情
              .state('app.financial_voucher_data_detail',{
                  url: '/financial_voucher_data_detail',
                  templateUrl: 'tpl/finance/financial_voucher_data/financial_voucher_data_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/finance/financial_voucher_data/financial_voucher_data_detail.js'+getCacheTime(),
                                  'tpl/finance/financial_voucher_data/financial_voucher_assis_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //借阅任务明细一览
              .state('app.original_borrow_task_detail_list', {
                  url: '/original_borrow_task_detail_list',
                  templateUrl: 'tpl/original/borrow_task_detail/borrow_task_detail_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/borrow_task_detail/borrow_task_detail_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 合同还款一览
              .state('app.finance_cont_repay_sked_view', {
                  url: '/finance_cont_repay_sked_view',
                  templateUrl: 'tpl/finance/cont_repay_sked/cont_repay_sked_view.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/cont_repay_sked/cont_repay_sked_view.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 合同还款一览
              .state('app.finance_fin_repay_sked_list', {
                  url: '/finance_fin_repay_sked_list',
                  templateUrl: 'tpl/finance/fin_repay_sked/fin_repay_sked_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/fin_repay_sked/fin_repay_sked_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 还款开票信息
              .state('app.finance_fin_repay_sked_invoice', {
                  url: '/finance_fin_repay_sked_invoice',
                  templateUrl: 'tpl/finance/fin_repay_sked/fin_repay_sked_invoice.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/fin_repay_sked/fin_repay_sked_invoice.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 批量修改开票属性
              .state('app.finance_edit_invoice_prop', {
                  url: '/finance_edit_invoice_prop',
                  templateUrl: 'tpl/finance/fin_repay_sked/fin_repay_sked_invoice_edit_prop.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/finance/fin_repay_sked/fin_repay_sked_invoice_edit_prop.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅任务一览
              .state('app.original_borrow_task_list', {
                  url: '/original_borrow_task_list',
                  templateUrl: 'tpl/original/borrow_task/borrow_task_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/borrow_task/borrow_task_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //借阅详情
              .state('app.original_file_borrow_details', {
                  url: '/original_file_borrow_details',
                  templateUrl: 'tpl/original/borrow_task/orig_file_borrow_details.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/original/borrow_task/orig_file_borrow_details.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //抵押明细提醒
              .state('app.asset_mortgage_remind_list', {
                  url: '/asset_mortgage_remind_list',
                  templateUrl: 'tpl/asset/mortgage_remind/mortgage_remind_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_remind/mortgage_remind_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //抵押明细提醒
              .state('app.asset_mortgage_remind_detail', {
                  url: '/asset_mortgage_remind_detail',
                  templateUrl: 'tpl/asset/mortgage_remind/mortgage_remind_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_remind/mortgage_remind_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //抵押确认页
              .state('app.asset_mortgage_remind_unlockImpawn', {
                  url: '/asset_mortgage_remind_unlockImpawn',
                  templateUrl: 'tpl/asset/mortgage_remind/mortgage_remind_unlockImpawn.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_remind/mortgage_remind_unlockImpawn.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //解押抵押确认页
              .state('app.asset_mortgage_remind_Impawn', {
                  url: '/asset_mortgage_remind_Impawn',
                  templateUrl: 'tpl/asset/mortgage_remind/mortgage_remind_Impawn.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/asset/mortgage_remind/mortgage_remind_Impawn.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //贷后合同一览
              .state('app.postbiz_contract_list', {
                  url: '/postbiz_contract_list',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/postbiz_contract_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/postbiz_contract_list.js' + getCacheTime(),
                              ]);
                          }]
                  }
              })
              //贷后开票信息变更申请
              .state('app.postbiz_invoice_change_save', {
                  url: '/postbiz_invoice_change_save',
                  templateUrl: 'tpl/postbiz/invoice_change/invoice_change_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/invoice_change/invoice_change_save.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //贷后开票信息变更审核
              .state('app.postbiz_invoice_change_approval', {
                  url: '/postbiz_invoice_change_approval',
                  templateUrl: 'tpl/postbiz/invoice_change/invoice_change_approval.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/invoice_change/invoice_change_approval.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业开票信息一览
              .state('app.postbiz_invoice_company_list', {
                  url: '/postbiz_invoice_company_list',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/invoice_company_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/invoice_company_list.js' + getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业开票信息变更任务一览
              .state('app.postbiz_invoice_change_list', {
                  url: '/postbiz_invoice_change_list',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/invoice_change_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/invoice_change_list.js' + getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业开票信息变更任务一览
              .state('app.postbiz_invoice_change_detail', {
                  url: '/postbiz_invoice_change_detail',
                  templateUrl: 'tpl/postbiz/invoice_change/invoice_change_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/invoice_change/invoice_change_detail.js' + getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //基本信息变更申请一览
              .state('app.postbiz_basic_change_list', {
                  url: '/postbiz_basic_change_list',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/basic_change_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/basic_change_list.js' + getCacheTime(),
                              ]);
                          }]
                  }
              })
              //生效合同变更查询一览
              .state('app.postbiz_basic_change_task_list', {
                  url: '/postbiz_basic_change_task_list',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/basic_change_task_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/basic_change_task_list.js' + getCacheTime(),
                              ]);
                          }]
                  }
              })
              //生效合同变更-取消
              .state('app.postbiz_basic_change_cancel', {
                  url: '/postbiz_basic_change_cancel',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/basic_change_cancel.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/basic_change_cancel.js' + getCacheTime(),

                              ]);
                          }]
                  }
              })
              //生效合同变更-风控初审
              .state('app.postbiz_basic_change_risk_save', {
                  url: '/postbiz_basic_change_risk_save',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/basic_change_risk_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/basic_change_risk_save.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //生效合同变更-风控复审
              .state('app.postbiz_basic_change_risk_review_save', {
                  url: '/postbiz_basic_change_risk_review_save',
                  templateUrl: 'tpl/postbiz/postbiz_contract_list/basic_change_risk_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/postbiz_contract_list/basic_change_risk_save.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //承租人基本信息变更申请
              .state('app.postbiz_basic_change_save', {
                  url: '/postbiz_basic_change_save',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/basic_change/basic_change_save.js' + getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_modify.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //承租人基本信息变更资管初审
              .state('app.postbiz_basic_change_approval', {
                  url: '/postbiz_basic_change_approval',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_approval.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/basic_change/basic_change_approval.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //承租人基本信息变更资管初审合同生成
              .state('app.postbiz_basic_change_cont_create', {
                  url: '/postbiz_basic_change_cont_create',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_cont_create.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/basic_change/basic_change_cont_create.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //承租人基本信息变更合同打印
              .state('app.postbiz_basic_change_cont_print', {
                  url: '/postbiz_basic_change_cont_print',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_cont_print.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/basic_change/basic_change_cont_print.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //承租人基本信息变更合同审核
              .state('app.postbiz_basic_change_cont_audit', {
                  url: '/postbiz_basic_change_cont_audit',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_cont_audit.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/basic_change/basic_change_cont_audit.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //承租人基本信息变更详情
              .state('app.postbiz_basic_change_detail', {
                  url: '/postbiz_basic_change_detail',
                  templateUrl: 'tpl/postbiz/basic_change/basic_change_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/basic_change/basic_change_detail.js' + getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),

                                  'tpl/postbiz/basic_change/basic_change_apply_save.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/cstm_person_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_company_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/borrower_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/common_borrower/common_borrower_detail.js'+getCacheTime(),

                                  'tpl/prebiz/apply_input/guarantee_info_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),

                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),

                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  //开票信息、个人基本信息、企业基本信息变更历史弹出框
                                  'tpl/postbiz/postbiz_contract_list/invoice_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.js'+getCacheTime(),
                                  'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //个人基本信息变更申请
              .state('app.postbiz_person_basic_change_save', {
                  url: '/postbiz_person_basic_change_save',
                  templateUrl: 'tpl/postbiz/person_basic_change/person_basic_change_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/person_basic_change/person_basic_change_save.js' + getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业基本信息变更申请
              .state('app.postbiz_company_basic_change_save', {
                  url: '/postbiz_company_basic_change_save',
                  templateUrl: 'tpl/postbiz/company_basic_change/company_basic_change_save.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/company_basic_change/company_basic_change_save.js' + getCacheTime(),
                                  'tpl/prebiz/apply_input/cstm_contact_append.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //个人基本信息变更详情
              .state('app.postbiz_person_basic_change_detail', {
                  url: '/postbiz_person_basic_change_detail',
                  templateUrl: 'tpl/postbiz/person_basic_change/person_basic_change_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/person_basic_change/person_basic_change_detail.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //个人基本信息变更资管初审
              .state('app.postbiz_person_basic_change_approval', {
                  url: '/postbiz_person_basic_change_approval',
                  templateUrl: 'tpl/postbiz/person_basic_change/person_basic_change_approval.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/person_basic_change/person_basic_change_approval.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业基本信息变更资管初审
              .state('app.postbiz_company_basic_change_approval', {
                  url: '/postbiz_company_basic_change_approval',
                  templateUrl: 'tpl/postbiz/company_basic_change/company_basic_change_approval.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/company_basic_change/company_basic_change_approval.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //个人基本信息变更资管复审
              .state('app.postbiz_person_basic_change_review', {
                  url: '/postbiz_person_basic_change_review',
                  templateUrl: 'tpl/postbiz/person_basic_change/person_basic_change_review.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/person_basic_change/person_basic_change_review.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业基本信息变更资管初审
              .state('app.postbiz_company_basic_change_review', {
                  url: '/postbiz_company_basic_change_review',
                  templateUrl: 'tpl/postbiz/company_basic_change/company_basic_change_review.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/company_basic_change/company_basic_change_review.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //企业基本信息变更详情
              .state('app.postbiz_company_basic_change_detail', {
                  url: '/postbiz_company_basic_change_detail',
                  templateUrl: 'tpl/postbiz/company_basic_change/company_basic_change_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function ($ocLazyLoad) {
                              return $ocLazyLoad.load(['toaster', 'tpl/postbiz/company_basic_change/company_basic_change_detail.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //合同展期申请父页面
              .state('app.postbiz_defer_task_apply_page', {
                  url: '/postbiz_defer_task_apply_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_apply_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_apply_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_apply.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //合同展期申请
              .state('app.postbiz_defer_task_apply', {
                  url: '/postbiz_defer_task_apply',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_apply.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_apply.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同展期申请审批父页面
              .state('app.postbiz_defer_task_approve_page', {
                  url: '/postbiz_defer_task_approve_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_approve_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_approve_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同展期申请审批
              .state('app.postbiz_defer_task_approve', {
                  url: '/postbiz_defer_task_approve',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同生成父页面
              .state('app.postbiz_defer_task_contract_generate_page', {
                  url: '/postbiz_defer_task_contract_generate_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_generate_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_generate_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_contract_generate.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同生页面
              .state('app.postbiz_defer_task_contract_generate', {
                  url: '/postbiz_defer_task_contract_generate',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_generate.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_generate.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同打印
              .state('app.postbiz_defer_task_contract_print', {
                  url: '/postbiz_defer_task_contract_print',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_print.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_print.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同打印父页面
              .state('app.postbiz_defer_task_contract_print_page', {
                  url: '/postbiz_defer_task_contract_print_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_print_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_print_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_contract_print.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同审核父页面
              .state('app.postbiz_defer_task_contract_approve_page', {
                  url: '/postbiz_defer_task_contract_approve_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_approve_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_approve_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_contract_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同审核页面
              .state('app.postbiz_defer_task_contract_approve', {
                  url: '/postbiz_defer_task_contract_approve',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_contract_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_contract_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同申请财务审核页面
              .state('app.postbiz_defer_task_financial_approve', {
                  url: '/postbiz_defer_task_financial_approve',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_financial_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_financial_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同申请财务审核父页面
              .state('app.postbiz_defer_task_financial_approve_page', {
                  url: '/postbiz_defer_task_financial_approve_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_financial_approve_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_financial_approve_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_financial_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同申请总经理审核父页面
              .state('app.postbiz_defer_task_manager_approve_page', {
                  url: '/postbiz_defer_task_manager_approve_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_manager_approve_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_manager_approve_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_manager_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //展期合同申请总经理审核页面
              .state('app.postbiz_defer_task_manager_approve', {
                  url: '/postbiz_defer_task_manager_approve',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_manager_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_manager_approve.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同展期前信息
              .state('app.postbiz_defer_task_detail_before', {
                  url: '/postbiz_defer_task_detail_before',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_detail_before.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_detail_before.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同展期后信息
              .state('app.postbiz_defer_task_detail', {
                  url: '/postbiz_defer_task_detail',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //合同展期详情父信息
              .state('app.postbiz_defer_task_detail_page', {
                  url: '/postbiz_defer_task_detail_page',
                  templateUrl: 'tpl/postbiz/defer_task/defer_task_detail_page.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/defer_task/defer_task_detail_page.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_detail_before.js'+getCacheTime(),
                                  'tpl/postbiz/defer_task/defer_task_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户申请一览
              .state('app.postbiz_transfer_info_list', {
                  url: '/postbiz_transfer_info_list',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_info_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_info_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户申请
              .state('app.postbiz_transfer_apply', {
                  url: '/postbiz_transfer_apply',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_apply.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_apply.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户详情
              .state('app.postbiz_transfer_detail', {
                  url: '/postbiz_transfer_detail',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_info_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_info_detail.js'+getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户申请审核、资管复核、总经理审核
              .state('app.postbiz_transfer_approve', {
                  url: '/postbiz_transfer_approve',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_approve.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_approve.js'+getCacheTime(),
                                  'tpl/postbiz/transfer_info/transfer_info_detail.js' + getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户费用结算
              .state('app.postbiz_transfer_settlement', {
                  url: '/postbiz_transfer_settlement',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_settlement.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_settlement.js'+getCacheTime(),
                                  'tpl/postbiz/transfer_info/transfer_info_detail.js' + getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户任务：财务确认收款
              .state('app.postbiz_transfer_receipt', {
                  url: '/postbiz_transfer_receipt',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_receipt.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_receipt.js'+getCacheTime(),
                                  'tpl/postbiz/transfer_info/transfer_info_detail.js' + getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户任务：财务审核
              .state('app.postbiz_transfer_touching', {
                  url: '/postbiz_transfer_touching',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_touching.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_touching.js'+getCacheTime(),
                                  'tpl/postbiz/transfer_info/transfer_info_detail.js' + getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户任务：财务确认付款
              .state('app.postbiz_transfer_loan', {
                  url: '/postbiz_transfer_loan',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_loan.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_loan.js'+getCacheTime(),
                                  'tpl/postbiz/transfer_info/transfer_info_detail.js' + getCacheTime(),
                                  'tpl/postbiz/overdue_cstm/overdue_sales.js' + getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户退保一览
              .state('app.postbiz_transfer_info_retreats_list', {
                  url: '/postbiz_transfer_info_retreats_list',
                  templateUrl: 'tpl/postbiz/transfer_info/transfer_info_retreats_list.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/transfer_info_retreats_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //催收人员列表
              .state('app.postbiz_collection_person_list', {
                  url: '/postbiz_collection_person_list',
                  templateUrl: 'tpl/postbiz/collection_person/collection_person_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_person/collection_person_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //添加催收人员
              .state('app.postbiz_collection_person_save', {
                  url: '/postbiz_collection_person_save',
                  templateUrl: 'tpl/postbiz/collection_person/collection_person_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_person/collection_person_save.js'+getCacheTime(),
                                  'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //修改催收人员
              .state('app.postbiz_collection_person_modify', {
                  url: '/postbiz_collection_person_modify',
                  templateUrl: 'tpl/postbiz/collection_person/collection_person_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_person/collection_person_modify.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //催收人员详情
              .state('app.postbiz_collection_person_detail', {
                  url: '/postbiz_collection_person_detail',
                  templateUrl: 'tpl/postbiz/collection_person/collection_person_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_person/collection_person_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收任务一览
              .state('app.postbiz_collection_task_list', {
                  url: '/postbiz_collection_task_list',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收申请
              .state('app.postbiz_collection_task_save', {
                  url: '/postbiz_collection_task_save',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_save.js'+getCacheTime(),
                                  'tpl/postbiz/collection_task/cstm_select_list.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收派单
              .state('app.postbiz_collection_task_dispatch', {
                  url: '/postbiz_collection_task_dispatch',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_dispatch.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_dispatch.js'+getCacheTime(),
                                  'tpl/postbiz/collection_task/cstm_select_list.js'+getCacheTime(),
                                  'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收审核
              .state('app.postbiz_collection_task_approval', {
                  url: '/postbiz_collection_task_approval',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_approval.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_approval.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收总经理审核
              .state('app.postbiz_collection_task_manager', {
                  url: '/postbiz_collection_task_manager',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_manager.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_manager.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收登记
              .state('app.postbiz_collection_task_register', {
                  url: '/postbiz_collection_task_register',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_register.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_register.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收结果确认
              .state('app.postbiz_collection_task_confirm', {
                  url: '/postbiz_collection_task_confirm',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_confirm.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_confirm.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 上门催收详情
              .state('app.postbiz_collection_task_detail', {
                  url: '/postbiz_collection_task_detail',
                  templateUrl: 'tpl/postbiz/collection_task/collection_task_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/collection_task/collection_task_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //车检列表
              .state('app.postbiz_annual_inspection_list', {
                  url: '/postbiz_annual_inspection_list',
                  templateUrl: 'tpl/postbiz/annual_inspection/annual_inspection_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/annual_inspection/annual_inspection_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //车检更新界面
              .state('app.postbiz_annual_inspection_update', {
                  url: '/postbiz_annual_inspection_update',
                  templateUrl: 'tpl/postbiz/annual_inspection/annual_inspection_update.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/annual_inspection/annual_inspection_update.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //车检详情界面
              .state('app.postbiz_annual_inspection_detail', {
                  url: '/postbiz_annual_inspection_detail',
                  templateUrl: 'tpl/postbiz/annual_inspection/annual_inspection_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/annual_inspection/annual_inspection_detail.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //增加保证金申请
              .state('app.postbiz_deposit_change_apply', {
                  url: '/postbiz_deposit_change_apply',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_change_apply.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_change_apply.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金审核意见备注
              .state('app.postbiz_deposit_approval', {
                  url: '/postbiz_deposit_approval',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_approval.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_approval.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //增加保证金详情页面
              .state('app.postbiz_deposit_change_detail', {
                  url: '/postbiz_deposit_change_detail',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_change_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金审批页面
              .state('app.postbiz_deposit_change_approve', {
                  url: '/postbiz_deposit_change_approve',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_change_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_change_approve.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_approval.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_audit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_credit_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_person_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_risk/risk_report_company_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金合同生成备注
              .state('app.postbiz_deposit_remark', {
                  url: '/postbiz_deposit_remark',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_remark.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_remark.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //增加保证金合同生成页面
              .state('app.postbiz_deposit_contract_create', {
                  url: '/postbiz_deposit_contract_create',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_contract_create.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_contract_create.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_remark.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金补充协议上传页面
              .state('app.postbiz_deposit_contract_sign', {
                  url: '/postbiz_deposit_contract_sign',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_contract_sign.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_contract_sign.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_supple_upload.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_contract_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金合同复合页面
              .state('app.postbiz_deposit_contract_approve', {
                  url: '/postbiz_deposit_contract_approve',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_contract_approve.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_contract_approve.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_approval.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_contract_file.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金财务确认收款页面
              .state('app.postbiz_deposit_finance_receipt', {
                  url: '/postbiz_deposit_finance_receipt',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_finance_receipt.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/deposit_change_task/deposit_finance_receipt.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime()
                              ]);
                          }]
                  }
              })
              //增加保证金车辆出库
              .state('app.postbiz_deposit_change_export', {
                  url: '/postbiz_deposit_change_export',
                  templateUrl: 'tpl/postbiz/deposit_change_task/deposit_change_export.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/deposit_change_task/deposit_change_export.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/postbiz/deposit_change_task/deposit_change_detail.js'+getCacheTime(),
                                  'tpl/postbiz/vehicle_disposal/vehicle_export.js'+getCacheTime(),
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //指标管理
              .state('app.postbiz_license_idx_list', {
                  url: '/postbiz_license_idx_list',
                  templateUrl: 'tpl/postbiz/license_idx/license_idx_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/license_idx/license_idx_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //新增指标
              .state('app.postbiz_license_idx_save', {
                  url: '/postbiz_license_idx_save',
                  templateUrl: 'tpl/postbiz/license_idx/license_idx_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster'
                                  ,'tpl/postbiz/license_idx/license_idx_save.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //修改指标
              .state('app.postbiz_license_idx_modify', {
                  url: '/postbiz_license_idx_modify',
                  templateUrl: 'tpl/postbiz/license_idx/license_idx_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster'
                                  ,'tpl/postbiz/license_idx/license_idx_modify.js'+getCacheTime(),
                                  'tpl/product/product/product_user.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //指标详情
              .state('app.postbiz_license_idx_detail', {
                  url: '/postbiz_license_idx_detail',
                  templateUrl: 'tpl/postbiz/license_idx/license_idx_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster'
                                  ,'tpl/postbiz/license_idx/license_idx_detail.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 车辆处置一览
              .state('app.postbiz_vehicle_disposal_list', {
                  url: '/postbiz_vehicle_disposal_list',
                  templateUrl: 'tpl/postbiz/vehicle_disposal/vehicle_disposal_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 车辆处置申请
              .state('app.postbiz_vehicle_disposal_apply', {
                  url: '/postbiz_vehicle_disposal_apply',
                  templateUrl: 'tpl/postbiz/vehicle_disposal/vehicle_disposal_apply.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_apply.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 车辆处置申请
              .state('app.postbiz_vehicle_disposal_detail', {
                  url: '/postbiz_vehicle_disposal_detail',
                  templateUrl: 'tpl/postbiz/vehicle_disposal/vehicle_disposal_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster',
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_detail.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              //开票数据一览
              .state('app.postbiz_invoice_list',{
                      url: '/postbiz_invoice_list',
                      templateUrl: 'tpl/postbiz/invoice/invoice_list.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/invoice/invoice_list.js'+getCacheTime(),
                                      'tpl/postbiz/invoice/invoice_printinv_confirm.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //自动开票打印
              .state('app.postbiz_invoice_auto_list',{
                      url: '/postbiz_invoice_auto_list',
                      templateUrl: 'tpl/postbiz/invoice/invoice_auto_list.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/invoice/invoice_auto_list.js'+getCacheTime(),
                                      'tpl/postbiz/invoice/invoice_printinv_result.js'+getCacheTime(),
                                      'tpl/alert/confirm.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //手动开票
              .state('app.postbiz_invoice_manual',{
                      url: '/postbiz_invoice_manual',
                      templateUrl: 'tpl/postbiz/invoice/invoice_manual.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/invoice/invoice_manual.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //车辆维修记录列表
              .state('app.postbiz_veh_maintain_list', {
                  url: '/postbiz_veh_maintain_list',
                  templateUrl: 'tpl/postbiz/veh_maintain/veh_maintain_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/veh_maintain/veh_maintain_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //车辆维修记录详情
              .state('app.postbiz_veh_maintain_detail', {
                  url: '/postbiz_veh_maintain_detail',
                  templateUrl: 'tpl/postbiz/veh_maintain/veh_maintain_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/veh_maintain/veh_maintain_detail.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //添加车辆维修记录
              .state('app.postbiz_veh_maintain_save', {
                  url: '/postbiz_veh_maintain_save',
                  templateUrl: 'tpl/postbiz/veh_maintain/veh_maintain_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/veh_maintain/veh_maintain_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/prebiz/contract/contract_list_select.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //修改车辆维修记录
              .state('app.postbiz_veh_maintain_modify', {
                  url: '/postbiz_veh_maintain_modify',
                  templateUrl: 'tpl/postbiz/veh_maintain/veh_maintain_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/veh_maintain/veh_maintain_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_save.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_pers_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_comp_modify.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/guarantee_info.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_person_list.js'+getCacheTime(),
                                  'tpl/prebiz/apply_input/crm_company_list.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/common/file/file_list.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务一览
              .state('app.postbiz_lawsuit_task_list', {
                  url: '/postbiz_lawsuit_task_list',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务申请画面
              .state('app.postbiz_lawsuit_task_save', {
                  url: '/postbiz_lawsuit_task_save',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_save.js'+getCacheTime(),
                                  'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/cost/overdue_cont/overdue_cont_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务风控经理审核
              .state('app.postbiz_lawsuit_task_approval', {
                  url: '/postbiz_lawsuit_task_approval',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_approval.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_approval.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务副总审核
              .state('app.postbiz_lawsuit_task_demanager', {
                  url: '/postbiz_lawsuit_task_demanager',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_demanager.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_demanager.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务总经理审核
              .state('app.postbiz_lawsuit_task_manager', {
                  url: '/postbiz_lawsuit_task_manager',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_manager.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_manager.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务登记
              .state('app.postbiz_lawsuit_task_register', {
                  url: '/postbiz_lawsuit_task_register',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_register.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_register.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //诉讼任务详情
              .state('app.postbiz_lawsuit_task_detail', {
                  url: '/postbiz_lawsuit_task_detail',
                  templateUrl: 'tpl/postbiz/lawsuit_task/lawsuit_task_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/lawsuit_task/lawsuit_task_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //转固定资产流程总经理审批
              .state('app.postbiz_capital_assets_manager', {
                  url: '/postbiz_capital_assets_manager',
                  templateUrl: 'tpl/postbiz/capital_assets/capital_assets_manager.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/capital_assets/capital_assets_manager.js'+getCacheTime(),
                                  'tpl/postbiz/vehicle_disposal/vehicle_disposal_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  // 文件上传
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //发起收车任务
              .state('app.postbiz_retrieve_cars_task_launch',{
                      url: '/postbiz_retrieve_cars_task_launch',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_launch.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_launch.js'+getCacheTime(),
                                      'tpl/cost/overdue_cont/overdue_cont_list_select.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //收车任务一览
              .state('app.postbiz_retrieve_cars_task_list',{
                      url: '/postbiz_retrieve_cars_task_list',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_list.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_list.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //收车任务风控派单
              .state('app.postbiz_retrieve_cars_task_risk',{
                      url: '/postbiz_retrieve_cars_task_risk',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_risk.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_risk.js'+getCacheTime(),
                                      'tpl/system/sys_user/sys_user_list_select.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )

              //收车任务审批
              .state('app.postbiz_retrieve_cars_task_approve',{
                      url: '/postbiz_retrieve_cars_task_approve',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_approve.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_approve.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务委派和登记
              .state('app.postbiz_retrieve_cars_task_register',{
                      url: '/postbiz_retrieve_cars_task_register',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_register.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_register.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务车辆入库
              .state('app.postbiz_retrieve_cars_task_storage',{
                      url: '/postbiz_retrieve_cars_task_storage',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_storage.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_storage.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务确认交接
              .state('app.postbiz_retrieve_cars_task_handover',{
                      url: '/postbiz_retrieve_cars_task_handover',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_handover.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_handover.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务财务审核
              .state('app.postbiz_retrieve_cars_task_financial',{
                      url: '/postbiz_retrieve_cars_task_financial',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_financial.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_financial.js'+getCacheTime(),
                                      'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务总经理审核
              .state('app.postbiz_retrieve_cars_task_audit',{
                      url: '/postbiz_retrieve_cars_task_audit',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_audit.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_audit.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //收车任务详情
              .state('app.postbiz_retrieve_cars_task_detail',{
                      url: '/postbiz_retrieve_cars_task_detail',
                      templateUrl: 'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_detail.html'+getCacheTime(),
                      resolve: {
                          deps: ['$ocLazyLoad',
                              function( $ocLazyLoad ){
                                  return $ocLazyLoad.load(['toaster',
                                      'tpl/postbiz/retrieve_cars_task/retrieve_cars_task_detail.js'+getCacheTime(),
                                      'js/fileinput/fileinput.min.js'+getCacheTime(),
                                      'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                      'css/fileinput/fileinput.min.css'+getCacheTime(),
                                      'tpl/common/file/file_list.js'+getCacheTime(),
                                      'tpl/common/file/file_upload.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file.js'+getCacheTime(),
                                      'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                      'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                      'tpl/common/file/file_list_tabs.js'+getCacheTime(),
                                      'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                      'tpl/cost/cont_prepayment/cont_prepayment_try_count.js'+getCacheTime(),
                                  ]);
                              }]
                      }
                  }
              )
              //库存管理列表
              .state('app.postbiz_sec_hand_inventory_list', {
                  url: '/postbiz_sec_hand_inventory_list',
                  templateUrl: 'tpl/postbiz/sec_hand_inventory/sec_hand_inventory_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/sec_hand_inventory/sec_hand_inventory_list.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //添加库存管理记录
              .state('app.postbiz_sec_hand_inventory_save', {
                  url: '/postbiz_sec_hand_inventory_save',
                  templateUrl: 'tpl/postbiz/sec_hand_inventory/sec_hand_inventory_save.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/sec_hand_inventory/sec_hand_inventory_save.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //修改库存管理记录
              .state('app.postbiz_sec_hand_inventory_modify', {
                  url: '/postbiz_sec_hand_inventory_modify',
                  templateUrl: 'tpl/postbiz/sec_hand_inventory/sec_hand_inventory_modify.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/sec_hand_inventory/sec_hand_inventory_modify.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //库存管理记录详情
              .state('app.postbiz_sec_hand_inventory_detail', {
                  url: '/postbiz_sec_hand_inventory_detail',
                  templateUrl: 'tpl/postbiz/sec_hand_inventory/sec_hand_inventory_detail.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/sec_hand_inventory/sec_hand_inventory_detail.js'+getCacheTime(),

                              ]);
                          }]
                  }
              })
              //当月提报数据统计表
              .state('app.postbiz_report_statistics_list', {
                  url: '/postbiz_report_statistics_list',
                  templateUrl: 'tpl/postbiz/license_idx/report_statistics_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/license_idx/report_statistics_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //月度租金到账率
              .state('app.postbiz_monthly_rent_list', {
                  url: '/postbiz_monthly_rent_list',
                  templateUrl: 'tpl/postbiz/monthly_rent/monthly_rent_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/monthly_rent/monthly_rent_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资租赁业务统计报表
              .state('app.postbiz_business_statistics_list', {
                  url: '/postbiz_business_statistics_list',
                  templateUrl: 'tpl/postbiz/license_idx/business_statistics_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/license_idx/business_statistics_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //融资租赁审批数据统计报表
              .state('app.postbiz_approval_statistics_list', {
                  url: '/postbiz_approval_statistics_list',
                  templateUrl: 'tpl/postbiz/license_idx/approval_statistics_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/license_idx/approval_statistics_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //逾期率统计表
              .state('app.postbiz_monthly_overdue_list', {
                  url: '/postbiz_monthly_overdue_list',
                  templateUrl: 'tpl/postbiz/monthly_overdue/monthly_overdue_list.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/monthly_overdue/monthly_overdue_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //保险理赔财务确认收款
              .state('app.insurance_cont_insur_claim_receivables', {
                  url: '/insurance_cont_insur_claim_receivables',
                  templateUrl: 'tpl/insurance/cont_insur_claim/cont_insur_claim_receivables.html'+getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/insurance/cont_insur_claim/cont_insur_claim_receivables.js'+getCacheTime(),
                                  'tpl/common/file/file_list_directive.js'+getCacheTime(),
                                  'tpl/common/file/file_upload.js'+getCacheTime(),
                                  'tpl/common/tree_file/tree_file_directive.js'+getCacheTime(),
                                  'js/fileinput/fileinput.min.js'+getCacheTime(),
                                  'js/fileinput/bootstrap.min.js'+getCacheTime(),
                                  'css/fileinput/fileinput.min.css'+getCacheTime(),
                                  'tpl/insurance/cont_insur_claim/cont_insur_claim_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              //贷前财务付款清单一览查询
          .state('app.financial_prebiz_cont_pay_detail_list',{
              url: '/financial_prebiz_cont_pay_detail_list',
              templateUrl: 'tpl/finance/financial_prebiz_cont_pay/financial_prebiz_cont_pay_detail_list.html'+getCacheTime(),
              resolve: {
                  deps: ['$ocLazyLoad',
                      function( $ocLazyLoad ){
                          return $ocLazyLoad.load(['toaster',
                              'tpl/finance/financial_prebiz_cont_pay/financial_prebiz_cont_pay_detail_list.js'+getCacheTime(),
                          ]);
                      }]
              }
          })
          //贷前财务付款清单汇总一览查询
          .state('app.finance_cont_pay_list',{
              url: '/finance_cont_pay_list',
              templateUrl: 'tpl/finance/financial_prebiz_cont_pay/finance_cont_pay_list.html'+getCacheTime(),
              resolve: {
                  deps: ['$ocLazyLoad',
                      function( $ocLazyLoad ){
                          return $ocLazyLoad.load(['toaster',
                              'tpl/finance/financial_prebiz_cont_pay/finance_cont_pay_list.js'+getCacheTime(),
                          ]);
                      }]
              }
          })
          // 过户退保申请
              .state('app.postbiz_surrender_charge_apply', {
                  url: '/postbiz_surrender_charge_apply',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_apply.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_apply.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户退保详情
              .state('app.postbiz_surrender_charge_detail', {
                  url: '/postbiz_surrender_charge_detail',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_detail.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_detail.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户退保资管审核
              .state('app.postbiz_surrender_charge_approve', {
                  url: '/postbiz_surrender_charge_approve',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_approve.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_approve.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

              // 过户退保财务确认收款
              .state('app.postbiz_surrender_charge_receivables', {
                  url: '/postbiz_surrender_charge_receivables',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_receivables.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_receivables.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户退保财务制单
              .state('app.postbiz_surrender_charge_review', {
                  url: '/postbiz_surrender_charge_review',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_review.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_review.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                                  'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })
              // 过户退保财务放款
              .state('app.postbiz_surrender_charge_confirm', {
                  url: '/postbiz_surrender_charge_confirm',
                  templateUrl: 'tpl/postbiz/transfer_info/surrender_charge_confirm.html' + getCacheTime(),
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['toaster','tpl/postbiz/transfer_info/surrender_charge_confirm.js'+getCacheTime(),
                                  'tpl/common/process_log/process_log_list.js'+getCacheTime(),
                              ]);
                          }]
                  }
              })

      }
    ]
  ).config(['$httpProvider', function($httpProvider) {
    //Handle 401 Error
    $httpProvider.interceptors.push(function($q, $injector) {
        return {
            response: function(response){
                return response || $q.when(response);
            },
            responseError: function(rejection){
                var currentUrl = $injector.get('$location').url();
                if(rejection.status === 401){
                    //var state = $injector.get('$state');
                    //state.go("access.signin");
                    window.parent.location.href = "/#/access/signin";
                }
                return $q.reject(rejection);
            }
        };
    });
}]);