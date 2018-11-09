package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContBaseInfoVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同信息业务层
 * @date 2018-03-23
 */
public interface ContractService {

	/**
	 * @Title:
	 * @Description: 分页查询合同信息
	 * @param contractVo
	 * @return PageInfoExtend<Contract>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	PageInfoExtend<Contract> findContractsByPage(ContractVo contractVo);

	/** 
	* @Description: 分页查询合同一览信息
	* @Param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/4/27 17:04
	*/ 
	PageInfoExtend<ContractListVo> findContractListByPage(ContractListVo contractListVo, SysUserVo sysUser);

	/**
	 * @Description: 当月新增放款车辆明细查询合同一览信息
	 * @Param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/4/27 17:04
	 */
	PageInfoExtend<ContractListVo> findNewLoanByPage(ContractListVo contractListVo, SysUserVo sysUser);

	/**
	 * @Description: 当月新增放款车辆明细导出
	 * @Param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/4/27 17:04
	 */
	PageInfoExtend<ContractListVo> findNewLoanExport(ContractListVo contractListVo, SysUserVo sysUser);

	/**
	* @Description: 合同一览信息选择
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/9/28 16:56
	*/
	PageInfoExtend<ContractListVo> findContractSelectListByPage(ContractListVo contractListVo, SysUserVo sysUser);

	/**
	 * @Title:
	 * @Description:  根据contractId获取合同信息
	 * @param contractId
	 * @return Contract
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	Contract findContractByContractId(String contractId);

	/**
	 * @Title:
	 * @Description:  根据contNo获取合同详情顶部信息
	 * @param contNo
	 * @return ApplyBaseInfoVo
	 * @throws
	 * @author huzongcheng
	 */
	ContBaseInfoVo findContBaseInfo(String contNo);

	/**
	 * @Title:
	 * @Description:  根据contractId获取合同信息
	 * @param contNo
	 * @return Contract
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	Contract findContractByContractNo(String contNo);

	/**
	 * @Title:
	 * @Description:  根据contractId获取合同信息
	 * @param contNo
	 * @return Contract
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	ContractVo findContractVoByContractNo(String contNo);

	/**
	 * @Title:
	 * @Description:  根据contNo查询详情
	 * @param contNo
	 * @return Contract
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-23 18:48:00
	 */
	ContCreateVo findContCreateDetailByContNo(String contNo);

	/**
	 * @Title:
	 * @Description:  批量插入合同信息
	 * @param contracts
	 * @return insert
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	int insertContracts(List<Contract> contracts);

	/**
	 * @Title:
	 * @Description:  根据合同号修改
	 * @param contract
	 * @return insert
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	int updateContractByContractId(Contract contract, String contractId);
	/**
	 * @Title:
	 * @Description:  根据contractId更新申请信息状态
	 * @param contractId
	 * @param bizStatus
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:22
	 */
	int updateContBizStsByContractId(String contractId, String bizStatus);

	/**
	 * @Title:
	 * @Description: 根据合同状态集合获取订单信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public List<Contract> findContractsBybizStatusList(List<String> bizStatusList);


	/**
	 * @Title:
	 * @Description:  根据状态查找合同
	 * @param contract
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	 List<Contract> findContractsByContractStatus(Contract contract);
	
	/** 
	* @Description: 根据applyNo查询所有合同
	* @param:  
	* @return:
	* @Author: yangyiquan
	* @Date: 2018/6/15 13:44
	*/ 
	 List<Contract> findContractsByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 根据申请编号,查询申请合同相关的财务核算代码
	 * @param:  contractVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:52
	 */
	ContractVo findContractVoFinassCodes(String applyNo,String contNo);

	/** 
	* @Description: 根据合同号更新
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/4 10:09
	*/ 
	int updateContractByContNo(Contract contract, String contNo);

	/**
	 * @Description: 验证车架号是否存在，存在返回true
	 * @param: [contNo, vinNo]
	 * @return: boolean
	 * @Author: yangyiquan
	 * @Date: 2018/7/14 20:42
	 */
	boolean validVinNo(String contNo, String vinNo);

}
