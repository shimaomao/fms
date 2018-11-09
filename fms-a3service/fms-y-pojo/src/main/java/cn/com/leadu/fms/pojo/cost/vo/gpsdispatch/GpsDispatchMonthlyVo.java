package cn.com.leadu.fms.pojo.cost.vo.gpsdispatch;/**
 * Created by yyq on 2018/5/28.
 */

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.star.util.DateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: fms
 * @description: gps月结Vo
 * @author: yangyiquan
 * @create: 2018-05-28 14:48
 **/
@Data
public class GpsDispatchMonthlyVo extends PageQuery<GpsDispatch> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 派单信息id
     * @author yangyiquan
     */
    private String dispatchId;

    /**
     * @Fields  : 派单信息id
     * @author yangyiquan
     */
    private List<String> dispatchIds;

    /**
     * @Fields  : 合同编号
     * @author yangyiquan
     */
    private String contNo;

    /**
     * @Fields  : 出租人
     * @author yangyiquan
     */
    private String rentPerson;

    /**
     * @Fields  : 承租人
     * @author yangyiquan
     */
    private String lessee;

    /**
     * @Fields  : 车架号
     * @author yangyiquan
     */
    private String vinNo;

    /**
     * @Fields  : gps月结任务号
     * @author yangyiquan
     */
    private String monthlySettlementNo;

    /**
     * @Fields  : 当前节点用户
     * @author yangyiquan
     */
    private String presentUser;

    /**
     * @Fields  : 账单设备费用
     * @author yangyiquan
     */
    private BigDecimal equipmentCost;

    /**
     * @Fields  : 账单安装费用
     * @author yangyiquan
     */
    private BigDecimal installationCost;

    /**
     * @Fields  : 账单拆改费
     * @author yangyiquan
     */
    private BigDecimal changeCost;

    /**
     * @Fields  : 账单费用合计
     * @author yangyiquan
     */
    private BigDecimal billTotalCost;

    /**
     * @Fields  : 派单费用合计
     * @author yangyiquan
     */
    private BigDecimal totalCost;

    /**
     * @Fields  : 备注
     * @author yangyiquan
     */
    private String memo;

    /**
     * @Fields  : 月结状态
     * @author yangyiquan
     */
    private String monthlySts;

    /**
     * @Fields  : 个人标志
     */
    private String personFlag;

    /**
     * @Fields  : 账单月
     * @author ningyangyang
     */
    private String billMonth;

    /**
     * @Fields  : 附件信息
     * @author yanfengbo
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  :出租人区域
     */
    private String groupDistrict;

    /**
     * @Fields  : gps厂商
     * @author yanfengbo
     */
    private String gpsSeller;

    /**
     * @Fields  : 盗抢险投保渠道
     * @author yanfengbo
     */
    private String theftInsuranceType;

    /**
     * @Fields  : 预计安装时间
     * @author yanfengbo
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date expectInstallDate;


    /**
     * @Fields  : 搜索用预计安装起始时间
     * @author yanfengbo
     */
    private String expectInstallStartDateStr;

    /**
     * @Fields  : 搜索用预计安装结束时间
     * @author yanfengbo
     */
    private String expectInstallEndDateStr;

}
