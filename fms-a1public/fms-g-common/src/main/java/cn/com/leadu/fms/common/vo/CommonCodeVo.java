package cn.com.leadu.fms.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: SysCodeVo
 * @Description: 共通数据字典vo
 * @date 2018/3/27
 */
@Data
public class CommonCodeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 
     * @Fields  : 类型代码
     */ 
    private String codeType;

    /** 
     * @Fields  : 值
     */ 
    private String codeValue;

    /** 
     * @Fields  : 值名称
     */ 
    private String codeValueName;

    /**
     * @Fields  : 显示顺序
     */
    private Integer orderNo;

}
