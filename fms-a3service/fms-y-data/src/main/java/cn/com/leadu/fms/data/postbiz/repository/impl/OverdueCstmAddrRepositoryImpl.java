package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueCstmAddrDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmAddrRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrRepositoryImpl
 * @Description: 逾期客户地址信息Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class OverdueCstmAddrRepositoryImpl extends AbstractBaseRepository<OverdueCstmAddrDao, OverdueCstmAddr> implements OverdueCstmAddrRepository {

    /**
     * @Title:
     * @Description: 新增逾期客户地址信息
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int insertData(OverdueCstmAddr overdueCstmAddr) {
        return super.insert(overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期客户地址信息
     * @param overdueCstmAddrs
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int insertDataList(List<OverdueCstmAddr> overdueCstmAddrs){
        return super.insertListByJdbcTemplate(overdueCstmAddrs);
    }

    /**
     * @Title:
     * @Description: 修改逾期客户地址信息
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int updateByPrimaryKeyData(OverdueCstmAddr overdueCstmAddr) {
        return super.updateByPrimaryKey(overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期客户地址信息
     * @param overdueCstmAddrs
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueCstmAddr> overdueCstmAddrs){
        return super.updateListByPrimaryKey(overdueCstmAddrs);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期客户地址信息
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueCstmAddr overdueCstmAddr) {
        return super.updateByPrimaryKeySelective(overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期客户地址信息
     * @param overdueCstmAddrs
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueCstmAddr> overdueCstmAddrs) {
        return super.updateListByPrimaryKeySelective(overdueCstmAddrs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期客户地址信息
     * @param overdueCstmAddr
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int updateByExampleData(OverdueCstmAddr overdueCstmAddr, Example example) {
        return super.updateByExample(overdueCstmAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期客户地址信息
     * @param overdueCstmAddr
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int updateByExampleSelectiveData(OverdueCstmAddr overdueCstmAddr, Example example){
        return super.updateByExampleSelective(overdueCstmAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueCstmAddrId删除逾期客户地址信息
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public int deleteData(OverdueCstmAddr overdueCstmAddr) {
        return super.delete(overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 根据overdueCstmAddrId集合批量删除逾期客户地址信息
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public int deleteDataList(List overdueCstmAddrIds,OverdueCstmAddr overdueCstmAddr){
        return super.deleteByIds(overdueCstmAddrIds,overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期客户地址信息
     * @param example
     * @param overdueCstmAddr
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public int deleteExampleData(Example example,OverdueCstmAddr overdueCstmAddr){
        return super.deleteByExample(example,overdueCstmAddr);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期客户地址信息
     * @return List<OverdueCstmAddr>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public List<OverdueCstmAddr> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期客户地址信息
     * @param example
     * @return OverdueCstmAddr
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public OverdueCstmAddr selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期客户地址信息
     * @param example
     * @return List<OverdueCstmAddr>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public List<OverdueCstmAddr> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueCstmAddrId查询逾期客户地址信息
     * @param overdueCstmAddrId
     * @return OverdueCstmAddr
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public OverdueCstmAddr selectByPrimaryKey(Object overdueCstmAddrId) {
        return super.selectByPrimaryKey(overdueCstmAddrId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueCstmAddr>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @Override
    public PageInfoExtend<OverdueCstmAddr> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
