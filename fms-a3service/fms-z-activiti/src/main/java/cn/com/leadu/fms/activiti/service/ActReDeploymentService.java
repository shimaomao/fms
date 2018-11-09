package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import org.activiti.engine.repository.Model;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentService
 * @Description: 流程文件部署信息service
 * @date 2018/3/13
 */
public interface ActReDeploymentService {

    /**
     * @Title:
     * @Description:   分页查询流程文件信息
     * @param actReDeploymentVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 03:28:35
     */
    PageInfoExtend<ActReDeploymentVo> findActReDeploymentsByPage(ActReDeploymentVo actReDeploymentVo);

}
