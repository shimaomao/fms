package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyRepository
 * @Description: 客户企业基本信息Repository层
 * @date 2018-03-27
 */
public interface CstmCompanyRepository {

	/**
	 * @Title:
	 * @Description: 新增客户企业基本信息
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int insertData(CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 批量保存客户企业基本信息
	 * @param cstmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int insertDataList(List<CstmCompany> cstmCompanys);

	/**
	 * @Title:
	 * @Description: 修改客户企业基本信息
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByPrimaryKeyData(CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 批量修改客户企业基本信息
	 * @param cstmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByPrimaryKeyDataList(List<CstmCompany> cstmCompanys);

	/**
	 * @Title:
	 * @Description: 动态修改客户企业基本信息
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByPrimaryKeySelectiveData(CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户企业基本信息
	 * @param cstmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmCompany> cstmCompanys);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户企业基本信息
	 * @param cstmCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByExampleData(CstmCompany cstmCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户企业基本信息
	 * @param cstmCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int updateByExampleSelectiveData(CstmCompany cstmCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据cstmCompanyId删除客户企业基本信息
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int deleteData(CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 根据cstmCompanyId集合批量删除客户企业基本信息
	 * @param cstmCompanyIds
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int deleteDataList(List cstmCompanyIds, CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户企业基本信息
	 * @param example
	 * @param cstmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	int deleteExampleData(Example example, CstmCompany cstmCompany);

	/**
	 * @Title:
	 * @Description: 查询全部客户企业基本信息
	 * @return List<CstmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	List<CstmCompany> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户企业基本信息
	 * @param example
	 * @return CstmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	CstmCompany selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户企业基本信息
	 * @param example
	 * @return List<CstmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	List<CstmCompany> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过cstmCompanyId查询客户企业基本信息
	 * @param cstmCompanyId
	 * @return CstmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	CstmCompany selectByPrimaryKey(Object cstmCompanyId);

	/**
	 * @Title:
	 * @Description: 分页查询客户企业基本信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	PageInfoExtend<CstmCompany> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户企业基本信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	PageInfoExtend<CstmCompany> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
