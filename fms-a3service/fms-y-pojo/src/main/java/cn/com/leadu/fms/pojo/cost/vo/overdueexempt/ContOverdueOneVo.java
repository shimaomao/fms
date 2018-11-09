package cn.com.leadu.fms.pojo.cost.vo.overdueexempt;

import lombok.Data;

/**
 * @author yanfengbo
 * @ClassName: ContOverdueOneVo
 * @Description: 用于罚息免除上部页面回显的vo
 * @date
 */
@Data
public class ContOverdueOneVo {
    private static final long serialVersionUID = 1L;
    /**
     * @Fields  : 合同编号
     * @author yanfengbo
     */
    private String contNo;

    /**
     * @Fields  : 申请编号
     * @author lijunjun
     */
    private String applyNo;

    /**
     * @Fields  : 车架号
     * @author lijunjun
     */
    private String vinNo;

    /**
     * @Fields  : 承租人
     */
    private String cstmName;
}
