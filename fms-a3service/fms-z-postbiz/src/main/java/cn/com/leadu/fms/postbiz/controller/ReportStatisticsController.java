package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BusinessStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsVo;
import cn.com.leadu.fms.postbiz.service.ReportStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2018/9/27.
 */
@RestController
@RequestMapping("report_statistics")
public class ReportStatisticsController {

    /**
     * @Fields  : 指标管理表service
     */
    @Autowired
    private ReportStatisticsService reportStatisticsService;
    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @param reportStatisticsVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    @RequestMapping(value = "findReportStatisticsVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findReportStatisticsVoByPage(ReportStatisticsVo reportStatisticsVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(reportStatisticsService.findReportStatisticsVoByPage(reportStatisticsVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    @RequestMapping(value = "findBusinessStatisticsVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBusinessStatisticsVoByPage(BusinessStatisticsVo businessStatisticsVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(reportStatisticsService.findBusinessStatisticsVoByPage(businessStatisticsVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 当月提报数据统计导出
     * @return
     * @throws
     * @date 2018/9/29 14:59
     */
    @RequestMapping(value = "reportstatisticsExport" , method = RequestMethod.GET)
    public void reportstatisticsExport(HttpServletResponse httpServletResponse,String groupDistrict,String contractSerachDate){
        reportStatisticsService.reportstatisticsExport(httpServletResponse,groupDistrict,contractSerachDate);
    }

    /**
     * @Title:
     * @Description: 融资租赁业务统计报表导出
     * @return
     * @throws
     * @date 2018/10/8 13:53
     */
    @RequestMapping(value = "reportBusinessStatisticsExport" , method = RequestMethod.GET)
    public void reportBusinessStatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries){
        reportStatisticsService.reportBusinessStatisticsExport(httpServletResponse,yearInquiries);
    }

    /**
     * @Title:
     * @Description: 融资租赁审批数据统计报表导出
     * @return
     * @throws
     * @date 2018/10/13 11:53
     */
    @RequestMapping(value = "reportApprovaltatisticsExport" , method = RequestMethod.GET)
    public void reportApprovaltatisticsExport(HttpServletResponse httpServletResponse,String yearInquiries){
        reportStatisticsService.reportApprovalstatisticsExport(httpServletResponse,yearInquiries);
    }
}
