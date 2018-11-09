package cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree;/**
 * Created by yyq on 2018/6/22.
 */

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: fms
 * @description: 申请有条件同意审批
 * @author: yangyiquan
 * @create: 2018-06-22 11:45
 **/
@Data
public class ApplyConditionalAgreeVo {
    private static final long serialVersionUID = 1L;
    /**
     * @Fields  :  任务id
     */
    private String taskId;
    /**
     * @Fields  : 备注
     */
    private String memo;
    /**
     * @Fields  : 当前用户
     */
    private String user;
    /**
     * @Fields  :  合同号
     * @author yangyiquan
     */
    private String contNo;
    /**
     * @Fields  :  申请号
     * @author yangyiquan
     */
    private String applyNo;
    /**
     * @Fields  : 申请类型
     */
    private String applyType;
    /**
     * @Fields  : 当前任务节点key
     */
    private String taskDefinitionKey;

    /**
     * @Fields  : 审批操作
     */
    private String actType;
    /**
     * @Fields  : 操作类型
     */
    private String codeType1;
    /**
     * @Fields: 操作代码
     */
    private String codeValue1;
    /**
     * @Fields: 申请融资信息
     */
    private ApplyFinance applyFinance;
    /**
     * @Fields  : 是否适合抵押
     */
    private String mortgageFlag;

    /**
     * @Fields  : 风险融资额
     * @author yangyiquan
     */
    private BigDecimal riskAmount;

    /**
     * @Fields  : 风控经理操作建议
     * @author yanfengbo
     */
    private String windcontrManagerProposal;
}
