package cn.com.leadu.fms.pojo.activiti.vo.actredeployment;

import cn.com.leadu.fms.common.vo.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentVo
 * @Description: 流程部署文件vo
 * @date 2018/3/13
 */
@Data
public class ActReDeploymentVo extends PageQuery<ActReDeploymentVo> {

    private String getId;

    private String getName;

    private Date getDeploymentTime;

    private String getCategory;

    private String getTenantId;

}
