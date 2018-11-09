package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositVehicleTypeVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskRepository
 * @Description: 保证金变更任务Repository层
 */
public interface DepositChangeTaskRepository {

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 新增保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int insertData(DepositChangeTask depositChangeTask);

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量保存保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int insertDataList(List<DepositChangeTask> depositChangeTasks);

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int updateByPrimaryKeyData(DepositChangeTask depositChangeTask);

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int updateByPrimaryKeyDataList(List<DepositChangeTask> depositChangeTasks);

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 动态修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int updateByPrimaryKeySelectiveData(DepositChangeTask depositChangeTask);

    /**
     * @param depositChangeTasks
     * @return int
     * @throws
     * @Title:
     * @Description: 批量动态修改保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int updateByPrimaryKeySelectiveDataList(List<DepositChangeTask> depositChangeTasks);

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
    int updateByExampleData(DepositChangeTask depositChangeTask, Example example);

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
    int updateByExampleSelectiveData(DepositChangeTask depositChangeTask, Example example);

    /**
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 根据depositChangeTaskId删除保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int deleteData(DepositChangeTask depositChangeTask);

    /**
     * @param depositChangeTaskIds
     * @param depositChangeTask
     * @return int
     * @throws
     * @Title:
     * @Description: 根据depositChangeTaskId集合批量删除保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    int deleteDataList(List depositChangeTaskIds, DepositChangeTask depositChangeTask);

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
    int deleteExampleData(Example example, DepositChangeTask depositChangeTask);

    /**
     * @return List<DepositChangeTask>
     * @throws
     * @Title:
     * @Description: 查询全部保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    List<DepositChangeTask> selectAll();

    /**
     * @param example
     * @return DepositChangeTask
     * @throws
     * @Title:
     * @Description: 通过条件查询一个保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    DepositChangeTask selectOneByExample(Example example);

    /**
     * @param example
     * @return List<DepositChangeTask>
     * @throws
     * @Title:
     * @Description: 通过条件批量查询保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    List<DepositChangeTask> selectListByExample(Example example);

    /**
     * @param depositChangeTaskId
     * @return DepositChangeTask
     * @throws
     * @Title:
     * @Description: 通过depositChangeTaskId查询保证金变更任务
     * @author huzongcheng
     * @date 2018-9-1 15:38:43
     */
    DepositChangeTask selectByPrimaryKey(Object depositChangeTaskId);

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
    PageInfoExtend<DepositChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery);

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
    PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

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
    int updateByPrimaryKeyData(DepositChangeTask depositChangeTask, boolean exclusive);

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
    int updateByPrimaryKeyDataList(List<DepositChangeTask> depositChangeTasks, boolean exclusive);

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
    int updateByPrimaryKeySelectiveData(DepositChangeTask depositChangeTask, boolean exclusive);

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
    int updateByPrimaryKeySelectiveDataList(List<DepositChangeTask> depositChangeTasks, boolean exclusive);

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
    int updateByExampleData(DepositChangeTask depositChangeTask, Example example, boolean exclusive);

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
    int updateByExampleSelectiveData(DepositChangeTask depositChangeTask, Example example, boolean exclusive);

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo获取申请页需要展示的基本信息
     * @author huzongcheng
     * @date
     */
    DepositChangeApplyVo selectApplyInfoByContNo(String contNo);

    /**
     * @param contNo 合同编号
     * @return DepositVehicleTypeVo
     * @Title:
     * @Description: 根据contNo获取品牌车型
     * @author huzongcheng
     * @date
     */
    DepositVehicleTypeVo selectVehicleType(String contNo);

}
