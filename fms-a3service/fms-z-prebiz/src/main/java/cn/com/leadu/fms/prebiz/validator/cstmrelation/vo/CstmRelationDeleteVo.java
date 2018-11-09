package cn.com.leadu.fms.prebiz.validator.cstmrelation.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationVo
 * @Description: 融资申请客户关系删除时载体及验证
 * @date 2018-05-16
 */
@Data
public class CstmRelationDeleteVo extends BaseVo<CstmRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 客户关系主键
     * @author qiaomengnan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String relationId;

}