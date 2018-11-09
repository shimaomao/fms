package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.activiti.dao.ActRuTaskDao;
import cn.com.leadu.fms.data.activiti.repository.ActRuTaskRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskRepositoryImpl
 * @Description:
 * @date 2018/6/22
 */
@Repository
public class ActRuTaskRepositoryImpl implements ActRuTaskRepository {

    @Autowired
    private ActRuTaskDao actRuTaskDao;

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    public List<ActRuTask> selectActRuTasksByBusinessKeys(List<String> businessKeys){
        return actRuTaskDao.selectActRuTasksByBusinessKeys(businessKeys);
    }

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
    @Transactional
    public void updateActRuTasksAssigneeByIds(List<String> taskIds,String user){
        if(ArrayUtils.isNotNullAndLengthNotZero(taskIds)) {
            Example example = SqlUtil.newExample(ActRuTask.class);
            example.createCriteria().andIn("id", taskIds);
            ActRuTask actRuTask = new ActRuTask();
            actRuTask.setAssignee(user);
            actRuTaskDao.updateByExampleSelective(actRuTask, example);
        }
    }

}
