package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.EquMorTaskService;
import cn.com.leadu.fms.data.asset.repository.EquMorTaskRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskService
 * @Description: 资方抵押任务业务实现层
 * @date 2018-05-30
 */
@Service
public class EquMorTaskServiceImpl implements EquMorTaskService {

    /**
     * @Fields  : 资方抵押任务repository
     */
    @Autowired
    private EquMorTaskRepository equMorTaskRepository;

    /**
     * @Title:
     * @Description:   保存资方抵押任务
     * @param equMorTask
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 05:57:28
     */
    public void saveEquMorTask(EquMorTask equMorTask){
        equMorTaskRepository.insertData(equMorTask);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押任务
     * @param equMorTask
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:53
     */
    public void modifyEquMorTask(EquMorTask equMorTask){
        equMorTaskRepository.updateByPrimaryKeySelectiveData(equMorTask,true);
    }

    /**
     * @Title:
     * @Description:   根据资方抵押任务号查询抵押任务
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 02:58:41
     */
    public EquMorTask findEquMorTaskByEquMorTaskNo(String equMorTaskNo){
        Example example = SqlUtil.newExample(EquMorTask.class);
        example.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        return equMorTaskRepository.selectOneByExample(example);
    }

}
