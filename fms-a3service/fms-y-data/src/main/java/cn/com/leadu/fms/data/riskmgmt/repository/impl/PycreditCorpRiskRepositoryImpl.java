package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditCorpRiskDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpRiskRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskRepositoryImpl
 * @Description: 企业风险Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditCorpRiskRepositoryImpl extends AbstractBaseRepository<PycreditCorpRiskDao, PycreditCorpRisk> implements PycreditCorpRiskRepository {

    /**
     * @Title:
     * @Description: 新增企业风险
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int insertData(PycreditCorpRisk pycreditCorpRisk) {
        return super.insert(pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 批量保存企业风险
     * @param pycreditCorpRisks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int insertDataList(List<PycreditCorpRisk> pycreditCorpRisks){
        return super.insertListByJdbcTemplate(pycreditCorpRisks);
    }

    /**
     * @Title:
     * @Description: 修改企业风险
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpRisk pycreditCorpRisk) {
        return super.updateByPrimaryKey(pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 批量修改企业风险
     * @param pycreditCorpRisks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpRisk> pycreditCorpRisks){
        return super.updateListByPrimaryKey(pycreditCorpRisks);
    }

    /**
     * @Title:
     * @Description: 动态修改企业风险
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpRisk pycreditCorpRisk) {
        return super.updateByPrimaryKeySelective(pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业风险
     * @param pycreditCorpRisks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpRisk> pycreditCorpRisks) {
        return super.updateListByPrimaryKeySelective(pycreditCorpRisks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业风险
     * @param pycreditCorpRisk
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByExampleData(PycreditCorpRisk pycreditCorpRisk, Example example) {
        return super.updateByExample(pycreditCorpRisk,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险
     * @param pycreditCorpRisk
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpRisk pycreditCorpRisk, Example example){
        return super.updateByExampleSelective(pycreditCorpRisk,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditCorpRiskId删除企业风险
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int deleteData(PycreditCorpRisk pycreditCorpRisk) {
        return super.delete(pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 根据pycreditCorpRiskId集合批量删除企业风险
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int deleteDataList(List pycreditCorpRiskIds,PycreditCorpRisk pycreditCorpRisk){
        return super.deleteByIds(pycreditCorpRiskIds,pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除企业风险
     * @param example
     * @param pycreditCorpRisk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int deleteExampleData(Example example,PycreditCorpRisk pycreditCorpRisk){
        return super.deleteByExample(example,pycreditCorpRisk);
    }

    /**
     * @Title:
     * @Description: 查询全部企业风险
     * @return List<PycreditCorpRisk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public List<PycreditCorpRisk> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个企业风险
     * @param example
     * @return PycreditCorpRisk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public PycreditCorpRisk selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询企业风险
     * @param example
     * @return List<PycreditCorpRisk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public List<PycreditCorpRisk> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditCorpRiskId查询企业风险
     * @param pycreditCorpRiskId
     * @return PycreditCorpRisk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public PycreditCorpRisk selectByPrimaryKey(Object pycreditCorpRiskId) {
        return super.selectByPrimaryKey(pycreditCorpRiskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询企业风险
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditCorpRisk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public PageInfoExtend<PycreditCorpRisk> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询企业风险vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改企业风险
     * @param pycreditCorpRisk,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpRisk pycreditCorpRisk,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditCorpRisk,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改企业风险,并进行排他
     * @param pycreditCorpRisks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpRisk> pycreditCorpRisks,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditCorpRisks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改企业风险,并进行排他
     * @param pycreditCorpRisk
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpRisk pycreditCorpRisk,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditCorpRisk,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业风险,并进行排他
     * @param pycreditCorpRisks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpRisk> pycreditCorpRisks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditCorpRisks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业风险,并进行排他
     * @param pycreditCorpRisk
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByExampleData(PycreditCorpRisk pycreditCorpRisk, Example example,boolean exclusive) {
        return super.updateByExample(pycreditCorpRisk,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险,并进行排他
     * @param pycreditCorpRisk
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpRisk pycreditCorpRisk, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditCorpRisk,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险,并进行排他
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditCorpRisk> selectPycreditCorpRiskList(String name, int ceilingNumber){
        return baseDao.selectPycreditCorpRiskList(name,ceilingNumber);
    }

    /**
     * @param name
     * @Description: 查询最近一条企业风险实体
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 14:51
     */
    @Override
    public PycreditCorpRisk selectLastPycreditCorpRiskByDocumentNo(String name) {
        return baseDao.selectLastPycreditCorpRiskByDocumentNo(name);
    }
}
