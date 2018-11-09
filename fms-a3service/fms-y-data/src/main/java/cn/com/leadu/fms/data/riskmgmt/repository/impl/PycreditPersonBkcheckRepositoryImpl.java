package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditPersonBkcheckDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditPersonBkcheckRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckRepositoryImpl
 * @Description: 个人银行卡核查Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditPersonBkcheckRepositoryImpl extends AbstractBaseRepository<PycreditPersonBkcheckDao, PycreditPersonBkcheck> implements PycreditPersonBkcheckRepository {

    /**
     * @Title:
     * @Description: 新增个人银行卡核查
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int insertData(PycreditPersonBkcheck pycreditPersonBkcheck) {
        return super.insert(pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量保存个人银行卡核查
     * @param pycreditPersonBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int insertDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks){
        return super.insertListByJdbcTemplate(pycreditPersonBkchecks);
    }

    /**
     * @Title:
     * @Description: 修改个人银行卡核查
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeyData(PycreditPersonBkcheck pycreditPersonBkcheck) {
        return super.updateByPrimaryKey(pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量修改个人银行卡核查
     * @param pycreditPersonBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks){
        return super.updateListByPrimaryKey(pycreditPersonBkchecks);
    }

    /**
     * @Title:
     * @Description: 动态修改个人银行卡核查
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck) {
        return super.updateByPrimaryKeySelective(pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人银行卡核查
     * @param pycreditPersonBkchecks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks) {
        return super.updateListByPrimaryKeySelective(pycreditPersonBkchecks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人银行卡核查
     * @param pycreditPersonBkcheck
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByExampleData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example) {
        return super.updateByExample(pycreditPersonBkcheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改个人银行卡核查
     * @param pycreditPersonBkcheck
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByExampleSelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example){
        return super.updateByExampleSelective(pycreditPersonBkcheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditPersonBkcheckId删除个人银行卡核查
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int deleteData(PycreditPersonBkcheck pycreditPersonBkcheck) {
        return super.delete(pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 根据pycreditPersonBkcheckId集合批量删除个人银行卡核查
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int deleteDataList(List pycreditPersonBkcheckIds,PycreditPersonBkcheck pycreditPersonBkcheck){
        return super.deleteByIds(pycreditPersonBkcheckIds,pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除个人银行卡核查
     * @param example
     * @param pycreditPersonBkcheck
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int deleteExampleData(Example example,PycreditPersonBkcheck pycreditPersonBkcheck){
        return super.deleteByExample(example,pycreditPersonBkcheck);
    }

    /**
     * @Title:
     * @Description: 查询全部个人银行卡核查
     * @return List<PycreditPersonBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public List<PycreditPersonBkcheck> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个个人银行卡核查
     * @param example
     * @return PycreditPersonBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public PycreditPersonBkcheck selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询个人银行卡核查
     * @param example
     * @return List<PycreditPersonBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public List<PycreditPersonBkcheck> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditPersonBkcheckId查询个人银行卡核查
     * @param pycreditPersonBkcheckId
     * @return PycreditPersonBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public PycreditPersonBkcheck selectByPrimaryKey(Object pycreditPersonBkcheckId) {
        return super.selectByPrimaryKey(pycreditPersonBkcheckId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询个人银行卡核查
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditPersonBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public PageInfoExtend<PycreditPersonBkcheck> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询个人银行卡核查vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改个人银行卡核查
     * @param pycreditPersonBkcheck,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeyData(PycreditPersonBkcheck pycreditPersonBkcheck,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditPersonBkcheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改个人银行卡核查,并进行排他
     * @param pycreditPersonBkchecks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditPersonBkchecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改个人银行卡核查,并进行排他
     * @param pycreditPersonBkcheck
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditPersonBkcheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人银行卡核查,并进行排他
     * @param pycreditPersonBkchecks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditPersonBkchecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人银行卡核查,并进行排他
     * @param pycreditPersonBkcheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByExampleData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example,boolean exclusive) {
        return super.updateByExample(pycreditPersonBkcheck,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改个人银行卡核查,并进行排他
     * @param pycreditPersonBkcheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    @Override
    public int updateByExampleSelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditPersonBkcheck,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改个人银行卡核查,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditPersonBkcheck> selectPycreditPersonBkcheckList(String documentNo, int ceilingNumber){
        return baseDao.selectPycreditPersonBkcheckList(documentNo,ceilingNumber);
    }

    /**
     * @param documentNo
     * @Description: 查询最近一条个人银行卡核查
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 11:55
     */
    @Override
    public PycreditPersonBkcheck selectLastPycreditPersonBkcheckByDocumentNo(String documentNo) {
        return baseDao.selectLastPycreditPersonBkcheckByDocumentNo(documentNo);
    }
}
