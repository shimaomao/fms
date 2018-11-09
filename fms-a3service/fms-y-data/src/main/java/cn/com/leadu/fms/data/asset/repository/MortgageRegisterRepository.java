package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterRepository
 * @Description: 解抵押过户信息Repository层
 * @date 2018-05-18
 */
public interface MortgageRegisterRepository {

	/**
	 * @Title:
	 * @Description: 新增解抵押过户信息
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int insertData(MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 批量保存解抵押过户信息
	 * @param mortgageRegisters
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int insertDataList(List<MortgageRegister> mortgageRegisters);

	/**
	 * @Title:
	 * @Description: 修改解抵押过户信息
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByPrimaryKeyData(MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 批量修改解抵押过户信息
	 * @param mortgageRegisters
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByPrimaryKeyDataList(List<MortgageRegister> mortgageRegisters);

	/**
	 * @Title:
	 * @Description: 动态修改解抵押过户信息
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByPrimaryKeySelectiveData(MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 批量动态修改解抵押过户信息
	 * @param mortgageRegisters
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByPrimaryKeySelectiveDataList(List<MortgageRegister> mortgageRegisters);

	/**
	 * @Title:
	 * @Description: 根据条件修改解抵押过户信息
	 * @param mortgageRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByExampleData(MortgageRegister mortgageRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改解抵押过户信息
	 * @param mortgageRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int updateByExampleSelectiveData(MortgageRegister mortgageRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据mortgageRegisterId删除解抵押过户信息
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int deleteData(MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 根据mortgageRegisterId集合批量删除解抵押过户信息
	 * @param mortgageRegisterIds
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int deleteDataList(List mortgageRegisterIds,MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除解抵押过户信息
	 * @param example
	 * @param mortgageRegister
	 * @return int
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	int deleteExampleData(Example example,MortgageRegister mortgageRegister);

	/**
	 * @Title:
	 * @Description: 查询全部解抵押过户信息
	 * @return List<MortgageRegister>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	List<MortgageRegister> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个解抵押过户信息
	 * @param example
	 * @return MortgageRegister
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	MortgageRegister selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询解抵押过户信息
	 * @param example
	 * @return List<MortgageRegister>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	List<MortgageRegister> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过mortgageRegisterId查询解抵押过户信息
	 * @param mortgageRegisterId
	 * @return MortgageRegister
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	MortgageRegister selectByPrimaryKey(Object mortgageRegisterId);

	/**
	 * @Title:
	 * @Description: 分页查询解抵押过户信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MortgageRegister>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	PageInfoExtend<MortgageRegister> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询解抵押过户信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
