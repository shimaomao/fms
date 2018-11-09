package cn.com.leadu.fms.prebiz.validator.contrepayaccount.vo;/**
 * Created by yyq on 2018/5/9.
 */

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @program: fms
 * @description: 客户还款信息修改时载体及验证
 * @author: yangyiquan
 * @create: 2018-05-09 17:06
 **/
@Data
public class ContRepayAccountModifyVo extends BaseVo<ContRepayAccount>{

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 还款信息ID
     */
    @NotBlank(message = ValidatorConstants.ID_NOT_NULL)
    private String repayAccId;

    /**
     * @Fields  : 合同编号
     */
    private String contNo;

    /**
     * @Fields  : 订单编号
     */
    private String applyNo;

    /**
     * @Fields  : 车辆序号
     */
    private String vehicleNo;

    /**
     * @Fields  : 还款借记卡户名
     */
    @NotBlank(message = "还款借记卡户名不能为空")
    private String accountName;

    /**
     * @Fields  : 还款借记卡开户证件号码
     */
    @NotBlank(message = "还款借记卡开户证件号码不能为空")
    private String certifNo;

    /**
     * @Fields  : 还款卡绑定手机号
     */
    @NotBlank(message = "还款卡绑定手机号不能为空")
    private String accMobileNo;

    /**
     * @Fields  : 还款借记卡开户行
     */
    @NotBlank(message = "还款借记卡开户行不能为空")
    private String accBank;

    /**
     * @Fields  : 还款借记卡帐号
     */
    @NotBlank(message = "还款借记卡帐号不能为空")
    private String accountNo;

}
