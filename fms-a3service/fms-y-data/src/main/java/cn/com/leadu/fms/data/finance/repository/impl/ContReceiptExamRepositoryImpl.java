package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.ContReceiptExamDao;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamRepositoryImpl
 * @Description: 财务勾稽信息Repository 实现层
 * @date 2018-06-05
 */
@Repository
public class ContReceiptExamRepositoryImpl extends AbstractBaseRepository<ContReceiptExamDao, ContReceiptExam> implements ContReceiptExamRepository {

    /**
     * @Title:
     * @Description: 新增财务勾稽信息
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int insertData(ContReceiptExam contReceiptExam) {
        return super.insert(contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 批量保存财务勾稽信息
     * @param contReceiptExams
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int insertDataList(List<ContReceiptExam> contReceiptExams){
        return super.insertListByJdbcTemplate(contReceiptExams);
    }

    /**
     * @Title:
     * @Description: 修改财务勾稽信息
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeyData(ContReceiptExam contReceiptExam) {
        return super.updateByPrimaryKey(contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 批量修改财务勾稽信息
     * @param contReceiptExams
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContReceiptExam> contReceiptExams){
        return super.updateListByPrimaryKey(contReceiptExams);
    }

    /**
     * @Title:
     * @Description: 动态修改财务勾稽信息
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContReceiptExam contReceiptExam) {
        return super.updateByPrimaryKeySelective(contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务勾稽信息
     * @param contReceiptExams
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContReceiptExam> contReceiptExams) {
        return super.updateListByPrimaryKeySelective(contReceiptExams);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务勾稽信息
     * @param contReceiptExam
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByExampleData(ContReceiptExam contReceiptExam, Example example) {
        return super.updateByExample(contReceiptExam,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务勾稽信息
     * @param contReceiptExam
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByExampleSelectiveData(ContReceiptExam contReceiptExam, Example example){
        return super.updateByExampleSelective(contReceiptExam,example);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId删除财务勾稽信息
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int deleteData(ContReceiptExam contReceiptExam) {
        return super.delete(contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId集合批量删除财务勾稽信息
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int deleteDataList(List contReceiptExamIds,ContReceiptExam contReceiptExam){
        return super.deleteByIds(contReceiptExamIds,contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务勾稽信息
     * @param example
     * @param contReceiptExam
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int deleteExampleData(Example example,ContReceiptExam contReceiptExam){
        return super.deleteByExample(example,contReceiptExam);
    }

    /**
     * @Title:
     * @Description: 查询全部财务勾稽信息
     * @return List<ContReceiptExam>
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public List<ContReceiptExam> selectAll() {
        return super.selectAll();
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个财务勾稽信息
     * @param example
     * @return ContReceiptExam
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public ContReceiptExam selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过条件批量查询财务勾稽信息
     * @param example
     * @return List<ContReceiptExam>
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public List<ContReceiptExam> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过contReceiptExamId查询财务勾稽信息
     * @param contReceiptExamId
     * @return ContReceiptExam
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public ContReceiptExam selectByPrimaryKey(Object contReceiptExamId) {
        return super.selectByPrimaryKey(contReceiptExamId);
    }

    /**
     * @Title:
     * @Description: 分页查询财务勾稽信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContReceiptExam>
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public PageInfoExtend<ContReceiptExam> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务勾稽信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务勾稽信息
     * @param contReceiptExam,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeyData(ContReceiptExam contReceiptExam,boolean exclusive) {
        return super.updateByPrimaryKey(contReceiptExam,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务勾稽信息,并进行排他
     * @param contReceiptExams
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContReceiptExam> contReceiptExams,boolean exclusive){
        return super.updateListByPrimaryKey(contReceiptExams,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务勾稽信息,并进行排他
     * @param contReceiptExam
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContReceiptExam contReceiptExam,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contReceiptExam,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务勾稽信息,并进行排他
     * @param contReceiptExams
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContReceiptExam> contReceiptExams,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contReceiptExams,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务勾稽信息,并进行排他
     * @param contReceiptExam
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByExampleData(ContReceiptExam contReceiptExam, Example example,boolean exclusive) {
        return super.updateByExample(contReceiptExam,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务勾稽信息,并进行排他
     * @param contReceiptExam
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-5 14:42:43
     */
    @Override
    public int updateByExampleSelectiveData(ContReceiptExam contReceiptExam, Example example,boolean exclusive){
        return super.updateByExampleSelective(contReceiptExam,example,exclusive);
    }

}
