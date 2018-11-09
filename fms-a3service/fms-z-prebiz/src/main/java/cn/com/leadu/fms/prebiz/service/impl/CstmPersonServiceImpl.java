package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.prebiz.service.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonService
 * @Description: 客户个人基本信息业务实现层
 * @date 2018-03-26
 */
@Service
public class CstmPersonServiceImpl implements CstmPersonService {

    /**
     * @Fields  : 客户个人基本信息repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;

    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息
     * @param cstmPersonVo
     * @return PageInfoExtend<CstmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public PageInfoExtend<CstmPerson> findCstmPersonsByPage(CstmPersonVo cstmPersonVo){
        Example example = SqlUtil.newExample(CstmPerson.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmPerson> pageInfo = cstmPersonRepository.selectListByExamplePage(example,cstmPersonVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存客户个人基本信息
     * @param cstmPersonSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Transactional
    public void saveCstmPerson(CstmPersonSaveVo cstmPersonSaveVo,String applyNo){
        //获取订单编号
      // String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
        CstmPerson cstmPerson = EntityUtils.getEntity(cstmPersonSaveVo,new CstmPerson());//个人基本信息
        cstmPerson.setApplyNo(applyNo);
            cstmPersonRepository.insertData(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 修改客户个人基本信息
     * @param cstmPersonModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public void modifyCstmPerson(CstmPersonModifyVo cstmPersonModifyVo){
        cstmPersonRepository.updateByPrimaryKeySelectiveData(cstmPersonModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过cstmPersonId删除客户个人基本信息
     * @param cstmPersonDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public void deleteCstmPerson(CstmPersonDeleteVo cstmPersonDeleteVo){
        cstmPersonRepository.deleteData(cstmPersonDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过cstmPersonId集合删除客户个人基本信息
     * @param cstmPersonDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public void deleteCstmPersonsByCstmPersonIds(CstmPersonDeleteListVo cstmPersonDeleteListVo){
        cstmPersonRepository.deleteDataList(cstmPersonDeleteListVo.getCstmPersonIds(),cstmPersonDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据cstmPersonId获取客户个人基本信息
     * @param cstmPersonId
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public CstmPerson findCstmPersonByCstmPersonId(String cstmPersonId){
        return cstmPersonRepository.selectByPrimaryKey(cstmPersonId);
    }

    /**
     * @Description: 根据订单编号获取客户信息
     * @param: [applyNo]
     * @return: cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson
     * @Author: yangyiquan
     * @Date: 2018/7/13 16:31
     */
    public CstmPerson findCstmPersonByApplyNo(String applyNo){
        if(StringUtils.isTrimBlank(applyNo)){
            throw new FmsServiceException("申请编号不能为空");
        }
        Example example = SqlUtil.newExample(CstmPerson.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        CstmPerson cstmPerson =  cstmPersonRepository.selectOneByExample(example);
        return cstmPerson;
    }

    /**
     * @Description: 根据certifNo获取所有客户信息,排除applyNo
     * @param: [certifNo, applyNo]
     * @return: java.util.List<cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson>
     * @Author: yangyiquan
     * @Date: 2018/7/13 16:30
     */
    @Override
    public List<CstmPerson> findCstmPersonListByCertifNo(String certifNo,String applyNo) {
        if(StringUtils.isTrimBlank(certifNo)){
            throw new FmsServiceException("证件号码不能为空");
        }
        Example example = SqlUtil.newExample(CstmPerson.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("certifNo", certifNo);
        if(StringUtils.isNotTrimBlank(applyNo)){
            criteria.andNotEqualTo("applyNo",applyNo);
        }
        return cstmPersonRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据applyNo更新客户个人基本信息
     * @param cstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public void updateCstmpersonByapplyNo(CstmPerson cstmPerson,String applyNo) {
        if(StringUtils.isNotTrimBlank(applyNo)) {
            Example example = SqlUtil.newExample(CstmPerson.class);
            example.createCriteria().andEqualTo("applyNo", applyNo);
            CstmPerson oldCstmProson = cstmPersonRepository.selectOneByExample(example);
            cstmPerson.setApplyNo(applyNo);
            cstmPerson.setDelFlag(DeleteFlags.EXIST.getFlag());
            if(oldCstmProson != null){
                cstmPerson.setCreateTime(oldCstmProson.getCreateTime());
                cstmPerson.setCreator(oldCstmProson.getCreator());
            }
            cstmPersonRepository.updateByExampleData(cstmPerson, example);
        }
    }

}
