package cn.com.leadu.fms.pojo.postbiz.vo.depositchange;

import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: ContConfirmBefVo
 * @Description: 增加保证金审批载体
 */
@Data
public class DepositApproveVo {

    private static final long serialVersionUID = 1L;

    /**
     * 增加保证金申请任务号
     *
     * @Fields :
     */
    private String depositTaskNo;

    /**
     * @Fields :
     */
    private String taskId;
    /**
     * @Fields :
     */
    private String remark;

    /**
     * @Fields :
     */
    private String user; //审批人

    /**
     * @Fields : 附件
     */
    private List<BizFiles> bizFilesList;
    /**
     * @Fields: 审批区分
     */
    private String detailFlag;

    /**
     * @Fields: 收款明细
     */
    private List<DepositFinanceVo> depositFinanceVoList;


    /*********车辆出库用********/
    /**
     * @Fields  : 出库时间
     * @author wangxue
     */
    private Date shipmentDate;

    /**
     * @Fields  : 出库经办人
     * @author wangxue
     */
    private String agent;

    /**
     * @Fields  : 出库经办人联系方式
     * @author wangxue
     */
    private String agentMobileNo;


}