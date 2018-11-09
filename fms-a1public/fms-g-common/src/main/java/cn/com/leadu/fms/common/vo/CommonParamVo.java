package cn.com.leadu.fms.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: CommonParamVo
 * @Description:
 * @date 2018/6/20
 */
@Data
public class CommonParamVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 参数主键
     */
    private String paramKey;

    /**
     * @Fields  : 参数名称
     */
    private String paramName;

    /**
     * @Fields  : 参数值
     */
    private String paramValue;

}
