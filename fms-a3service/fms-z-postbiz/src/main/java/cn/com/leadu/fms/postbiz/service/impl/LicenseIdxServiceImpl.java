package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.LicenseIdxEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.postbiz.service.LicenseIdxService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.LicenseIdxRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxSaveVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxModifyVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxDeleteVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author license_idx
 * @ClassName: LicenseIdxService
 * @Description: 指标管理表业务实现层
 */
@Service
public class LicenseIdxServiceImpl implements LicenseIdxService {

    /**
     * @Fields  : 指标管理表repository
     */
    @Autowired
    private LicenseIdxRepository licenseIdxRepository;
    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询指标管理表
     * @param licenseIdxVo
     * @return PageInfoExtend<LicenseIdx>
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public PageInfoExtend<LicenseIdxVo> findLicenseIdxVosByPage(LicenseIdxVo licenseIdxVo){
        //指标编号
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getLicenseIdxNo())) {
            licenseIdxVo.setLicenseIdxNo((SqlUtil.likePattern(licenseIdxVo.getLicenseIdxNo())));
        } else{
            licenseIdxVo.setLicenseIdxNo(null);
        }
        //指标状态
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getLicenseIdxStatus())) {
            licenseIdxVo.setLicenseIdxStatus((licenseIdxVo.getLicenseIdxStatus()));
        } else{
            licenseIdxVo.setLicenseIdxStatus(null);
        }
        //指标所属分公司
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getGroupName())) {
            licenseIdxVo.setGroupName((SqlUtil.likePattern(licenseIdxVo.getGroupName())));
        } else{
            licenseIdxVo.setGroupName(null);
        }
        //指标使用人
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getUseCustomer())) {
            licenseIdxVo.setUseCustomer((SqlUtil.likePattern(licenseIdxVo.getUseCustomer())));
        } else{
            licenseIdxVo.setUseCustomer(null);
        }
        //指标合同编号
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getUseContNo())) {
            licenseIdxVo.setUseContNo((SqlUtil.likePattern(licenseIdxVo.getUseContNo())));
        } else{
            licenseIdxVo.setUseContNo(null);
        }
        //车牌号
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getUseLicenseNo())) {
            licenseIdxVo.setUseLicenseNo((SqlUtil.likePattern(licenseIdxVo.getUseLicenseNo())));
        } else{
            licenseIdxVo.setUseLicenseNo(null);
        }
        //合同状态
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getBizStatus())) {
            licenseIdxVo.setBizStatus(licenseIdxVo.getBizStatus());
        } else{
            licenseIdxVo.setBizStatus(null);
        }
        PageInfoExtend<LicenseIdxVo> pageInfo = licenseIdxRepository.selectListVoByPage("selectLicenseIdxVos",licenseIdxVo,licenseIdxVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存指标管理表
     * @param licenseIdxSaveVo
     * @return java.lang.String
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public void saveLicenseIdx(LicenseIdxSaveVo licenseIdxSaveVo){
        LicenseIdxVo LicenseIdxVo = this.checkLicenseIdxVoBylicenseIdxNo(licenseIdxSaveVo.getLicenseIdxNo());
        if(LicenseIdxVo==null){
            //保存指标信息
            licenseIdxRepository.insertData(licenseIdxSaveVo.getEntity());
            //保存附件信息
            bizFilesService.modifyBizFilesList(licenseIdxSaveVo.getBizFilesList(),licenseIdxSaveVo.getLicenseIdxNo(),
                    BizCodeTypeEnums.INDEXANNEX_FILE.getCodeType());
        }else {
            throw new FmsServiceException("该指标编号已存在，请重新录入！");
        }
    }

    /**
     * @Title:
     * @Description: 修改指标管理表
     * @param licenseIdxModifyVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public void modifyLicenseIdx(LicenseIdxModifyVo licenseIdxModifyVo){
        licenseIdxRepository.updateByPrimaryKeySelectiveData(licenseIdxModifyVo.getEntity());
        //保存附件信息
        bizFilesService.modifyBizFilesList(licenseIdxModifyVo.getBizFilesList(),licenseIdxModifyVo.getLicenseIdxNo(),
                BizCodeTypeEnums.INDEXANNEX_FILE.getCodeType());
    }

    /**
     * @Title:
     * @Description:  通过licenseIdxId删除指标管理表
     * @param licenseIdxDeleteVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public void deleteLicenseIdx(LicenseIdxDeleteVo licenseIdxDeleteVo){
        licenseIdxRepository.deleteData(licenseIdxDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过licenseIdxId集合删除指标管理表
     * @param licenseIdxDeleteListVo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public void deleteLicenseIdxsByLicenseIdxIds(LicenseIdxDeleteListVo licenseIdxDeleteListVo){
        licenseIdxRepository.deleteDataList(licenseIdxDeleteListVo.getLicenseIdxIds(),licenseIdxDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return LicenseIdx
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public LicenseIdx findLicenseIdxByLicenseIdxId(String licenseIdxId){
        return licenseIdxRepository.selectByPrimaryKey(licenseIdxId);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxId获取指标管理表
     * @param licenseIdxId
     * @return LicenseIdx
     * @throws
     * @author license_idx
     * @date 2018-9-12 11:38:16
     */
    public LicenseIdxVo findLicenseIdxVoByLicenseIdxId(String licenseIdxId){
        LicenseIdxVo licenseIdxVo = licenseIdxRepository.selectVoByPrimaryKey(licenseIdxId);
        //查询附件
        licenseIdxVo.setBizFilesList(bizFilesService.findBizFilesList(licenseIdxVo.getLicenseIdxNo(), BizCodeTypeEnums.INDEXANNEX_FILE.getCodeType()));
        return licenseIdxVo;
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxNo获取指标管理表是否存在
     * @param licenseIdxNo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    public LicenseIdxVo checkLicenseIdxVoBylicenseIdxNo(String licenseIdxNo){
        return licenseIdxRepository.selectLicenseIdxNoByPrimaryKey(licenseIdxNo);
    }

    /**
     * @Title:
     * @Description:  修改指标管理表
     * @param licenseIdxId
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    public void modifyLicenseIdxVoBylicenseIdx(String licenseIdxId,String licenseIdxzt){
        LicenseIdx licenseIdx = licenseIdxRepository.selectByPrimaryKey(licenseIdxId);
        licenseIdx.setLicenseIdxStatus(LicenseIdxEnums.ALREADYUSED.getType());//未使用状态
        if(LicenseIdxEnums.NOTUSED.getType().equals(licenseIdxzt)){//指标退牌操作
            licenseIdx.setUseCustomer(null);//指标使用人更新为空
            licenseIdx.setUseCertifNo(null);//使用人证件号更新为空
            licenseIdx.setUsePhoneNo(null);//使用人电话更新为空
            if(StringUtils.isNotTrimBlank(licenseIdx.getLicenseNoUsed())){
                licenseIdx.setLicenseNoUsed(licenseIdx.getLicenseNoUsed()+","+licenseIdx.getUseLicenseNo());//历史车牌号累加保存
            }else{
                licenseIdx.setLicenseNoUsed(licenseIdx.getUseLicenseNo());//历史车牌号累加保存
            }
            licenseIdx.setUseLicenseNo(null);//车牌号更新为空
            licenseIdx.setUseAppointDate(null);//指标预约日期更新为空
            licenseIdx.setLeaseStartDate(null);//指标续约开始日更新为空
            licenseIdx.setLeaseEndDate(null);//指标续约结束日更新为空
        }else if(LicenseIdxEnums.APPOINTMENT.getType().equals(licenseIdxzt)){//指标取消操作
            Example example = SqlUtil.newExample(Contract.class);
            example.createCriteria().andEqualTo("contNo",licenseIdx.getUseContNo());
            Contract contract = contractRepository.selectOneByExample(example);
            if(contract == null){
                throw new FmsServiceException( "合同信息不存在");
            }
            contract.setLicenseIdxNo(null);//指标编号置为空
            contractRepository.updateByPrimaryKeyData(contract);
        }
        licenseIdx.setUseContNo(null);//合同编号更新为空
        licenseIdxRepository.updateByPrimaryKeyData(licenseIdx);
    }

    /**
     * @Title:
     * @Description:  根据用户代码查询未使用指标信息
     * @throws
     * @author license_idx
     * @date 2018-9-20 11:38:16
     */
    public PageInfoExtend<LicenseIdxVo> findLicenseIdxVoBylicenseIdxlist(LicenseIdxVo licenseIdxVo){

        //指标编号
        if (StringUtils.isNotTrimBlank(licenseIdxVo.getLicenseIdxNo())) {
            licenseIdxVo.setLicenseIdxNo((SqlUtil.likePattern(licenseIdxVo.getLicenseIdxNo())));
        } else{
            licenseIdxVo.setLicenseIdxNo(null);
        }
        PageInfoExtend<LicenseIdxVo> pageInfo = licenseIdxRepository.selectListVoByPage("selectLicenseIdxVobySysgroup",licenseIdxVo,licenseIdxVo.getPageQuery());
        return pageInfo;
    }


}
