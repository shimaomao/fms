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
 * @ClassName: CapitalAssetsTask
 * @Description: 转固定资产实体
 */
@Data
public class CapitalAssetsTask extends BaseEntity<CapitalAssetsTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields : 变更任务ID
     * @author huzongcheng
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = IdGenerator.ID_GENERATOR)
    private String capitalAssetsTaskId;

    /**
     * @Fields : 变更任务号
     * @author huzongcheng
     */
    private String capitalAssetsTaskNo;

    /**
     * @Fields : 变更任务状态
     * @author huzongcheng
     */
    private String capitalAssetsTaskStatus;

    /**
     * @Fields : 合同编号
     * @author huzongcheng
     */
    private String contNo;

    /**
     * @Fields : 当前节点操作人
     * @author huzongcheng
     */
    private String presentUser;

    /**
     * @Fields : 车辆残值
     * @author huzongcheng
     */
    private BigDecimal residualValue;

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