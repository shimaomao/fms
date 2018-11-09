package cn.com.leadu.fms.postbiz.validator.overduecstm.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 逾期客户信息删除时载体及验证
 * @date 2018-05-16
 */
@Data
public class OverdueCstmDeleteListVo extends BaseVo<OverdueCstm> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期客户ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueCstmIds;

}