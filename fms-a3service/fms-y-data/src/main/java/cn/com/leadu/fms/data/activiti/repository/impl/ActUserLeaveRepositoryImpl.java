package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.data.activiti.dao.ActUserLeaveDao;
import cn.com.leadu.fms.data.activiti.repository.ActUserLeaveRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveRepositoryImpl
 * @Description: 用户请假Repository 实现层
 * @date 2018-03-14
 */
@Repository
public class ActUserLeaveRepositoryImpl extends AbstractBaseRepository<ActUserLeaveDao, ActUserLeave> implements ActUserLeaveRepository {

    /**
     * @Title:
     * @Description: 新增用户请假
     * @param actUserLeave
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int insertData(ActUserLeave actUserLeave) {
        return super.insert(actUserLeave);
    }

    /**
     * @Title:
     * @Description: 批量保存用户请假
     * @param actUserLeaves
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int insertDataList(List<ActUserLeave> actUserLeaves){
        return super.insertListByJdbcTemplate(actUserLeaves);
    }

    /**
     * @Title:
     * @Description: 修改用户请假
     * @param actUserLeave
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int updateByPrimaryKeyData(ActUserLeave actUserLeave) {
        return super.updateByPrimaryKey(actUserLeave);
    }

    /**
     * @Title:
     * @Description: 批量修改用户请假
     * @param actUserLeaves
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ActUserLeave> actUserLeaves){
        return super.updateListByPrimaryKey(actUserLeaves);
    }

    /**
     * @Title:
     * @Description: 动态修改用户请假
     * @param actUserLeave
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ActUserLeave actUserLeave) {
        return super.updateByPrimaryKeySelective(actUserLeave);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户请假
     * @param actUserLeaves
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public int updateByPrimaryKeySelectiveDataList(List<ActUserLeave> actUserLeaves) {
        return super.updateListByPrimaryKeySelective(actUserLeaves);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户请假
     * @param actUserLeave
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int updateByExampleData(ActUserLeave actUserLeave, Example example) {
        return super.updateByExample(actUserLeave,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户请假
     * @param actUserLeave
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int updateByExampleSelectiveData(ActUserLeave actUserLeave, Example example){
        return super.updateByExampleSelective(actUserLeave,example);
    }
    
    /**
     * @Title:
     * @Description: 根据leaveId删除用户请假
     * @param actUserLeave
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public int deleteData(ActUserLeave actUserLeave) {
        return super.delete(actUserLeave);
    }

    /**
     * @Title:
     * @Description: 根据leaveId集合批量删除用户请假
     * @param actUserLeave
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public int deleteDataList(List leaveIds,ActUserLeave actUserLeave){
        return super.deleteByIds(leaveIds,actUserLeave);
    }

    /**
     * @Title:
     * @Description: 查询全部用户请假
     * @return List<ActUserLeave>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public List<ActUserLeave> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户请假
     * @param example
     * @return ActUserLeave
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public ActUserLeave selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户请假
     * @param example
     * @return List<ActUserLeave>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public List<ActUserLeave> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过leaveId查询用户请假
     * @param leaveId
     * @return ActUserLeave
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public ActUserLeave selectByPrimaryKey(Object leaveId) {
        return super.selectByPrimaryKey(leaveId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户请假
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ActUserLeave>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @Override
    public PageInfoExtend<ActUserLeave> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户请假vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ActUserLeave>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    public PageInfoExtend<ActUserLeave> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
