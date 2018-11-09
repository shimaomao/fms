package cn.com.leadu.fms.pojo.finance.vo.contrepaysked;/**
 * Created by ningyangyang on 2018/9/3.
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: fms
 * @Description: 还款计划表已还信息载体
 * @author: ningyangyang
 * @date 2018/9/3 10:14
 */
@Data
public class ContRepaySkedAlreadyPayInfoVo {
    /**
     * @Fields  : 已还期数
     * @author ningyangyang
     */
    private Integer alreadyRepayNper;

    /**
     * @Fields  : 已还金额
     * @author ningyangyang
     */
    private BigDecimal alreadyRepayAmount;

    /**
     * @Fields  : 最近未还日期
     * @author ningyangyang
     */
    private Date startValiDate;
}
