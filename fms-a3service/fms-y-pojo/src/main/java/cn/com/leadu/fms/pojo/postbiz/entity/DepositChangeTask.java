package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTask
 * @Description: 保证金变更任务实体
 */
@Data
public class DepositChangeTask extends BaseEntity<DepositChangeTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields : 变更任务ID
     * @author huzongcheng
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = IdGenerator.ID_GENERATOR)
    private String depositChangeTaskId;

    /**
     * @Fields : 变更任务号
     * @author huzongcheng
     */
    private String depositTaskNo;

    /**
     * @Fields : 变更任务状态
     * @author huzongcheng
     */
    private String depositTaskStatus;

    /**
     * @Fields : 当前节点操作人
     * @author huzongcheng
     */
    private String presentUser;

    /**
     * @Fields : 合同编号
     * @author huzongcheng
     */
    private String contNo;

    /**
     * @Fields : 补充保证金
     * @author huzongcheng
     */
    private BigDecimal supplementDeposit;

    /**
     * @Fields : 申请备注
     * @author huzongcheng
     */
    private String applyRemark;

    /**
     * @Fields : 任务提出人
     * @author huzongcheng
     */
    private String submitUser;

    /**
     * @Fields : 任务提出时间
     * @author huzongcheng
     */
    private Date submitDate;

}