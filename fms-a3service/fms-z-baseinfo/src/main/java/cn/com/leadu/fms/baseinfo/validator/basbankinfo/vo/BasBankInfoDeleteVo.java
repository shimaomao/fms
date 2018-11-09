package cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoVo
 * @Description: 银行账号维护删除时载体及验证
 * @date 2018-03-26
 */
@Data
public class BasBankInfoDeleteVo extends BaseVo<BasBankInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 银行ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String bankId;

}