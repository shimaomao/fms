package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.EquMorRepayService;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayDeleteListVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayDeleteVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayModifyVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepaySaveVo;
import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.ResponseUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepay.EquMorRepayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayService
 * @Description: 资方抵押还款计划业务实现层
 * @date 2018-05-30
 */
@Slf4j
@Service
public class EquMorRepayServiceImpl implements EquMorRepayService {

    /**
     * @Fields  : 资方抵押还款计划repository
     */
    @Autowired
    private EquMorRepayRepository equMorRepayRepository;

    @Autowired
    private CommonExcelService commonExcelService;

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划
     * @param equMorRepayVo
     * @return PageInfoExtend<EquMorRepay>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public PageInfoExtend<EquMorRepay> findEquMorRepaysByPage(EquMorRepayVo equMorRepayVo){
        Example example = SqlUtil.newExample(EquMorRepay.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<EquMorRepay> pageInfo = equMorRepayRepository.selectListByExamplePage(example,equMorRepayVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepaySaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public void saveEquMorRepay(EquMorRepaySaveVo equMorRepaySaveVo){
        equMorRepayRepository.insertData(equMorRepaySaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepayModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public void modifyEquMorRepay(EquMorRepayModifyVo equMorRepayModifyVo){
        equMorRepayRepository.updateByPrimaryKeySelectiveData(equMorRepayModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equMorRepayId删除资方抵押还款计划
     * @param equMorRepayDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public void deleteEquMorRepay(EquMorRepayDeleteVo equMorRepayDeleteVo){
        equMorRepayRepository.deleteData(equMorRepayDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equMorRepayId集合删除资方抵押还款计划
     * @param equMorRepayDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public void deleteEquMorRepaysByEquMorRepayIds(EquMorRepayDeleteListVo equMorRepayDeleteListVo){
        equMorRepayRepository.deleteDataList(equMorRepayDeleteListVo.getEquMorRepayIds(),equMorRepayDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据equMorRepayId获取资方抵押还款计划
     * @param equMorRepayId
     * @return EquMorRepay
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    public EquMorRepay findEquMorRepayByEquMorRepayId(String equMorRepayId){
        return equMorRepayRepository.selectByPrimaryKey(equMorRepayId);
    }

    /**
     * @Fields  : 解析还款计划excel
     * @author qiaomengnan
     */
    public List<EquMorRepayVo> parseEquMorRepayVoExcel(String filePath){
        List<EquMorRepayVo> equMorChargeVos = commonExcelService.importExcelToData(filePath,EquMorRepayVo.class);
        return equMorChargeVos;
    }

    /**
     * @Title:
     * @Description:   还款计划表下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 03:23:28
     */
    public void downloadEquMorRepayExcelTemplate(HttpServletResponse httpServletResponse){
        try {
            ResponseUtils.outExcel(httpServletResponse,"还款计划表模板");
            commonExcelService.exportList("还款计划表模板",getRepayTemplateData(),EquMorRepayVo.class,httpServletResponse.getOutputStream(), ExcelTypeConstants.ONE);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("还款计划表模板模板生成失败");
        }
    }

    /**
     * @Title:
     * @Description: 返回还款计划表模板数据
     * @param: 
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 11:24
     */
    private List<EquMorRepayVo> getRepayTemplateData() throws ParseException {
        List<EquMorRepayVo> equMorRepayVos = new ArrayList<>();
        EquMorRepayVo equMorRepayVo = new EquMorRepayVo();
        equMorRepayVo.setClientName("小季");
        equMorRepayVo.setLeasePeriod("12");
        equMorRepayVo.setVinNo("1234567890123456A");
        equMorRepayVo.setRepayDate("5");
        equMorRepayVo.setRent(new BigDecimal("2000"));
        equMorRepayVos.add(equMorRepayVo);
        return equMorRepayVos;
    }

    /**
     * @Title:
     * @Description:   保存还款计划集合
     * @param equMorRepays
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 04:00:31
     */
    @Transactional
    public void saveEquMorRepay(List<EquMorRepay> equMorRepays){
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorRepays))
            equMorRepayRepository.insertDataList(equMorRepays);
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号查询还款计划
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:07:04
     */
    public List<EquMorRepay> findEquMorRepayByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo)) {
            Example equMorRepayExample = SqlUtil.newExample(EquMorRepay.class);
            equMorRepayExample.createCriteria().andEqualTo("equMorTaskNo", equMorTaskNo);
            return equMorRepayRepository.selectListByExample(equMorRepayExample);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号删除还款计划
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:48:30
     */
    @Transactional
    public void deleteEquMorRepayByEquMorTaskNo(String equMorTaskNo){
        checkEquMorTaskNo(equMorTaskNo);
        Example equMorRepayExample = SqlUtil.newExample(EquMorRepay.class);
        equMorRepayExample.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        equMorRepayRepository.deleteExampleData(equMorRepayExample,new EquMorRepay());
    }

    /**
     * @Title:
     * @Description: check抵押任务号
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 18:32
     */
    private void checkEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
    }

}
