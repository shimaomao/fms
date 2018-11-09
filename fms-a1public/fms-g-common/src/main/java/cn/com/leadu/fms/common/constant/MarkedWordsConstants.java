package cn.com.leadu.fms.common.constant;

/**
 * @author qiaomengnan
 * @ClassName: MarkedWordsConstants
 * @Description: 消息提示语
 * @date 2018/5/29
 */
public class MarkedWordsConstants {
    
    /** 
     * @Fields  : sql更新排他错误提示
     * @author qiaomengnan
     */ 
    public static final String SQL_EXCLUSIVE_ERROR_MESSAGE = "修改失败,当前记录已被修改过";

    /**
     * @Fields  : 排他更新未获取到最后一次更新时间
     * @author qiaomengnan
     */
    public static final String SQL_GET_UPDATE_TIME_LAST_ERROR_MESSAGE = "修改失败,未获取到最后一次更新时间";

    /**
     * @Fields  : 未获取到主键
     * @author qiaomengnan
     */
    public static final String SQL_GET_ID_ERROR_MESSAGE = "未获取到主键";

    /**
     * @Fields  : 获取主键值错误,更新失败
     * @author qiaomengnan
     */
    public static final String SQL_GET_ID_VALUE_ERROR_MESSAGE = "获取主键值错误,更新失败";

    /**
     * @Fields  : 表中的主键列必须是一个才可以使用此方法
     * @author qiaomengnan
     */
    public static final String SQL_ID_ONLY_ERROR_MESSAGE = "表中的主键列必须是一个才可以使用此方法";

    /**
     * @Fields  : example不能为空
     * @author qiaomengnan
     */
    public static final String SQL_EXAMPLE_NOT_NULL_ERROR_MESSAGE = "example不能为空";

    /**
     * @Fields  : example条件不存在
     * @author qiaomengnan
     */
    public static final String SQL_EXAMPLE_CRITERIA_NOT_EXIST_ERROR_MESSAGE = "example条件不存在";

    /**
     * @Fields  : example条件不存在
     * @author qiaomengnan
     */
    public static final String SQL_EXAMPLE_CRITERION_NOT_EXIST_ERROR_MESSAGE = "example条件不存在";

    /**
     * @Fields  : example条件不存在
     * @author qiaomengnan
     */
    public static final String SQL_EXAMPLE_CRITERION_VALUE_NOT_EXIST_ERROR_MESSAGE = "example条件值不存在";

}
