package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyBaseInfoVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyService
 * @Description: 申请信息业务层
 * @date 2018-03-26
 */
public interface ApplyService {

	/**
	 * @Title:
	 * @Description: 分页查询申请信息
	 * @param applyVo
	 * @return PageInfoExtend<Apply>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	PageInfoExtend<Apply> findApplysByPage(ApplyVo applyVo);

	/** 
	* @Description: 分页查询申请一览信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/3 18:33
	*/ 
	PageInfoExtend<ApplyListVo> findApplyListByPage(ApplyListVo applyListVo,SysUserVo sysUser);

	/**
	 * @Title:
	 * @Description:  根据applyId获取申请信息
	 * @param applyId
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	Apply findApplyByApplyId(String applyId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取申请信息
	 * @param applyNo
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	Apply findApplyByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取申请详情顶部信息
	 * @param applyNo
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:22
	 */
	ApplyBaseInfoVo findApplyBaseInfo(String applyNo);

	/** 
	* @Description: 根据applyNo跟新apply
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/4 14:34
	*/ 
	int updateApplyByApplyNo(Apply apply, String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyId更新申请信息状态
	 * @param applyUpd
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:22
	 */
	 int updateApplyBizStsByApplyId(Apply applyUpd);

	/**
	 * @Title:
	 * @Description:  根据订单提出账号(apply_user)获取申请信息
	 * @param applyUser
	 * @return Apply
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 10:14:22
	 */
	 ApplyVo findApplyVoByApplyUser(String applyUser);

	/**
	 * @Title:
	 * @Description: 保存订单信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-26 10:14:22
	 */
	void saveApply(Apply apply);

	/**
	 * @Title:
	 * @Description: 修改申请信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-26 10:14:22
	 */
	void modifyApply(Apply apply);

	/**
	 * @Title:
	 * @Description: 根据订单状态获取订单信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	List<Apply> findApplysByBizStatus(String... bizStatus);


	/** 
	* @Description: 根据订单编号计算风险融资额，包括当前订单，当前订单不存在则抛异常
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/26 22:00
	*/ 
	BigDecimal riskAmountWithApply(String applyNo);

	/** 
	* @Description: 计算风险融资额，不包括当前订单
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/15 11:06
	*/ 
	BigDecimal riskAmount(String applyNo,String applyType,String certifNo);

	/**
	 * @Title:
	 * @Description:   分页查找待派单订单
	 * @param applyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/22 11:43:07
	 */
	PageInfoExtend<ApplyVo> findDispatchApplyVosByPage(ApplyVo applyVo);

	/**
	 * @Title:
	 * @Description:   派单指定
	 * @param applyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/22 02:59:29
	 */
	void dispatchApply(ApplyVo applyVo);

	/**
	 * @Title:
	 * @Description: 根据申请编号查询订单详情
	 * @param: applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 14:53
	 */
	ApplyVo findApplyVoDetailByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 取到订单申请人的证件号码
	 * @param: applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:32
	 */
	String findApplyCertifNoByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 取到订单申请人的财务辅助核算代码
	 * @param: applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:32
	 */
	String findApplyFinassCstmCodeByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 根据申请编号,查询申请订单相关的财务核算代码
	 * @param:  applyNo
	 * @param:  contNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:52
	 */
	ApplyVo findApplyVoFinassCodesByApplyNo(String applyNo,String contNo);

}