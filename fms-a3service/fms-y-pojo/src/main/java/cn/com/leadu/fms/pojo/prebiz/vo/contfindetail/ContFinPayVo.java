package cn.com.leadu.fms.pojo.prebiz.vo.contfindetail;/**
 * Created by yyq on 2018/5/25.
 */

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: fms
 * @description: 融资费用明细和财务付款vo
 * @author: yangyiquan
 * @create: 2018-05-25 13:55
 **/
@Data
public class ContFinPayVo extends PageQuery<ContFinDetail>{

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合同融资费用明细ID
     */
    private String contFinDetailId;

    /**
     * @Fields  : 合同编号
     */
    private String contNo;

    /**
     * @Fields  : 订单编号
     */
    private String applyNo;

    /**
     * @Fields  : 融资项目代码
     */
    private String finItem;

    /**
     * @Fields  : 融资项目名称
     */
    private String finItemName;

    /**
     * @Fields  : 融资项目年限
     */
    private Integer finItemYear;

    /**
     * @Fields  : 融资额
     */
    private BigDecimal finAmount;

    /**
     * @Fields  : 财务科目代码
     * @author yangyiquan
     */
    private String finassSubjectCd;

    /**
     * @Fields  :付款信息
     */
    private ContPay contPay;

    /**
     * @Fields  :是否确认付款
     */
    private String confirmPayStatus;
}
