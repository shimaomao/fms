package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.data.riskmgmt.dao.PycreditCardCheckDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCardCheckRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckRepositoryImpl
 * @Description: 卡核查及交易Repository 实现层
 * @date 2018-06-14
 */
@Repository
public class PycreditCardCheckRepositoryImpl extends AbstractBaseRepository<PycreditCardCheckDao, PycreditCardCheck> implements PycreditCardCheckRepository {

    /**
     * @Title:
     * @Description: 新增卡核查及交易
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int insertData(PycreditCardCheck pycreditCardCheck) {
        return super.insert(pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 批量保存卡核查及交易
     * @param pycreditCardChecks
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int insertDataList(List<PycreditCardCheck> pycreditCardChecks){
        return super.insertListByJdbcTemplate(pycreditCardChecks);
    }

    /**
     * @Title:
     * @Description: 修改卡核查及交易
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCardCheck pycreditCardCheck) {
        return super.updateByPrimaryKey(pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 批量修改卡核查及交易
     * @param pycreditCardChecks
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCardCheck> pycreditCardChecks){
        return super.updateListByPrimaryKey(pycreditCardChecks);
    }

    /**
     * @Title:
     * @Description: 动态修改卡核查及交易
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCardCheck pycreditCardCheck) {
        return super.updateByPrimaryKeySelective(pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 批量动态修改卡核查及交易
     * @param pycreditCardChecks
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCardCheck> pycreditCardChecks) {
        return super.updateListByPrimaryKeySelective(pycreditCardChecks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改卡核查及交易
     * @param pycreditCardCheck
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByExampleData(PycreditCardCheck pycreditCardCheck, Example example) {
        return super.updateByExample(pycreditCardCheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改卡核查及交易
     * @param pycreditCardCheck
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCardCheck pycreditCardCheck, Example example){
        return super.updateByExampleSelective(pycreditCardCheck,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditCardCheckId删除卡核查及交易
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int deleteData(PycreditCardCheck pycreditCardCheck) {
        return super.delete(pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 根据pycreditCardCheckId集合批量删除卡核查及交易
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int deleteDataList(List pycreditCardCheckIds,PycreditCardCheck pycreditCardCheck){
        return super.deleteByIds(pycreditCardCheckIds,pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除卡核查及交易
     * @param example
     * @param pycreditCardCheck
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int deleteExampleData(Example example,PycreditCardCheck pycreditCardCheck){
        return super.deleteByExample(example,pycreditCardCheck);
    }

    /**
     * @Title:
     * @Description: 查询全部卡核查及交易
     * @return List<PycreditCardCheck>
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public List<PycreditCardCheck> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个卡核查及交易
     * @param example
     * @return PycreditCardCheck
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public PycreditCardCheck selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询卡核查及交易
     * @param example
     * @return List<PycreditCardCheck>
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public List<PycreditCardCheck> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditCardCheckId查询卡核查及交易
     * @param pycreditCardCheckId
     * @return PycreditCardCheck
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public PycreditCardCheck selectByPrimaryKey(Object pycreditCardCheckId) {
        return super.selectByPrimaryKey(pycreditCardCheckId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询卡核查及交易
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditCardCheck>
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public PageInfoExtend<PycreditCardCheck> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询卡核查及交易vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改卡核查及交易
     * @param pycreditCardCheck,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeyData(PycreditCardCheck pycreditCardCheck,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditCardCheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改卡核查及交易,并进行排他
     * @param pycreditCardChecks
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditCardCheck> pycreditCardChecks,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditCardChecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改卡核查及交易,并进行排他
     * @param pycreditCardCheck
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditCardCheck pycreditCardCheck,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditCardCheck,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改卡核查及交易,并进行排他
     * @param pycreditCardChecks
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditCardCheck> pycreditCardChecks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditCardChecks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改卡核查及交易,并进行排他
     * @param pycreditCardCheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByExampleData(PycreditCardCheck pycreditCardCheck, Example example,boolean exclusive) {
        return super.updateByExample(pycreditCardCheck,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改卡核查及交易,并进行排他
     * @param pycreditCardCheck
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    @Override
    public int updateByExampleSelectiveData(PycreditCardCheck pycreditCardCheck, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditCardCheck,example,exclusive);
    }

}
