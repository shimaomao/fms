package cn.com.leadu.fms.data.activiti.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskDao
 * @Description:
 * @date 2018/6/22
 */
public interface ActRuTaskDao extends BaseDao<ActRuTask> {

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<ActRuTask> selectActRuTasksByBusinessKeys(@Param("businessKeys")List<String> businessKeys);


}
