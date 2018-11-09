package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;

import java.io.OutputStream;

/**
 * @author qinmuqiao
 * @ClassName: MonthlyRentExcelExportService
 * @Description: 导出月度到账率excel
 * @date 2018-03-26
 */
public interface MonthlyRentExcelExportService {

    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param monthlyRent 填充模板的数据
     * @param out
     * @throws Exception
     */
    void monthlyRectExport(SysTplType sysTplType, MonthlyRent monthlyRent, OutputStream out) throws Exception;
}
