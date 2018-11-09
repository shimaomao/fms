package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectRepository
 * @Description: 财务科目管理Repository层
 * @date 2018-06-20
 */
public interface FinancialSubjectRepository {

	/**
	 * @Title:
	 * @Description: 新增财务科目管理
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int insertData(FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 批量保存财务科目管理
	 * @param financialSubjects
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int insertDataList(List<FinancialSubject> financialSubjects);

	/**
	 * @Title:
	 * @Description: 修改财务科目管理
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeyData(FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 批量修改财务科目管理
	 * @param financialSubjects
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeyDataList(List<FinancialSubject> financialSubjects);

	/**
	 * @Title:
	 * @Description: 动态修改财务科目管理
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeySelectiveData(FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务科目管理
	 * @param financialSubjects
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialSubject> financialSubjects);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务科目管理
	 * @param financialSubject
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByExampleData(FinancialSubject financialSubject, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务科目管理
	 * @param financialSubject
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByExampleSelectiveData(FinancialSubject financialSubject, Example example);

	/**
	 * @Title:
	 * @Description: 根据subjectId删除财务科目管理
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int deleteData(FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 根据subjectId集合批量删除财务科目管理
	 * @param subjectIds
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int deleteDataList(List subjectIds,FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务科目管理
	 * @param example
	 * @param financialSubject
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int deleteExampleData(Example example,FinancialSubject financialSubject);

	/**
	 * @Title:
	 * @Description: 查询全部财务科目管理
	 * @return List<FinancialSubject>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	List<FinancialSubject> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务科目管理
	 * @param example
	 * @return FinancialSubject
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	FinancialSubject selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务科目管理
	 * @param example
	 * @return List<FinancialSubject>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	List<FinancialSubject> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过subjectId查询财务科目管理
	 * @param subjectId
	 * @return FinancialSubject
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	FinancialSubject selectByPrimaryKey(Object subjectId);

	/**
	 * @Title:
	 * @Description: 分页查询财务科目管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialSubject>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	PageInfoExtend<FinancialSubject> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务科目管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务科目管理
	 * @param financialSubject,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeyData(FinancialSubject financialSubject,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务科目管理,并进行排他
	 * @param financialSubjects
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeyDataList(List<FinancialSubject> financialSubjects,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务科目管理,并进行排他
	 * @param financialSubject
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialSubject financialSubject,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务科目管理,并进行排他
	 * @param financialSubjects
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialSubject> financialSubjects,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务科目管理,并进行排他
	 * @param financialSubject
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByExampleData(FinancialSubject financialSubject, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务科目管理,并进行排他
	 * @param financialSubject
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	int updateByExampleSelectiveData(FinancialSubject financialSubject, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 通过subjectId查询财务科目管理及其辅助核算类型
	 * @param subjectId
	 * @return FinancialSubject
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 11:24:39
	 */
	FinancialSubjectVo selectFinancialSubjectVoByPrimaryKey(String subjectId);

}
