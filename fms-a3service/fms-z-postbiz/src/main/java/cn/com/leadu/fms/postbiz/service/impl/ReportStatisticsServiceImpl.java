package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.BusinessStatisticsExportService;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.*;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.postbiz.service.ReportStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by admin on 2018/9/27.
 */
@Service
@Slf4j
public class ReportStatisticsServiceImpl implements ReportStatisticsService {

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;
    @Autowired
    private ReportStatisticsService reportStatisticsService;
    @Autowired
    private BusinessStatisticsExportService businessStatisticsExportService;
    @Autowired
    private ApplyRepository applyRepository;
    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @param reportStatisticsVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    public PageInfoExtend<ReportStatisticsVo> findReportStatisticsVoByPage(ReportStatisticsVo reportStatisticsVo){
        //用户组区域
        if (StringUtils.isExits(reportStatisticsVo.getGroupDistrict())) {
            reportStatisticsVo.setGroupDistrict((SqlUtil.likePattern(reportStatisticsVo.getGroupDistrict())));
        } else{
            reportStatisticsVo.setGroupDistrict(null);
        }
        //合同生效月份
        if (!StringUtils.isExits(reportStatisticsVo.getContractSerachDate())) {
            reportStatisticsVo.setContractSerachDate(null);
        }
        PageInfoExtend<ReportStatisticsVo> pageInfo = contractRepository.selectListVoByPage("selectReportStatisticsVo",reportStatisticsVo,reportStatisticsVo.getPageQuery());
        if(pageInfo!=null && pageInfo.getData().size()>0){//计算本月合计数据
            for (int i = 0; i < pageInfo.getData().size(); i++) {
                ReportStatisticsVo reportStatisticsvo = pageInfo.getData().get(i);
                BigDecimal distributorTotal = new BigDecimal(0);//计算经销商合计车辆
                BigDecimal totalRetailCustomers = new BigDecimal(0);//计算零售客户合计
                BigDecimal monthSum = new BigDecimal(0);//计算本月合计
                distributorTotal = reportStatisticsvo.getDrivingVehicle().add(reportStatisticsvo.getStepCar()).add(reportStatisticsvo.getEmployeesCar());
                totalRetailCustomers = reportStatisticsvo.getCustomerEnterprise().add(reportStatisticsvo.getCustomerPerson()).add(reportStatisticsvo.getCustomerLeaseback()).add(reportStatisticsvo.getCustomersHandCar()).add(reportStatisticsvo.getCustomerMotorcycle());
                monthSum = distributorTotal.add(totalRetailCustomers);
                reportStatisticsvo.setDistributorTotal(distributorTotal);
                reportStatisticsvo.setTotalRetailCustomers(totalRetailCustomers);
                reportStatisticsvo.setMonthSum(monthSum);
            }
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 查询当月提报数据统计报表明细
     * @param reportStatisticsListVo
     * @return
     * @throws
     * @date 2018-9-30 11:38:16
     */
    public List<ReportStatisticsListVo> findReportStatisticsListVoByPage(ReportStatisticsListVo reportStatisticsListVo){
        //用户组区域
        if (StringUtils.isExits(reportStatisticsListVo.getGroupDistrict())) {
            reportStatisticsListVo.setGroupDistrict((SqlUtil.likePattern(reportStatisticsListVo.getGroupDistrict())));
        } else{
            reportStatisticsListVo.setGroupDistrict(null);
        }
        //合同生效月份
        if (!StringUtils.isExits(reportStatisticsListVo.getContractSerachDate())) {
            reportStatisticsListVo.setContractSerachDate(null);
        }
        List<ReportStatisticsListVo> ReportStatisticsList = contractRepository.selectReportStatisticsListVos(reportStatisticsListVo);
        return ReportStatisticsList;
    }

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    public PageInfoExtend<BusinessStatisticsVo> findBusinessStatisticsVoByPage(BusinessStatisticsVo businessStatisticsVo){
        businessStatisticsVo.setPageFlag(PageFlags.NOT_PAGE.getFlag());//不分页
        //合同生效月份
        if (!StringUtils.isExits(businessStatisticsVo.getYearInquiries())) {
            businessStatisticsVo.setYearInquiries(null);
        }
        PageInfoExtend<BusinessStatisticsVo> pageInfo = contractRepository.selectListVoByPage("selectBusinessStatisticsVo",businessStatisticsVo,businessStatisticsVo.getPageQuery());
        if(pageInfo!=null && pageInfo.getData().size()>0){//计算月度累计融资额
            BigDecimal accumulatedTotal = new BigDecimal(0);//计算月度累计融资额
            BigDecimal cumulativeNumber = new BigDecimal(0);//计算累计台数
            for (int i = 0; i < pageInfo.getData().size(); i++) {
                BusinessStatisticsVo businessStatisticsvo = pageInfo.getData().get(i);
                accumulatedTotal = accumulatedTotal.add(businessStatisticsvo.getFinTotal());
                cumulativeNumber = cumulativeNumber.add(businessStatisticsvo.getMonthlyNumber());
                businessStatisticsvo.setAccumulatedTotal(accumulatedTotal);
                businessStatisticsvo.setCumulativeNumber(cumulativeNumber);
            }
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 当月提报数据统计导出
     * @return
     * @throws
     * @date 2018/9/29 14:59
     */
    public void reportstatisticsExport(HttpServletResponse httpServletResponse,String groupDistrict,String contractSerachDate) {
        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.REPORTSTATISTICS.getType())); //当月提报数据统计报表key
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,统计报表导出失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,统计报表导出失败");
        }
        //获取当月提报数据统计报表
        ReportStatisticsVo reportstatisticsvo = new ReportStatisticsVo();
        reportstatisticsvo.setGroupDistrict(groupDistrict);//区域
        reportstatisticsvo.setContractSerachDate(contractSerachDate);//合同生效月份
        PageInfoExtend<ReportStatisticsVo> pageInfo = this.findReportStatisticsVoByPage(reportstatisticsvo);
        //获取当月提报数据统计报表明细
        ReportStatisticsListVo reportStatisticsListVo = new ReportStatisticsListVo();
        reportStatisticsListVo.setGroupDistrict(groupDistrict);//区域
        reportStatisticsListVo.setContractSerachDate(contractSerachDate);//合同生效月份
        reportStatisticsListVo.setFinItem(FinItemEnums.CARPRICE.getCode());//用于取成交价
        List<ReportStatisticsListVo> ReportStatisticsList = this.findReportStatisticsListVoByPage(reportStatisticsListVo);
        //生成excel
        try{
            List<ReportStatisticsVo> datalist = pageInfo.getData();
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            businessStatisticsExportService.singlemonthreport(sysTplType,datalist,ReportStatisticsList,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }

    /**
     * @Title:
     * @Description: 融资租赁业务统计报表导出
     * @return
     * @throws
     * @date 2018/10/8 13:53
     */
    public void reportBusinessStatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries) {
        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.BUSINESSS_TATISTICS.getType()));//融资租赁业务统计报表key
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,统计报表导出失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,统计报表导出失败");
        }
        //获取融资租赁业务统计报表
        BusinessStatisticsVo businessStatisticsVo = new BusinessStatisticsVo();
        businessStatisticsVo.setYearInquiries(yearInquiries);//合同生效年份
        List<BusinessStatisticsVo> datalist = this.selectBusinessStatisticsListVo(businessStatisticsVo);
        //获取各个区域业务量分布
        RegionStatisticsVo regionStatisticsVo = new RegionStatisticsVo();
        regionStatisticsVo.setYearInquiries(yearInquiries);//合同生效年份
        List<RegionStatisticsVo> regionStatisticslist = this.selectRegionStatisticsListVo(regionStatisticsVo);
        //获取各个品牌台数
        BrandStatisticsVo brandStatisticsVo = new BrandStatisticsVo();
        brandStatisticsVo.setYearInquiries(yearInquiries);//合同生效年份
        List<BrandStatisticsVo> brandStatisticslist = this.selectBrandStatisticsListVo(brandStatisticsVo);
        //生成excel
        try{
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            businessStatisticsExportService.reportbustatisticsexport(sysTplType,datalist,regionStatisticslist,brandStatisticslist,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param regionStatisticsVo
     * @return
     * @throws
     * @date 2018-10-08 16:38:16
     */
    public List<RegionStatisticsVo> selectRegionStatisticsListVo(RegionStatisticsVo regionStatisticsVo){
        //合同生效年份
        if (!StringUtils.isExits(regionStatisticsVo.getYearInquiries())) {
            regionStatisticsVo.setYearInquiries(null);
        }
        List<RegionStatisticsVo> RegionStatisticsVoList = contractRepository.selectRegionStatisticsListVos(regionStatisticsVo);
        return RegionStatisticsVoList;
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务品牌统计报表
     * @param brandStatisticsVo
     * @return
     * @throws
     * @date 2018-10-09 15:38:16
     */
    public List<BrandStatisticsVo> selectBrandStatisticsListVo(BrandStatisticsVo brandStatisticsVo){
        //合同生效年份
        if (!StringUtils.isExits(brandStatisticsVo.getYearInquiries())) {
            brandStatisticsVo.setYearInquiries(null);
        }
        List<BrandStatisticsVo> BrandStatisticsVoList = contractRepository.selectBrandStatisticsListVos(brandStatisticsVo);
        return BrandStatisticsVoList;
    }

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-10-10 16:38:16
     */
    public List<BusinessStatisticsVo> selectBusinessStatisticsListVo(BusinessStatisticsVo businessStatisticsVo){
        //合同生效年份
        if (!StringUtils.isExits(businessStatisticsVo.getYearInquiries())) {
            businessStatisticsVo.setYearInquiries(null);
        }
        List<BusinessStatisticsVo> BusinessStatisticsVoVoList = contractRepository.selectBusinessStatisticsListVos(businessStatisticsVo);
        if(BusinessStatisticsVoVoList!=null && BusinessStatisticsVoVoList.size()>0){
            BigDecimal accumulatedTotal = new BigDecimal(0);//计算月度累计融资额
            BigDecimal cumulativeNumber = new BigDecimal(0);//计算累计台数
            for (int i = 0; i < BusinessStatisticsVoVoList.size(); i++) {
                BusinessStatisticsVo businessStatisticsvo = BusinessStatisticsVoVoList.get(i);
                accumulatedTotal = accumulatedTotal.add(businessStatisticsvo.getFinTotal());
                cumulativeNumber = cumulativeNumber.add(businessStatisticsvo.getMonthlyNumber());
                businessStatisticsvo.setAccumulatedTotal(accumulatedTotal);
                businessStatisticsvo.setCumulativeNumber(cumulativeNumber);
            }
        }
        return BusinessStatisticsVoVoList;
    }

    /**
     * @Title:
     * @Description: 融资租赁审批数据统计报表导出
     * @return
     * @throws
     * @date 2018/10/13 11:53
     */
    public void reportApprovalstatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries) {
        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(TplTypeKeyEnums.Approval_STATISTICS.getType()));//融资租赁审批数据统计报表key
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,统计报表导出失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,统计报表导出失败");
        }
        //获取区域分组首次申请提交通过台数统计
        ApprovalStatisticsVo adoptApprovalStatisticsVo = new ApprovalStatisticsVo();
        adoptApprovalStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<ApprovalStatisticsVo> adoptdatalist = this.selectAdoptApprovalStatisticsVo(adoptApprovalStatisticsVo);
        //获取区域分组首次申请提交拒绝台数统计
        ApprovalStatisticsVo refuseApprovalStatisticsVo = new ApprovalStatisticsVo();
        refuseApprovalStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<ApprovalStatisticsVo> refusedatalist = this.selectRefuseApprovalStatisticsVo(refuseApprovalStatisticsVo);
        //获取区域分组首次申请提交取消台数统计
        ApprovalStatisticsVo cancelApprovalStatisticsVo = new ApprovalStatisticsVo();
        cancelApprovalStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<ApprovalStatisticsVo> canceldatalist = this.selectCancelApprovalStatisticsVo(cancelApprovalStatisticsVo);
        //获取区域分组首次申请提交通过，拒绝和取消台数统计
        ApprovalStatisticsVo allApprovalStatisticsVo = new ApprovalStatisticsVo();
        allApprovalStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<ApprovalStatisticsVo> alldatalist = this.selectAllApprovalStatisticsVo(allApprovalStatisticsVo);
        //获取区域分组首次申请提交通过率
        RateOfPassingStatisticsVo rateOfPassingStatisticsVo = new RateOfPassingStatisticsVo();
        rateOfPassingStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<RateOfPassingStatisticsVo> rateOfPassinglist = this.selectRateOfPassingStatisticsVo(rateOfPassingStatisticsVo);
        //获取单位行业类别分组首次申请提交通过台数统计
        IndustryStatisticsVo adoptIndustryStatisticsVo = new IndustryStatisticsVo();
        adoptIndustryStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<IndustryStatisticsVo> adoptIndustrylist = this.selectAdoptIndustryStatisticsVoStatisticsVo(adoptIndustryStatisticsVo);
        //获取单位行业类别分组首次申请提交拒绝台数统计
        IndustryStatisticsVo refuseIndustryStatisticsVo = new IndustryStatisticsVo();
        refuseIndustryStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<IndustryStatisticsVo> refuseIndustrylist = this.selectRefuseIndustryStatisticsVoStatisticsVo(refuseIndustryStatisticsVo);
        //获取单位行业类别分组首次申请提交取消台数统计
        IndustryStatisticsVo cancelIndustryStatisticsVo = new IndustryStatisticsVo();
        cancelIndustryStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<IndustryStatisticsVo> cancelIndustrylist = this.selectCancelIndustryStatisticsVoStatisticsVo(cancelIndustryStatisticsVo);
        //获取单位行业类别分组首次申请提交通过拒绝和取消台数统计
        IndustryStatisticsVo allIndustryStatisticsVo = new IndustryStatisticsVo();
        allIndustryStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<IndustryStatisticsVo> allIndustrylist = this.selectAllIndustryStatisticsVoStatisticsVo(allIndustryStatisticsVo);
        //获取单位行业类别分组首次申请提交通过率
        RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo = new RateOfPassingIndustryStatisticsVo();
        rateOfPassingIndustryStatisticsVo.setYearInquiries(yearInquiries);//首次申请年份
        List<RateOfPassingIndustryStatisticsVo> rateOfPassingIndustrylist = this.selectrateOfPassingStatisticsVoStatisticsVo(rateOfPassingIndustryStatisticsVo);
        //生成excel
        try{
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            businessStatisticsExportService.reportApprovalstatisticsexport(sysTplType,yearInquiries,adoptdatalist,refusedatalist,canceldatalist,alldatalist,rateOfPassinglist,adoptIndustrylist,refuseIndustrylist,cancelIndustrylist,allIndustrylist,rateOfPassingIndustrylist,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
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
        //首次申请年份
        if (!StringUtils.isExits(approvalStatisticsVo.getYearInquiries())) {
            approvalStatisticsVo.setYearInquiries(null);
        }
        List<ApprovalStatisticsVo> adoptdatalist = applyRepository.selectAdoptApprovalStatisticsVo(approvalStatisticsVo);
        return adoptdatalist;
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
        //首次申请年份
        if (!StringUtils.isExits(approvalStatisticsVo.getYearInquiries())) {
            approvalStatisticsVo.setYearInquiries(null);
        }
        List<ApprovalStatisticsVo> refusedatalist = applyRepository.selectRefuseApprovalStatisticsVo(approvalStatisticsVo);
        return refusedatalist;
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
        //首次申请年份
        if (!StringUtils.isExits(approvalStatisticsVo.getYearInquiries())) {
            approvalStatisticsVo.setYearInquiries(null);
        }
        List<ApprovalStatisticsVo> canceldatalist = applyRepository.selectCancelApprovalStatisticsVo(approvalStatisticsVo);
        return canceldatalist;
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过，拒绝和取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    public List<ApprovalStatisticsVo> selectAllApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(approvalStatisticsVo.getYearInquiries())) {
            approvalStatisticsVo.setYearInquiries(null);
        }
        List<ApprovalStatisticsVo> canceldatalist = applyRepository.selectAllApprovalStatisticsVo(approvalStatisticsVo);
        return canceldatalist;
    }

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过率
     * @param rateOfPassingStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    public List<RateOfPassingStatisticsVo> selectRateOfPassingStatisticsVo(RateOfPassingStatisticsVo rateOfPassingStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(rateOfPassingStatisticsVo.getYearInquiries())) {
            rateOfPassingStatisticsVo.setYearInquiries(null);
        }
        List<RateOfPassingStatisticsVo> rateOfPassinglist = applyRepository.selectAllApprovalStatisticsVo(rateOfPassingStatisticsVo);
        return rateOfPassinglist;
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectAdoptIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(industryStatisticsVo.getYearInquiries())) {
            industryStatisticsVo.setYearInquiries(null);
        }
        List<IndustryStatisticsVo> adoptIndustrylist = applyRepository.selectAdoptIndustryStatisticsVo(industryStatisticsVo);
        return adoptIndustrylist;
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交拒绝台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectRefuseIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(industryStatisticsVo.getYearInquiries())) {
            industryStatisticsVo.setYearInquiries(null);
        }
        List<IndustryStatisticsVo> refuseIndustrylist = applyRepository.selectRefuseIndustryStatisticsVo(industryStatisticsVo);
        return refuseIndustrylist;
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectCancelIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(industryStatisticsVo.getYearInquiries())) {
            industryStatisticsVo.setYearInquiries(null);
        }
        List<IndustryStatisticsVo> cancelIndustrylist = applyRepository.selectCancelIndustryStatisticsVo(industryStatisticsVo);
        return cancelIndustrylist;
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<IndustryStatisticsVo> selectAllIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(industryStatisticsVo.getYearInquiries())) {
            industryStatisticsVo.setYearInquiries(null);
        }
        List<IndustryStatisticsVo> allIndustrylist = applyRepository.selectAllIndustryStatisticsVo(industryStatisticsVo);
        return allIndustrylist;
    }

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过率
     * @param rateOfPassingIndustryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    public List<RateOfPassingIndustryStatisticsVo> selectrateOfPassingStatisticsVoStatisticsVo(RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo){
        //首次申请年份
        if (!StringUtils.isExits(rateOfPassingIndustryStatisticsVo.getYearInquiries())) {
            rateOfPassingIndustryStatisticsVo.setYearInquiries(null);
        }
        List<RateOfPassingIndustryStatisticsVo> rateOfPassingIndustrylist = applyRepository.selectrateOfPassingStatisticsVo(rateOfPassingIndustryStatisticsVo);
        return rateOfPassingIndustrylist;
    }
}
