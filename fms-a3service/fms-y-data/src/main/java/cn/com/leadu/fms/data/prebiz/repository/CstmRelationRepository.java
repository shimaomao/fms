package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationRepository
 * @Description: 融资申请客户关系Repository层
 * @date 2018-05-16
 */
public interface CstmRelationRepository {

	/**
	 * @Title:
	 * @Description: 新增融资申请客户关系
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int insertData(CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 批量保存融资申请客户关系
	 * @param cstmRelations
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int insertDataList(List<CstmRelation> cstmRelations);

	/**
	 * @Title:
	 * @Description: 修改融资申请客户关系
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByPrimaryKeyData(CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 批量修改融资申请客户关系
	 * @param cstmRelations
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByPrimaryKeyDataList(List<CstmRelation> cstmRelations);

	/**
	 * @Title:
	 * @Description: 动态修改融资申请客户关系
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByPrimaryKeySelectiveData(CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资申请客户关系
	 * @param cstmRelations
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmRelation> cstmRelations);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资申请客户关系
	 * @param cstmRelation
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByExampleData(CstmRelation cstmRelation, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资申请客户关系
	 * @param cstmRelation
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int updateByExampleSelectiveData(CstmRelation cstmRelation, Example example);

	/**
	 * @Title:
	 * @Description: 根据relationId删除融资申请客户关系
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int deleteData(CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 根据relationId集合批量删除融资申请客户关系
	 * @param relationIds
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int deleteDataList(List relationIds, CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除融资申请客户关系
	 * @param example
	 * @param cstmRelation
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	int deleteExampleData(Example example, CstmRelation cstmRelation);

	/**
	 * @Title:
	 * @Description: 查询全部融资申请客户关系
	 * @return List<CstmRelation>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	List<CstmRelation> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资申请客户关系
	 * @param example
	 * @return CstmRelation
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	CstmRelation selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资申请客户关系
	 * @param example
	 * @return List<CstmRelation>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	List<CstmRelation> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过relationId查询融资申请客户关系
	 * @param relationId
	 * @return CstmRelation
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	CstmRelation selectByPrimaryKey(Object relationId);

	/**
	 * @Title:
	 * @Description: 分页查询融资申请客户关系
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmRelation>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	PageInfoExtend<CstmRelation> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资申请客户关系vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
