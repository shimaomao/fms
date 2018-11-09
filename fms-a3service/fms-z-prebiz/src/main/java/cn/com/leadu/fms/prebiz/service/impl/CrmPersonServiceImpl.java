package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonCarrierVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.GuaranteeMate;
import cn.com.leadu.fms.prebiz.service.CrmPersonService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CrmPersonRepository;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonSaveVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonService
 * @Description: CRM个人信息业务实现层
 * @date 2018-05-23
 */
@Service
public class CrmPersonServiceImpl implements CrmPersonService {

    /**
     * @Fields  : CRM个人信息repository
     */
    @Autowired
    private CrmPersonRepository crmPersonRepository;

    @Autowired
    private  NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询CRM个人信息
     * @param crmPersonVo
     * @return PageInfoExtend<CrmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public PageInfoExtend<CrmPerson> findCrmPersonsByPage(CrmPersonVo crmPersonVo){
        Example example = SqlUtil.newExample(CrmPerson.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(crmPersonVo.getName()))
            criteria.andLike("name",SqlUtil.likePattern(crmPersonVo.getName()));
        if(StringUtils.isNotTrimBlank(crmPersonVo.getCertifNo()))
            criteria.andLike("certifNo",SqlUtil.likePattern(crmPersonVo.getCertifNo()));
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CrmPerson> pageInfo = crmPersonRepository.selectListByExamplePage(example,crmPersonVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存CRM个人信息
     * @param crmPersonSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public void saveCrmPerson(CrmPersonSaveVo crmPersonSaveVo){
        String finassCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMPER_CODE.getType());
        crmPersonSaveVo.setFinassCstmCode(finassCstmCode);
        crmPersonRepository.insertData(crmPersonSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改CRM个人信息
     * @param crmPersonModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public void modifyCrmPerson(CrmPersonModifyVo crmPersonModifyVo){
        crmPersonRepository.updateByPrimaryKeySelectiveData(crmPersonModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过personId删除CRM个人信息
     * @param crmPersonDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public void deleteCrmPerson(CrmPersonDeleteVo crmPersonDeleteVo){
        crmPersonRepository.deleteData(crmPersonDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过personId集合删除CRM个人信息
     * @param crmPersonDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public void deleteCrmPersonsByPersonIds(CrmPersonDeleteListVo crmPersonDeleteListVo){
        crmPersonRepository.deleteDataList(crmPersonDeleteListVo.getPersonIds(),crmPersonDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据personId获取CRM个人信息
     * @param personId
     * @return CrmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public CrmPerson findCrmPersonByPersonId(String personId){
        return crmPersonRepository.selectByPrimaryKey(personId);
    }

    /**
     * @Title:
     * @Description:  根据证件号码获取CRM个人信息
     * @param certifNo
     * @return CrmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public CrmPersonCarrierVo findCrmPersonByCertifNo(String certifNo) {
        Example example = SqlUtil.newExample(CrmPerson.class);
        example.createCriteria().andEqualTo("certifNo",certifNo);
        CrmPerson crmPerson =  crmPersonRepository.selectOneByExample(example);
        if(crmPerson!=null){
            CrmPersonCarrierVo crmCarrierVo = new CrmPersonCarrierVo();
            //申请录入的个人基本信息
            crmCarrierVo.setCstmPerson(EntityUtils.getEntity(crmPerson,new CstmPerson()));
            //申请录入的配偶信息
            crmCarrierVo.setCstmPersMate(EntityUtils.getEntity(crmPerson,new CstmPersMate()));
            //申请录入的担保人信息
            crmCarrierVo.setGuaranteePers(EntityUtils.getEntity(crmPerson,new GuaranteePers()));
            //申请录入的个人职业信息
            crmCarrierVo.setCstmPersJob(EntityUtils.getEntity(crmPerson,new CstmPersJob()));
            //申请录入的个人地址信息
            crmCarrierVo.setCstmPersAddr(EntityUtils.getEntity(crmPerson,new CstmPersAddr()));
            //申请录入的共同借款人信息
            crmCarrierVo.setCommonBorrower(EntityUtils.getEntity(crmPerson,new CommonBorrower()));
            //担保人的配偶信息
            crmCarrierVo.setGuaranteeMate(getGuaranteeMateFromCrmper(crmPerson));
            return crmCarrierVo;
        }
        return new CrmPersonCarrierVo();
    }

    /**
     * @Title:
     * @Description: 将crm信息转为担保人配偶信息
     * @param crmPerson
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public GuaranteeMate getGuaranteeMateFromCrmper(CrmPerson crmPerson){
        GuaranteeMate guaranteeMate = new GuaranteeMate();
        guaranteeMate.setMateName(crmPerson.getName());
        guaranteeMate.setMateCertifType(crmPerson.getCertifType());
        guaranteeMate.setMateCertifNo(crmPerson.getCertifNo());
        guaranteeMate.setMateMobileNo(crmPerson.getMobileNo());
        guaranteeMate.setMateCompName(crmPerson.getCompName());
        guaranteeMate.setMateCompTel(crmPerson.getCompTel());
        guaranteeMate.setMatePosition(crmPerson.getPosition());
        guaranteeMate.setMateSalary(crmPerson.getSalary());
        guaranteeMate.setMateCompProv(crmPerson.getCompProv());
        guaranteeMate.setMateCompCity(crmPerson.getCompCity());
        guaranteeMate.setMateCompCounty(crmPerson.getCompCounty());
        guaranteeMate.setMateCompAddr(crmPerson.getCompAddr());
        return guaranteeMate;
    }


    /**
     * @Title:
     * @Description: 将前台传入的融资信息转为crm个人信息
     * @param applyInputVo
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public void getCrmPersonFromInputVo(ApplyInputVo applyInputVo) {
        //保存主贷人信息
        if(applyInputVo.getCstmPerson()!=null){
            CrmPerson crmPerson  =  EntityUtils.getEntity(applyInputVo.getCstmPerson(),new CrmPerson());
            if(applyInputVo.getCstmPersMate()!=null){
                crmPerson.setMateName(applyInputVo.getCstmPersMate().getName());
                crmPerson.setMateCertifType(applyInputVo.getCstmPersMate().getCertifType());
                crmPerson.setMateCertifNo(applyInputVo.getCstmPersMate().getCertifNo());
            }
            if(applyInputVo.getCstmPersJob()!=null){
                crmPerson  =  EntityUtils.getEntity(applyInputVo.getCstmPersJob(),crmPerson);
            }
            if(applyInputVo.getCstmPersAddr()!=null){
                crmPerson = EntityUtils.getEntity(applyInputVo.getCstmPersAddr(),crmPerson);
            }
            Example example = SqlUtil.newExample(CrmPerson.class);
            example.createCriteria().andEqualTo("certifNo",crmPerson.getCertifNo());
            CrmPerson crmPerson1 = crmPersonRepository.selectOneByExample(example);
            if(crmPerson1 == null){
                String finassCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMPER_CODE.getType());
                crmPerson.setFinassCstmCode(finassCstmCode);
                crmPersonRepository.insertData(crmPerson);
            }
            else
                crmPersonRepository.updateByExampleSelectiveData(crmPerson,example);
        }
        //配偶信息
        if(applyInputVo.getCstmPersMate()!=null){
            if(applyInputVo.getCstmPersMate().getCertifNo()!=null){
                CrmPerson crmPerson =  EntityUtils.getEntity(applyInputVo.getCstmPersMate(),new CrmPerson());
//                if(crmPerson.getCertifNo().equals(applyInputVo.getCstmPerson().getCertifNo())){
//                    throw new FmsServiceException("配偶证件号码不能与主贷人相同");
//                }
                Example example = SqlUtil.newExample(CrmPerson.class);
                example.createCriteria().andEqualTo("certifNo",crmPerson.getCertifNo());
                CrmPerson crm = crmPersonRepository.selectOneByExample(example);
                if(crm==null){
                    String assCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMPER_CODE.getType());
                    crmPerson.setFinassCstmCode(assCstmCode);
                    crmPersonRepository.insertData(crmPerson);
                }
                else
                    crmPersonRepository.updateByExampleSelectiveData(crmPerson,example);
            }

        }
        //担保人信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteePersList())){
            for(GuaranteePers guaranteePers:applyInputVo.getGuaranteePersList()){
                CrmPerson crmPerson = EntityUtils.getEntity(guaranteePers,new CrmPerson());
//                if(crmPerson.getCertifNo().equals(applyInputVo.getCstmPerson().getCertifNo())){
//                    throw new FmsServiceException("担保人证件号不能和主贷人相同");
//                }
                Example example = SqlUtil.newExample(CrmPerson.class);
                example.createCriteria().andEqualTo("certifNo",crmPerson.getCertifNo());
                CrmPerson crm = crmPersonRepository.selectOneByExample(example);
                if(crm==null){
                    String assCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMPER_CODE.getType());
                    crmPerson.setFinassCstmCode(assCstmCode);
                    crmPersonRepository.insertData(crmPerson);
                }
                else
                    crmPersonRepository.updateByExampleSelectiveData(crmPerson,example);
            }
        }
        //共同借款人
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCommonBorrowerList())){
            for(CommonBorrower commonBorrower:applyInputVo.getCommonBorrowerList()){
                CrmPerson crmPerson = EntityUtils.getEntity(commonBorrower,new CrmPerson());
                Example example = SqlUtil.newExample(CrmPerson.class);
                example.createCriteria().andEqualTo("certifNo",crmPerson.getCertifNo());
                CrmPerson crm = crmPersonRepository.selectOneByExample(example);
                if(crm==null){
                    String assCstmCode =  numGenerateService.getNumGenerateByNumType(NumTypeEnums.FINASS_CSTMPER_CODE.getType());
                    crmPerson.setFinassCstmCode(assCstmCode);
                    crmPersonRepository.insertData(crmPerson);
                }else{
                    crmPersonRepository.updateByExampleSelectiveData(crmPerson,example);
                }
            }
        }
    }

    @Override
    public CrmPerson findCrmPerByCertifNo(String certifNo) {
        Example example = SqlUtil.newExample(CrmPerson.class);
        example.createCriteria().andEqualTo("certifNo",certifNo);
        CrmPerson crm = crmPersonRepository.selectOneByExample(example);
        if(crm==null){
            return null;
        }else{
            return crm;
        }
    }


    /**
     * @Title:
     * @Description:  将crmperson转为主贷人
     * @param crmPerson
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public CstmPerson getCstmPersonFromCrmPerson(CrmPerson crmPerson){
        CstmPerson cstmPerson = new CstmPerson();
        cstmPerson.setName(crmPerson.getName());
        cstmPerson.setCertifType(crmPerson.getCertifType());
        cstmPerson.setCertifNo(crmPerson.getCertifNo());
        cstmPerson.setSex(crmPerson.getSex());
        cstmPerson.setMarriageStatus(crmPerson.getMarriageStatus());
        cstmPerson.setCensusType(crmPerson.getCensusType());
        cstmPerson.setBirthDate(crmPerson.getBirthDate());
        cstmPerson.setEduBgType(crmPerson.getEduBgType());
        cstmPerson.setMobileNo(crmPerson.getMobileNo());
        cstmPerson.setTelNo(crmPerson.getTelNo());
        cstmPerson.setQqNo(crmPerson.getQqNo());
        cstmPerson.setWechatNo(crmPerson.getCertifNo());
        cstmPerson.setMail(crmPerson.getMail());
        cstmPerson.setEthnicType(crmPerson.getEthnicType());
        cstmPerson.setLicenseNo(crmPerson.getLicenseNo());
        return cstmPerson;
    }
    /**
     * @Title:
     * @Description:  将crmperson转为担保人
     * @param crmPerson
     * @return GuaranteePers
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
     public GuaranteePers getGuaranteePersonFromCrmPerson(CrmPerson crmPerson){
         GuaranteePers guaranteePers = new GuaranteePers();
         guaranteePers.setName(crmPerson.getName());
         guaranteePers.setCertifType(crmPerson.getCertifType());
         guaranteePers.setCertifNo(crmPerson.getCertifNo());
         guaranteePers.setSex(crmPerson.getSex());
         guaranteePers.setBirthDate(crmPerson.getBirthDate());
         guaranteePers.setMobileNo(crmPerson.getMobileNo());
         guaranteePers.setTelNo(crmPerson.getTelNo());
         guaranteePers.setResideProv(crmPerson.getResideProv());
         guaranteePers.setResideCity(crmPerson.getResideCity());
         guaranteePers.setResideCounty(crmPerson.getResideCounty());
         guaranteePers.setResideAddr(crmPerson.getResideAddr());
         guaranteePers.setCompName(crmPerson.getCompName());
         guaranteePers.setCompTel(crmPerson.getCompTel());
         guaranteePers.setWorkYear(crmPerson.getWorkYear());
         guaranteePers.setProfession(crmPerson.getProfession());
         guaranteePers.setPosition(crmPerson.getPosition());
         guaranteePers.setIndustry(crmPerson.getIndustry());
         guaranteePers.setCompProv(crmPerson.getCompProv());
         guaranteePers.setCompCity(crmPerson.getCompCity());
         guaranteePers.setCompCounty(crmPerson.getCompCounty());
         guaranteePers.setCompAddr(crmPerson.getCompAddr());
         guaranteePers.setSalary(crmPerson.getSalary());
         return guaranteePers;
     }
    /**
     * @Title:
     * @Description:  将配偶信息转为crmPerson
     * @param cstmPersMate
     * @return CrmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
      public CrmPerson getCrmPersonFromCstmMate(CstmPersMate cstmPersMate){
          CrmPerson crmPerson = new CrmPerson();
          crmPerson.setName(cstmPersMate.getName());
          crmPerson.setCertifType(cstmPersMate.getCertifType());
          crmPerson.setCertifNo(cstmPersMate.getCertifNo());
          crmPerson.setMobileNo(cstmPersMate.getMobileNo());
          crmPerson.setCompName(cstmPersMate.getCompName());
          crmPerson.setCompTel(cstmPersMate.getCompTel());
          crmPerson.setPosition(cstmPersMate.getPosition());
          crmPerson.setSalary(cstmPersMate.getSalary());
          crmPerson.setCompProv(cstmPersMate.getCompProv());
          crmPerson.setCompCity(cstmPersMate.getCompCity());
          crmPerson.setCompCounty(cstmPersMate.getCompCounty());
          crmPerson.setCompAddr(cstmPersMate.getCompAddr());
          return null;
      }
}
