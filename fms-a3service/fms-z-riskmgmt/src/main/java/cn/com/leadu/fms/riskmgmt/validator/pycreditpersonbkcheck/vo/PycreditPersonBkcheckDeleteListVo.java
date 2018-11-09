package cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckVo
 * @Description: 个人银行卡核查删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditPersonBkcheckDeleteListVo extends BaseVo<PycreditPersonBkcheck> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人银行卡核查id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> pycreditPersonBkcheckIds;

}