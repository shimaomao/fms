package cn.com.leadu.fms.postbiz.service;


import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueService
 * @Description: 逾期率统计业务层
 */
public interface MonthlyOverdueService {

    /**
     * @Title:
     * @Description: 每月定位统计逾期数据
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    void analyseMonthlyOverdue();

    /**
     * @Title:
     * @Description: 分页查询逾期统计信息
     * @param monthlyOverduesVo
     * @return PageInfoExtend<monthlyOverduesVo>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    PageInfoExtend<MonthlyOverduesVo> findMonthlyOverduesVosByPage(MonthlyOverduesVo monthlyOverduesVo);

    /**
     * @Title:
     * @Description:  模板出excel
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    void excelExport(HttpServletResponse httpServletResponse , MonthlyOverduesVo monthlyOverduesVo);
}
