package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.common.constant.enums.CommonStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysGroupEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysGroupLev;
import cn.com.leadu.fms.common.constant.enums.system.SysGroupParentTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupDetailVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import cn.com.leadu.fms.system.service.SysGroupParentService;
import cn.com.leadu.fms.system.service.SysGroupService;
import cn.com.leadu.fms.system.service.SysUserService;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupModifyVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysGroupService
 * @Description: 用户组管理业务实现层
 * @date 2018-03-10
 */
@Service
public class SysGroupServiceImpl implements SysGroupService {

    /**
     * @Fields  : 用户组管理repository
     */
    @Autowired
    private SysGroupRepository sysGroupRepository;

    @Autowired
    private SysGroupParentService sysGroupParentService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * @Title:
     * @Description: 分页查询用户组管理
     * @param sysGroupVo
     * @return PageInfoExtend<SysGroupVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public PageInfoExtend<SysGroupVo> findSysGroupVosByPage(SysGroupVo sysGroupVo) {
        // 用户组代码
        if (StringUtils.isNotTrimBlank(sysGroupVo.getGroupCode())) {
            sysGroupVo.setGroupCode(SqlUtil.likePattern(sysGroupVo.getGroupCode()));
        } else {
            sysGroupVo.setGroupCode(null);
        }
        // 用户组名称
        if (StringUtils.isNotTrimBlank(sysGroupVo.getGroupName())) {
            sysGroupVo.setGroupName(SqlUtil.likePattern(sysGroupVo.getGroupName()));
        } else {
            sysGroupVo.setGroupName(null);
        }
        // 上级用户组
        if (StringUtils.isNotTrimBlank(sysGroupVo.getParentGroup())) {
            sysGroupVo.setParentGroup(sysGroupVo.getParentGroup().trim());
        } else {
            sysGroupVo.setParentGroup(null);
        }
        // 组织类型
        sysGroupVo.setParentType(SysGroupParentTypeEnums.ADMIN.getType());
        PageInfoExtend<SysGroupVo> pageInfo = sysGroupRepository.selectListVoByPage("selectSysGroupVosByPage", sysGroupVo, sysGroupVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param sysGroupSaveVo
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Transactional
    public void saveSysGroup(SysGroupSaveVo sysGroupSaveVo){
        // 保存用户组
        sysGroupRepository.insertData(sysGroupSaveVo.getEntity());
        // 保存用户组关系
        if (ArrayUtils.isNotNullAndLengthNotZero(sysGroupSaveVo.getSysGroupParentVoList())) {
            List<SysGroupParent> sysGroupParentList = new ArrayList<>();
            for (SysGroupParentVo sysGroupParentVo : sysGroupSaveVo.getSysGroupParentVoList()) {
                SysGroupParent sysGroupParent = new SysGroupParent();
                sysGroupParent.setGroupCode(sysGroupSaveVo.getGroupCode());
                sysGroupParent.setParentGroup(sysGroupParentVo.getParentGroup());
                sysGroupParent.setParentType(sysGroupParentVo.getParentType());
                sysGroupParentList.add(sysGroupParent);
            }
            sysGroupParentService.saveSysGroupParents(sysGroupParentList);
        }
    }

    /**
     * @Title:
     * @Description: 修改用户组管理
     * @param sysGroupModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Transactional
    public void modifySysGroup(SysGroupModifyVo sysGroupModifyVo){
        List<SysGroupParent> sysGroupParentList = sysGroupParentService.findSysGroupParentsByGroup(sysGroupModifyVo.getGroupCode());
        Map<String, String> parentTypeMap = new HashMap<>();
        for (SysGroupParent sysGroupParent : sysGroupParentList) {
            parentTypeMap.put(sysGroupParent.getParentType(), sysGroupParent.getParentGroup());
        }
        // 本次传入的用户组关系
        List<SysGroupParentVo> sysGroupParentVoList = sysGroupModifyVo.getSysGroupParentVoList();
        Map<String, String> parentTypeVoMap = new HashMap<>();
        for (SysGroupParentVo sysGroupParentVo : sysGroupParentVoList) {
            parentTypeVoMap.put(sysGroupParentVo.getParentType(), sysGroupParentVo.getParentGroup());
        }
        // 本次需要新增的用户关系
        List<SysGroupParent> saveSysGroupParentList = new ArrayList<>();
        for (SysGroupParentVo sysGroupParentVo : sysGroupParentVoList) {
            if (!parentTypeMap.containsKey(sysGroupParentVo.getParentType())) {
                SysGroupParent sysGroupParent = new SysGroupParent();
                sysGroupParent.setGroupCode(sysGroupModifyVo.getGroupCode());
                sysGroupParent.setParentGroup(sysGroupParentVo.getParentGroup());
                sysGroupParent.setParentType(sysGroupParentVo.getParentType());
                saveSysGroupParentList.add(sysGroupParent);
            }
        }
        // 本次需要修改或删除的用户关系
        List<SysGroupParent> modifySysGroupParentList = new ArrayList<>();
        List<String> deleteParentIds = new ArrayList<>();
        for (SysGroupParent sysGroupParent : sysGroupParentList) {
            String parentGroup = parentTypeVoMap.get(sysGroupParent.getParentType());
            if (parentGroup == null) {
                deleteParentIds.add(sysGroupParent.getParentId());
            } else if (!parentGroup.equals(sysGroupParent.getParentGroup())) {
                sysGroupParent.setParentGroup(parentGroup);
                modifySysGroupParentList.add(sysGroupParent);
            }
        }
        // 保存用户组关系
        if (saveSysGroupParentList.size() > 0) {
            sysGroupParentService.saveSysGroupParents(saveSysGroupParentList);
        }
        if (modifySysGroupParentList.size() > 0) {
            sysGroupParentService.modifySysGroupParents(modifySysGroupParentList);
        }
        if (deleteParentIds.size() > 0) {
            sysGroupParentService.deleteSysGroupParentsByParentIds(deleteParentIds);
        }
        sysGroupRepository.updateByPrimaryKeySelectiveData(sysGroupModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过groupId集合删除用户组管理
     * @param sysGroupDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Transactional
    public void deleteSysGroupsByGroupIds(SysGroupDeleteListVo sysGroupDeleteListVo){
        // 判断当前删除的用户组是否有子用户组
        long count = sysGroupRepository.selectParentGroupCountByGroupIds(sysGroupDeleteListVo.getGroupIds());
        if (count > 0) {
            throw new FmsServiceException("选中的用户组有下级用户组，不能删除");
        }
        // 查询当前删除的用户组，是否有被用户使用
        List<String> userList = sysUserService.findSysUserLoginNamesByGroupIds(sysGroupDeleteListVo.getGroupIds());
        if (ArrayUtils.isNotNullAndLengthNotZero(userList) && userList.size() > 0) {
            throw new FmsServiceException("选中的用户组已经被用户使用，不能删除");
        }
        // 删除用户组关系数据
        List<String> parentIdList = sysGroupRepository.selectParentIdsByGroupIds(sysGroupDeleteListVo.getGroupIds());
        if (ArrayUtils.isNotNullAndLengthNotZero(parentIdList)) {
            sysGroupParentService.deleteSysGroupParentsByParentIds(parentIdList);
        }
        sysGroupRepository.deleteDataList(sysGroupDeleteListVo.getGroupIds(),sysGroupDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据groupId获取用户组信息
     * @param groupId
     * @return SysGroup
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    public SysGroupDetailVo findSysGroupVoByGroupId(String groupId){
        if (StringUtils.isTrimBlank(groupId)) {
            groupId = null;
        }
        SysGroupDetailVo sysGroupDetailVo = sysGroupRepository.selectSysGroupVoByGroupId(groupId);
        if (sysGroupDetailVo != null) {
            // 取得上级用户组信息
            List<SysGroupParentVo> sysGroupParentVoList = sysGroupRepository.selectParentGroupsByGroup(sysGroupDetailVo.getGroupCode());
            if (sysGroupParentVoList != null && sysGroupParentVoList.size() > 0) {
                for (SysGroupParentVo sysGroupParentVo : sysGroupParentVoList) {
                    if (SysGroupParentTypeEnums.ADMIN.getType().equals(sysGroupParentVo.getParentType())) {
                        // 行政组织
                        sysGroupDetailVo.setAdminParentGroup(sysGroupParentVo.getParentGroup());
                        sysGroupDetailVo.setAdminParentGroupName(sysGroupParentVo.getParentGroupName());
                    } else if (SysGroupParentTypeEnums.FINANCE.getType().equals(sysGroupParentVo.getParentType())) {
                        // 行政组织
                        sysGroupDetailVo.setFinanceParentGroup(sysGroupParentVo.getParentGroup());
                        sysGroupDetailVo.setFinanceParentGroupName(sysGroupParentVo.getParentGroupName());
                    } else if (SysGroupParentTypeEnums.SELL.getType().equals(sysGroupParentVo.getParentType())) {
                        // 行政组织
                        sysGroupDetailVo.setSellParentGroup(sysGroupParentVo.getParentGroup());
                        sysGroupDetailVo.setSellParentGroupName(sysGroupParentVo.getParentGroupName());
                    }else if (SysGroupParentTypeEnums.OPERATION.getType().equals(sysGroupParentVo.getParentType())) {
                        // 行政组织
                        sysGroupDetailVo.setOperateParentGroup(sysGroupParentVo.getParentGroup());
                        sysGroupDetailVo.setOperateParentGroupName(sysGroupParentVo.getParentGroupName());
                    }
                }
            }
        }
        return sysGroupDetailVo;
    }

    /**
     * @Title:
     * @Description:  根据用户组代码，获取用户组信息
     * @param groupCode
     * @return SysGroup
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:31:58
     */
    @Override
    public SysGroup findSysGroupByGroup(String groupCode) {
        if (StringUtils.isNotTrimBlank(groupCode)) {
            Example example = SqlUtil.newExample(SysGroup.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("groupCode", groupCode);
            SqlUtil.setOrderByUpdateTimeDesc(example);
            return sysGroupRepository.selectOneByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  根据groupCode获取用户组信息
     * @param groupCode
     * @return SysGroup
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:31:58
     */
    @Override
    public SysGroup selectSysGroupVoByGroupCode(String groupCode) {
            Example example=SqlUtil.newExample(SysGroup.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("groupCode", groupCode);
            return sysGroupRepository.selectSysGroupVoByGroupCode(example);
    }

    /**
     * @Title:
     * @Description:    查询用户组信息树
     * @param parentType 组织类型
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/13 09:46:15
     */
    @Override
    public List<BootstrapTreeViewNodeVo> findSysGroupByTree(String parentType, String groupCode) {
        List<SysGroupVo> sysGroupVoList = sysGroupRepository.selectSysGroupVosByTree(parentType);
        // 排除用户组及子集
        List<String> chileGroupCodeList = new ArrayList<>();
        if (StringUtils.isNotTrimBlank(groupCode)) {
            List<SysGroupVo> childGroupList = CommonTreeDataUtils.getChildResults(sysGroupVoList, groupCode);
            if (ArrayUtils.isNotNullAndLengthNotZero(childGroupList)) {
                for (SysGroupVo sysGroupVo : childGroupList) {
                    chileGroupCodeList.add(sysGroupVo.getGroupCode());
                }
            }
            chileGroupCodeList.add(groupCode);
        }
        // 取得数据树
        List<BootstrapTreeViewNodeVo> nodes;
        if (ArrayUtils.isNotNullAndLengthNotZero(chileGroupCodeList)) {
            List<SysGroupVo> dataList = new ArrayList<>();
            for (SysGroupVo sysGroupVo : sysGroupVoList) {
                if (!chileGroupCodeList.contains(sysGroupVo.getGroupCode())) {
                    dataList.add(sysGroupVo);
                }
            }
            nodes = CommonTreeDataUtils.getTrees(dataList);
        } else {
            nodes = CommonTreeDataUtils.getTrees(sysGroupVoList);
        }
        return nodes;
    }

    /**
     * @Title:
     * @Description: 根据经销商代码，取得经销商用户组及全部父级用户组
     * @param groupCode
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018/03/23 17:46:15
     */
    @Override
    public List<String> findSysGroupCodeListByGroupCode(String groupCode) {
        List<String> resultList = new ArrayList<>();
        List<SysGroupVo> sysGroupVoList = sysGroupRepository.selectSysGroupVosByTree(SysGroupParentTypeEnums.ADMIN.getType());
        // 取得当前用户组的code及全部父级组织的代码
        List<SysGroupVo> tempList = CommonTreeDataUtils.getParentResults(sysGroupVoList, groupCode);
        if (ArrayUtils.isNotNullAndLengthNotZero(tempList)) {
            for (SysGroupVo sysGroupVo : tempList) {
                resultList.add(sysGroupVo.getGroupCode());
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description:   得到经销商保存情况
     * @param sysGroupVo
     * @return Map<String,String>
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:31:58
     */
    public PageInfoExtend<SysGroupVo> findSysGroupVoListByPage(SysGroupVo sysGroupVo) {
        // 用户组层级
        if (StringUtils.isNotTrimBlank(sysGroupVo.getGroupLev())) {
            sysGroupVo.setGroupLev(sysGroupVo.getGroupLev().trim());
        } else {
            sysGroupVo.setGroupLev(null);
        }
        // 用户组层级名称
        if (StringUtils.isNotTrimBlank(sysGroupVo.getGroupLevName())) {
            sysGroupVo.setGroupLevName(SqlUtil.likePattern(sysGroupVo.getGroupLevName()));
        } else {
            sysGroupVo.setGroupLevName(null);
        }
        if(StringUtils.isNotTrimBlank(sysGroupVo.getGroupName())){
            sysGroupVo.setGroupName(SqlUtil.likePattern(sysGroupVo.getGroupName()));
        }else{
            sysGroupVo.setGroupName(null);
        }
        if(StringUtils.isNotTrimBlank(sysGroupVo.getGroupCode())){
            sysGroupVo.setGroupCode(SqlUtil.likePattern(sysGroupVo.getGroupCode().toUpperCase()));
        }else{
            sysGroupVo.setGroupCode(null);
        }
        //组织层级
        sysGroupVo.setGroupLev(SysGroupLev.BRANCH.getType());
        return sysGroupRepository.selectListVoByPage("selectSysGroupVoListByPage",sysGroupVo,sysGroupVo.getPageQuery());

    }

    /**
     * @Title:
     * @Description:   得到经销商保存情况
     * @param sysGroupVo
     * @return Map<String,String>
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:31:58
     */
    public String getBasPartnerStatus(SysGroupVo sysGroupVo) {
        String flag = ""; //flag=1 覆盖用户组信息 flag=2新增用户组信息
        Example example = SqlUtil.newExample(SysGroup.class);
        example.createCriteria().andEqualTo("groupCode",sysGroupVo.getGroupCode());
        SysGroup sysGroup = sysGroupRepository.selectOneByExample(example);
       //用户组无数据
        if(sysGroup!=null){
            flag = "1";
            SysGroup sysGroupUpd = sysGroupVo.getEntity();
            sysGroupUpd.setGroupId(sysGroup.getGroupId());
            sysGroupUpd.setEnableFlag(CommonStatusEnums.ENABLE.getType());
            sysGroupRepository.updateByPrimaryKeySelectiveData(sysGroupUpd);
        }else{
            flag = "2";
            //保存用户组信息
            sysGroup = sysGroupVo.getEntity();
            sysGroup.setEnableFlag(CommonStatusEnums.ENABLE.getType());
            sysGroupRepository.insertData(sysGroup);
        }
        //保存用户关系信息
        if(StringUtils.isNotTrimBlank(sysGroupVo.getParentGroup())){
            SysGroupParent sysGroupParent=new SysGroupParent();
            sysGroupParent=sysGroupParentService.findSysGroupParentsByGroupCode(sysGroupVo.getGroupCode());
            if(sysGroupParent!=null){
                sysGroupParent.setGroupCode(sysGroup.getGroupCode());
                sysGroupParent.setParentGroup(sysGroupVo.getParentGroup());
                sysGroupParentService.modifySysGroupParent(sysGroupParent);
            }else{
                sysGroupParent=new SysGroupParent();
                sysGroupParent.setGroupCode(sysGroup.getGroupCode());
                sysGroupParent.setParentGroup(sysGroupVo.getParentGroup());
                //组织类别默认为 1：行政组织
                sysGroupParent.setParentType(SysGroupEnums.ADMINISTRATIVE_TYPE.getType());
                sysGroupParentService.saveSysGroupParent(sysGroupParent);
            }

        }
        return flag;
    }
}
