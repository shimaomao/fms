package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.MortgageRegisterDao;
import cn.com.leadu.fms.data.asset.repository.MortgageRegisterRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterRepositoryImpl
 * @Description: 解抵押过户信息Repository 实现层
 * @date 2018-05-18
 */
@Repository
public class MortgageRegisterRepositoryImpl extends AbstractBaseRepository<MortgageRegisterDao, MortgageRegister> implements MortgageRegisterRepository {

    /**
     * @Title:
     * @Description: 新增解抵押过户信息
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int insertData(MortgageRegister mortgageRegister) {
        return super.insert(mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 批量保存解抵押过户信息
     * @param mortgageRegisters
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int insertDataList(List<MortgageRegister> mortgageRegisters){
        return super.insertListByJdbcTemplate(mortgageRegisters);
    }

    /**
     * @Title:
     * @Description: 修改解抵押过户信息
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int updateByPrimaryKeyData(MortgageRegister mortgageRegister) {
        return super.updateByPrimaryKey(mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 批量修改解抵押过户信息
     * @param mortgageRegisters
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MortgageRegister> mortgageRegisters){
        return super.updateListByPrimaryKey(mortgageRegisters);
    }

    /**
     * @Title:
     * @Description: 动态修改解抵押过户信息
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MortgageRegister mortgageRegister) {
        return super.updateByPrimaryKeySelective(mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 批量动态修改解抵押过户信息
     * @param mortgageRegisters
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    public int updateByPrimaryKeySelectiveDataList(List<MortgageRegister> mortgageRegisters) {
        return super.updateListByPrimaryKeySelective(mortgageRegisters);
    }

    /**
     * @Title:
     * @Description: 根据条件修改解抵押过户信息
     * @param mortgageRegister
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int updateByExampleData(MortgageRegister mortgageRegister, Example example) {
        return super.updateByExample(mortgageRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改解抵押过户信息
     * @param mortgageRegister
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int updateByExampleSelectiveData(MortgageRegister mortgageRegister, Example example){
        return super.updateByExampleSelective(mortgageRegister,example);
    }
    
    /**
     * @Title:
     * @Description: 根据mortgageRegisterId删除解抵押过户信息
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public int deleteData(MortgageRegister mortgageRegister) {
        return super.delete(mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 根据mortgageRegisterId集合批量删除解抵押过户信息
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    public int deleteDataList(List mortgageRegisterIds,MortgageRegister mortgageRegister){
        return super.deleteByIds(mortgageRegisterIds,mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除解抵押过户信息
     * @param example
     * @param mortgageRegister
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    public int deleteExampleData(Example example,MortgageRegister mortgageRegister){
        return super.deleteByExample(example,mortgageRegister);
    }

    /**
     * @Title:
     * @Description: 查询全部解抵押过户信息
     * @return List<MortgageRegister>
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public List<MortgageRegister> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个解抵押过户信息
     * @param example
     * @return MortgageRegister
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public MortgageRegister selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询解抵押过户信息
     * @param example
     * @return List<MortgageRegister>
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public List<MortgageRegister> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过mortgageRegisterId查询解抵押过户信息
     * @param mortgageRegisterId
     * @return MortgageRegister
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public MortgageRegister selectByPrimaryKey(Object mortgageRegisterId) {
        return super.selectByPrimaryKey(mortgageRegisterId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询解抵押过户信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MortgageRegister>
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @Override
    public PageInfoExtend<MortgageRegister> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询解抵押过户信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
