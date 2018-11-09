package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.prebiz.service.CstmContactService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmContactRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactService
 * @Description: 客户联系人信息业务实现层
 * @date 2018-03-27
 */
@Service
public class CstmContactServiceImpl implements CstmContactService {

    /**
     * @Fields  : 客户联系人信息repository
     */
    @Autowired
    private CstmContactRepository cstmContactRepository;
    /**
     * 枚举类
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询客户联系人信息
     * @param cstmContactVo
     * @return PageInfoExtend<CstmContact>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public PageInfoExtend<CstmContact> findCstmContactsByPage(CstmContactVo cstmContactVo){
        Example example = SqlUtil.newExample(CstmContact.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmContact> pageInfo = cstmContactRepository.selectListByExamplePage(example,cstmContactVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 批量保存客户联系人信息
     * @param cstmContactList
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public void saveCstmContact(List<CstmContact> cstmContactList,String applyNo){
        //获取订单编号
        //String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());

        for (CstmContact cstmContact: cstmContactList) {
            cstmContact.setApplyNo(applyNo);
        }
        cstmContactRepository.insertDataList(cstmContactList);
    }

    /**
     * @Title:
     * @Description: 修改客户联系人信息
     * @param cstmContactModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public void modifyCstmContact(CstmContactModifyVo cstmContactModifyVo){
        cstmContactRepository.updateByPrimaryKeySelectiveData(cstmContactModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contactId删除客户联系人信息
     * @param cstmContactDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public void deleteCstmContact(CstmContactDeleteVo cstmContactDeleteVo){
        cstmContactRepository.deleteData(cstmContactDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contactId集合删除客户联系人信息
     * @param cstmContactDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public void deleteCstmContactsByContactIds(CstmContactDeleteListVo cstmContactDeleteListVo){
        cstmContactRepository.deleteDataList(cstmContactDeleteListVo.getContactIds(),cstmContactDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contactId获取客户联系人信息
     * @param contactId
     * @return CstmContact
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    public CstmContact findCstmContactByContactId(String contactId){
        return cstmContactRepository.selectByPrimaryKey(contactId);
    }

    /**
     * 根据订单号得到联系人信息
     * @param applyNo
     * @return
     */
    public List<CstmContact> findCstmContactsByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(CstmContact.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        if(cstmContactRepository.selectListByExample(example) == null){
            List<CstmContact> cstmContactList = new ArrayList<>();
            return cstmContactList;
        }
        return cstmContactRepository.selectListByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据applyNo更新客户联系人信息
     * @param cstmContactList
     * @return CstmContact
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:44
     */
    @Override
    public void updateCstmContactsByApplyNo(List<CstmContact> cstmContactList,String applyNo) {
        Example example = SqlUtil.newExample(CstmContact.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        List<CstmContact>  CstmContactGetList =  cstmContactRepository.selectListByExample(example);
        List<CstmContact> CstmContactAddList = new ArrayList<>();
        List<CstmContact> CstmContactUpdList = new ArrayList<>();
        List<CstmContact> CstmContactKeepList = new ArrayList<>();
        if(cstmContactList.size()!=0){
            //CstmContactGetList.removeAll(cstmContactList);
            for(CstmContact cstmcon:cstmContactList){
                if(StringUtils.isTrimBlank(cstmcon.getContactId())){
                    cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }else{
                    CstmContactUpdList.add(cstmcon);
                }
                if(CstmContactGetList.size()!=0){
                    for(CstmContact con:CstmContactGetList){
                        if(con.getContactId().equals(cstmcon.getContactId())){
                            CstmContactKeepList.add(con);
                            break;
                        }
                    }
                }
            }
            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
            if(CstmContactGetList.size()>0){
                for(CstmContact con: CstmContactGetList){
                    cstmContactRepository.deleteData(con);
                }
            }
            cstmContactRepository.insertDataList(CstmContactAddList);
            cstmContactRepository.updateByPrimaryKeySelectiveDataList(CstmContactUpdList);

        }else{
            cstmContactRepository.deleteExampleData(example,new CstmContact());
        }
    }

}
