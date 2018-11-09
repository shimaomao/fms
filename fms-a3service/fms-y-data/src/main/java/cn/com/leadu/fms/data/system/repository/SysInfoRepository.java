package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoRepository
 * @Description: 消息管理Repository层
 * @date 2018-04-25
 */
public interface SysInfoRepository {

	/**
	 * @Title:
	 * @Description: 新增消息管理
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int insertData(SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 批量保存消息管理
	 * @param sysInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int insertDataList(List<SysInfo> sysInfos);

	/**
	 * @Title:
	 * @Description: 修改消息管理
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByPrimaryKeyData(SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 批量修改消息管理
	 * @param sysInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByPrimaryKeyDataList(List<SysInfo> sysInfos);

	/**
	 * @Title:
	 * @Description: 动态修改消息管理
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByPrimaryKeySelectiveData(SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 批量动态修改消息管理
	 * @param sysInfos
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysInfo> sysInfos);

	/**
	 * @Title:
	 * @Description: 根据条件修改消息管理
	 * @param sysInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByExampleData(SysInfo sysInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改消息管理
	 * @param sysInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int updateByExampleSelectiveData(SysInfo sysInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据infoId删除消息管理
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int deleteData(SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 根据infoId集合批量删除消息管理
	 * @param infoIds
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int deleteDataList(List infoIds, SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除消息管理
	 * @param example
	 * @param sysInfo
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	int deleteExampleData(Example example, SysInfo sysInfo);

	/**
	 * @Title:
	 * @Description: 查询全部消息管理
	 * @return List<SysInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	List<SysInfo> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个消息管理
	 * @param example
	 * @return SysInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	SysInfo selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询消息管理
	 * @param example
	 * @return List<SysInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	List<SysInfo> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过infoId查询消息管理
	 * @param infoId
	 * @return SysInfo
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	SysInfo selectByPrimaryKey(Object infoId);

	/**
	 * @Title:
	 * @Description: 分页查询消息管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysInfo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	PageInfoExtend<SysInfo> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询消息管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-4-25 14:01:54
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
