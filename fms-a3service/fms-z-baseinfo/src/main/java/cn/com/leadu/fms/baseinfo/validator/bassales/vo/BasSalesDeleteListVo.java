package cn.com.leadu.fms.baseinfo.validator.bassales.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasSalesVo
 * @Description: 实际销售方删除时载体及验证
 * @date 2018-05-03
 */
@Data
public class BasSalesDeleteListVo extends BaseVo<BasSales> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 实际销售方id
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> salesIds;

}