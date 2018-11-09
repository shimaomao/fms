package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateRepository
 * @Description: 客户个人配偶信息Repository层
 * @date 2018-03-26
 */
public interface CstmPersMateRepository {

	/**
	 * @Title:
	 * @Description: 新增客户个人配偶信息
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int insertData(CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 批量保存客户个人配偶信息
	 * @param cstmPersMates
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int insertDataList(List<CstmPersMate> cstmPersMates);

	/**
	 * @Title:
	 * @Description: 修改客户个人配偶信息
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByPrimaryKeyData(CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 批量修改客户个人配偶信息
	 * @param cstmPersMates
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByPrimaryKeyDataList(List<CstmPersMate> cstmPersMates);

	/**
	 * @Title:
	 * @Description: 动态修改客户个人配偶信息
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByPrimaryKeySelectiveData(CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户个人配偶信息
	 * @param cstmPersMates
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmPersMate> cstmPersMates);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户个人配偶信息
	 * @param cstmPersMate
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByExampleData(CstmPersMate cstmPersMate, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户个人配偶信息
	 * @param cstmPersMate
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int updateByExampleSelectiveData(CstmPersMate cstmPersMate, Example example);

	/**
	 * @Title:
	 * @Description: 根据persMateId删除客户个人配偶信息
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int deleteData(CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 根据persMateId集合批量删除客户个人配偶信息
	 * @param persMateIds
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int deleteDataList(List persMateIds, CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户个人配偶信息
	 * @param example
	 * @param cstmPersMate
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	int deleteExampleData(Example example, CstmPersMate cstmPersMate);

	/**
	 * @Title:
	 * @Description: 查询全部客户个人配偶信息
	 * @return List<CstmPersMate>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	List<CstmPersMate> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户个人配偶信息
	 * @param example
	 * @return CstmPersMate
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	CstmPersMate selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户个人配偶信息
	 * @param example
	 * @return List<CstmPersMate>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	List<CstmPersMate> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过persMateId查询客户个人配偶信息
	 * @param persMateId
	 * @return CstmPersMate
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	CstmPersMate selectByPrimaryKey(Object persMateId);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人配偶信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersMate>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	PageInfoExtend<CstmPersMate> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人配偶信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersMate>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	PageInfoExtend<CstmPersMate> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
