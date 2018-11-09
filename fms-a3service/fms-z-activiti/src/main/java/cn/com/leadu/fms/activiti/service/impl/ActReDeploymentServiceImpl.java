package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActReDeploymentService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentServiceImpl
 * @Description: 流程文件部署信息service实现类
 * @date 2018/3/13
 */
@Service
public class ActReDeploymentServiceImpl implements ActReDeploymentService {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * @Title:
     * @Description:   分页查询流程文件信息
     * @param actReDeploymentVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 03:28:35
     */
    public PageInfoExtend<ActReDeploymentVo> findActReDeploymentsByPage(ActReDeploymentVo actReDeploymentVo){
        DeploymentQuery deploymentQuery = repositoryService.createDeploymentQuery()
                .orderByDeploymenTime().desc();
        List<Deployment> deployments = deploymentQuery.listPage(actReDeploymentVo.getStart(),actReDeploymentVo.getPageSize());
        List<ActReDeploymentVo> actReDeploymentVos = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(deployments)){
            for(Deployment deployment : deployments)
                actReDeploymentVos.add(EntityUtils.getEntity(deployment,new ActReDeploymentVo()));
        }
        return PageInfoExtendUtils.getPageInfoExtend(actReDeploymentVos,deploymentQuery.count(), actReDeploymentVo.getPageQuery());
    }


}
