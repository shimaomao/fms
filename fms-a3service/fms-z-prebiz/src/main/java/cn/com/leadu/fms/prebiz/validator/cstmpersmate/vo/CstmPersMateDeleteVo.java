package cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateVo
 * @Description: 客户个人配偶信息删除时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersMateDeleteVo extends BaseVo<CstmPersMate> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String persMateId;

}