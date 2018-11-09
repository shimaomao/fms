package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;

import java.io.OutputStream;
import java.util.List;

public interface MonthlyOverdueExcelExportService {

    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param monthlyOverduesVo 填充模板的数据
     * @param out
     * @throws Exception
     */
    void monthlyOverdueExport(SysTplType sysTplType, List<MonthlyOverduesVo> vos, OutputStream out) throws Exception;
}
