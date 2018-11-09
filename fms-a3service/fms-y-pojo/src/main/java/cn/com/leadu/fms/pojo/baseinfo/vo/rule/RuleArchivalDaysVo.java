package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: RuleContractTemplateVo
 * @Description: 规则引擎 合同模板规则入例vo
 * @date 2018/6/15
 */
@Data
public class RuleArchivalDaysVo {

    /** 
     * @Fields  : 出租人
     * @author qiaomengnan
     */ 
    private String belongGroup;

    /** 
     * @Fields  : 归档期限天数
     * @author qiaomengnan
     */ 
    private String archivalDays;

}
