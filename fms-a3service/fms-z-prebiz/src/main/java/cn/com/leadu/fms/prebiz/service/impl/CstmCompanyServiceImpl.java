package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.prebiz.service.CstmCompanyService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmCompanyRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanySaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyService
 * @Description: 客户企业基本信息业务实现层
 * @date 2018-03-27
 */
@Service
public class CstmCompanyServiceImpl implements CstmCompanyService {

    /**
     * @Fields  : 客户企业基本信息repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;
    /**
     * 枚举类
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息
     * @param cstmCompanyVo
     * @return PageInfoExtend<CstmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public PageInfoExtend<CstmCompany> findCstmCompanysByPage(CstmCompanyVo cstmCompanyVo){
        Example example = SqlUtil.newExample(CstmCompany.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmCompany> pageInfo = cstmCompanyRepository.selectListByExamplePage(example,cstmCompanyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存客户企业基本信息
     * @param cstmCompanySaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public void saveCstmCompany(CstmCompanySaveVo cstmCompanySaveVo,String applyNo){
        //获取订单编号
        //String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
        CstmCompany cstmCompany = cstmCompanySaveVo.getEntity();
        cstmCompany.setApplyNo(applyNo);
        cstmCompanyRepository.insertData(cstmCompany);
    }

    /**
     * @Title:
     * @Description: 修改客户企业基本信息
     * @param cstmCompanyModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public void modifyCstmCompany(CstmCompanyModifyVo cstmCompanyModifyVo){
        cstmCompanyRepository.updateByPrimaryKeySelectiveData(cstmCompanyModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过cstmCompanyId删除客户企业基本信息
     * @param cstmCompanyDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public void deleteCstmCompany(CstmCompanyDeleteVo cstmCompanyDeleteVo){
        cstmCompanyRepository.deleteData(cstmCompanyDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过cstmCompanyId集合删除客户企业基本信息
     * @param cstmCompanyDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public void deleteCstmCompanysByCstmCompanyIds(CstmCompanyDeleteListVo cstmCompanyDeleteListVo){
        cstmCompanyRepository.deleteDataList(cstmCompanyDeleteListVo.getCstmCompanyIds(),cstmCompanyDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据cstmCompanyId获取客户企业基本信息
     * @param cstmCompanyId
     * @return CstmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public CstmCompany findCstmCompanyByCstmCompanyId(String cstmCompanyId){
        return cstmCompanyRepository.selectByPrimaryKey(cstmCompanyId);
    }

    /**
     * 根据订单号得到企业信息
     * @param applyNo
     * @return
     */
    public CstmCompany findCstmCompanyByApplyNo(String applyNo){
        Example example =  SqlUtil.newExample(CstmCompany.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return cstmCompanyRepository.selectOneByExample(example);
    }

    /**
     * @param applyNo
     * @Description: 根据socialCertifNo获取所有企业信息,排除applyNo
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 11:33
     */
    @Override
    public List<CstmCompany> findCstmCompanyListBySocialCertifNo(String socialCertifNo,String applyNo) {
//        Example example =  SqlUtil.newExample(CstmCompany.class);
//        example.createCriteria().andEqualTo("socialCertifNo",socialCertifNo).andNotEqualTo("applyNo",applyNo);
//        return cstmCompanyRepository.selectListByExample(example);
        if(StringUtils.isTrimBlank(socialCertifNo)){
            throw new FmsServiceException("统一社会信用代码不能为空");
        }
        Example example = SqlUtil.newExample(CstmCompany.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("socialCertifNo", socialCertifNo);
        if(StringUtils.isNotTrimBlank(applyNo)){
            criteria.andNotEqualTo("applyNo",applyNo);
        }
        return cstmCompanyRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据applyNo更新客户企业基本信息
     * @param cstmCompany
     * @return CstmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public void updateCstmCompanyByApplyNo(CstmCompany cstmCompany,String applyNo) {
        if(StringUtils.isNotTrimBlank(applyNo)){
            Example example =  SqlUtil.newExample(CstmCompany.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            CstmCompany oldCstmCompany = cstmCompanyRepository.selectOneByExample(example);
            cstmCompany.setApplyNo(applyNo);
            cstmCompany.setDelFlag(DeleteFlags.EXIST.getFlag());
            if(oldCstmCompany != null){
                cstmCompany.setCreateTime(oldCstmCompany.getCreateTime());
                cstmCompany.setCreator(oldCstmCompany.getCreator());
            }
            cstmCompanyRepository.updateByExampleData(cstmCompany,example);
        }
    }
}
