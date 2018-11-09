package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeResultEnums
 * @Description: 天易返回结果状态码
 * @date 2018/7/18
 */
public enum  KingDeeResultEnums {

    SUCCESS("0","调用成功");

    private String result;

    private String name;

    KingDeeResultEnums(String result, String name){
        this.result = result;
        this.name = name;
    }

    public String getResult(){
        return result;
    }

    public String getName(){
        return name;
    }

}
