package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActIdGroupService;
import cn.com.leadu.fms.activiti.service.ActReProcdefService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.activiti.repository.ActReProcdefRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefServiceImpl
 * @Description:
 * @date 2018/3/13
 */
@Service
public class ActReProcdefServiceImpl implements ActReProcdefService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ActReProcdefRepository actReProcdefRepository;

    @Autowired
    private ActIdGroupService actIdGroupService;


    /**
     * @Title:
     * @Description:   分页查询流程定义vos
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 05:00:50
     */
    public PageInfoExtend<ActReProcdefVo> findActReProcdefVosByPage(ActReProcdefVo actReProcdefVo){
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //查询流程定义
        List<ProcessDefinition> processDefinitions = processDefinitionQuery.latestVersion()
                .orderByDeploymentId().desc().listPage(actReProcdefVo.getStart(),actReProcdefVo.getPageSize());
        if(ArrayUtils.isNotNullAndLengthNotZero(processDefinitions)) {
            List<ActReProcdefVo> actReProcdefVos = new ArrayList<>();
            for (ProcessDefinition processDefinition : processDefinitions) {
                //流程定义vo转换
                ActReProcdefVo actReProcdefVoTmp = EntityUtils.getEntity(processDefinition, new ActReProcdefVo());
                Deployment deployment = repositoryService.createDeploymentQuery()
                        .deploymentId(actReProcdefVoTmp.getDeploymentId()).singleResult();
                //查询流程定义所属部署对象
                actReProcdefVoTmp.setActReDeploymentVo(EntityUtils.getEntity(deployment, new ActReDeploymentVo()));
                actReProcdefVos.add(actReProcdefVoTmp);
            }
            return PageInfoExtendUtils.getPageInfoExtend(actReProcdefVos,processDefinitionQuery.count(),actReProcdefVo.getPageQuery());
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    public List<ActReProcdefVo> findActReProcdefVosByUserOrGroup(SysUser sysUser){
        List<String> userGroups = actIdGroupService.findActIdGroupIdsByUser(sysUser.getUser());
        ActReProcdefVo params = new ActReProcdefVo();
        params.setUserGroups(userGroups);
        params.setUser(sysUser.getUser());
        return actReProcdefRepository.selectActReProcdefVosByUserOrGroup(params);
    }

    /**
     * @Title:  
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型，并得到树形
     * @param sysUser
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/12 11:15:14
     */
    public List<BootstrapTreeViewNodeVo> findProcdefTree(SysUser sysUser){
        //创建树形对象
        BootstrapTreeViewNodeVo nodeVo = new BootstrapTreeViewNodeVo();
        List<String> userGroups = actIdGroupService.findActIdGroupIdsByUser(sysUser.getUser());
        ActReProcdefVo params = new ActReProcdefVo();
        params.setUserGroups(userGroups);
        params.setUser(sysUser.getUser());
        params.setTree(true);
        //查询当前拥有的所有流程任务
        List<ActReProcdefVo> actReProcdefVos = actReProcdefRepository.selectActReProcdefVosByUserOrGroup(params);
        if(ArrayUtils.isNotNullAndLengthNotZero(actReProcdefVos)) {
            nodeVo.setText("我的任务【" + actReProcdefVos.size() + "】");
            //归类,不同key的任务放到不通的list中
            Map<String, List<ActReProcdefVo>> actReProcdefVosMap = new HashMap<>();
            for(ActReProcdefVo actReProcdefVo : actReProcdefVos){
                if(actReProcdefVo != null){
                    if(actReProcdefVosMap.get(actReProcdefVo.getKey()) == null)
                        actReProcdefVosMap.put(actReProcdefVo.getKey(),new ArrayList<>());
                    actReProcdefVosMap.get(actReProcdefVo.getKey()).add(actReProcdefVo);
                }
            }
            //得到子节点
            List<BootstrapTreeViewNodeVo> nodeVos = new ArrayList<>();
            for(String key : actReProcdefVosMap.keySet()){
                List<ActReProcdefVo> vos = actReProcdefVosMap.get(key);
                if(ArrayUtils.isNotNullAndLengthNotZero(vos)){
                    BootstrapTreeViewNodeVo child = new BootstrapTreeViewNodeVo();
                    child.setId(key);
                    child.setText(vos.get(0).getName() + "【" + vos.size() +"】");
                    nodeVos.add(child);
                }
            }
            nodeVo.setNodes(nodeVos);
        }else{
            nodeVo.setText("我的任务【0】");
        }
        List<BootstrapTreeViewNodeVo> nodeVos = new ArrayList<>();
        nodeVos.add(nodeVo);
        return nodeVos;
    }

}
