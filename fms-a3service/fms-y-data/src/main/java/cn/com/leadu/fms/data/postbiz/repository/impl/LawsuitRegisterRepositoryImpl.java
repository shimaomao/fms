package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.LawsuitRegisterDao;
import cn.com.leadu.fms.data.postbiz.repository.LawsuitRegisterRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterRepositoryImpl
 * @Description: 诉讼登记信息Repository 实现层
 */
@Repository
public class LawsuitRegisterRepositoryImpl extends AbstractBaseRepository<LawsuitRegisterDao, LawsuitRegister> implements LawsuitRegisterRepository {

    /**
     * @Title:
     * @Description: 新增诉讼登记信息
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int insertData(LawsuitRegister lawsuitRegister) {
        return super.insert(lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 批量保存诉讼登记信息
     * @param lawsuitRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int insertDataList(List<LawsuitRegister> lawsuitRegisters){
        return super.insertListByJdbcTemplate(lawsuitRegisters);
    }

    /**
     * @Title:
     * @Description: 修改诉讼登记信息
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeyData(LawsuitRegister lawsuitRegister) {
        return super.updateByPrimaryKey(lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 批量修改诉讼登记信息
     * @param lawsuitRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LawsuitRegister> lawsuitRegisters){
        return super.updateListByPrimaryKey(lawsuitRegisters);
    }

    /**
     * @Title:
     * @Description: 动态修改诉讼登记信息
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LawsuitRegister lawsuitRegister) {
        return super.updateByPrimaryKeySelective(lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 批量动态修改诉讼登记信息
     * @param lawsuitRegisters
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LawsuitRegister> lawsuitRegisters) {
        return super.updateListByPrimaryKeySelective(lawsuitRegisters);
    }

    /**
     * @Title:
     * @Description: 根据条件修改诉讼登记信息
     * @param lawsuitRegister
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByExampleData(LawsuitRegister lawsuitRegister, Example example) {
        return super.updateByExample(lawsuitRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改诉讼登记信息
     * @param lawsuitRegister
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByExampleSelectiveData(LawsuitRegister lawsuitRegister, Example example){
        return super.updateByExampleSelective(lawsuitRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据lawsuitRegisterId删除诉讼登记信息
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int deleteData(LawsuitRegister lawsuitRegister) {
        return super.delete(lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitRegisterId集合批量删除诉讼登记信息
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int deleteDataList(List lawsuitRegisterIds,LawsuitRegister lawsuitRegister){
        return super.deleteByIds(lawsuitRegisterIds,lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除诉讼登记信息
     * @param example
     * @param lawsuitRegister
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int deleteExampleData(Example example,LawsuitRegister lawsuitRegister){
        return super.deleteByExample(example,lawsuitRegister);
    }

    /**
     * @Title:
     * @Description: 查询全部诉讼登记信息
     * @return List<LawsuitRegister>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public List<LawsuitRegister> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个诉讼登记信息
     * @param example
     * @return LawsuitRegister
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public LawsuitRegister selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询诉讼登记信息
     * @param example
     * @return List<LawsuitRegister>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public List<LawsuitRegister> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过lawsuitRegisterId查询诉讼登记信息
     * @param lawsuitRegisterId
     * @return LawsuitRegister
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public LawsuitRegister selectByPrimaryKey(Object lawsuitRegisterId) {
        return super.selectByPrimaryKey(lawsuitRegisterId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<LawsuitRegister>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public PageInfoExtend<LawsuitRegister> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改诉讼登记信息
     * @param lawsuitRegister,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeyData(LawsuitRegister lawsuitRegister,boolean exclusive) {
        return super.updateByPrimaryKey(lawsuitRegister,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改诉讼登记信息,并进行排他
     * @param lawsuitRegisters
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LawsuitRegister> lawsuitRegisters,boolean exclusive){
        return super.updateListByPrimaryKey(lawsuitRegisters,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改诉讼登记信息,并进行排他
     * @param lawsuitRegister
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LawsuitRegister lawsuitRegister,boolean exclusive) {
        return super.updateByPrimaryKeySelective(lawsuitRegister,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改诉讼登记信息,并进行排他
     * @param lawsuitRegisters
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LawsuitRegister> lawsuitRegisters,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(lawsuitRegisters,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改诉讼登记信息,并进行排他
     * @param lawsuitRegister
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByExampleData(LawsuitRegister lawsuitRegister, Example example,boolean exclusive) {
        return super.updateByExample(lawsuitRegister,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改诉讼登记信息,并进行排他
     * @param lawsuitRegister
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @Override
    public int updateByExampleSelectiveData(LawsuitRegister lawsuitRegister, Example example,boolean exclusive){
        return super.updateByExampleSelective(lawsuitRegister,example,exclusive);
    }

}
