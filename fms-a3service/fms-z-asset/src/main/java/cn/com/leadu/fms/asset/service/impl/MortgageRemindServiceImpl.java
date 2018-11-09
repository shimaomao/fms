package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.MortgageRemindService;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageRemindStatusEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.asset.repository.MortgageRemindRepository;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindSaveVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindModifyVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindDeleteVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindDeleteListVo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindService
 * @Description: 抵押提醒业务实现层
 * @date 2018-07-27
 */
@Service
public class MortgageRemindServiceImpl implements MortgageRemindService {

    /**
     * @Fields  : 抵押提醒repository
     */
    @Autowired
    private MortgageRemindRepository mortgageRemindRepository;

    //附件上传的
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询抵押提醒
     * @param mortgageRemindVo
     * @return PageInfoExtend<MortgageRemind>
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public PageInfoExtend<MortgageRemindVo> findMortgageRemindsByPage(MortgageRemindVo mortgageRemindVo){

        if(StringUtils.isNotTrimBlank(mortgageRemindVo.getLessee())){
            mortgageRemindVo.setLessee(SqlUtil.likePattern(mortgageRemindVo.getLessee()));
        }else
            mortgageRemindVo.setLessee(null);
        if(StringUtils.isNotTrimBlank(mortgageRemindVo.getVinNo())){
            mortgageRemindVo.setVinNo(SqlUtil.likePattern(mortgageRemindVo.getVinNo().toUpperCase()));
        }else
            mortgageRemindVo.setVinNo(null);

        if(StringUtils.isNotTrimBlank(mortgageRemindVo.getMortgageStatus())){
            mortgageRemindVo.setMortgageStatus(mortgageRemindVo.getMortgageStatus());
        }else
            mortgageRemindVo.setMortgageStatus(null);

        mortgageRemindVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        mortgageRemindVo.setMortgageType(MortgageRemindStatusEnums.NOT_MOR.getStatus());
        mortgageRemindVo.setLicenseAttr(LicenseAttrEnums.LEASE_BACK.getType());
        PageInfoExtend<MortgageRemindVo> pageInfo = mortgageRemindRepository.selectListVoByPage("selectMortgageRemindsByPage",mortgageRemindVo,mortgageRemindVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存抵押提醒
     * @param mortgageRemindSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public void saveMortgageRemind(MortgageRemindSaveVo mortgageRemindSaveVo){
        mortgageRemindRepository.insertData(mortgageRemindSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改抵押提醒
     * @param mortgageRemindModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public void modifyMortgageRemind(MortgageRemindModifyVo mortgageRemindModifyVo){
        List<MortgageRemind> mortgageRemindList = mortgageRemindModifyVo.getMortgageRemindList();
        //true 抵押  false解押
        for(MortgageRemind mortgageRemind : mortgageRemindList){
            if (MortgageRemindStatusEnums.NOT_MOR.getStatus().equals(mortgageRemindModifyVo.getMortgageStatus())){
                mortgageRemind.setMortgageStatus(MortgageRemindStatusEnums.EQU_MOR_SUCCESS.getStatus());
            }else if (MortgageRemindStatusEnums.EQU_MOR_SUCCESS.getStatus().equals(mortgageRemindModifyVo.getMortgageStatus())){
                mortgageRemind.setMortgageStatus(MortgageRemindStatusEnums.RESOLVING_RELIEF.getStatus());
            }
        }
        mortgageRemindRepository.updateByPrimaryKeySelectiveDataList(mortgageRemindList,true);

        //如果附件不为空，则进行保存
        if(ArrayUtils.isNotNullAndLengthNotZero(mortgageRemindModifyVo.getBizFilesList())){
            if (MortgageRemindStatusEnums.NOT_MOR.getStatus().equals(mortgageRemindModifyVo.getMortgageStatus())){
                bizFilesService.modifyBizFilesList(mortgageRemindModifyVo.getBizFilesList(),mortgageRemindModifyVo.getMorRemindId(),BizCodeTypeEnums.mortgageRemindFile.getCodeType());
            }else if (MortgageRemindStatusEnums.EQU_MOR_SUCCESS.getStatus().equals(mortgageRemindModifyVo.getMortgageStatus())){
                bizFilesService.modifyBizFilesList(mortgageRemindModifyVo.getBizFilesList(),mortgageRemindModifyVo.getMorRemindId(),BizCodeTypeEnums.mortgageRemindUnLockFile.getCodeType());
            }
        }
    }

    /**
     * @Title:
     * @Description:  通过morRemindId删除抵押提醒
     * @param mortgageRemindDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public void deleteMortgageRemind(MortgageRemindDeleteVo mortgageRemindDeleteVo){
        mortgageRemindRepository.deleteData(mortgageRemindDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过morRemindId集合删除抵押提醒
     * @param mortgageRemindDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public void deleteMortgageRemindsByMorRemindIds(MortgageRemindDeleteListVo mortgageRemindDeleteListVo){
        mortgageRemindRepository.deleteDataList(mortgageRemindDeleteListVo.getMorRemindIds(),mortgageRemindDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return MortgageRemind
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public MortgageRemind findMortgageRemindByMorRemindId(String morRemindId){
        return mortgageRemindRepository.selectByPrimaryKey(morRemindId);
    }


    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return MortgageRemind
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public MortgageRemindVo selectMortgageRemindVosBymorRemindId(String morRemindId){
        MortgageRemindVo mortgageRemindVo  = mortgageRemindRepository.selectMortgageRemindVosBymorRemindId(morRemindId);
        mortgageRemindVo.setBizFilesList(bizFilesService.findBizFilesList(morRemindId, BizCodeTypeEnums.mortgageRemindFile.getCodeType()));
        mortgageRemindVo.setBizUnlockFilesList(bizFilesService.findBizFilesList(morRemindId, BizCodeTypeEnums.mortgageRemindUnLockFile.getCodeType()));
        return mortgageRemindVo;
    }

}
