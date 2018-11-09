package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterRepository
 * @Description: 电话催收登记信息Repository层
 * @date 2018-05-17
 */
public interface OverdueTelRegisterRepository {

	/**
	 * @Title:
	 * @Description: 新增电话催收登记信息
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int insertData(OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 批量保存电话催收登记信息
	 * @param overdueTelRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int insertDataList(List<OverdueTelRegister> overdueTelRegisters);

	/**
	 * @Title:
	 * @Description: 修改电话催收登记信息
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByPrimaryKeyData(OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 批量修改电话催收登记信息
	 * @param overdueTelRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByPrimaryKeyDataList(List<OverdueTelRegister> overdueTelRegisters);

	/**
	 * @Title:
	 * @Description: 动态修改电话催收登记信息
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByPrimaryKeySelectiveData(OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 批量动态修改电话催收登记信息
	 * @param overdueTelRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueTelRegister> overdueTelRegisters);

	/**
	 * @Title:
	 * @Description: 根据条件修改电话催收登记信息
	 * @param overdueTelRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByExampleData(OverdueTelRegister overdueTelRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改电话催收登记信息
	 * @param overdueTelRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int updateByExampleSelectiveData(OverdueTelRegister overdueTelRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueTelRegisterId删除电话催收登记信息
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int deleteData(OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 根据overdueTelRegisterId集合批量删除电话催收登记信息
	 * @param overdueTelRegisterIds
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int deleteDataList(List overdueTelRegisterIds, OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除电话催收登记信息
	 * @param example
	 * @param overdueTelRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	int deleteExampleData(Example example, OverdueTelRegister overdueTelRegister);

	/**
	 * @Title:
	 * @Description: 查询全部电话催收登记信息
	 * @return List<OverdueTelRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	List<OverdueTelRegister> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个电话催收登记信息
	 * @param example
	 * @return OverdueTelRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	OverdueTelRegister selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询电话催收登记信息
	 * @param example
	 * @return List<OverdueTelRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	List<OverdueTelRegister> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueTelRegisterId查询电话催收登记信息
	 * @param overdueTelRegisterId
	 * @return OverdueTelRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	OverdueTelRegister selectByPrimaryKey(Object overdueTelRegisterId);

	/**
	 * @Title:
	 * @Description: 分页查询电话催收登记信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueTelRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	PageInfoExtend<OverdueTelRegister> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询电话催收登记信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
