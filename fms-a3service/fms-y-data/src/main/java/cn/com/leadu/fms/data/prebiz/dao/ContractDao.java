package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.*;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractDao
 * @Description: 合同信息dao层
 * @date 2018-03-23
 */
public interface ContractDao extends BaseDao<Contract> {

    /**
     * @Title:
     * @Description: 通过contNo查询合同信息
     * @param contNo
     * @return ContCreateVo
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:48:00
     */
     ContCreateVo selectContCreateDetailByContNo(@Param("contNo") String contNo);

    /** 
    * @Description: 分页查询合同一览信息
    * @Param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/4/27 16:26
    */
    List<ContractListVo> selectContractListByPage(@Param("contractListVo") ContractListVo contractListVo);

    /**
    * @Description: 合同一览信息选择
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/28 17:04
    */
    List<ContractListVo> selectContractSelectListByPage(@Param("contractListVo") ContractListVo contractListVo);

    /**
     * @Description: 分页查询合同一览信息
     * @Param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/27 16:26
     */
    ContractVo selectContractVoByContractNo(@Param("contNo") String contNo);

    /**
     * @Title:
     * @Description: 根据申请编号,查询申请合同相关的财务核算代码
     * @param:  applyTypePerson
     * @param:  applyNo
     * @param:  contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/6/30 0030 15:52
     */
    ContractVo selectContractVoFinassCodes(@Param("contractVo") ContractVo contractVo);

    /**
     * @Description: 自动程序更新合同结清状态
     * @param: uncleared 未结清状态
     * @param: contractEffect 合同生效清状态
     * @param: withdrawingSuccess 扣款成功状态
     * @param: automaticClearing 自动结清状态
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/13 17:27
     */
    int updateAutomaticClearing(@Param("uncleared") String uncleared,@Param("contractEffect") String contractEffect
            ,@Param("withdrawingSuccess") String withdrawingSuccess,@Param("automaticClearing") String automaticClearing);

    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @param reportStatisticsVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    List<ReportStatisticsVo> selectReportStatisticsVo(@Param("reportStatisticsVo") ReportStatisticsVo reportStatisticsVo);

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    List<BusinessStatisticsVo> selectBusinessStatisticsVo(@Param("businessStatisticsVo") BusinessStatisticsVo businessStatisticsVo);

    /**
     * @Title:
     * @Description: 查询当月提报数据统计报表明细
     * @param reportStatisticsListVo
     * @return
     * @throws
     * @date 2018-9-30 11:38:16
     */
    List<ReportStatisticsListVo> selectReportStatisticsListVo(@Param("reportStatisticsListVo") ReportStatisticsListVo reportStatisticsListVo);

    /**
     * @Title:
     * @Description: 查询融资租赁业务统计报表
     * @param regionStatisticsVo
     * @return
     * @throws
     * @date 2018-10-08 16:38:16
     */
    List<RegionStatisticsVo> selectRegionStatisticsListVo(@Param("regionStatisticsVo") RegionStatisticsVo regionStatisticsVo);

    /**
     * @Title:
     * @Description: 查询融资租赁业务品牌统计报表
     * @param brandStatisticsVo
     * @return
     * @throws
     * @date 2018-10-09 15:38:16
     */
    List<BrandStatisticsVo> selectBrandStatisticsListVo(@Param("brandStatisticsVo") BrandStatisticsVo brandStatisticsVo);

    /**
     * @Description: 首页工作台查询待请款合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    Long selectRequestCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);

    /**
     * @Description: 首页工作台查询待放款合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    Long selectLoanCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);

    /**
     * @Description: 首页工作台查询待归档合同数量
     * @param:
     * @return:
     * @Author: huzongcheng
     * @param
     */
    Long selectOriginCount(@Param("deskSearchVo") DeskSearchVo deskSearchVo);
}