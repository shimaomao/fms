package cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailListVo
 * @Description: 银行流水明细删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class AccountDetailListDeleteListVo extends BaseVo<AccountDetailList> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 银行流水明细id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> accountDetailListIds;

}