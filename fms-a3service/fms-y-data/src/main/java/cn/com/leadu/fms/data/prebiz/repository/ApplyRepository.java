package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ApprovalStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.IndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingIndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingStatisticsVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyRepository
 * @Description: 申请信息Repository层
 * @date 2018-03-26
 */
public interface ApplyRepository {

	/**
	 * @Title:
	 * @Description: 新增申请信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int insertData(Apply apply);

	/**
	 * @Title:
	 * @Description: 批量保存申请信息
	 * @param applys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int insertDataList(List<Apply> applys);

	/**
	 * @Title:
	 * @Description: 修改申请信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByPrimaryKeyData(Apply apply);

	/**
	 * @Title:
	 * @Description: 批量修改申请信息
	 * @param applys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByPrimaryKeyDataList(List<Apply> applys);

	/**
	 * @Title:
	 * @Description: 动态修改申请信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByPrimaryKeySelectiveData(Apply apply);

	/**
	 * @Title:
	 * @Description: 批量动态修改申请信息
	 * @param applys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<Apply> applys);

	/**
	 * @Title:
	 * @Description: 根据条件修改申请信息
	 * @param apply
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByExampleData(Apply apply, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改申请信息
	 * @param apply
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByExampleSelectiveData(Apply apply, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改申请信息
	 * @param apply
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int updateByExampleSelectiveData(Apply apply, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据applyId删除申请信息
	 * @param apply
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int deleteData(Apply apply);

	/**
	 * @Title:
	 * @Description: 根据applyId集合批量删除申请信息
	 * @param applyIds
	 * @param apply
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	int deleteDataList(List applyIds, Apply apply);

	/**
	 * @Title:
	 * @Description: 查询全部申请信息
	 * @return List<Apply>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	List<Apply> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个申请信息
	 * @param example
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	Apply selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询申请信息
	 * @param example
	 * @return List<Apply>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	List<Apply> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyId查询申请信息
	 * @param applyId
	 * @return Apply
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	Apply selectByPrimaryKey(Object applyId);

	/**
	 * @Title:
	 * @Description: 分页查询申请信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<Apply>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	PageInfoExtend<Apply> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询申请信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<Apply>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 10:14:21
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:  根据订单提出账号(apply_user)获取申请信息
	 * @param applyUser
	 * @return Apply
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 10:14:22
	 */
	ApplyVo selectApplyVoByApplyUser(String applyUser);

	/**
	 * @Title:
	 * @Description: 根据申请编号,查询申请订单相关的财务核算代码
	 * @param:  applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:52
	 */
	ApplyVo selectApplyVoFinassCodesByApplyNo(ApplyVo applyVo);

	/**
	 * @Title
	 * @Description 根据客户证件号，获取客户最新订单的风控初审人员
	 * @param certifNo 证件号码
	 * @return String
	 * @throws
	 * @author wangxue
	 * @date 2018/6/30 0030 15:52
	 */
	String selectApproveUserByCertifNo(String certifNo);

	/**
	 * @Title:
	 * @Description: 根据区域年月分组统计首次提交通过台数
	 * @param approvalStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-13 11:38:16
	 */
	List<ApprovalStatisticsVo> selectAdoptApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据区域年月分组统计首次提交拒绝台数
	 * @param approvalStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-13 11:38:16
	 */
	List<ApprovalStatisticsVo> selectRefuseApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据区域年月分组统计首次提交取消台数
	 * @param approvalStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-13 11:38:16
	 */
	List<ApprovalStatisticsVo> selectCancelApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据区域年月分组统计首次提交通过，拒绝和取消台数
	 * @param approvalStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 11:38:16
	 */
	List<ApprovalStatisticsVo> selectAllApprovalStatisticsVo(ApprovalStatisticsVo approvalStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据区域年月分组统计首次提交通过率
	 * @param rateOfPassingStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 11:38:16
	 */
	List<RateOfPassingStatisticsVo> selectAllApprovalStatisticsVo(RateOfPassingStatisticsVo rateOfPassingStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据单位行业类别年月分组统计首次提交通过台数
	 * @param industryStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 18:38:16
	 */
	List<IndustryStatisticsVo> selectAdoptIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据单位行业类别年月分组统计首次提交拒绝台数
	 * @param industryStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 18:38:16
	 */
	List<IndustryStatisticsVo> selectRefuseIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据单位行业类别年月分组统计首次提交取消台数
	 * @param industryStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 18:38:16
	 */
	List<IndustryStatisticsVo> selectCancelIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据单位行业类别年月分组统计首次提交取消台数
	 * @param industryStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 18:38:16
	 */
	List<IndustryStatisticsVo> selectAllIndustryStatisticsVo(IndustryStatisticsVo industryStatisticsVo);

	/**
	 * @Title:
	 * @Description: 根据单位行业类别年月分组统计首次提交通过率
	 * @param rateOfPassingIndustryStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-15 18:38:16
	 */
	List<RateOfPassingIndustryStatisticsVo> selectrateOfPassingStatisticsVo(RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo);

	/**
	 * @Title:
	 * @Description: 首页工作台查询本月融资额
	 * @param deskSearchVo
	 * @return
	 * @throws
	 */
	BigDecimal selectFinTotal(DeskSearchVo deskSearchVo);

	/**
	 * @Title:
	 * @Description: 首页工作台查询本月累计放款数
	 * @param deskSearchVo
	 * @return
	 * @throws
	 */
	Long selectLoanCount(DeskSearchVo deskSearchVo);

	/**
	 * @Title:
	 * @Description: 首页工作台查询当月申请订单数总量
	 * @param deskSearchVo
	 * @return
	 * @throws
	 */
	List<Apply> selectApplyCount(DeskSearchVo deskSearchVo);

	/**
	 * @Title:
	 * @Description: 首页工作台查询当月申请车辆数
	 * @param deskSearchVo
	 * @return
	 * @throws
	 */
	Long selectVehicleCount(DeskSearchVo deskSearchVo);
}
