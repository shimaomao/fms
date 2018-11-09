package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueTelRegisterDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueTelRegisterRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterRepositoryImpl
 * @Description: 电话催收登记信息Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class OverdueTelRegisterRepositoryImpl extends AbstractBaseRepository<OverdueTelRegisterDao, OverdueTelRegister> implements OverdueTelRegisterRepository {

    /**
     * @Title:
     * @Description: 新增电话催收登记信息
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int insertData(OverdueTelRegister overdueTelRegister) {
        return super.insert(overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 批量保存电话催收登记信息
     * @param overdueTelRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int insertDataList(List<OverdueTelRegister> overdueTelRegisters){
        return super.insertListByJdbcTemplate(overdueTelRegisters);
    }

    /**
     * @Title:
     * @Description: 修改电话催收登记信息
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int updateByPrimaryKeyData(OverdueTelRegister overdueTelRegister) {
        return super.updateByPrimaryKey(overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 批量修改电话催收登记信息
     * @param overdueTelRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueTelRegister> overdueTelRegisters){
        return super.updateListByPrimaryKey(overdueTelRegisters);
    }

    /**
     * @Title:
     * @Description: 动态修改电话催收登记信息
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueTelRegister overdueTelRegister) {
        return super.updateByPrimaryKeySelective(overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 批量动态修改电话催收登记信息
     * @param overdueTelRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueTelRegister> overdueTelRegisters) {
        return super.updateListByPrimaryKeySelective(overdueTelRegisters);
    }

    /**
     * @Title:
     * @Description: 根据条件修改电话催收登记信息
     * @param overdueTelRegister
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int updateByExampleData(OverdueTelRegister overdueTelRegister, Example example) {
        return super.updateByExample(overdueTelRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改电话催收登记信息
     * @param overdueTelRegister
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int updateByExampleSelectiveData(OverdueTelRegister overdueTelRegister, Example example){
        return super.updateByExampleSelective(overdueTelRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueTelRegisterId删除电话催收登记信息
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public int deleteData(OverdueTelRegister overdueTelRegister) {
        return super.delete(overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 根据overdueTelRegisterId集合批量删除电话催收登记信息
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public int deleteDataList(List overdueTelRegisterIds,OverdueTelRegister overdueTelRegister){
        return super.deleteByIds(overdueTelRegisterIds,overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除电话催收登记信息
     * @param example
     * @param overdueTelRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public int deleteExampleData(Example example,OverdueTelRegister overdueTelRegister){
        return super.deleteByExample(example,overdueTelRegister);
    }

    /**
     * @Title:
     * @Description: 查询全部电话催收登记信息
     * @return List<OverdueTelRegister>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public List<OverdueTelRegister> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个电话催收登记信息
     * @param example
     * @return OverdueTelRegister
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public OverdueTelRegister selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询电话催收登记信息
     * @param example
     * @return List<OverdueTelRegister>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public List<OverdueTelRegister> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueTelRegisterId查询电话催收登记信息
     * @param overdueTelRegisterId
     * @return OverdueTelRegister
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public OverdueTelRegister selectByPrimaryKey(Object overdueTelRegisterId) {
        return super.selectByPrimaryKey(overdueTelRegisterId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueTelRegister>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @Override
    public PageInfoExtend<OverdueTelRegister> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
