package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContBaseInfoVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同信息业务实现层
 * @date 2018-03-23
 */
@Service
public class ContractServiceImpl implements ContractService {

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;

    /**
     * @Title:
     * @Description: 分页查询合同信息
     * @param contractVo
     * @return PageInfoExtend<Contract>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public PageInfoExtend<Contract> findContractsByPage(ContractVo contractVo){
        Example example = SqlUtil.newExample(Contract.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<Contract> pageInfo = contractRepository.selectListByExamplePage(example,contractVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param contractListVo
     * @Description: 分页查询合同一览信息
     * @Param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/27 17:04
     */
    @Override
    public PageInfoExtend<ContractListVo> findContractListByPage(ContractListVo contractListVo,SysUserVo sysUser) {
        //合同号
        if(StringUtils.isTrimBlank(contractListVo.getContNo()))
            contractListVo.setContNo(null);
        else
            contractListVo.setContNo(SqlUtil.likePattern(contractListVo.getContNo()));

        //申请编号
        if (StringUtils.isTrimBlank(contractListVo.getApplyNo()))
            contractListVo.setApplyNo(null);
        else
            contractListVo.setApplyNo(SqlUtil.likePattern(contractListVo.getApplyNo()));

        //客户姓名
        if(StringUtils.isTrimBlank(contractListVo.getName()))
            contractListVo.setName(null);
        else
            contractListVo.setName(SqlUtil.likePattern(contractListVo.getName()));

        //申请类型
        if(StringUtils.isTrimBlank(contractListVo.getCompanyType1()))
            contractListVo.setCompanyType1(null);
        else
            contractListVo.setCompanyType1(contractListVo.getCompanyType1());

        //申请状态
        if(StringUtils.isTrimBlank(contractListVo.getBizStatus()))
            contractListVo.setBizStatus(null);
        else
            contractListVo.setBizStatus(contractListVo.getBizStatus());

        //出租人区域
        if(StringUtils.isTrimBlank(contractListVo.getGroupDistrict()))
            contractListVo.setGroupDistrict(null);
        else
            contractListVo.setGroupDistrict(SqlUtil.likePattern(contractListVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(contractListVo.getVinNo()))
            contractListVo.setVinNo(null);
        else
            contractListVo.setVinNo(SqlUtil.likePattern(contractListVo.getVinNo()));

        //产品名称
        if(StringUtils.isTrimBlank(contractListVo.getProductName()))
            contractListVo.setProductName(null);
        else
            contractListVo.setProductName(SqlUtil.likePattern(contractListVo.getProductName()));

        //合同生效日期区间(起始)
        if(StringUtils.isTrimBlank(contractListVo.getValidStartTime()))
            contractListVo.setValidStartTime(null);
        else
            contractListVo.setValidStartTime(contractListVo.getValidStartTime());
        //合同生效日期区间(结束)
        if(StringUtils.isTrimBlank(contractListVo.getValidEndTime()))
            contractListVo.setValidEndTime(null);
        else
            contractListVo.setValidEndTime(contractListVo.getValidEndTime());

        //合同生成日期区间(起始)
        if(StringUtils.isTrimBlank(contractListVo.getValidStartTime2()))
            contractListVo.setValidStartTime2(null);
        else
            contractListVo.setValidStartTime2(contractListVo.getValidStartTime2());
        //合同生成日期区间(结束)
        if(StringUtils.isTrimBlank(contractListVo.getValidEndTime2()))
            contractListVo.setValidEndTime2(null);
        else
            contractListVo.setValidEndTime2(contractListVo.getValidEndTime2());
        //业务类型
        if(StringUtils.isTrimBlank(contractListVo.getLicenseAttr()))
            contractListVo.setLicenseAttr(null);
        else
            contractListVo.setLicenseAttr(contractListVo.getLicenseAttr());
        //担保人
        if(StringUtils.isNotTrimBlank(contractListVo.getGuarantee())){
            contractListVo.setGuarantee(SqlUtil.likePattern(contractListVo.getGuarantee()));
        }else{
            contractListVo.setGuarantee(null);
        }

        //申请类型
        if(StringUtils.isTrimBlank(contractListVo.getPaymentSts()))
            contractListVo.setPaymentSts(null);
        else
            contractListVo.setPaymentSts(contractListVo.getPaymentSts());

        //还款日
        if(StringUtils.isTrimBlank(contractListVo.getRepayDay()))
            contractListVo.setRepayDay(null);
        else
            contractListVo.setRepayDay(contractListVo.getRepayDay());

        //租赁期限开始日
        if(StringUtils.isTrimBlank(contractListVo.getLeaseTermStartDate()))
            contractListVo.setLeaseTermStartDate(null);
        else
            contractListVo.setLeaseTermStartDate(contractListVo.getLeaseTermStartDate());

        //租赁期限结束日
        if(StringUtils.isTrimBlank(contractListVo.getLeaseTermEndDate()))
            contractListVo.setLeaseTermEndDate(null);
        else
            contractListVo.setLeaseTermEndDate(contractListVo.getLeaseTermEndDate());

        //租赁期限结束日起始
        if(StringUtils.isNotTrimBlank(contractListVo.getStartTimeLeaseTermEnd()))
            contractListVo.setStartTimeLeaseTermEnd(contractListVo.getStartTimeLeaseTermEnd());
        else
            contractListVo.setStartTimeLeaseTermEnd(null);
        //租赁期限结束日结束
        if(StringUtils.isNotTrimBlank(contractListVo.getEndTimeLeaseTermEnd()))
            contractListVo.setEndTimeLeaseTermEnd(contractListVo.getEndTimeLeaseTermEnd());
        else
            contractListVo.setEndTimeLeaseTermEnd(null);

        //车牌号
        if(StringUtils.isTrimBlank(contractListVo.getVehicleLicenseNo()))
            contractListVo.setVehicleLicenseNo(null);
        else
            contractListVo.setVehicleLicenseNo(SqlUtil.likePattern(contractListVo.getVehicleLicenseNo()));

        //款项状态
        if(StringUtils.isTrimBlank(contractListVo.getFundStatus()))
            contractListVo.setFundStatus(null);
        else
            contractListVo.setFundStatus(contractListVo.getFundStatus());


        //设置个人标志
        contractListVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());
        //设置企业标志
        contractListVo.setCompanyFlag(ApplyTypeEnums.COMPANY.getType());
        //用于取成交价
        contractListVo.setFinItem(FinItemEnums.CARPRICE.getCode());
        //根据用户条件进行筛选

        //PageInfoExtend<ContractListVo> pageInfo = contractRepository.selectListVoByPage("selectContractListByPage", contractListVo, contractListVo.getPageQuery());
        return screening(contractListVo,sysUser);
    }

    /**
     * @param contractListVo
     * @Description: 当月新增放款车辆明细查询合同一览信息
     * @Param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/27 17:04
     */
    @Override
    public PageInfoExtend<ContractListVo> findNewLoanByPage(ContractListVo contractListVo,SysUserVo sysUser){
        contractListVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        return this.findContractListByPage(contractListVo,sysUser);
    }

    /**
     * @param contractListVo
     * @Description: 当月新增放款车辆明细导出
     * @Param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/27 17:04
     */
    @Override
    public PageInfoExtend<ContractListVo> findNewLoanExport(ContractListVo contractListVo,SysUserVo sysUser){
        if(StringUtils.isTrimBlank(contractListVo.getCensuMonth())) {
            contractListVo.setCensuMonth(DateUtils.dateToStr(new Date(), DateUtils.formatStr_yyyyMM));//月份为空时，默认为当前月
        }
        else {
            contractListVo.setCensuMonth(contractListVo.getCensuMonth());
        }
        contractListVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        PageInfoExtend<ContractListVo> contractListVoList = this.findContractListByPage(contractListVo,sysUser);
        //增加合计行
        ContractListVo vo = new ContractListVo();
        BigDecimal investTotal = BigDecimal.ZERO;//申请金额
        BigDecimal initAmount = BigDecimal.ZERO;//首付金额
        BigDecimal finTotal = BigDecimal.ZERO;//融资金额
        BigDecimal loanInterest = BigDecimal.ZERO;//贷款利息
        BigDecimal deposit = BigDecimal.ZERO;//保证金
        BigDecimal finalAmount = BigDecimal.ZERO;//尾付金额
        BigDecimal carpriceFee = BigDecimal.ZERO;//购车合同金额
        for(ContractListVo contractList:contractListVoList.getData()){
            //申请金额
            BigDecimal it = contractList.getInvestTotal()==null ? BigDecimal.ZERO : contractList.getInvestTotal();
            investTotal=investTotal.add(it);
            //首付金额
            BigDecimal ia = contractList.getInitAmount()==null ? BigDecimal.ZERO : contractList.getInitAmount();
            initAmount=initAmount.add(ia);
            //融资金额
            BigDecimal ft = contractList.getFinTotal()==null ? BigDecimal.ZERO : contractList.getFinTotal();
            finTotal=finTotal.add(ft);
            //贷款利息
            BigDecimal li = contractList.getLoanInterest()==null ? BigDecimal.ZERO : contractList.getLoanInterest();
            loanInterest=loanInterest.add(li);
            //保证金
            BigDecimal dt = contractList.getDeposit()==null ? BigDecimal.ZERO : contractList.getDeposit();
            deposit=deposit.add(dt);
            //尾付金额
            BigDecimal fa = contractList.getFinalAmount()==null ? BigDecimal.ZERO : contractList.getFinalAmount();
            finalAmount=finalAmount.add(fa);
            //购车合同金额
            BigDecimal cf = contractList.getCarpriceFee()==null ? BigDecimal.ZERO : contractList.getCarpriceFee();
            carpriceFee=carpriceFee.add(cf);
        }
        vo.setInvestTotal(investTotal); //申请金额
        vo.setInitAmount(initAmount);//首付金额
        vo.setFinTotal(finTotal);//融资金额
        vo.setLoanInterest(loanInterest);//贷款利息
        vo.setDeposit(deposit);//保证金
        vo.setFinalAmount(finalAmount);//尾付金额
        vo.setCarpriceFee(carpriceFee);//购车合同金额
        vo.setContractValidDate("合计");
        contractListVoList.getData().add(vo);//增加合计行
        return contractListVoList;
    }

    /**
    * @Description: 合同一览信息选择
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/28 17:03
    */
    @Override
    public PageInfoExtend<ContractListVo> findContractSelectListByPage(ContractListVo contractListVo, SysUserVo sysUser) {
        //合同号
        if(StringUtils.isTrimBlank(contractListVo.getContNo()))
            contractListVo.setContNo(null);
        else
            contractListVo.setContNo(SqlUtil.likePattern(contractListVo.getContNo()));

        //客户姓名
        if(StringUtils.isTrimBlank(contractListVo.getName()))
            contractListVo.setName(null);
        else
            contractListVo.setName(SqlUtil.likePattern(contractListVo.getName()));

        //出租人区域
        if(StringUtils.isTrimBlank(contractListVo.getGroupDistrict()))
            contractListVo.setGroupDistrict(null);
        else
            contractListVo.setGroupDistrict(SqlUtil.likePattern(contractListVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(contractListVo.getVinNo()))
            contractListVo.setVinNo(null);
        else
            contractListVo.setVinNo(SqlUtil.likePattern(contractListVo.getVinNo()));


        //设置扣款状态
        contractListVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        //设置当前日期
        contractListVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
        //合同生效状态
        contractListVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        PageInfoExtend<ContractListVo> pageInfo = contractRepository.selectListVoByPage("selectContractSelectListByPage", contractListVo, contractListVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Description: 分页查询申请一览信息过滤条件
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/3 18:32
     */
    public PageInfoExtend<ContractListVo> screening(ContractListVo contractListVo,SysUserVo sysUser){
            List<String> roleList = new ArrayList<>();
        sysUser.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        for(SysRole role:sysUser.getRoles()){
            roleList.add(role.getRole());
        }
        PageInfoExtend<ContractListVo> pageInfo = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            contractListVo.setSysUser(sysUser.getUser());
             pageInfo = contractRepository.selectListVoByPage("selectContractListByPage", contractListVo, contractListVo.getPageQuery());
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
            contractListVo.setSysUserGroup(groupCodes);
            pageInfo = contractRepository.selectListVoByPage("selectContractListByPage", contractListVo, contractListVo.getPageQuery());
        }else{
             pageInfo = contractRepository.selectListVoByPage("selectContractListByPage", contractListVo, contractListVo.getPageQuery());
        }
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据contractId获取合同信息
     * @param contractId
     * @return Contract
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public Contract findContractByContractId(String contractId){
        return contractRepository.selectByPrimaryKey(contractId);
    }
    /**
     * @Title:
     * @Description:  根据contNo获取合同信息
     * @param contNo
     * @return Contract
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public Contract findContractByContractNo(String contNo){
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        return contractRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取合同详情顶部信息
     * @param contNo
     * @return ApplyBaseInfoVo
     * @throws
     * @author huzongcheng
     */
    public ContBaseInfoVo findContBaseInfo(String contNo){
        Contract contract = findContractByContractNo(contNo);
        if(contract == null){
            throw new FmsServiceException("该合同不存在");
        }
        ContBaseInfoVo vo = new ContBaseInfoVo();
        vo.setContNo(contNo);
        vo.setBizStatus(contract.getBizStatus());
        vo.setPaymentSts(contract.getPaymentSts());
        if(StringUtils.isNotTrimBlank(contract.getPresentUser())){
            List<String> userList = ArrayUtils.asList(contract.getPresentUser().split(","));
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
     * @Title:
     * @Description:  根据contNo获取合同信息
     * @param contNo
     * @return Contract
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @Override
    public ContractVo findContractVoByContractNo(String contNo) {
        return contractRepository.selectContractVoByContractNo(contNo);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取合同信息
     * @param contNo
     * @return ContCreateVo
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:48:00
     */
    public ContCreateVo findContCreateDetailByContNo(String contNo){
        return contractRepository.selectContCreateDetailByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:  根据contractId更新申请信息状态
     * @param contractId
     * @param bizStatus
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:22
     */
    public int updateContBizStsByContractId(String contractId, String bizStatus){
        Contract contract = new Contract();
        contract.setContractId(contractId);
        contract.setBizStatus(bizStatus);
        return contractRepository.updateByPrimaryKeySelectiveData(contract);
    }

    /**
     * @Title:
     * @Description:  批量登录合同信息
     * @param contracts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public int insertContracts(List<Contract> contracts){
        return contractRepository.insertDataList(contracts);
    }
    /**
     * @Title:
     * @Description:  修改合同
     * @param contract
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public int updateContractByContractId(Contract contract, String contractId){
        contract.setContractId(contractId);
        return contractRepository.updateByPrimaryKeySelectiveData(contract);
    }

    /**
     * @Title:
     * @Description: 根据合同状态集合获取订单信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<Contract> findContractsBybizStatusList(List<String> bizStatusList){
        Example example = SqlUtil.newExample(Contract.class);
        Example.Criteria criteria = example.createCriteria();
        if (ArrayUtils.isNotNullAndLengthNotZero(bizStatusList)){
            criteria.andIn("bizStatus",bizStatusList);
        }
        List<Contract> contracts = contractRepository.selectListByExample(example);
        return contracts;
    }
    /**
     * @Title:
     * @Description:  根据状态查找合同
     * @param contract
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    public List<Contract> findContractsByContractStatus(Contract contract){
        Example example  = SqlUtil.newExample(Contract.class);
        Example.Criteria criteria =  example.createCriteria();
        if(StringUtils.isNotTrimBlank(contract.getBizStatus())){
            criteria.andEqualTo("bizStatus",contract.getBizStatus());
        }
        if(StringUtils.isNotTrimBlank(contract.getPaymentSts())){
            criteria.andEqualTo("paymentSts",contract.getPaymentSts());
        }
        return contractRepository.selectListByExample(example);
    }

    /**
     * @param applyNo
     * @Description: 根据applyNo查询所有合同
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 13:44
     */
    @Override
    public List<Contract> findContractsByApplyNo(String applyNo) {
        Example example =SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return contractRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请合同相关的财务核算代码
     * @param:  contractVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    public ContractVo findContractVoFinassCodes(String applyNo,String contNo){
        ContractVo contractVo = new ContractVo();
        contractVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        contractVo.setApplyNo(applyNo);
        contractVo.setContNo(contNo);
        return contractRepository.selectContractVoFinassCodes(contractVo);
    }

    /**
     * @param contract
     * @param contNo
     * @Description: 根据合同号更新
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/4 10:05
     */
    @Override
    public int updateContractByContNo(Contract contract, String contNo) {
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        return contractRepository.updateByExampleSelectiveData(contract,example);
    }

    /**
     * @Description: 验证车架号是否存在，存在返回true
     * @param: [contNo, vinNo]
     * @return: boolean
     * @Author: yangyiquan
     * @Date: 2018/7/14 20:42
     */
    @Override
    public boolean validVinNo(String contNo, String vinNo) {
        if(StringUtils.isTrimBlank(contNo))
            throw new FmsServiceException("合同编号不能为空");
        if(StringUtils.isTrimBlank(vinNo))
            throw new FmsServiceException("车架号不能为空");
        boolean validVinNoResult = false;//默认不存在
        Example example = SqlUtil.newExample(Contract.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("vinNo", vinNo).andNotEqualTo("contNo", contNo).andNotEqualTo("bizStatus", BizStatusEnums.CONTRACT_INVALID.getType())
            .andNotEqualTo("bizStatus", BizStatusEnums.CONTRACT_CANCEL.getType());
        List<Contract> contractList = contractRepository.selectListByExample(example);
        if(ArrayUtils.isNotNullAndLengthNotZero(contractList))
            validVinNoResult = true;//存在
        return validVinNoResult;
    }

}
