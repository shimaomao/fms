package cn.com.leadu.fms.system.validator.sysannouncement.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementVo
 * @Description: 利率因子删除时载体及验证
 * @date 2018-04-27
 */
@Data
public class SysAnnouncementDeleteListVo extends BaseVo<SysAnnouncement> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 公告id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> announceIds;

}