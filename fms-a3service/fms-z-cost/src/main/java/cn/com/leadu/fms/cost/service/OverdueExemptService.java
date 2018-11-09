package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptDeleteListVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptDeleteVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptModifyVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptService
 * @Description: 罚息免除任务表业务层
 * @date 2018-05-30
 */
public interface OverdueExemptService {

	/**
	 * @Title:
	 * @Description: 分页查询罚息免除任务表
	 * @param overdueExemptVo
	 * @return PageInfoExtend<OverdueExempt>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	PageInfoExtend<OverdueExemptVo> findOverdueExemptsByPage(OverdueExemptVo overdueExemptVo);

	/**
	 * @Title:
	 * @Description: 保存罚息免除任务表
	 * @param overdueExemptSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
    void saveOverdueExempt(OverdueExemptSaveVo overdueExemptSaveVo);


	/**
	 * @Title:
	 * @Description: 修改罚息免除任务表
	 * @param overdueExemptModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	void modifyOverdueExempt(OverdueExemptModifyVo overdueExemptModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueExemptId删除罚息免除任务表
	 * @param overdueExemptDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	void deleteOverdueExempt(OverdueExemptDeleteVo overdueExemptDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueExemptId集合删除罚息免除任务表
	 * @param overdueExemptDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	void deleteOverdueExemptsByOverdueExemptIds(OverdueExemptDeleteListVo overdueExemptDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据overdueExemptId获取罚息免除任务表
	 * @param overdueExemptId
	 * @return OverdueExempt
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	OverdueExempt findOverdueExemptByOverdueExemptId(String overdueExemptId);

	/**
	 * @Title:
	 * @Description: 取得罚息免除一览
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	PageInfoExtend<ContOverdueVo> findContOverdueVosByPage(ContOverdueVo contOverdueVo);
	/**
	 * @Title:
	 * @Description:  根据contNo获取逾期罚息信息和合同信息(初次提交页面回显)
	 * @param contNo
	 * @return OverdueCont
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	OverdueExemptVo findDetailBycontNo(String contNo);

	/**
	 * @param
	 * @return
	 * @throws
	 * @Title:
	 * @Description: 根据serviced获取逾期合同信息和逾期罚息信息(退回)(二次提交页面回显)
	 * @author yanfengbo
	 * @date
	 */
	public OverdueExemptVo findDetailByServiceId(String servicedId);

	/**
	 * @Title:
	 * @Description: 根据serviceId获取审批详情
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
//	OverdueExemptVo findDetailByServiceId(String serviceId);

	/**
	 * @Title:
	 * @Description: 罚息免除
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public void entryOverdueCont(OverdueExemptVo overdueExemptVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 罚息免除审核通过
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public void approval(OverdueExemptVo overdueExemptVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 罚息免除审核退回
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public void sendBack(OverdueExemptVo overdueExemptVo,SysUser sysUser);

}
