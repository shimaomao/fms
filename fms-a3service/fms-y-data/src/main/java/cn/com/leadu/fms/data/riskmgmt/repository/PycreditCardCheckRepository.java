package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckRepository
 * @Description: 卡核查及交易Repository层
 * @date 2018-06-14
 */
public interface PycreditCardCheckRepository {

	/**
	 * @Title:
	 * @Description: 新增卡核查及交易
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int insertData(PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 批量保存卡核查及交易
	 * @param pycreditCardChecks
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int insertDataList(List<PycreditCardCheck> pycreditCardChecks);

	/**
	 * @Title:
	 * @Description: 修改卡核查及交易
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeyData(PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 批量修改卡核查及交易
	 * @param pycreditCardChecks
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeyDataList(List<PycreditCardCheck> pycreditCardChecks);

	/**
	 * @Title:
	 * @Description: 动态修改卡核查及交易
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeySelectiveData(PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 批量动态修改卡核查及交易
	 * @param pycreditCardChecks
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCardCheck> pycreditCardChecks);

	/**
	 * @Title:
	 * @Description: 根据条件修改卡核查及交易
	 * @param pycreditCardCheck
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByExampleData(PycreditCardCheck pycreditCardCheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改卡核查及交易
	 * @param pycreditCardCheck
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByExampleSelectiveData(PycreditCardCheck pycreditCardCheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditCardCheckId删除卡核查及交易
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int deleteData(PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 根据pycreditCardCheckId集合批量删除卡核查及交易
	 * @param pycreditCardCheckIds
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int deleteDataList(List pycreditCardCheckIds,PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除卡核查及交易
	 * @param example
	 * @param pycreditCardCheck
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int deleteExampleData(Example example,PycreditCardCheck pycreditCardCheck);

	/**
	 * @Title:
	 * @Description: 查询全部卡核查及交易
	 * @return List<PycreditCardCheck>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	List<PycreditCardCheck> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个卡核查及交易
	 * @param example
	 * @return PycreditCardCheck
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PycreditCardCheck selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询卡核查及交易
	 * @param example
	 * @return List<PycreditCardCheck>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	List<PycreditCardCheck> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditCardCheckId查询卡核查及交易
	 * @param pycreditCardCheckId
	 * @return PycreditCardCheck
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PycreditCardCheck selectByPrimaryKey(Object pycreditCardCheckId);

	/**
	 * @Title:
	 * @Description: 分页查询卡核查及交易
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditCardCheck>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PageInfoExtend<PycreditCardCheck> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询卡核查及交易vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改卡核查及交易
	 * @param pycreditCardCheck,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeyData(PycreditCardCheck pycreditCardCheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改卡核查及交易,并进行排他
	 * @param pycreditCardChecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeyDataList(List<PycreditCardCheck> pycreditCardChecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改卡核查及交易,并进行排他
	 * @param pycreditCardCheck
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditCardCheck pycreditCardCheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改卡核查及交易,并进行排他
	 * @param pycreditCardChecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCardCheck> pycreditCardChecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改卡核查及交易,并进行排他
	 * @param pycreditCardCheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByExampleData(PycreditCardCheck pycreditCardCheck, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改卡核查及交易,并进行排他
	 * @param pycreditCardCheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	int updateByExampleSelectiveData(PycreditCardCheck pycreditCardCheck, Example example,boolean exclusive);

}
