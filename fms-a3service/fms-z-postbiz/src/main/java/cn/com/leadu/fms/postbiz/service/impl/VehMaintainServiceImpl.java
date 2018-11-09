package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehMaintainEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.ResponseUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesListVo;
import cn.com.leadu.fms.postbiz.service.VehMaintainService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.VehMaintainRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonModifyVo;
import cn.com.leadu.fms.postbiz.validator.vehmaintain.vo.VehMaintainModifyVo;
import cn.com.leadu.fms.postbiz.validator.vehmaintain.vo.VehMaintainSaveVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainService
 * @Description: 车辆维修记录业务实现层
 */
@Service
public class VehMaintainServiceImpl implements VehMaintainService {

    /**
     * @Fields  : 车辆维修记录repository
     */
    @Autowired
    private VehMaintainRepository vehMaintainRepository;

    @Autowired
    private CommonExcelService commonExcelService;

    //附件上传的
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询车辆维修记录
     * @param vehMaintainVo
     * @return PageInfoExtend<VehMaintain>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    public PageInfoExtend<VehMaintainVo> findVehMaintainsVosByPage(VehMaintainVo vehMaintainVo){
        if (StringUtils.isTrimBlank(vehMaintainVo.getMaintainFlag())) {
            vehMaintainVo.setMaintainFlag(null);
        }
        if (StringUtils.isTrimBlank(vehMaintainVo.getVinNo())) {
            vehMaintainVo.setVinNo(null);
        }else {
            vehMaintainVo.setVinNo(SqlUtil.likePattern(vehMaintainVo.getVinNo()));
        }

        if (StringUtils.isTrimBlank(vehMaintainVo.getVehContNo())) {
            vehMaintainVo.setVehContNo(null);
        }else {
            vehMaintainVo.setVehContNo(SqlUtil.likePattern(vehMaintainVo.getVehContNo()));
        }

        if (StringUtils.isTrimBlank(vehMaintainVo.getVehTenant())) {
            vehMaintainVo.setVehTenant(null);
        }else {
            vehMaintainVo.setVehTenant(SqlUtil.likePattern(vehMaintainVo.getVehTenant()));
        }


        PageInfoExtend<VehMaintainVo> pageInfo = vehMaintainRepository.selectListVoByPage("selectVeMaintainVosByPage",vehMaintainVo,vehMaintainVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存车辆维修记录
     * @param vehMaintainSaveVo
     * @return java.lang.String
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    public void saveVehMaintain(VehMaintainSaveVo vehMaintainSaveVo){
        VehMaintain vehMaintain = vehMaintainSaveVo.getEntity();
        vehMaintainRepository.insertData(vehMaintain);
        //如果附件不为空，则进行保存
        if(ArrayUtils.isNotNullAndLengthNotZero(vehMaintainSaveVo.getBizFilesList())){
            bizFilesService.modifyBizFilesList(vehMaintainSaveVo.getBizFilesList(),vehMaintainSaveVo.getVehMaintainId(),BizCodeTypeEnums.VEHMAINTAIN_FILE.getCodeType());
        }

    }


    /**
     * @Title:
     * @Description:  修改车辆维修记录
     * @return VehMaintain
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    public void modifyVehMaintain(VehMaintainModifyVo vehMaintainModifyVo){
        vehMaintainRepository.updateByPrimaryKeySelectiveData(vehMaintainModifyVo.getEntity());
        //如果附件不为空，则进行更新
        if(ArrayUtils.isNotNullAndLengthNotZero(vehMaintainModifyVo.getBizFilesList())){
            bizFilesService.modifyBizFilesList(vehMaintainModifyVo.getBizFilesList(),vehMaintainModifyVo.getVehMaintainId(),BizCodeTypeEnums.VEHMAINTAIN_FILE.getCodeType());
        }
    }

    /**
     * @Title:
     * @Description:  根据vehMaintainId获取车辆维修记录
     * @param vehMaintainId
     * @return VehMaintain
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    public VehMaintainVo findVehMaintainVoByVehMaintainId(String vehMaintainId){

        VehMaintainVo vehMaintainVo = vehMaintainRepository.selectVehMaintainVoByVehMaintainId(vehMaintainId);
        vehMaintainVo.setBizFilesList(bizFilesService.findBizFilesList(vehMaintainId,BizCodeTypeEnums.VEHMAINTAIN_FILE.getCodeType()));
        return  vehMaintainVo;
    }

    /**
     * @Title:
     * @Description:  excel导入数据
     * @param filePath
     * @return VehMaintain
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    public void importVehMaintainsByExcel(String filePath){
        List<VehMaintain> VehMaintains = commonExcelService.importExcelToData(filePath,VehMaintain.class);
        for(VehMaintain vehMaintain : VehMaintains){
            vehMaintain.setMaintainFlag(VehMaintainEnums.MAINTAINEXCELL.getType());
        }
        vehMaintainRepository.insertDataList(VehMaintains);
    }

    /**
     * @Title:
     * @Description:   收款明细导入模板下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/05/11 11:51:40
     */
    @Override
    public void exportVehMaintainModalExcel(HttpServletResponse httpServletResponse) {
        try {
            ResponseUtils.outExcel(httpServletResponse,"维修记录模板");
            commonExcelService.exportList("维修记录模板",null,VehMaintain.class,httpServletResponse.getOutputStream(), ExcelTypeConstants.TWO);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new FmsServiceException("维修记录模板生成失败");
        }
    }
}
