package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskService
 * @Description: 诉讼任务信息业务层
 */
public interface LawsuitTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询诉讼任务信息
	 * @param lawsuitTaskSearchVo
	 * @return PageInfoExtend<LawsuitTaskSearchVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
	PageInfoExtend<LawsuitTaskSearchVo> findLawsuitTasksByPage(LawsuitTaskSearchVo lawsuitTaskSearchVo);

	/**
	 * @Title:
	 * @Description: 根据lawsuitTaskNo获取诉讼任务信息
	 * @return LawsuitTaskSearchVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
	LawsuitTaskSearchVo findLawsuitTasksByTaskNo(String lawsuitTaskNo);

	/**
	 * @Title:
	 * @Description: 根据lawsuitTaskNo获取诉讼登记信息
	 * @return LawsuitTaskSearchVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
	LawsuitTaskSearchVo findLawsuitRegistersByTaskNo(String lawsuitTaskNo);

	/**
	 * @Title:
	 * @Description: 根据overdueContId获取诉讼基本信息
	 * @return overdueContId
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
	LawsuitTaskSearchVo findLawsuitTasksByOverdueContId(String overdueContId);

	/**
	 * @Title:
	 * @Description: 根据overdueContId获取逾期客户Id
	 * @return overdueContId
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
	String findOverdueCstmIdByOverdueContId(String overdueContId);

	/**
	 * @Title:
	 * @Description: 诉讼任务申请发起
	 * @param lawsuitTaskSearchVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void saveLawsuitTask(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 校验合同是否存在未结束的任务
	 * @param overdueContId
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void isLawsuitTaskExit(String overdueContId);

	/**
	 * @Title:
	 * @Description: 风控经理审核通过
	 * @param lawsuitTaskSearchVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void lawsuitApproval(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 退回
	 * @param lawsuitTaskSearchVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void lawsuitBack(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 拒绝
	 * @param lawsuitTaskSearchVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void lawsuitRefuse(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 诉讼任务登记暂存
	 * @param lawsuitTaskSearchVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void registerTemporary(LawsuitTaskSearchVo lawsuitTaskSearchVo);

	/**
	 * @Title:
	 * @Description: 诉讼任务登记提交
	 * @param lawsuitTaskSearchVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:47:48
	 */
    void registerSave(LawsuitTaskSearchVo lawsuitTaskSearchVo, SysUser sysUser);
}
