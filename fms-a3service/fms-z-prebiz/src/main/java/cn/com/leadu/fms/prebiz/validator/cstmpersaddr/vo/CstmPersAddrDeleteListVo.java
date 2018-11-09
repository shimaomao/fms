package cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrVo
 * @Description: 客户个人地址信息删除时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersAddrDeleteListVo extends BaseVo<CstmPersAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人地址信息id
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> persAddrIds;

}