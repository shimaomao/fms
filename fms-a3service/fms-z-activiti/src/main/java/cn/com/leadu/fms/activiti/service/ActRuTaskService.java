package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskService
 * @Description: 任务查询
 * @date 2018/3/14
 */
public interface ActRuTaskService {

    /**
     * @Title:
     * @Description:   查询个人任务和候选任务
     * @param actRuTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:09:34
     */
    PageInfoExtend<ActRuTaskVo> findActRuTaskVosByCandidateOrAssigned(ActRuTaskVo actRuTaskVo, SysUser sysUser);

    /**
     * @Title:
     * @Description:   审批任务
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 08:49:31
     */
    void approvalActRuTask(ActRuTaskVo actRuTaskVo);

//    /**
//     * @Title:
//     * @Description: 测试工作流流程
//     * @param: taskId
//     * @param: status
//     * @return
//     * @throws
//     * @author qiaomengnan
//     * @date 2018/4/17  16:15
//     */
//    void approvalTest(String taskId,Integer status);

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<ActRuTask> findActRuTasksByBusinessKeys(List<String> businessKeys);

}
