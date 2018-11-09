package cn.com.leadu.fms.data.activiti.repository;

import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskRepository
 * @Description:
 * @date 2018/6/22
 */
public interface ActRuTaskRepository {

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<ActRuTask> selectActRuTasksByBusinessKeys(List<String> businessKeys);

    /**
     * @Title:
     * @Description:   根据任务id，更新任务持有人
     * @param taskIds
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/22 07:00:30
     */
    void updateActRuTasksAssigneeByIds(List<String> taskIds,String user);

}
