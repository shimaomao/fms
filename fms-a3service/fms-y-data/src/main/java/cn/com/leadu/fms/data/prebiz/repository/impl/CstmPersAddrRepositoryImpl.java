package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmPersAddrDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersAddrRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrRepositoryImpl
 * @Description: 客户个人地址信息Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class CstmPersAddrRepositoryImpl extends AbstractBaseRepository<CstmPersAddrDao, CstmPersAddr> implements CstmPersAddrRepository {

    /**
     * @Title:
     * @Description: 新增客户个人地址信息
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int insertData(CstmPersAddr cstmPersAddr) {
        return super.insert(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 批量保存客户个人地址信息
     * @param cstmPersAddrs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int insertDataList(List<CstmPersAddr> cstmPersAddrs){
        return super.insertListByJdbcTemplate(cstmPersAddrs);
    }

    /**
     * @Title:
     * @Description: 修改客户个人地址信息
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int updateByPrimaryKeyData(CstmPersAddr cstmPersAddr) {
        return super.updateByPrimaryKey(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 批量修改客户个人地址信息
     * @param cstmPersAddrs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmPersAddr> cstmPersAddrs){
        return super.insertListByJdbcTemplate(cstmPersAddrs);
    }

    /**
     * @Title:
     * @Description: 动态修改客户个人地址信息
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmPersAddr cstmPersAddr) {
        return super.updateByPrimaryKeySelective(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户个人地址信息
     * @param cstmPersAddrs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmPersAddr> cstmPersAddrs) {
        return super.updateListByPrimaryKeySelective(cstmPersAddrs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户个人地址信息
     * @param cstmPersAddr
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int updateByExampleData(CstmPersAddr cstmPersAddr, Example example) {
        return super.updateByExample(cstmPersAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户个人地址信息
     * @param cstmPersAddr
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int updateByExampleSelectiveData(CstmPersAddr cstmPersAddr, Example example){
        return super.updateByExampleSelective(cstmPersAddr,example);
    }
    
    /**
     * @Title:
     * @Description: 根据persAddrId删除客户个人地址信息
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public int deleteData(CstmPersAddr cstmPersAddr) {
        return super.delete(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 根据persAddrId集合批量删除客户个人地址信息
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public int deleteDataList(List persAddrIds,CstmPersAddr cstmPersAddr){
        return super.deleteByIds(persAddrIds,cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户个人地址信息
     * @param example
     * @param cstmPersAddr
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public int deleteExampleData(Example example,CstmPersAddr cstmPersAddr){
        return super.deleteByExample(example,cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 查询全部客户个人地址信息
     * @return List<CstmPersAddr>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public List<CstmPersAddr> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户个人地址信息
     * @param example
     * @return CstmPersAddr
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public CstmPersAddr selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户个人地址信息
     * @param example
     * @return List<CstmPersAddr>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public List<CstmPersAddr> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过persAddrId查询客户个人地址信息
     * @param persAddrId
     * @return CstmPersAddr
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public CstmPersAddr selectByPrimaryKey(Object persAddrId) {
        return super.selectByPrimaryKey(persAddrId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmPersAddr>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public PageInfoExtend<CstmPersAddr> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmPersAddr>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public PageInfoExtend<CstmPersAddr> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
