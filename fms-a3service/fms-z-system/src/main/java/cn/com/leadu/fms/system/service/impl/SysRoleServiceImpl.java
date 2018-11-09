package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApproveAgreeFlagEnums;
import cn.com.leadu.fms.common.constant.enums.system.HomeApproveStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.system.repository.SysRoleMenuRepository;
import cn.com.leadu.fms.data.system.repository.SysRoleRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRoleRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.system.entity.*;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import cn.com.leadu.fms.pojo.system.vo.desk.RoleApproveVo;
import cn.com.leadu.fms.pojo.system.vo.desk.RoleDeskVo;
import cn.com.leadu.fms.pojo.system.vo.sysrole.SysRoleVo;
import cn.com.leadu.fms.system.service.SysCodeService;
import cn.com.leadu.fms.system.service.SysRoleResourceService;
import cn.com.leadu.fms.system.service.SysRoleService;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleModifyVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleServiceImpl
 * @Description: 角色业务层
 * @date 2018/1/12
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysRoleResourceService sysRoleResourceService;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private CommonConstantService commonConstantService;

    @Autowired
    private SysCodeService sysCodeService;

    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;

    @Autowired
    private ApplyRepository applyRepository;

    @Autowired
    private ContractRepository contractRepository;

    private final String HOME_APPRVE_CONSTANTS = "homeApprveConstants_";

    /**
     * @Title:
     * @Description: 保存角色
     * @param sysRoleSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    @Transactional
    public void saveSysRole(SysRoleSaveVo sysRoleSaveVo){
        sysRoleRepository.insertData(sysRoleSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 根据角色名分页查询角色,按照新增时间分页
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    public PageInfoExtend<SysRole> findSysRolesByPage(SysRoleVo sysRoleVo){
        Example example = SqlUtil.newExample(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysRoleVo.getRoleName()))
            criteria.andLike("roleName",SqlUtil.likePattern(sysRoleVo.getRoleName()));
        SqlUtil.setOrderByCreateTimeDesc(example);
        return sysRoleRepository.selectListByExamplePage(example,sysRoleVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 修改角色
     * @param sysRoleModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    @Transactional
    public void modifySysRole(SysRoleModifyVo sysRoleModifyVo){
        sysRoleRepository.updateByPrimaryKeySelectiveData(sysRoleModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id删除角色
     * @param sysRoleDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    @Transactional
    public void deleteSysRole(SysRoleDeleteVo sysRoleDeleteVo){
        sysRoleRepository.deleteData(sysRoleDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param roleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    public SysRole findSysRoleById(String roleId){
        return sysRoleRepository.selectByPrimaryKey(roleId);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除角色
     * @param sysRoleDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @Transactional
    public void deleteSysRolesByIds(SysRoleDeleteListVo sysRoleDeleteListVo){
        if(ArrayUtils.isNotNullAndLengthNotZero(sysRoleDeleteListVo.getIds())){
            Example exple = SqlUtil.newExample(SysUserRole.class);
            for(String roleId :sysRoleDeleteListVo.getIds()){
                exple.createCriteria().andEqualTo("roleId",roleId);
                List<SysUserRole> list =  sysUserRoleRepository.selectListByExample(exple);
                if(list.size()!=0){
                    throw new FmsServiceException( "用户角色不可删除");
                }
            }
            Example example = SqlUtil.newExample(SysRoleMenu.class);
            for(String roleId :sysRoleDeleteListVo.getIds()){
                example.createCriteria().andEqualTo("roleId",roleId);
                sysRoleMenuRepository.deleteExampleData(example,new SysRoleMenu());
                Example example1 = SqlUtil.newExample(SysUserRole.class);
                example1.createCriteria().andEqualTo("roleId",roleId);
                sysUserRoleRepository.deleteExampleData(example1,new SysUserRole());
            }
            sysRoleRepository.deleteDataList(sysRoleDeleteListVo.getIds(),sysRoleDeleteListVo.getEntity());
        }
    }

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色id集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 12:02:28
     */
    public List<String> findSysRoleIdsBySysUserId(String sysUserId){
        List<String> sysRoleIds = null;
        if(StringUtils.isNotTrimBlank(sysUserId))
            sysRoleIds = sysRoleRepository.selectSysRoleIdsBySysUserId(sysUserId);
        return sysRoleIds;
    }

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 01:57:26
     */
    public List<SysRole> findSysRolesBySysUserId(String sysUserId){
        List<SysRole> sysRoles = null;
        if(StringUtils.isNotTrimBlank(sysUserId))
            sysRoles = sysRoleRepository.selectSysRolesBySysUserId(sysUserId);
        return sysRoles;
    }
    /**
     * 根据code获取角色
     * @param role
     * @return
     */
    @Override
    public SysRole findSysRoleByRole(String role) {
        if(StringUtils.isNotTrimBlank(role)) {
            Example example = SqlUtil.newExample(SysRole.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("role", role);
            SqlUtil.andEqualToDeleteExist(criteria);
            List<SysRole> sysRoleList = sysRoleRepository.selectListByExample(example);
            if (ArrayUtils.isNotNullAndLengthNotZero(sysRoleList))
                return sysRoleList.get(0);
        }
        return null;
    }

    /**
     * 找到所有的角色
     * @return
     */
    @Override
    public List<SysRole> findAllRoles() {
        return sysRoleRepository.findAllRoles();
    }

    /**
     * 找某角色对应的应该显示的审批情况集合
     * @return
     */
    @Override
    public RoleDeskVo findApproveInfo(SysUser sysUser, String searchType) {
        //根据用户id取得用户角色集合
        List<SysRole> roles = findSysRolesBySysUserId(sysUser.getUserId());
        //遍历角色集合得到角色code集合
        List<String> roleList = new ArrayList<>();
        for(SysRole role:roles){
            roleList.add(role.getRole());
        }
        //初始化查询条件-订单提出人
        String submitUser = null;
        //初始化查询条件-订单提出机构
        List<String> groupCodes = null;
        if(roleList.contains(SysRoleEnums.YW.getId())){
            submitUser = sysUser.getUser();
        } else if(roleList.contains(SysRoleEnums.QY.getId())){
            groupCodes = new ArrayList();
            groupCodes.add(sysUser.getGroupCode());
            Example example = SqlUtil.newExample(SysGroupParent.class);
            example.createCriteria().andEqualTo("parentGroup",sysUser.getGroupCode());
            List<SysGroupParent> groups = sysGroupParentRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(groups)){
                for(SysGroupParent group:groups){
                    groupCodes.add(group.getGroupCode());
                }
            }
        }
        //初始化所有主页模块集合
        HashSet<String> keySet = new HashSet();
        if (buildHomeData(roles, keySet)) return null;
        //取出首页审批模块所有的数据字典
        List<SysCode> sysCodeList = sysCodeService.findSysCodesByCodeType(CommonCodeTypeConstants.HOME_APPROVE);
        if(ArrayUtils.isNullOrLengthZero(sysCodeList)) return null;
        //new一个返回的结果集
        RoleDeskVo result = new RoleDeskVo();
        //查询参数载体
        DeskSearchVo searchVo = new DeskSearchVo();
        searchVo.setSearchType(searchType);
        searchVo.setSysUser(submitUser); //设定共通查询条件:订单提出人
        searchVo.setSysUserGroup(groupCodes); //设定共通查询条件:订单提出机构
        // 设值：本月融资额
        result.setAmount(applyRepository.selectFinTotal(searchVo));
        // 设值：本月放款数
        result.setLoanCount(applyRepository.selectLoanCount(searchVo));
        // 查询本月申请订单的订单集合
        List<Apply> applyList = applyRepository.selectApplyCount(searchVo);
        List<String> applyNoList = new ArrayList(); //所有订单编号集合
        List<String> applyNoListSubmit = new ArrayList(); //待提交订单编号集合
        List<String> applyNoListConfirm = new ArrayList(); //待确认订单编号集合
        List<String> applyNoListPass = new ArrayList(); //已通过订单编号集合
        List<String> applyNoListCondition = new ArrayList(); //有条件同意订单编号集合
        List<String> applyNoListRefuse = new ArrayList(); //已拒绝订单编号集合
        List<String> applyNoListCancel = new ArrayList(); //已取消订单编号集合
        if(ArrayUtils.isNullOrLengthZero(applyList)){ //如果订单编号为空，则申请数量设为"0/0"
            result.setApplyCount("0/0");
        } else { //如果不为空
            //遍历订单集合,按照状态分配给不同状态的订单编号集合
            assignListByStatus(applyList, applyNoList, applyNoListSubmit, applyNoListConfirm, applyNoListPass, applyNoListCondition, applyNoListRefuse, applyNoListCancel);
            // 查询车辆数量并赋值
            searchVo.setApplyNoList(applyNoList);
            result.setApplyCount(applyNoList.size() + "/" + applyRepository.selectVehicleCount(searchVo));
        }
        //构建工作台需要展示的模块数据
        List<RoleApproveVo> resultList = buildDeskModule(keySet, sysCodeList, result, searchVo, applyNoList, applyNoListSubmit, applyNoListConfirm, applyNoListPass, applyNoListCondition, applyNoListRefuse, applyNoListCancel);
        result.setModules(resultList);
        return result;
    }

    /**
     * 构建工作台需要展示的模块数据
     *
     * @param keySet 需要展示的主页模块集合
     * @param sysCodeList 主页模块数据字典集合
     * @param result 结果集
     * @param searchVo 检索条件
     * @param applyNoList 总的申请编号集合
     * @param applyNoListSubmit //待提交的申请编号集合
     * @param applyNoListConfirm //待确认的申请编号集合
     * @param applyNoListPass //已通过的申请编号集合
     * @param applyNoListCondition //有条件通过的申请编号集合
     * @param applyNoListRefuse //已拒绝的申请编号集合
     * @param applyNoListCancel //已取消的申请编号集合
     * @return
     */
    private List<RoleApproveVo> buildDeskModule(HashSet<String> keySet, List<SysCode> sysCodeList, RoleDeskVo result,
            DeskSearchVo searchVo, List<String> applyNoList, List<String> applyNoListSubmit,
            List<String> applyNoListConfirm, List<String> applyNoListPass, List<String> applyNoListCondition,
            List<String> applyNoListRefuse, List<String> applyNoListCancel) {
        List<RoleApproveVo> resultList = new ArrayList();
        RoleApproveVo vo;
        //遍历首页审批数据字典集合
        for(SysCode sysCode : sysCodeList){
            //如果有该角色对应的审批模块，则加入到结果集中
            if(keySet.contains(sysCode.getCodeValue())){
                vo = new RoleApproveVo();
                vo.setName(sysCode.getCodeValueName()); //模块名称
                vo.setCode(sysCode.getCodeValue()); //模块code,跳转入参用
                vo.setIconUrl(sysCode.getAppendValue()); //模块icon的url
                String codeValue = sysCode.getCodeValue(); //数据字典值
                if(ArrayUtils.isNullOrLengthZero(applyNoList)){ //如果本月尚无申请单子的情况下，则申请相关的值都设为"0/0"
                    if(!HomeApproveStatusEnums.ORIGIN.getType().equals(sysCode.getCodeValue()) //不是待归档、待放款、待请款
                            && !HomeApproveStatusEnums.LOAN.getType().equals(sysCode.getCodeValue())
                            && !HomeApproveStatusEnums.REQUEST_FUNDS.getType().equals(sysCode.getCodeValue())){
                        vo.setCount("0/0");
                    }
                } else {
                    if(HomeApproveStatusEnums.SUBMIT.getType().equals(codeValue)) //待提交
                        if (ArrayUtils.isNullOrLengthZero(applyNoListSubmit)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListSubmit);
                            vo.setCount(applyNoListSubmit.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                    else if(HomeApproveStatusEnums.CONFIRM.getType().equals(codeValue)) //待确认
                        if (ArrayUtils.isNullOrLengthZero(applyNoListConfirm)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListConfirm);
                            vo.setCount(applyNoListConfirm.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                    else if(HomeApproveStatusEnums.PASS.getType().equals(codeValue)) //已通过
                        if (ArrayUtils.isNullOrLengthZero(applyNoListPass)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListPass);
                            vo.setCount(applyNoListPass.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                    else if(HomeApproveStatusEnums.CONDITION_PASS.getType().equals(codeValue)) //有条件通过
                        if (ArrayUtils.isNullOrLengthZero(applyNoListCondition)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListCondition);
                            vo.setCount(applyNoListCondition.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                    else if(HomeApproveStatusEnums.REFUSE.getType().equals(codeValue)) //已拒绝
                        if (ArrayUtils.isNullOrLengthZero(applyNoListRefuse)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListRefuse);
                            vo.setCount(applyNoListRefuse.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                    else if(HomeApproveStatusEnums.CANCEL.getType().equals(codeValue)) //已取消
                        if (ArrayUtils.isNullOrLengthZero(applyNoListCancel)) {
                            vo.setCount("0/0"); //如果订单编号集合为空则设为"0/0"
                        } else{
                            //不为空则进行查询
                            searchVo.setApplyNoList(applyNoListCancel);
                            vo.setCount(applyNoListCancel.size() + "/" + applyRepository.selectVehicleCount(searchVo));
                        }
                }

                if(HomeApproveStatusEnums.REQUEST_FUNDS.getType().equals(codeValue)) { //待请款
                    searchVo.setContractStatus(BizStatusEnums.CONTRACT_CANCEL.getType()); //合同状态不是已取消
                    vo.setCount(String.valueOf(contractRepository.selectRequestCount(searchVo)));
                }else if(HomeApproveStatusEnums.LOAN.getType().equals(codeValue)) { //待放款
                    searchVo.setContractStatus(BizStatusEnums.CONTRACT_CANCEL.getType()); //合同状态不是已取消
                    vo.setCount(String.valueOf(contractRepository.selectLoanCount(searchVo)));
                }else if(HomeApproveStatusEnums.ORIGIN.getType().equals(codeValue) || HomeApproveStatusEnums.ORIGIN1.getType().equals(codeValue)) { //待归档
                    searchVo.setOrigStatus(OrigFileStatusEnums.VERIFIED.getType()); //归档状态为待归档
                    vo.setCount(String.valueOf(contractRepository.selectOriginCount(searchVo)));
                }
                vo.setRouterUrl(sysCode.getMemo());//跳转url
                resultList.add(vo);
            }
        }
        //如果有"审批中"模块，则计算审批中数量
        if(keySet.contains(HomeApproveStatusEnums.APPROVE.getType())){
            //获取审批中的订单数量
            Long approveCount = Long.valueOf((applyNoList.size() - applyNoListSubmit.size() - applyNoListConfirm.size()
                    - applyNoListPass.size() - applyNoListCondition.size() - applyNoListRefuse.size() - applyNoListCancel.size()));
            //获取审批中的车辆数量
            Long vehicleCount = Long.parseLong(result.getApplyCount().split("/")[1]); //车辆总数量
            //总数量依次减去其他状态的车辆数量
            for(RoleApproveVo item : resultList){
                if(StringUtils.isNotTrimBlank(item.getCount()) && item.getCount().contains("/")) { //订单相关状态的做相减
                    vehicleCount = vehicleCount - Long.parseLong(item.getCount().split("/")[1]);
                }
            }
            //再循环一次，给审批中数量设值
            for(RoleApproveVo item : resultList){
                //替换审批中数据的count为上面计算好的数值
                if(HomeApproveStatusEnums.APPROVE.getDesc().equals(item.getName())){
                    item.setCount(approveCount + "/" + vehicleCount);
                }
            }
        }
        return resultList;
    }

    /**
     * 按照状态分配给不同状态的订单编号集合
     * @param applyList
     * @param applyNoListSubmit
     * @param applyNoListConfirm
     * @param applyNoListPass
     * @param applyNoListCondition
     * @param applyNoListRefuse
     * @param applyNoListCancel
     */
    private void assignListByStatus(List<Apply> applyList, List<String> applyNoList, List<String> applyNoListSubmit, List<String> applyNoListConfirm, List<String> applyNoListPass, List<String> applyNoListCondition, List<String> applyNoListRefuse, List<String> applyNoListCancel) {
        for(Apply apply : applyList){
            String status = apply.getBizStatus(); //订单状态
            String applyNo = apply.getApplyNo(); //订单编号
            applyNoList.add(applyNo);
            if(BizStatusEnums.APPLY_INPUT.getType().equals(status) || BizStatusEnums.APPLY_INPUT2.getType().equals(status)
                    || BizStatusEnums.APPLY_INPUT3.getType().equals(status) || BizStatusEnums.APPLY_INPUT4.getType().equals(status)
                    || BizStatusEnums.APPLY_INPUT5.getType().equals(status) || BizStatusEnums.APPLY_INPUT6.getType().equals(status)){
                //待提交
                applyNoListSubmit.add(applyNo);
            } else if(BizStatusEnums.WAIT_CONTRACT_CONF1.getType().equals(status)
                    || BizStatusEnums.WAIT_CONTRACT_CONF2.getType().equals(status)){
                //待确认
                applyNoListConfirm.add(applyNo);
            } else if(BizStatusEnums.APPLY_FINISH.getType().equals(status)){ //如果是已通过，判断是否是有条件同意
                if(ApproveAgreeFlagEnums.CONDITIONAL_AGREE.getType().equals(apply.getApproveFlag())){
                    //有条件通过
                    applyNoListCondition.add(applyNo);
                } else {
                    //无条件通过
                    applyNoListPass.add(applyNo);
                }
            } else if(BizStatusEnums.APPLY_INVALID.getType().equals(status)){
                //已拒绝
                applyNoListRefuse.add(applyNo);
            } else if(BizStatusEnums.APPLY_CANCEL.getType().equals(status)){
                //已取消
                applyNoListCancel.add(applyNo);
            }
        }
    }

    /**
     * 构建主页工作台显示模块的set集合
     * @param roles
     * @param keySet
     * @return
     */
    private boolean buildHomeData(List<SysRole> roles, HashSet<String> keySet) {
        //定义系统常量key
        String paramKey;
        for(SysRole role : roles){
            // 拼接字符串，取得系统常量key
            paramKey = HOME_APPRVE_CONSTANTS + role.getRole();
            // 系统常量中取得该角色对应审批模块情况
            String constantParams = commonConstantService.findSysParamValue(paramKey);
            if(StringUtils.isTrimBlank(constantParams)){
                return true;
            }
            //逗号分隔
            String [] constantArr = StringUtils.isNotTrimBlank(constantParams) ? constantParams.split(",") : new String[0];
            if(constantArr == null || constantArr.length == 0){
                continue;
            }
            //arr转list，构建模块的数据字典集合
            List<String> keyList = Arrays.asList(constantArr);
            keySet.addAll(keyList);
        }
        if(keySet == null || keySet.isEmpty()){
            return true;
        }
        return false;
    }
}
