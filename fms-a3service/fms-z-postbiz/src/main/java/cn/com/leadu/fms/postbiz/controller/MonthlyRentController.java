package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.postbiz.service.MonthlyRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 月度租金到账率接口
 */
@RestController
@RequestMapping("monthly_rent")
public class MonthlyRentController {

    /**
     * @Fields  : 月度租金到账率Service
     */
    @Autowired
    private MonthlyRentService monthlyRentService;

    /**
     * @Title:
     * @Description: 分页查询月度租金到账率
     * @param monthlyRentVo
     * @return PageInfoExtend<MonthlyRent>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "findMonthlyRentsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyRentsByPage(MonthlyRentVo monthlyRentVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(monthlyRentService.findMonthlyRentsByPage(monthlyRentVo)),
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
    public void excelExport(HttpServletResponse httpServletResponse,String monthlyRentId){
        monthlyRentService.excelExport(httpServletResponse,monthlyRentId);
    }
}
