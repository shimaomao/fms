package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.baseinfo.rpc.system.SysGroupRpc;
import cn.com.leadu.fms.baseinfo.service.BasPartnerService;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerModifyVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerSaveVo;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasPartnerRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author huchenghao
 * @ClassName: BasPartnerService
 * @Description: 经销商信息维护业务实现层
 * @date 2018-03-17
 */
@Slf4j
@Service
public class BasPartnerServiceImpl implements BasPartnerService {

    /**
     * @Fields  : 经销商信息维护repository
     */
    @Autowired
    private BasPartnerRepository basPartnerRepository;

    @Autowired
    private SysGroupRpc sysGroupRpc;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    /**
     * @Fields  : 附件service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询经销商信息维护
     * @param basPartnerVo
     * @return PageInfoExtend<BasPartner>
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public PageInfoExtend<BasPartner> findBasPartnersByPage(BasPartnerVo basPartnerVo){
        Example example = SqlUtil.newExample(BasPartner.class);
        Example.Criteria criteria = example.createCriteria();
        //条件：经销商代码
        if(StringUtils.isNotTrimBlank(basPartnerVo.getPartnerCode())){
            criteria.andLike("partnerCode",SqlUtil.likePattern(basPartnerVo.getPartnerCode()));
        }
        //条件：经销商名称
        if(StringUtils.isNotTrimBlank(basPartnerVo.getPartnerName())){
            criteria.andLike("partnerName",SqlUtil.likePattern(basPartnerVo.getPartnerName()));
        }

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BasPartner> pageInfo = basPartnerRepository.selectListByExamplePage(example,basPartnerVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存经销商信息维护
     * @param basPartnerSaveVo
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Transactional
    public String saveBasPartner(BasPartnerSaveVo basPartnerSaveVo){
        String flag=""; //flag=1 覆盖用户组信息 flag=2新增用户组信息
        SysGroupVo sysGroupVo = new SysGroupVo();
        sysGroupVo.setGroupCode(basPartnerSaveVo.getPartnerCode());
        sysGroupVo.setGroupNameShort(basPartnerSaveVo.getPartnerNameShort());
        sysGroupVo.setGroupName(basPartnerSaveVo.getPartnerName());
        sysGroupVo.setGroupLev(basPartnerSaveVo.getGroupLev());
        sysGroupVo.setParentGroup(basPartnerSaveVo.getParentGroupCode());
        try {
             flag = ResponseEntityUtils.getRestResponseData(sysGroupRpc.getBasPartnerStatus(sysGroupVo));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        // 保存附件信息
        bizFilesService.modifyBizFilesList(basPartnerSaveVo.getBizFilesList(),basPartnerSaveVo.getPartnerCode(),
                BizCodeTypeEnums.PARTNER.getCodeType());
//        bizFilesService.saveBizFiles(basPartnerSaveVo.getBizfilesVo().getBizFilesListVos(),basPartnerSaveVo.getPartnerCode(), BizCodeTypeEnums.PARTNER.getCodeType());
        basPartnerRepository.insertData(basPartnerSaveVo.getEntity());
        return flag;
    }

    /**
     * @Title:
     * @Description: 修改经销商信息维护
     * @param basPartnerModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public String modifyBasPartner(BasPartnerModifyVo basPartnerModifyVo){
        //修改经销商信息，覆盖
        String flag = "2";
        SysGroupVo sysGroupVo = new SysGroupVo();
        sysGroupVo.setGroupCode(basPartnerModifyVo.getPartnerCode());
        sysGroupVo.setGroupNameShort(basPartnerModifyVo.getPartnerNameShort());
        sysGroupVo.setGroupName(basPartnerModifyVo.getPartnerName());
        sysGroupVo.setGroupLev(basPartnerModifyVo.getGroupLev());
        sysGroupVo.setParentGroup(basPartnerModifyVo.getParentGroupCode());
        try {
            ResponseEntityUtils.getRestResponseData(sysGroupRpc.getBasPartnerStatus(sysGroupVo));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        // 修改附件信息
        bizFilesService.modifyBizFilesList(basPartnerModifyVo.getBizFilesList(),basPartnerModifyVo.getPartnerCode(),
                BizCodeTypeEnums.PARTNER.getCodeType());
//        bizFilesService.updateBizFiles(basPartnerModifyVo.getBizfilesVo().getBizFilesListVos(),basPartnerModifyVo.getPartnerCode(),BizCodeTypeEnums.PARTNER.getCodeType());
        basPartnerRepository.updateByPrimaryKeySelectiveData(basPartnerModifyVo.getEntity());
        return flag;
    }

    /**
     * @Title:
     * @Description:  通过partnerId删除经销商信息维护
     * @param basPartnerDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public void deleteBasPartner(BasPartnerDeleteVo basPartnerDeleteVo){
        basPartnerRepository.deleteData(basPartnerDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过partnerId集合删除经销商信息维护
     * @param basPartnerDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public void deleteBasPartnersByPartnerIds(BasPartnerDeleteListVo basPartnerDeleteListVo){
        basPartnerRepository.deleteDataList(basPartnerDeleteListVo.getPartnerIds(),basPartnerDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据partnerId获取经销商信息维护
     * @param partnerId
     * @return BasPartner
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public BasPartnerVo findBasPartnerByPartnerId(String partnerId){
        BasPartnerVo basPartnerVo=new BasPartnerVo();
        basPartnerVo=basPartnerRepository.findBasPartnerByPartnerId(partnerId);

        basPartnerVo.setBizFilesList(bizFilesService.findBizFilesList(basPartnerVo.getPartnerCode(), BizCodeTypeEnums.PARTNER.getCodeType()));
//        try {
//            CommonBizFilesVo bizFilesVo=ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesByBizCode(basPartnerVo.getPartnerCode()));
//            basPartnerVo.setBizfilesVo(bizFilesVo);
//        }catch (FmsRpcException ex){
//            log.error(ex.getMessage());
//            ex.printStackTrace();
//        }
        return  basPartnerVo;
    }

    /**
     * @Title:
     * @Description:  根据当经销商代码，获取经销商信息
     * @param partnerCode
     * @return
     * @throws
     * @author wangxuecontract_fin
     * @date 2018-3-22 19:35:32
     */
    @Override
    public BasPartner findBasPartnerByPartnerCode(String partnerCode) {
        Example example = SqlUtil.newExample(BasPartner.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("partnerCode",partnerCode);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return basPartnerRepository.selectOneByExample(example);
    }
}
