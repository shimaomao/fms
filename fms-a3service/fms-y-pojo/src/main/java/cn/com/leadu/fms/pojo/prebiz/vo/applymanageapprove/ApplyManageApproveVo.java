package cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove;/**
 * Created by yyq on 2018/6/30.
 */

import lombok.Data;

/**
 * @program: fms
 * @description: 总经理审核Vo
 * @author: yangyiquan
 * @create: 2018-06-30 15:32
 **/
@Data
public class ApplyManageApproveVo {

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
}
