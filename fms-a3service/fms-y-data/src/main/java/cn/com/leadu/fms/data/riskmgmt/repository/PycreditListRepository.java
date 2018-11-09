package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditListRepository
 * @Description: 鹏元查询一览Repository层
 * @date 2018-06-04
 */
public interface PycreditListRepository {

	/**
	 * @Title:
	 * @Description: 新增鹏元查询一览
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int insertData(PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 批量保存鹏元查询一览
	 * @param pycreditLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int insertDataList(List<PycreditList> pycreditLists);

	/**
	 * @Title:
	 * @Description: 修改鹏元查询一览
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeyData(PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 批量修改鹏元查询一览
	 * @param pycreditLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeyDataList(List<PycreditList> pycreditLists);

	/**
	 * @Title:
	 * @Description: 动态修改鹏元查询一览
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeySelectiveData(PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 批量动态修改鹏元查询一览
	 * @param pycreditLists
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditList> pycreditLists);

	/**
	 * @Title:
	 * @Description: 根据条件修改鹏元查询一览
	 * @param pycreditList
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByExampleData(PycreditList pycreditList, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改鹏元查询一览
	 * @param pycreditList
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByExampleSelectiveData(PycreditList pycreditList, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditId删除鹏元查询一览
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int deleteData(PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 根据pycreditId集合批量删除鹏元查询一览
	 * @param pycreditIds
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int deleteDataList(List pycreditIds,PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除鹏元查询一览
	 * @param example
	 * @param pycreditList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int deleteExampleData(Example example,PycreditList pycreditList);

	/**
	 * @Title:
	 * @Description: 查询全部鹏元查询一览
	 * @return List<PycreditList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	List<PycreditList> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个鹏元查询一览
	 * @param example
	 * @return PycreditList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PycreditList selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询鹏元查询一览
	 * @param example
	 * @return List<PycreditList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	List<PycreditList> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditId查询鹏元查询一览
	 * @param pycreditId
	 * @return PycreditList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PycreditList selectByPrimaryKey(Object pycreditId);

	/**
	 * @Title:
	 * @Description: 分页查询鹏元查询一览
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PageInfoExtend<PycreditList> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询鹏元查询一览vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改鹏元查询一览
	 * @param pycreditList,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeyData(PycreditList pycreditList,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改鹏元查询一览,并进行排他
	 * @param pycreditLists
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeyDataList(List<PycreditList> pycreditLists,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改鹏元查询一览,并进行排他
	 * @param pycreditList
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditList pycreditList,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改鹏元查询一览,并进行排他
	 * @param pycreditLists
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditList> pycreditLists,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改鹏元查询一览,并进行排他
	 * @param pycreditList
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByExampleData(PycreditList pycreditList, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改鹏元查询一览,并进行排他
	 * @param pycreditList
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	int updateByExampleSelectiveData(PycreditList pycreditList, Example example,boolean exclusive);

}
