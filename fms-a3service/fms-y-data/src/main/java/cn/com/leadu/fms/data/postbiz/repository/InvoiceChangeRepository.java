package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeSearchVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeRepository
 * @Description: 开票信息变更Repository层
 * @date 2018-08-29
 */
public interface InvoiceChangeRepository {

	/**
	 * @Title:
	 * @Description: 新增开票信息变更
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int insertData(InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 批量保存开票信息变更
	 * @param invoiceChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int insertDataList(List<InvoiceChange> invoiceChanges);

	/**
	 * @Title:
	 * @Description: 修改开票信息变更
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeyData(InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 批量修改开票信息变更
	 * @param invoiceChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeyDataList(List<InvoiceChange> invoiceChanges);

	/**
	 * @Title:
	 * @Description: 动态修改开票信息变更
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeySelectiveData(InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票信息变更
	 * @param invoiceChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceChange> invoiceChanges);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票信息变更
	 * @param invoiceChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByExampleData(InvoiceChange invoiceChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票信息变更
	 * @param invoiceChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByExampleSelectiveData(InvoiceChange invoiceChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据invoiceChangeId删除开票信息变更
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int deleteData(InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 根据invoiceChangeId集合批量删除开票信息变更
	 * @param invoiceChangeIds
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int deleteDataList(List invoiceChangeIds, InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除开票信息变更
	 * @param example
	 * @param invoiceChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int deleteExampleData(Example example, InvoiceChange invoiceChange);

	/**
	 * @Title:
	 * @Description: 查询全部开票信息变更
	 * @return List<InvoiceChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	List<InvoiceChange> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个开票信息变更
	 * @param example
	 * @return InvoiceChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	InvoiceChange selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询开票信息变更
	 * @param example
	 * @return List<InvoiceChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	List<InvoiceChange> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过invoiceChangeId查询开票信息变更
	 * @param invoiceChangeId
	 * @return InvoiceChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	InvoiceChange selectByPrimaryKey(Object invoiceChangeId);

	/**
	 * @Title:
	 * @Description: 分页查询开票信息变更
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<InvoiceChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	PageInfoExtend<InvoiceChange> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询开票信息变更vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改开票信息变更
	 * @param invoiceChange,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeyData(InvoiceChange invoiceChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改开票信息变更,并进行排他
	 * @param invoiceChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeyDataList(List<InvoiceChange> invoiceChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改开票信息变更,并进行排他
	 * @param invoiceChange
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(InvoiceChange invoiceChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改开票信息变更,并进行排他
	 * @param invoiceChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByPrimaryKeySelectiveDataList(List<InvoiceChange> invoiceChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改开票信息变更,并进行排他
	 * @param invoiceChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByExampleData(InvoiceChange invoiceChange, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改开票信息变更,并进行排他
	 * @param invoiceChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-29 9:45:20
	 */
	int updateByExampleSelectiveData(InvoiceChange invoiceChange, Example example, boolean exclusive);

	/**
	 * 根据applyNo获取企业发票基本信息
	 * @param socialCertifNo
	 * @return InvoiceChangeVo
	 */
	InvoiceChangeVo selectApplyInvoiceVosBySocialCertifNo(String socialCertifNo);

	/**
	 * 根据applyNo获取企业发票基本信息
	 * @param invoiceTaskNo
	 * @return InvoiceChangeVo
	 */
	List<InvoiceChangeVo> selectInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo);

	/**
	 * 更新企业信息表
	 * @param invoiceChangeSearchVo
	 */
	void updateCstmCompany(InvoiceChangeSearchVo invoiceChangeSearchVo);

	/**
	 * 根据统一社会信用编号获取applyNo
	 * @param invoiceChangeVo
	 * @return
	 */
//	List<String> selectApplyNoListBySocialCertifNo(InvoiceChangeVo invoiceChangeVo);

}
