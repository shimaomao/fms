package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import lombok.Data;

/**
 * Created by leadu on 2018/10/15.
 */@Data
public class RateOfPassingStatisticsVo {
    /**
     * @Fields  : 区域
     * @author group_district
     */
    private String groupDistrict;

    /**
     * @Fields  : 首次申请日期
     */
    private String applytSerachDate;

    /**
     * @Fields  : 首次提交通过，拒绝和取消总申请台数
     */
    private String numberOftables;

    /**
     * @Fields  : 首次提交通过申请台数
     */
    private String adoptnumberOftables;

    /**
     * @Fields  : 首次提交通过率
     */
    private String rateOfPassing;

    /**
     * @Fields  : 月份
     */
    private String effectivedateMonth;

    /**
     * @Fields  : 首次申请日期 (年份查询)
     */
    private String yearInquiries;
}
