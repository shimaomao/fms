package cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailVo
 * @Description: 银行流水删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class AccountDetailDeleteListVo extends BaseVo<AccountDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 银行流水id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> accountDetailIds;

}