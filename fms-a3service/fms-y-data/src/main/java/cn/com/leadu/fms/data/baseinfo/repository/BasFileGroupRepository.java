package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupRepository
 * @Description: 附件组Repository层
 */
public interface BasFileGroupRepository {

	/**
	 * @Title:
	 * @Description: 新增附件组
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int insertData(BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 批量保存附件组
	 * @param basFileGroups
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int insertDataList(List<BasFileGroup> basFileGroups);

	/**
	 * @Title:
	 * @Description: 修改附件组
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeyData(BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 批量修改附件组
	 * @param basFileGroups
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeyDataList(List<BasFileGroup> basFileGroups);

	/**
	 * @Title:
	 * @Description: 动态修改附件组
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeySelectiveData(BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 批量动态修改附件组
	 * @param basFileGroups
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasFileGroup> basFileGroups);

	/**
	 * @Title:
	 * @Description: 根据条件修改附件组
	 * @param basFileGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByExampleData(BasFileGroup basFileGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改附件组
	 * @param basFileGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByExampleSelectiveData(BasFileGroup basFileGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据basFileGroupId删除附件组
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int deleteData(BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 根据basFileGroupId集合批量删除附件组
	 * @param basFileGroupIds
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int deleteDataList(List basFileGroupIds, BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除附件组
	 * @param example
	 * @param basFileGroup
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int deleteExampleData(Example example, BasFileGroup basFileGroup);

	/**
	 * @Title:
	 * @Description: 查询全部附件组
	 * @return List<BasFileGroup>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	List<BasFileGroup> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个附件组
	 * @param example
	 * @return BasFileGroup
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	BasFileGroup selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询附件组
	 * @param example
	 * @return List<BasFileGroup>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	List<BasFileGroup> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过basFileGroupId查询附件组
	 * @param basFileGroupId
	 * @return BasFileGroup
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	BasFileGroup selectByPrimaryKey(Object basFileGroupId);

	/**
	 * @Title:
	 * @Description: 分页查询附件组
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasFileGroup>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	PageInfoExtend<BasFileGroup> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询附件组vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改附件组
	 * @param basFileGroup,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeyData(BasFileGroup basFileGroup, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改附件组,并进行排他
	 * @param basFileGroups
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeyDataList(List<BasFileGroup> basFileGroups, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改附件组,并进行排他
	 * @param basFileGroup
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(BasFileGroup basFileGroup, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改附件组,并进行排他
	 * @param basFileGroups
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasFileGroup> basFileGroups, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改附件组,并进行排他
	 * @param basFileGroup
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByExampleData(BasFileGroup basFileGroup, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改附件组,并进行排他
	 * @param basFileGroup
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	int updateByExampleSelectiveData(BasFileGroup basFileGroup, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description:  查询附件类型下一级子类附件
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-30 22:06:58
	 */
	List<BasFileTypeVo> selectBasFileTypeChiByFileType(String fileType);
}
