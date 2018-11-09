package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditCorpBkcheckDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpBkcheckRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckRepositoryImpl
 * @Description: 企业银行卡核查Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditCorpBkcheckRepositoryImpl extends AbstractBaseRepository<PycreditCorpBkcheckDao, PycreditCorpBkcheck> implements PycreditCorpBkcheckRepository {

    /**
     * @Title:
     * @Description: 新增企业银行卡核查
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int insertData(PycreditCorpBkcheck pycreditCorpBkcheck) {
        return super.insert(pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量保存企业银行卡核查
     * @param pycreditCorpBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int insertDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks){
        return super.insertListByJdbcTemplate(pycreditCorpBkchecks);
    }

    /**
     * @Title:
     * @Description: 修改企业银行卡核查
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpBkcheck pycreditCorpBkcheck) {
        return super.updateByPrimaryKey(pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量修改企业银行卡核查
     * @param pycreditCorpBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks){
        return super.updateListByPrimaryKey(pycreditCorpBkchecks);
    }

    /**
     * @Title:
     * @Description: 动态修改企业银行卡核查
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck) {
        return super.updateByPrimaryKeySelective(pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业银行卡核查
     * @param pycreditCorpBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks) {
        return super.updateListByPrimaryKeySelective(pycreditCorpBkchecks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业银行卡核查
     * @param pycreditCorpBkcheck
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByExampleData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example) {
        return super.updateByExample(pycreditCorpBkcheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改企业银行卡核查
     * @param pycreditCorpBkcheck
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example){
        return super.updateByExampleSelective(pycreditCorpBkcheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditCorpBkcheckId删除企业银行卡核查
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int deleteData(PycreditCorpBkcheck pycreditCorpBkcheck) {
        return super.delete(pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 根据pycreditCorpBkcheckId集合批量删除企业银行卡核查
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int deleteDataList(List pycreditCorpBkcheckIds,PycreditCorpBkcheck pycreditCorpBkcheck){
        return super.deleteByIds(pycreditCorpBkcheckIds,pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除企业银行卡核查
     * @param example
     * @param pycreditCorpBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int deleteExampleData(Example example,PycreditCorpBkcheck pycreditCorpBkcheck){
        return super.deleteByExample(example,pycreditCorpBkcheck);
    }

    /**
     * @Title:
     * @Description: 查询全部企业银行卡核查
     * @return List<PycreditCorpBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public List<PycreditCorpBkcheck> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个企业银行卡核查
     * @param example
     * @return PycreditCorpBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public PycreditCorpBkcheck selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询企业银行卡核查
     * @param example
     * @return List<PycreditCorpBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public List<PycreditCorpBkcheck> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditCorpBkcheckId查询企业银行卡核查
     * @param pycreditCorpBkcheckId
     * @return PycreditCorpBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public PycreditCorpBkcheck selectByPrimaryKey(Object pycreditCorpBkcheckId) {
        return super.selectByPrimaryKey(pycreditCorpBkcheckId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询企业银行卡核查
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditCorpBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public PageInfoExtend<PycreditCorpBkcheck> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询企业银行卡核查vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改企业银行卡核查
     * @param pycreditCorpBkcheck,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpBkcheck pycreditCorpBkcheck,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditCorpBkcheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改企业银行卡核查,并进行排他
     * @param pycreditCorpBkchecks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditCorpBkchecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改企业银行卡核查,并进行排他
     * @param pycreditCorpBkcheck
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditCorpBkcheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业银行卡核查,并进行排他
     * @param pycreditCorpBkchecks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditCorpBkchecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业银行卡核查,并进行排他
     * @param pycreditCorpBkcheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByExampleData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example,boolean exclusive) {
        return super.updateByExample(pycreditCorpBkcheck,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改企业银行卡核查,并进行排他
     * @param pycreditCorpBkcheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditCorpBkcheck,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业银行卡核查,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditCorpBkcheck> selectPycreditCorpBkcheckList(String name, int ceilingNumber){
        return baseDao.selectPycreditCorpBkcheckList(name,ceilingNumber);
    }

    /**
     * @param name
     * @Description: 查询最近一条企业银行卡核查
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 14:26
     */
    @Override
    public PycreditCorpBkcheck selectLastPycreditCorpBkcheckByDocumentNo(String name) {
        return baseDao.selectLastPycreditCorpBkcheckByDocumentNo(name);
    }
}
