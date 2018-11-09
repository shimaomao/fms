package cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckVo
 * @Description: 企业银行卡核查删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpBkcheckDeleteVo extends BaseVo<PycreditCorpBkcheck> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业银行卡核查id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditCorpBkcheckId;

}