package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CrmCompanyRepository;
import cn.com.leadu.fms.data.prebiz.repository.CrmStockAssetsRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyCarrierVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import cn.com.leadu.fms.prebiz.service.CrmCompanyService;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanySaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyService
 * @Description: CRM企业信息业务实现层
 * @date 2018-05-23
 */
@Service
public class CrmCompanyServiceImpl implements CrmCompanyService {

    /**
     * @Fields  : CRM企业信息repository
     */
    @Autowired
    private CrmCompanyRepository crmCompanyRepository;

    @Autowired
    private NumGenerateService numGenerateService;

    @Autowired
    private CrmStockAssetsRepository crmStockAssetsRepository;

    /**
     * @Title:
     * @Description: 分页查询CRM企业信息
     * @param crmCompanyVo
     * @return PageInfoExtend<CrmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public PageInfoExtend<CrmCompanyVo> findCrmCompanysByPage(CrmCompanyVo crmCompanyVo){
//        Example example = SqlUtil.newExample(CrmCompany.class);
//        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(crmCompanyVo.getName())){
            crmCompanyVo.setName(SqlUtil.likePattern(crmCompanyVo.getName()));
        }else{
            crmCompanyVo.setName(null);
        }
        if(StringUtils.isNotTrimBlank(crmCompanyVo.getSocialCertifNo())){
            crmCompanyVo.setSocialCertifNo(SqlUtil.likePattern(crmCompanyVo.getSocialCertifNo()));
        }else{
            crmCompanyVo.setSocialCertifNo(null);
        }
        PageInfoExtend<CrmCompanyVo> pageInfo = crmCompanyRepository.selectListVoByPage("selectCrmCompanyVosByPage",crmCompanyVo,crmCompanyVo.getPageQuery());
        for(CrmCompanyVo crmCompany:pageInfo.getData()){
            Example example = SqlUtil.newExample(CrmStockAssets.class);
            example.createCriteria().andEqualTo("socialCertifNo",crmCompany.getSocialCertifNo());
            crmCompany.setCrmStockAssetsVoList(crmStockAssetsRepository.selectListByExample(example));
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存CRM企业信息
     * @param crmCompanySaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public void saveCrmCompany(CrmCompanySaveVo crmCompanySaveVo){
        String finassCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMCO_CODE.getType());
        crmCompanySaveVo.setFinassCstmCode(finassCstmCode);
        crmCompanyRepository.insertData(crmCompanySaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改CRM企业信息
     * @param crmCompanyModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public void modifyCrmCompany(CrmCompanyModifyVo crmCompanyModifyVo){
        crmCompanyRepository.updateByPrimaryKeySelectiveData(crmCompanyModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过companyId删除CRM企业信息
     * @param crmCompanyDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public void deleteCrmCompany(CrmCompanyDeleteVo crmCompanyDeleteVo){
        crmCompanyRepository.deleteData(crmCompanyDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过companyId集合删除CRM企业信息
     * @param crmCompanyDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public void deleteCrmCompanysByCompanyIds(CrmCompanyDeleteListVo crmCompanyDeleteListVo){
        crmCompanyRepository.deleteDataList(crmCompanyDeleteListVo.getCompanyIds(),crmCompanyDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据companyId获取CRM企业信息
     * @param companyId
     * @return CrmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public CrmCompany findCrmCompanyByCompanyId(String companyId){
        return crmCompanyRepository.selectByPrimaryKey(companyId);
    }

    /**
     * @Title:
     * @Description:  根据证件号获取CRM企业信息
     * @param socialCertifNo
     * @return CrmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public CrmCompanyCarrierVo findCrmCompanyByCertifNo(String socialCertifNo) {
        Example example  = SqlUtil.newExample(CrmCompany.class);
        example.createCriteria().andEqualTo("socialCertifNo",socialCertifNo);
        CrmCompany CrmCompany = crmCompanyRepository.selectOneByExample(example);
        CrmCompanyCarrierVo crmCompanyCarrierVo = new CrmCompanyCarrierVo();
        crmCompanyCarrierVo.setCstmCompany(EntityUtils.getEntity(CrmCompany,new CstmCompany()));
        crmCompanyCarrierVo.setGuaranteeComp(EntityUtils.getEntity(CrmCompany,new GuaranteeComp()));
        return crmCompanyCarrierVo;
    }

    /**
     * @Title:
     * @Description: 将前台传入的融资信息转为crm企业信息
     * @param applyInputVo
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public void getCrmCompFromInputVo(ApplyInputVo applyInputVo) {
        // 保存企业crm信息
        if(applyInputVo.getCstmCompany()!=null){
            CrmCompany crmCompany = EntityUtils.getEntity(applyInputVo.getCstmCompany(),new CrmCompany());
            Example example = SqlUtil.newExample(CrmCompany.class);
            example.createCriteria().andEqualTo("socialCertifNo",crmCompany.getSocialCertifNo());
            CrmCompany crm = crmCompanyRepository.selectOneByExample(example);
            if(crm==null){
                String finassCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMCO_CODE.getType());
                crmCompany.setFinassCstmCode(finassCstmCode);
                crmCompanyRepository.insertData(crmCompany);
            }
            else
                crmCompanyRepository.updateByExampleSelectiveData(crmCompany,example);
            //保存crm股东信息
            this.saveCrmStockAssets(applyInputVo);
        }
        //保存担保企业信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteeCompList())){
            for(GuaranteeComp guaranteeComp:applyInputVo.getGuaranteeCompList()){
                CrmCompany crmCompany = EntityUtils.getEntity(guaranteeComp,new CrmCompany());
                Example example = SqlUtil.newExample(CrmCompany.class);
                example.createCriteria().andEqualTo("socialCertifNo",crmCompany.getSocialCertifNo());
                CrmCompany crm = crmCompanyRepository.selectOneByExample(example);
                if(crm==null){
                    String finassCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMCO_CODE.getType());
                    crmCompany.setFinassCstmCode(finassCstmCode);
                    crmCompanyRepository.insertData(crmCompany);
                }
                else
                    crmCompanyRepository.updateByExampleSelectiveData(crmCompany,example);
            }
        }
    }

    @Override
    public CrmCompany findCrmCompByCertifNo(String socialCertifNo) {
        Example example = SqlUtil.newExample(CrmCompany.class);
        example.createCriteria().andEqualTo("socialCertifNo",socialCertifNo);
        CrmCompany crm = crmCompanyRepository.selectOneByExample(example);
        return crm;
    }

    /**
     * @Title:
     * @Description: 保存crm股东信息
     * @param applyInputVo
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public void saveCrmStockAssets(ApplyInputVo applyInputVo){
        Example example = SqlUtil.newExample(CrmStockAssets.class);
        example.createCriteria().andEqualTo("socialCertifNo",applyInputVo.getCstmCompany().getSocialCertifNo());
        List<CrmStockAssets> crmStockAssetsList =  crmStockAssetsRepository.selectListByExample(example);
        List<String> crmStockAssetsIds = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(crmStockAssetsList)){
            for(CrmStockAssets crmStockAssets:crmStockAssetsList){
                crmStockAssetsIds.add(crmStockAssets.getStockAssetsId());
            }
            crmStockAssetsRepository.deletePhysicsEntityList(crmStockAssetsIds);
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCrmStockAssetsList())){
            for(CrmStockAssets crmStockAssets:applyInputVo.getCrmStockAssetsList()){
                crmStockAssets.setSocialCertifNo(applyInputVo.getCstmCompany().getSocialCertifNo());
                crmStockAssets.setStockAssetsId(null);
            }
            crmStockAssetsRepository.insertDataList(applyInputVo.getCrmStockAssetsList());
        }
    }

}
