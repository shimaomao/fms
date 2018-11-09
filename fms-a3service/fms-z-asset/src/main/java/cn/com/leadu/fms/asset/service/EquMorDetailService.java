package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.asset.validator.equmordetail.vo.EquMorDetailSaveVo;
import cn.com.leadu.fms.asset.validator.equmordetail.vo.EquMorDetailsInfoReviewVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailService
 * @Description: 资方抵押明细业务层
 * @date 2018-05-30
 */
public interface EquMorDetailService {

	/**
	 * @Title:
	 * @Description: 查询资方抵押明细(申请)
	 * @param equMorDetailVo
	 * @return PageInfoExtend<EquMorDetail>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:06
	 */
	List<EquMorDetailVo> findEquMorDetailVos(EquMorDetailVo equMorDetailVo);

	/**
	 * @Title:
	 * @Description: 查询资方抵押明细(审核)
	 * @param equMorDetailVo
	 * @return PageInfoExtend<EquMorDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:06
	 */
	EquMorDetailVo findEquMorDetailVoList(EquMorDetailVo equMorDetailVo);

	/**
	 * @Title:
	 * @Description: 保存资方抵押明细
	 * @param equMorDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:06
	 */
    void saveEquMorDetail(EquMorDetailSaveVo equMorDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 资方抵押解除(初次提交)
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:06
	 */
	void applyEquMorDetail(EquMorDetailVo equMorDetailVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:   修改抵押详情
	 * @param equMorDetail
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 03:18:42
	 */
	void modifyEquMorDetail(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 资方抵押解除(再次提交)
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:06
	 */
	void modifyEquMorDetail(EquMorDetailVo equMorDetailVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 资方抵押明细一览
	 * @param equMorDetailVo
	 * @return PageInfoExtend<EquMorDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:06
	 */
	PageInfoExtend<EquMorDetailVo> findEquMorDetailVosByPage(EquMorDetailVo equMorDetailVo);

	/**
	 * @Title:
	 * @Description:   保存资方抵押明细
	 * @param equMorDetail
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/01 05:59:24
	 */
	void saveEquMorDetail(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description:   保存资方抵押明细集合
	 * @param equMorDetails
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/01 05:59:24
	 */
	void saveEquMorDetails(List<EquMorDetail> equMorDetails);

	/**
	 * @Title:
	 * @Description: 审核通过到制单或确认收款
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-3 17:02:06
	 */
	void approvalToVoucher(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 退回上一级
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-3 17:02:06
	 */
	void sendBack(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 制单
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-3 17:02:06
	 */
	void approvalVoucher(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 财务付款
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-3 17:02:06
	 */
	void approvalFinance(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 财务确认收款
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:05
	 */
	void approvalReceipt(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 解抵押确认
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:05
	 */
	void approvalConfirm(EquMorDetailVo equMorDetailVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description:   根据抵押任务号查找抵押明细列表
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 04:09:29
	 */
	List<EquMorDetail> findEquMorDetailsByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description:   批量更新抵押明细
	 * @param equMorDetails
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 04:50:04
	 */
	void modifyEquMorDetails(List<EquMorDetail> equMorDetails);

	/**
	 * @Title:
	 * @Description: 资方抵押资料上传
	 * @param equMorArchiveVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 05:45:39
	 */
	void equMorArchive(EquMorArchiveVo equMorArchiveVo);

	/**
	 * @Title:
	 * @Description:   资方抵押资料复核
	 * @param equMorDetailsInfoReviewVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 03:19:09
	 */
	void equMorArchiveReview(EquMorDetailsInfoReviewVo equMorDetailsInfoReviewVo);

	/**
	 * @Title:
	 * @Description:   根据抵押任务编号 查询抵押明细列表
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 11:13:30
	 */
	List<EquMorDetailVo> findEquMorDetailVosByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description:   根据抵押任务编号 查询抵押明细列表 并且带出文件详情
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 11:13:30
	 */
	List<EquMorDetailVo> findEquMorDetailVosAndFileByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description: 根据资方抵押任务获取一条抵押详情
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 02:59:10
	 */
	EquMorDetail findEquMorDetailByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description: 根据抵押任务号更新抵押状态为抵押中
	 * @param:  equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/12 0012 15:35
	 */
	void modifyEquMorStatusByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description: 根据抵押任务号更新抵押状态为取消
	 * @param:  equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/12 0012 15:35
	 */
	void modifyCancelStatusByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description: 根据抵押任务号更新抵押状态为无效
	 * @param:  equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/12 0012 15:35
	 */
	void modifyInvalidStatusByEquMorTaskNo(String equMorTaskNo);


	/**
	 * @Title:
	 * @Description: 根据抵押任务号更新抵押状态为已完成
	 * @param:  equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/17 0017 15:31
	 */
	void modifyEquMorSuccessStatusByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description: 资方解压付款单打印
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	String printEquRel(EquMorDetailVo equMorDetailVo);


	/**
	 * @Title:
	 * @Description:  资产抵押还款计划详情表插入数据
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018/06/12 10:12:45
	 */
	public  void insertEquMorRepayDetailList(String equMorTaskNo);

}
