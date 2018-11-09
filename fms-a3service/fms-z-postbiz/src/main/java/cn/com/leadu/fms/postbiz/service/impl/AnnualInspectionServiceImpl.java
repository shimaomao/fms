package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.AnnualInspectionEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.postbiz.service.AnnualInspectionService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.AnnualInspectionRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.postbiz.validator.annualinspection.vo.AnnualInspectionModifyVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionService
 * @Description: 年检提醒业务实现层
 */
@Service
public class AnnualInspectionServiceImpl implements AnnualInspectionService {

    /**
     * @Fields  : 年检提醒repository
     */
    @Autowired
    private AnnualInspectionRepository annualInspectionRepository;

    @Autowired
    private NumGenerateService numGenerateService;

    @Autowired
    private ContractRepository contractRepository;


    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    @Autowired
    private SysGroupRepository sysGroupRepository;

    @Autowired
    private CommonConstantService commonConstantService;



    /**
     * @Title:
     * @Description: 分页查询年检提醒
     * @param annualInspectionVo
     * @return PageInfoExtend<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public PageInfoExtend<AnnualInspectionVo> findAnnualInspectionVosByPage (AnnualInspectionVo annualInspectionVo){

        if (StringUtils.isTrimBlank(annualInspectionVo.getAnnualInspectStatus())){
            annualInspectionVo.setAnnualInspectStatus(null);
        }
        if (StringUtils.isNotTrimBlank(annualInspectionVo.getContNo())){
            annualInspectionVo.setContNo(SqlUtil.likePattern(annualInspectionVo.getContNo()));
        }else{
            annualInspectionVo.setContNo(null);
        }

        if (StringUtils.isNotTrimBlank(annualInspectionVo.getAnnualInspecVinNo())){
            annualInspectionVo.setAnnualInspecVinNo(SqlUtil.likePattern(annualInspectionVo.getAnnualInspecVinNo()));
        }else{
            annualInspectionVo.setAnnualInspecVinNo(null);
        }

        if (StringUtils.isNotTrimBlank(annualInspectionVo.getAnnualInspecUser())){
            annualInspectionVo.setAnnualInspecUser(SqlUtil.likePattern(annualInspectionVo.getAnnualInspecUser()));
        }else{
            annualInspectionVo.setAnnualInspecUser(null);
        }

        PageInfoExtend<AnnualInspectionVo> pageInfo = annualInspectionRepository.selectListVoByPage("selectAnnualInspectionVosByPage",annualInspectionVo,annualInspectionVo.getPageQuery());
        return pageInfo;
    }


    /**
     * @Title:
     * @Description: 修改年检提醒
     * @param annualInspectionModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public void modifyAnnualInspection(AnnualInspectionModifyVo annualInspectionModifyVo){

        Example example = new Example(AnnualInspection.class);
        //设置查询条件
        example.createCriteria().andEqualTo("annualInspectionId",annualInspectionModifyVo.getAnnualInspectionId());
        AnnualInspection nModifyVo= annualInspectionRepository.selectOneByExample(example);
        if (nModifyVo.getAnnualInspectStatus().equals(AnnualInspectionEnums.INSPECTINO.getType())) {
            throw new FmsServiceException("该车辆已经年检！");
        }
        annualInspectionModifyVo.setAnnualInspectStatus(AnnualInspectionEnums.INSPECTINO.getType());
        annualInspectionRepository.updateByPrimaryKeySelectiveData(annualInspectionModifyVo.getEntity());
    }



    /**
     * @Title:
     * @Description:  根据annualInspectionId获取年检提醒
     * @param annualInspectionId
     * @return AnnualInspection
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public AnnualInspectionVo findAnnualInspectionVoByAnnualInspectionId(String annualInspectionId){
        AnnualInspectionVo annualInspectionVo  = annualInspectionRepository.selectAnnualInspectionVoByAnnualInespectionId(annualInspectionId);
        return annualInspectionVo;
    }



    /**
     * @Title:
     * @Description:  获取合同信息表里面符合的数据
     * @return AnnualInspection
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public void findInfomationFromContract(){
        //获取系统常量间隔多少年 年检
        Integer annualYear =  Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.ANNUALINSPECTION_YEAR));
        //获取系统常量 提交多少天 获取需要年检车辆
        Integer annualDays =  Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.ANNUALINSPECTION_INSERT_DAYS));

        List<Contract> contractList = annualInspectionRepository.selectContractsByPaymentSts(annualYear,annualDays);
        List<AnnualInspection> annualInspectionList = new ArrayList<>();

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, annualDays);//预期的年检时间
        Date date = ca.getTime();
        if (ArrayUtils.isNotNullAndLengthNotZero(contractList)){
            for (Contract tractV:contractList) {
                AnnualInspection inspectionV = new AnnualInspection();

                String inspectNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.FIND_ANNULINSPECTION_NUM_TYPE.getType());
                inspectionV.setAnnualInspectNo(inspectNo);

                inspectionV.setContNo(tractV.getContNo());
                inspectionV.setAnnualInspectStatus(AnnualInspectionEnums.UNINSPECTINO.getType());


                inspectionV.setAnnualInspectDeadline(date);
                annualInspectionList.add(inspectionV);

            }
        }
        annualInspectionRepository.insertDataList(annualInspectionList);
    }

}
