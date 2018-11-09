package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditAddrDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditAddrRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrRepositoryImpl
 * @Description: 地址核验Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditAddrRepositoryImpl extends AbstractBaseRepository<PycreditAddrDao, PycreditAddr> implements PycreditAddrRepository {

    /**
     * @Title:
     * @Description: 新增地址核验
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int insertData(PycreditAddr pycreditAddr) {
        return super.insert(pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 批量保存地址核验
     * @param pycreditAddrs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int insertDataList(List<PycreditAddr> pycreditAddrs){
        return super.insertListByJdbcTemplate(pycreditAddrs);
    }

    /**
     * @Title:
     * @Description: 修改地址核验
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeyData(PycreditAddr pycreditAddr) {
        return super.updateByPrimaryKey(pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 批量修改地址核验
     * @param pycreditAddrs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditAddr> pycreditAddrs){
        return super.updateListByPrimaryKey(pycreditAddrs);
    }

    /**
     * @Title:
     * @Description: 动态修改地址核验
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditAddr pycreditAddr) {
        return super.updateByPrimaryKeySelective(pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 批量动态修改地址核验
     * @param pycreditAddrs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditAddr> pycreditAddrs) {
        return super.updateListByPrimaryKeySelective(pycreditAddrs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改地址核验
     * @param pycreditAddr
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByExampleData(PycreditAddr pycreditAddr, Example example) {
        return super.updateByExample(pycreditAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改地址核验
     * @param pycreditAddr
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByExampleSelectiveData(PycreditAddr pycreditAddr, Example example){
        return super.updateByExampleSelective(pycreditAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditAddrId删除地址核验
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int deleteData(PycreditAddr pycreditAddr) {
        return super.delete(pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 根据pycreditAddrId集合批量删除地址核验
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int deleteDataList(List pycreditAddrIds,PycreditAddr pycreditAddr){
        return super.deleteByIds(pycreditAddrIds,pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除地址核验
     * @param example
     * @param pycreditAddr
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int deleteExampleData(Example example,PycreditAddr pycreditAddr){
        return super.deleteByExample(example,pycreditAddr);
    }

    /**
     * @Title:
     * @Description: 查询全部地址核验
     * @return List<PycreditAddr>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public List<PycreditAddr> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个地址核验
     * @param example
     * @return PycreditAddr
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public PycreditAddr selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询地址核验
     * @param example
     * @return List<PycreditAddr>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public List<PycreditAddr> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditAddrId查询地址核验
     * @param pycreditAddrId
     * @return PycreditAddr
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public PycreditAddr selectByPrimaryKey(Object pycreditAddrId) {
        return super.selectByPrimaryKey(pycreditAddrId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询地址核验
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditAddr>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public PageInfoExtend<PycreditAddr> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询地址核验vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改地址核验
     * @param pycreditAddr,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeyData(PycreditAddr pycreditAddr,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditAddr,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改地址核验,并进行排他
     * @param pycreditAddrs
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditAddr> pycreditAddrs,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditAddrs,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改地址核验,并进行排他
     * @param pycreditAddr
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditAddr pycreditAddr,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditAddr,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改地址核验,并进行排他
     * @param pycreditAddrs
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditAddr> pycreditAddrs,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditAddrs,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改地址核验,并进行排他
     * @param pycreditAddr
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByExampleData(PycreditAddr pycreditAddr, Example example,boolean exclusive) {
        return super.updateByExample(pycreditAddr,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改地址核验,并进行排他
     * @param pycreditAddr
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    @Override
    public int updateByExampleSelectiveData(PycreditAddr pycreditAddr, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditAddr,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改反欺诈分析,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditAddr> selectPycreditAddrList(String documentNo, int ceilingNumber){
        return baseDao.selectPycreditAddrList(documentNo,ceilingNumber);
    }

    /**
     * @param documentNo
     * @Description: 查询最近一条查询记录
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 11:39
     */
    @Override
    public PycreditAddr selectLastPycreditAddrByDocumentNo(String documentNo) {
        return baseDao.selectLastPycreditAddrByDocumentNo(documentNo);
    }
}
