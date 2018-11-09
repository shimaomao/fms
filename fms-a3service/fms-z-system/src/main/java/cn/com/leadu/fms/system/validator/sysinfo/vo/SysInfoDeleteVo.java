package cn.com.leadu.fms.system.validator.sysinfo.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoVo
 * @Description: 消息管理删除时载体及验证
 * @date 2018-04-25
 */
@Data
public class SysInfoDeleteVo extends BaseVo<SysInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 消息id
     * @author qiaomengnan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String infoId;

}