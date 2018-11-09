package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.EquRelTaskService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.asset.repository.EquRelTaskRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import cn.com.leadu.fms.pojo.asset.vo.equreltask.EquRelTaskVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskSaveVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskModifyVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskDeleteVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskService
 * @Description: 资方解押任务业务实现层
 * @date 2018-05-30
 */
@Service
public class EquRelTaskServiceImpl implements EquRelTaskService {

    /**
     * @Fields  : 资方解押任务repository
     */
    @Autowired
    private EquRelTaskRepository equRelTaskRepository;

    /**
     * @Title:
     * @Description: 分页查询资方解押任务
     * @param equRelTaskVo
     * @return PageInfoExtend<EquRelTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public PageInfoExtend<EquRelTask> findEquRelTasksByPage(EquRelTaskVo equRelTaskVo){
        Example example = SqlUtil.newExample(EquRelTask.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<EquRelTask> pageInfo = equRelTaskRepository.selectListByExamplePage(example,equRelTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存资方解押任务
     * @param equRelTaskSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public void saveEquRelTask(EquRelTaskSaveVo equRelTaskSaveVo){
        equRelTaskRepository.insertData(equRelTaskSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改资方解押任务
     * @param equRelTaskModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public void modifyEquRelTask(EquRelTaskModifyVo equRelTaskModifyVo){
        equRelTaskRepository.updateByPrimaryKeySelectiveData(equRelTaskModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equRelTaskId删除资方解押任务
     * @param equRelTaskDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public void deleteEquRelTask(EquRelTaskDeleteVo equRelTaskDeleteVo){
        equRelTaskRepository.deleteData(equRelTaskDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equRelTaskId集合删除资方解押任务
     * @param equRelTaskDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public void deleteEquRelTasksByEquRelTaskIds(EquRelTaskDeleteListVo equRelTaskDeleteListVo){
        equRelTaskRepository.deleteDataList(equRelTaskDeleteListVo.getEquRelTaskIds(),equRelTaskDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据equRelTaskId获取资方解押任务
     * @param equRelTaskId
     * @return EquRelTask
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public EquRelTask findEquRelTaskByEquRelTaskId(String equRelTaskId){
        return equRelTaskRepository.selectByPrimaryKey(equRelTaskId);
    }

}
