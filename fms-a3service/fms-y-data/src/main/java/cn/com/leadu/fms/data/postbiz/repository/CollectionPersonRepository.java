package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonRepository
 * @Description: 催收组员Repository层
 */
public interface CollectionPersonRepository {

	/**
	 * @Title:
	 * @Description: 新增催收组员
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int insertData(CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 批量保存催收组员
	 * @param collectionPersons
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int insertDataList(List<CollectionPerson> collectionPersons);

	/**
	 * @Title:
	 * @Description: 修改催收组员
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeyData(CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 批量修改催收组员
	 * @param collectionPersons
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeyDataList(List<CollectionPerson> collectionPersons);

	/**
	 * @Title:
	 * @Description: 动态修改催收组员
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeySelectiveData(CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 批量动态修改催收组员
	 * @param collectionPersons
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<CollectionPerson> collectionPersons);

	/**
	 * @Title:
	 * @Description: 根据条件修改催收组员
	 * @param collectionPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByExampleData(CollectionPerson collectionPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改催收组员
	 * @param collectionPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByExampleSelectiveData(CollectionPerson collectionPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据collectionPersonId删除催收组员
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int deleteData(CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 根据collectionPersonId集合批量删除催收组员
	 * @param collectionPersonIds
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int deleteDataList(List collectionPersonIds, CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除催收组员
	 * @param example
	 * @param collectionPerson
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int deleteExampleData(Example example, CollectionPerson collectionPerson);

	/**
	 * @Title:
	 * @Description: 查询全部催收组员
	 * @return List<CollectionPerson>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	List<CollectionPerson> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个催收组员
	 * @param example
	 * @return CollectionPerson
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	CollectionPerson selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询催收组员
	 * @param example
	 * @return List<CollectionPerson>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	List<CollectionPerson> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过collectionPersonId查询催收组员
	 * @param collectionPersonId
	 * @return CollectionPerson
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	CollectionPerson selectByPrimaryKey(Object collectionPersonId);

	/**
	 * @Title:
	 * @Description: 分页查询催收组员
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CollectionPerson>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	PageInfoExtend<CollectionPerson> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询催收组员vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改催收组员
	 * @param collectionPerson,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeyData(CollectionPerson collectionPerson, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改催收组员,并进行排他
	 * @param collectionPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeyDataList(List<CollectionPerson> collectionPersons, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改催收组员,并进行排他
	 * @param collectionPerson
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(CollectionPerson collectionPerson, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改催收组员,并进行排他
	 * @param collectionPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<CollectionPerson> collectionPersons, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改催收组员,并进行排他
	 * @param collectionPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByExampleData(CollectionPerson collectionPerson, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改催收组员,并进行排他
	 * @param collectionPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:12
	 */
	int updateByExampleSelectiveData(CollectionPerson collectionPerson, Example example, boolean exclusive);

}
