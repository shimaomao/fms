/**
 * 画面项目权限
 * Created by wangxue on 2018/3/8.
 */

var common_frame_widget_id = {
    F000001:'F000001',
    F000002:'F000002',
    F000003:'F000003',
    F000004:'F000004',
    F000005:'F000005',
    F000006:'F000006',
    F000007:'F000007',
    F000008:'F000008',
    F000009:'F000009',
    F000401:'F000401',
    F000402:'F000402',
    F000403:'F000403',
    F000404:'F000404',
    F000405:'F000405',
    F000406:'F000406',
    F000601:'F000601',
    F000602:'F000602',
    F000603:'F000603',
    F000620:'F000620',
    F000621:'F000621',
    F000622:'F000622',
    F000641:'F000641',
    F000642:'F000642',
    F000643:'F000643',
    F000801:'F000801',
    F000802:'F000802',
    F000803:'F000803',


}

var common_widget_attribute_value = {};

var common_ele_widget_map = 'eleWidgetMap';
var common_ele_show_mod = 'showMod';
var common_ele_write_mod = 'writeMod';
var common_ele_check_mod = 'checkMod';
var common_frm_widget_name = 'frmWidgetName';

/**
 * 根据画面识别ID，获取当前页面的名称
 * @param frmWidgetId
 * @returns {*}
 */
function consNameById(frmWidgetId) {
    try {
        if (frmWidgetId == null || frmWidgetId == '') {
            return null;
        }
        var item = common_widget_attribute_value[frmWidgetId];
        if (item != null) {
            return item[common_frm_widget_name];
        }
        return null;
    }catch (err){
        console.error(err);
        return null;
    }
}

/**
 * 根据画面识别ID，获取当前页面下的全部项目的所有权限
 * @param frmWidgetId
 * @returns {*}
 */
function consItemWidgetMap(frmWidgetId){
    try {
        if (frmWidgetId == null || frmWidgetId == '') {
            return null;
        }
        var items = {};
        var itemMap = common_widget_attribute_value[frmWidgetId][common_ele_widget_map];
        for (var key in itemMap) {
            var item = itemMap[key];
            setModBoolean(item);
            items[key] = item;
        }
        return items;
    }catch (err){
        console.error(err);
        return null;
    }
}

/**
 * 设置项目的三个权限
 * @param item
 * @returns {*}
 */
function setModBoolean(item) {
    if (item != null) {
        // 项目显示权限
        if (item[common_ele_show_mod] == '1') {
            item[common_ele_show_mod] = true;
        } else {
            item[common_ele_show_mod] = false;
        }
        // 项目编辑权限
        if (item[common_ele_write_mod] == '1') {
            item[common_ele_write_mod] = true;
        } else {
            item[common_ele_write_mod] = false;
        }
        // 项目是否必须
        if (item[common_ele_check_mod] == '1') {
            item[common_ele_check_mod] = true;
        } else {
            item[common_ele_check_mod] = false;
        }
    }
}

// function initialCommonWidgetValue(){
//     $.ajax({
//         type : "get",
//         url : "sys_widget_attribute/findSysWidgetAttributeVoByTree",
//         async : false,
//         dataType : 'json',
//         success : function(data){
//             common_widget_attribute_value = data.data;
//         }
//     });
// }
//
// initialCommonWidgetValue();