package cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtVo
 * @Description: 企业债务删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpDebtDeleteListVo extends BaseVo<PycreditCorpDebt> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业债务id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> pycreditCorpDebtIds;

}