package cn.com.leadu.fms.data.activiti.repository;

import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefRepository
 * @Description:    任务相关流程实例 repository
 * @date 2018/6/19
 */
public interface ActReProcdefRepository {

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    List<ActReProcdefVo> selectActReProcdefVosByUserOrGroup(ActReProcdefVo actReProcdefVo);

}
