package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.prebiz.dao.ContractDao;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BrandStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BusinessStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RegionStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsListVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContractRepositoryImpl
 * @Description: 合同信息Repository 实现层
 * @date 2018-06-11
 */
@Repository
public class ContractRepositoryImpl extends AbstractBaseRepository<ContractDao, Contract> implements ContractRepository {

    /**
     * @Title:
     * @Description: 新增合同信息
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int insertData(Contract contract) {
        return super.insert(contract);
    }

    /**
     * @Title:
     * @Description: 批量保存合同信息
     * @param contracts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int insertDataList(List<Contract> contracts){
        return super.insertListByJdbcTemplate(contracts);
    }

    /**
     * @Title:
     * @Description: 修改合同信息
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeyData(Contract contract) {
        return super.updateByPrimaryKey(contract);
    }

    /**
     * @Title:
     * @Description: 批量修改合同信息
     * @param contracts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Contract> contracts){
        return super.updateListByPrimaryKey(contracts);
    }

    /**
     * @Title:
     * @Description: 动态修改合同信息
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Contract contract) {
        return super.updateByPrimaryKeySelective(contract);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同信息
     * @param contracts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<Contract> contracts) {
        return super.updateListByPrimaryKeySelective(contracts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同信息
     * @param contract
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByExampleData(Contract contract, Example example) {
        return super.updateByExample(contract,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改合同信息
     * @param contract
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByExampleSelectiveData(Contract contract, Example example){
        return super.updateByExampleSelective(contract,example);
    }

    /**
     * @Title:
     * @Description: 根据contractId删除合同信息
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int deleteData(Contract contract) {
        return super.delete(contract);
    }

    /**
     * @Title:
     * @Description: 根据contractId集合批量删除合同信息
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int deleteDataList(List contractIds,Contract contract){
        return super.deleteByIds(contractIds,contract);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除合同信息
     * @param example
     * @param contract
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int deleteExampleData(Example example,Contract contract){
        return super.deleteByExample(example,contract);
    }

    /**
     * @Title:
     * @Description: 查询全部合同信息
     * @return List<Contract>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public List<Contract> selectAll() {
        return super.selectAll();
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个合同信息
     * @param example
     * @return Contract
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public Contract selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过条件批量查询合同信息
     * @param example
     * @return List<Contract>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public List<Contract> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过contractId查询合同信息
     * @param contractId
     * @return Contract
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public Contract selectByPrimaryKey(Object contractId) {
        return super.selectByPrimaryKey(contractId);
    }

    /**
     * @Title:
     * @Description: 分页查询合同信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<Contract>
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public PageInfoExtend<Contract> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改合同信息
     * @param contract,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeyData(Contract contract,boolean exclusive) {
        return super.updateByPrimaryKey(contract,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改合同信息,并进行排他
     * @param contracts
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Contract> contracts,boolean exclusive){
        return super.updateListByPrimaryKey(contracts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改合同信息,并进行排他
     * @param contract
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Contract contract,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contract,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同信息,并进行排他
     * @param contracts
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<Contract> contracts,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contracts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同信息,并进行排他
     * @param contract
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByExampleData(Contract contract, Example example,boolean exclusive) {
        return super.updateByExample(contract,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改合同信息,并进行排他
     * @param contract
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-11 20:12:27
     */
    @Override
    public int updateByExampleSelectiveData(Contract contract, Example example,boolean exclusive){
        return super.updateByExampleSelective(contract,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 通过contNo查询合同信息
     * @param contNo
     * @return Contract
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @Override
    public ContCreateVo selectContCreateDetailByContNo(String contNo) {
        return baseDao.selectContCreateDetailByContNo(contNo);
    }
    /**
     * @Title:
     * @Description: 通过contNo查询合同信息
     * @param contNo
     * @return Contract
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @Override
    public ContractVo selectContractVoByContractNo(String contNo) {
        return baseDao.selectContractVoByContractNo(contNo);
    }

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请合同相关的财务核算代码
     * @param:  contractVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    public ContractVo selectContractVoFinassCodes(ContractVo contractVo){
        return baseDao.selectContractVoFinassCodes(contractVo);
    }

    /**
     * @Description: 自动程序更新合同结清状态
     * @param: uncleared 未结清状态
     * @param: contractEffect 合同生效清状态
     * @param: withdrawingSuccess 扣款成功状态
     * @param: automaticClearing 自动结清状态
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/13 17:27
     */
    @Override
    public int updateAutomaticClearing(String uncleared,String contractEffect,String withdrawingSuccess,String automaticClearing) {
        return baseDao.updateAutomaticClearing(uncleared, contractEffect, withdrawingSuccess, automaticClearing);
    }

    /**
     * @Title:
     * @Description:   查询当月提报数据统计报表明细
     * @param reportStatisticsListVo
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018/09/30 09:57:48
     */
    public List<ReportStatisticsListVo> selectReportStatisticsListVos(ReportStatisticsListVo reportStatisticsListVo){
        return baseDao.selectReportStatisticsListVo(reportStatisticsListVo);
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param regionStatisticsVo
     * @return
     * @throws
     * @date 2018-10-08 16:38:16
     */
    public List<RegionStatisticsVo> selectRegionStatisticsListVos(RegionStatisticsVo regionStatisticsVo){
        return baseDao.selectRegionStatisticsListVo(regionStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务品牌统计报表
     * @param brandStatisticsVo
     * @return
     * @throws
     * @date 2018-10-09 15:38:16
     */
    public List<BrandStatisticsVo> selectBrandStatisticsListVos(BrandStatisticsVo brandStatisticsVo){
        return baseDao.selectBrandStatisticsListVo(brandStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-10-10 16:38:16
     */
    public List<BusinessStatisticsVo> selectBusinessStatisticsListVos(BusinessStatisticsVo businessStatisticsVo){
        return baseDao.selectBusinessStatisticsVo(businessStatisticsVo);
    }

    /**
     * @Description: 首页工作台查询待请款合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    public Long selectRequestCount(DeskSearchVo deskSearchVo){
        return baseDao.selectRequestCount(deskSearchVo);
    }

    /**
     * @Description: 首页工作台查询待放款合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    public Long selectLoanCount(DeskSearchVo deskSearchVo){
        return baseDao.selectLoanCount(deskSearchVo);
    }

    /**
     * @Description: 首页工作台查询待归档合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    public Long selectOriginCount(DeskSearchVo deskSearchVo){
        return baseDao.selectOriginCount(deskSearchVo);
    }

}
