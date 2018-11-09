package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import cn.com.leadu.fms.postbiz.service.MonthlyOverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueAnalyseController
 * @Description: 逾期率统计接口
 * @date 2018-09-25
 */
@RestController
@RequestMapping("monthly_overdue")
public class MonthlyOverdueController {

    @Autowired
    private MonthlyOverdueService monthlyOverdueService;

    /**
     * @Title:
     * @Description: 每月定位统计逾期数据
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    @RequestMapping(value = "analyseMonthlyOverdue" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> analyseMonthlyOverdue(){
        monthlyOverdueService.analyseMonthlyOverdue();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期统计信息
     * @param monthlyOverduesVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "findMonthlyOverduesVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyOverduesVosByPage(MonthlyOverduesVo monthlyOverduesVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(monthlyOverdueService.findMonthlyOverduesVosByPage(monthlyOverduesVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  模板出excel
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    @RequestMapping(value = "excelExport" , method = RequestMethod.GET)
    public void excelExport(HttpServletResponse httpServletResponse, MonthlyOverduesVo monthlyOverduesVo){
        monthlyOverdueService.excelExport(httpServletResponse,monthlyOverduesVo);
    }
}
