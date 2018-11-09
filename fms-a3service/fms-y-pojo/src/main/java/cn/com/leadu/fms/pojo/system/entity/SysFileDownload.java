package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: SysFileDownload
 * @Description:
 * @date 2018/1/23
 */
@Data
public class SysFileDownload extends BaseEntity<SysFileDownload> {

    private String sysFileId;

    private String sysUserId;

}
