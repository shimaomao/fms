package cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrVo
 * @Description: 客户个人地址信息删除时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersAddrDeleteVo extends BaseVo<CstmPersAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人地址信息id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String persAddrId;

}