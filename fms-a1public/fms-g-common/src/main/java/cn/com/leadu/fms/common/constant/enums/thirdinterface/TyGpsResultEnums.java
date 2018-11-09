package cn.com.leadu.fms.common.constant.enums.thirdinterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GpsTyResultEnums
 * @Description: gps天易接口返回result类型
 * @date 2018/7/4
 */
public enum TyGpsResultEnums {

    SUCCESS("0","调用成功"),
    PARAMETER_ERROR("1","参数错误"),
    AUTH_ERROR("2","鉴权失败"),
    OTHER_ERROR("9","其他错误");

    private String result;

    private String name;


    TyGpsResultEnums(String result, String name){
        this.result = result;
        this.name = name;
    }

    public String getResult(){
        return result;
    }

    public String getName(){
        return name;
    }

    public static class status {
        private static final Map<String,String> statusMap = new HashMap<>();
        static {
            for(TyGpsResultEnums enumValue : TyGpsResultEnums.values()){
                statusMap.put(enumValue.getResult(),enumValue.getName());
            }
        }
        public static String getStatusName(String status){
            return statusMap.get(status);
        }
    }

}
