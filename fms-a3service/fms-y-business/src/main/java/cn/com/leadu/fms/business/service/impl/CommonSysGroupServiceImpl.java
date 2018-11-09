package cn.com.leadu.fms.business.service.impl;/**
 * Created by ningyangyang on 2018/11/8.
 */

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.business.service.CommonSysGroupService;
import cn.com.leadu.fms.common.constant.enums.system.SysGroupParentTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: fms
 * @Description:  通过机构代码获取当前机构用户以及子机构用户
 * @author: ningyangyang
 * @date 2018/11/8 9:51
 */
@Service
public class CommonSysGroupServiceImpl implements CommonSysGroupService{

    /**
     *  用户组repository
     */
    @Autowired
    private SysGroupRepository sysGroupRepository;

    /**
     *  用户管理repository
     */
    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * @Description: 获取子机构的所有用户
     * @param groupCode
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/10/7 17:04
     */
    @Override
    public List<String> getUserInSameGroup(String groupCode) {
        List<SysGroupVo> sysGroupVoList = sysGroupRepository.selectSysGroupVosByTree(SysGroupParentTypeEnums.ADMIN.getType());
        List<String> userList = new ArrayList<>();
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
            userList =  sysUserRepository.selectSysUserLoginNamesByGroupCodes(chileGroupCodeList);
        }

        return userList;
    }
}
