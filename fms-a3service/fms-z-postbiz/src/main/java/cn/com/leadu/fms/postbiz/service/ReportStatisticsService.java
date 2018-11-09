package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.*;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by admin on 2018/9/27.
 */
public interface ReportStatisticsService {
    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @param reportStatisticsVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    PageInfoExtend<ReportStatisticsVo> findReportStatisticsVoByPage(ReportStatisticsVo reportStatisticsVo);

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    PageInfoExtend<BusinessStatisticsVo> findBusinessStatisticsVoByPage(BusinessStatisticsVo businessStatisticsVo);

    /**
     * @Title:
     * @Description: 当月提报数据统计导出
     * @return
     * @throws
     * @date 2018/9/29 14:59
     */
    void reportstatisticsExport(HttpServletResponse httpServletResponse,String groupDistrict,String contractSerachDate);

    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表明细
     * @param reportStatisticsListVo
     * @return
     * @throws
     * @date 2018-9-30 11:38:16
     */
    List<ReportStatisticsListVo> findReportStatisticsListVoByPage(ReportStatisticsListVo reportStatisticsListVo);

    /**
     * @Title:
     * @Description: 融资租赁业务统计报表导出
     * @return
     * @throws
     * @date 2018/10/8 13:53
     */
    void reportBusinessStatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries);

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param regionStatisticsVo
     * @return
     * @throws
     * @date 2018-10-08 16:38:16
     */
    List<RegionStatisticsVo> selectRegionStatisticsListVo(RegionStatisticsVo regionStatisticsVo);

    /**
     * @Title:
     * @Description: 查询融资租赁业务品牌统计报表
     * @param brandStatisticsVo
     * @return
     * @throws
     * @date 2018-10-09 15:38:16
     */
    List<BrandStatisticsVo> selectBrandStatisticsListVo(BrandStatisticsVo brandStatisticsVo);

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-10-10 16:38:16
     */
    List<BusinessStatisticsVo> selectBusinessStatisticsListVo(BusinessStatisticsVo businessStatisticsVo);

    /**
     * @Title:
     * @Description: 融资租赁审批数据统计报表导出
     * @return
     * @throws
     * @date 2018/10/13 11:53
     */
    void reportApprovalstatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectAdoptApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交拒绝台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectRefuseApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectCancelApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过，拒绝和取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    List<ApprovalStatisticsVo> selectAllApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过率
     * @param rateOfPassingStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    List<RateOfPassingStatisticsVo> selectRateOfPassingStatisticsVo(RateOfPassingStatisticsVo rateOfPassingStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    List<IndustryStatisticsVo> selectAdoptIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交拒绝台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    List<IndustryStatisticsVo> selectRefuseIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    List<IndustryStatisticsVo> selectCancelIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过拒绝和取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    List<IndustryStatisticsVo> selectAllIndustryStatisticsVoStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过率
     * @param rateOfPassingIndustryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 18:38:16
     */
    List<RateOfPassingIndustryStatisticsVo> selectrateOfPassingStatisticsVoStatisticsVo(RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo);
}
