package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangeVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeRepository
 * @Description: 个人基本信息变更表Repository层
 * @date 2018-08-31
 */
public interface PersonBasicChangeRepository {

	/**
	 * @Title:
	 * @Description: 新增个人基本信息变更表
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int insertData(PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 批量保存个人基本信息变更表
	 * @param personBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int insertDataList(List<PersonBasicChange> personBasicChanges);

	/**
	 * @Title:
	 * @Description: 修改个人基本信息变更表
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeyData(PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 批量修改个人基本信息变更表
	 * @param personBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeyDataList(List<PersonBasicChange> personBasicChanges);

	/**
	 * @Title:
	 * @Description: 动态修改个人基本信息变更表
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeySelectiveData(PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人基本信息变更表
	 * @param personBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeySelectiveDataList(List<PersonBasicChange> personBasicChanges);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人基本信息变更表
	 * @param personBasicChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByExampleData(PersonBasicChange personBasicChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人基本信息变更表
	 * @param personBasicChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByExampleSelectiveData(PersonBasicChange personBasicChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据personChangeId删除个人基本信息变更表
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int deleteData(PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 根据personChangeId集合批量删除个人基本信息变更表
	 * @param personChangeIds
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int deleteDataList(List personChangeIds, PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除个人基本信息变更表
	 * @param example
	 * @param personBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int deleteExampleData(Example example, PersonBasicChange personBasicChange);

	/**
	 * @Title:
	 * @Description: 查询全部个人基本信息变更表
	 * @return List<PersonBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	List<PersonBasicChange> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个个人基本信息变更表
	 * @param example
	 * @return PersonBasicChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PersonBasicChange selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询个人基本信息变更表
	 * @param example
	 * @return List<PersonBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	List<PersonBasicChange> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过personChangeId查询个人基本信息变更表
	 * @param personChangeId
	 * @return PersonBasicChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PersonBasicChange selectByPrimaryKey(Object personChangeId);

	/**
	 * @Title:
	 * @Description: 分页查询个人基本信息变更表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PersonBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PageInfoExtend<PersonBasicChange> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询个人基本信息变更表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改个人基本信息变更表
	 * @param personBasicChange,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeyData(PersonBasicChange personBasicChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改个人基本信息变更表,并进行排他
	 * @param personBasicChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeyDataList(List<PersonBasicChange> personBasicChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改个人基本信息变更表,并进行排他
	 * @param personBasicChange
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PersonBasicChange personBasicChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人基本信息变更表,并进行排他
	 * @param personBasicChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByPrimaryKeySelectiveDataList(List<PersonBasicChange> personBasicChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人基本信息变更表,并进行排他
	 * @param personBasicChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByExampleData(PersonBasicChange personBasicChange, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人基本信息变更表,并进行排他
	 * @param personBasicChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	int updateByExampleSelectiveData(PersonBasicChange personBasicChange, Example example, boolean exclusive);

	/**
	 * 根据申请编号获取个人基本信息
	 * @param applyNo
	 * @return
	 */
	PersonBasicChangeVo selectPersonBasicChangeByApplyNo(String applyNo);
}
