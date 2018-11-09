package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.cost.GpsInstallStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.cost.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.cost.service.PilferInsuranceService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.PilferInsuranceRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.CstmDetailVo;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceSaveVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceModifyVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceDeleteVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceDeleteListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceService
 * @Description: 盗抢险信息业务实现层
 * @date 2018-05-31
 */
@Slf4j
@Service
public class PilferInsuranceServiceImpl implements PilferInsuranceService {

    /**
     * @Fields  : 盗抢险信息repository
     */
    @Autowired
    private PilferInsuranceRepository pilferInsuranceRepository;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息
     * @param pilferInsuranceVo
     * @return PageInfoExtend<PilferInsurance>
     * @throws
     * @author yanfengbo
     * @date 2018-5-31 15:34:24
     */
    public PageInfoExtend<PilferInsurance> findPilferInsurancesByPage(PilferInsuranceVo pilferInsuranceVo){
        pilferInsuranceVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        if(StringUtils.isNotTrimBlank(pilferInsuranceVo.getApplyNo()))
            pilferInsuranceVo.setApplyNo(SqlUtil.likePattern(pilferInsuranceVo.getApplyNo()));
        else
            pilferInsuranceVo.setApplyNo(null);
        if(StringUtils.isNotTrimBlank(pilferInsuranceVo.getContNo()))
            pilferInsuranceVo.setContNo(SqlUtil.likePattern(pilferInsuranceVo.getContNo()));
        else
            pilferInsuranceVo.setContNo(null);

        //出租人区域
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getGroupDistrict()))
            pilferInsuranceVo.setGroupDistrict(null);
        else
            pilferInsuranceVo.setGroupDistrict(SqlUtil.likePattern(pilferInsuranceVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getVinNo()))
            pilferInsuranceVo.setVinNo(null);
        else
            pilferInsuranceVo.setVinNo(SqlUtil.likePattern(pilferInsuranceVo.getVinNo()));

        //承租人
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getLessee()))
            pilferInsuranceVo.setLessee(null);
        else
            pilferInsuranceVo.setLessee(SqlUtil.likePattern(pilferInsuranceVo.getLessee()));

        //gps厂商
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getGpsSeller()))
            pilferInsuranceVo.setGpsSeller(null);

        //盗抢险投保渠道
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getTheftInsuranceType()))
            pilferInsuranceVo.setTheftInsuranceType(null);
        //GPS派单录入的安装状态为【已完成】
        pilferInsuranceVo.setInstallStatus(GpsInstallStatusEnums.COMPLETED.getType());
        //是否融盗抢险为【是】
        pilferInsuranceVo.setTheftInsuranceFlag(YesNoFlagEnums.YES.getType());
        return pilferInsuranceRepository.selectListVoByPage("selectPilferInsurancesByPage",pilferInsuranceVo,pilferInsuranceVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 保存盗抢险信息
     * @param pilferInsuranceSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public void savePilferInsurance(PilferInsuranceSaveVo pilferInsuranceSaveVo){
        pilferInsuranceRepository.insertData(pilferInsuranceSaveVo.getEntity());
        //保存附件信息
        bizFilesService.modifyBizFilesList(pilferInsuranceSaveVo.getBizFilesList(),pilferInsuranceSaveVo.getContNo(),
                BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType());
        // 保存附件信息
      /*  if(pilferInsuranceSaveVo.getBizfilesVo()!=null){
            PilferInsuranceVo pilferInsuranceVo = EntityUtils.getEntity(pilferInsuranceSaveVo, new PilferInsuranceVo());
            bizFilesService.saveBizFiles(pilferInsuranceVo.getBizfilesVo().getBizFilesListVos(), uuid, BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType());
        }*/
    }

    /**
     * @Title:
     * @Description: 修改盗抢险信息
     * @param pilferInsuranceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public void modifyPilferInsurance(PilferInsuranceModifyVo pilferInsuranceModifyVo){
        //保存附件信息
        bizFilesService.modifyBizFilesList(pilferInsuranceModifyVo.getBizFilesList(),pilferInsuranceModifyVo.getContNo(),
                BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType());
        // 修改附件信息
       /* if(pilferInsuranceModifyVo.getBizfilesVo()!=null){
            PilferInsuranceVo pilferInsuranceVo = EntityUtils.getEntity(pilferInsuranceModifyVo, new PilferInsuranceVo());
            bizFilesService.updateBizFiles(pilferInsuranceVo.getBizfilesVo().getBizFilesListVos(),pilferInsuranceVo.getPilferInsuranceId(),BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType());
        }*/
        pilferInsuranceRepository.updateByPrimaryKeySelectiveData(pilferInsuranceModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pilferInsuranceId删除盗抢险信息
     * @param pilferInsuranceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public void deletePilferInsurance(PilferInsuranceDeleteVo pilferInsuranceDeleteVo){
        pilferInsuranceRepository.deleteData(pilferInsuranceDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pilferInsuranceId集合删除盗抢险信息
     * @param pilferInsuranceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public void deletePilferInsurancesByPilferInsuranceIds(PilferInsuranceDeleteListVo pilferInsuranceDeleteListVo){
        pilferInsuranceRepository.deleteDataList(pilferInsuranceDeleteListVo.getPilferInsuranceIds(),pilferInsuranceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pilferInsuranceId获取盗抢险信息
     * @param pilferInsuranceId
     * @return PilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    public PilferInsurance findPilferInsuranceByPilferInsuranceId(String pilferInsuranceId){
        return pilferInsuranceRepository.selectByPrimaryKey(pilferInsuranceId);
    }

    /**
     * @param pilferInsuranceVo
     * @Description: 查询盗抢险月结信息一览
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/17 21:18
     */
    @Override
    public PageInfoExtend<PilferInsuranceVo> findPilferInsuranceMonthlysVosListByPage(PilferInsuranceVo pilferInsuranceVo) {
        pilferInsuranceVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());//个人标识

        //月结任务号
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getMonthlyPilferInsuranceNo()))
            pilferInsuranceVo.setMonthlyPilferInsuranceNo(null);
        else
            pilferInsuranceVo.setMonthlyPilferInsuranceNo(SqlUtil.likePattern(pilferInsuranceVo.getMonthlyPilferInsuranceNo()));

        //月结状态
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getMonthlyPilferInsuranceSts()))
            pilferInsuranceVo.setMonthlyPilferInsuranceSts(null);
        else
            pilferInsuranceVo.setMonthlyPilferInsuranceSts(pilferInsuranceVo.getMonthlyPilferInsuranceSts());

        //出租人区域
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getGroupDistrict()))
            pilferInsuranceVo.setGroupDistrict(null);
        else
            pilferInsuranceVo.setGroupDistrict(SqlUtil.likePattern(pilferInsuranceVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getVinNo()))
            pilferInsuranceVo.setVinNo(null);
        else
            pilferInsuranceVo.setVinNo(SqlUtil.likePattern(pilferInsuranceVo.getVinNo()));

        //起始时间
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getExpectInstallStartDateStr()))
            pilferInsuranceVo.setExpectInstallStartDateStr(null);
        else
            pilferInsuranceVo.setExpectInstallStartDateStr(pilferInsuranceVo.getExpectInstallStartDateStr());

        //结束时间
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getExpectInstallEndDateStr()))
            pilferInsuranceVo.setExpectInstallEndDateStr(null);
        else
            pilferInsuranceVo.setExpectInstallEndDateStr(pilferInsuranceVo.getExpectInstallEndDateStr());

        //承租人
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getLessee()))
            pilferInsuranceVo.setLessee(null);
        else
            pilferInsuranceVo.setLessee(SqlUtil.likePattern(pilferInsuranceVo.getLessee()));

        //gps厂商
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getGpsSeller()))
            pilferInsuranceVo.setGpsSeller(null);

        //盗抢险投保渠道
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getTheftInsuranceType()))
            pilferInsuranceVo.setTheftInsuranceType(null);
        return pilferInsuranceRepository.selectListVoByPage("selectPilferInsuranceMonthlysVosListByPage",pilferInsuranceVo,pilferInsuranceVo.getPageQuery());
    }

    /**
     * @param pilferInsuranceVo
     * @Description: 查询盗抢险月结信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/31 18:18
     */
    @Override
    public PageInfoExtend<PilferInsuranceVo> findPilferInsuranceMonthlysVos(PilferInsuranceVo pilferInsuranceVo) {
        pilferInsuranceVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());//个人标识
        if(pilferInsuranceVo.getPilferInsuranceIds() == null || pilferInsuranceVo.getPilferInsuranceIds().size() == 0){
            pilferInsuranceVo.setPilferInsuranceIds(null);
        }
        //月结任务号
        if(StringUtils.isTrimBlank(pilferInsuranceVo.getMonthlyPilferInsuranceNo()))
            pilferInsuranceVo.setMonthlyPilferInsuranceNo(null);
        else
            pilferInsuranceVo.setMonthlyPilferInsuranceNo(pilferInsuranceVo.getMonthlyPilferInsuranceNo());
        return pilferInsuranceRepository.selectListVoByPage("selectPilferInsuranceMonthlysVosByPage",pilferInsuranceVo,pilferInsuranceVo.getPageQuery());

    }

    /**
     * @Title:
     * @Description: 根据合同号获取盗抢险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public PilferInsuranceVo findPilferInsuranceVoByContNo(String contNo){
        Example example = SqlUtil.newExample(PilferInsurance.class);
        example.createCriteria().andEqualTo("contNo", contNo);
        PilferInsurance pilferInsurance = pilferInsuranceRepository.selectOneByExample(example);
        //根据合同号查询一条客户基本信息
        CstmDetailVo cstmDetailVo = pilferInsuranceRepository.selectOneCstmDetailByContNo(contNo);
        PilferInsuranceVo pilferInsuranceVo = EntityUtils.getEntity(pilferInsurance, new PilferInsuranceVo());
        //合同号
        pilferInsuranceVo.setContNo(cstmDetailVo.getContNo());
        //承租人
        pilferInsuranceVo.setLessee(cstmDetailVo.getLessee());
        //车架号
        pilferInsuranceVo.setVinNo(cstmDetailVo.getVinNo());
        //发动机号
        pilferInsuranceVo.setEngineNo(cstmDetailVo.getEngineNo());
        //有限设备号
        pilferInsuranceVo.setWiredDeviceNo(cstmDetailVo.getWiredDeviceNo());
        //无线设备号
        pilferInsuranceVo.setWirelessDeviceNo(cstmDetailVo.getWirelessDeviceNo());
        if(StringUtils.isNotTrimBlank(pilferInsuranceVo.getPilferInsuranceId())){
            //查询附件
            pilferInsuranceVo.setBizFilesList(bizFilesService.findBizFilesList(contNo, BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType()));
            //查询附件信息
          /*  try {
                CommonBizFilesVo bizFilesVo= ResponseEntityUtils.getRestResponseData(bizFilesRpc.findPilferInsuranceBizFilesByBizCode(pilferInsuranceVo.getPilferInsuranceId()));
                pilferInsuranceVo.setBizfilesVo(bizFilesVo);
            }catch (FmsRpcException ex){
                log.error(ex.getMessage());
                ex.printStackTrace();
            }*/
        }
        return pilferInsuranceVo;
    }
}
