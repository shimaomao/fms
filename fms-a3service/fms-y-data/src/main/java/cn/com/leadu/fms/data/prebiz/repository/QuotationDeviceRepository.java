package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceRepository
 * @Description: 报价器信息Repository层
 * @date 2018-06-02
 */
public interface QuotationDeviceRepository {

	/**
	 * @Title:
	 * @Description: 新增报价器信息
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int insertData(QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 批量保存报价器信息
	 * @param quotationDevices
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int insertDataList(List<QuotationDevice> quotationDevices);

	/**
	 * @Title:
	 * @Description: 修改报价器信息
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeyData(QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 批量修改报价器信息
	 * @param quotationDevices
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeyDataList(List<QuotationDevice> quotationDevices);

	/**
	 * @Title:
	 * @Description: 动态修改报价器信息
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeySelectiveData(QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 批量动态修改报价器信息
	 * @param quotationDevices
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<QuotationDevice> quotationDevices);

	/**
	 * @Title:
	 * @Description: 根据条件修改报价器信息
	 * @param quotationDevice
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByExampleData(QuotationDevice quotationDevice, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改报价器信息
	 * @param quotationDevice
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByExampleSelectiveData(QuotationDevice quotationDevice, Example example);

	/**
	 * @Title:
	 * @Description: 根据quotationDeviceId删除报价器信息
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int deleteData(QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 根据quotationDeviceId集合批量删除报价器信息
	 * @param quotationDeviceIds
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int deleteDataList(List quotationDeviceIds, QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除报价器信息
	 * @param example
	 * @param quotationDevice
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int deleteExampleData(Example example, QuotationDevice quotationDevice);

	/**
	 * @Title:
	 * @Description: 查询全部报价器信息
	 * @return List<QuotationDevice>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	List<QuotationDevice> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个报价器信息
	 * @param example
	 * @return QuotationDevice
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	QuotationDevice selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询报价器信息
	 * @param example
	 * @return List<QuotationDevice>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	List<QuotationDevice> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过quotationDeviceId查询报价器信息
	 * @param quotationDeviceId
	 * @return QuotationDevice
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	QuotationDevice selectByPrimaryKey(Object quotationDeviceId);

	/**
	 * @Title:
	 * @Description: 通过quotationDeviceId查询报价器信息
	 * @param quotationDeviceId
	 * @return QuotationDevice
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	QuotationDeviceVo selectQuotationDeviceByQuotationDeviceId(String quotationDeviceId);

	/**
	 * @Title:
	 * @Description: 分页查询报价器信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<QuotationDevice>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	PageInfoExtend<QuotationDevice> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询报价器信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改报价器信息
	 * @param quotationDevice,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeyData(QuotationDevice quotationDevice, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改报价器信息,并进行排他
	 * @param quotationDevices
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeyDataList(List<QuotationDevice> quotationDevices, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改报价器信息,并进行排他
	 * @param quotationDevice
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(QuotationDevice quotationDevice, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改报价器信息,并进行排他
	 * @param quotationDevices
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<QuotationDevice> quotationDevices, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改报价器信息,并进行排他
	 * @param quotationDevice
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByExampleData(QuotationDevice quotationDevice, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改报价器信息,并进行排他
	 * @param quotationDevice
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-2 18:19:52
	 */
	int updateByExampleSelectiveData(QuotationDevice quotationDevice, Example example, boolean exclusive);

}
