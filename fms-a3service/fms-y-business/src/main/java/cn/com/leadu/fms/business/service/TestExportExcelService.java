package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.TestData;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;

import java.io.OutputStream;

/**
 * @author qiaomengnan
 * @ClassName: CommonExcelService
 * @Description: excel共通处理service
 * @date 2018/5/9
 */
public interface TestExportExcelService {

    /**
     * 按照指定模板导出测试
     * @param sysTplType 模板实体类
     * @param testData 填充模板的数据
     * @param out
     * @throws Exception
     */
    void export(SysTplType sysTplType, TestData testData, OutputStream out) throws Exception;

}
