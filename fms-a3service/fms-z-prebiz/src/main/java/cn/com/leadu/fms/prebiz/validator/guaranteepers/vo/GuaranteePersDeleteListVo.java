package cn.com.leadu.fms.prebiz.validator.guaranteepers.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersVo
 * @Description: 担保个人信息删除时载体及验证
 * @date 2018-03-30
 */
@Data
public class GuaranteePersDeleteListVo extends BaseVo<GuaranteePers> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 担保个人id
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> guarPersIds;

}