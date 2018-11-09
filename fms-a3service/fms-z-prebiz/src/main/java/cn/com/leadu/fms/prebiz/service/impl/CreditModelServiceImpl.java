package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.constant.enums.prebiz.CstmRelationIdentityTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.prebiz.service.ApplyCreditService;
import cn.com.leadu.fms.prebiz.service.ApplyInputService;
import cn.com.leadu.fms.prebiz.service.CreditModelService;
import cn.com.leadu.fms.prebiz.service.CstmRelationService;
import cn.com.leadu.fms.prebiz.vo.CreditModelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CreditModelServiceImpl
 * @Description: 贷前模型
 * @date 2018/5/15
 */
@Slf4j
@Service
public class CreditModelServiceImpl implements CreditModelService {

    @Autowired
    private ApplyInputService applyInputService;

    @Autowired
    private CommonExcelService commonExcelService;

    @Autowired
    private ApplyCreditService applyCreditService;

    @Autowired
    private CstmRelationService cstmRelationService;

    /**
     * @Title:
     * @Description:   生成贷前模型
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 04:32:36
     */
    public void generatePreBizCreditModel(String applyNo){
        ApplyInputVo applyInputVo = applyInputService.findApplyDetailInfo(applyNo);
        CreditModelVo creditModelVo = new CreditModelVo();
        creditModelVo.setApplyNo(applyNo);
        creditModelVo.setSex(applyInputVo.getCstmPerson().getSex());
        creditModelVo.setMarriageStatus(applyInputVo.getCstmPerson().getMarriageStatus());
        creditModelVo.setCensusType(applyInputVo.getCstmPerson().getCensusType());
        creditModelVo.setEduBgType(applyInputVo.getCstmPerson().getEduBgType());
        creditModelVo.setProfession(applyInputVo.getCstmPersJob().getProfession());
        creditModelVo.setWorkYear(applyInputVo.getCstmPersJob().getWorkYear());
        creditModelVo.setResideCond(applyInputVo.getCstmPersAddr().getResideCond());
        creditModelVo.setCensusProv(applyInputVo.getCstmPersAddr().getCensusProv());
        creditModelVo.setCensusCity(applyInputVo.getCstmPersAddr().getCensusCity());
        creditModelVo.setVehicleForm(applyInputVo.getApplyFinanceVo().getVehicleForm());
        creditModelVo.setGuidePrice(new BigDecimal(0));
        BigDecimal vehAgeMonths = new BigDecimal(0);
        List<ApplyVehicleVo> applyVehicleVos = applyInputVo.getApplyVehicleVoList();
        if(ArrayUtils.isNotNullAndLengthNotZero(applyVehicleVos)){
            for(ApplyVehicleVo applyVehicleVo : applyVehicleVos){
                if(applyVehicleVo != null){
                    if(applyVehicleVo.getGuidePrice() != null)
                        creditModelVo.setGuidePrice(
                                creditModelVo.getGuidePrice().add(applyVehicleVo.getGuidePrice())
                        );
                    if(applyVehicleVo.getVehAgeMonths() != null && applyVehicleVo.getVehAgeMonths().compareTo(vehAgeMonths) == 1){
                        vehAgeMonths = applyVehicleVo.getVehAgeMonths();
                    }
                }
            }
        }
        creditModelVo.setVehAgeMonths(vehAgeMonths);
        creditModelVo.setFinAmount(applyInputVo.getApplyFinanceVo().getFinTotal());
        try {
            String fileName = UUIDUtils.getUUID();
            String excelPath = CommonFileUtils.getRootPath(ExcelUtils.getExcelName(fileName));
            String txtPath = CommonFileUtils.getRootPath(TxtUtils.getTxtName(fileName));
            FileOutputStream outputStream = CommonFileUtils.getFileOutputStream(excelPath);
            commonExcelService.exportList(fileName, creditModelVo,
                    CreditModelVo.class,outputStream, ExcelTypeConstants.ONE);
            PythonUtils.modelAnalysis(excelPath,txtPath);
            String creditGrade = TxtUtils.getModelScoringSegment(txtPath);
            if(StringUtils.isTrimBlank(creditGrade))
                throw new FmsServiceException("未获取到模型评分段");
            applyCreditService.saveApplyCredit(applyNo,excelPath,txtPath,creditGrade);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("生成模型失败");
        }
    }

    /**
     * @Title:
     * @Description:   获取用户报告基础信息
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 11:05:56
     */
    public ApplyInputVo findCustomerByApplyNo(String applyNo){
        ApplyInputVo applyInputVo = applyInputService.findApplyDetailInfo(applyNo);
        BigDecimal guidePrice = new BigDecimal(0);
        List<ApplyVehicleVo> applyVehicleVos = applyInputVo.getApplyVehicleVoList();
        if(ArrayUtils.isNotNullAndLengthNotZero(applyVehicleVos)){
            for(ApplyVehicleVo applyVehicleVo : applyVehicleVos){
                if(applyVehicleVo != null){
                    if(applyVehicleVo.getGuidePrice() != null)
                        guidePrice = guidePrice.add(applyVehicleVo.getGuidePrice());
                }
            }
        }
        applyInputVo.setVehiclesGuidePriceCount(guidePrice);
        ApplyCredit applyCredit = applyCreditService.findApplyCreditByApplyNo(applyNo);
        if(applyCredit != null)
            applyInputVo.setCreditGrade(applyCredit.getCreditGrade());

        List<CstmRelation> cstmRelations = cstmRelationService.findCstmRelationsByApplyNo(applyNo);
        Map<String,Object> echartsMap = new HashMap<>();

        List<Map<String,Object>> datas = new ArrayList<>();
        CstmRelation relationLender = null;
        for(CstmRelation cstmRelation : cstmRelations){
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("id",cstmRelation.getRelationId());
            tmp.put("name",cstmRelation.getName());
            tmp.put("des","申请编号:" + applyNo + ",身份:"+cstmRelation.getIdentityTypeName());
            tmp.put("itemStyle","{normal:{color:'red'}}");
            datas.add(tmp);
            if(cstmRelation.getIdentityTypeCode().equals(CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()))
                relationLender = cstmRelation;
        }

        echartsMap.put("data",datas);
        if(relationLender == null)
            throw new FmsServiceException("未发现主贷人");
        List<Map<String,Object>> links = new ArrayList<>();
        for(CstmRelation cstmRelation : cstmRelations){
            if(cstmRelation != relationLender) {
                Map<String, Object> tmp = new HashMap<>();
                tmp.put("source", relationLender.getRelationId());
                tmp.put("target", cstmRelation.getRelationId());
                tmp.put("name",cstmRelation.getIdentityTypeName());
                links.add(tmp);
            }
        }
        echartsMap.put("links",links);
        applyInputVo.setEchartsMap(echartsMap);
        return applyInputVo;
    }

}
