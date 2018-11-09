package cn.com.leadu.fms.original.service.impl;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActOrigFileSortUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InsuranceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.PostStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.LicenseIdxEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.insurance.repository.RenewalRegisterRepository;
import cn.com.leadu.fms.data.original.repository.FileSendRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.postbiz.repository.LicenseIdxRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmCompanyRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersonRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.original.rpc.system.SysCodeRpc;
import cn.com.leadu.fms.original.rpc.system.SysGroupRpc;
import cn.com.leadu.fms.original.service.OrigFileService;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteListVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileModifyVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileSaveVo;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.CstmPersonAddTelVo;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileMailVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.pojo.system.entity.*;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;
import static cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums.ARCHIVED;
import static cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums.VERIFIED;
import static cn.com.leadu.fms.extend.common.util.ResponseEntityUtils.getRestResponseData;

/**
 * @author ningyangyang
 * @ClassName: OrigFileService
 * @Description: 资料邮寄附件业务实现层
 * @date 2018-05-03
 */
@Service
@Slf4j
public class OrigFileServiceImpl implements OrigFileService {

    private static final Logger logger = LoggerFactory.getLogger(OrigFileServiceImpl.class);

    /**
     * @Fields  : 资料邮寄附件repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  : 用户组管理repository
     */
    @Autowired
    private SysGroupRepository sysGroupRepository;

    /**
     * @Fields  : 用户组管理Rpc
     */
    @Autowired
    private SysGroupRpc sysGroupRpc;

    /**
     * @Fields  : 资料邮寄附件明细repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 合同车辆保险信息repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    @Autowired
    private RenewalRegisterRepository renewalRegisterRepository;
    /**
     * @Fields  : 资料邮寄repository
     */
    @Autowired
    private FileSendRepository fileSendRepository;

    /**
     * @Fields  : 数据字典Rpc
     */
    @Autowired
    private SysCodeRpc sysCodeRpc;

    /**
     * @Fields  : 业务编号管理repository
     */
    @Autowired
    private NumGenerateService numGenerateService;

    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private LicenseIdxRepository licenseIdxRepository;
    /**
     * 客户个人信息Repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;

    /**
     * 客户企业信息Repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件
     * @param origFileVo
     * @return PageInfoExtend<OrigFile>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findOrigFilesByPage(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        Example example = SqlUtil.newExample(OrigFile.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("origFileStatus",VERIFIED.getType());
        if(StringUtils.isNotTrimBlank(origFileVo.getBizCodeType())){
            SysCodeVo sysCodeVo = new SysCodeVo();
            sysCodeVo.setCodeType("bizCodeType");
            sysCodeVo.setCodeValueName(origFileVo.getBizCodeType());
            List<String> bizCodeTypeList = new ArrayList<>();
            try {
                Map<String,Object> sysCodeVoMap = sysCodeVo == null?null:(Map) JSON.toJSON(sysCodeVo);
                PageInfoExtend<SysCode> sysCodePageInfo =  ResponseEntityUtils.getRestResponseData(sysCodeRpc.findSysCodesByPage(sysCodeVoMap));
                List<SysCode> sysCodeList = sysCodePageInfo.getData();
                if(ArrayUtils.isNotNullAndLengthNotZero(sysCodeList)){
                    for(SysCode sysCode:sysCodeList){
                        bizCodeTypeList.add(sysCode.getCodeValue());
                    }
                    criteria.andIn("bizCodeType",bizCodeTypeList);
                }else{
                    return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,origFileVo.getPageQuery(),OrigFileVo.class);
                }

            } catch (FmsRpcException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw  new FmsServiceException("获取业务类型失败");
            }

        }
        if(StringUtils.isNotTrimBlank(origFileVo.getBizCode())){
            criteria.andLike("bizCode",SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OrigFile> pageInfo = origFileRepository.selectListByExamplePage(example,origFileVo.getPageQuery());
        PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = new PageInfoExtend<>();  //entity转Vo
        BeanUtils.copyProperties(pageInfo,origFileVoPageInfoExtend,"data");
        List<OrigFile> origFileList = pageInfo.getData();
        String groupCode = sysUser.getGroupCode();       //得到当前登录用户的组织机构
        Example ex1 = SqlUtil.newExample(SysGroup.class);
        ex1.createCriteria().andEqualTo("groupCode",groupCode);
        SysGroup Group =   sysGroupRepository.selectSysGroupVoByGroupCode(ex1);
        List<SysGroupVo> sysGroupsList;
        try {
            sysGroupsList = getRestResponseData(sysGroupRpc.findSysGroupVosByPage()).getData();
        } catch (FmsRpcException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new FmsServiceException("获取用户组失败");
        }
        List<SysGroupVo> sysGroupList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(sysGroupsList)){
            sysGroupList =  CommonTreeDataUtils.getChildResults(sysGroupsList,Group.getGroupCode());
        }
        List<OrigFile> keepOrigFileList  = new ArrayList<>();
        for(OrigFile origFile:origFileList){
            if(ArrayUtils.isNotNullAndLengthNotZero(sysGroupList)){
                List<String> codeList = new ArrayList<>();
                for(SysGroupVo sysGroupVo:sysGroupList){
                    codeList.add(sysGroupVo.getGroupCode());
                }
                if(groupCode.equals(origFile)||codeList.contains(origFile.getOrigFileGroup())){
                    keepOrigFileList.add(origFile);
                }
            }else if(groupCode.equals(origFile)){
                keepOrigFileList.add(origFile);
            }

        }
        if(ArrayUtils.isNotNullAndLengthNotZero(keepOrigFileList)){
            Long totalNum = new Long(keepOrigFileList.size());
            Long filter = new Long(keepOrigFileList.size());
            Date date = new Date();
            List<OrigFileVo> back = new ArrayList<>();
            for(OrigFile origFile:keepOrigFileList){
                OrigFileVo orig =    EntityUtils.getEntity(origFile,new OrigFileVo());
                Long origFileDeadLine = origFile.getOrigDeadline() == null?0:origFile.getOrigDeadline().getTime();
                int remainDays = (int)((origFileDeadLine - date.getTime())/(1000*3600*24));
                if(remainDays>=0){
                    orig.setDaysRemaining(remainDays);
                }
                if(origFile.getOrigFileStatus().equals(ARCHIVED.getType())){
                    //Date actualFilingDate =  new Date(origFile.getUpdateTime().getTime());
                    orig.setActualFilingDate(origFile.getUpdateTime());
                }
                back.add(orig);
            }
            origFileVoPageInfoExtend.setData(back);
            origFileVoPageInfoExtend.setRecordsTotal(totalNum);
            origFileVoPageInfoExtend.setRecordsFiltered(filter);
        }else{
            return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,origFileVo.getPageQuery(),OrigFileVo.class);
        }

        return origFileVoPageInfoExtend;
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件
     * @param origFileVo
     * @param sysUser
     * @return PageInfoExtend<OrigFile>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFileVo findOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser) {
        OrigFileVo origFileVoInfo = origFileRepository.selectOrigFileInfoByBizCodeAndBizCodeType(origFileVo);
        return origFileVoInfo;
    }
    /**
     * @Title:
     * @Description: 分页查询贷前原件归档
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public PageInfoExtend<OrigFileVo> findOrigFileListByPage(OrigFileVo origFileVo,SysUserVo sysUser){
        if(StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        }else{
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        if(StringUtils.isNotExits(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(null);
        }

        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());

        //文件状态
        if(StringUtils.isTrimBlank(origFileVo.getOrigFileDetailStatus())){
            origFileVo.setOrigFileDetailStatus(null);
        }
        //承租人
        if(StringUtils.isTrimBlank(origFileVo.getCstmName()))
            origFileVo.setCstmName(null);
        else
            origFileVo.setCstmName(SqlUtil.likePattern(origFileVo.getCstmName()));

        //车架号
        if(StringUtils.isTrimBlank(origFileVo.getVinNo()))
            origFileVo.setVinNo(null);
        else
            origFileVo.setVinNo(SqlUtil.likePattern(origFileVo.getVinNo()));

        //return origFileRepository.selectListVoByPage("selectOrigFileListByPage",origFileVo,origFileVo.getPageQuery());
        //PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = origFileRepository.selectListVoByPage("selectOrigFileListByPage",origFileVo,origFileVo.getPageQuery());
        PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = screening(origFileVo, sysUser);
        List<OrigFileVo> origFileVoList =  origFileVoPageInfoExtend.getData();
        for(OrigFileVo origFile : origFileVoList){
            if(origFile.getOrigDeadline() != null){
                Calendar calendar = Calendar.getInstance();
                long day =  (origFile.getOrigDeadline().getTime()-calendar.getTime().getTime())/(24*60*60*1000);
                if(!OrigFileStatusEnums.ARCHIVED.getType().equals(origFile.getOrigFileStatus())){
                    origFile.setDaysRemaining(((int)(day+1)));
                }else{
                    origFile.setDaysRemaining(0);
                }
            }else{
                origFile.setDaysRemaining(0);
            }
        }
        //排序
//        Comparator<OrigFileVo> comparator = new Comparator<OrigFileVo>() {
//            public int compare(OrigFileVo s1, OrigFileVo s2) {
//                return s1.getDaysRemaining() - s2.getDaysRemaining();
//            }
//        };
//        if(ArrayUtils.isNotNullAndLengthNotZero(origFileVoList)){
//            Collections.sort(origFileVoList,comparator);
//        }
        origFileVoPageInfoExtend.setData(origFileVoList);
        return origFileVoPageInfoExtend;
    }
    
    /**
     * @Title:  
     * @Description: 分页查询贷前原件归档信息过滤条件
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    public PageInfoExtend<OrigFileVo> screening(OrigFileVo origFileVo, SysUserVo sysUser){
        List<String> roleList = new ArrayList<>();
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        PageInfoExtend<OrigFileVo> pageInfo = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            origFileVo.setSysUser(sysUser.getUser());
            pageInfo = origFileRepository.selectListVoByPage("selectOrigFileListByPage", origFileVo, origFileVo.getPageQuery());
        }else if(roleList.contains(SysRoleEnums.QY.getId())){
            List<String> groupCodes = new ArrayList<>();
            groupCodes.add(sysUser.getGroupCode());
            Example example = SqlUtil.newExample(SysGroupParent.class);
            example.createCriteria().andEqualTo("parentGroup",sysUser.getGroupCode());
            List<SysGroupParent> groups = sysGroupParentRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(groups)){
                for(SysGroupParent group:groups){
                    groupCodes.add(group.getGroupCode());
                }
            }
            origFileVo.setSysUserGroup(groupCodes);
            pageInfo = origFileRepository.selectListVoByPage("selectOrigFileListByPage", origFileVo, origFileVo.getPageQuery());
        }else{
            pageInfo = origFileRepository.selectListVoByPage("selectOrigFileListByPage", origFileVo, origFileVo.getPageQuery());
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询贷前原件归档
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public PageInfoExtend<OrigFileVo> findOrigFileInsListByPage(OrigFileVo origFileVo){
        if(StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        }
        if(StringUtils.isNotExits(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(null);
        }
        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.INSURANCE_TYPE.getType());

        if(StringUtils.isNotTrimBlank(origFileVo.getContNo())){
            origFileVo.setContNo(SqlUtil.likePattern(origFileVo.getContNo()));
        }else{
            origFileVo.setContNo(null);
        }

        //车架号
        if(StringUtils.isTrimBlank(origFileVo.getVinNo()))
            origFileVo.setVinNo(null);
        else
            origFileVo.setVinNo(SqlUtil.likePattern(origFileVo.getVinNo()));

        //承租人
        if (StringUtils.isNotTrimBlank(origFileVo.getCstmName())){
            origFileVo.setCstmName(SqlUtil.likePattern(origFileVo.getCstmName()));
        } else {
            origFileVo.setCstmName(null);
        }

        PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = origFileRepository.selectListVoByPage("selectOrigFileInsListByPage",origFileVo,origFileVo.getPageQuery());
        List<OrigFileVo> origFileVoList =  origFileVoPageInfoExtend.getData();
        for(OrigFileVo origFile : origFileVoList){
            if(origFile.getOrigDeadline() != null){
                Calendar calendar = Calendar.getInstance();
                long day =  (origFile.getOrigDeadline().getTime()-calendar.getTime().getTime())/(24*60*60*1000) + 1;
                if(!OrigFileStatusEnums.ARCHIVED.getType().equals(origFile.getOrigFileStatus())){
                    origFile.setDaysRemaining(((int)day));
                }else{
                    origFile.setDaysRemaining(0);
                }
            }else{
                origFile.setDaysRemaining(0);
            }
        }
        //排序
        Comparator<OrigFileVo> comparator = new Comparator<OrigFileVo>() {
            public int compare(OrigFileVo s1, OrigFileVo s2) {
                return s1.getDaysRemaining() - s2.getDaysRemaining();
            }
        };
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileVoList)){
            Collections.sort(origFileVoList,comparator);
        }
        origFileVoPageInfoExtend.setData(origFileVoList);
        return origFileVoPageInfoExtend;
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件（原件归档）
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        if (StringUtils.isNotExits(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(null);
        }
        if (StringUtils.isNotExits(origFileVo.getPostNo())){
            origFileVo.setPostNo(null);
        }
        if (StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        }else{
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        return origFileRepository.selectListVoByPage("selectOrigFileVosByOrigFileStatus",origFileVo,origFileVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件(原件借阅)
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findBorrowOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        if (StringUtils.isNotExits(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(null);
        }
        if (StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        } else {
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        }

        //客户姓名
        if (StringUtils.isNotTrimBlank(origFileVo.getCstmName())){
            origFileVo.setCstmName(SqlUtil.likePattern(origFileVo.getCstmName()));
        } else {
            origFileVo.setCstmName(null);
        }
        //车架号
        if (StringUtils.isNotTrimBlank(origFileVo.getVinNo())){
            origFileVo.setVinNo(SqlUtil.likePattern(origFileVo.getVinNo()));
        } else {
            origFileVo.setVinNo(null);
        }
        origFileVo.setOrigFileStatusParam(OrigFileStatusEnums.ARCHIVED.getType());
        //业务类型，不查出续保业务类
        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.INSURANCE_TYPE.getType());
        return origFileRepository.selectListVoByPage("selectBorrowOrigFilesByOrigFileStatus",origFileVo,origFileVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件(续保归档)
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findRenewalOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        if (StringUtils.isNotExits(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(null);
        }
        if (StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        } else {
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        return origFileRepository.selectListVoByPage("selectRenewalOrigFilesByOrigFileStatus",origFileVo,origFileVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件(贷前归档邮寄与上传)
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findPreOrigFilesByOrigFileStatus(OrigFileVo origFileVo,SysUserVo sysUser){
        //合同号
        if (StringUtils.isNotExits(origFileVo.getBizCode())){
            origFileVo.setBizCode(null);
        } else {
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        //归档状态
        if(StringUtils.isNotTrimBlank(origFileVo.getOrigFileStatus())){
            origFileVo.setOrigFileStatus(origFileVo.getOrigFileStatus());
        }else{
            origFileVo.setOrigFileStatus(null);
        }

        //文件状态
        if(StringUtils.isTrimBlank(origFileVo.getOrigFileDetailStatus())){
            origFileVo.setOrigFileDetailStatus(null);
        }
        //承租人
        if(StringUtils.isTrimBlank(origFileVo.getCstmName()))
            origFileVo.setCstmName(null);
        else
            origFileVo.setCstmName(SqlUtil.likePattern(origFileVo.getCstmName()));

        //车架号
        if(StringUtils.isTrimBlank(origFileVo.getVinNo()))
            origFileVo.setVinNo(null);
        else
            origFileVo.setVinNo(SqlUtil.likePattern(origFileVo.getVinNo()));

        //是否超期
        if(StringUtils.isTrimBlank(origFileVo.getDaysRemainingStatus())){
            origFileVo.setDaysRemainingStatus(null);
        }

        //origFileVo.setOrigFileStatusParam(OrigFileStatusEnums.VERIFIED.getType());
        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
        //return origFileRepository.selectListVoByPage("selectPreOrigFilesByOrigFileStatus",origFileVo,origFileVo.getPageQuery());
        //PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = origFileRepository.selectListVoByPage("selectPreOrigFilesByOrigFileStatus",origFileVo,origFileVo.getPageQuery());
        PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = screening2(origFileVo,sysUser);
        List<OrigFileVo> origFileVoList =  origFileVoPageInfoExtend.getData();
        for(OrigFileVo origFile : origFileVoList){
            if(origFile.getOrigDeadline() != null){
                Calendar calendar = Calendar.getInstance();
                long day =  (origFile.getOrigDeadline().getTime()-calendar.getTime().getTime())/(24*60*60*1000);
                if(!OrigFileStatusEnums.ARCHIVED.getType().equals(origFile.getOrigFileStatus())){
                    origFile.setDaysRemaining(((int)day)+1);
                }else{
                    origFile.setDaysRemaining(0);
                }
            }else{
                origFile.setDaysRemaining(0);
            }
        }
        //排序
//        Comparator<OrigFileVo> comparator = new Comparator<OrigFileVo>() {
//            public int compare(OrigFileVo s1, OrigFileVo s2) {
//                return s1.getDaysRemaining() - s2.getDaysRemaining();
//            }
//        };
//        if(ArrayUtils.isNotNullAndLengthNotZero(origFileVoList)){
//            Collections.sort(origFileVoList,comparator);
//        }
        origFileVoPageInfoExtend.setData(origFileVoList);
        return origFileVoPageInfoExtend;
    }

    /**
     * @Title:
     * @Description: 分页查询贷前归档邮寄与上传信息过滤条件
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<OrigFileVo> screening2(OrigFileVo origFileVo, SysUserVo sysUser){
        List<String> roleList = new ArrayList<>();
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        PageInfoExtend<OrigFileVo> pageInfo = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            origFileVo.setSysUser(sysUser.getUser());
            pageInfo = origFileRepository.selectListVoByPage("selectPreOrigFilesByOrigFileStatus", origFileVo, origFileVo.getPageQuery());
        }else if(roleList.contains(SysRoleEnums.QY.getId())){
            List<String> groupCodes = new ArrayList<>();
            groupCodes.add(sysUser.getGroupCode());
            Example example = SqlUtil.newExample(SysGroupParent.class);
            example.createCriteria().andEqualTo("parentGroup",sysUser.getGroupCode());
            List<SysGroupParent> groups = sysGroupParentRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(groups)){
                for(SysGroupParent group:groups){
                    groupCodes.add(group.getGroupCode());
                }
            }
            origFileVo.setSysUserGroup(groupCodes);
            pageInfo = origFileRepository.selectListVoByPage("selectPreOrigFilesByOrigFileStatus", origFileVo, origFileVo.getPageQuery());
        }else{
            pageInfo = origFileRepository.selectListVoByPage("selectPreOrigFilesByOrigFileStatus", origFileVo, origFileVo.getPageQuery());
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileMailList(OrigFileVo origFileVo) {
        if (StringUtils.isTrimBlank(origFileVo.getBizCode()) || StringUtils.isTrimBlank(origFileVo.getBizCodeType())){
            throw new FmsServiceException("参数不正确");
        }
        List<OrigFileDetailVo> origFileDetailVoList = origFileRepository.selectOrigFileMailList(origFileVo);
        return origFileDetailVoList;
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件
     * @param origFileSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public void saveOrigFile(OrigFileSaveVo origFileSaveVo){
        origFileRepository.insertData(origFileSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 文件归档暂存
     * @param origFileSortVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void temporarySave(OrigFileSortVo origFileSortVo) {
        if (StringUtils.isTrimBlank(origFileSortVo.getBizCode())){
            throw new FmsServiceException("合同号参数不正确");
        }
        Example example = SqlUtil.newExample(OrigFile.class);
        example.createCriteria().andEqualTo("bizCode", origFileSortVo.getBizCode()).andEqualTo("bizCodeType", origFileSortVo.getBizCodeType());
        OrigFile origFile = origFileRepository.selectOneByExample(example);
        if (origFile == null){
            throw new FmsServiceException("文件归档信息不存在");
        }
//        if (StringUtils.isTrimBlank(origFile.getFileRecordNo())){
            origFile.setFileRecordNo(origFileSortVo.getFileRecordNo());
            origFile.setOrigVinNo(origFileSortVo.getOrigVinNo());
            origFile.setOrigEngineeNo(origFileSortVo.getOrigEngineeNo());
            origFile.setOrigMemo(origFileSortVo.getRemark());
            //更新原件归档表的归档编号
            origFileRepository.updateByExampleSelectiveData(origFile,example);
//        }

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileSortVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : origFileSortVo.getOrigFileDetailVoList()){
                example = SqlUtil.newExample(OrigFileDetail.class);
                example.createCriteria().andEqualTo("origFileDetailId", origFileDetailVo.getOrigFileDetailId());
                OrigFileDetail origFileDetail = origFileDetailRepository.selectOneByExample(example);
                if (origFileDetail == null){
                    throw new FmsServiceException("原件归档明细信息不存在，请重新操作");
                }
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }
        //更新原件归档明细信息
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList,true);
        }
        //更新合同信息表
        contractRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getContractVo().getEntity(),true);
        //更新合同车辆保险信息
        ContInsurance contInsuranceUpd = origFileSortVo.getContInsuranceVo().getEntity();
        contInsuranceRepository.updateByPrimaryKeySelectiveData(contInsuranceUpd,true);
    }

    /**
     * @Title:
     * @Description: 确认收到
     * @param origFileSortVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void ReceivedConfirm(OrigFileSortVo origFileSortVo) {
        if (ArrayUtils.isNullOrLengthZero(origFileSortVo.getOrigFileDetailVoList())){
            throw new FmsServiceException("请至少选择一条数据");
        }
        Example example = SqlUtil.newExample(OrigFile.class);
        example.createCriteria().andEqualTo("bizCode", origFileSortVo.getBizCode()).andEqualTo("bizCodeType", origFileSortVo.getBizCodeType());
        OrigFile origFile = origFileRepository.selectOneByExample(example);
        if (origFile == null){
            throw new FmsServiceException("文件归档信息不存在");
        }
//        if (StringUtils.isTrimBlank(origFile.getFileRecordNo())){
            origFile.setFileRecordNo(origFileSortVo.getFileRecordNo());
            origFile.setOrigVinNo(origFileSortVo.getOrigVinNo());
            origFile.setOrigEngineeNo(origFileSortVo.getOrigEngineeNo());
            origFile.setOrigMemo(origFileSortVo.getRemark());

        //更新原件归档表的归档编号
            origFileRepository.updateByExampleSelectiveData(origFile,example);
//        }

        example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo", origFileSortVo.getBizCode());
        Contract contract = contractRepository.selectOneByExample(example);
        if (contract == null){
            throw new FmsServiceException("合同信息不存在");
        }

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        for (OrigFileDetailVo origFileDetailVo : origFileSortVo.getOrigFileDetailVoList()){
            example = SqlUtil.newExample(OrigFileDetail.class);
            example.createCriteria().andEqualTo("origFileDetailId", origFileDetailVo.getOrigFileDetailId());
            OrigFileDetail origFileDetail = origFileDetailRepository.selectOneByExample(example);
            if (origFileDetail == null){
                throw new FmsServiceException("原件归档明细信息不存在，请重新操作");
            }
            if (StringUtils.isTrimBlank(origFileDetail.getFileRecordNo())){
                origFileDetailVo.setFileRecordNo(origFileSortVo.getFileRecordNo());//归档编号
            }
            origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.TO_BE_SORTED.getType());//文件状态更新为"待归档"
            origFileDetailList.add(origFileDetailVo.getEntity());
        }

        //更新原件归档明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList,true);
        }
        //更新合同信息表
        contractRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getContractVo().getEntity(),true);
        //更新合同车辆保险信息
        contInsuranceRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getContInsuranceVo().getEntity(),true);
    }

    /**
     * @Title:
     * @Description: 归档
     * @param origFileSortVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void origFileSort(OrigFileSortVo origFileSortVo, SysUser sysUser) {

        Example origFileExample = SqlUtil.newExample(OrigFile.class);
        origFileExample.createCriteria().andEqualTo("bizCode", origFileSortVo.getBizCode()).andEqualTo("bizCodeType", origFileSortVo.getBizCodeType());
        OrigFile origFile = origFileRepository.selectOneByExample(origFileExample);
        if (origFile == null){
            throw new FmsServiceException("文件归档信息不存在");
        }
        String fileTaskNo;
        if (StringUtils.isNotTrimBlank(origFile.getOrigFileTaskNo())){
            fileTaskNo = origFile.getOrigFileTaskNo();
        } else {
            //生成归档任务号
            fileTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.ORIG_FILE_SORT_NUM_TYPE.getType());
        }
        ActRuTaskVo actRuTaskVo;
        Map<String, Object> map = new HashMap<>();
        map.put("bizCode", origFileSortVo.getBizCode());
        map.put("bizCodeType", origFileSortVo.getBizCodeType());
        if (StringUtils.isNotTrimBlank(origFileSortVo.getTaskId())){
            actRuTaskVo = ActOrigFileSortUtils.origFileReviewAgree(origFileSortVo.getTaskId());
        } else {
            //开启新的工作流
            actRuTaskVo = ActOrigFileSortUtils.startOrigFileSort(fileTaskNo, ActProcessInstanceKeyEnums.ORIG_FILE_SORT.getKey(), fileTaskNo, map);
        }
        if (StringUtils.isTrimBlank(origFile.getFileRecordNo())){
            origFile.setFileRecordNo(origFileSortVo.getFileRecordNo());//归档编号
        }
        origFile.setOrigFileTaskNo(fileTaskNo);//归档任务号
        origFile.setOrigFileTaskStatus(actRuTaskVo.getTaskCode());//归档任务状态
        origFile.setOrigFileStatus(OrigFileStatusEnums.CHECKED.getType());//归档状态 归档待审核
        origFile.setOrigFileDate(DateUtils.getNowDate());//归档日期
        origFile.setOrigVinNo(origFileSortVo.getOrigVinNo());//归档车架号
        origFile.setOrigEngineeNo(origFileSortVo.getOrigEngineeNo());//归档发动机号
        origFile.setOrigMemo(origFileSortVo.getRemark());//归档备注

        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo", origFileSortVo.getBizCode());
        Contract contract = contractRepository.selectOneByExample(example);
        if (contract == null){
            throw new FmsServiceException("合同信息不存在");
        }
        if (!origFileSortVo.getContractVo().getVinNo().equals(origFileSortVo.getOrigVinNo())){
            throw new FmsServiceException("车架号与合同信息中的车架号不一致");
        }
        if (!origFileSortVo.getContractVo().getEngineNo().equals(origFileSortVo.getOrigEngineeNo())){
            throw new FmsServiceException("发动机号与合同信息中的发动机号不一致");
        }

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileSortVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : origFileSortVo.getOrigFileDetailVoList()){
                example = SqlUtil.newExample(OrigFileDetail.class);
                example.createCriteria().andEqualTo("origFileDetailId", origFileDetailVo.getOrigFileDetailId());
                OrigFileDetail origFileDetail = origFileDetailRepository.selectOneByExample(example);
                if (origFileDetail == null){
                    throw new FmsServiceException("原件归档明细信息不存在，请重新操作");
                }
                    //当前文件不是已收到
                    if(!OrigFileDetailStatusEnums.TO_BE_SORTED.getType().equals(origFileDetailVo.getOrigFileDetailStatus())&&!OrigFileDetailStatusEnums.BE_SORTED.getType().equals(origFileDetailVo.getOrigFileDetailStatus())&& YesNoFlagEnums.YES.getType().equals(origFileDetailVo.getOrigFlag())){
                        throw new FmsServiceException("请先确认收到，再进行归档");
                    }else if(OrigFileDetailStatusEnums.TO_BE_SORTED.getType().equals(origFileDetailVo.getOrigFileDetailStatus())){
                        origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_SORTED.getType());//文件状态更新为"已归档"
                    }

                if (StringUtils.isTrimBlank(origFileDetail.getFileRecordNo())){
                    origFileDetailVo.setFileRecordNo(origFileSortVo.getFileRecordNo());//归档编号
                }
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }

        //更新原件归档表的归档编号
        origFileRepository.updateByExampleSelectiveData(origFile,origFileExample);

        //更新原件归档明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList,true);
        }
        //更新合同信息表
        contractRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getContractVo().getEntity(),true);
        //更新合同车辆保险信息
        ContInsurance contInsuranceUpd = origFileSortVo.getContInsuranceVo().getEntity();
        contInsuranceUpd.setInsuranceYears(DateUtils.getYear(
                DateUtils.getStringDate(contInsuranceUpd.getValidStartDay()), DateUtils.getStringDate(contInsuranceUpd.getValidEndDay())));
        contInsuranceRepository.updateByPrimaryKeySelectiveData(contInsuranceUpd,true);

        //如果有指标编号则更新对应指标为已使用信息
        if(StringUtils.isNotTrimBlank(contract.getLicenseIdxNo())){//合同中有指标信息
            Example examplelicense = new Example(LicenseIdx.class);
            examplelicense.createCriteria().andEqualTo("licenseIdxNo", contract.getLicenseIdxNo());
            LicenseIdx LicenseIdx = licenseIdxRepository.selectOneByExample(examplelicense);
            LicenseIdx.setLicenseIdxStatus(LicenseIdxEnums.NOTUSED.getType());//已使用
            LicenseIdx.setUseLicenseNo(origFileSortVo.getContractVo().getVehicleLicenseNo());//车牌号
            if(ApplyTypeEnums.PERSON.getType().equals(contract.getApplyType())){//个人申请
                CstmPersonAddTelVo cstmpersonaddtelvo = cstmPersonRepository.selectCstmPersonAddTelVoByApplyNo(contract.getApplyNo());
                LicenseIdx.setUseCustomer(cstmpersonaddtelvo.getName());//指标使用人名称
                LicenseIdx.setUseCertifNo(cstmpersonaddtelvo.getCertifNo());//使用人证件号
                LicenseIdx.setUsePhoneNo(cstmpersonaddtelvo.getMobileNo()); //使用人电话
            }else if(ApplyTypeEnums.COMPANY.getType().equals(contract.getApplyType())){//企业申请
                Example examplecomoany = new Example(LicenseIdx.class);
                examplecomoany.createCriteria().andEqualTo("applyNo", contract.getApplyNo());
                CstmCompany cstmcompany = cstmCompanyRepository.selectOneByExample(examplecomoany);
                LicenseIdx.setUseCustomer(cstmcompany.getName());//企业名称
                LicenseIdx.setUseCertifNo(cstmcompany.getSocialCertifNo());//企业社会信用代码
                LicenseIdx.setUsePhoneNo(cstmcompany.getContactMobno()); //企业联系人电话
            }
            licenseIdxRepository.updateByPrimaryKeyData(LicenseIdx);
        }

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setWfLogNo(fileTaskNo);
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogType(BizTypeEnums.ORIG_FILE_SORT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(origFileSortVo.getRemark());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(SUBMIT.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);

    }

    /**
     * @Title:
     * @Description: 归档审核
     * @param origFileSortVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public void origFileSortExamine(OrigFileSortVo origFileSortVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(origFileSortVo.getBizCode()) || StringUtils.isTrimBlank(origFileSortVo.getBizCodeType())){
            throw new FmsServiceException("参数不正确");
        }
        //审核通过工作流
        ActRuTaskVo actRuTaskVo = ActOrigFileSortUtils.origFileReviewAgree(origFileSortVo.getTaskId());
        Example example = SqlUtil.newExample(OrigFile.class);
        example.createCriteria().andEqualTo("bizCode", origFileSortVo.getBizCode()).andEqualTo("bizCodeType", origFileSortVo.getBizCodeType());
        OrigFile origFile = origFileRepository.selectOneByExample(example);
        if (origFile == null){
            throw new FmsServiceException("原件归档信息不存在");
        }
        origFile.setOrigFileStatus(OrigFileStatusEnums.ARCHIVED.getType());// 已归档
        origFile.setOrigFileTaskStatus(actRuTaskVo.getTaskCode());//归档任务状态
        //更新原件归档表
        origFileRepository.updateByExampleSelectiveData(origFile, example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogType(BizTypeEnums.ORIG_FILE_SORT.getType());
        workflowLog.setWfLogNo(origFile.getOrigFileTaskNo());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(origFileSortVo.getRemark());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(APPROVAL.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileMailVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void mailConfirm(OrigFileMailVo origFileMailVo, SysUser sysUser) {
        if (ArrayUtils.isNullOrLengthZero(origFileMailVo.getOrigFileDetailVoList())){
            throw new FmsServiceException("请至少选择一条数据");
        }
        FileSend fileSend = new FileSend();
        fileSend.setFilePostId(UUIDUtils.getUUID());
        fileSend.setPostStatus(PostStatusEnums.TO_BE_RECEIVED.getType());//邮寄状态
        fileSend.setPostComp(origFileMailVo.getPostComp());//快递公司
        fileSend.setPostDate(origFileMailVo.getPostDate());//邮寄日期
        fileSend.setPostNo(origFileMailVo.getPostNo());//快递编号
        fileSend.setPostMember(sysUser.getUser());//快递邮寄人员
        fileSend.setPostMemberTel(origFileMailVo.getPostMemberTel());//联系电话
        fileSend.setRemark(origFileMailVo.getRemark());//备注
        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        for (OrigFileDetailVo origFileDetailVo : origFileMailVo.getOrigFileDetailVoList()){
            origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.ALREADY_MAILED.getType());
            origFileDetailVo.setFilePostId(fileSend.getFilePostId());
            origFileDetailList.add(origFileDetailVo.getEntity());
        }
        //登录资料邮寄表
        fileSendRepository.insertData(fileSend);
        //更新原件归档明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);
        }
    }

    /**
     * @Title:
     * @Description: 资料上传
     * @param origFileMailVo
     * @param sysUser
     * @throws
     * @return java.lang.String
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void origFileUpload(OrigFileMailVo origFileMailVo, SysUser sysUser) {
        //保存附件信息
        bizFilesService.modifyBizFilesList(origFileMailVo.getBizFilesList(),origFileMailVo.getBizCode(),
                origFileMailVo.getBizCodeType());
    }

    /**
     * @Title:
     * @Description: 保单归档确认
     * @param origFileSortVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Transactional
    @Override
    public void renewalSortConfirm(OrigFileSortVo origFileSortVo, SysUser sysUser) {

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileSortVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : origFileSortVo.getOrigFileDetailVoList()){
                Example example = SqlUtil.newExample(OrigFileDetail.class);
                example.createCriteria().andEqualTo("origFileDetailId", origFileDetailVo.getOrigFileDetailId());
                OrigFileDetail origFileDetail = origFileDetailRepository.selectOneByExample(example);
                if (origFileDetail == null){
                    throw new FmsServiceException("原件归档明细信息不存在，请重新操作");
                }
                if (YesNoFlagEnums.YES.getType().equals(origFileDetailVo.getOrigFlag())){
                    origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_SORTED.getType());//文件状态更新为"已归档"
                }
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }

        //当前保单的保险年限
        origFileSortVo.getContInsuranceVo().setInsuranceYears(
                DateUtils.getYear(DateUtils.getStringDate(origFileSortVo.getContInsuranceVo().getValidStartDay()),
                        DateUtils.getStringDate(origFileSortVo.getContInsuranceVo().getValidEndDay())));
        //
        if (StringUtils.isNotTrimBlank(origFileSortVo.getRenewalRegisterVo().getCurrentInsuranceId())){
            ContInsurance contInsurance = contInsuranceRepository.selectByPrimaryKey(origFileSortVo.getRenewalRegisterVo().getCurrentInsuranceId());
            if (contInsurance != null){
                //更新当前保险的保单状态为失效
                ContInsuranceVo contInsuranceVoCur = new ContInsuranceVo();
                contInsuranceVoCur.setInsuranceStatus(InsuranceStatusEnums.INSURANCE_INVALID.getType());//更新保单系统状态 2-失效
                contInsuranceVoCur.setContVehinsId(origFileSortVo.getRenewalRegisterVo().getCurrentInsuranceId());
                contInsuranceRepository.updateByPrimaryKeySelectiveData(contInsuranceVoCur.getEntity());

                //已购买保险年限
                origFileSortVo.getContInsuranceVo().setInsuranceYears(origFileSortVo.getContInsuranceVo().getInsuranceYears() +
                        (contInsurance.getInsuranceYears() == null ? 0 : contInsurance.getInsuranceYears()));
            }
        }

        Example example = SqlUtil.newExample(OrigFile.class);
        example.createCriteria().andEqualTo("bizCode", origFileSortVo.getBizCode()).andEqualTo("bizCodeType", origFileSortVo.getBizCodeType());
        OrigFile origFile = origFileRepository.selectOneByExample(example);
        if (origFile != null){
            origFile.setOrigFileStatus(OrigFileStatusEnums.ARCHIVED.getType());//归档状态
            origFile.setOrigFileDate(DateUtils.getNowDate());//归档日期
            //更新原件归档表的归档状态
            origFileRepository.updateByExampleSelectiveData(origFile, example);
        }

        //更新原件归档明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);
        }
        //更新合同车辆保险信息表
        if (origFileSortVo.getContInsuranceVo() != null){
            origFileSortVo.getContInsuranceVo().setInsuranceStatus(InsuranceStatusEnums.INSURANCE_VALID.getType());
            contInsuranceRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getContInsuranceVo().getEntity(), true);
        }
        //更新续保任务表
        if(origFileSortVo.getRenewalRegisterVo() != null){
            renewalRegisterRepository.updateByPrimaryKeySelectiveData(origFileSortVo.getRenewalRegisterVo().getEntity(), true);
        }
        //保存附件信息
        if (origFileSortVo.getBizFilesList() != null){
            bizFilesService.modifyBizFilesList(origFileSortVo.getBizFilesList(),origFileSortVo.getBizCode(),
                    origFileSortVo.getOrigFileType());
        }
        //保存日志信息
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        //用续保任务号
        workflowLog.setWfLogNo(origFileSortVo.getBizCode());

        workflowLog.setWfLogType(BizTypeEnums.RENEWAL_SORT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(origFileSortVo.getRemark());
        workflowLog.setStatus(BizStatusEnums.RENEWAL_SORT.getType());
        workflowLog.setActType(SUBMIT.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);


    }

    /**
     * @Title:
     * @Description: 归档审核退回
     * @param origFileSortVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public void origFileSortExamineBack(OrigFileSortVo origFileSortVo, SysUser sysUser) {
        //退回工作流
        ActRuTaskVo actRuTaskVo = ActOrigFileSortUtils.approvalReturnSuperior(origFileSortVo.getTaskId());

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogType(BizTypeEnums.ORIG_FILE_SORT.getType());
        workflowLog.setWfLogNo(origFileSortVo.getBizCode());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(origFileSortVo.getRemark());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(SENDBACK.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 修改资料邮寄附件
     * @param origFileModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public void modifyOrigFile(OrigFileModifyVo origFileModifyVo){
        origFileRepository.updateByPrimaryKeySelectiveData(origFileModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过origFileId删除资料邮寄附件
     * @param origFileDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public void deleteOrigFile(OrigFileDeleteVo origFileDeleteVo){
        origFileRepository.deleteData(origFileDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  获取贷前归档明细一览画面数据（资管复核）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFileSortVo findOrigFileSortDetailsExamineByPage(OrigFileDetailVo origFileDetailVo){
        if (StringUtils.isTrimBlank(origFileDetailVo.getOrigFileTaskNo())){
            throw new FmsServiceException("参数不正确");
        }
        OrigFileSortVo origFileSortVo = origFileRepository.selectOrigFileSortDetailsByPage(origFileDetailVo);
        //查询附件信息
        origFileSortVo.setBizFilesList(bizFilesService.findBizFilesList(origFileSortVo.getBizCode(),origFileSortVo.getOrigFileType()));
        return origFileSortVo;
    }

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVo
     * @return OrigFileSortVo
     * @throws
     * @author lijunjun
     * @date 2018-5-11 14:16:47
     */
    @Override
    public OrigFileSortVo selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo) {
        if (StringUtils.isTrimBlank(origFileDetailVo.getBizCode()) || StringUtils.isTrimBlank(origFileDetailVo.getBizCodeType())){
            throw new FmsServiceException("参数不正确");
        }
        OrigFileSortVo origFileSortVo = origFileRepository.selectOrigFileRenewalSortDetailsByPage(origFileDetailVo);
        if (origFileSortVo != null && origFileSortVo.getRenewalRegisterVo() != null){
            ContInsuranceVo contInsuranceVo = new ContInsuranceVo();
            ContInsurance contInsurance = contInsuranceRepository.selectByPrimaryKey(origFileSortVo.getRenewalRegisterVo().getRenewalContVehinsId());
            BeanUtils.copyProperties(contInsurance, contInsuranceVo);
            origFileSortVo.setContInsuranceVo(contInsuranceVo);
        }
//
//        CommonBizFilesVo commonBizFilesVo = getContPrintFileList(origFileSortVo.getBizCode(), BizCodeTypeEnums.ORIG_RENEWAL_SORT_FILE.getCodeType());
//        origFileSortVo.setCommonBizFilesVo(commonBizFilesVo);
        origFileSortVo.setBizFilesList(bizFilesService.findBizFilesList(origFileSortVo.getBizCode(), BizCodeTypeEnums.ORIG_RENEWAL_SORT_FILE.getCodeType()));
        return origFileSortVo;
    }


    /**
     * @Title:
     * @Description:  获取贷前归档明细一览画面数据
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFileSortVo findOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo){
        if (StringUtils.isTrimBlank(origFileDetailVo.getBizCode())){
            origFileDetailVo.setBizCode(null);
        }
        OrigFileSortVo origFileSortVo = origFileRepository.selectOrigFileSortDetailsByPage(origFileDetailVo);
        if (StringUtils.isTrimBlank(origFileSortVo.getFileRecordNo())){
            //如果原件归档表中没有归档编号，自动生成归档编号返回
            String str1 = "WL";
            //共通方法取得 日期+编号
            String str3 = numGenerateService.getNumGenerateByNumType(NumTypeEnums.ORIG_FILE_NUM.getType());
            origFileSortVo.setFileRecordNo(str1.concat(str3));
            //更新归档编号
            origFileRepository.updateByPrimaryKeySelectiveData(EntityUtils.getEntity(origFileSortVo, new OrigFile()));
        }
        //取得附件信息 老代码
//        CommonBizFilesVo commonBizFilesVo = getContPrintFileList(origFileSortVo.getBizCode(), origFileSortVo.getBizCodeType());
//        commonBizFilesVo.setFileType(origFileSortVo.getOrigFileType());
//        origFileSortVo.setCommonBizFilesVo(commonBizFilesVo);
        //查询附件信息
        origFileSortVo.setBizFilesList(bizFilesService.findBizFilesList(origFileSortVo.getBizCode(),origFileSortVo.getOrigFileType()));
        return origFileSortVo;
    }

    private CommonBizFilesVo getContPrintFileList(String bizCode, String bizCodeType){
        return bizFilesService.findBizFilesByBizCode(bizCode, bizCodeType);
    }

    /**
     * @Title:
     * @Description:  通过origFileId集合删除资料邮寄附件
     * @param origFileDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public void deleteOrigFilesByOrigFileIds(OrigFileDeleteListVo origFileDeleteListVo){
        origFileRepository.deleteDataList(origFileDeleteListVo.getOrigFileIds(),origFileDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据origFileId获取资料邮寄附件
     * @param origFileId
     * @return OrigFile
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public OrigFile findOrigFileByOrigFileId(String origFileId){
        return origFileRepository.selectByPrimaryKey(origFileId);
    }

    /**
     * @Title:
     * @Description:  确认归档
     * @param origFileVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    public void confirmFile(OrigFileVo origFileVo){
        if(ArrayUtils.isNullOrLengthZero(origFileVo.getOrigFileDetailList())){
            throw new FmsServiceException("未选择附件信息");
        }
        for(OrigFileDetail origFileDetail : origFileVo.getOrigFileDetailList()){
            Example origFileDetailExample = SqlUtil.newExample(OrigFileDetail.class);
            origFileDetailExample.createCriteria().andEqualTo("origFileDetailId", origFileDetail.getOrigFileDetailId());
            OrigFileDetail origFileDetailEntity = origFileDetailRepository.selectOneByExample(origFileDetailExample);
            if(origFileDetailEntity != null){
                origFileDetailEntity.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_SORTED.getType());// 3-已归档
                origFileDetailEntity.setFileRecordNo(origFileDetail.getFileRecordNo());
                origFileDetailEntity.setFileInfo1(origFileDetail.getFileInfo1());
                origFileDetailEntity.setFileInfo2(origFileDetail.getFileInfo2());
                origFileDetailEntity.setFileInfo3(origFileDetail.getFileInfo3());
                origFileDetailRepository.updateByPrimaryKeySelectiveData(origFileDetailEntity);
            }
        }
    }

    /**
     * @Title:
     * @Description:  退回
     * @param origFileVo
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    public void cancelFile(OrigFileVo origFileVo){

        if(ArrayUtils.isNullOrLengthZero(origFileVo.getOrigFileDetailList())){
            throw new FmsServiceException("未选择附件信息");
        }
        for(OrigFileDetail origFileDetail : origFileVo.getOrigFileDetailList()) {
            //对已归档的信息进行过滤
            if(OrigFileDetailStatusEnums.BE_SORTED.getType().equals(origFileDetail.getOrigFileDetailStatus())){
                continue;
            }
            Example origFileDetailExample = SqlUtil.newExample(OrigFileDetail.class);
            origFileDetailExample.createCriteria().andEqualTo("origFileDetailId", origFileDetail.getOrigFileDetailId());
            OrigFileDetail origFileDetailEntity = origFileDetailRepository.selectOneByExample(origFileDetailExample);
            if (origFileDetailEntity != null){
                origFileDetailEntity.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_BACK.getType());// 4-被退回
                origFileDetailRepository.updateByPrimaryKeySelectiveData(origFileDetailEntity);
            }
        }
    }

    /**
     * @Title:
     * @Description:  归档完成确认
     * @param origFileVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    public void fileFinishedConfirm(OrigFileVo origFileVo){
        if(origFileVo.getOrigFileVoList() == null || (origFileVo.getOrigFileVoList() != null
                && origFileVo.getOrigFileVoList().size() == 0)){
            throw new FmsServiceException("未选择附件信息");
        }
        for(OrigFileVo origFileVoInfo : origFileVo.getOrigFileVoList()){
            Example origFileExample = SqlUtil.newExample(OrigFile.class);
            origFileExample.createCriteria().andEqualTo("origFileId", origFileVoInfo.getOrigFileId());
            OrigFile origFileEntity = origFileRepository.selectOneByExample(origFileExample);
            if(origFileEntity != null){
                origFileEntity.setOrigFileStatus(OrigFileStatusEnums.ARCHIVED.getType()); // 1-已归档
                origFileRepository.updateByPrimaryKeySelectiveData(origFileEntity);
            }
        }
    }


    /**
     * @Title:
     * @Description:  归档明细
     * @param origFileVo
     * @return PageInfoExtend<OrigFileVo>
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 14:16:47
     */
    public PageInfoExtend<OrigFileVo> findOrigArchiveDetailByPage(OrigFileVo origFileVo){
        Example example = SqlUtil.newExample(OrigFile.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(origFileVo.getBizCodeType())){
            SysCodeVo sysCodeVo = new SysCodeVo();
            sysCodeVo.setCodeType("bizCodeType");
            sysCodeVo.setCodeValueName(origFileVo.getBizCodeType());
            List<String> bizCodeTypeList = new ArrayList<>();
            try {
                Map<String,Object> sysCodeVoMap = sysCodeVo == null?null:(Map) JSON.toJSON(sysCodeVo);
                PageInfoExtend<SysCode> sysCodePageInfo =  ResponseEntityUtils.getRestResponseData(sysCodeRpc.findSysCodesByPage(sysCodeVoMap));
                List<SysCode> sysCodeList = sysCodePageInfo.getData();
                if(ArrayUtils.isNotNullAndLengthNotZero(sysCodeList)){
                    for(SysCode sysCode:sysCodeList){
                        bizCodeTypeList.add(sysCode.getCodeValue());
                    }
                    criteria.andIn("bizCodeType",bizCodeTypeList);
                }else{
                    return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,origFileVo.getPageQuery(),OrigFileVo.class);
                }

            } catch (FmsRpcException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw  new FmsServiceException("获取业务类型失败");
            }
        }
        if(StringUtils.isNotTrimBlank(origFileVo.getBizCode())){
            criteria.andLike("bizCode",SqlUtil.likePattern(origFileVo.getBizCode()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OrigFile> pageInfo = origFileRepository.selectListByExamplePage(example,origFileVo.getPageQuery());
        PageInfoExtend<OrigFileVo> origFileVoPageInfoExtend = new PageInfoExtend<>();  //entity转Vo
        BeanUtils.copyProperties(pageInfo,origFileVoPageInfoExtend,"data");
        List<OrigFile> origFileList = pageInfo.getData();
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileList)){
            List<OrigFileVo> backOrigFileList  = new ArrayList<>();
            Date date = new Date();
            for(OrigFile origFile:origFileList){
                OrigFileVo orig =    EntityUtils.getEntity(origFile,new OrigFileVo());
                Long origFileDeadLine = origFile.getOrigDeadline() == null?0:origFile.getOrigDeadline().getTime();
                int remainDays = (int)((origFileDeadLine - date.getTime())/(1000*3600*24));
                if(remainDays>=0){
                    orig.setDaysRemaining(remainDays);
                }
                if(origFile.getOrigFileStatus().equals(ARCHIVED.getType())){
                    //Date actualFilingDate =  new Date(origFile.getUpdateTime().getTime());
                    orig.setActualFilingDate(origFile.getUpdateTime());
                }
                backOrigFileList.add(orig);
            }
            origFileVoPageInfoExtend.setData(backOrigFileList);
            return origFileVoPageInfoExtend;
        }else

        return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,origFileVo.getPageQuery(),OrigFileVo.class);
    }

    /**
     * @Title:
     * @Description: 查询融保险资料邮寄附件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @Override
    public List<OrigFileVo> findOrigFileVos() {
        OrigFileVo origFileVo = new OrigFileVo();
        Date date = new Date();
        origFileVo.setJugTime( DateUtils.dateToStr(date,DateUtils.formatStr_yyyyMMdd));
        origFileVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        return origFileRepository.selectOrigFileVos(origFileVo);
    }

    /**
     * @Title:
     * @Description: 查询邮寄文件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-27 14:16:46
     */
    @Override
    public OrigFile findOrigFileByContNo(String contNo) {
        Example example  = SqlUtil.newExample(OrigFile.class);
        example.createCriteria().andEqualTo("bizCode",contNo).andEqualTo("bizCodeType", OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
        return origFileRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 续保归档附件上传
     * @param origFileSortVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public void uploadRenewalFile(OrigFileSortVo origFileSortVo) {
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileSortVo.getBizFilesList())){
            bizFilesService.modifyBizFilesList(origFileSortVo.getBizFilesList(),origFileSortVo.getBizCode(),
                    origFileSortVo.getOrigFileType());
        }
    }

}
