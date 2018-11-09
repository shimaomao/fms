package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.data.activiti.dao.ActReProcdefDao;
import cn.com.leadu.fms.data.activiti.repository.ActReProcdefRepository;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefRepositoryImpl
 * @Description: 任务相关流程实例 repository 实现层
 * @date 2018/6/19
 */
@Repository
public class ActReProcdefRepositoryImpl implements ActReProcdefRepository {

    @Autowired
    private ActReProcdefDao actReProcdefDao;

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    public List<ActReProcdefVo> selectActReProcdefVosByUserOrGroup(ActReProcdefVo actReProcdefVo){
        return actReProcdefDao.selectActReProcdefVosByUserOrGroup(actReProcdefVo);
    }

}
