package cn.com.leadu.fms.common.constant;

/**
 * @author qiaomengnan
 * @ClassName: Constants
 * @Description: 框架常量配置
 * @date 2018/1/7
 */
public class FrameworkConstants {

    public static final String  COMPONENT_SCAN = "cn.com.leadu.fms";

    public static final String  ENABLE_FEIGN_CLIENTS = "cn.com.leadu.fms";

    public static final String MAPPER_SCAN =  "cn.com.leadu.fms.data.*.dao";

    public static final String AOP_REPOSITORY_INSERT = "execution(* cn.com.leadu.fms.data..*.insert*Data(..))";

    public static final String AOP_REPOSITORY_UPDATE = "execution(* cn.com.leadu.fms.data..*.update*Data(..))";

    public static final String AOP_REPOSITORY_DELETE = "execution(* cn.com.leadu.fms.data..*.delete*Data(..))";

    public static final String AOP_REPOSITORY_INSERT_LIST = "execution(* cn.com.leadu.fms.data..*.insert*DataList(..))";

    public static final String AOP_REPOSITORY_UPDATE_LIST = "execution(* cn.com.leadu.fms.data..*.update*DataList(..))";

    public static final String AOP_REPOSITORY_DELETE_LIST = "execution(* cn.com.leadu.fms.data..*.delete*DataList(..))";

}
