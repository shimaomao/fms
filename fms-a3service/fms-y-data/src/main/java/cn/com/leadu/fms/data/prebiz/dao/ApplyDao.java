package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ApprovalStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.IndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingIndustryStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RateOfPassingStatisticsVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyDao
 * @Description: 申请信息dao层
 * @date 2018-03-26
 */
public interface ApplyDao extends BaseDao<Apply> {

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
    * @Description: 分页查询申请一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/3 17:32
    */ 
    List<ApplyListVo> selectApplyListByPage(@Param("applyListVo") ApplyListVo applyListVo);


    /**
     * @Title:
     * @Description: 查询待风控初审订单
     * @param applyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/22 11:34:51
     */
    List<ApplyVo> selectDispatchApplyVosByPage(@Param("applyVo") ApplyVo applyVo);

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请订单相关的财务核算代码
     * @param:  applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    ApplyVo selectApplyVoFinassCodesByApplyNo(@Param("applyVo") ApplyVo applyVo);

    /**
     * @Title
     * @Description 根据客户证件号，获取客户最新订单的风控初审人员
     * @param certifNo 证件号码
     * @return String
     * @throws
     * @author wangxue
     * @date 2018/6/30 0030 15:52
     */
    String selectApproveUserByCertifNo(@Param("certifNo") String certifNo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectAdoptApprovalStatisticsVo(@Param("approvalStatisticsVo") ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交拒绝台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectRefuseApprovalStatisticsVo(@Param("approvalStatisticsVo") ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-13 11:38:16
     */
    List<ApprovalStatisticsVo> selectCancelApprovalStatisticsVo(@Param("approvalStatisticsVo") ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过，拒绝和取消台数
     * @param approvalStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    List<ApprovalStatisticsVo> selectAllApprovalStatisticsVo(@Param("approvalStatisticsVo") ApprovalStatisticsVo approvalStatisticsVo);

    /**
     * @Title:
     * @Description: 根据区域年月分组统计首次提交通过率
     * @param rateOfPassingStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 11:38:16
     */
    List<RateOfPassingStatisticsVo> selectRateOfPassingStatisticsVo(@Param("rateOfPassingStatisticsVo") RateOfPassingStatisticsVo rateOfPassingStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 17:29:16
     */
    List<IndustryStatisticsVo> selectAdoptIndustryStatisticsVo(@Param("industryStatisticsVo") IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交拒绝台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 17:29:16
     */
    List<IndustryStatisticsVo> selectRefuseIndustryStatisticsVo(@Param("industryStatisticsVo") IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 17:29:16
     */
    List<IndustryStatisticsVo> selectCancelIndustryStatisticsVo(@Param("industryStatisticsVo") IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过拒绝和取消台数
     * @param industryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 17:29:16
     */
    List<IndustryStatisticsVo> selectAllIndustryStatisticsVo(@Param("industryStatisticsVo") IndustryStatisticsVo industryStatisticsVo);

    /**
     * @Title:
     * @Description: 根据单位行业类别年月分组统计首次提交通过率
     * @param rateOfPassingIndustryStatisticsVo
     * @return
     * @throws
     * @date 2018-10-15 17:29:16
     */
    List<RateOfPassingIndustryStatisticsVo> selectRateOfPassingIndustryStatisticsVo(@Param("rateOfPassingIndustryStatisticsVo") RateOfPassingIndustryStatisticsVo rateOfPassingIndustryStatisticsVo);

    /**
     * @Description: 首页工作台查询本月融资额
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
    */
    BigDecimal selectFinTotal(@Param("deskSearchVo") DeskSearchVo deskSearchVo);

    /**
     * @Description: 首页工作台查询本月累计放款数
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    Long selectLoanCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);

    /**
     * @Description: 首页工作台查询当月申请订单数总量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    List<Apply> selectApplyCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);

    /**
     * @Description: 首页工作台查询当月申请车辆数
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    Long selectVehicleCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);
}