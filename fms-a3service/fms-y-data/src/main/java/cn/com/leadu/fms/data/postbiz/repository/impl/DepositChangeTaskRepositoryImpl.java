package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.postbiz.dao.DepositChangeTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.DepositChangeTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositVehicleTypeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskRepositoryImpl
 * @Description: 保证金变更任务Repository 实现层
 */
@Repository
public class DepositChangeTaskRepositoryImpl extends AbstractBaseRepository<DepositChangeTaskDao, DepositChangeTask> implements DepositChangeTaskRepository {

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 新增保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int insertData(DepositChangeTask depositChangeTask) {
        return super.insert(depositChangeTask);
    }

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量保存保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int insertDataList(List<DepositChangeTask> depositChangeTasks) {
        return super.insertListByJdbcTemplate(depositChangeTasks);
    }

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeyData(DepositChangeTask depositChangeTask) {
        return super.updateByPrimaryKey(depositChangeTask);
    }

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<DepositChangeTask> depositChangeTasks) {
        return super.updateListByPrimaryKey(depositChangeTasks);
    }

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 动态修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeySelectiveData(DepositChangeTask depositChangeTask) {
        return super.updateByPrimaryKeySelective(depositChangeTask);
    }

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量动态修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<DepositChangeTask> depositChangeTasks) {
        return super.updateListByPrimaryKeySelective(depositChangeTasks);
    }

    /**
     * @param depositChangeTask
     * @param example
     * @return int
     * @throws
     * @Title:
     * @Description: 根据条件修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByExampleData(DepositChangeTask depositChangeTask, Example example) {
        return super.updateByExample(depositChangeTask, example);
    }

    /**
     * @param depositChangeTask
     * @param example
     * @return int
     * @throws
     * @Title:
     * @Description: 根据条件动态修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByExampleSelectiveData(DepositChangeTask depositChangeTask, Example example) {
        return super.updateByExampleSelective(depositChangeTask, example);
    }

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 根据depositChangeTaskId删除保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int deleteData(DepositChangeTask depositChangeTask) {
        return super.delete(depositChangeTask);
    }

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 根据depositChangeTaskId集合批量删除保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int deleteDataList(List depositChangeTaskIds, DepositChangeTask depositChangeTask) {
        return super.deleteByIds(depositChangeTaskIds, depositChangeTask);
    }

    /**
     * @param example
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 根据自定义条件删除保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int deleteExampleData(Example example, DepositChangeTask depositChangeTask) {
        return super.deleteByExample(example, depositChangeTask);
    }

    /**
     * @return List<DepositChangeTask>
     * @throws
     * @Title:
     * @Description: 查询全部保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public List<DepositChangeTask> selectAll() {
        return super.selectAll();
    }

    /**
     * @param example
     * @return DepositChangeTask
     * @throws
     * @Title:
     * @Description: 通过条件查询一个保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public DepositChangeTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @param example
     * @return List<DepositChangeTask>
     * @throws
     * @Title:
     * @Description: 通过条件批量查询保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public List<DepositChangeTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @param depositChangeTaskId
     * @return DepositChangeTask
     * @throws
     * @Title:
     * @Description: 通过depositChangeTaskId查询保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public DepositChangeTask selectByPrimaryKey(Object depositChangeTaskId) {
        return super.selectByPrimaryKey(depositChangeTaskId);
    }

    /**
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<DepositChangeTask>
     * @throws
     * @Title:
     * @Description: 分页查询保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public PageInfoExtend<DepositChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery) {
        return super.selectListByExamplePage(example, pageQuery);
    }

    /**
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @Title:
     * @Description: 分页查询保证金变更任务vo
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    public PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery) {
        return super.selectListVoByPage(methodName, param, pageQuery);
    }

    /**
     * @param depositChangeTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeyData(DepositChangeTask depositChangeTask, boolean exclusive) {
        return super.updateByPrimaryKey(depositChangeTask, exclusive);
    }

    /**
     * @param depositChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 批量修改保证金变更任务, 并进行排他
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<DepositChangeTask> depositChangeTasks, boolean exclusive) {
        return super.updateListByPrimaryKey(depositChangeTasks, exclusive);
    }

    /**
     * @param depositChangeTask
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 根据主键动态修改保证金变更任务, 并进行排他
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(DepositChangeTask depositChangeTask, boolean exclusive) {
        return super.updateByPrimaryKeySelective(depositChangeTask, exclusive);
    }

    /**
     * @param depositChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 批量动态修改保证金变更任务, 并进行排他
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<DepositChangeTask> depositChangeTasks, boolean exclusive) {
        return super.updateListByPrimaryKeySelective(depositChangeTasks, exclusive);
    }

    /**
     * @param depositChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 根据条件修改保证金变更任务, 并进行排他
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByExampleData(DepositChangeTask depositChangeTask, Example example, boolean exclusive) {
        return super.updateByExample(depositChangeTask, example, exclusive);
    }

    /**
     * @param depositChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @Title:
     * @Description: 根据条件动态修改保证金变更任务, 并进行排他
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    @Override
    public int updateByExampleSelectiveData(DepositChangeTask depositChangeTask, Example example, boolean exclusive) {
        return super.updateByExampleSelective(depositChangeTask, example, exclusive);
    }

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo获取申请页需要展示的基本信息
     * @author huzongcheng
     * @date
     */
    @Override
    public DepositChangeApplyVo selectApplyInfoByContNo(String contNo) {
        return baseDao.selectApplyInfoByContNo(contNo);
    }

    /**
     * @param contNo 合同编号
     * @return DepositVehicleTypeVo
     * @Title:
     * @Description: 根据contNo获取品牌车型
     * @author huzongcheng
     * @date
     */
    @Override
    public DepositVehicleTypeVo selectVehicleType(String contNo) {
        return baseDao.selectVehicleType(contNo);
    }

}
