package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CstmRelationIdentityTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.prebiz.service.CstmRelationService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmRelationRepository;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmrelation.CstmRelationVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationService
 * @Description: 融资申请客户关系业务实现层
 * @date 2018-05-16
 */
@Service
public class CstmRelationServiceImpl implements CstmRelationService {

    /**
     * @Fields  : 融资申请客户关系repository
     */
    @Autowired
    private CstmRelationRepository cstmRelationRepository;

    /**
     * @Title:
     * @Description: 分页查询融资申请客户关系
     * @param cstmRelationVo
     * @return PageInfoExtend<CstmRelation>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public PageInfoExtend<CstmRelation> findCstmRelationsByPage(CstmRelationVo cstmRelationVo){
        Example example = SqlUtil.newExample(CstmRelation.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmRelation> pageInfo = cstmRelationRepository.selectListByExamplePage(example,cstmRelationVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存融资申请客户关系
     * @param cstmRelationSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public void saveCstmRelation(CstmRelationSaveVo cstmRelationSaveVo){
        cstmRelationRepository.insertData(cstmRelationSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改融资申请客户关系
     * @param cstmRelationModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public void modifyCstmRelation(CstmRelationModifyVo cstmRelationModifyVo){
        cstmRelationRepository.updateByPrimaryKeySelectiveData(cstmRelationModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过relationId删除融资申请客户关系
     * @param cstmRelationDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public void deleteCstmRelation(CstmRelationDeleteVo cstmRelationDeleteVo){
        cstmRelationRepository.deleteData(cstmRelationDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过relationId集合删除融资申请客户关系
     * @param cstmRelationDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public void deleteCstmRelationsByRelationIds(CstmRelationDeleteListVo cstmRelationDeleteListVo){
        cstmRelationRepository.deleteDataList(cstmRelationDeleteListVo.getRelationIds(),cstmRelationDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据relationId获取融资申请客户关系
     * @param relationId
     * @return CstmRelation
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public CstmRelation findCstmRelationByRelationId(String relationId){
        return cstmRelationRepository.selectByPrimaryKey(relationId);
    }

    /**
     * @Title:
     * @Description: 保存融资申请客户关系
     * @param applyInputVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:13:22
     */
    @Transactional
    public void saveApplyRelation(ApplyInputVo applyInputVo){
        List<CstmRelation> cstmRelations = new ArrayList<>();
        String relationLenderId = null;
        if(ApplyTypeEnums.PERSON.getType().equals(applyInputVo.getApplyType())) {
            //客户个人基本信息
            CstmRelation cstmPerson = getCstmRelation(applyInputVo.getApplyNo(),
                    applyInputVo.getCstmPerson().getCertifNo(),
                    applyInputVo.getCstmPerson().getMobileNo(),
                    applyInputVo.getCstmPerson().getName(),
                    null,
                    CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER);
            cstmRelations.add(cstmPerson);
            relationLenderId = cstmPerson.getRelationId();
        }else if(ApplyTypeEnums.COMPANY.getType().equals(applyInputVo.getApplyType())){
            //客户企业基本信息
            applyInputVo.getCstmCompany();
            CstmRelation cstmCompany = getCstmRelation(applyInputVo.getApplyNo(),
                    applyInputVo.getCstmCompany().getCertifNo(),
                    applyInputVo.getCstmCompany().getMobileNo(),
                    applyInputVo.getCstmCompany().getName(),
                    null,
                    CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER);
            cstmRelations.add(cstmCompany);
            relationLenderId = cstmCompany.getRelationId();
        }else{
            throw new FmsServiceException("申请类型不存在");
        }

        //客户个人配偶信息
        if(applyInputVo.getCstmPersMate() != null) {
            CstmRelation cstmPersMate = getCstmRelation(applyInputVo.getApplyNo(),
                    applyInputVo.getCstmPersMate().getCertifNo(),
                    applyInputVo.getCstmPersMate().getMobileNo(),
                    applyInputVo.getCstmPersMate().getName(),
                    relationLenderId,
                    CstmRelationIdentityTypeEnums.MATE
            );
            cstmRelations.add(cstmPersMate);
        }


        //客户联系人信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getCstmContactList())){
            for(CstmContact tmp : applyInputVo.getCstmContactList()){
                CstmRelation cstmContact = getCstmRelation(applyInputVo.getApplyNo(),
                        "",tmp.getMobileNo(),tmp.getName(),relationLenderId,CstmRelationIdentityTypeEnums.CONTACT
                );
                cstmRelations.add(cstmContact);
            }

        }

        //担保个人信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteePersList())){
            for(GuaranteePers tmp : applyInputVo.getGuaranteePersList()){
                CstmRelation guaranteePers = getCstmRelation(applyInputVo.getApplyNo(),
                        tmp.getCertifNo(),tmp.getMobileNo(),tmp.getName(),relationLenderId,CstmRelationIdentityTypeEnums.GUARANTEE_PERSON
                        );
                cstmRelations.add(guaranteePers);
            }
        }

        //担保企业信息
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getGuaranteeCompList())) {
            for(GuaranteeComp tmp : applyInputVo.getGuaranteeCompList()){
                CstmRelation guaranteeComp = getCstmRelation(applyInputVo.getApplyNo(),
                        tmp.getCertifNo(),tmp.getMobileNo(),tmp.getName(),relationLenderId,CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY
                );
                cstmRelations.add(guaranteeComp);
            }
        }
        cstmRelationRepository.insertDataList(cstmRelations);
    }

    private CstmRelation getCstmRelation(String applyNo,String certifNo,String mobileNo,String name,
                                         String relationLenderId,CstmRelationIdentityTypeEnums enums){
        CstmRelation cstmrelation = new CstmRelation();
        cstmrelation.setRelationId(UUIDUtils.getUUID());
        cstmrelation.setApplyNo(applyNo);
        cstmrelation.setCertifNo(certifNo);
        cstmrelation.setMobileNo(mobileNo);
        cstmrelation.setName(name);
        cstmrelation.setRelationLenderId(relationLenderId);
        cstmrelation.setIdentityTypeCode(enums.getCode());
        cstmrelation.setIdentityTypeName(enums.getType());
        return cstmrelation;
    }

    /**
     * @Title:
     * @Description:   根据申请编号拿到对应的客户信息
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/16 03:43:21
     */
    public List<CstmRelation> findCstmRelationsByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(CstmRelation.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return cstmRelationRepository.selectListByExample(example);
    }


}
