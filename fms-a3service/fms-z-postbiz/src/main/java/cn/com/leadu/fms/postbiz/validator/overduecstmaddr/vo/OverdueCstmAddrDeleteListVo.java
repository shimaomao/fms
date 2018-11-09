package cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrVo
 * @Description: 逾期客户地址信息删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class OverdueCstmAddrDeleteListVo extends BaseVo<OverdueCstmAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期客户地址信息ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueCstmAddrIds;

}