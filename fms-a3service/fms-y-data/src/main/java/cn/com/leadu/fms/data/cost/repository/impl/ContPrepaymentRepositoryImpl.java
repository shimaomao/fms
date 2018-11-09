package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.ContPrepaymentDao;
import cn.com.leadu.fms.data.cost.repository.ContPrepaymentRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentRepositoryImpl
 * @Description: 提前还款Repository 实现层
 * @date 2018-05-10
 */
@Repository
public class ContPrepaymentRepositoryImpl extends AbstractBaseRepository<ContPrepaymentDao, ContPrepayment> implements ContPrepaymentRepository {

    /**
     * @Title:
     * @Description: 新增提前还款
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int insertData(ContPrepayment contPrepayment) {
        return super.insert(contPrepayment);
    }

    /**
     * @Title:
     * @Description: 批量保存提前还款
     * @param contPrepayments
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int insertDataList(List<ContPrepayment> contPrepayments){
        return super.insertListByJdbcTemplate(contPrepayments);
    }

    /**
     * @Title:
     * @Description: 修改提前还款
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int updateByPrimaryKeyData(ContPrepayment contPrepayment) {
        return super.updateByPrimaryKey(contPrepayment);
    }

    /**
     * @Title:
     * @Description: 批量修改提前还款
     * @param contPrepayments
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContPrepayment> contPrepayments){
        return super.updateListByPrimaryKey(contPrepayments);
    }

    /**
     * @Title:
     * @Description: 动态修改提前还款
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContPrepayment contPrepayment) {
        return super.updateByPrimaryKeySelective(contPrepayment);
    }

    /**
     * @Title:
     * @Description: 批量动态修改提前还款
     * @param contPrepayments
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContPrepayment> contPrepayments) {
        return super.updateListByPrimaryKeySelective(contPrepayments);
    }

    /**
    * @Description: 批量动态修改提前还款,并进行排他
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 18:46
    */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContPrepayment> contPrepayments, boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contPrepayments, exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改提前还款
     * @param contPrepayment
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int updateByExampleData(ContPrepayment contPrepayment, Example example) {
        return super.updateByExample(contPrepayment,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改提前还款
     * @param contPrepayment
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int updateByExampleSelectiveData(ContPrepayment contPrepayment, Example example){
        return super.updateByExampleSelective(contPrepayment,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contPrepaymentId删除提前还款
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public int deleteData(ContPrepayment contPrepayment) {
        return super.delete(contPrepayment);
    }

    /**
     * @Title:
     * @Description: 根据contPrepaymentId集合批量删除提前还款
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public int deleteDataList(List contPrepaymentIds,ContPrepayment contPrepayment){
        return super.deleteByIds(contPrepaymentIds,contPrepayment);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除提前还款
     * @param example
     * @param contPrepayment
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public int deleteExampleData(Example example,ContPrepayment contPrepayment){
        return super.deleteByExample(example,contPrepayment);
    }

    /**
     * @Title:
     * @Description: 查询全部提前还款
     * @return List<ContPrepayment>
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public List<ContPrepayment> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个提前还款
     * @param example
     * @return ContPrepayment
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public ContPrepayment selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询提前还款
     * @param example
     * @return List<ContPrepayment>
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public List<ContPrepayment> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contPrepaymentId查询提前还款
     * @param contPrepaymentId
     * @return ContPrepayment
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public ContPrepayment selectByPrimaryKey(Object contPrepaymentId) {
        return super.selectByPrimaryKey(contPrepaymentId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询提前还款
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContPrepayment>
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @Override
    public PageInfoExtend<ContPrepayment> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询提前还款vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @param contPrepaymentVo
     * @Description: 通过合同号查询提前还款相关信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/19 19:58
     */
    @Override
    public ContPrepaymentVo selectContPrepaymentByContNo(ContPrepaymentVo contPrepaymentVo) {
        return baseDao.selectContPrepaymentByContNo(contPrepaymentVo);
    }

    /**
     * @Description: 查找当日>提前还款失效日 且 合同未结清的提前还款
     * @param: uncleared 未结清状态
     * @param: prepaymentInvalid 提前还款作废状态
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/24 17:18
     */
    @Override
    public List<ContPrepaymentVo> selectInValidContPrepayment(String uncleared,String prepaymentInvalid,String prepaymentValid) {
        return baseDao.selectInValidContPrepayment(uncleared,prepaymentInvalid,prepaymentValid);
    }

}
