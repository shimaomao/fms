package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContInsuranceDao;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContInsuranceRepositoryImpl
 * @Description: 合同车辆保险信息Repository 实现层
 * @date 2018-06-11
 */
@Repository
public class ContInsuranceRepositoryImpl extends AbstractBaseRepository<ContInsuranceDao, ContInsurance> implements ContInsuranceRepository {

    /**
     * @Title:
     * @Description: 新增合同车辆保险信息
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int insertData(ContInsurance contInsurance) {
        return super.insert(contInsurance);
    }

    /**
     * @Title:
     * @Description: 批量保存合同车辆保险信息
     * @param contInsurances
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int insertDataList(List<ContInsurance> contInsurances){
        return super.insertListByJdbcTemplate(contInsurances);
    }

    /**
     * @Title:
     * @Description: 修改合同车辆保险信息
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeyData(ContInsurance contInsurance) {
        return super.updateByPrimaryKey(contInsurance);
    }

    /**
     * @Title:
     * @Description: 批量修改合同车辆保险信息
     * @param contInsurances
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContInsurance> contInsurances){
        return super.updateListByPrimaryKey(contInsurances);
    }

    /**
     * @Title:
     * @Description: 动态修改合同车辆保险信息
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContInsurance contInsurance) {
        return super.updateByPrimaryKeySelective(contInsurance);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同车辆保险信息
     * @param contInsurances
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContInsurance> contInsurances) {
        return super.updateListByPrimaryKeySelective(contInsurances);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同车辆保险信息
     * @param contInsurance
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByExampleData(ContInsurance contInsurance, Example example) {
        return super.updateByExample(contInsurance,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改合同车辆保险信息
     * @param contInsurance
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByExampleSelectiveData(ContInsurance contInsurance, Example example){
        return super.updateByExampleSelective(contInsurance,example);
    }

    /**
     * @Title:
     * @Description: 根据contVehinsId删除合同车辆保险信息
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int deleteData(ContInsurance contInsurance) {
        return super.delete(contInsurance);
    }

    /**
     * @Title:
     * @Description: 根据contVehinsId集合批量删除合同车辆保险信息
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int deleteDataList(List contVehinsIds,ContInsurance contInsurance){
        return super.deleteByIds(contVehinsIds,contInsurance);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除合同车辆保险信息
     * @param example
     * @param contInsurance
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int deleteExampleData(Example example,ContInsurance contInsurance){
        return super.deleteByExample(example,contInsurance);
    }

    /**
     * @Title:
     * @Description: 查询全部合同车辆保险信息
     * @return List<ContInsurance>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public List<ContInsurance> selectAll() {
        return super.selectAll();
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个合同车辆保险信息
     * @param example
     * @return ContInsurance
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public ContInsurance selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过条件批量查询合同车辆保险信息
     * @param example
     * @return List<ContInsurance>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public List<ContInsurance> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过contVehinsId查询合同车辆保险信息
     * @param contVehinsId
     * @return ContInsurance
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public ContInsurance selectByPrimaryKey(Object contVehinsId) {
        return super.selectByPrimaryKey(contVehinsId);
    }

    /**
     * @Title:
     * @Description: 分页查询合同车辆保险信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContInsurance>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public PageInfoExtend<ContInsurance> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同车辆保险信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改合同车辆保险信息
     * @param contInsurance,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeyData(ContInsurance contInsurance,boolean exclusive) {
        return super.updateByPrimaryKey(contInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改合同车辆保险信息,并进行排他
     * @param contInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContInsurance> contInsurances,boolean exclusive){
        return super.updateListByPrimaryKey(contInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改合同车辆保险信息,并进行排他
     * @param contInsurance
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContInsurance contInsurance,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同车辆保险信息,并进行排他
     * @param contInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContInsurance> contInsurances,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同车辆保险信息,并进行排他
     * @param contInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByExampleData(ContInsurance contInsurance, Example example,boolean exclusive) {
        return super.updateByExample(contInsurance,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改合同车辆保险信息,并进行排他
     * @param contInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:25:35
     */
    @Override
    public int updateByExampleSelectiveData(ContInsurance contInsurance, Example example,boolean exclusive){
        return super.updateByExampleSelective(contInsurance,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据状态查询车辆保险信息
     * @param
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 18:48:00
     */
    @Override
    public List<ContInsuranceVo> selectContInsuranceByStatus(ContInsuranceVo contInsurance) {
        return baseDao.selectContInsuranceByStatus(contInsurance);
    }

}
