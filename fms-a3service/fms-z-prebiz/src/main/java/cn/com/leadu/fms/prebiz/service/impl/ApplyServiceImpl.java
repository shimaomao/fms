package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.activiti.repository.ActRuTaskRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyRepository;
import cn.com.leadu.fms.data.system.repository.SysCodeRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyBaseInfoVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.rpc.activiti.ActRuTaskRpc;
import cn.com.leadu.fms.prebiz.rpc.finance.ContRepaySkedRpc;
import cn.com.leadu.fms.prebiz.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyService
 * @Description: 申请信息业务实现层
 * @date 2018-03-26
 */
@Slf4j
@Service
public class ApplyServiceImpl implements ApplyService {

    /**
     * @Fields  : 申请信息repository
     */
    @Autowired
    private ApplyRepository applyRepository;

    /**
     * @Fields  : 合同service
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  : 客户个人基本信息service
     */
    @Autowired
    private CstmPersonService cstmPersonService;

    /**
     * @Fields  : 客户企业基本信息service
     */
    @Autowired
    private CstmCompanyService cstmCompanyService;

    /**
     * @Fields  : 合同融资信息service
     */
    @Autowired
    private ContractFinanceService contractFinanceService;

    /**
     * @Fields  : 申请融资信息service
     */
    @Autowired
    private ApplyFinanceService applyFinanceService;

    @Autowired
    private SysCodeRepository sysCodeRepository;

    /**
     * @Fields  : 融资合同还款计划rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    @Autowired
    private ActRuTaskRpc actRuTaskRpc;

    @Autowired
    private ActRuTaskRepository actRuTaskRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;


    /**
     * @Fields  : crm企业
     * @author qiaomengnan
     */
    @Autowired
    private CrmCompanyService crmCompanyService;

    /**
     * @Fields  : crm个人
     * @author qiaomengnan
     */
    @Autowired
    private CrmPersonService crmPersonService;

    /**
     * @Title:
     * @Description: 分页查询申请信息
     * @param applyVo
     * @return PageInfoExtend<Apply>
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public PageInfoExtend<Apply> findApplysByPage(ApplyVo applyVo){
        Example example = SqlUtil.newExample(Apply.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<Apply> pageInfo = applyRepository.selectListByExamplePage(example,applyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Description: 分页查询申请一览信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/3 18:32
     */
    public PageInfoExtend<ApplyListVo> findApplyListByPage(ApplyListVo applyListVo,SysUserVo sysUser) {
        //申请编号
        if (StringUtils.isTrimBlank(applyListVo.getApplyNo()))
            applyListVo.setApplyNo(null);
        else
            applyListVo.setApplyNo(SqlUtil.likePattern(applyListVo.getApplyNo()));

        //客户姓名
        if(StringUtils.isTrimBlank(applyListVo.getName()))
            applyListVo.setName(null);
        else
            applyListVo.setName(SqlUtil.likePattern(applyListVo.getName()));

        //申请类型
        if(StringUtils.isTrimBlank(applyListVo.getApplyType()))
            applyListVo.setApplyType(null);
        else
            applyListVo.setApplyType(applyListVo.getApplyType());

        //申请状态
        if(StringUtils.isTrimBlank(applyListVo.getBizStatus()))
            applyListVo.setBizStatus(null);
        else
            applyListVo.setBizStatus(applyListVo.getBizStatus());


        //审核人员
        if(StringUtils.isTrimBlank(applyListVo.getApproveUser()))
            applyListVo.setApproveUser(null);
        else
            applyListVo.setApproveUser(applyListVo.getApproveUser());

        //出租人区域
        if(StringUtils.isTrimBlank(applyListVo.getGroupDistrict()))
            applyListVo.setGroupDistrict(null);
        else
            applyListVo.setGroupDistrict(SqlUtil.likePattern(applyListVo.getGroupDistrict()));

        //业务类型
        if(StringUtils.isTrimBlank(applyListVo.getLicenseAttr()))
            applyListVo.setLicenseAttr(null);
        //担保人
        if(StringUtils.isNotTrimBlank(applyListVo.getGuarantee())){
            applyListVo.setGuarantee(SqlUtil.likePattern(applyListVo.getGuarantee()));
        }else{
            applyListVo.setGuarantee(null);
        }
        //订单提交日区间起始
        if(StringUtils.isNotTrimBlank(applyListVo.getSubmitStartTime())){
            applyListVo.setSubmitStartTime(applyListVo.getSubmitStartTime());
        }else{
            applyListVo.setSubmitStartTime(null);
        }
        //订单提交日区间结束
        if(StringUtils.isNotTrimBlank(applyListVo.getSubmitEndTime())){
            applyListVo.setSubmitEndTime(applyListVo.getSubmitEndTime());
        }else{
            applyListVo.setSubmitEndTime(null);
        }
        //审批通过日区间起始
        if(StringUtils.isNotTrimBlank(applyListVo.getApproveStartTime())){
            applyListVo.setApproveStartTime(applyListVo.getApproveStartTime());
        }else{
            applyListVo.setApproveStartTime(null);
        }
        //审批通过日区间结束
        if(StringUtils.isNotTrimBlank(applyListVo.getApproveEndTime())){
            applyListVo.setApproveEndTime(applyListVo.getApproveEndTime());
        }else{
            applyListVo.setApproveEndTime(null);
        }

        //风控审批结果
        if(StringUtils.isTrimBlank(applyListVo.getWindcontrApprovalStatus()))
            applyListVo.setWindcontrApprovalStatus(null);
        else
            applyListVo.setWindcontrApprovalStatus(applyListVo.getWindcontrApprovalStatus());
        //终审审批结果
        if(StringUtils.isTrimBlank(applyListVo.getFinalApprovalStatus()))
            applyListVo.setFinalApprovalStatus(null);
        else
            applyListVo.setFinalApprovalStatus(applyListVo.getFinalApprovalStatus());
        //订单状态大类
        if(StringUtils.isNotTrimBlank(applyListVo.getApplyStatus())) {
            String applyStatus = applyListVo.getApplyStatus();
            //取出对应的的数据字典
            SysCodeVo sysCodeVo = new SysCodeVo();
            sysCodeVo.setCodeType(CommonCodeTypeConstants.APPLY_STATUS);
            sysCodeVo.setCodeValue(applyStatus);
            SysCode sysCode = findSysCodeByCodeValue(sysCodeVo);
            List<String> statusList = Arrays.asList(sysCode.getMemo().split(","));
            applyListVo.setStatusList(statusList);
        }
        //设置个人标志
        applyListVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());
        //设置企业标志
        applyListVo.setCompanyFlag(ApplyTypeEnums.COMPANY.getType());

        //PageInfoExtend<ApplyListVo> pageInfo = applyRepository.selectListVoByPage("selectApplyListByPage", applyListVo, applyListVo.getPageQuery());
        return screening(applyListVo,sysUser);
    }
    /**
     * @Description: 分页查询申请一览信息过滤条件
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/3 18:32
     */
    public PageInfoExtend<ApplyListVo> screening(ApplyListVo applyListVo, SysUserVo sysUser){
        List<String> roleList = new ArrayList<>();
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        PageInfoExtend<ApplyListVo> pageInfo = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            applyListVo.setSysUser(sysUser.getUser());
            pageInfo = applyRepository.selectListVoByPage("selectApplyListByPage", applyListVo, applyListVo.getPageQuery());
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
            applyListVo.setSysUserGroup(groupCodes);
            pageInfo = applyRepository.selectListVoByPage("selectApplyListByPage", applyListVo, applyListVo.getPageQuery());
        }else{
            pageInfo = applyRepository.selectListVoByPage("selectApplyListByPage", applyListVo, applyListVo.getPageQuery());
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据applyId获取申请信息
     * @param applyId
     * @return Apply
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public Apply findApplyByApplyId(String applyId){
        return applyRepository.selectByPrimaryKey(applyId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取申请信息
     * @param applyNo
     * @return Apply
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public Apply findApplyByApplyNo(String applyNo){
        if(StringUtils.isTrimBlank(applyNo))
            throw new FmsServiceException("订单编号不能为空");

        Example example = SqlUtil.newExample(Apply.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return applyRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取申请详情顶部信息
     * @param applyNo
     * @return Apply
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public ApplyBaseInfoVo findApplyBaseInfo(String applyNo){
        Apply apply = findApplyByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException("该订单不存在");
        }
        ApplyBaseInfoVo vo = new ApplyBaseInfoVo();
        vo.setApplyNo(applyNo);
        vo.setBizStatus(apply.getBizStatus());
        if(StringUtils.isNotTrimBlank(apply.getPresentUser())){
            List<String> userList = ArrayUtils.asList(apply.getPresentUser().split(","));
            StringBuilder value = new StringBuilder("");
            for(int i=0;i<userList.size();i++){
                Example example = SqlUtil.newExample(SysUser.class);
                example.createCriteria().andEqualTo("user",userList.get(i));
                SysUser sysUser = sysUserRepository.selectOneByExample(example);
                //如果有多个审批者，则加上逗号分隔符
                if(i>0){
                    value = value.append(",");
                }
                //拼接姓名和账号
                value = value.append(sysUser.getUserName()).append("(").append(sysUser.getUser()).append(")");
            }
            vo.setPresentUserName(value.toString());
        }
        return vo;
    }

    /**
     * @param apply
     * @param applyNo
     * @Description: 根据applyNo更新apply
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/4 14:33
     */
    @Override
    public int updateApplyByApplyNo(Apply apply, String applyNo) {
        Example example = SqlUtil.newExample(Apply.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return applyRepository.updateByExampleSelectiveData(apply,example);
    }

    /**
     * @Title:
     * @Description:  根据applyId更新申请信息状态
     * @param applyUpd
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public int updateApplyBizStsByApplyId(Apply applyUpd){
        return applyRepository.updateByPrimaryKeySelectiveData(applyUpd);
    }

    /**
     * @Title:
     * @Description:  根据订单提出账号(apply_user)获取申请信息
     * @param applyUser
     * @return Apply
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 10:14:22
     */
    public ApplyVo findApplyVoByApplyUser(String applyUser){
        return applyRepository.selectApplyVoByApplyUser(applyUser);
    }

    /**
     * @Title:
     * @Description: 保存订单信息
     * @param apply
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-26 10:14:22
     */
    @Override
    public void saveApply(Apply apply) {
        applyRepository.insertData(apply);
    }

    /**
     * @Title:
     * @Description: 修改申请信息
     * @param apply
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-26 10:14:22
     */
    @Override
    public void modifyApply(Apply apply) {
        applyRepository.updateByPrimaryKeySelectiveData(apply);
    }

    /**
     * @Title:
     * @Description: 根据订单状态获取订单信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<Apply> findApplysByBizStatus(String... bizStatus){
        Example example = SqlUtil.newExample(Apply.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotTrimBlank(bizStatus)){
            for(String status : bizStatus){
                criteria.orEqualTo("bizStatus",status);
            }
        }else {
            throw new FmsServiceException("订单状态不存在");
        }
        return applyRepository.selectListByExample(example);
    }

    /** 
    * @Description: 根据订单编号计算风险融资额，包括当前订单，当前订单不存在则抛异常
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/26 22:01
    */ 
    @Override
    public BigDecimal riskAmountWithApply(String applyNo) {

        Apply apply = this.findApplyByApplyNo(applyNo);
        if(apply == null){
            throw new FmsServiceException("当前申请信息不存在");
        }
        String certifNo = this.findApplyCertifNoByApplyNo(applyNo);
        //当前申请信息以外融资额
        BigDecimal riskAmount = this.riskAmount(applyNo, apply.getApplyType(), certifNo);
        //当前申请信息（融资额-保证金-首期租金）
        ApplyFinance applyFinanceNow = applyFinanceService.findApplyFinanceByApplyNo(applyNo);

        if(applyFinanceNow == null)
            throw new FmsServiceException("当前融资信息不存在");

        riskAmount = getBigDecimal(applyFinanceNow.getFinTotal()).subtract(getBigDecimal(applyFinanceNow.getDeposit()))
                .subtract(getBigDecimal(applyFinanceNow.getRent())).add(riskAmount);

        return riskAmount;
    }

    /**
     * @param applyNo
     * @Description: 计算风险融资额，不包括当前订单
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 11:05
     */
    @Override
    public BigDecimal riskAmount(String applyNo,String applyType,String certifNo) {
        BigDecimal riskAmount = BigDecimal.ZERO;
        //当前申请信息（融资额-保证金-首期租金）,不计算
        /*ApplyFinance applyFinanceNow = applyFinanceService.findApplyFinanceByApplyNo(applyNo);

        if(applyFinanceNow != null)
            riskAmount = getBigDecimal(applyFinanceNow.getFinTotal()).subtract(getBigDecimal(applyFinanceNow.getDeposit()))
                .subtract(getBigDecimal(applyFinanceNow.getRent()));*/

        //个人
        if(ApplyTypeEnums.PERSON.getType().equals(applyType)){
            //获取除当前applyNo对应的所有个人信息
            List<CstmPerson> cstmPersonList = cstmPersonService.findCstmPersonListByCertifNo(certifNo,applyNo);
            for(CstmPerson cstmPerson : cstmPersonList){
                //查找每一个applyNo对应的所有合同
                List<Contract> contractList = contractService.findContractsByApplyNo(cstmPerson.getApplyNo());
                if(ArrayUtils.isNullOrLengthZero(contractList)){//如果没生成合同
                    Apply apply = this.findApplyByApplyNo(cstmPerson.getApplyNo());
                    //cstmperson中的数据是变更承租人产生的，没有申请信息
                    if(apply == null){
                        continue;
                    }
                    //通过风控审批的条件(申请状态>0105 && 没有失效)
                    if(Integer.parseInt(apply.getBizStatus())>Integer.parseInt(BizStatusEnums.APPLY_VALID.getType())
                            && !BizStatusEnums.APPLY_INPUT2.getType().equals(apply.getBizStatus())//不等于待提交(风控主管审核退回)
                            && !BizStatusEnums.APPLY_INPUT3.getType().equals(apply.getBizStatus())//不等于待提交(合同生成前结束)
                            && !BizStatusEnums.APPLY_INVALID.getType().equals(apply.getBizStatus())//不是提前结束
                            && !BizStatusEnums.APPLY_CANCEL.getType().equals(apply.getBizStatus())){//没有订单取消
                        ApplyFinance applyFinance = applyFinanceService.findApplyFinanceByApplyNo(cstmPerson.getApplyNo());
                        if(applyFinance != null){
                            riskAmount = riskAmount.add(getBigDecimal(applyFinance.getFinTotal()).
                                    subtract(getBigDecimal(applyFinance.getDeposit())).
                                    subtract(getBigDecimal(applyFinance.getRent())));
                        }
                    }
                }else{//如果生成合同
                    riskAmount = riskAmount.add(getContractRiskAmount(contractList));
                }
            }
        }else{//企业
            List<CstmCompany> cstmCompanyList = cstmCompanyService.findCstmCompanyListBySocialCertifNo(certifNo,applyNo);
            for(CstmCompany cstmCompany : cstmCompanyList){
                //查找每一个applyNo对应的所有合同
                List<Contract> contractList = contractService.findContractsByApplyNo(cstmCompany.getApplyNo());
                if(ArrayUtils.isNullOrLengthZero(contractList)){//如果没生成合同
                    Apply apply = this.findApplyByApplyNo(cstmCompany.getApplyNo());
                    //cstmperson中的数据是变更承租人产生的，没有申请信息
                    if(apply == null){
                        continue;
                    }
                    //通过风控审批的条件(申请状态>0105 && 没有生效)
                    if(Integer.parseInt(apply.getBizStatus())>Integer.parseInt(BizStatusEnums.APPLY_VALID.getType())
                            && !BizStatusEnums.APPLY_INPUT2.getType().equals(apply.getBizStatus())//不等于待提交(风控主管审核退回)
                            && !BizStatusEnums.APPLY_INPUT3.getType().equals(apply.getBizStatus())//不等于待提交(合同生成前结束)
                            && !BizStatusEnums.APPLY_INVALID.getType().equals(apply.getBizStatus())
                            && !BizStatusEnums.APPLY_CANCEL.getType().equals(apply.getBizStatus())){
                        ApplyFinance applyFinance = applyFinanceService.findApplyFinanceByApplyNo(cstmCompany.getApplyNo());
                        if(applyFinance != null)
                            riskAmount = riskAmount.add(getBigDecimal(applyFinance.getFinTotal()).
                                    subtract(getBigDecimal(applyFinance.getDeposit())).
                                    subtract(getBigDecimal(applyFinance.getRent())));
                    }
                }else {//如果生成合同
                    riskAmount = riskAmount.add(getContractRiskAmount(contractList));
                }
            }
        }
        return riskAmount;
    }
    /** 
    * @Description: 计算合同的风险融资额
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/11 14:49
    */ 
    private BigDecimal getContractRiskAmount(List<Contract> contractList){
        BigDecimal riskAmount = BigDecimal.ZERO;
        for(Contract contract : contractList){
            if(BizStatusEnums.CONTRACT_EFFECT.getType().equals(contract.getBizStatus())){//合同已生效
                if(PaymentStsEnums.UNCLEARED.getType().equals(contract.getPaymentSts())){//且未结清
                    BigDecimal totalRent;
                    try {
                        //查询逾期租金合计，如果未生成还款计划表，返回-1
                        totalRent = ResponseEntityUtils.getRestResponseData(contRepaySkedRpc.findContRepaySkedRentSum(contract.getContNo()));
                    } catch (FmsRpcException e) {
                        log.error(e.getMessage());
                        e.printStackTrace();
                        throw new FmsServiceException("获取剩余租金合计信息失败");
                    }
                    if(totalRent == null || new BigDecimal("-1").compareTo(totalRent)==0){
                        throw new FmsServiceException("获取剩余租金合计信息失败");
                    }
                    ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contract.getContNo());
                    //减去保证金
                    if(contractFinanceVo != null){
                        totalRent = totalRent.subtract(getBigDecimal(contractFinanceVo.getDeposit()));
                    }
                    riskAmount = riskAmount.add(totalRent);
                }
            }else{//合同未生效
                if(!BizStatusEnums.CONTRACT_INVALID.getType().equals(contract.getBizStatus()) && !BizStatusEnums.CONTRACT_CANCEL.getType().equals(contract.getBizStatus())){//合同未失效
                    ContractFinanceVo contractFinanceVo = contractFinanceService.findContractFinanceVoByContNo(contract.getContNo());
                    if(contractFinanceVo != null)
                        riskAmount = riskAmount.add(getBigDecimal(contractFinanceVo.getFinTotal()).
                                subtract(getBigDecimal(contractFinanceVo.getDeposit())).
                                subtract(getBigDecimal(contractFinanceVo.getRent())));
                }
            }
        }
        return riskAmount;
    }


    private BigDecimal getBigDecimal(BigDecimal bigDecimal){
        if(bigDecimal == null){
            return BigDecimal.ZERO;
        }else{
            return bigDecimal;
        }
    }

    /**
     * @Title:
     * @Description:   分页查找待派单订单
     * @param applyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/22 11:43:07
     */
    public PageInfoExtend<ApplyVo> findDispatchApplyVosByPage(ApplyVo applyVo){
        applyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        applyVo.setBizStatus(BizStatusEnums.APPLY_APPROVE.getType());
        if(StringUtils.isNotTrimBlank(applyVo.getLessee()))
            applyVo.setLessee(SqlUtil.likePattern(applyVo.getLessee()));
        else
            applyVo.setLessee(null);
        if(StringUtils.isNotTrimBlank(applyVo.getApplyNo()))
            applyVo.setApplyNo(SqlUtil.likePattern(applyVo.getApplyNo()));
        else
            applyVo.setApplyNo(null);
        PageInfoExtend<ApplyVo> pageInfo = applyRepository.selectListVoByPage("selectDispatchApplyVosByPage", applyVo, applyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:   派单指定
     * @param applyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/22 02:59:29
     */
    @Transactional
    public void dispatchApply(ApplyVo applyVo){
        if(StringUtils.isTrimBlank(applyVo.getApproveUser()))
            throw new FmsServiceException("请选择审批人");
        if(ArrayUtils.isNullOrLengthZero(applyVo.getApplyNos()))
            throw new FmsServiceException("请选择需要派单的订单");
        List<ActRuTaskVo> actRuTaskVos = null;
        try {
            actRuTaskVos = ResponseEntityUtils.getRestResponseData(actRuTaskRpc.findActRuTasksByBusinessKeys(applyVo.getApplyNos()));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取派单任务失败");
        }
        List<String> taskIds = new ArrayList<>();
        for(ActRuTaskVo actRuTaskVo : actRuTaskVos){
            if(!ActContGenerationFlagEnums.CONTRACT_GENERATION_RISK.getFlag().equals(actRuTaskVo.getTaskDefKey())){
                throw new FmsServiceException(actRuTaskVo.getBusinessKey() + "的任务已不在初审节点");
            }
            taskIds.add(actRuTaskVo.getId());
            //修改流程中的对应人参数
            ActContractGenerationUtils.modifyRiskUser(actRuTaskVo.getExecutionId(),applyVo.getApproveUser());
        }
        //修改任务表对应人
        actRuTaskRepository.updateActRuTasksAssigneeByIds(taskIds,applyVo.getApproveUser());
        modifyApplysApproveUser(applyVo.getApplyNos(),applyVo.getApproveUser());
    }

    /**
     * @Title:
     * @Description: 根据申请编号更新风控初审人员
     * @param:  applyNos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/2 0002 14:05
     */
    private List<Apply> modifyApplysApproveUser(List<String> applyNos,String approveUser){
        if (ArrayUtils.isNotNullAndLengthNotZero(applyNos)){
            Example example = SqlUtil.newExample(Apply.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andIn("applyNo",applyNos);
            Apply apply = new Apply();
            apply.setApproveUser(approveUser);//跟新被派单人
            apply.setPresentUser(approveUser);//更新当前审批人
            applyRepository.updateByExampleSelectiveData(apply,example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 根据申请编号查询订单详情
     * @param: applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 14:53
     */
    public ApplyVo findApplyVoDetailByApplyNo(String applyNo){
        if (StringUtils.isNotTrimBlank(applyNo)) {
            Apply apply = findApplyByApplyNo(applyNo);
            ApplyVo applyVo = EntityUtils.getEntity(apply,new ApplyVo());
            if(applyVo != null) {
                if (ApplyTypeEnums.PERSON.getType().equals(applyVo.getApplyType())) {
                    applyVo.setCstmPersonVo(EntityUtils.getEntity(cstmPersonService.findCstmPersonByApplyNo(applyNo),new CstmPersonVo())); ;
                } else {
                    applyVo.setCstmCompanyVo(EntityUtils.getEntity(cstmCompanyService.findCstmCompanyByApplyNo(applyNo),new CstmCompanyVo()));
                }
            }
            return applyVo;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 取到订单申请人的证件号码
     * @param: applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:32
     */
    public String findApplyCertifNoByApplyNo(String applyNo){
        //取到订单申请人的证件号码
        ApplyVo applyVo = findApplyVoDetailByApplyNo(applyNo);
        if(applyVo != null) {
            if (ApplyTypeEnums.PERSON.getType().equals(applyVo.getApplyType())) {
                if(applyVo.getCstmPersonVo() != null)
                    return applyVo.getCstmPersonVo().getCertifNo();
            }else{
                if(applyVo.getCstmCompanyVo() != null)
                    return applyVo.getCstmCompanyVo().getSocialCertifNo();
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 取到订单申请人的财务辅助核算代码
     * @param: applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:32
     */
    public String findApplyFinassCstmCodeByApplyNo(String applyNo){
        //取到订单申请人的证件号码
        ApplyVo applyVo = findApplyVoDetailByApplyNo(applyNo);
        if(applyVo != null) {
            if (ApplyTypeEnums.PERSON.getType().equals(applyVo.getApplyType())) {
                if(applyVo.getCstmPersonVo() != null) {
                    CrmPerson crmPerson = crmPersonService.findCrmPerByCertifNo(applyVo.getCstmPersonVo().getCertifNo());
                    if(crmPerson != null)
                        return crmPerson.getFinassCstmCode();
                }
            }else{
                if(applyVo.getCstmCompanyVo() != null) {
                    CrmCompany crmCompany = crmCompanyService.findCrmCompByCertifNo(applyVo.getCstmCompanyVo().getSocialCertifNo());
                    if(crmCompany != null)
                         return crmCompany.getFinassCstmCode();
                }
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请订单相关的财务核算代码
     * @param:  applyNo
     * @param:  contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    public ApplyVo findApplyVoFinassCodesByApplyNo(String applyNo,String contNo){
        ApplyVo applyVo = new ApplyVo();
        applyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        applyVo.setApplyNo(applyNo);
        applyVo.setContNo(contNo);
        return applyRepository.selectApplyVoFinassCodesByApplyNo(applyVo);
    }

    /**
     * @Title:
     * @Description:  根据codeValue和codeType查询
     * @param sysCodeVo
     * @return SysCode
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    private SysCode findSysCodeByCodeValue(SysCodeVo sysCodeVo){
        Example example=SqlUtil.newExample(SysCode.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeType()))
            criteria.andEqualTo("codeType",sysCodeVo.getCodeType());
        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeValue()))
            criteria.andEqualTo("codeValue",sysCodeVo.getCodeValue());
        SqlUtil.setOrderByCreateTimeDesc(example);
        return sysCodeRepository.selectOneByExample(example);
    }

}
