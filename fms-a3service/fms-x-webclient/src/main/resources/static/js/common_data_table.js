/**
 * Created by qiaohao on 2018/1/10.
 */


var CheckBox = "checkBox";
var Radio = "radio";

/**
 * 将id设置为checkbok 可单多选
 * @param idName
 * @param idCheckBoxName
 * @returns {{title: string, data: string, render: render}}
 */
function defaultCheckBox(idName,idCheckBoxName){
    var dataName = replaceIdData(idName);
    var dataCheckBoxName = replaceIdData('ids',idCheckBoxName);
    return {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
            data:dataName,
            width:'3%',
            render: function(data,type,row,meta){
                        return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'"><i></i></label>'
                    }
            }
}

function defaultHandle(modifyName,detailName,deleteName,$compile,$scope) {
    return {
        title: '操作',
        data: 'id',
        width:'10%',
        render: function (data, type, row, meta) {
            return '<button class="btn m-b-xxs btn-xs btn-info text-center" ng-click="'+modifyName+'(\'' + data + '\')"><i class="icon-pencil"></i>编辑</button>&nbsp;' +
                '<button  class="btn m-b-xxs btn-xs btn-info text-center" ng-click="'+detailName+'(\'' + data + '\')"><i class="icon-eye"></i>查看</button>&nbsp;' +
                '<button class="btn m-b-xxs btn-xs btn-info text-center" ng-click="'+deleteName+'(\''+data+'\')"><i class="fa fa-trash-o"></i>删除</button>';
        },
        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
            $compile(nTd)($scope);
        }
    }
}

function defaultDetail(rowName,detailFucName,title,width,$compile,$scope,idName){
    var dataName = replaceIdData(idName);
    return {
        title: title,
        data: dataName,
        width:width,
        render: function (data, type, row, meta) {
            if(!row[rowName] || row[rowName] == "null"){
                return "";
            }
            return '<a class="a1" ng-click="'+detailFucName+'(\'' + data + '\')">'+row[rowName]+'</a>';
        },
        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
            $compile(nTd)($scope);
        }
    }
}

/**
 * 创建 dataTable
 * @param dataTableProperties
 * @param dataTableParams
 * @param $scope
 * @returns {*|jQuery}
 */
function createTable(dataTableProperties,dataTableParams,$scope,trSelectedEvent){
    var dataTableAjax = dataTableProperties.dataTableAjax;
    var dataTableId = dataTableProperties.dataTableId;
    //记忆页码
    if($scope.params){
        if($scope.params.start){
            var start = $scope.params.start;
            var length = $scope.params.length;
        }
    }
    var properties = {
        ajax: function(data,callback,settings){
            loadingOpen();
            setTimeout(function () {
                loadingClose();
            },5000);
            data.columns = [];
            data.search = [];
            $.ajax({
                url: dataTableAjax.url,
                type: dataTableAjax.type,
                data: $.extend(dataTableParams($scope),data),
                success: function(result) {
                    console.log($scope.params);
                    callback(result.data);
                    loadingClose();
                    if($scope.callback){
                        $scope.callback(result.data);
                    }
                }
            });
        },
        ordering : false,
        displayStart:start,
        pageLength:length,
        scrollX: true,
        aoColumns: dataTableProperties.dataTableColumn,
        serverSide : true,
        selectType: dataTableProperties.dataTableSelectType,
        // aLengthMenu: [[10, 25, 50, 100,1000000], [10, 25, 50, 100,"All"]],
        language: CommonDataTableUtils.language,
        paging: CommonObjectUtils.isExist(dataTableProperties.paging) ? false : true,
        scrollY: CommonObjectUtils.isExist(dataTableProperties.scrollY) ? dataTableProperties.scrollY : null,
        "sDom": "t<'row'><'row'<'col-md-5'<l><i>><'col-md-7 pull-right'p>>",
        "fnInitComplete": $.proxy(CommonDataTableUtils.fnInitComplete(dataTableId,$scope,trSelectedEvent), this),
        "fnDrawCallback":CommonDataTableUtils.fnDrawCallback(dataTableId)
    };
    var dataTable = $("#"+dataTableId).dataTable(properties);

    CommonDataTableUtils.dataTableGetRow(dataTable);

    return dataTable;
}

function replaceIdData(newData){
    var dataName = 'id';
    if(isNotUndefined(newData) && isNotNull(newData))
        dataName = newData;
    return dataName;
}


function replaceData(oldData,newData){
    if(isNotUndefined(newData) && isNotNull(newData))
        oldData = newData;
    return oldData;
}


function resetColumnText(title,data,width,renderFuc) {
    return {
        title: title,
        data: data,
        width: width,
        render: function (data, type, row, meta) {
            //return '<span translate="code.gender.'+row[column]+'">'+row[column]+'</span>';
            return renderFuc(data, type, row, meta);
        }
    }
}


function resetColumnNgText(title,data,width,$compile,$scope) {
    return {
        title: title,
        data: data,
        width: width,
        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
            $compile(nTd)($scope);
        }
    }
}


function resetColumnNgTextFuc(title,data,width,$compile,$scope,renderFuc) {
    return {
        title: title,
        data: data,
        width: width,
        render: function (data, type, row, meta) {
            return renderFuc(data, type, row, meta);
        },
        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
            $compile(nTd)($scope);
        }
    }
}


//dataTable工具类
var CommonDataTableUtils = new Object();

//创建dataTable表格,自定义数据内容，非ajax请求
CommonDataTableUtils.createDataTableForData = function(dataTableProperties,$scope,trSelectedEvent){
    var dataTableId = dataTableProperties.dataTableId;
    var properties = {
        data:dataTableProperties.dataTableData,
        info:false,
        bPaginate:false,
        searching:false,
        destroy:true,
        scrollX: true,
        ordering : false,
        columns:dataTableProperties.dataTableColumn,
        "sDom": "t<'row'><'row'<'col-md-5'<l><i>><'col-md-7 pull-right'p>>",
        language: CommonDataTableUtils.language
    };
    properties.selectType = dataTableProperties.dataTableSelectType;
    properties.fnInitComplete = $.proxy(CommonDataTableUtils.fnInitComplete(dataTableId,$scope,trSelectedEvent), this);
    properties.fnDrawCallback = CommonDataTableUtils.fnDrawCallback(dataTableId);
    var dataTable =  $('#'+dataTableProperties.dataTableId).dataTable(properties);

    CommonDataTableUtils.dataTableGetRow(dataTable);

    return dataTable;

};

//dataTable语言
CommonDataTableUtils.language = {
    "sProcessing": "处理中...",
        "sLengthMenu": "每页显示 _MENU_ 条信息,",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "共 _TOTAL_ 条信息<select class='form-control input-sm' style='visibility: hidden; ' />",
        "sInfoEmpty": ",【无数据显示】<select class='form-control input-sm' style='visibility: hidden; ' />",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索:",
        "sUrl": "",
        "sEmptyTable": "暂无相关信息",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }

};
//返回数据字典中对应的值
CommonDataTableUtils.getCodeValue = function(data, type, row, meta, codeType){
    return CommonCodeUtils.getCodeValueName(codeType,data)
};
//点击选中checkbox
CommonDataTableUtils.fnInitComplete = function (dataTableId,$scope,trSelectedEvent) {
    return function (oSettings, json) {
        $('#' + dataTableId + ' .a1').on('click', function (event) {
            event.stopPropagation();
        });
        if(!oSettings.oInit.selectType){
            $('#' + dataTableId + ' tbody').on('click', 'tr', function (event) {
                $(this).addClass("tr-bg");
                $(this).siblings().removeClass("tr-bg");
            });
        }
        //行单选
        if (oSettings.oInit.selectType == Radio) {
            $('#' + dataTableId + ' tbody').on('click', 'tr', function (event) {
                var ck = $(this).find('input:checkbox');
                if (!ck.prop('checked')) {
                    $('#' + dataTableId).find('tr input:checkbox').prop('checked', false);
                    ck.prop('checked', true);
                    $(this).addClass("tr-bg");
                    $(this).siblings().removeClass("tr-bg");
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),true,$scope);
                } else {
                    $(this).find('input:checkbox').prop('checked', false);
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),false,$scope);
                }
                event.stopPropagation();
            });
        } else if (oSettings.oInit.selectType == CheckBox) {
            $('#' + dataTableId + ' tbody').on('click', 'tr', function () {
                var ck = $(this).find('input:checkbox');
                ck.prop('checked', !ck.prop('checked'));
                if(ck.prop('checked')){
                    $(this).addClass("tr-bg");
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),true,$scope);
                }else{
                    $(this).removeClass("tr-bg");
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),false,$scope);
                }

                if ($('#'+ dataTableId +' [name=ids]:checkbox:checked').length == $('#'+ dataTableId +' [name=ids]:checkbox').length)
                    $("#"+dataTableId+"_wrapper [name=all_checked]").prop('checked', true);
                else
                    $("#"+dataTableId+"_wrapper [name=all_checked]").prop('checked', false);
            })
        }else if(oSettings.oInit.selectType == 'onlyClickTd'){
            $('#' + dataTableId + ' tbody tr td:first-child').on('click', function () {
                var ck = $(this).find('input:checkbox:enabled');
                ck.prop('checked', !ck.prop('checked'));
                if(ck.prop('checked')){
                    $(this).parent().addClass("tr-bg");
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),true,$scope);
                }else{
                    $(this).parent().removeClass("tr-bg");
                    if(isNotUndefined(trSelectedEvent))
                        trSelectedEvent(ck.val(),false,$scope);
                }

                if ($('#'+ dataTableId +' [name=ids]:checkbox:checked').length == $('#'+ dataTableId +' [name=ids]:checkbox').length)
                    $("#"+dataTableId+"_wrapper [name=all_checked]").prop('checked', true);
                else
                    $("#"+dataTableId+"_wrapper [name=all_checked]").prop('checked', false);
            })
        }

        if (oSettings.oInit.selectType == CheckBox || oSettings.oInit.selectType == 'onlyClickTd') {
            $("#"+dataTableId+"_wrapper [name=all_checked]").prop('checked', false);
            $("#"+dataTableId+"_wrapper [name=all_checked]").click(function () {
                $("#"+dataTableId+" [name=ids]:checkbox:enabled").prop('checked', this.checked);
                if(this.checked){
                    $("#"+dataTableId+" [name=ids]:checkbox:enabled").parent().parent().parent().addClass('tr-bg');
                }else{
                    $("#"+dataTableId+" [name=ids]:checkbox:enabled").parent().parent().parent().removeClass('tr-bg');
                }
            });
        } else {
            $("#"+dataTableId+"_wrapper [name=all_checked]").prop('disabled', true);
        }

        $('#' + dataTableId + ' [name=ids]:checkbox').click(function (event) {
            event.stopPropagation();
            return false;
        });
    }
    
};

/**
 * 设定某一列是否显示
 * @param dataTable 列表对象
 * @param columnNo 列号，第几列
 * @param visible false:隐藏、true:显示
 */
function setColumnVisible(dataTable,columnNo,visible) {
    var column = dataTable.fnSetColumnVis(columnNo,visible,false);
};

CommonDataTableUtils.fnDrawCallback = function (dataTableId) {
  return function (oSettings) {
      var oTable = $("#" + dataTableId).dataTable();
      $('#redirect').keyup(function(e){
          if(e.keyCode==13){
              var redirectpage
              if($(this).val() && $(this).val()>0){
                  redirectpage = $(this).val()-1;
              }else{
                  redirectpage = 0;
              }
              oTable.fnPageChange( redirectpage );
          }
      });
      if (oSettings.oInit.selectType == CheckBox || oSettings.oInit.selectType == 'onlyClickTd') {
          $("#" + dataTableId + "_wrapper [name=all_checked]").prop('checked', false);
          $("#" + dataTableId + "_wrapper [name=all_checked]").click(function () {
              $("#" + dataTableId + " [name=ids]:checkbox:enabled").prop('checked', this.checked);
              if(this.checked){
                  $("#"+dataTableId+" [name=ids]:checkbox:enabled").parent().parent().parent().addClass('tr-bg');
              }else{
                  $("#"+dataTableId+" [name=ids]:checkbox:enabled").parent().parent().parent().removeClass('tr-bg');
              }
          });
      } else {
          $("#" + dataTableId + "_wrapper [name=all_checked]").prop('disabled', true);
      }

      dataTableWidth(true);
  }
};
//datatable获取选中数据
CommonDataTableUtils.dataTableGetRow = function (dataTable) {

    dataTable.getAllRow = function(){
        var nTrs = dataTable.fnGetNodes();
        return nTrs;
    }

    dataTable.getRows = function(){
        var nTrs = dataTable.fnGetNodes();
        var rows = [];
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).find('[name=ids]:checkbox').prop('checked')){
                rows.push(dataTable.fnGetData(nTrs[i]));
            }
        }
        return rows;
    };

    /**
     *
     * @param id id数据
     * @param idName id的名称  默认为id  针对于名称非id的拓展
     * @returns {*}
     */
    dataTable.getRow = function(id,idName){
        var dataName = replaceIdData(idName);
        var nTrs = dataTable.fnGetNodes();
        if(isNotUndefined(id) && isNotNull(id)) {
            for(var i = 0; i < nTrs.length; i++){
                getData = dataTable.fnGetData(nTrs[i]);
                if (getData[dataName] == id){
                    return getData
                }
            }
        }else{
            for(var i = 0; i < nTrs.length; i++){
                if($(nTrs[i]).find('[name=ids]:checkbox').prop('checked')){
                    return dataTable.fnGetData(nTrs[i]);
                }
            }
        }
        return null;
    };


    dataTable.getRowsIds = function(idName){
        var dataName = replaceIdData(idName);
        var nTrs = dataTable.fnGetNodes();
        var rows = [];
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).find('[name=ids]:checkbox').prop('checked')){
                rows.push(dataTable.fnGetData(nTrs[i])[dataName]);
            }
        }
        return rows;
    };

    dataTable.getRowId = function(idName){
        var dataName = replaceIdData(idName);
        var nTrs = dataTable.fnGetNodes();
        var rows = [];
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).find('[name=ids]:checkbox').prop('checked')){
                return dataTable.fnGetData(nTrs[i])[dataName];
            }
        }
        return null;
    };
};


