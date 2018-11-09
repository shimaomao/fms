package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.MonthlyRentExcelExportService;
import cn.com.leadu.fms.common.constant.enums.postbiz.AnnualInspectionEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.MonthlyRentEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.MonthlyRentRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.DataList;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.TestData;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.postbiz.service.MonthlyRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: MonthlyRentService
 * @Description: 月度租金到账率业务实现层
 */
@Service
public class MonthlyRentServiceImpl implements MonthlyRentService {

    /**
     * @Fields  : 月度租金到账率repository
     */
    @Autowired
    private MonthlyRentRepository monthlyRentRepository;

    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    @Autowired
    private MonthlyRentExcelExportService monthlyRentExcelExportService;

    /**
     * @Title:
     * @Description: 分页查询年检提醒
     * @param monthlyRentVo
     * @return PageInfoExtend<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public PageInfoExtend<MonthlyRent> findMonthlyRentsByPage (MonthlyRentVo monthlyRentVo){

        Example example = SqlUtil.newExample(MonthlyRent.class);
        if (StringUtils.isNotTrimBlank(monthlyRentVo.getCensusMonth())) {
            example.createCriteria().andEqualTo("censusMonth",monthlyRentVo.getCensusMonth().replace("-",""));
        }else {
            SqlUtil.setOrderByColumnAsc(example,"census_month");
        }
        PageInfoExtend<MonthlyRent> pageInfo = monthlyRentRepository.selectListByExamplePage(example,monthlyRentVo.getPageQuery());

        StringBuilder stringBuilder ;
        for (MonthlyRent rent: pageInfo.getData()) {
            stringBuilder = new StringBuilder(rent.getCensusMonth());
            rent.setCensusMonth(stringBuilder.insert(4,"-").toString());

        }
        return pageInfo;
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
    public void excelExport(HttpServletResponse httpServletResponse , String monthlyRentId){
        //获取某月的数据
        MonthlyRent monthlyRent = monthlyRentRepository.selectByPrimaryKey(monthlyRentId);

        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey(MonthlyRentEnums.EXCELLKEY.getType())); //模板key需要用枚举
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成合同文件失败");
        }

        //生成excel
        try{
            if(monthlyRent == null)
                throw new FmsServiceException("请传递生成excel的必要参数");
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            monthlyRentExcelExportService.monthlyRectExport(sysTplType,monthlyRent,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
//            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }

}
