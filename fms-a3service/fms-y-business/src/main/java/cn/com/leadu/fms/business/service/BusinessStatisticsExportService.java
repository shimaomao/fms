package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.*;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by admin on 2018/10/10.
 */
public interface BusinessStatisticsExportService {

    /**
     * 当月提报数据统计导出
     * @param sysTplType 模板实体类
     * @param datalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    void singlemonthreport(SysTplType sysTplType, List<ReportStatisticsVo> datalist, List<ReportStatisticsListVo> ReportStatisticsList, OutputStream out) throws Exception;

    /**
     * 融资租赁业务统计报表导出
     * @param sysTplType 模板实体类
     * @param datalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    void reportbustatisticsexport(SysTplType sysTplType, List<BusinessStatisticsVo> datalist, List<RegionStatisticsVo> regionStatisticslist, List<BrandStatisticsVo> brandStatisticslist, OutputStream out) throws Exception;

    /**
     * 融资租赁审批数据统计报表导出
     * @param sysTplType 模板实体类
     * @param adoptdatalist 填充模板的数据
     * @param out
     * @throws Exception
     */
    void reportApprovalstatisticsexport(SysTplType sysTplType, String yearInquiries, List<ApprovalStatisticsVo> adoptdatalist, List<ApprovalStatisticsVo> refusedatalist, List<ApprovalStatisticsVo> canceldatalist, List<ApprovalStatisticsVo> alldatalist, List<RateOfPassingStatisticsVo> rateOfPassinglist, List<IndustryStatisticsVo> adoptIndustrylist, List<IndustryStatisticsVo> refuseIndustrylist, List<IndustryStatisticsVo> cancelIndustrylist, List<IndustryStatisticsVo> allIndustrylist, List<RateOfPassingIndustryStatisticsVo> rateOfPassingIndustrylist, OutputStream out) throws Exception;
}
