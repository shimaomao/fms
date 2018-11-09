package cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: AccountDetailListVo
 * @Description: 银行流水明细删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class AccountDetailListDeleteVo extends BaseVo<AccountDetailList> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 银行流水明细id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String accountDetailListId;

}