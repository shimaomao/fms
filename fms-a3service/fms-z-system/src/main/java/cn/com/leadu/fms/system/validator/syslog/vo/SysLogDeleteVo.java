package cn.com.leadu.fms.system.validator.syslog.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: SysLogVo
 * @Description: 日志管理删除时载体及验证
 * @date 2018-04-10
 */
@Data
public class SysLogDeleteVo extends BaseVo<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 日志ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String logId;

}