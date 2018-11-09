package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueAssignmentDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueAssignmentRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentRepositoryImpl
 * @Description: 当日逾期任务信息Repository 实现层
 * @date 2018-05-16
 */
@Repository
public class OverdueAssignmentRepositoryImpl extends AbstractBaseRepository<OverdueAssignmentDao, OverdueAssignment> implements OverdueAssignmentRepository {

    /**
     * @Title:
     * @Description: 新增当日逾期任务信息
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int insertData(OverdueAssignment overdueAssignment) {
        return super.insert(overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 批量保存当日逾期任务信息
     * @param overdueAssignments
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int insertDataList(List<OverdueAssignment> overdueAssignments){
        return super.insertListByJdbcTemplate(overdueAssignments);
    }

    /**
     * @Title:
     * @Description: 修改当日逾期任务信息
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int updateByPrimaryKeyData(OverdueAssignment overdueAssignment) {
        return super.updateByPrimaryKey(overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 批量修改当日逾期任务信息
     * @param overdueAssignments
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueAssignment> overdueAssignments){
        return super.updateListByPrimaryKey(overdueAssignments);
    }

    /**
     * @Title:
     * @Description: 动态修改当日逾期任务信息
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueAssignment overdueAssignment) {
        return super.updateByPrimaryKeySelective(overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 批量动态修改当日逾期任务信息
     * @param overdueAssignments
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueAssignment> overdueAssignments) {
        return super.updateListByPrimaryKeySelective(overdueAssignments);
    }

    /**
     * @Title:
     * @Description: 根据条件修改当日逾期任务信息
     * @param overdueAssignment
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int updateByExampleData(OverdueAssignment overdueAssignment, Example example) {
        return super.updateByExample(overdueAssignment,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改当日逾期任务信息
     * @param overdueAssignment
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int updateByExampleSelectiveData(OverdueAssignment overdueAssignment, Example example){
        return super.updateByExampleSelective(overdueAssignment,example);
    }

    /**
     * @Title:
     * @Description: 根据overdueAssignmentId删除当日逾期任务信息
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public int deleteData(OverdueAssignment overdueAssignment) {
        return super.delete(overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 根据overdueAssignmentId集合批量删除当日逾期任务信息
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public int deleteDataList(List overdueAssignmentIds,OverdueAssignment overdueAssignment){
        return super.deleteByIds(overdueAssignmentIds,overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除当日逾期任务信息
     * @param example
     * @param overdueAssignment
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public int deleteExampleData(Example example,OverdueAssignment overdueAssignment){
        return super.deleteByExample(example,overdueAssignment);
    }

    /**
     * @Title:
     * @Description: 查询全部当日逾期任务信息
     * @return List<OverdueAssignment>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public List<OverdueAssignment> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个当日逾期任务信息
     * @param example
     * @return OverdueAssignment
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public OverdueAssignment selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询当日逾期任务信息
     * @param example
     * @return List<OverdueAssignment>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public List<OverdueAssignment> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueAssignmentId查询当日逾期任务信息
     * @param overdueAssignmentId
     * @return OverdueAssignment
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public OverdueAssignment selectByPrimaryKey(Object overdueAssignmentId) {
        return super.selectByPrimaryKey(overdueAssignmentId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueAssignment>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @Override
    public PageInfoExtend<OverdueAssignment> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
