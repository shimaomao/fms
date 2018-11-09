package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.constant.enums.CommonUserInfoReadStatusEnums;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysUserInfoRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import cn.com.leadu.fms.system.service.SysUserInfoService;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysuserinfo.vo.SysUserInfoSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoService
 * @Description: 消息用户操作管理业务实现层
 * @date 2018-04-25
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    /**
     * @Fields  : 消息用户操作管理repository
     */
    @Autowired
    private SysUserInfoRepository sysUserInfoRepository;

    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理
     * @param sysUserInfoVo
     * @return PageInfoExtend<SysUserInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public PageInfoExtend<SysUserInfo> findSysUserInfosByPage(SysUserInfoVo sysUserInfoVo){
        Example example = SqlUtil.newExample(SysUserInfo.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysUserInfo> pageInfo = sysUserInfoRepository.selectListByExamplePage(example,sysUserInfoVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存消息用户操作管理
     * @param sysUserInfoSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public void saveSysUserInfo(SysUserInfoSaveVo sysUserInfoSaveVo){
        sysUserInfoRepository.insertData(sysUserInfoSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改消息用户操作管理
     * @param sysUserInfoModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public void modifySysUserInfo(SysUserInfoModifyVo sysUserInfoModifyVo){
        sysUserInfoRepository.updateByPrimaryKeySelectiveData(sysUserInfoModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过userInfoId删除消息用户操作管理
     * @param sysUserInfoDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public void deleteSysUserInfo(SysUserInfoDeleteVo sysUserInfoDeleteVo){
        sysUserInfoRepository.deleteData(sysUserInfoDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过userInfoId集合删除消息用户操作管理
     * @param sysUserInfoDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public void deleteSysUserInfosByUserInfoIds(SysUserInfoDeleteListVo sysUserInfoDeleteListVo){
        sysUserInfoRepository.deleteDataList(sysUserInfoDeleteListVo.getUserInfoIds(),sysUserInfoDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据userInfoId获取消息用户操作管理
     * @param userInfoId
     * @return SysUserInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public SysUserInfo findSysUserInfoByUserInfoId(String userInfoId){
        return sysUserInfoRepository.selectByPrimaryKey(userInfoId);
    }

    /**
     * @Title:
     * @Description: 查询当前自己的消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 14:51
     */
    public PageInfoExtend<SysUserInfo> findSysUserInfoVosByPage(SysUserInfoVo sysUserInfoVo, SysUser sysUser){
        sysUserInfoVo.setUser(sysUser.getUser());
        sysUserInfoVo.setPageFlag(PageFlags.NOT_PAGE.getFlag());
        return sysUserInfoRepository.selectListVoByPage("selectSysUserInfoVos",sysUserInfoVo,sysUserInfoVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 确认读取消息
     * @param: sysUserInfoVo
     * @param: sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/25 14:51
     */
    public void readSysUserInfo(SysUserInfoVo sysUserInfoVo){
        if(sysUserInfoVo == null || StringUtils.isTrimBlank(sysUserInfoVo.getUserInfoId()))
            throw new FmsServiceException("确认已读消息不能为空");
        SysUserInfo sysUserInfo = sysUserInfoVo.getEntity();
        sysUserInfo.setReadStatus(CommonUserInfoReadStatusEnums.READ.getStatus());
        sysUserInfo.setReadTime(new Date());
        sysUserInfoRepository.updateByPrimaryKeySelectiveData(sysUserInfo);
    }

}
