package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoRepository
 * @Description: 消息用户操作管理Repository层
 * @date 2018-04-25
 */
public interface SysUserInfoRepository {

	/**
	 * @Title:
	 * @Description: 新增消息用户操作管理
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int insertData(SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 批量保存消息用户操作管理
	 * @param sysUserInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int insertDataList(List<SysUserInfo> sysUserInfos);

	/**
	 * @Title:
	 * @Description: 修改消息用户操作管理
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByPrimaryKeyData(SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 批量修改消息用户操作管理
	 * @param sysUserInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByPrimaryKeyDataList(List<SysUserInfo> sysUserInfos);

	/**
	 * @Title:
	 * @Description: 动态修改消息用户操作管理
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByPrimaryKeySelectiveData(SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 批量动态修改消息用户操作管理
	 * @param sysUserInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysUserInfo> sysUserInfos);

	/**
	 * @Title:
	 * @Description: 根据条件修改消息用户操作管理
	 * @param sysUserInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByExampleData(SysUserInfo sysUserInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改消息用户操作管理
	 * @param sysUserInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int updateByExampleSelectiveData(SysUserInfo sysUserInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据userInfoId删除消息用户操作管理
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int deleteData(SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 根据userInfoId集合批量删除消息用户操作管理
	 * @param userInfoIds
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int deleteDataList(List userInfoIds, SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除消息用户操作管理
	 * @param example
	 * @param sysUserInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	int deleteExampleData(Example example, SysUserInfo sysUserInfo);

	/**
	 * @Title:
	 * @Description: 查询全部消息用户操作管理
	 * @return List<SysUserInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	List<SysUserInfo> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个消息用户操作管理
	 * @param example
	 * @return SysUserInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	SysUserInfo selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询消息用户操作管理
	 * @param example
	 * @return List<SysUserInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	List<SysUserInfo> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过userInfoId查询消息用户操作管理
	 * @param userInfoId
	 * @return SysUserInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	SysUserInfo selectByPrimaryKey(Object userInfoId);

	/**
	 * @Title:
	 * @Description: 分页查询消息用户操作管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysUserInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	PageInfoExtend<SysUserInfo> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询消息用户操作管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:12:34
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
