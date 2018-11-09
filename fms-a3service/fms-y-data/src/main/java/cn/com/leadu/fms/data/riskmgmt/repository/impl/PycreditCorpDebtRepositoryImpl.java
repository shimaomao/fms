package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditCorpDebtDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpDebtRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtRepositoryImpl
 * @Description: 企业债务Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditCorpDebtRepositoryImpl extends AbstractBaseRepository<PycreditCorpDebtDao, PycreditCorpDebt> implements PycreditCorpDebtRepository {

    /**
     * @Title:
     * @Description: 新增企业债务
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int insertData(PycreditCorpDebt pycreditCorpDebt) {
        return super.insert(pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 批量保存企业债务
     * @param pycreditCorpDebts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int insertDataList(List<PycreditCorpDebt> pycreditCorpDebts){
        return super.insertListByJdbcTemplate(pycreditCorpDebts);
    }

    /**
     * @Title:
     * @Description: 修改企业债务
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpDebt pycreditCorpDebt) {
        return super.updateByPrimaryKey(pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 批量修改企业债务
     * @param pycreditCorpDebts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpDebt> pycreditCorpDebts){
        return super.updateListByPrimaryKey(pycreditCorpDebts);
    }

    /**
     * @Title:
     * @Description: 动态修改企业债务
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpDebt pycreditCorpDebt) {
        return super.updateByPrimaryKeySelective(pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业债务
     * @param pycreditCorpDebts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpDebt> pycreditCorpDebts) {
        return super.updateListByPrimaryKeySelective(pycreditCorpDebts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业债务
     * @param pycreditCorpDebt
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByExampleData(PycreditCorpDebt pycreditCorpDebt, Example example) {
        return super.updateByExample(pycreditCorpDebt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改企业债务
     * @param pycreditCorpDebt
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpDebt pycreditCorpDebt, Example example){
        return super.updateByExampleSelective(pycreditCorpDebt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditCorpDebtId删除企业债务
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int deleteData(PycreditCorpDebt pycreditCorpDebt) {
        return super.delete(pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 根据pycreditCorpDebtId集合批量删除企业债务
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int deleteDataList(List pycreditCorpDebtIds,PycreditCorpDebt pycreditCorpDebt){
        return super.deleteByIds(pycreditCorpDebtIds,pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除企业债务
     * @param example
     * @param pycreditCorpDebt
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int deleteExampleData(Example example,PycreditCorpDebt pycreditCorpDebt){
        return super.deleteByExample(example,pycreditCorpDebt);
    }

    /**
     * @Title:
     * @Description: 查询全部企业债务
     * @return List<PycreditCorpDebt>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public List<PycreditCorpDebt> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个企业债务
     * @param example
     * @return PycreditCorpDebt
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public PycreditCorpDebt selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询企业债务
     * @param example
     * @return List<PycreditCorpDebt>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public List<PycreditCorpDebt> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditCorpDebtId查询企业债务
     * @param pycreditCorpDebtId
     * @return PycreditCorpDebt
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public PycreditCorpDebt selectByPrimaryKey(Object pycreditCorpDebtId) {
        return super.selectByPrimaryKey(pycreditCorpDebtId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询企业债务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditCorpDebt>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public PageInfoExtend<PycreditCorpDebt> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询企业债务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改企业债务
     * @param pycreditCorpDebt,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCorpDebt pycreditCorpDebt,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditCorpDebt,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改企业债务,并进行排他
     * @param pycreditCorpDebts
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCorpDebt> pycreditCorpDebts,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditCorpDebts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改企业债务,并进行排他
     * @param pycreditCorpDebt
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCorpDebt pycreditCorpDebt,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditCorpDebt,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业债务,并进行排他
     * @param pycreditCorpDebts
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCorpDebt> pycreditCorpDebts,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditCorpDebts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业债务,并进行排他
     * @param pycreditCorpDebt
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByExampleData(PycreditCorpDebt pycreditCorpDebt, Example example,boolean exclusive) {
        return super.updateByExample(pycreditCorpDebt,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改企业债务,并进行排他
     * @param pycreditCorpDebt
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCorpDebt pycreditCorpDebt, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditCorpDebt,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业债务,并进行排他
     * @param name
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditCorpDebt> selectPycreditCorpDebtList(String name, int ceilingNumber){
        return baseDao.selectPycreditCorpDebtList(name,ceilingNumber);
    }

    /**
     * @param name
     * @Description: 查尊最近企业债务查询
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 15:18
     */
    @Override
    public PycreditCorpDebt selectLastPycreditCorpDebtByDocumentNo(String name) {
        return baseDao.selectLastPycreditCorpDebtByDocumentNo(name);
    }
}
