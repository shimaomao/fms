package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.CompanyBasicChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeRepository
 * @Description: 企业基本信息变更Repository层
 * @date 2018-09-01
 */
public interface CompanyBasicChangeRepository {

	/**
	 * @Title:
	 * @Description: 新增企业基本信息变更
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int insertData(CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 批量保存企业基本信息变更
	 * @param companyBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int insertDataList(List<CompanyBasicChange> companyBasicChanges);

	/**
	 * @Title:
	 * @Description: 修改企业基本信息变更
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeyData(CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 批量修改企业基本信息变更
	 * @param companyBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeyDataList(List<CompanyBasicChange> companyBasicChanges);

	/**
	 * @Title:
	 * @Description: 动态修改企业基本信息变更
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeySelectiveData(CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业基本信息变更
	 * @param companyBasicChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<CompanyBasicChange> companyBasicChanges);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业基本信息变更
	 * @param companyBasicChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByExampleData(CompanyBasicChange companyBasicChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业基本信息变更
	 * @param companyBasicChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByExampleSelectiveData(CompanyBasicChange companyBasicChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据companyChangeId删除企业基本信息变更
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int deleteData(CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 根据companyChangeId集合批量删除企业基本信息变更
	 * @param companyChangeIds
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int deleteDataList(List companyChangeIds, CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除企业基本信息变更
	 * @param example
	 * @param companyBasicChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int deleteExampleData(Example example, CompanyBasicChange companyBasicChange);

	/**
	 * @Title:
	 * @Description: 查询全部企业基本信息变更
	 * @return List<CompanyBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	List<CompanyBasicChange> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个企业基本信息变更
	 * @param example
	 * @return CompanyBasicChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	CompanyBasicChange selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询企业基本信息变更
	 * @param example
	 * @return List<CompanyBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	List<CompanyBasicChange> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过companyChangeId查询企业基本信息变更
	 * @param companyChangeId
	 * @return CompanyBasicChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	CompanyBasicChange selectByPrimaryKey(Object companyChangeId);

	/**
	 * @Title:
	 * @Description: 分页查询企业基本信息变更
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CompanyBasicChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	PageInfoExtend<CompanyBasicChange> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询企业基本信息变更vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改企业基本信息变更
	 * @param companyBasicChange,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeyData(CompanyBasicChange companyBasicChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改企业基本信息变更,并进行排他
	 * @param companyBasicChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeyDataList(List<CompanyBasicChange> companyBasicChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改企业基本信息变更,并进行排他
	 * @param companyBasicChange
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(CompanyBasicChange companyBasicChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业基本信息变更,并进行排他
	 * @param companyBasicChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<CompanyBasicChange> companyBasicChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业基本信息变更,并进行排他
	 * @param companyBasicChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByExampleData(CompanyBasicChange companyBasicChange, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业基本信息变更,并进行排他
	 * @param companyBasicChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:35
	 */
	int updateByExampleSelectiveData(CompanyBasicChange companyBasicChange, Example example, boolean exclusive);

}
