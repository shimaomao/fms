package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContPayDao;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContPayRepositoryImpl
 * @Description: 财务付款表Repository 实现层
 * @date 2018-04-11
 */
@Repository
public class ContPayRepositoryImpl extends AbstractBaseRepository<ContPayDao, ContPay> implements ContPayRepository {

    /**
     * @Title:
     * @Description: 新增财务付款表
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int insertData(ContPay contPay) {
        return super.insert(contPay);
    }

    /**
     * @Title:
     * @Description: 批量保存财务付款表
     * @param contPays
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int insertDataList(List<ContPay> contPays){
        return super.insertListByJdbcTemplate(contPays);
    }

    /**
     * @Title:
     * @Description: 修改财务付款表
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int updateByPrimaryKeyData(ContPay contPay) {
        return super.updateByPrimaryKey(contPay);
    }

    /**
     * @Title:
     * @Description: 批量修改财务付款表
     * @param contPays
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContPay> contPays){
        return super.insertListByJdbcTemplate(contPays);
    }

    /**
     * @Title:
     * @Description: 动态修改财务付款表
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContPay contPay) {
        return super.updateByPrimaryKeySelective(contPay);
    }


    /**
     * @Title:
     * @Description: 动态修改财务付款表,并进行排他
     * @param contPay
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public int updateByPrimaryKeySelectiveData(ContPay contPay, boolean exclusive){
        return super.updateByPrimaryKeySelective(contPay,exclusive);
    }


    /**
     * @Title:
     * @Description: 批量动态修改财务付款表
     * @param contPays
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContPay> contPays) {
        return super.updateListByPrimaryKeySelective(contPays);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务付款表
     * @param contPay
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int updateByExampleData(ContPay contPay, Example example) {
        return super.updateByExample(contPay,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务付款表
     * @param contPay
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int updateByExampleSelectiveData(ContPay contPay, Example example){
        return super.updateByExampleSelective(contPay,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contPayId删除财务付款表
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public int deleteData(ContPay contPay) {
        return super.delete(contPay);
    }

    /**
     * @Title:
     * @Description: 根据contPayId集合批量删除财务付款表
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    public int deleteDataList(List contPayIds,ContPay contPay){
        return super.deleteByIds(contPayIds,contPay);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务付款表
     * @param example
     * @param contPay
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    public int deleteExampleData(Example example,ContPay contPay){
        return super.deleteByExample(example,contPay);
    }

    /**
     * @Title:
     * @Description: 查询全部财务付款表
     * @return List<ContPay>
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public List<ContPay> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务付款表
     * @param example
     * @return ContPay
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public ContPay selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务付款表
     * @param example
     * @return List<ContPay>
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public List<ContPay> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contPayId查询财务付款表
     * @param contPayId
     * @return ContPay
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public ContPay selectByPrimaryKey(Object contPayId) {
        return super.selectByPrimaryKey(contPayId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务付款表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContPay>
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public PageInfoExtend<ContPay> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务付款表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContPay>
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    public PageInfoExtend<ContPay> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @return PageInfoExtend<ContPay>
     * @Title:
     * @Description: 分页查询财务付款表vo
     * @author liujinge
     * @date 2018-4-11 10:10:16
     */
    @Override
    public PageInfoExtend<ContPayVo> selectListVosByPage(String methodName, Object param, PageQuery pageQuery) {
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
