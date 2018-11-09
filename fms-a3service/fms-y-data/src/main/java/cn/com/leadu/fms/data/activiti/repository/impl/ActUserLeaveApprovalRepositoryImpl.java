package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.data.activiti.dao.ActUserLeaveApprovalDao;
import cn.com.leadu.fms.data.activiti.repository.ActUserLeaveApprovalRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalRepositoryImpl
 * @Description: 用户请假审批Repository 实现层
 * @date 2018-03-20
 */
@Repository
public class ActUserLeaveApprovalRepositoryImpl extends AbstractBaseRepository<ActUserLeaveApprovalDao, ActUserLeaveApproval> implements ActUserLeaveApprovalRepository {

    /**
     * @Title:
     * @Description: 新增用户请假审批
     * @param actUserLeaveApproval
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int insertData(ActUserLeaveApproval actUserLeaveApproval) {
        return super.insert(actUserLeaveApproval);
    }

    /**
     * @Title:
     * @Description: 批量保存用户请假审批
     * @param actUserLeaveApprovals
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int insertDataList(List<ActUserLeaveApproval> actUserLeaveApprovals){
        return super.insertListByJdbcTemplate(actUserLeaveApprovals);
    }

    /**
     * @Title:
     * @Description: 修改用户请假审批
     * @param actUserLeaveApproval
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int updateByPrimaryKeyData(ActUserLeaveApproval actUserLeaveApproval) {
        return super.updateByPrimaryKey(actUserLeaveApproval);
    }

    /**
     * @Title:
     * @Description: 批量修改用户请假审批
     * @param actUserLeaveApprovals
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ActUserLeaveApproval> actUserLeaveApprovals){
        return super.updateListByPrimaryKey(actUserLeaveApprovals);
    }

    /**
     * @Title:
     * @Description: 动态修改用户请假审批
     * @param actUserLeaveApproval
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ActUserLeaveApproval actUserLeaveApproval) {
        return super.updateByPrimaryKeySelective(actUserLeaveApproval);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户请假审批
     * @param actUserLeaveApprovals
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    public int updateByPrimaryKeySelectiveDataList(List<ActUserLeaveApproval> actUserLeaveApprovals) {
        return super.updateListByPrimaryKeySelective(actUserLeaveApprovals);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户请假审批
     * @param actUserLeaveApproval
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int updateByExampleData(ActUserLeaveApproval actUserLeaveApproval, Example example) {
        return super.updateByExample(actUserLeaveApproval,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户请假审批
     * @param actUserLeaveApproval
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int updateByExampleSelectiveData(ActUserLeaveApproval actUserLeaveApproval, Example example){
        return super.updateByExampleSelective(actUserLeaveApproval,example);
    }
    
    /**
     * @Title:
     * @Description: 根据approvalId删除用户请假审批
     * @param actUserLeaveApproval
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public int deleteData(ActUserLeaveApproval actUserLeaveApproval) {
        return super.delete(actUserLeaveApproval);
    }

    /**
     * @Title:
     * @Description: 根据approvalId集合批量删除用户请假审批
     * @param actUserLeaveApproval
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    public int deleteDataList(List approvalIds,ActUserLeaveApproval actUserLeaveApproval){
        return super.deleteByIds(approvalIds,actUserLeaveApproval);
    }

    /**
     * @Title:
     * @Description: 查询全部用户请假审批
     * @return List<ActUserLeaveApproval>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public List<ActUserLeaveApproval> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户请假审批
     * @param example
     * @return ActUserLeaveApproval
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public ActUserLeaveApproval selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户请假审批
     * @param example
     * @return List<ActUserLeaveApproval>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public List<ActUserLeaveApproval> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过approvalId查询用户请假审批
     * @param approvalId
     * @return ActUserLeaveApproval
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public ActUserLeaveApproval selectByPrimaryKey(Object approvalId) {
        return super.selectByPrimaryKey(approvalId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户请假审批
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ActUserLeaveApproval>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    @Override
    public PageInfoExtend<ActUserLeaveApproval> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户请假审批vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ActUserLeaveApproval>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:24
     */
    public PageInfoExtend<ActUserLeaveApproval> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
