package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.data.cost.dao.PilferInsuranceDao;
import cn.com.leadu.fms.data.cost.repository.PilferInsuranceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.CstmDetailVo;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceRepositoryImpl
 * @Description: 盗抢险信息Repository 实现层
 * @date 2018-05-31
 */
@Repository
public class PilferInsuranceRepositoryImpl extends AbstractBaseRepository<PilferInsuranceDao, PilferInsurance> implements PilferInsuranceRepository {

    /**
     * @Title:
     * @Description: 新增盗抢险信息
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int insertData(PilferInsurance pilferInsurance) {
        return super.insert(pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量保存盗抢险信息
     * @param pilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int insertDataList(List<PilferInsurance> pilferInsurances){
        return super.insertListByJdbcTemplate(pilferInsurances);
    }

    /**
     * @Title:
     * @Description: 修改盗抢险信息
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeyData(PilferInsurance pilferInsurance) {
        return super.updateByPrimaryKey(pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量修改盗抢险信息
     * @param pilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PilferInsurance> pilferInsurances){
        return super.updateListByPrimaryKey(pilferInsurances);
    }

    /**
     * @Title:
     * @Description: 动态修改盗抢险信息
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PilferInsurance pilferInsurance) {
        return super.updateByPrimaryKeySelective(pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量动态修改盗抢险信息
     * @param pilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PilferInsurance> pilferInsurances) {
        return super.updateListByPrimaryKeySelective(pilferInsurances);
    }

    /**
     * @Title:
     * @Description: 根据条件修改盗抢险信息
     * @param pilferInsurance
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByExampleData(PilferInsurance pilferInsurance, Example example) {
        return super.updateByExample(pilferInsurance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改盗抢险信息
     * @param pilferInsurance
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByExampleSelectiveData(PilferInsurance pilferInsurance, Example example){
        return super.updateByExampleSelective(pilferInsurance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pilferInsuranceId删除盗抢险信息
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int deleteData(PilferInsurance pilferInsurance) {
        return super.delete(pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 根据pilferInsuranceId集合批量删除盗抢险信息
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int deleteDataList(List pilferInsuranceIds,PilferInsurance pilferInsurance){
        return super.deleteByIds(pilferInsuranceIds,pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除盗抢险信息
     * @param example
     * @param pilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int deleteExampleData(Example example,PilferInsurance pilferInsurance){
        return super.deleteByExample(example,pilferInsurance);
    }

    /**
     * @Title:
     * @Description: 查询全部盗抢险信息
     * @return List<PilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public List<PilferInsurance> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个盗抢险信息
     * @param example
     * @return PilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public PilferInsurance selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询盗抢险信息
     * @param example
     * @return List<PilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public List<PilferInsurance> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pilferInsuranceId查询盗抢险信息
     * @param pilferInsuranceId
     * @return PilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public PilferInsurance selectByPrimaryKey(Object pilferInsuranceId) {
        return super.selectByPrimaryKey(pilferInsuranceId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询盗抢险信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public PageInfoExtend<PilferInsurance> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改盗抢险信息
     * @param pilferInsurance,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeyData(PilferInsurance pilferInsurance,boolean exclusive) {
        return super.updateByPrimaryKey(pilferInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改盗抢险信息,并进行排他
     * @param pilferInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PilferInsurance> pilferInsurances,boolean exclusive){
        return super.updateListByPrimaryKey(pilferInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改盗抢险信息,并进行排他
     * @param pilferInsurance
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PilferInsurance pilferInsurance,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pilferInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改盗抢险信息,并进行排他
     * @param pilferInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PilferInsurance> pilferInsurances,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pilferInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改盗抢险信息,并进行排他
     * @param pilferInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByExampleData(PilferInsurance pilferInsurance, Example example,boolean exclusive) {
        return super.updateByExample(pilferInsurance,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改盗抢险信息,并进行排他
     * @param pilferInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @Override
    public int updateByExampleSelectiveData(PilferInsurance pilferInsurance, Example example,boolean exclusive){
        return super.updateByExampleSelective(pilferInsurance,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据合同号查询一条客户基本信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public CstmDetailVo selectOneCstmDetailByContNo(String contNo){
        return baseDao.selectOneCstmDetailByContNo(contNo);
    }

}
