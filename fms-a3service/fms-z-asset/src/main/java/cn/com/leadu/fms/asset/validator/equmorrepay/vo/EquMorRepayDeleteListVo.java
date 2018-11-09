package cn.com.leadu.fms.asset.validator.equmorrepay.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayVo
 * @Description: 资方抵押还款计划删除时载体及验证
 * @date 2018-05-30
 */
@Data
public class EquMorRepayDeleteListVo extends BaseVo<EquMorRepay> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资方抵押还款计划表id
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> equMorRepayIds;

}