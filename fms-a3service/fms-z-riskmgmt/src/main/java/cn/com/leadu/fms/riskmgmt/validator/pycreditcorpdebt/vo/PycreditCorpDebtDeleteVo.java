package cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtVo
 * @Description: 企业债务删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpDebtDeleteVo extends BaseVo<PycreditCorpDebt> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业债务id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditCorpDebtId;

}