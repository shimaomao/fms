package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterRepository
 * @Description: 诉讼登记信息Repository层
 */
public interface LawsuitRegisterRepository {

	/**
	 * @Title:
	 * @Description: 新增诉讼登记信息
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int insertData(LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 批量保存诉讼登记信息
	 * @param lawsuitRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int insertDataList(List<LawsuitRegister> lawsuitRegisters);

	/**
	 * @Title:
	 * @Description: 修改诉讼登记信息
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeyData(LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 批量修改诉讼登记信息
	 * @param lawsuitRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeyDataList(List<LawsuitRegister> lawsuitRegisters);

	/**
	 * @Title:
	 * @Description: 动态修改诉讼登记信息
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeySelectiveData(LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 批量动态修改诉讼登记信息
	 * @param lawsuitRegisters
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<LawsuitRegister> lawsuitRegisters);

	/**
	 * @Title:
	 * @Description: 根据条件修改诉讼登记信息
	 * @param lawsuitRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByExampleData(LawsuitRegister lawsuitRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改诉讼登记信息
	 * @param lawsuitRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByExampleSelectiveData(LawsuitRegister lawsuitRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据lawsuitRegisterId删除诉讼登记信息
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int deleteData(LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 根据lawsuitRegisterId集合批量删除诉讼登记信息
	 * @param lawsuitRegisterIds
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int deleteDataList(List lawsuitRegisterIds, LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除诉讼登记信息
	 * @param example
	 * @param lawsuitRegister
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int deleteExampleData(Example example, LawsuitRegister lawsuitRegister);

	/**
	 * @Title:
	 * @Description: 查询全部诉讼登记信息
	 * @return List<LawsuitRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	List<LawsuitRegister> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个诉讼登记信息
	 * @param example
	 * @return LawsuitRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	LawsuitRegister selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询诉讼登记信息
	 * @param example
	 * @return List<LawsuitRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	List<LawsuitRegister> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过lawsuitRegisterId查询诉讼登记信息
	 * @param lawsuitRegisterId
	 * @return LawsuitRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	LawsuitRegister selectByPrimaryKey(Object lawsuitRegisterId);

	/**
	 * @Title:
	 * @Description: 分页查询诉讼登记信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<LawsuitRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	PageInfoExtend<LawsuitRegister> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询诉讼登记信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改诉讼登记信息
	 * @param lawsuitRegister,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeyData(LawsuitRegister lawsuitRegister, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改诉讼登记信息,并进行排他
	 * @param lawsuitRegisters
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeyDataList(List<LawsuitRegister> lawsuitRegisters, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改诉讼登记信息,并进行排他
	 * @param lawsuitRegister
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(LawsuitRegister lawsuitRegister, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改诉讼登记信息,并进行排他
	 * @param lawsuitRegisters
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<LawsuitRegister> lawsuitRegisters, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改诉讼登记信息,并进行排他
	 * @param lawsuitRegister
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByExampleData(LawsuitRegister lawsuitRegister, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改诉讼登记信息,并进行排他
	 * @param lawsuitRegister
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	int updateByExampleSelectiveData(LawsuitRegister lawsuitRegister, Example example, boolean exclusive);

}
