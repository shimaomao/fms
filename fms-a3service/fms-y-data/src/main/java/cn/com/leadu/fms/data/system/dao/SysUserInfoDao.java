package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import cn.com.leadu.fms.pojo.system.vo.sysuserinfo.SysUserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoDao
 * @Description: 消息用户操作管理dao层
 * @date 2018-04-25
 */
public interface SysUserInfoDao extends BaseDao<SysUserInfo> {

    List<SysUserInfoVo> selectSysUserInfoVos(@Param("sysUserInfoVo") SysUserInfoVo sysUserInfoVo);

}