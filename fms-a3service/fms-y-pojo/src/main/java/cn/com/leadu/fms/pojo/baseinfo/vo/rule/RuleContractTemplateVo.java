package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: RuleContractTemplateVo
 * @Description: 规则引擎 合同模板规则入例vo
 * @date 2018/6/15
 */
@Data
public class RuleContractTemplateVo {

    /** 
     * @Fields  : 实际销售方所属集团
     * @author qiaomengnan
     */ 
    private String withinGroup;

    /** 
     * @Fields  : 业务类型
     * @author qiaomengnan
     */ 
    private String licenseAttr;

    /** 
     * @Fields  : 车型
     * @author qiaomengnan
     */ 
    private String vehicleType2;
    
    /** 
     * @Fields  : 合同模板
     * @author qiaomengnan
     */ 
    private String template;

    /**
     * @Fields  : 产品方案
     * @author yanfengbo
     */
    private String 	product;


}
