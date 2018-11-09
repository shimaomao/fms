package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.CstmPersonAddTelVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonRepository
 * @Description: 客户个人基本信息Repository层
 * @date 2018-03-26
 */
public interface CstmPersonRepository {

	/**
	 * @Title:
	 * @Description: 新增客户个人基本信息
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int insertData(CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 批量保存客户个人基本信息
	 * @param cstmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int insertDataList(List<CstmPerson> cstmPersons);

	/**
	 * @Title:
	 * @Description: 修改客户个人基本信息
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByPrimaryKeyData(CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 批量修改客户个人基本信息
	 * @param cstmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByPrimaryKeyDataList(List<CstmPerson> cstmPersons);

	/**
	 * @Title:
	 * @Description: 动态修改客户个人基本信息
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByPrimaryKeySelectiveData(CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户个人基本信息
	 * @param cstmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmPerson> cstmPersons);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户个人基本信息
	 * @param cstmPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByExampleData(CstmPerson cstmPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户个人基本信息
	 * @param cstmPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int updateByExampleSelectiveData(CstmPerson cstmPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据cstmPersonId删除客户个人基本信息
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int deleteData(CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 根据cstmPersonId集合批量删除客户个人基本信息
	 * @param cstmPersonIds
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int deleteDataList(List cstmPersonIds, CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户个人基本信息
	 * @param example
	 * @param cstmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	int deleteExampleData(Example example, CstmPerson cstmPerson);

	/**
	 * @Title:
	 * @Description: 查询全部客户个人基本信息
	 * @return List<CstmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	List<CstmPerson> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户个人基本信息
	 * @param example
	 * @return CstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	CstmPerson selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户个人基本信息
	 * @param example
	 * @return List<CstmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	List<CstmPerson> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过cstmPersonId查询客户个人基本信息
	 * @param cstmPersonId
	 * @return CstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	CstmPerson selectByPrimaryKey(Object cstmPersonId);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人基本信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	PageInfoExtend<CstmPerson> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人基本信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	PageInfoExtend<CstmPerson> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Description: 根据身亲编号获取客户的地址信息和电话信息
	 * @param:  applyNo 申请编号
	 * @return: CstmPersonAddTelVo
	 * @Author: wangxue
	 * @Date: 2018/9/4 17:32
	 */
	CstmPersonAddTelVo selectCstmPersonAddTelVoByApplyNo(String applyNo);

}
