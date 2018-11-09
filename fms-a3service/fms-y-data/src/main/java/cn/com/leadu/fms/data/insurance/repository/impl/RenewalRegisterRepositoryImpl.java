package cn.com.leadu.fms.data.insurance.repository.impl;

import cn.com.leadu.fms.data.insurance.dao.RenewalRegisterDao;
import cn.com.leadu.fms.data.insurance.repository.RenewalRegisterRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RenewalRegisterRepositoryImpl
 * @Description: 续保任务登记Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class RenewalRegisterRepositoryImpl extends AbstractBaseRepository<RenewalRegisterDao, RenewalRegister> implements RenewalRegisterRepository {

    /**
     * @Title:
     * @Description: 新增续保任务登记
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int insertData(RenewalRegister renewalRegister) {
        return super.insert(renewalRegister);
    }

    /**
     * @Title:
     * @Description: 批量保存续保任务登记
     * @param renewalRegisters
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int insertDataList(List<RenewalRegister> renewalRegisters){
        return super.insertListByJdbcTemplate(renewalRegisters);
    }

    /**
     * @Title:
     * @Description: 修改续保任务登记
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int updateByPrimaryKeyData(RenewalRegister renewalRegister) {
        return super.updateByPrimaryKey(renewalRegister);
    }

    /**
     * @Title:
     * @Description: 批量修改续保任务登记
     * @param renewalRegisters
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RenewalRegister> renewalRegisters){
        return super.updateListByPrimaryKey(renewalRegisters);
    }

    /**
     * @Title:
     * @Description: 动态修改续保任务登记
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RenewalRegister renewalRegister) {
        return super.updateByPrimaryKeySelective(renewalRegister);
    }

    @Override
    public int updateByPrimaryKeySelectiveData(RenewalRegister renewalRegister, boolean exclusive) {
        return super.updateByPrimaryKeySelective(renewalRegister, exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改续保任务登记
     * @param renewalRegisters
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    public int updateByPrimaryKeySelectiveDataList(List<RenewalRegister> renewalRegisters) {
        return super.updateListByPrimaryKeySelective(renewalRegisters);
    }

    /**
     * @Title:
     * @Description: 根据条件修改续保任务登记
     * @param renewalRegister
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int updateByExampleData(RenewalRegister renewalRegister, Example example) {
        return super.updateByExample(renewalRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改续保任务登记
     * @param renewalRegister
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int updateByExampleSelectiveData(RenewalRegister renewalRegister, Example example){
        return super.updateByExampleSelective(renewalRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据renewalRegisterId删除续保任务登记
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public int deleteData(RenewalRegister renewalRegister) {
        return super.delete(renewalRegister);
    }

    /**
     * @Title:
     * @Description: 根据renewalRegisterId集合批量删除续保任务登记
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    public int deleteDataList(List renewalRegisterIds,RenewalRegister renewalRegister){
        return super.deleteByIds(renewalRegisterIds,renewalRegister);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除续保任务登记
     * @param example
     * @param renewalRegister
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    public int deleteExampleData(Example example,RenewalRegister renewalRegister){
        return super.deleteByExample(example,renewalRegister);
    }

    /**
     * @Title:
     * @Description: 查询全部续保任务登记
     * @return List<RenewalRegister>
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public List<RenewalRegister> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个续保任务登记
     * @param example
     * @return RenewalRegister
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public RenewalRegister selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询续保任务登记
     * @param example
     * @return List<RenewalRegister>
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public List<RenewalRegister> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过renewalRegisterId查询续保任务登记
     * @param renewalRegisterId
     * @return RenewalRegister
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public RenewalRegister selectByPrimaryKey(Object renewalRegisterId) {
        return super.selectByPrimaryKey(renewalRegisterId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询续保任务登记
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RenewalRegister>
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    @Override
    public PageInfoExtend<RenewalRegister> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询续保任务登记vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 10:49:29
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 查找前三天未收到消息险信息
     * @param  renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date
     */
    @Override
    public List<RenewalRegisterVo> selectRenewalRegistersPriorMonth(RenewalRegisterVo renewalRegisterVo) {
        return baseDao.selectRenewalRegistersPriorMonth(renewalRegisterVo);
    }


    /**
     * @Title:
     * @Description: 查找一个月后到期的保险信息
     * @param  renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date
     */
    @Override
    public List<ContInsuranceVo> selectContInsuranPerMonth(RenewalRegisterVo renewalRegisterVo) {
        return baseDao.selectContInsuranPerMonth(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 查找即将到期保险信息
     * @param  renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date
     */
    @Override
    public List<RenewalRegisterVo> selectContInsurance(RenewalRegisterVo renewalRegisterVo) {
        return baseDao.selectContInsurance(renewalRegisterVo);
    }

}
