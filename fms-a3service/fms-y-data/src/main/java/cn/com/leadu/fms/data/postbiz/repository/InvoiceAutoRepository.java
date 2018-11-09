package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoRepository
 * @Description: 自动开票信息Repository层
 */
public interface InvoiceAutoRepository {

	/**
	 * @Title:
	 * @Description: 新增自动开票信息
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int insertData(InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 批量保存自动开票信息
	 * @param invoiceAutos
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int insertDataList(List<InvoiceAuto> invoiceAutos);

	/**
	 * @Title:
	 * @Description: 修改自动开票信息
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeyData(InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 批量修改自动开票信息
	 * @param invoiceAutos
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeyDataList(List<InvoiceAuto> invoiceAutos);

	/**
	 * @Title:
	 * @Description: 动态修改自动开票信息
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeySelectiveData(InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 批量动态修改自动开票信息
	 * @param invoiceAutos
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceAuto> invoiceAutos);

	/**
	 * @Title:
	 * @Description: 根据条件修改自动开票信息
	 * @param invoiceAuto
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByExampleData(InvoiceAuto invoiceAuto, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改自动开票信息
	 * @param invoiceAuto
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByExampleSelectiveData(InvoiceAuto invoiceAuto, Example example);

	/**
	 * @Title:
	 * @Description: 根据invoiceAutoId删除自动开票信息
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int deleteData(InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 根据invoiceAutoId集合批量删除自动开票信息
	 * @param invoiceAutoIds
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int deleteDataList(List invoiceAutoIds,InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除自动开票信息
	 * @param example
	 * @param invoiceAuto
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int deleteExampleData(Example example,InvoiceAuto invoiceAuto);

	/**
	 * @Title:
	 * @Description: 查询全部自动开票信息
	 * @return List<InvoiceAuto>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	List<InvoiceAuto> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个自动开票信息
	 * @param example
	 * @return InvoiceAuto
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	InvoiceAuto selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询自动开票信息
	 * @param example
	 * @return List<InvoiceAuto>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	List<InvoiceAuto> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过invoiceAutoId查询自动开票信息
	 * @param invoiceAutoId
	 * @return InvoiceAuto
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	InvoiceAuto selectByPrimaryKey(Object invoiceAutoId);

	/**
	 * @Title:
	 * @Description: 分页查询自动开票信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<InvoiceAuto>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	PageInfoExtend<InvoiceAuto> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询自动开票信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改自动开票信息
	 * @param invoiceAuto,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeyData(InvoiceAuto invoiceAuto,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改自动开票信息,并进行排他
	 * @param invoiceAutos
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeyDataList(List<InvoiceAuto> invoiceAutos,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改自动开票信息,并进行排他
	 * @param invoiceAuto
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(InvoiceAuto invoiceAuto,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改自动开票信息,并进行排他
	 * @param invoiceAutos
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceAuto> invoiceAutos,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改自动开票信息,并进行排他
	 * @param invoiceAuto
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByExampleData(InvoiceAuto invoiceAuto, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改自动开票信息,并进行排他
	 * @param invoiceAuto
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-9-10 16:04:19
	 */
	int updateByExampleSelectiveData(InvoiceAuto invoiceAuto, Example example,boolean exclusive);

}
