/**
 * Created by huchenghao on 2018/2/26.
 */
var AreaUtils=new Object();
var common_area_value={};
var common_area_code={
    //省份list
    getProvinceList:'provinceList',
    //城市list   getCityList.get(province code)
    getCityList:'cityMapList',
    //区县list   getCityList.get(city code)
    getAreaList:'areaMapList',
    //areacode取名称 getName.get(key)
    getName:'areaMap',
};
//所有省份list
AreaUtils.getAllProvinceList=function(){
    return common_area_value[common_area_code.getProvinceList];
}

AreaUtils.getAllCityList = function(){
    return common_area_value [common_area_code.getCityList];
}

AreaUtils.getAllAreaList = function(){
    return common_area_value[common_area_code.getAreaList];
}

//根据省份代码获取城市list
AreaUtils.getCityList=function(cityCode){
    return common_area_value[common_area_code.getCityList][cityCode];
}
//根据城市代码获取区县list
AreaUtils.getAreaList=function(areaCode){
    return common_area_value[common_area_code.getAreaList][areaCode];
}

AreaUtils.getAllAreaName=function(){
    return common_area_value[common_area_code.getName];
}
AreaUtils.getAreaName=function(code){
    if(isNotNullEmpty(code) && isNotUndefined(code)){
        return common_area_value[common_area_code.getName][code];
    }else{
        return "";
    }
}


AreaUtils.commonAreaValuesVersion = "commonAreaValuesVersion";
AreaUtils.commonAreaValues = "commonAreaValues";

AreaUtils.setCommonAreaValues = function (data) {
    common_area_value = data.commonAreaValues.province;
    localStorage[AreaUtils.commonAreaValues] = JSON.stringify(data.commonAreaValues.province);
    localStorage[AreaUtils.commonAreaValuesVersion] = data.commonAreaValuesVersion;
}


AreaUtils.initCommonArea = function () {

    var confirmRequest = false;
    var commonAreaValues = localStorage[AreaUtils.commonAreaValues];
    //判断区域是否为空,为空则去取值
    if(CommonObjectUtils.isNotExist(commonAreaValues)){
        confirmRequest = true;
    }
    //如果值已经为空则不用判断version了，直接拿值
    if(!confirmRequest){
        var version = localStorage[AreaUtils.commonAreaValuesVersion];
        //对比常量字典的版本,不一致去取值
        $.ajax({
            type : "get",
            url  : "bas_area/findBasAreaValuesVersion",
            async : false,
            dataType : 'json',
            success : function(data){
                if(version != data.data){
                    confirmRequest = true;
                }
            },
            error : function(data){
                confirmRequest = true;
            }
        });
    }
    if(confirmRequest){
        $.ajax({
            type : "get",
            url : "bas_area/findBasAreas",
            async : false,
            dataType : 'json',
            success : function(data){
                AreaUtils.setCommonAreaValues(data.data)
                //common_area_value = data.data.province;
            }
        });
    }else{
        common_area_value = JSON.parse(commonAreaValues);
    }
}

AreaUtils.initCommonArea();

