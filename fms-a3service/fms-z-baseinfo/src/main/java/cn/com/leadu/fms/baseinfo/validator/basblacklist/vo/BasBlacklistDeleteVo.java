package cn.com.leadu.fms.baseinfo.validator.basblacklist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistVo
 * @Description: 黑名单删除时载体及验证
 * @date 2018-05-04
 */
@Data
public class BasBlacklistDeleteVo extends BaseVo<BasBlacklist> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 黑名单id
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String blacklistId;

}