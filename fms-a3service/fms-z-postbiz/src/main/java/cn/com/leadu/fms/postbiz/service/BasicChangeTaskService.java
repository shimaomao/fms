package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.*;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskService
 * @Description: 基本信息变更任务业务层
 * @date 2018-08-31
 */
public interface BasicChangeTaskService {

	/**
	 * @Description: 分页查询合同一览信息
	 * @Param:
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/4/27 17:04
	 */
	PageInfoExtend<ContractListVo> findContractListByPage(ValidContractChangeVo validContractChangeVo, SysUserVo sysUser);

	/**
	 * @Description: 生效合同变更查询
	 * @Param:
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/4/27 17:04
	 */
	PageInfoExtend<BasicChangeTaskVo> findBasicChangeTaskListByPage(BasicChangeTaskVo basicChangeTaskVo, SysUserVo sysUser);

	/**
	 * @Description: check该客户是否存在未结束的基本信息变更任务
	 * @Param: applyNo
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/4/27 17:04
	 */
	void checkBasicChangeTask(String applyNo);

	/**
	 * @Description: check该任务能被取消
	 * @Param: basicTaskNo
	 * @Param: sysUser
	 * @return:
	 * @Author: lijunjun
	 * @Date: 2018/4/27 17:04
	 */
	void isTaskCanBeCancel(String basicTaskNo, SysUserVo sysUser);

	/**
	 * 基本信息变更取消
	 * @param basicChangeTaskCancelVo
	 * @param sysUser
	 */
	void basicChangeTaskCancel(BasicChangeTaskCancelVo basicChangeTaskCancelVo, SysUserVo sysUser);

	/**
	 * @Title:
	 * @Description: 分页查询指定申请编号的企业基本信息变更历史任务
	 * @param vo 参数
	 * @return PageInfoExtend<BasicChangeCompHistoryVo>
	 * @throws
	 * @author huzongcheng
	 */
	PageInfoExtend<BasicChangeCompHistoryVo> findBasicCompChangeHistory(BasicChangeCompHistoryVo vo);

	/**
	 * @Title:
	 * @Description: 分页查询指定申请编号的个人基本信息变更历史任务
	 * @param vo 参数
	 * @return PageInfoExtend<BasicChangePersHistoryVo>
	 * @throws
	 * @author huzongcheng
	 */
	PageInfoExtend<BasicChangePersHistoryVo> findBasicPersChangeHistory(BasicChangePersHistoryVo vo);

	/**
	 * 获取展期、增加保证金、变更承租人变更任务号
	 * @param contNo 合同号
	 * @return
	 */
	ChangeInfoVo findChangeInfo(String contNo);

	/**
	 * 获取基本信息变更取消内容
	 * @param basicTaskNo 变更任务号
	 * @param sysUser
	 * @return
	 */
	BasicChangeTaskCancelVo findBasicChangeCancelVo(String basicTaskNo, SysUserVo sysUser);

}
