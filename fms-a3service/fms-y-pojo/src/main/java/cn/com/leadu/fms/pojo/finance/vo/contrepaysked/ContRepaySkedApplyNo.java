package cn.com.leadu.fms.pojo.finance.vo.contrepaysked;/**
 * Created by ningyangyang on 2018/5/23.
 */

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/5/23 14:45
 */
@Data
public class ContRepaySkedApplyNo extends PageQuery<ContRepaySked> {

    private static final long serialVersionUID = 1L;
    /**
     * @Fields  : 最早逾期合同
     */
    private Date minDate;

    /**
     * @Fields  : 逾期期数
     */
    private Integer overduePeriods;

    /**
     * @Fields  : 当前逾期本金
     */
    private BigDecimal overduePrincipal;

    /**
     * @Fields  : 当前逾期租金
     */
    private BigDecimal overdueRent;
}
