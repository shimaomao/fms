package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.CapitalAssetsTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.CapitalAssetsTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CapitalAssetsTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskRepositoryImpl
 * @Description: 转固定资产Repository 实现层
 */
@Repository
public class CapitalAssetsTaskRepositoryImpl extends AbstractBaseRepository<CapitalAssetsTaskDao, CapitalAssetsTask> implements CapitalAssetsTaskRepository {

    /**
     * @Title:
     * @Description: 新增转固定资产
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int insertData(CapitalAssetsTask capitalAssetsTask) {
        return super.insert(capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 批量保存转固定资产
     * @param capitalAssetsTasks
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int insertDataList(List<CapitalAssetsTask> capitalAssetsTasks){
        return super.insertListByJdbcTemplate(capitalAssetsTasks);
    }

    /**
     * @Title:
     * @Description: 修改转固定资产
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeyData(CapitalAssetsTask capitalAssetsTask) {
        return super.updateByPrimaryKey(capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 批量修改转固定资产
     * @param capitalAssetsTasks
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CapitalAssetsTask> capitalAssetsTasks){
        return super.updateListByPrimaryKey(capitalAssetsTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改转固定资产
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CapitalAssetsTask capitalAssetsTask) {
        return super.updateByPrimaryKeySelective(capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改转固定资产
     * @param capitalAssetsTasks
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CapitalAssetsTask> capitalAssetsTasks) {
        return super.updateListByPrimaryKeySelective(capitalAssetsTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改转固定资产
     * @param capitalAssetsTask
     * @param example
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByExampleData(CapitalAssetsTask capitalAssetsTask, Example example) {
        return super.updateByExample(capitalAssetsTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改转固定资产
     * @param capitalAssetsTask
     * @param example
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByExampleSelectiveData(CapitalAssetsTask capitalAssetsTask, Example example){
        return super.updateByExampleSelective(capitalAssetsTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据capitalAssetsTaskId删除转固定资产
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int deleteData(CapitalAssetsTask capitalAssetsTask) {
        return super.delete(capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 根据capitalAssetsTaskId集合批量删除转固定资产
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int deleteDataList(List capitalAssetsTaskIds,CapitalAssetsTask capitalAssetsTask){
        return super.deleteByIds(capitalAssetsTaskIds,capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除转固定资产
     * @param example
     * @param capitalAssetsTask
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int deleteExampleData(Example example,CapitalAssetsTask capitalAssetsTask){
        return super.deleteByExample(example,capitalAssetsTask);
    }

    /**
     * @Title:
     * @Description: 查询全部转固定资产
     * @return List<CapitalAssetsTask>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public List<CapitalAssetsTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个转固定资产
     * @param example
     * @return CapitalAssetsTask
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public CapitalAssetsTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询转固定资产
     * @param example
     * @return List<CapitalAssetsTask>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public List<CapitalAssetsTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过capitalAssetsTaskId查询转固定资产
     * @param capitalAssetsTaskId
     * @return CapitalAssetsTask
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public CapitalAssetsTask selectByPrimaryKey(Object capitalAssetsTaskId) {
        return super.selectByPrimaryKey(capitalAssetsTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询转固定资产
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CapitalAssetsTask>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public PageInfoExtend<CapitalAssetsTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询转固定资产vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改转固定资产
     * @param capitalAssetsTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeyData(CapitalAssetsTask capitalAssetsTask,boolean exclusive) {
        return super.updateByPrimaryKey(capitalAssetsTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改转固定资产,并进行排他
     * @param capitalAssetsTasks
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CapitalAssetsTask> capitalAssetsTasks,boolean exclusive){
        return super.updateListByPrimaryKey(capitalAssetsTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改转固定资产,并进行排他
     * @param capitalAssetsTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CapitalAssetsTask capitalAssetsTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(capitalAssetsTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改转固定资产,并进行排他
     * @param capitalAssetsTasks
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CapitalAssetsTask> capitalAssetsTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(capitalAssetsTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改转固定资产,并进行排他
     * @param capitalAssetsTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByExampleData(CapitalAssetsTask capitalAssetsTask, Example example,boolean exclusive) {
        return super.updateByExample(capitalAssetsTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改转固定资产,并进行排他
     * @param capitalAssetsTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:00:43
     */
    @Override
    public int updateByExampleSelectiveData(CapitalAssetsTask capitalAssetsTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(capitalAssetsTask,example,exclusive);
    }

}
