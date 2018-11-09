package cn.com.leadu.fms.data.insurance.repository;

import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RenewalRegisterRepository
 * @Description: 续保任务登记Repository层
 * @date 2018-05-17
 */
public interface RenewalRegisterRepository {

	/**
	 * @Title:
	 * @Description: 新增续保任务登记
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int insertData(RenewalRegister renewalRegister);

	/**
	 * @Title:
	 * @Description: 批量保存续保任务登记
	 * @param renewalRegisters
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int insertDataList(List<RenewalRegister> renewalRegisters);

	/**
	 * @Title:
	 * @Description: 修改续保任务登记
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByPrimaryKeyData(RenewalRegister renewalRegister);

	/**
	 * @Title:
	 * @Description: 批量修改续保任务登记
	 * @param renewalRegisters
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByPrimaryKeyDataList(List<RenewalRegister> renewalRegisters);

	/**
	 * @Title:
	 * @Description: 动态修改续保任务登记
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByPrimaryKeySelectiveData(RenewalRegister renewalRegister);
	/**
	 * @Title:
	 * @Description: 动态修改续保任务登记
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByPrimaryKeySelectiveData(RenewalRegister renewalRegister, boolean exclusive);
	/**
	 * @Title:
	 * @Description: 批量动态修改续保任务登记
	 * @param renewalRegisters
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<RenewalRegister> renewalRegisters);

	/**
	 * @Title:
	 * @Description: 根据条件修改续保任务登记
	 * @param renewalRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByExampleData(RenewalRegister renewalRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改续保任务登记
	 * @param renewalRegister
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int updateByExampleSelectiveData(RenewalRegister renewalRegister, Example example);

	/**
	 * @Title:
	 * @Description: 根据renewalRegisterId删除续保任务登记
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int deleteData(RenewalRegister renewalRegister);

	/**
	 * @Title:
	 * @Description: 根据renewalRegisterId集合批量删除续保任务登记
	 * @param renewalRegisterIds
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int deleteDataList(List renewalRegisterIds, RenewalRegister renewalRegister);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除续保任务登记
	 * @param example
	 * @param renewalRegister
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	int deleteExampleData(Example example, RenewalRegister renewalRegister);

	/**
	 * @Title:
	 * @Description: 查询全部续保任务登记
	 * @return List<RenewalRegister>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	List<RenewalRegister> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个续保任务登记
	 * @param example
	 * @return RenewalRegister
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	RenewalRegister selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询续保任务登记
	 * @param example
	 * @return List<RenewalRegister>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	List<RenewalRegister> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过renewalRegisterId查询续保任务登记
	 * @param renewalRegisterId
	 * @return RenewalRegister
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	RenewalRegister selectByPrimaryKey(Object renewalRegisterId);

	/**
	 * @Title:
	 * @Description: 分页查询续保任务登记
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RenewalRegister>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	PageInfoExtend<RenewalRegister> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询续保任务登记vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 10:49:28
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 查找前三天未收到消息险信息
	 * @param  renewalRegisterVo
	 * @return RenewalRegisterVo
	 * @throws
	 * @author ningyangyang
	 * @date
	 */
	List<RenewalRegisterVo> selectRenewalRegistersPriorMonth(RenewalRegisterVo renewalRegisterVo);


	/**
	 * @Title:
	 * @Description: 查找一个月后到期的保险信息
	 * @param  renewalRegisterVo
	 * @return ContInsuranceVo
	 * @throws
	 * @author ningyangyang
	 * @date
	 */
	List<ContInsuranceVo> selectContInsuranPerMonth(RenewalRegisterVo renewalRegisterVo);

	/**
	 * @Title:
	 * @Description: 查找即将到期保险信息
	 * @param  renewalRegisterVo
	 * @return RenewalRegisterVo
	 * @throws
	 * @author ningyangyang
	 * @date
	 */
	List<RenewalRegisterVo> selectContInsurance(RenewalRegisterVo renewalRegisterVo);

}
