package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditDriverDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditDriverRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverRepositoryImpl
 * @Description: 驾驶证核查Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditDriverRepositoryImpl extends AbstractBaseRepository<PycreditDriverDao, PycreditDriver> implements PycreditDriverRepository {

    /**
     * @Title:
     * @Description: 新增驾驶证核查
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int insertData(PycreditDriver pycreditDriver) {
        return super.insert(pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 批量保存驾驶证核查
     * @param pycreditDrivers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int insertDataList(List<PycreditDriver> pycreditDrivers){
        return super.insertListByJdbcTemplate(pycreditDrivers);
    }

    /**
     * @Title:
     * @Description: 修改驾驶证核查
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeyData(PycreditDriver pycreditDriver) {
        return super.updateByPrimaryKey(pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 批量修改驾驶证核查
     * @param pycreditDrivers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditDriver> pycreditDrivers){
        return super.updateListByPrimaryKey(pycreditDrivers);
    }

    /**
     * @Title:
     * @Description: 动态修改驾驶证核查
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditDriver pycreditDriver) {
        return super.updateByPrimaryKeySelective(pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 批量动态修改驾驶证核查
     * @param pycreditDrivers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditDriver> pycreditDrivers) {
        return super.updateListByPrimaryKeySelective(pycreditDrivers);
    }

    /**
     * @Title:
     * @Description: 根据条件修改驾驶证核查
     * @param pycreditDriver
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByExampleData(PycreditDriver pycreditDriver, Example example) {
        return super.updateByExample(pycreditDriver,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改驾驶证核查
     * @param pycreditDriver
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByExampleSelectiveData(PycreditDriver pycreditDriver, Example example){
        return super.updateByExampleSelective(pycreditDriver,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditDriverId删除驾驶证核查
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int deleteData(PycreditDriver pycreditDriver) {
        return super.delete(pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 根据pycreditDriverId集合批量删除驾驶证核查
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int deleteDataList(List pycreditDriverIds,PycreditDriver pycreditDriver){
        return super.deleteByIds(pycreditDriverIds,pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除驾驶证核查
     * @param example
     * @param pycreditDriver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int deleteExampleData(Example example,PycreditDriver pycreditDriver){
        return super.deleteByExample(example,pycreditDriver);
    }

    /**
     * @Title:
     * @Description: 查询全部驾驶证核查
     * @return List<PycreditDriver>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public List<PycreditDriver> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个驾驶证核查
     * @param example
     * @return PycreditDriver
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public PycreditDriver selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询驾驶证核查
     * @param example
     * @return List<PycreditDriver>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public List<PycreditDriver> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditDriverId查询驾驶证核查
     * @param pycreditDriverId
     * @return PycreditDriver
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public PycreditDriver selectByPrimaryKey(Object pycreditDriverId) {
        return super.selectByPrimaryKey(pycreditDriverId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询驾驶证核查
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditDriver>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public PageInfoExtend<PycreditDriver> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询驾驶证核查vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改驾驶证核查
     * @param pycreditDriver,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeyData(PycreditDriver pycreditDriver,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditDriver,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改驾驶证核查,并进行排他
     * @param pycreditDrivers
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditDriver> pycreditDrivers,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditDrivers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改驾驶证核查,并进行排他
     * @param pycreditDriver
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditDriver pycreditDriver,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditDriver,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改驾驶证核查,并进行排他
     * @param pycreditDrivers
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditDriver> pycreditDrivers,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditDrivers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改驾驶证核查,并进行排他
     * @param pycreditDriver
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByExampleData(PycreditDriver pycreditDriver, Example example,boolean exclusive) {
        return super.updateByExample(pycreditDriver,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改驾驶证核查,并进行排他
     * @param pycreditDriver
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    @Override
    public int updateByExampleSelectiveData(PycreditDriver pycreditDriver, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditDriver,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改驾驶证核查,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditDriver> selectPycreditDriverList(String documentNo, int ceilingNumber){
        return baseDao.selectPycreditDriverList(documentNo,ceilingNumber);
    }

    /**
     * @param documentNo
     * @Description: 查询最近一条驾驶证核查实体
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/6 14:34
     */
    @Override
    public PycreditDriver selectLastPycreditDriverByDocumentNo(String documentNo) {
        return baseDao.selectLastPycreditDriverByDocumentNo(documentNo);
    }
}
