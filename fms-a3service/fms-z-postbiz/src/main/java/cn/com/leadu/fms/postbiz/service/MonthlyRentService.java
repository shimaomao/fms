package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qinmuqiao
 * @ClassName: MonthlyRentService
 * @Description: 月度租金到账率业务层
 */
public interface MonthlyRentService {


    /**
     * @Title:
     * @Description: 分页查询月度到账率数据
     * @param monthlyRentVo
     * @return PageInfoExtend<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    PageInfoExtend<MonthlyRent> findMonthlyRentsByPage(MonthlyRentVo monthlyRentVo);


    /**
     * @Title:
     * @Description:  模板出excel
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    void excelExport(HttpServletResponse httpServletResponse ,String monthlyRentId);
}
