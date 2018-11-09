package cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PycreditAntiVo
 * @Description: 反欺诈分析删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditAntiDeleteVo extends BaseVo<PycreditAnti> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 反欺诈分析id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditAntiId;

}