package cn.com.leadu.fms.data.activiti.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.activiti.entity.ActReProcdef;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefDao
 * @Description: 任务相关流程实例dao
 * @date 2018/6/19
 */
public interface ActReProcdefDao extends BaseDao<ActReProcdef> {

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    List<ActReProcdefVo> selectActReProcdefVosByUserOrGroup(@Param("actReProcdefVo") ActReProcdefVo actReProcdefVo);

}
