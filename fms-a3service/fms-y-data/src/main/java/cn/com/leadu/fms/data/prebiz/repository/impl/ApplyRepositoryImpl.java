package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.prebiz.dao.ApplyDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyRepository;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ApprovalStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.IndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingIndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingStatisticsVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyRepositoryImpl
 * @Description: 申请信息Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class ApplyRepositoryImpl extends AbstractBaseRepository<ApplyDao, Apply> implements ApplyRepository {

    /**
     * @Title:
     * @Description: 新增申请信息
     * @param apply
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int insertData(Apply apply) {
        return super.insert(apply);
    }

    /**
     * @Title:
     * @Description: 批量保存申请信息
     * @param applys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int insertDataList(List<Apply> applys){
        return super.insertListByJdbcTemplate(applys);
    }

    /**
     * @Title:
     * @Description: 修改申请信息
     * @param apply
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByPrimaryKeyData(Apply apply) {
        return super.updateByPrimaryKey(apply);
    }

    /**
     * @Title:
     * @Description: 批量修改申请信息
     * @param applys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Apply> applys){
        return super.insertListByJdbcTemplate(applys);
    }

    /**
     * @Title:
     * @Description: 动态修改申请信息
     * @param apply
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Apply apply) {
        return super.updateByPrimaryKeySelective(apply);
    }

    /**
     * @Title:
     * @Description: 批量动态修改申请信息
     * @param applys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    public int updateByPrimaryKeySelectiveDataList(List<Apply> applys) {
        return super.updateListByPrimaryKeySelective(applys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改申请信息
     * @param apply
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByExampleData(Apply apply, Example example) {
        return super.updateByExample(apply,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改申请信息
     * @param apply
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByExampleSelectiveData(Apply apply, Example example){
        return super.updateByExampleSelective(apply,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改申请信息
     * @param apply
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int updateByExampleSelectiveData(Apply apply, Example example,boolean exclusive){
        return super.updateByExampleSelective(apply,example,exclusive);
    }
    
    /**
     * @Title:
     * @Description: 根据applyId删除申请信息
     * @param apply
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public int deleteData(Apply apply) {
        return super.delete(apply);
    }

    /**
     * @Title:
     * @Description: 根据applyId集合批量删除申请信息
     * @param apply
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    public int deleteDataList(List applyIds,Apply apply){
        return super.deleteByIds(applyIds,apply);
    }

    /**
     * @Title:
     * @Description: 查询全部申请信息
     * @return List<Apply>
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public List<Apply> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个申请信息
     * @param example
     * @return Apply
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public Apply selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询申请信息
     * @param example
     * @return List<Apply>
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public List<Apply> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyId查询申请信息
     * @param applyId
     * @return Apply
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public Apply selectByPrimaryKey(Object applyId) {
        return super.selectByPrimaryKey(applyId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询申请信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<Apply>
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @Override
    public PageInfoExtend<Apply> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询申请信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<Apply>
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    public PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description:  根据订单提出账号(apply_user)获取申请信息
     * @param applyUser
     * @return Apply
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 10:14:22
     */
    public ApplyVo selectApplyVoByApplyUser(String applyUser){
        return baseDao.selectApplyVoByApplyUser(applyUser);
    }

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请订单相关的财务核算代码
     * @param:  applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    public ApplyVo selectApplyVoFinassCodesByApplyNo(ApplyVo applyVo){
        return baseDao.selectApplyVoFinassCodesByApplyNo(applyVo);
    }

    /**
     * @Title
     * @Description 根据客户证件号，获取客户最新订单的风控初审人员
     * @param certifNo 证件号码
     * @return String
     * @throws
     * @author wangxue
     * @date 2018/6/30 0030 15:52
     */
    @Override
    public String selectApproveUserByCertifNo(String certifNo) {
        return baseDao.selectApproveUserByCertifNo(certifNo);
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    public List<ApprovalStatisticsVo> selectAdoptApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo){
        return baseDao.selectAdoptApprovalStatisticsVo(approvalStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交拒绝台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    public List<ApprovalStatisticsVo> selectRefuseApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo){
        return baseDao.selectRefuseApprovalStatisticsVo(approvalStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    public List<ApprovalStatisticsVo> selectCancelApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo){
        return baseDao.selectCancelApprovalStatisticsVo(approvalStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    public List<ApprovalStatisticsVo> selectAllApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo){
        return baseDao.selectAllApprovalStatisticsVo(approvalStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过率
     * @param rateOfPassingStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    public List<RateOfPassingStatisticsVo> selectAllApprovalStatisticsVo(RateOfPassingStatisticsVo rateOfPassingStatisticsVo){
        return baseDao.selectRateOfPassingStatisticsVo(rateOfPassingStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectAdoptIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        return baseDao.selectAdoptIndustryStatisticsVo(industryStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交拒绝台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectRefuseIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        return baseDao.selectRefuseIndustryStatisticsVo(industryStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectCancelIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        return baseDao.selectCancelIndustryStatisticsVo(industryStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectAllIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        return baseDao.selectAllIndustryStatisticsVo(industryStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过率
     * @param rateOfPassingIndustryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<RateOfPassingIndustryStatisticsVo> selectrateOfPassingStatisticsVo(RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo){
        return baseDao.selectRateOfPassingIndustryStatisticsVo(rateOfPassingIndustryStatisticsVo);
    }

    /**
     * @Title:
     * @Description: 首页工作台查询本月融资额
     * @param deskSearchVo
     * @return
     * @throws
     */
    public BigDecimal selectFinTotal(DeskSearchVo deskSearchVo){
        return baseDao.selectFinTotal(deskSearchVo);
    }

    /**
     * @Title:
     * @Description: 首页工作台查询本月累计放款数
     * @param deskSearchVo
     * @return
     * @throws
     */
    public Long selectLoanCount(DeskSearchVo deskSearchVo){
        return baseDao.selectLoanCount(deskSearchVo);
    }

    /**
     * @Title:
     * @Description: 首页工作台查询当月申请订单数总量
     * @param deskSearchVo
     * @return
     * @throws
     */
    public List<Apply> selectApplyCount(DeskSearchVo deskSearchVo){
        return baseDao.selectApplyCount(deskSearchVo);
    }

    /**
     * @Title:
     * @Description: 首页工作台查询当月申请车辆数
     * @param deskSearchVo
     * @return
     * @throws
     */
    public Long selectVehicleCount(DeskSearchVo deskSearchVo){
        return baseDao.selectVehicleCount(deskSearchVo);
    }
}
