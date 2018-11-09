package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import lombok.Data;

/**
 * @author liujinge
 * @ClassName: RuleInsuranceVo
 * @Description: 规则引擎 险种类型入力vo
 * @date 2018/6/15
 */
@Data
public class RuleInsuranceVo {

    /**
     * @Fields  : 申请类型
     */
    private String applyType;
    /**
     * @Fields  : 企业类型1
     * @author liujinge
     */
    private String companyType1;

    /**
     * @Fields  : 企业类型2
     * @author liujinge
     */
    private String companyType2;
    
    /** 
     * @Fields  : 险种类型
     * @author liujinge
     */ 
    private String insuranceType;


}
