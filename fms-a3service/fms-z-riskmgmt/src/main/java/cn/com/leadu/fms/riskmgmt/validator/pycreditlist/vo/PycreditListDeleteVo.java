package cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PycreditListVo
 * @Description: 鹏元查询一览删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditListDeleteVo extends BaseVo<PycreditList> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 鹏元查询id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditId;

}