package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistRepository
 * @Description: 黑名单Repository层
 * @date 2018-05-04
 */
public interface BasBlacklistRepository {

	/**
	 * @Title:
	 * @Description: 新增黑名单
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int insertData(BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 批量保存黑名单
	 * @param basBlacklists
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int insertDataList(List<BasBlacklist> basBlacklists);

	/**
	 * @Title:
	 * @Description: 修改黑名单
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByPrimaryKeyData(BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 批量修改黑名单
	 * @param basBlacklists
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByPrimaryKeyDataList(List<BasBlacklist> basBlacklists);

	/**
	 * @Title:
	 * @Description: 动态修改黑名单
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByPrimaryKeySelectiveData(BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 批量动态修改黑名单
	 * @param basBlacklists
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasBlacklist> basBlacklists);

	/**
	 * @Title:
	 * @Description: 根据条件修改黑名单
	 * @param basBlacklist
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByExampleData(BasBlacklist basBlacklist, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改黑名单
	 * @param basBlacklist
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int updateByExampleSelectiveData(BasBlacklist basBlacklist, Example example);

	/**
	 * @Title:
	 * @Description: 根据blacklistId删除黑名单
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int deleteData(BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 根据blacklistId集合批量删除黑名单
	 * @param blacklistIds
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int deleteDataList(List blacklistIds,BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除黑名单
	 * @param example
	 * @param basBlacklist
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	int deleteExampleData(Example example,BasBlacklist basBlacklist);

	/**
	 * @Title:
	 * @Description: 查询全部黑名单
	 * @return List<BasBlacklist>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	List<BasBlacklist> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个黑名单
	 * @param example
	 * @return BasBlacklist
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	BasBlacklist selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询黑名单
	 * @param example
	 * @return List<BasBlacklist>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	List<BasBlacklist> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过blacklistId查询黑名单
	 * @param blacklistId
	 * @return BasBlacklist
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	BasBlacklist selectByPrimaryKey(Object blacklistId);

	/**
	 * @Title:
	 * @Description: 分页查询黑名单
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasBlacklist>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	PageInfoExtend<BasBlacklist> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询黑名单vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:28
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
